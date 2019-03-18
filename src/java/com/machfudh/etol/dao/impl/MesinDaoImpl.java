/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.dao.impl;

import com.machfudh.etol.dao.MesinDao;
import com.machfudh.etol.entity.Mesin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class MesinDaoImpl implements MesinDao{
    
    private Connection conn;

    public MesinDaoImpl(Connection conn) {
        this.conn = conn;
    }
       

    @Override
    public Mesin cekMesin(String kodeMesin) throws Exception {
        Mesin mesin = new Mesin();
        
        String sql = "SELECT id,lokasi,potongan FROM mesin WHERE kode=? LIMIT 1";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, kodeMesin);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            mesin = new Mesin();
            
            mesin.setId(rs.getInt(1));
            mesin.setLokasi(rs.getString(2));
            mesin.setPotongan(rs.getInt(3));
        }
        
        
        return mesin;
    }
    
    
    
}
