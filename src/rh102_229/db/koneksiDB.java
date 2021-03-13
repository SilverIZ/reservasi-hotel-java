package rh102_229.db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *
 * @author iskandar18102
 */
public class koneksiDB {
    public static Connection conn;
    public static Statement stm;
    public static Properties propert = new Properties();
    
    public static Connection getKoneksi(){
        if (conn == null){
            try {
                
                String url="jdbc:mysql://localhost/reservasihotel18102_18229";
                String username= "root";     // default username
                String password= "";         // jika ada password bisa anda masukkan
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn =DriverManager.getConnection(url, username, password);
                stm = conn.createStatement();
                  } 
            
            catch (Exception ex){
             System.err.println("error"+ex);
             
            }
            
            
            
        }
        return conn;
    }
    
    public static void main (String[] args) throws SQLException{
        if(getKoneksi().equals(conn)){
            System.out.println("sukses");
        }
    }
    
}

