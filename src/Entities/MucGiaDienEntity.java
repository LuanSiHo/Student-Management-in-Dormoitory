/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class MucGiaDienEntity {
    
    private int MaGiaDien;
    private Date NgayApDung;
    private float TuKW;
    private float DenKW;
    private String GiaDien;

    public MucGiaDienEntity() {
    }

    public int getMaGiaDien() {
        return MaGiaDien;
    }

    public void setMaGiaDien(int MaGiaDien) {
        this.MaGiaDien = MaGiaDien;
    }

    public Date getNgayApDung() {
        return NgayApDung;
    }

    public void setNgayApDung(Date NgayApDung) {
        this.NgayApDung = NgayApDung;
    }

    public float getTuKW() {
        return TuKW;
    }

    public void setTuKW(float TuKW) {
        this.TuKW = TuKW;
    }

    public float getDenKW() {
        return DenKW;
    }

    public void setDenKW(float DenKW) {
        this.DenKW = DenKW;
    }

    public String getGiaDien() {
        return GiaDien;
    }

    public void setGiaDien(String GiaDien) {
        this.GiaDien = GiaDien;
    }
    
    
}
