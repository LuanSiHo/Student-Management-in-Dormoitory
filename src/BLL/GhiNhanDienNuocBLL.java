/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.GhiNhanDienNuocDAL;
import Entities.GhiNhanDienNuocEntity;
import Entities.ThuPhiDienNuocEntity;
import java.sql.Date;
import java.util.Vector;


public class GhiNhanDienNuocBLL {
    
    GhiNhanDienNuocDAL ghiNhanDienNuocDAL = new GhiNhanDienNuocDAL();
    
    public void Insert(int MaNha, int MaPhong, int thang, int nam, Date ngayChot, float SoKWDien, float SoKhoiNuoc, float ChiSoDienCuoi, float ChiSoNuocCuoi) {
        ghiNhanDienNuocDAL.Insert(MaNha, MaPhong, thang, nam, ngayChot, SoKWDien, SoKhoiNuoc, ChiSoDienCuoi, ChiSoNuocCuoi);
    }
    
    public void Delete(int MaNha) {
        ghiNhanDienNuocDAL.Delete(MaNha);
    }
    
    public GhiNhanDienNuocEntity LayGhiNhanDienNuoc(int thang, int nam, int MaNha, int MaPhong) {
        return ghiNhanDienNuocDAL.LayGhiNhanDienNuoc(thang, nam, MaNha, MaPhong);
    }
    
    public void ShowTable(Vector cols, Vector data, String TenNha, String TenPhong) {
        ghiNhanDienNuocDAL.ShowTable(cols, data, TenNha, TenPhong);
    }
    
    public boolean KiemTraGhiNhanDienNuoc(int MaNha, int MaPhong, int Thang, int Nam) {
        return ghiNhanDienNuocDAL.KiemTraGhiNhanDienNuoc(MaNha, MaPhong, Thang, Nam);
    }
    
    public void search_TraCuuDN(Vector cols, Vector data, String tenNha, String tenPhong) {
        ghiNhanDienNuocDAL.search_TraCuuDN(cols, data, tenNha, tenPhong);
    }
    
}
