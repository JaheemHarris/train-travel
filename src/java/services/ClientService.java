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
import java.util.Date;
import java.util.Random;
import tables.Client;
import tables.Reservation;
import tables.Voyage;

/**
 *
 * @author HP
 */
public class ClientService {
 
    public Client connexionClient(String mail,String passwd,DbAccess databaseConnection) throws Exception{
        Client user = null;
        if(!"".equals(mail) && !"".equals(passwd)){
            Connection con = null;
            PreparedStatement stmt = null;
            ResultSet result=null;
            try{
                con=databaseConnection.getConnection();
                String req="SELECT * FROM Client WHERE mail=? AND motDePasse=sha1(?)";
                stmt=con.prepareStatement(req);
                stmt.setObject(1,mail);
                stmt.setObject(2,passwd);
                System.out.println(stmt);
                result= stmt.executeQuery();
                String idClient = null;
                String nom = null;
                String prenom = null;
                String email = null;
                String password = null;
                while(result.next()){
                    idClient = result.getString(1);
                    nom = result.getString(2);
                    prenom = result.getString(3);
                    email = result.getString(4);
                    password = result.getString(5);
                    user = new Client(idClient,nom,prenom,email,password);
                }
            }catch(Exception e){
                e.printStackTrace();
                throw e;
            }
            finally{
                if(stmt!=null){
                    stmt.close();
                }
                if(result!=null){
                    result.close();
                }
                databaseConnection.closeConnection();
            }
        }
        return user;
    }
    
