/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.HoanTraPhiCSVCDAL;
import java.util.Vector;

public class HoanTraPhiCSVCBLL {

    HoanTraPhiCSVCDAL hoanTraPhiCSVCDAL = new HoanTraPhiCSVCDAL();

    public void Insert(String maKTX, String namHoc, String phiHoanTra) {
        hoanTraPhiCSVCDAL.Insert(maKTX, namHoc, phiHoanTra);
    }

    public void Delete(String MaKTX) {
        hoanTraPhiCSVCDAL.Delete(MaKTX);
    }

    public void ShowTable(Vector cols, Vector data, String MaKTX, String NamHoc) {
        hoanTraPhiCSVCDAL.ShowTable(cols, data, MaKTX, NamHoc);
    }

    public boolean KiemTraHoanTraPhiCSVC(String MaKTX, String NamHoc) {
        return hoanTraPhiCSVCDAL.KiemTraHoanTraPhiCSVC(MaKTX, NamHoc);
    }

    public String layNamHoc(String str) {
        return hoanTraPhiCSVCDAL.layNamHoc(str);
    }
}
