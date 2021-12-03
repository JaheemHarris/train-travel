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
import java.util.Date;

/**
 *
 * @author HP
 */
public class Reservation {
    private String idReservation;
    private String idClient;
    private String idVoyage;
    private int nombreBillet;
    private double prixTotal;
    private String dateVoyage;
    private String dateReservation;

    public Reservation() {
    }

    public Reservation(String idReservation, String idClient, String idVoyage, int nombreBillet, double prixTotal,String dateVoyage, String dateReservation) {
        this.idReservation = idReservation;
        this.idClient = idClient;
        this.idVoyage = idVoyage;
        this.nombreBillet = nombreBillet;
        this.dateVoyage=dateVoyage;
        this.prixTotal = prixTotal;
        this.dateReservation = dateReservation;
    }

    public Reservation(String idReservation, String idClient, String idVoyage, int nombreBillet, double prixTotal, String dateVoyage) {
        this.idReservation = idReservation;
        this.idClient = idClient;
        this.idVoyage = idVoyage;
        this.nombreBillet = nombreBillet;
        this.prixTotal = prixTotal;
        this.dateVoyage = dateVoyage;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(String idVoyage) {
        this.idVoyage = idVoyage;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNombreBillet() {
        return nombreBillet;
    }

    public void setNombreBillet(int nombreBillet) {
        this.nombreBillet = nombreBillet;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(String dateVoyage) {
        this.dateVoyage = dateVoyage;
    }
    
    public void add(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO Reservation VALUES (?,?,?,?,?,?,CURDATE());";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,this.idReservation);
            stmt.setObject(2,this.idClient);
            stmt.setObject(3,this.idVoyage);
            stmt.setObject(4,this.nombreBillet);
            stmt.setObject(5,this.prixTotal);
            stmt.setObject(6,this.dateVoyage);
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
