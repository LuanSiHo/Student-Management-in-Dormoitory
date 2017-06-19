/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class MucGiaNuocEntity {
    private int MaGiaNuoc;
    private Date NgayApDung;
    private float TuKhoi;
    private float DenKhoi;
    private String GiaNuoc;

    public MucGiaNuocEntity() {
    }

    public int getMaGiaNuoc() {
        return MaGiaNuoc;
    }

    public void setMaGiaNuoc(int MaGiaNuoc) {
        this.MaGiaNuoc = MaGiaNuoc;
    }

    public Date getNgayApDung() {
        return NgayApDung;
    }

    public void setNgayApDung(Date NgayApDung) {
        this.NgayApDung = NgayApDung;
    }

    public float getTuKhoi() {
        return TuKhoi;
    }

    public void setTuKhoi(float TuKhoi) {
        this.TuKhoi = TuKhoi;
    }

    public float getDenKhoi() {
        return DenKhoi;
    }

    public void setDenKhoi(float DenKhoi) {
        this.DenKhoi = DenKhoi;
    }

    public String getGiaNuoc() {
        return GiaNuoc;
    }

    public void setGiaNuoc(String GiaNuoc) {
        this.GiaNuoc = GiaNuoc;
    }
    
    
}
