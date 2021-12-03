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
public class HorraireTrain {
    private String idHorraireTrain;
    private String idTrain;
    private String idTrajet;
    private String heureDepart;
    private String heureArrivee;

    public HorraireTrain() {
    }

    public HorraireTrain(String idHorraireTrain) {
        this.idHorraireTrain = idHorraireTrain;
    }

    public HorraireTrain(String idHorraireTrain, String idTrain, String idTrajet, String heureDepart, String heureArrivee) {
        this.idHorraireTrain = idHorraireTrain;
        this.idTrain = idTrain;
        this.idTrajet = idTrajet;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    public String getIdHorraireTrain() {
        return idHorraireTrain;
    }

    public void setIdHorraireTrain(String idHorraireTrain) {
        this.idHorraireTrain = idHorraireTrain;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public String getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(String idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }
    
    public void add(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO HorraireTrain VALUES (?,?,?,?,?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idHorraireTrain);
            stmt.setObject(2,this.idTrain);
            stmt.setObject(3,this.idTrajet);
            stmt.setObject(4,this.heureDepart);
            stmt.setObject(5,this.heureArrivee);
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
            String req = "UPDATE HorraireTrain SET idTrain=? ,idTrajet=? ,heureDepart=? ,heureArrivee=? WHERE idHorraireTrain=? ";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idTrain);
            stmt.setObject(2,this.idTrajet);
            stmt.setObject(3,this.heureDepart);
            stmt.setObject(4,this.heureArrivee);
            stmt.setObject(5,this.idHorraireTrain);
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
            String req = "DELETE FROM HorraireTrain WHERE idHorraireTrain=? ";
            stmt.setObject(1,this.idHorraireTrain);
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
