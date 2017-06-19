/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class BackupThuPhiNoiTruEntity {

    private String MaKTX;
    private String HoSinhVien;
    private String TenSinhVien;
    private String MSSV;
    private String GioiTinh;
    private String CMND;
    private Date NgaySinh;
    private int MaXepPhong;
    private String TenTruong;
    private String TenNha;
    private String TenPhong;
    private String NamHoc;
    private String HocKy;
    private String SoTienThu;
    private String PhiHoanTra;

    public String getSoTienThu() {
        return SoTienThu;
    }

    public void setSoTienThu(String SoTienThu) {
        this.SoTienThu = SoTienThu;
    }

    public String getPhiHoanTra() {
        return PhiHoanTra;
    }

    public void setPhiHoanTra(String PhiHoanTra) {
        this.PhiHoanTra = PhiHoanTra;
    }

    public String getTenTruong() {
        return TenTruong;
    }

    public void setTenTruong(String TenTruong) {
        this.TenTruong = TenTruong;
    }

    public BackupThuPhiNoiTruEntity() {
    }

    public String getMaKTX() {
        return MaKTX;
    }

    public void setMaKTX(String MaKTX) {
        this.MaKTX = MaKTX;
    }

    public String getHoSinhVien() {
        return HoSinhVien;
    }

    public void setHoSinhVien(String HoSinhVien) {
        this.HoSinhVien = HoSinhVien;
    }

    public String getTenSinhVien() {
        return TenSinhVien;
    }

    public void setTenSinhVien(String TenSinhVien) {
        this.TenSinhVien = TenSinhVien;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getMaXepPhong() {
        return MaXepPhong;
    }

    public void setMaXepPhong(int MaXepPhong) {
        this.MaXepPhong = MaXepPhong;
    }

    public String getTenNha() {
        return TenNha;
    }

    public void setTenNha(String TenNha) {
        this.TenNha = TenNha;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public String getNamHoc() {
        return NamHoc;
    }

    public void setNamHoc(String NamHoc) {
        this.NamHoc = NamHoc;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

}
