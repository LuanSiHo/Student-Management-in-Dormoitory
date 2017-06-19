/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BackupThuPhiDienNuocDAL;
import java.sql.Date;


public class BackupThuPhiDienNuocBLL {
    
    BackupThuPhiDienNuocDAL backupThuPhiDienNuocDAL = new BackupThuPhiDienNuocDAL();
    
    public void Insert(int MaNha, int MaPhong, int thang, int nam) {
        backupThuPhiDienNuocDAL.Insert(MaNha, MaPhong, thang, nam);
    }
    
    public void Update(int MaNha, int MaPhong, int thang, int nam, float SoKWDien, float SoKhoiNuoc) {
        backupThuPhiDienNuocDAL.Update(MaNha, MaPhong, thang, nam, SoKWDien, SoKhoiNuoc);
    }
    
    public void Update_NgayThu_DaThu(int MaNha, int MaPhong, int thang, int nam, Date ngayThu) {
        backupThuPhiDienNuocDAL.Update_NgayThu_DaThu(MaNha, MaPhong, thang, nam, ngayThu);
    }
    
}
