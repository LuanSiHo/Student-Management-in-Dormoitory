/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.XepPhongDAL;
import Entities.SinhVienEntity;
import Entities.XepPhongEntity;
import java.util.Vector;


public class XepPhongBLL {

    XepPhongDAL xepPhongDAL = new XepPhongDAL();

    public void ShowTable(Vector cols, Vector data, int SoNguoi, String GioiTinh, String NamHoc, String HocKy) {
        xepPhongDAL.ShowTable(cols, data, SoNguoi, GioiTinh, NamHoc, HocKy);
    }

    public void Insert(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        xepPhongDAL.Insert(MaKTX, MaNha, MaPhong, NamHoc, HocKy);
    }

    public void Update(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        xepPhongDAL.Update(MaKTX, MaNha, MaPhong, NamHoc, HocKy);
    }

    public void Delete(String MaKTX) {
        xepPhongDAL.Delete(MaKTX);
    }

    public void Delete(int MaNha) {
        xepPhongDAL.Delete(MaNha);
    }

    public void delete(int maPhong) {
        xepPhongDAL.delete(maPhong);
    }

    public boolean KiemTraXepPhong(String maKTX, String namHoc, String hocKy) {
        return xepPhongDAL.KiemTraXepPhong(maKTX, namHoc, hocKy);
    }

    public boolean kiemTraXepPhong(int maPhong, String NamHoc) {
        return xepPhongDAL.kiemTraXepPhong(maPhong, NamHoc);
    }

    public boolean KiemTraXepPhong(int MaNha, String NamHoc) {
        return xepPhongDAL.KiemTraXepPhong(MaNha, NamHoc);
    }

    public XepPhongEntity Search_XepPhong_MaKTX(String MaKTX) {
        return xepPhongDAL.Search_XepPhong_MaKTX(MaKTX);
    }

    public boolean KiemTraXepPhong(String MaKTX) {
        return xepPhongDAL.KiemTraXepPhong(MaKTX);
    }

    public int KiemTraXepPhong(int maPhong, String NamHoc, String HocKy) {
        return xepPhongDAL.KiemTraXepPhong(maPhong, NamHoc, HocKy);
    }

}
