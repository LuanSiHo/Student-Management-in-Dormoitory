/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.XuLySinhVienRaKhoiKTXDAL;
import java.io.FileNotFoundException;
import java.util.Vector;


public class XuLySinhVienRaKhoiKTXBLL {

    XuLySinhVienRaKhoiKTXDAL xuLySinhVienRaKhoiKTXDAL = new XuLySinhVienRaKhoiKTXDAL();

    public String TinhPhiHoanTra(String MaKTX) {
        return xuLySinhVienRaKhoiKTXDAL.TinhPhiHoanTra(MaKTX);
    }

    public void Insert(String MaKTX) {
        xuLySinhVienRaKhoiKTXDAL.Insert(MaKTX);
    }

    public void ShowTable(Vector cols, Vector data, String MaKTX) {
        xuLySinhVienRaKhoiKTXDAL.ShowTable(cols, data, MaKTX);
    }

    public boolean KiemTraXuLySVRaKhoiKTX(String MaKTX) {
        return xuLySinhVienRaKhoiKTXDAL.KiemTraXuLySVRaKhoiKTX(MaKTX);
    }

    public void inBienLaiHoanTra(String maKTX, String user) throws FileNotFoundException {
        xuLySinhVienRaKhoiKTXDAL.inBienLaiHoanTra(maKTX, user);
    }
}
