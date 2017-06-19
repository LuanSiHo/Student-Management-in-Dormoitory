/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.QuyDinhThoiGianEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class QuyDinhThoiGianDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Update(String NamHoc, String HocKy, Date TuNgay, Date DenNgay) {
        String sql = "UPDATE tb_QuyDinhThoiGian SET NamHoc = ?, HocKy = ?, TuNgay = ?, DenNgay = ?";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, NamHoc);
            ps.setString(2, HocKy);
            ps.setDate(3, TuNgay);
            ps.setDate(4, DenNgay);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

    }

    public void ShowTable(Vector cols, Vector data) {
        String sql = "SELECT * from tb_QuyDinhThoiGian";

        cols.add("Năm Học");
        cols.add("Học Kỳ");
        cols.add("Từ Ngày");
        cols.add("Đến Ngày");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector ThoiGian = new Vector();
                ThoiGian.addElement(rs.getString("NamHoc"));
                ThoiGian.addElement(rs.getString("HocKy"));
                ThoiGian.addElement(rs.getString("TuNgay"));
                ThoiGian.addElement(rs.getString("DenNgay"));

                data.add(ThoiGian);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public QuyDinhThoiGianEntity LayThoiGian() {
        String sql = "SELECT * FROM tb_QuyDinhThoiGian";
        QuyDinhThoiGianEntity quyDinhThoiGianEntity = new QuyDinhThoiGianEntity();

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                quyDinhThoiGianEntity.setMaQuyDinh(rs.getInt("MaQuyDinh"));
                quyDinhThoiGianEntity.setNamHoc(rs.getString("NamHoc"));
                quyDinhThoiGianEntity.setHocKy(rs.getString("HocKy"));
                quyDinhThoiGianEntity.setTuNgay(rs.getDate("TuNgay"));
                quyDinhThoiGianEntity.setDenNgay(rs.getDate("DenNgay"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        } 
        return quyDinhThoiGianEntity;
    }
}
