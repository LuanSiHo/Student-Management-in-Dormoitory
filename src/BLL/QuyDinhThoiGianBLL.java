/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.QuyDinhThoiGianDAL;
import Entities.QuyDinhThoiGianEntity;
import java.sql.Date;
import java.util.Vector;


public class QuyDinhThoiGianBLL {

    QuyDinhThoiGianDAL quyDinhThoiGianDAL = new QuyDinhThoiGianDAL();

    public void Update(String NamHoc, String HocKy, Date TuNgay, Date DenNgay) {
        quyDinhThoiGianDAL.Update(NamHoc, HocKy, TuNgay, DenNgay);
    }

    public void ShowTable(Vector cols, Vector data) {
        quyDinhThoiGianDAL.ShowTable(cols, data);
    }

    public QuyDinhThoiGianEntity LayThoiGian() {
        return quyDinhThoiGianDAL.LayThoiGian();
    }

}
