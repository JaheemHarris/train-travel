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
import tables.Trajet;

/**
 *
 * @author HP
 */
public class TrajetService {

public Trajet getTrajetById(String idTrajet,DbAccess dbConnex)throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Trajet trajetFound = null;
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM Trajet WHERE idTrajet=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1, idTrajet);
            res = stmt.executeQuery();
            String idVilleDepart = null;
            String idVilleDestination = null;
            double distance = 0;
            while(res.next()){
                idTrajet=res.getString(1);
                idVilleDepart = res.getString(2);
                idVilleDestination = res.getString(3);
                distance = res.getDouble(4);
                trajetFound = new Trajet(idTrajet,idVilleDepart,idVilleDestination,distance);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(res!=null){
                res.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
        return trajetFound;
    }

    public Trajet getTrajet(String idVilleDepart,String idVilleArrivee,DbAccess dbConnex) throws Exception,SQLException{
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res = null;
        Trajet path=null;
        try{
            con=dbConnex.getConnection();
            String req="SELECT * FROM Trajet WHERE idVilleDepart=% AND idVilleArrivee=%";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idVilleDepart);
            stmt.setObject(2,idVilleArrivee);
            res=stmt.executeQuery(req);
            String id = null;
            String idDepart = null;
            String idArrivee = null;
            int distance = 0;
            while(res.next()){
                id = res.getString(1);
                idDepart = res.getString(2);
                idArrivee = res.getString(3);
                distance = res.getInt(4);
            }
            path = new Trajet(id,idDepart,idArrivee,distance);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            
        }
        return path;
    }
    
    
    public ArrayList<Trajet> listeTrajet(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Trajet> listeTrajet = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Trajet";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idTrajet=null;
            String idVilleDepart=null;
            String idVilleArrivee=null;
            double distance =0.0;
            Trajet temp=null;
            while(res.next()){
                idTrajet=res.getString(1);
                idVilleDepart=res.getString(2);
                idVilleArrivee=res.getString(3);
                distance=res.getDouble(4);
                temp=new Trajet(idTrajet,idVilleDepart,idVilleArrivee,distance);
                listeTrajet.add(temp);
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
        return listeTrajet;
    }
}
