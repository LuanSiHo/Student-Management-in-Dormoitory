/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


public class QuyDinhThoiGianEntity {
    
    private int MaQuyDinh;
    private String NamHoc;
    private String HocKy;
    private Date TuNgay;
    private Date DenNgay;

    public QuyDinhThoiGianEntity() {
    }

    public int getMaQuyDinh() {
        return MaQuyDinh;
    }

    public void setMaQuyDinh(int MaQuyDinh) {
        this.MaQuyDinh = MaQuyDinh;
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

    public Date getTuNgay() {
        return TuNgay;
    }

    public void setTuNgay(Date TuNgay) {
        this.TuNgay = TuNgay;
    }

    public Date getDenNgay() {
        return DenNgay;
    }

    public void setDenNgay(Date DenNgay) {
        this.DenNgay = DenNgay;
    }
    
    
}
