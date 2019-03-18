/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.machfudh.etol.entity;

/**
 *
 * @author user
 */
public class Sensor {
    
  private int id;
  private int clientid;
  private int roomid;
  private int suhu;
  private int kelembapan;
  private int magnet; 
  private int btn1; 
  private int btn2; 
  private int btn3;
  private int btn4; 
  private String irremoot1; // remote TV 
  private String irremoot2; // remote AC 
  private String waktu;
  private String tanggal;

    public int getBtn1() {
        return btn1;
    }

    public void setBtn1(int btn1) {
        this.btn1 = btn1;
    }

    public int getBtn2() {
        return btn2;
    }

    public void setBtn2(int btn2) {
        this.btn2 = btn2;
    }

    public int getBtn3() {
        return btn3;
    }

    public void setBtn3(int btn3) {
        this.btn3 = btn3;
    }

    public int getBtn4() {
        return btn4;
    }

    public void setBtn4(int btn4) {
        this.btn4 = btn4;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIrremoot1() {
        return irremoot1;
    }

    public void setIrremoot1(String irremoot1) {
        this.irremoot1 = irremoot1;
    }

    public String getIrremoot2() {
        return irremoot2;
    }

    public void setIrremoot2(String irremoot2) {
        this.irremoot2 = irremoot2;
    }

    public int getKelembapan() {
        return kelembapan;
    }

    public void setKelembapan(int kelembapan) {
        this.kelembapan = kelembapan;
    }

    public int getMagnet() {
        return magnet;
    }

    public void setMagnet(int magnet) {
        this.magnet = magnet;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getSuhu() {
        return suhu;
    }

    public void setSuhu(int suhu) {
        this.suhu = suhu;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
        
}
