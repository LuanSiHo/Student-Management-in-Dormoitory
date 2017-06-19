/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class BackupGhiNhanDienNuocEntity {
    
    private int MaGhiNhan;
    private int MaNha;
    private int MaPhong;
    private int Thang;
    private int Nam;
    private Date NgayChot;
    private float SoKWDien;
    private float SoKhoiNuoc;
    private float ChiSoDienCuoi;
    private float ChiSoNuocCuoi;

    public BackupGhiNhanDienNuocEntity() {
    }


    

    public int getMaGhiNhan() {
        return MaGhiNhan;
    }

    public void setMaGhiNhan(int MaGhiNhan) {
        this.MaGhiNhan = MaGhiNhan;
    }

    public int getMaNha() {
        return MaNha;
    }

    public void setMaNha(int MaNha) {
        this.MaNha = MaNha;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int MaPhong) {
        this.MaPhong = MaPhong;
    }

    public int getThang() {
        return Thang;
    }

    public void setThang(int Thang) {
        this.Thang = Thang;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int Nam) {
        this.Nam = Nam;
    }

    public Date getNgayChot() {
        return NgayChot;
    }

    public void setNgayChot(Date NgayChot) {
        this.NgayChot = NgayChot;
    }

    public float getSoKWDien() {
        return SoKWDien;
    }

    public void setSoKWDien(float SoKWDien) {
        this.SoKWDien = SoKWDien;
    }

    public float getSoKhoiNuoc() {
        return SoKhoiNuoc;
    }

    public void setSoKhoiNuoc(float SoKhoiNuoc) {
        this.SoKhoiNuoc = SoKhoiNuoc;
    }

    public float getChiSoDienCuoi() {
        return ChiSoDienCuoi;
    }

    public void setChiSoDienCuoi(float ChiSoDienCuoi) {
        this.ChiSoDienCuoi = ChiSoDienCuoi;
    }

    public float getChiSoNuocCuoi() {
        return ChiSoNuocCuoi;
    }

    public void setChiSoNuocCuoi(float ChiSoNuocCuoi) {
        this.ChiSoNuocCuoi = ChiSoNuocCuoi;
    }
    
}
