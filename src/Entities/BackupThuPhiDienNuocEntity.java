/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class BackupThuPhiDienNuocEntity {
    
      
    private int MaThuPhiDienNuoc;
    private int MaNha;
    private int MaPhong;
    private int Thang;
    private int Nam;
    private Date NgayThu;
    private String TienDien;
    private String TienNuoc;
    private String TongCong;
    private String DaThu;

    public String getDaThu() {
        return DaThu;
    }

    public void setDaThu(String DaThu) {
        this.DaThu = DaThu;
    }

    public BackupThuPhiDienNuocEntity() {
    }

   

    public int getMaThuPhiDienNuoc() {
        return MaThuPhiDienNuoc;
    }

    public void setMaThuPhiDienNuoc(int MaThuPhiDienNuoc) {
        this.MaThuPhiDienNuoc = MaThuPhiDienNuoc;
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

    public Date getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(Date NgayThu) {
        this.NgayThu = NgayThu;
    }

    public String getTienDien() {
        return TienDien;
    }

    public void setTienDien(String TienDien) {
        this.TienDien = TienDien;
    }

    public String getTienNuoc() {
        return TienNuoc;
    }

    public void setTienNuoc(String TienNuoc) {
        this.TienNuoc = TienNuoc;
    }

    public String getTongCong() {
        return TongCong;
    }

    public void setTongCong(String TongCong) {
        this.TongCong = TongCong;
    }
    
}
