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
public class Compagnie {
    private String idCompagnie;
    private String nomCompagnie;

    public Compagnie() {
    }

    public Compagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public Compagnie(String idCompagnie, String nomCompagnie) {
        this.idCompagnie = idCompagnie;
        this.nomCompagnie = nomCompagnie;
    }

    public String getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public void setNomCompagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
    }
    
    public void add(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO Compagnie VALUES (?,?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idCompagnie);
            stmt.setObject(2,this.nomCompagnie);
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
            String req = "UPDATE Compagnie SET nomCompagnie=? WHERE idCompagnie=? ";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.nomCompagnie);
            stmt.setObject(2,this.idCompagnie);
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
    
    public void delete(DbAccess dbConnex) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "DELETE FROM Compagnie WHERE idCompagnie=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idCompagnie);
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
