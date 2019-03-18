/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DBUtil {
    
    private Connection conn = null ;

    public DBUtil() {
    
       String URL = "jdbc:postgresql://localhost:5432/etol";
       String USER = "postgres";
       String PASS = "admin";
       
       
       try{
           Class.forName("org.postgresql.Driver").newInstance();
           this.conn = DriverManager.getConnection(URL, USER, PASS);
           System.out.println("Koneksi Berhasil ..");
       }catch(Exception ex){
           System.out.println("Koneksi Gagal Bro ....");
       }
    
    }
    

    public Connection getConn(){
        return this.conn;
    }
    
    public void closeConn(){
        
        if(this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
