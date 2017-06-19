/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.QuyDinhPhiNoiTruDAL;
import Entities.QuyDinhPhiNoiTruEntity;
import java.util.Vector;


public class QuyDinhPhiNoiTruBLL {

    QuyDinhPhiNoiTruDAL quyDinhPhiNoiTruDAL = new QuyDinhPhiNoiTruDAL();

    public QuyDinhPhiNoiTruEntity LayPhiNoiTru(String MaKTX) {
        return quyDinhPhiNoiTruDAL.LayPhiNoiTru(MaKTX);
    }

    public void ShowTable(Vector cols, Vector data) {
        quyDinhPhiNoiTruDAL.ShowTable(cols, data);
    }

    public String LayPhiNoiTruTheoLoaiNha(int soNguoi) {
        return quyDinhPhiNoiTruDAL.LayPhiNoiTruTheoLoaiNha(soNguoi);
    }
    
     public void Update(int soNguoi, String phiNoiTru)
     {
         quyDinhPhiNoiTruDAL.Update(soNguoi, phiNoiTru);
     }
}
