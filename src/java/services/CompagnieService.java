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
import tables.Compagnie;

/**
 *
 * @author HP
 */
public class CompagnieService {
    
    public Compagnie getCompagnieById(String idCompagnie,DbAccess dbConnex)throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Compagnie compagnieFound = null;
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM Compagnie WHERE idCompagnie=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1, idCompagnie);
            res = stmt.executeQuery();
            while(res.next()){
                idCompagnie = res.getString(1);
                String nomCompagnie = res.getString(2);
                compagnieFound = new Compagnie(idCompagnie,nomCompagnie);
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
        return compagnieFound;
    }
    
    public ArrayList<Compagnie> listeCompagnie(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Compagnie> listeCompagnie = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Compagnie";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idCompagnie=null;
            String nom=null;
            Compagnie temp=null;
            while(res.next()){
                idCompagnie=res.getString(1);
                nom=res.getString(2);
                temp=new Compagnie(idCompagnie,nom);
                listeCompagnie.add(temp);
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
        return listeCompagnie;
    }
}
