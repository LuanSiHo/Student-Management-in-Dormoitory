/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhaDAL;
import java.util.ArrayList;
import java.util.Vector;


public class NhaBLL {

    NhaDAL nhaDAL = new NhaDAL();
    
    public int LayMaNha(String tenNha) {
        return nhaDAL.LayMaNha(tenNha);
    }
    
    public String LayTenNha(String MaKTX) {
        return nhaDAL.LayTenNha(MaKTX);
    }

    public String LayTenNhaTuMaXepPhong(int MaXepPhong) {
        return nhaDAL.LayTenNhaTuMaXepPhong(MaXepPhong);
    }
    
    public ArrayList<String> LayDanhSachNha() {
        return nhaDAL.LayDanhSachNha();
    }
    
    public void ShowTable(Vector cols, Vector data) {
        nhaDAL.ShowTable(cols, data);
    }
    
    public void Insert(String tenNha, int maLoaiNha) {
        nhaDAL.Insert(tenNha, maLoaiNha);
    }
    
    public Boolean TimNha(String tenNha) {
        return nhaDAL.TimNha(tenNha);
    }
    
    public void Delete(String tenNha) {
        nhaDAL.Delete(tenNha);
    }
    
    public void Update(String tenNha, int maNha, int maLoaiNha) {
        nhaDAL.Update(tenNha, maNha, maLoaiNha);
    }
    
    public boolean KiemTraXoaNha(String tenNha) {
        return nhaDAL.KiemTraXoaNha(tenNha);
    }
}
