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


public class GhiNhanKyLuatDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Insert(String MaKTX, Date NgayGhiNhan, String MucKyLuat, String GhiChu) {
        String sql = "INSERT INTO tb_GhiNhanKyLuat(MaKTX,NgayGhiNhan,MucKyLuat,GhiChu) VALUES(?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MaKTX);
            ps.setDate(2, NgayGhiNhan);
            ps.setString(3, MucKyLuat);
            ps.setString(4, GhiChu);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select tb_SinhVien.MaKTX,HoSinhVien,TenSinhVien,MSSV,TenTruong,TenPhong,TenNha,NgayGhiNhan,MucKyLuat,GhiChu\n"
                + "from tb_SinhVien,tb_Truong,tb_GhiNhanKyLuat, tb_XepPhong,tb_Phong,tb_Nha\n"
                + "where tb_SinhVien.MaKTX = tb_GhiNhanKyLuat.MaKTX and tb_SinhVien.MaTruong = tb_Truong.MaTruong \n"
                + "and tb_SinhVien.MaKTX = tb_XepPhong.MaKTX and tb_XepPhong.MaNha = tb_Nha.MaNha and tb_XepPhong.MaPhong = tb_Phong.MaPhong\n"
                + "and tb_Nha.MaNha = tb_Phong.MaNha";

        //tao ten cot
        cols.addElement("Mã KTX");
        cols.addElement("Họ Sinh Viên");
        cols.addElement("Tên Sinh Viên");
        cols.addElement("MSSV");
        cols.addElement("Trường");
        cols.addElement("Phòng");
        cols.addElement("Nhà");
        cols.addElement("Ngày Ghi Nhận");
        cols.addElement("Mức Kỷ Luật");
        cols.addElement("Ghi Chú");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector ghiNhanKyLuat = new Vector();
                ghiNhanKyLuat.addElement(rs.getString("MaKTX"));
                ghiNhanKyLuat.addElement(rs.getString("HoSinhVien"));
                ghiNhanKyLuat.addElement(rs.getString("TenSinhVien"));
                ghiNhanKyLuat.addElement(rs.getString("MSSV"));
                ghiNhanKyLuat.addElement(rs.getString("TenTruong"));
                ghiNhanKyLuat.addElement(rs.getString("TenPhong"));
                ghiNhanKyLuat.addElement(rs.getString("TenNha"));
                ghiNhanKyLuat.addElement(rs.getString("NgayGhiNhan"));
                ghiNhanKyLuat.addElement(rs.getString("MucKyLuat"));
                ghiNhanKyLuat.addElement(rs.getString("GhiChu"));
                data.add(ghiNhanKyLuat);
            }
        } catch (Exception e) {
            System.out.println("Lỗi rồi " + e.toString());
        }

    }

    public void Delete(String MaKTX) {
        String sql = "delete from tb_GhiNhanKyLuat where MaKTX = '"+MaKTX+"'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }
}
