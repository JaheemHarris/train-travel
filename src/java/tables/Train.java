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
public class Train {
    private String idTrain;
    private String idCompagnie;
    private String numero;
    private int nombreDePlaces;
    
    public Train(){
    }

    public Train(String idTrain) {
        this.idTrain = idTrain;
    }

    public Train(String idTrain, String idCompagnie, String numero, int nombreDePlaces) {
        this.idTrain = idTrain;
        this.idCompagnie = idCompagnie;
        this.numero = numero;
        this.nombreDePlaces = nombreDePlaces;
    }


    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public String getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNombreDePlaces() {
        return nombreDePlaces;
    }

    public void setNombreDePlaces(int nombreDePlaces) {
        this.nombreDePlaces = nombreDePlaces;
    }
    
    public void add(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO Train VALUES (?,?,?,?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idTrain);
            stmt.setObject(2,this.idCompagnie);
            stmt.setObject(3,this.numero);
            stmt.setObject(4,this.nombreDePlaces);
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
    
    public void update(DbAccess dbConnex) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "UPDATE Train SET idCompagnie=? , numero=?, nombreDePlaces=? WHERE idTrain=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idCompagnie);
            stmt.setObject(2,this.numero);
            stmt.setObject(3,this.nombreDePlaces);
            stmt.setObject(4,this.idTrain);
            System.out.println(stmt);
            stmt.executeUpdate();
            con.commit();
        }catch(Exception e){
            con.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
    }
    
    public void delete(DbAccess dbConnex) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "DELETE FROM Train WHERE idTrain=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idTrain);
            stmt.executeUpdate();
            con.commit();
        }catch(Exception e){
            con.rollback();
            e.printStackTrace();
            throw e;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
            dbConnex.closeConnection();
        }
    }
}
