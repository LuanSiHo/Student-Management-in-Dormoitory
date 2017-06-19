/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BackupThuPhiNoiTruDAL;
import Entities.BackupThuPhiNoiTruEntity;


public class BackupThuPhiNoiTruBLL {

    BackupThuPhiNoiTruDAL backupThuPhiNoiTruDAL = new BackupThuPhiNoiTruDAL();

    public void Insert() {
        backupThuPhiNoiTruDAL.Insert();
    }

    public BackupThuPhiNoiTruEntity GetBackup(String MaKTX) {
        return backupThuPhiNoiTruDAL.GetBackup(MaKTX);
    }

    public BackupThuPhiNoiTruEntity GetBackup(String MaKTX, String NamHoc) {
        return backupThuPhiNoiTruDAL.GetBackup(MaKTX, NamHoc);
    }
}
