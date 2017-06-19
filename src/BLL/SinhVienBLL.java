/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SinhVienDAL;
import Entities.SinhVienEntity;
import java.io.FileNotFoundException;
//import java.util.Date;
import java.sql.Date;
import java.util.Vector;

public class SinhVienBLL {

  SinhVienDAL sinhVien = new SinhVienDAL();

  public void Insert(String MaKTX, String HoSinhVien, String TenSinhVien, Date NgaySinh, String GioiTinh, String CMND, Date NgayCap, String MSSV, String MaTruong) {
    sinhVien.Insert(MaKTX, HoSinhVien, TenSinhVien, NgaySinh, GioiTinh, CMND, NgayCap, MSSV, MaTruong);
  }

  public void Delete(String MaKTX) {
    sinhVien.Delete(MaKTX);
  }

  public void ShowTable(Vector cols, Vector data, String MaKTX) {
    sinhVien.ShowTable_TNSV(cols, data, MaKTX);
  }

  public boolean KiemTraThemSinhVien_CMND(String CMND) {
    return sinhVien.KiemTraThemSinhVien_CMND(CMND);
  }

  public boolean KiemTraThemSinhVien_MSSV(String MSSV) {
    return sinhVien.KiemTraThemSinhVien_MSSV(MSSV);
  }

  public boolean TimSinhVien(String MaKTX) {
    return sinhVien.TimSinhVien(MaKTX);
  }

  public SinhVienEntity Search_SV_MaKTX(String MaKTX) {
    return sinhVien.Search_SV_MaKTX(MaKTX);
  }

  public void ShowTable_CapNhatThongTin(Vector cols, Vector data, String MaKTX) {
    sinhVien.ShowTable_CapNhatThongTin(cols, data, MaKTX);
  }

  public void Update(String MaKTX, String HoSinhVien, String TenSinhVien, Date NgayCap, Date NgaySinh, String SDT, String DanToc, String TonGiao, String QuocTich, int maTinh, String DiaChi, String CMND, String GioiTinh, String MSSV, String MaTruong) {
    sinhVien.Update(MaKTX, HoSinhVien, TenSinhVien, NgayCap, NgaySinh, SDT, DanToc, TonGiao, QuocTich, maTinh, DiaChi, CMND, GioiTinh, MSSV, MaTruong);
  }

  public void search_TraCuuSV(Vector cols, Vector data, String clue) {
    sinhVien.search_TraCuuSV(cols, data, clue);
  }

  public void searchSV_Nha_Phong(Vector cols, Vector data, String tenNha, String tenPhong) {
    sinhVien.searchSV_Nha_Phong(cols, data, tenNha, tenPhong);
  }

  public boolean KiemTraCapNhatSinhVien(String MaKTX) {
    return sinhVien.KiemTraCapNhatSinhVien(MaKTX);
  }

  public void inThongKeTheoTruong(String namHoc) throws FileNotFoundException {
    sinhVien.inThongKeTheoTruong(namHoc);
  }

  public void inThongKeTheoNha(String namHoc) throws FileNotFoundException {
    sinhVien.inThongKeTheoNha(namHoc);
  }
}
