/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BackupXepPhongDAL {

    PreparedStatement ps;
    ResultSet rs;
    java.sql.Date sqlNgaySinh;
    java.sql.Date sqlNgayCap;

    public void Insert(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        String sql = "INSERT INTO tb_BackupXepPhong(MaKTX,MaNha,MaPhong,NamHoc,HocKy) VALUES(?,?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MaKTX);
            ps.setInt(2, MaNha);
            ps.setInt(3, MaPhong);
            ps.setString(4, NamHoc);
            ps.setString(5, HocKy);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        String sql = "UPDATE tb_BackupXepPhong SET MaNha = ?, MaPhong = ? WHERE MaKTX = ? AND NamHoc = ? AND HocKy = ?";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setInt(1, MaNha);
            ps.setInt(2, MaPhong);
            ps.setString(3, MaKTX);
            ps.setString(4, NamHoc);
            ps.setString(5, HocKy);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(String MaKTX) {

        String sql = "DELETE FROM tb_BackupXepPhong WHERE MaKTX = '" + MaKTX + "' ";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

    }

    public boolean KiemTraXepPhong(String MaKTX, String NamHoc, String HocKy) {
        String sql = "SELECT * FROM tb_BackupXepPhong WHERE MaKTX = ? AND NamHoc = ? AND HocKy = ?";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MaKTX);
            ps.setString(2, NamHoc);
            ps.setString(3, HocKy);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }

}
