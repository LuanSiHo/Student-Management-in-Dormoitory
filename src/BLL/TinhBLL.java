/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TinhDAL;
import java.util.ArrayList;
import java.util.Vector;


public class TinhBLL {

    TinhDAL tinhDAL = new TinhDAL();

    public void ShowTable(Vector cols, Vector data) {
        tinhDAL.ShowTable(cols, data);
    }

    public boolean TimTenTinh(String tenTinh) {
        return tinhDAL.TimTenTinh(tenTinh);
    }

    public void Insert(String tenTinh) {
        tinhDAL.Insert(tenTinh);
    }

    public void Delete(String tenTinh) {
        tinhDAL.Delete(tenTinh);
    }
    
    public void Update(String tenTinh,int maTinh) 
    {
        tinhDAL.Update(tenTinh, maTinh);
    }

    public String LayTenTinh(int maTinh) {
        return tinhDAL.LayTenTinh(maTinh);
    }

    public ArrayList<String> LayDanhSachTinh() {
        return tinhDAL.LayDanhSachTinh();
    }

    public int LayMaTinh(String tenTinh) {
        return tinhDAL.LayMaTinh(tenTinh);
    }

    public boolean KiemTraXoaTinh(String tenTinh) {
        return tinhDAL.KiemTraXoaTinh(tenTinh);
    }
}
