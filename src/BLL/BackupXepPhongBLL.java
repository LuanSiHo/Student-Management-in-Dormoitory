/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BackupXepPhongDAL;

public class BackupXepPhongBLL {

    BackupXepPhongDAL backupXepPhongDAL = new BackupXepPhongDAL();

    public void Insert(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        backupXepPhongDAL.Insert(MaKTX, MaNha, MaPhong, NamHoc, HocKy);
    }

    public void Update(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        backupXepPhongDAL.Update(MaKTX, MaNha, MaPhong, NamHoc, HocKy);
    }

    public void Delete(String MaKTX) {
        backupXepPhongDAL.Delete(MaKTX);
    }

    public boolean KiemTraXepPhong(String MaKTX, String NamHoc, String HocKy) {
        return backupXepPhongDAL.KiemTraXepPhong(MaKTX, NamHoc, HocKy);
    }
}
