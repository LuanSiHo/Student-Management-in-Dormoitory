/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PhongDAL;
import java.util.ArrayList;
import java.util.Vector;


public class PhongBLL {

    PhongDAL phongDAL = new PhongDAL();

    public int LayMaPhong(int tenPhong, String tenNha) {
        return phongDAL.LayMaPhong(tenPhong, tenNha);
    }

    public String LayTenPhong(String MaKTX) {
        return phongDAL.LayTenPhong(MaKTX);
    }

    public String LayTenPhongTuMaXepPhong(int MaXepPhong) {
        return phongDAL.LayTenPhongTuMaXepPhong(MaXepPhong);
    }

    public ArrayList<String> LayDanhSachPhong(String tenNha) {
        return phongDAL.LayDanhSachPhong(tenNha);
    }

    public void Delete(int maPhong) {
        phongDAL.Delete(maPhong);
    }

    public void ShowTable(Vector cols, Vector data, String tenNha) {
        phongDAL.ShowTable(cols, data, tenNha);
    }

    public void Insert(String tenPhong, int maNha) {
        phongDAL.Insert(tenPhong, maNha);
    }

    public boolean TimTenPhong(String tenPhong, int maNha) {
        return phongDAL.TimTenPhong(tenPhong, maNha);
    }
    
}
