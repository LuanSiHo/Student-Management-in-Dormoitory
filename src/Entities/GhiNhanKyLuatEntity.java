/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class GhiNhanKyLuatEntity {
    
    private int MaGhiNhanKyLuat;
    private String MaKTX;
    private Date NgayGhiNhan;
    private String MucKyLuat;
    private String GhiChu;

    public GhiNhanKyLuatEntity() {
    }

    public int getMaGhiNhanKyLuat() {
        return MaGhiNhanKyLuat;
    }

    public void setMaGhiNhanKyLuat(int MaGhiNhanKyLuat) {
        this.MaGhiNhanKyLuat = MaGhiNhanKyLuat;
    }

    public String getMaKTX() {
        return MaKTX;
    }

    public void setMaKTX(String MaKTX) {
        this.MaKTX = MaKTX;
    }

    public Date getNgayGhiNhan() {
        return NgayGhiNhan;
    }

    public void setNgayGhiNhan(Date NgayGhiNhan) {
        this.NgayGhiNhan = NgayGhiNhan;
    }

    public String getMucKyLuat() {
        return MucKyLuat;
    }

    public void setMucKyLuat(String MucKyLuat) {
        this.MucKyLuat = MucKyLuat;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}
