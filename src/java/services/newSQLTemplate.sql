/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  HP
 * Created: 26 juil. 2021
 */

INSERT INTO HorraireTrain VALUES ('HT001','TRN001','TRJ001','05:30','09:20');
INSERT INTO HorraireTrain VALUES ('HT002','TRN002','TRJ003','06:00','09:40');
INSERT INTO HorraireTrain VALUES ('HT003','TRN003','TRJ005','06:40','11:30');
INSERT INTO HorraireTrain VALUES ('HT004','TRN004','TRJ007','07:00','16:10');
INSERT INTO HorraireTrain VALUES ('HT005','TRN005','TRJ009','06:15','10:20');
INSERT INTO HorraireTrain VALUES ('HT006','TRN006','TRJ011','05:25','15:55');
INSERT INTO HorraireTrain VALUES ('HT007','TRN007','TRJ013','08:05','12:35');
INSERT INTO HorraireTrain VALUES ('HT008','TRN008','TRJ015','07:25','14:40');
INSERT INTO HorraireTrain VALUES ('HT009','TRN009','TRJ017','05:15','09:45');
INSERT INTO HorraireTrain VALUES ('HT010','TRN010','TRJ019','07:00','10:50');


INSERT INTO Voyage VALUES ('VG001','HT001',70);
INSERT INTO Voyage VALUES ('VG002','HT002',80);
INSERT INTO Voyage VALUES ('VG003','HT003',130);
INSERT INTO Voyage VALUES ('VG004','HT004',240);
INSERT INTO Voyage VALUES ('VG005','HT005',230);
INSERT INTO Voyage VALUES ('VG006','HT006',340);
INSERT INTO Voyage VALUES ('VG007','HT007',270);
INSERT INTO Voyage VALUES ('VG008','HT008',200);
INSERT INTO Voyage VALUES ('VG009','HT009',90);
INSERT INTO Voyage VALUES ('VG010','HT010',60);


CREATE VIEW vueVilleDepart AS SELECT Trajet.idTrajet,Trajet.idVilleDepart,Ville.nom AS villeDepart,Trajet.distance FROM Trajet JOIN Ville ON Trajet.idVilleDepart=Ville.idVille;

CREATE VIEW vueVilleDestination AS SELECT Trajet.idTrajet,Trajet.idVilleDestination,Ville.nom AS villeDestination,Trajet.distance FROM Trajet JOIN Ville ON Trajet.idVilleDestination=Ville.idVille;

CREATE VIEW itineraire AS SELECT depart.idTrajet,depart.idVilleDepart,destination.idVilleDestination,depart.villeDepart,destination.villeDestination,depart.distance FROM vueVilleDepart AS depart JOIN vueVilleDestination AS destination ON depart.idTrajet=destination.idTrajet GROUP BY depart.idTrajet;

CREATE VIEW trainCompagnie AS SELECT Train.idTrain,Train.idCompagnie,Compagnie.nomCompagnie,Train.numero,Train.nombreDePlaces FROM Train JOIN Compagnie ON Train.idCompagnie=Compagnie.idCompagnie;

CREATE VIEW HtTain AS SELECT Ht.idHorraireTrain,Ht.idTrain,tC.idCompagnie,tc.nomCompagnie,tC.numero,tC.nombreDePlaces,Ht.idTrajet,Ht.heureDepart,Ht.heureArrivee FROM HorraireTrain AS Ht JOIN trainCompagnie AS  tC ON Ht.idTrain=tC.idTrain;

CREATE VIEW horraire AS SELECT HtTn.idHorraireTrain,HtTn.idTrain,HtTn.idCompagnie,HtTn.nomCompagnie,HtTn.numero,HtTn.nombreDePlaces,HtTn.idTrajet,itn.idVilleDepart,itn.idVilleDestination,itn.villeDepart,itn.villeDestination,itn.distance,HtTn.heureDepart,HtTn.heureArrivee,TIMEDIFF(HtTn.heureArrivee,HtTn.heureDepart) AS duree FROM HtTain AS HtTn JOIN itineraire AS itn ON HtTn.idTrajet=itn.idTrajet;

CREATE VIEW allReservations AS SELECT res.idClient,hV.villeDepart,hv.villeDestination,res.dateVoyage,hv.heureDepart,hv.nomCompagnie,hv.numero,res.nombreBillet,res.dateReservation FROM Reservation as res JOIN horraireVoyage as hV ON res.idVoyage=hV.idVoyage;