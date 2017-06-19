/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class LoaiNhaEntity {
    private int MaLoaiNha;
    private int SoNguoi;
    private String GioiTinh;

    public LoaiNhaEntity() {
    }

    public int getMaLoaiNha() {
        return MaLoaiNha;
    }

    public void setMaLoaiNha(int MaLoaiNha) {
        this.MaLoaiNha = MaLoaiNha;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    
}