    public void updateClient(String idClient, String nom, String prenom, String mail, String motDePasse, DbAccess dbConnex)throws Exception{
        try{
            Client user = new Client(idClient,nom,prenom,mail,motDePasse);
            user.update(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public ArrayList<Client> listeClient(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Client> listeClient = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Client";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idClient=null;
            String nom=null;
            String prenom=null;
            String mail=null;
            String motDePasse=null;
            Client temp=null;
            while(res.next()){
                idClient=res.getString(1);
                nom=res.getString(2);
                prenom=res.getString(3);
                mail=res.getString(4);
                motDePasse=res.getString(5);
                temp=new Client(idClient,nom,prenom,mail,motDePasse);
                listeClient.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(res!=null){
                res.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
        return listeClient;
    }
    
    public boolean ifReservationAlreadyExist(String idReservation,DbAccess dbConnex)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=dbConnex.getConnection();
            String req="SELECT COUNT(*) FROM Reservation WHERE idReservation=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idReservation);
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
            dbConnex.closeConnection();
        }
        return false;   
    }
    
    public void reserver(String idClient, String idVoyage, int nombreBillet,String dateVoyage, DbAccess dbConnex)throws Exception{
        try{
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idReservation="RES"+String.valueOf(idRand);
            boolean reservationExist = ifReservationAlreadyExist(idReservation,dbConnex);
            while(reservationExist){
                idRand = rand.nextInt(1000);
                idReservation="RES"+String.valueOf(idRand);
                reservationExist = ifReservationAlreadyExist(idReservation,dbConnex);
            }
            VoyageService travelServ = new VoyageService();
            Voyage travel = travelServ.getVoyage(idVoyage, dbConnex);
            double prixUnitaire=travel.getPrixBillet();
            double prixTotal=nombreBillet*prixUnitaire;
            Reservation reservation = new Reservation(idReservation, idClient, idVoyage, nombreBillet, prixTotal, dateVoyage);
            reservation.add(dbConnex);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public ArrayList<ArrayList> getMyReservations(String idClient,DbAccess dbConnex) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<ArrayList> myReservations = new ArrayList();
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM allReservations WHERE idClient=?";
            stmt = con.prepareStatement(req);
            stmt.setObject(1,idClient);
            res = stmt.executeQuery();
            ArrayList reservation = null;
            while(res.next()){
                reservation = new ArrayList();
                for(int i=1;i<10;i++){
                    reservation.add(res.getString(i));
                }
                myReservations.add(reservation);
                reservation = null;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            dbConnex.closeConnection();
        }
        return myReservations;
    }
    
    public ArrayList<ArrayList> getMyReservations(String idClient,int offset,int nbr,DbAccess dbConnex) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<ArrayList> myReservations = new ArrayList();
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM allReservations WHERE idClient=? LIMIT ?,?";
            stmt = con.prepareStatement(req);
            stmt.setObject(1,idClient);
            stmt.setObject(2,offset);
            stmt.setObject(3,nbr);
            res = stmt.executeQuery();
            ArrayList reservation = null;
            while(res.next()){
                reservation = new ArrayList();
                for(int i=1;i<10;i++){
                    reservation.add(res.getString(i));
                }
                myReservations.add(reservation);
                reservation = null;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            dbConnex.closeConnection();
        }
        return myReservations;
    }
    
    public int getNombreReservations(String idClient,DbAccess dbConnex) throws Exception{
        int nombre = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = dbConnex.getConnection();
            String req = "SELECT COUNT(*) FROM allReservations WHERE idClient=?";
            stmt = con.prepareStatement(req);
            stmt.setObject(1,idClient);
            res = stmt.executeQuery();
            if(res.next()){
               nombre = res.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            if(res!=null){
                res.close();
            }
            dbConnex.closeConnection();
        }
        return nombre;
    }
    
    public ArrayList<ArrayList> rechercheSimple(String idVilleDepart,String idVilleDestination,DbAccess dbConnex)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList retour = new ArrayList();
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM horraireVoyage WHERE idVilleDepart=? AND idVilleDestination=?";
            stmt = con.prepareStatement(req);
            stmt.setObject(1,idVilleDepart);
            stmt.setObject(2,idVilleDestination);
            res = stmt.executeQuery();
            while(res.next()){
                ArrayList resArray = new ArrayList();
                resArray.add(res.getString(1));
                resArray.add(res.getString(2));
                resArray.add(res.getString(3));
                resArray.add(res.getString(4));
                resArray.add(res.getString(5));
                resArray.add(res.getString(6));
                resArray.add(res.getInt(7));
                resArray.add(res.getString(8));
                resArray.add(res.getString(9));
                resArray.add(res.getString(10));
                resArray.add(res.getString(11));
                resArray.add(res.getString(12));
                resArray.add(res.getDouble(13));
                resArray.add(res.getString(14));
                resArray.add(res.getString(15));
                resArray.add(res.getString(16));
                resArray.add(res.getDouble(17));
                retour.add(resArray);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(res!=null){
                res.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
        return retour;
    }
    
    public ArrayList getHorraireVoyageByIdVoyage(String idVoyage,DbAccess dbConnex)throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList horraireVoyage = new ArrayList();
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM horraireVoyage WHERE idVoyage=?";
            stmt = con.prepareStatement(req);
            stmt.setObject(1,idVoyage);
            res = stmt.executeQuery();
            while(res.next()){
                horraireVoyage.add(res.getString(1));
                horraireVoyage.add(res.getString(2));
                horraireVoyage.add(res.getString(3));
                horraireVoyage.add(res.getString(4));
                horraireVoyage.add(res.getString(5));
                horraireVoyage.add(res.getString(6));
                horraireVoyage.add(res.getInt(7));
                horraireVoyage.add(res.getString(8));
                horraireVoyage.add(res.getString(9));
                horraireVoyage.add(res.getString(10));
                horraireVoyage.add(res.getString(11));
                horraireVoyage.add(res.getString(12));
                horraireVoyage.add(res.getDouble(13));
                horraireVoyage.add(res.getString(14));
                horraireVoyage.add(res.getString(15));
                horraireVoyage.add(res.getString(16));
                horraireVoyage.add(res.getDouble(17));
                break;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(res!=null){
                res.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
        return horraireVoyage;
    }
}
