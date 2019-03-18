/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.dao;

import com.machfudh.etol.entity.Sensor;

/**
 *
 * @author user
 */
public interface SensorDao {
    
    public boolean setSensor(int clientID, int roomID, int btn1, int btn2, int btn3, int btn4) throws Exception;
    
    public Sensor getSensor(int clientID, int roomID)throws Exception;
    
}
