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
import tables.Reservation;
import tables.Voyage;

/**
 *
 * @author HP
 */
public class ReservationService {
    
    public void reserver(String idClient,String idVoyage,int nombreBillet,String dateDepart,String dateReservation,DbAccess dbConnex)throws SQLException,Exception{
        Connection con=null;
        PreparedStatement stmt=null;
        try{
            VoyageService vgServ = new VoyageService();
            Voyage travel = vgServ.getVoyage(idVoyage, dbConnex);
            double prixTotal=nombreBillet*travel.getPrixBillet();
            con=dbConnex.getConnection();
            String req="INSERT INTO Reservation VALUES (?,?,?,?,?,?,CURDATE())";
            Random rand = new Random();
            Integer idRand = rand.nextInt(1000);
            String idReservation="RES"+String.valueOf(idRand);
            boolean reservationExist = ifReservationAlreadyExist(idReservation,dbConnex);
            while(reservationExist){
                idRand = rand.nextInt(1000);
                idReservation="RES"+String.valueOf(idRand);
                reservationExist = ifReservationAlreadyExist(idReservation,dbConnex);
            }
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idReservation);
            stmt.setObject(2,idClient);
            stmt.setObject(3,idVoyage);
            stmt.setObject(4,nombreBillet);
            stmt.setObject(5,prixTotal);
            stmt.setObject(6,dateDepart);
            stmt.executeQuery();
            con.commit();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
    }
    
    public boolean ifReservationAlreadyExist(String idReservation,DbAccess connexDb)throws Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con=connexDb.getConnection();
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
            connexDb.closeConnection();
        }
        return false;
    }
    
    public ArrayList<Reservation> mesReservations(String idClnt,DbAccess dbConnex) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Reservation> lesReservations=new ArrayList<Reservation>();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Reservation WHERE idClient=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idClnt);
            res=stmt.executeQuery();
            String idReservation=null;
            String idClient=null;
            String idVoyage=null;
            int nombreBillet=0;
            double prixTotal=0.0;
            String dateVoyage=null;
            String dateReservation=null;
            Reservation temp=null;
            while(res.next()){
                idReservation=res.getString(1);
                idClient=res.getString(2);
                idVoyage=res.getString(3);
                nombreBillet=res.getInt(4);
                prixTotal=res.getDouble(5);
                dateVoyage=res.getString(6);
                dateReservation=res.getString(7);
                temp=new Reservation(idReservation,idClient,idVoyage,nombreBillet,prixTotal,dateVoyage,dateReservation);
                lesReservations.add(temp);
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
        
        return lesReservations;
    }
    
    public ArrayList<Reservation> mesReservations(String idClnt,int offset,int nbr,DbAccess dbConnex) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Reservation> lesReservations=new ArrayList<Reservation>();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Reservation WHERE idClient=? LIMIT ?,?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idClnt);
            stmt.setObject(2,offset);
            stmt.setObject(3,nbr);
            res=stmt.executeQuery();
            String idReservation=null;
            String idClient=null;
            String idVoyage=null;
            int nombreBillet=0;
            double prixTotal=0.0;
            String dateVoyage=null;
            String dateReservation=null;
            Reservation temp=null;
            while(res.next()){
                idReservation=res.getString(1);
                idClient=res.getString(2);
                idVoyage=res.getString(3);
                nombreBillet=res.getInt(4);
                prixTotal=res.getDouble(5);
                dateVoyage=res.getString(6);
                dateReservation=res.getString(7);
                temp=new Reservation(idReservation,idClient,idVoyage,nombreBillet,prixTotal,dateVoyage,dateReservation);
                lesReservations.add(temp);
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
        
        return lesReservations;
    }
}
