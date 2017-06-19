/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class ThuPhiNoiTruEntity {
    private int MaThuPhi;
    private int MaXepPhong;
    private Date NgayThu;
    private String SoTienThu;

    public ThuPhiNoiTruEntity() {
    }

    public int getMaThuPhi() {
        return MaThuPhi;
    }

    public void setMaThuPhi(int MaThuPhi) {
        this.MaThuPhi = MaThuPhi;
    }

    public int getMaXepPhong() {
        return MaXepPhong;
    }

    public void setMaXepPhong(int MaXepPhong) {
        this.MaXepPhong = MaXepPhong;
    }

    public Date getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(Date NgayThu) {
        this.NgayThu = NgayThu;
    }

    public String getSoTienThu() {
        return SoTienThu;
    }

    public void setSoTienThu(String SoTienThu) {
        this.SoTienThu = SoTienThu;
    }
    
    
}
