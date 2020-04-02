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
    private String url="jdbc:mysql://localhost:3306/huntkingdom?useTimezone=true&serverTimezone=GMT";
    private String username = "root";
    private String passwd = "";
    public static DataSource instance;
    private Connection cnx;
    
    public DataSource()
    {
        try {
            cnx=DriverManager.getConnection(url, username, passwd);
            System.out.print("Connected \n");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
