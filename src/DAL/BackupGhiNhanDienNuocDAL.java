/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.GhiNhanDienNuocEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BackupGhiNhanDienNuocDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Insert(int MaNha, int MaPhong, int thang, int nam, Date ngayChot, float SoKWDien, float SoKhoiNuoc, float ChiSoDienCuoi, float ChiSoNuocCuoi) {
        String sql = "INSERT INTO tb_BackupGhiNhanDienNuoc(MaNha,MaPhong,Thang,Nam,NgayChot,SoKWDien,SoKhoiNuoc,ChiSoDienCuoi,ChiSoNuocCuoi) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setInt(1, MaNha);
            ps.setInt(2, MaPhong);
            ps.setInt(3, thang);
            ps.setInt(4, nam);
            ps.setDate(5, ngayChot);
            ps.setFloat(6, SoKWDien);
            ps.setFloat(7, SoKhoiNuoc);
            ps.setFloat(8, ChiSoDienCuoi);
            ps.setFloat(9, ChiSoNuocCuoi);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(int MaNha) {
        String sql = "delete from tb_BackupGhiNhanDienNuoc where MaNha = '" + MaNha + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public GhiNhanDienNuocEntity LayGhiNhanDienNuoc(int thang, int nam, int MaNha, int MaPhong) {
        String sql = "SELECT * FROM tb_BackupGhiNhanDienNuoc  WHERE thang = '" + thang + "' AND nam = '" + nam + "' and MaNha = '" + MaNha + "' and MaPhong = '" + MaPhong + "'";
        GhiNhanDienNuocEntity ghiNhanDienNuocEntity = new GhiNhanDienNuocEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ghiNhanDienNuocEntity.setMaGhiNhan(rs.getInt("MaGhiNhan"));
                ghiNhanDienNuocEntity.setMaNha(rs.getInt("MaNha"));
                ghiNhanDienNuocEntity.setMaPhong(rs.getInt("MaPhong"));
                ghiNhanDienNuocEntity.setThang(rs.getInt("Thang"));
                ghiNhanDienNuocEntity.setNam(rs.getInt("Nam"));
                ghiNhanDienNuocEntity.setNgayChot(rs.getDate("NgayChot"));
                ghiNhanDienNuocEntity.setSoKWDien(rs.getFloat("SoKWDien"));
                ghiNhanDienNuocEntity.setSoKhoiNuoc(rs.getFloat("SoKhoiNuoc"));
                ghiNhanDienNuocEntity.setChiSoDienCuoi(rs.getFloat("ChiSoDienCuoi"));
                ghiNhanDienNuocEntity.setChiSoNuocCuoi(rs.getFloat("ChiSoNuocCuoi"));

            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return ghiNhanDienNuocEntity;
    }

    public boolean KiemTraGhiNhanDienNuoc(int MaNha, int MaPhong, int Thang, int Nam) {
        String sql = "select * from tb_BackupGhiNhanDienNuoc where MaNha = '" + MaNha + "' and MaPhong = '" + MaPhong + "' and Thang = '" + Thang + "' and Nam = '" + Nam + "'";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }

}
