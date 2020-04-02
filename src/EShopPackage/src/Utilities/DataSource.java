/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;
import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author Fares
 */
public class DataSource {
 private  static DataSource instance=null;
    String url="jdbc:mysql://localhost/javapi";
    String username="root";
    String password="";
    Connection connection=null;
    private DataSource() {
        try {
            connection=DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DataSource getInstance(){
        if(instance==null){
            instance=new DataSource();
        }
     return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
