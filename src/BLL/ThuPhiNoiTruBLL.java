/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThuPhiNoiTruDAL;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;


public class ThuPhiNoiTruBLL {

  ThuPhiNoiTruDAL thuPhiNoiTruDAL = new ThuPhiNoiTruDAL();

  public void ShowTable(Vector cols, Vector data, String MaKTX) {
    thuPhiNoiTruDAL.ShowTable(cols, data, MaKTX);
  }

  public void Insert(String MaKTX, String HocKy, String DaThu) {
    thuPhiNoiTruDAL.Insert(MaKTX, HocKy, DaThu);
  }

  public boolean KiemTraThuPhi(String MaKTX) {
    return thuPhiNoiTruDAL.KiemTraThuPhi(MaKTX);
  }

  public void Delete(String MaKTX) {
    thuPhiNoiTruDAL.Delete(MaKTX);
  }

  public void delete(String NamHoc) {
    thuPhiNoiTruDAL.delete(NamHoc);
  }

  public void inBienLai(String maKTX, String user) throws FileNotFoundException {
    thuPhiNoiTruDAL.inBienLai(maKTX, user);
  }

  public ArrayList<String> getNamThuPhi() {
    return thuPhiNoiTruDAL.getNamThuPhi();
  }

  public ArrayList<String> getHK(String namHoc) {
    return thuPhiNoiTruDAL.getHK(namHoc);
  }

  public void inThongKeThuPhi(String namHoc, String hocKy) {
    thuPhiNoiTruDAL.inThongKeThuPhi(namHoc, hocKy);
  }
}
