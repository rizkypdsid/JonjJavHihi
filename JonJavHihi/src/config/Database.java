/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mrpds
 */
public class Database {
    
    private static java.sql.Connection connection;
    public static java.sql.Connection getKoneksi(){
        if(connection == null){
            try{
                String url = "jdbc:mysql://localhost/jonjelly";
                String user = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                connection = DriverManager.getConnection(url, user, password);
            } catch(SQLException t){
                System.out.println("Error Koneksi KE DATABASE!");
            }
        }
    return connection;
    }
    
}
