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
import tables.HorraireTrain;

/**
 *
 * @author HP
 */
public class HorraireTrainService {
    public ArrayList<HorraireTrain> listeHorraireTrain(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<HorraireTrain> listeHorraireTrain = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM HorraireTrain";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idHorraireTrain=null;
            String idTrain=null;
            String idTrajet=null;
            String heureDepart=null;
            String heureArrivee=null;
            HorraireTrain temp=null;
            while(res.next()){
                idHorraireTrain=res.getString(1);
                idTrain=res.getString(2);
                idTrajet=res.getString(3);
                heureDepart=res.getString(4);
                heureArrivee=res.getString(5);
                temp=new HorraireTrain(idHorraireTrain, idTrain, idTrajet, heureDepart, heureArrivee);
                listeHorraireTrain.add(temp);
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
        return listeHorraireTrain;
    }
}
