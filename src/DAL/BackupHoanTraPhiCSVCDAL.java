/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class BackupHoanTraPhiCSVCDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Insert(String maKTX, String namHoc, String phiHoanTra) {
        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlToday = new Date(today.getTime());

        String sql = "INSERT INTO tb_BackupHoanTraPhiCSVC(MaKTX,NamHoc,PhiHoanTra,NgayHoanTra) VALUES(?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, maKTX);
            ps.setString(2, namHoc);
            ps.setString(3, phiHoanTra);
            ps.setDate(4, sqlToday);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: abc" + e.toString());
        }
    }

    public void ShowTable(Vector cols, Vector data, String MaKTX, String NamHoc) {
        String sql = "select top 1 HoSinhVien,TenSinhVien, MSSV, TenTruong ,TenNha,TenPhong,tb_BackupThuPhiNoiTru.NamHoc,PhiHoanTra,NgayHoanTra\n"
                + "from tb_BackupThuPhiNoiTru left join tb_BackupHoanTraPhiCSVC on tb_BackupThuPhiNoiTru.MaKTX = tb_BackupHoanTraPhiCSVC.MaKTX\n"
                + "where tb_BackupThuPhiNoiTru.MaKTX = '" + MaKTX + "' and tb_BackupThuPhiNoiTru.NamHoc = '" + NamHoc + "' order by HocKy DESC";

        cols.add("Họ");
        cols.add("Tên");
        cols.add("MSSV");
        cols.add("Trường");
        cols.add("Nhà");
        cols.add("Phòng");
        cols.add("Năm Học");
        cols.add("Phí Hoàn Trả");
        cols.add("Ngày Hoàn Trả");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector hoanTraPhiCSVC = new Vector();
                hoanTraPhiCSVC.addElement(rs.getString("HoSinhVien"));
                hoanTraPhiCSVC.addElement(rs.getString("TenSinhVien"));
                hoanTraPhiCSVC.addElement(rs.getString("MSSV"));
                hoanTraPhiCSVC.addElement(rs.getString("TenTruong"));
                hoanTraPhiCSVC.addElement(rs.getString("TenNha"));
                hoanTraPhiCSVC.addElement(rs.getString("TenPhong"));
                hoanTraPhiCSVC.addElement(rs.getString("NamHoc"));
                hoanTraPhiCSVC.addElement(String.valueOf(rs.getInt("PhiHoanTra")));
                hoanTraPhiCSVC.addElement(rs.getDate("NgayHoanTra"));
                data.add(hoanTraPhiCSVC);
            }
        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
    }

    public boolean KiemTraHoanTraPhiCSVC(String MaKTX, String NamHoc) {
        String sql = "select * from tb_BackupHoanTraPhiCSVC where MaKTX = '" + MaKTX + "' and NamHoc = '" + NamHoc + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
        return false;
    }
}
