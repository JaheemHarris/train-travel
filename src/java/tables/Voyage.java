/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import database.DbAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class Voyage {
    private String idVoyage;
    private String idHorraireTrain;
    private double prixBillet;

    public Voyage() {
    }

    public Voyage(String idVoyage) {
        this.idVoyage = idVoyage;
    }

    public Voyage(String idVoyage, String idHorraireTrain, double prixBillet) {
        this.idVoyage = idVoyage;
        this.idHorraireTrain = idHorraireTrain;
        this.prixBillet = prixBillet;
    }

    public String getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(String idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getIdHorraireTrain() {
        return idHorraireTrain;
    }

    public void setIdHorraireTrain(String idHorraireTrain) {
        this.idHorraireTrain = idHorraireTrain;
    }

    public double getPrixBillet() {
        return prixBillet;
    }

    public void setPrixBillet(double prixBillet) {
        this.prixBillet = prixBillet;
    }
    
    public void add(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO Voyage VALUES (?,?,?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idVoyage);
            stmt.setObject(2,this.idHorraireTrain);
            stmt.setObject(3,this.prixBillet);
            stmt.executeUpdate();
            con.commit();
        }catch(Exception e){
            con.rollback();
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
    }
    
    public void update(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "UPDATE Voyage SET idHorraireTrain=? ,prixBillet=? WHERE idVoyage=? ";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idHorraireTrain);
            stmt.setObject(2,this.prixBillet);
            stmt.setObject(3,this.idVoyage);
            stmt.executeUpdate();
            con.commit();
        }catch(Exception e){
            con.rollback();
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
    }
    
    public void delete(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "DELETE FROM Voyage WHERE idVoyage=? ";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idVoyage);
            stmt.executeUpdate();
            con.commit();
        }catch(Exception e){
            con.rollback();
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
    }
}