/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BackupGhiNhanDienNuocDAL;
import Entities.GhiNhanDienNuocEntity;
import java.sql.Date;

//back up ghi nhan dien nuoc BLL
public class BackupGhiNhanDienNuocBLL {

    BackupGhiNhanDienNuocDAL backupGhiNhanDienNuocDAL = new BackupGhiNhanDienNuocDAL();

    public void Insert(int MaNha, int MaPhong, int thang, int nam, Date ngayChot, float SoKWDien, float SoKhoiNuoc, float ChiSoDienCuoi, float ChiSoNuocCuoi) {
        backupGhiNhanDienNuocDAL.Insert(MaNha, MaPhong, thang, nam, ngayChot, SoKWDien, SoKhoiNuoc, ChiSoDienCuoi, ChiSoNuocCuoi);
    }

    public void Delete(int MaNha) {
        backupGhiNhanDienNuocDAL.Delete(MaNha);
    }

    public GhiNhanDienNuocEntity LayGhiNhanDienNuoc(int thang, int nam, int MaNha, int MaPhong) {
        return backupGhiNhanDienNuocDAL.LayGhiNhanDienNuoc(thang, nam, MaNha, MaPhong);
    }

    public boolean KiemTraGhiNhanDienNuoc(int MaNha, int MaPhong, int Thang, int Nam) {
        return backupGhiNhanDienNuocDAL.KiemTraGhiNhanDienNuoc(MaNha, MaPhong, Thang, Nam);
    }
}
