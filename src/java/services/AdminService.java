/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.DbAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import tables.Admin;
import tables.Compagnie;
import tables.HorraireTrain;
import tables.Train;
import tables.Trajet;
import tables.Ville;
import tables.Voyage;

/**
 *
 * @author HP
 */
public class AdminService {
    public Admin connectAdmin(String mail,String passwd,DbAccess databaseConnection) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Admin adminFound = null;
        try{
            con=databaseConnection.getConnection();
            String req;
            req = "SELECT * FROM admin WHERE login=? AND motDePasse=sha1(?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,mail);
            stmt.setObject(2,passwd);
            System.out.println(stmt);
            result=stmt.executeQuery();
            if(result.next()){
              adminFound = new Admin(result.getString(1),result.getString(2));  
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return adminFound;
    }
    
    
    
    /*<--------------------------- Ville------------------------>*/
    
    public void addVille(String nomVille,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idVille="VIL"+String.valueOf(idRand);
            boolean villeExist = ifVilleAlreadyExist(idVille,dbConnex);
            while(villeExist){
                idRand = rand.nextInt(1000);
                idVille="VIL"+String.valueOf(idRand);
                villeExist = ifVilleAlreadyExist(idVille,dbConnex);
            }
            Ville ville = new Ville(idVille,nomVille);
            ville.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void updateVille(String idVille,String nomVille,DbAccess dbConnex)throws Exception{
        try{
            Ville ville =new Ville(idVille,nomVille);
            ville.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void deleteVille(String idVille,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Ville ville = new Ville(idVille);
            ville.delete(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } 
    }
    
    public boolean ifVilleAlreadyExist(String idVille,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
            String req="SELECT COUNT(*) FROM Ville WHERE idVille=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idVille);
            res=stmt.executeQuery();
            while(res.next()){
                if(res.getInt(1)>0){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            connexDb.closeConnection();
        }
        return false;
    }
    
    /*<-------------------------------Ville------------------------------->*/
    
    
    
    
    /*<-------------------------------Trajet------------------------------------->*/
    
    public boolean ifTrajetAlreadyExist(String idTrajet,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
            String req="SELECT COUNT(*) FROM Trajet WHERE idTrajet=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idTrajet);
            res=stmt.executeQuery();
            while(res.next()){
                if(res.getInt(1)>0){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            connexDb.closeConnection();
        }
        return false;
    }
    
    public void addTrajet(String idVilleDepart,String idVilleDestination,double distance,DbAccess dbConnex) throws SQLException,Exception{
            
        try{
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idTrajet="TRJ"+String.valueOf(idRand);
            boolean trajetExist = ifTrajetAlreadyExist(idTrajet,dbConnex);
            while(trajetExist){
                idRand = rand.nextInt(1000);
                idTrajet="TRJ"+String.valueOf(idRand);
                trajetExist = ifTrajetAlreadyExist(idTrajet,dbConnex);
            }
            Trajet path = new Trajet(idTrajet,idVilleDepart,idVilleDestination,distance);
            path.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void updateTrajet(String idTrajet,String idVilleDepart,String idVilleDestination,double distance,DbAccess dbConnex) throws Exception{
        try{
            Trajet path = new Trajet(idTrajet,idVilleDepart,idVilleDestination,distance);
            path.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void deleteTrajet(String idTrajet,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Trajet path = new Trajet(idTrajet);
            path.delete(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    /*<-------------------------------Trajet------------------------------------->*/
    
    
    
    
    /*<-------------------------------HorraireTrain------------------------------------->*/
    
    public boolean ifHorraireTrainAlreadyExist(String idHorraireTrain,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
            String req="SELECT COUNT(*) FROM HorraireTrain WHERE idHorraireTrain=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idHorraireTrain);
            res=stmt.executeQuery();
            while(res.next()){
                if(res.getInt(1)>0){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            connexDb.closeConnection();
        }
        return false;
    }
    
    public void addHorraireTrain(String idTrain, String idTrajet, String heureDepart, String heureArrivee,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idHorraireTrain="HT"+String.valueOf(idRand);
            boolean horraireTrainExist = ifHorraireTrainAlreadyExist(idTrajet,dbConnex);
            while(horraireTrainExist){
                idRand = rand.nextInt(1000);
                idHorraireTrain="HT"+String.valueOf(idRand);
                horraireTrainExist = ifHorraireTrainAlreadyExist(idTrajet,dbConnex);
            }
            HorraireTrain horraire = new HorraireTrain(idHorraireTrain,idTrain,idTrajet,heureDepart,heureArrivee);
            horraire.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void updateHorraireTrain(String idHorraireTrain,String idTrain, String idTrajet, String heureDepart, String heureArrivee,DbAccess dbConnex) throws Exception{
        try{
            HorraireTrain horraire = new HorraireTrain(idHorraireTrain,idTrain,idTrajet,heureDepart,heureArrivee);
            horraire.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void deleteHorraireTrain(String idHorraireTrain,DbAccess dbConnex) throws SQLException,Exception{
        try{
            HorraireTrain horraire = new HorraireTrain(idHorraireTrain);
            horraire.delete(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    /*<-----------------------HorraireTrain---------------------------->*/
    
    
    
    
    /*<------------------------------Train------------------------------------>*/
    
    public void addTrain(String idCompagnie,String numero,int nombreDePlaces,DbAccess dbConnex) throws Exception{
        try{
            String req="INSERT INTO Train VALUES(?,?,?,?)";
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idTrain="TRN"+String.valueOf(idRand);
            boolean trainExist = ifTrainAlreadyExist(idTrain,dbConnex);
            while(trainExist){
                idRand = rand.nextInt(1000);
                idTrain="TRN"+String.valueOf(idRand);
                trainExist = ifTrainAlreadyExist(idTrain,dbConnex);
            }
            Train train = new Train(idTrain,idCompagnie,numero,nombreDePlaces);
            train.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public boolean ifTrainAlreadyExist(String idTrain,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
            String req="SELECT COUNT(*) FROM Train WHERE idTrain=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idTrain);
            res=stmt.executeQuery();
            while(res.next()){
                if(res.getInt(1)>0){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            connexDb.closeConnection();
        }
        return false;
    }
    
    public void updateTrain(String idTrain,String idCompagnie,String numero,int nombreDePlaces,DbAccess dbConnex) throws Exception{
        try{
            Train train = new Train(idTrain,idCompagnie,numero,nombreDePlaces);
            train.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void deleteTrain(String idTrain,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Train train = new Train(idTrain);
            train.delete(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    /*<----------------------Train------------------------------>*/
    
    
    
    /*<---------------------Compagnie------------------------------->*/
    
    public boolean ifCompagnieAlreadyExist(String idCompagnie,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
            String req="SELECT COUNT(*) FROM Compagnie WHERE idCompagnie=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idCompagnie);
            res=stmt.executeQuery();
            while(res.next()){
                if(res.getInt(1)>0){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            connexDb.closeConnection();
        }
        return false;
    }
    
    public void addCompagnie(String nomCompagnie,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idCompagnie="CMP"+String.valueOf(idRand);
            boolean compagnieExist = ifCompagnieAlreadyExist(idCompagnie,dbConnex);
            while(compagnieExist){
                idRand = rand.nextInt(1000);
                idCompagnie="CMP"+String.valueOf(idRand);
                compagnieExist = ifCompagnieAlreadyExist(idCompagnie,dbConnex);
            }
            Compagnie compagnie= new Compagnie(idCompagnie,nomCompagnie);
            compagnie.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void deleteCompagnie(String idCompagnie,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Compagnie compagnie = new Compagnie(idCompagnie);
            System.out.println(compagnie.getIdCompagnie());
            compagnie.delete(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void updateCompagnie(String idCompagnie,String nomCompagnie,DbAccess dbConnex) throws SQLException,Exception{
        try{
            Compagnie compagnie = new Compagnie(idCompagnie,nomCompagnie);
            compagnie.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    /*<-----------------------------Compagnie-------------------------------->*/
    
    
    /*<-------------------------------Voyage----------------------------------->*/
    
    public boolean ifVoyageAlreadyExist(String idVoyage,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
            String req="SELECT COUNT(*) FROM Voyage WHERE idVoyage=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idVoyage);
            res=stmt.executeQuery();
            while(res.next()){
                if(res.getInt(1)>0){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            connexDb.closeConnection();
        }
        return false;
    }
    
    public void addVoyage(String idHorraireTrain, double prixBillet, DbAccess dbConnex) throws Exception{
        try{
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idVoyage="VG"+String.valueOf(idRand);
            boolean voyageExist = ifVoyageAlreadyExist(idVoyage,dbConnex);
            while(voyageExist){
                idRand = rand.nextInt(1000);
                idVoyage="VG"+String.valueOf(idRand);
                voyageExist = ifVoyageAlreadyExist(idVoyage,dbConnex);
            }
            Voyage travel = new Voyage(idVoyage,idHorraireTrain,prixBillet);
            travel.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void updateVoyage(String idVoyage,String idHorraireTrain, double prixBillet, DbAccess dbConnex)throws Exception{
        try{
            Voyage travel = new Voyage(idVoyage,idHorraireTrain,prixBillet);
            travel.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void deleteVoyage(String idVoyage,DbAccess dbConnex) throws Exception{
        try{
            Voyage travel = new Voyage(idVoyage);
            travel.delete(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    /*<-------------------------------Voyage----------------------------------->*/
    
}