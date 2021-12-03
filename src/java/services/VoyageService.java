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
import tables.Voyage;

/**
 *
 * @author HP
 */
public class VoyageService {
    public Voyage getVoyage(String idVoyage,DbAccess dbConnex)throws SQLException,Exception{
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet res=null;
        Voyage travel=null;
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Voyage WHERE idVoyage=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idVoyage);
            res=stmt.executeQuery();
            String idV=null;
            String idHorraireTrain=null;
            double prixBillet=0.0;
            while(res.next()){
                idV=res.getString(1);
                idHorraireTrain=res.getString(2);
                prixBillet=res.getDouble(3);
            }
            travel=new Voyage(idV,idHorraireTrain,prixBillet);
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
        return travel;
    }
    
    public ArrayList<Voyage> listeVoyage(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Voyage> listeVoyage = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Voyage";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idVoyage=null;
            String idHorraireTrain=null;
            double prixBillet=0.0;
            Voyage temp=null;
            while(res.next()){
                idVoyage=res.getString(1);
                idHorraireTrain=res.getString(2);
                prixBillet=res.getDouble(3);
                temp=new Voyage(idVoyage,idHorraireTrain,prixBillet);
                listeVoyage.add(temp);
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
        return listeVoyage;
    }
}
