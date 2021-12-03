/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DbAccess {
    private Connection connection=null;
    
    public Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            String user = "eeoztnneirtfxr";
            String passwd = "cb3e013344c88c0a77955f11d4efb17720f73b631fa28f25f6fec3e9bd276cee";
            connection=DriverManager.getConnection("jdbc:postgresql://ec2-54-228-139-34.eu-west-1.compute.amazonaws.com:5432/d9uveh744dl7k9",user,passwd);
            connection.setAutoCommit(false);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
    
    public void closeConnection()throws Exception{
        try{
            if(connection!=null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}
