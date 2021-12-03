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
import java.util.List;
import tables.Train;

/**
 *
 * @author HP
 */
public class TrainService {
    
    public Train getTrainById(String idTrain,DbAccess dbConnex)throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Train trainFound = null;
        try{
            con = dbConnex.getConnection();
            String req = "SELECT * FROM Train WHERE idTrain=?";
            stmt=con.prepareStatement(req);
            stmt.setObject(1, idTrain);
            res = stmt.executeQuery();
            String idCompagnie = null;
            String numeroTrain = null;
            int nombreDePlaces = 0;
            while(res.next()){
                idTrain = res.getString(1);
                idCompagnie = res.getString(2);
                numeroTrain = res.getString(3);
                nombreDePlaces = res.getInt(4);
                trainFound = new Train(idTrain,idCompagnie,numeroTrain,nombreDePlaces);
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
        return trainFound;
    }
    
    public List<Train> findTrainOnThisPath(String idTrajet,DbAccess connexDb) throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Train> listOfTrain = new ArrayList<Train>();
        try{
            con=connexDb.getConnection();
            String req = "SELECT Train.* FROM HorraireTrain JOIN Train ON HorraireTrain.idTrain=Train.idTrain WHERE HorraireTrain.idTrajet=%";
            stmt=con.prepareStatement(req);
            stmt.setObject(1,idTrajet);
            result=stmt.executeQuery();
            String idTrain=null;
            String idCompagnie=null;
            String numero=null;
            int nbrDePlaces=0;
            Train trainTemp=null;
            while(result.next()){
                idTrain=result.getString(1);
                idCompagnie=result.getString(2);
                numero=result.getString(3);
                nbrDePlaces=result.getInt(4);
                trainTemp = new Train(idTrain,idCompagnie,numero,nbrDePlaces);
                listOfTrain.add(trainTemp);
            }
//            listOfTrain=new List();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            if(stmt!=null & result!=null ){
                stmt.close();
                result.close();
            }
            connexDb.closeConnection();
        }
        return listOfTrain;
    }
    
    public ArrayList<Train> listeTrain(DbAccess dbConnex)throws SQLException,Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ArrayList<Train> listeTrain = new ArrayList();
        try{
            con=dbConnex.getConnection();
            String req = "SELECT * FROM Train";
            stmt=con.prepareStatement(req);
            res=stmt.executeQuery();
            String idTrain=null;
            String idCompagnie=null;
            String numero=null;
            int nombreDePlaces=0;
            Train temp=null;
            while(res.next()){
                idTrain=res.getString(1);
                idCompagnie=res.getString(2);
                numero=res.getString(3);
                nombreDePlaces=res.getInt(4);
                temp=new Train(idTrain,idCompagnie,numero,nombreDePlaces);
                listeTrain.add(temp);
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
        return listeTrain;
    }
}
