/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class NhaEntity {
    private int MaNha;
    private String TenNha;
    private int MaLoaiNha;

    public NhaEntity() {
    }

    public int getMaNha() {
        return MaNha;
    }

    public void setMaNha(int MaNha) {
        this.MaNha = MaNha;
    }

    public String getTenNha() {
        return TenNha;
    }

    public void setTenNha(String TenNha) {
        this.TenNha = TenNha;
    }

    public int getMaLoaiNha() {
        return MaLoaiNha;
    }

    public void setMaLoaiNha(int MaLoaiNha) {
        this.MaLoaiNha = MaLoaiNha;
    }
    
    
}
