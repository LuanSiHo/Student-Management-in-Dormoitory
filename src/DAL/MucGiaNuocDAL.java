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


public class MucGiaNuocDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select * from tb_MucGiaNuoc";
        cols.add("Mã giá nước");
        cols.add("Ngày áp dụng");
        cols.add("Từ Khối");
        cols.add("Đến Khối");
        cols.add("Giá");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector mucGiaNuoc = new Vector();
                mucGiaNuoc.addElement(rs.getInt("MaGiaNuoc"));
                mucGiaNuoc.addElement(rs.getDate("NgayApDung"));
                mucGiaNuoc.addElement(rs.getInt("TuKhoi"));
                mucGiaNuoc.addElement(rs.getInt("DenKhoi"));
                mucGiaNuoc.addElement(rs.getInt("GiaNuoc"));
                data.add(mucGiaNuoc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(int maGiaNuoc, Date ngayApDung, float tuKhoi, float denKhoi, String gia) {
        String sql = "update tb_MucGiaNuoc set NgayApDung = '" + ngayApDung + "' , TuKhoi = '" + tuKhoi + "', DenKhoi = '" + denKhoi + "', GiaNuoc = '" + gia + "'\n"
                + "where MaGiaNuoc = '" + maGiaNuoc + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Hello");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }
}
