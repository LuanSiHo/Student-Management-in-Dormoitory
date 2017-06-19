/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThuPhiDienNuocDAL;
import Entities.ThuPhiDienNuocEntity;
import java.sql.Date;
import java.util.Vector;

public class ThuPhiDienNuocBLL {

    ThuPhiDienNuocDAL thuPhiDienNuocDAL = new ThuPhiDienNuocDAL();

    public void Insert(int MaNha, int MaPhong, int thang, int nam) {
        thuPhiDienNuocDAL.Insert(MaNha, MaPhong, thang, nam);
    }

    public void Update(int MaNha, int MaPhong, int thang, int nam, float SoKWDien, float SoKhoiNuoc) {
        thuPhiDienNuocDAL.Update(MaNha, MaPhong, thang, nam, SoKWDien, SoKhoiNuoc);
    }
    
    public void Delete(int MaNha) 
    {
        thuPhiDienNuocDAL.Delete(MaNha);
    }

    public ThuPhiDienNuocEntity LayThuPhiDienNuoc(int MaNha, int MaPhong, int thang, int nam) {
        return thuPhiDienNuocDAL.LayThuPhiDienNuoc(MaNha, MaPhong, thang, nam);
    }

    public void ShowTable(Vector cols, Vector data, String TenNha, String TenPhong) {
        thuPhiDienNuocDAL.ShowTable(cols, data, TenNha, TenPhong);
    }
    
    public void Update_NgayThu_DaThu(int MaNha, int MaPhong, int thang, int nam, Date ngayThu)
    {
        thuPhiDienNuocDAL.Update_NgayThu_DaThu(MaNha, MaPhong, thang, nam, ngayThu);
    }

}
