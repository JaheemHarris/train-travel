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
import tables.Ville;

/**
 *
 * @author HP
 */
public class VilleService {
    
    public Ville getVilleById(String idVille,DbAccess dbConnex)throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Ville villeFound = null;
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM Ville WHERE idVille=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1, idVille);
            res = stmt.executeQuery();
            while(res.next()){
                idVille = res.getString(1);
                String nomVille = res.getString(2);
                villeFound = new Ville(idVille,nomVille);
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
        return villeFound;
    }
    
    public ArrayList<Ville> listeVille(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Ville> listeVille = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Ville";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idVille=null;
            String nom=null;
            Ville temp=null;
            while(res.next()){
                idVille=res.getString(1);
                nom=res.getString(2);
                temp=new Ville(idVille,nom);
                listeVille.add(temp);
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
        return listeVille;
    }
}
