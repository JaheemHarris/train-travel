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
public class Client {
    
    private String idClient;
    private String nom;
    private String prenom;
    private String mail;
    private String motDePasse;

    public Client() {
    }

    public Client(String idClient) {
        this.idClient = idClient;
    }

    public Client(String idClient, String nom, String prenom, String mail, String motDePasse) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public void add(DbAccess dbConnex) throws SQLException,Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO Client VALUES (?,?,?,?,sha1(?))";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idClient);
            stmt.setObject(2,this.nom);
            stmt.setObject(3,this.prenom);
            stmt.setObject(4,this.mail);
            stmt.setObject(5,this.motDePasse);
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
    
    public void update(DbAccess dbConnex)throws SQLException,Exception{
        Connection con=null;
        PreparedStatement stmt = null;
        try{
              con=dbConnex.getConnection();
              String req = "UPDATE Client SET nom=? , prenom=? , mail=? , motDePasse=? WHERE idClient=? ";
              stmt=con.prepareStatement(req);
              stmt.setObject(1,this.nom);
              stmt.setObject(2,this.prenom);
              stmt.setObject(3,this.mail);
              stmt.setObject(4,this.motDePasse);
              stmt.setObject(5,this.idClient);
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
            String req = "DELETE FROM Client WHERE idClient=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idClient);
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
