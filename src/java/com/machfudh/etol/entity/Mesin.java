/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.entity;

/**
 *
 * @author user
 */
public class Mesin {
    
    private int id;
    private String kode;
    private String lokasi;
    private int potongan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getPotongan() {
        return potongan;
    }

    public void setPotongan(int potongan) {
        this.potongan = potongan;
    }
    
    
    
}
