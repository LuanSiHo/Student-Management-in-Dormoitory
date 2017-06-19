/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class XuLySinhVienRaKhoiKTXEntity {
    private int MaXuLy;
    private int MaXepPhong;
    private Date NgayRaKTX;
    private String PhiHoanTra;

    public XuLySinhVienRaKhoiKTXEntity() {
    }

    public int getMaXuLy() {
        return MaXuLy;
    }

    public void setMaXuLy(int MaXuLy) {
        this.MaXuLy = MaXuLy;
    }

    public int getMaXepPhong() {
        return MaXepPhong;
    }

    public void setMaXepPhong(int MaXepPhong) {
        this.MaXepPhong = MaXepPhong;
    }

    public Date getNgayRaKTX() {
        return NgayRaKTX;
    }

    public void setNgayRaKTX(Date NgayRaKTX) {
        this.NgayRaKTX = NgayRaKTX;
    }

    public String getPhiHoanTra() {
        return PhiHoanTra;
    }

    public void setPhiHoanTra(String PhiHoanTra) {
        this.PhiHoanTra = PhiHoanTra;
    }
    
    
}
