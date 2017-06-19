/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BackupHoanTraPhiCSVCDAL;
import DAL.HoanTraPhiCSVCDAL;
import java.util.Vector;


public class BackupHoanTraPhiCSVCBLL {

    BackupHoanTraPhiCSVCDAL  backupHoanTraPhiCSVCDAL = new BackupHoanTraPhiCSVCDAL();

    public void Insert(String maKTX, String namHoc, String phiHoanTra) {
        backupHoanTraPhiCSVCDAL.Insert(maKTX, namHoc, phiHoanTra);
    }

    public void ShowTable(Vector cols, Vector data, String MaKTX, String NamHoc) {
        backupHoanTraPhiCSVCDAL.ShowTable(cols, data, MaKTX, NamHoc);
    }

    public boolean KiemTraHoanTraPhiCSVC(String MaKTX, String NamHoc) {
        return backupHoanTraPhiCSVCDAL.KiemTraHoanTraPhiCSVC(MaKTX, NamHoc);
    }

}
