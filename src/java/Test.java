
import database.DbAccess;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import services.AdminService;
import services.ClientService;
import tables.Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[]args) throws Exception{
        DbAccess dbConnex = new DbAccess();
//        AdminService adServ = new AdminService();
        ClientService clientService = new ClientService();
        ArrayList<ArrayList> searchResult = new ArrayList();
        searchResult = clientService.rechercheSimple("VIL001", "VIL002", dbConnex);
        System.out.println(searchResult.size());
        ArrayList temp = new ArrayList();
        for(int i=0;i<searchResult.size();i++){
            temp = new ArrayList();
            temp = searchResult.get(i);
            for(int ii=0;ii<temp.size();ii++){
                System.out.println(temp.get(ii));
            }
        }
//        listeClient=clientService.listeClient(dbConnex);
//        System.out.println(listeClient.size());
//      Date date = new Date(2021-1900,6,29);
//        Date date = new Date(2021,7,29);
//        System.out.println(date);
//        add(date,dbConnex);
//        clientServ.reserver("CLT001", "VG001",3, "2021-07-30", dbConnex);
//        adServ.addCompagnie("Jaheem", dbConnex);
//          adServ.deleteVoyage("VG343",dbConnex);
//        adServ.addTrain("CMP220", "53983", 220, dbConnex);
//          adServ.deleteTrain("TRN33", dbConnex);
//            adServ.deleteCompagnie("CMP220", dbConnex);
    }
    
    public static void add(Date date,DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = dbConnex.getConnection();
            String req = "INSERT INTO daaw VALUES (?)";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,date);
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
