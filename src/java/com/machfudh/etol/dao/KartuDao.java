/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.dao;

/**
 *
 * @author user
 */
public interface KartuDao {
    
    public int cekSaldo(String kodeKartu) throws Exception;
    
    public boolean potSaldo(String kodeKartu, int saldo, int potongan) throws Exception;
    
}
