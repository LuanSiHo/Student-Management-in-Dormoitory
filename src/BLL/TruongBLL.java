/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TruongDAL;
import java.util.ArrayList;
import java.util.Vector;


public class TruongBLL {

    TruongDAL truongDAL = new TruongDAL();

    public String LayMaTruong(String tenTruong) {
        return truongDAL.LayMaTruong(tenTruong);
    }

    public String LayTenTruong(String maTruong) {
        return truongDAL.LayTenTruong(maTruong);
    }

    public ArrayList<String> LayDanhSachTruong() {
        return truongDAL.LayDanhSachTruong();
    }

    public void ShowTable(Vector cols, Vector data) {
        truongDAL.ShowTable(cols, data);
    }

    public void Insert(String maTruong, String tenTruong) {
        truongDAL.Insert(maTruong, tenTruong);
    }

    public void Delete(String maTruong) {
        truongDAL.Delete(maTruong);
    }

    public void Update(String maTruong, String tenTruong) {
        truongDAL.Update(maTruong, tenTruong);
    }

    public boolean TimTruong(String tenTruong,String maTruong) {
        return truongDAL.TimTruong(tenTruong, maTruong);
    }
    
    public boolean KiemTraXoaTruong(String maTruong)
    {
        return truongDAL.KiemTraXoaTruong(maTruong);
    }
}
