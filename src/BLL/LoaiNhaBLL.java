/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoaiNhaDAL;
import Entities.LoaiNhaEntity;
import java.util.ArrayList;


public class LoaiNhaBLL {

    LoaiNhaDAL loaiNhaDAL = new LoaiNhaDAL();

    public String LayGioiTinh_Phong(int MaPhong) {
        return loaiNhaDAL.LayGioiTinh_Phong(MaPhong);
    }

    public LoaiNhaEntity LayLoaiNha(String tenNha) {
        return loaiNhaDAL.LayLoaiNha(tenNha);
    }

    public ArrayList<Integer> LaySoNguoi() {
        return loaiNhaDAL.LaySoNguoi();
    }

    public ArrayList<String> LayGioiTinh() {
        return loaiNhaDAL.LayGioiTinh();
    }
    
     public int LayMaLoaiNha(int soNguoi, String gioiTinh)
     {
         return loaiNhaDAL.LayMaLoaiNha(soNguoi, gioiTinh);
     }
}
