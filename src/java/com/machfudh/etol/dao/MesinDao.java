/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.dao;

import com.machfudh.etol.entity.Mesin;

/**
 *
 * @author user
 */
public interface MesinDao {

    public Mesin cekMesin(String kodeMesin) throws Exception;

}
