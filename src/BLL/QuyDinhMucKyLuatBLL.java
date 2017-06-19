/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.QuyDinhMucKyLuatDAL;
import java.util.ArrayList;
import java.util.Vector;


public class QuyDinhMucKyLuatBLL {

    QuyDinhMucKyLuatDAL quyDinhMucKyLuatDAL = new QuyDinhMucKyLuatDAL();

    public void ShowTable(Vector cols, Vector data) {
        quyDinhMucKyLuatDAL.ShowTable(cols, data);
    }

    public void Insert(String tenKyLuat) {
        quyDinhMucKyLuatDAL.Insert(tenKyLuat);
    }

    public void Delete(String tenKyLuat) {
        quyDinhMucKyLuatDAL.Delete(tenKyLuat);
    }

    public void Update(String tenKyLuat, int maKyLuat) {
        quyDinhMucKyLuatDAL.Update(tenKyLuat, maKyLuat);
    }

    public ArrayList<String> LayDanhSachMucKyLuat() {
        return quyDinhMucKyLuatDAL.LayDanhSachMucKyLuat();
    }

    public boolean TimTenKyLuat(String tenKyLuat) {
        return quyDinhMucKyLuatDAL.TimTenKyLuat(tenKyLuat);
    }
}
