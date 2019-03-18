/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.entity;

/**
 *
 * @author user
 */
public class Kartu {
    
    private int id;
    private String kartu;
    private String mesin;
    private String transaksi;
    private int saldo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKartu() {
        return kartu;
    }

    public void setKartu(String kartu) {
        this.kartu = kartu;
    }

    public String getMesin() {
        return mesin;
    }

    public void setMesin(String mesin) {
        this.mesin = mesin;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(String transaksi) {
        this.transaksi = transaksi;
    }
    
    
    
}
