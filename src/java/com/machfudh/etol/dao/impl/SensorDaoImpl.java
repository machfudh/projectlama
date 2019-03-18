/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.dao.impl;

import com.machfudh.etol.dao.SensorDao;
import com.machfudh.etol.entity.Sensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class SensorDaoImpl implements SensorDao{
    
    private Connection conn;

    public SensorDaoImpl(Connection conn) {
        this.conn = conn;
    } 

    @Override
    public boolean setSensor(int clientID, int roomID, int btn1, int btn2, int btn3, int btn4) throws Exception {
        boolean result = false;
        String sql ="UPDATE sensordata SET btn1 = ?, btn2 = ?, btn3 = ?,  btn4 = ? WHERE clientid=? AND roomid =? ";
        System.out.println(" sql : "+sql);
        
        PreparedStatement ps = this.conn.prepareCall(sql);
        ps.setInt(1, btn1);
        ps.setInt(2, btn2);
        ps.setInt(3, btn3);
        ps.setInt(4, btn4);
        ps.setInt(5, clientID);
        ps.setInt(6, roomID);
        
        ps.executeUpdate();
        result = true;
        ps.close();
        
        return result;
    }

    @Override
    public Sensor getSensor(int clientID, int roomID) throws Exception {
        Sensor sensor = new Sensor();
         
        String sql = "SELECT btn1,btn2,btn3,btn4 FROM sensordata WHERE clientid=?  AND roomid=?  LIMIT 1";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1,clientID);
        ps.setInt(2,roomID);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
           sensor = new Sensor();
           
           sensor.setBtn1(rs.getInt(1));
           sensor.setBtn2(rs.getInt(2));
           sensor.setBtn3(rs.getInt(3));
           sensor.setBtn4(rs.getInt(4));
            
        }
        
        return sensor;
    }
    
    
    
}
