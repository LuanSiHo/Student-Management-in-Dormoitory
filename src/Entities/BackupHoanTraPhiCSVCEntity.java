/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class BackupHoanTraPhiCSVCEntity {

    private int MaHoanTra;
    private String MaKTX;
    private String NamHoc;
    private String PhiHoanTra;
    private Date NgayHoanTra;

    public BackupHoanTraPhiCSVCEntity() {
    }

    
    
    public int getMaHoanTra() {
        return MaHoanTra;
    }

    public void setMaHoanTra(int MaHoanTra) {
        this.MaHoanTra = MaHoanTra;
    }

    public String getMaKTX() {
        return MaKTX;
    }

    public void setMaKTX(String MaKTX) {
        this.MaKTX = MaKTX;
    }

    public String getNamHoc() {
        return NamHoc;
    }

    public void setNamHoc(String NamHoc) {
        this.NamHoc = NamHoc;
    }

    public String getPhiHoanTra() {
        return PhiHoanTra;
    }

    public void setPhiHoanTra(String PhiHoanTra) {
        this.PhiHoanTra = PhiHoanTra;
    }

    public Date getNgayHoanTra() {
        return NgayHoanTra;
    }

    public void setNgayHoanTra(Date NgayHoanTra) {
        this.NgayHoanTra = NgayHoanTra;
    }

}
