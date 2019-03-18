/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.dao.impl;

import com.machfudh.etol.dao.KartuDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class KartuDaoImpl implements KartuDao{
    
    private Connection conn;

    public KartuDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int cekSaldo(String kodeKartu) throws Exception {
        int saldo = 0 ;
        
        String sql = "SELECT saldo FROM kartu WHERE kode=? LIMIT 1";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, kodeKartu);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            
            saldo = rs.getInt(1);
            System.out.println("saldo   : "+saldo);
        }
        
        return saldo;
    }

    @Override
    public boolean potSaldo(String kodeKartu, int saldo, int potongan) throws Exception {
        boolean result = false;
        int sisasaldo = saldo - potongan;
        
        String sql = "UPDATE kartu SET saldo=? WHERE kode=? ";
        PreparedStatement ps = this.conn.prepareCall(sql);
        ps.setInt(1, sisasaldo);
        ps.setString(2, kodeKartu);
        
        ps.executeUpdate();
        result = true;
        ps.close();
        
        return result;
        
    }

    
}
