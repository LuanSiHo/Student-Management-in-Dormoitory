/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.XepPhongBLL;
import Entities.BackupThuPhiNoiTruEntity;
import Entities.XepPhongEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BackupThuPhiNoiTruDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Insert() {

        String sql = "INSERT INTO tb_BackupThuPhiNoiTru(MaKTX,HoSinhVien,TenSinhVien,NgaySinh,CMND, MSSV,GioiTinh,TenTruong,TenNha,TenPhong, tb_ThuPhiNoiTru.MaXepPhong,tb_ThuPhiNoiTru.MaThuPhi,NgayThu,SoTienThu,NamHoc,HocKy)\n"
                + "select tb_SinhVien.MaKTX, HoSinhVien,TenSinhVien,NgaySinh,CMND, MSSV,GioiTinh,TenTruong,TenNha,TenPhong, tb_ThuPhiNoiTru.MaXepPhong,MaThuPhi,NgayThu,SoTienThu,NamHoc,HocKy\n"
                + "from tb_SinhVien, tb_ThuPhiNoiTru, tb_Nha, tb_Phong, tb_Truong, tb_XepPhong\n"
                + "where tb_SinhVien.MaKTX = tb_XepPhong.MaKTX and tb_SinhVien.MaTruong = tb_Truong.MaTruong and tb_XepPhong.MaNha = tb_Nha.MaNha\n"
                + "and tb_XepPhong.MaPhong = tb_Phong.MaPhong and tb_Nha.MaNha = tb_Phong.MaNha and tb_XepPhong.MaXepPhong = tb_ThuPhiNoiTru.MaXepPhong\n"
                + "and tb_ThuPhiNoiTru.MaThuPhi NOT IN (SELECT MaThuPhi FROM tb_BackupThuPhiNoiTru)";

        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: xyz" + e.toString());
        }

    }

    public BackupThuPhiNoiTruEntity GetBackup(String MaKTX) {
        String sql = "SELECT top 1 * FROM tb_BackupThuPhiNoiTru WHERE MaKTX = '" + MaKTX + "' order by HocKy DESC";
        BackupThuPhiNoiTruEntity backupThuPhiNoiTruEntity = new BackupThuPhiNoiTruEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                backupThuPhiNoiTruEntity.setMaKTX(rs.getString("MaKTX"));
                backupThuPhiNoiTruEntity.setHoSinhVien(rs.getString("HoSinhVien"));
                backupThuPhiNoiTruEntity.setTenSinhVien(rs.getString("TenSinhVien"));
                backupThuPhiNoiTruEntity.setNgaySinh(rs.getDate("NgaySinh"));
                backupThuPhiNoiTruEntity.setCMND(rs.getString("CMND"));
                backupThuPhiNoiTruEntity.setMSSV(rs.getString("MSSV"));
                backupThuPhiNoiTruEntity.setGioiTinh(rs.getString("GioiTinh"));
                backupThuPhiNoiTruEntity.setTenTruong(rs.getString("TenTruong"));
                backupThuPhiNoiTruEntity.setTenNha(rs.getString("TenNha"));
                backupThuPhiNoiTruEntity.setTenPhong(rs.getString("TenPhong"));
                backupThuPhiNoiTruEntity.setMaXepPhong(rs.getInt("MaXepPhong"));
                backupThuPhiNoiTruEntity.setNamHoc(rs.getString("NamHoc"));
                backupThuPhiNoiTruEntity.setHocKy(rs.getString("HocKy"));
                backupThuPhiNoiTruEntity.setSoTienThu(rs.getString("SoTienThu"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi " + e.toString());
        }
        return backupThuPhiNoiTruEntity;

    }

    public BackupThuPhiNoiTruEntity GetBackup(String MaKTX, String NamHoc) {
        String sql = "SELECT top 1  * FROM tb_BackupThuPhiNoiTru WHERE MaKTX = '" + MaKTX + "' and NamHoc = '"+NamHoc+"' order by HocKy DESC";
        BackupThuPhiNoiTruEntity backupThuPhiNoiTruEntity = new BackupThuPhiNoiTruEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                backupThuPhiNoiTruEntity.setMaKTX(rs.getString("MaKTX"));
                backupThuPhiNoiTruEntity.setHoSinhVien(rs.getString("HoSinhVien"));
                backupThuPhiNoiTruEntity.setTenSinhVien(rs.getString("TenSinhVien"));
                backupThuPhiNoiTruEntity.setNgaySinh(rs.getDate("NgaySinh"));
                backupThuPhiNoiTruEntity.setCMND(rs.getString("CMND"));
                backupThuPhiNoiTruEntity.setMSSV(rs.getString("MSSV"));
                backupThuPhiNoiTruEntity.setGioiTinh(rs.getString("GioiTinh"));
                backupThuPhiNoiTruEntity.setTenTruong(rs.getString("TenTruong"));
                backupThuPhiNoiTruEntity.setTenNha(rs.getString("TenNha"));
                backupThuPhiNoiTruEntity.setTenPhong(rs.getString("TenPhong"));
                backupThuPhiNoiTruEntity.setMaXepPhong(rs.getInt("MaXepPhong"));
                backupThuPhiNoiTruEntity.setNamHoc(rs.getString("NamHoc"));
                backupThuPhiNoiTruEntity.setHocKy(rs.getString("HocKy"));
                backupThuPhiNoiTruEntity.setSoTienThu(rs.getString("SoTienThu"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi " + e.toString());
        }
        return backupThuPhiNoiTruEntity;
    }
}
