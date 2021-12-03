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
public class Trajet {
    private String idTrajet;
    private String idVilleDepart;
    private String idVilleDestination;
    private double distance;

    public Trajet() {
    }

    public Trajet(String idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Trajet(String idTrajet, String idVilleDepart, String idVilleDestination, double distance) {
        this.idTrajet = idTrajet;
        this.idVilleDepart = idVilleDepart;
        this.idVilleDestination = idVilleDestination;
        this.distance = distance;
    }

    public String getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(String idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getIdVilleDepart() {
        return idVilleDepart;
    }

    public void setIdVilleDepart(String idVilleDepart) {
        this.idVilleDepart = idVilleDepart;
    }

    public String getIdVilleDestination() {
        return idVilleDestination;
    }

    public void setIdVilleDestination(String idVilleDestination) {
        this.idVilleDestination = idVilleDestination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public void add(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO Trajet VALUES (?,?,?,?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idTrajet);
            stmt.setObject(2,this.idVilleDepart);
            stmt.setObject(3,this.idVilleDestination);
            stmt.setObject(4,this.distance);
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
            String req = "UPDATE Trajet SET idVilleDepart=? ,idVilleDestination=? ,distance=? WHERE idTrajet=? ";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idVilleDepart);
            stmt.setObject(2,this.idVilleDestination);
            stmt.setObject(3,this.distance);
            stmt.setObject(4,this.idTrajet);
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
            String req = "DELETE FROM Trajet WHERE idTrajet=? ";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idTrajet);
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
