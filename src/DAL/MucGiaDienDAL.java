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


public class MucGiaDienDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select * from tb_MucGiaDien";
        cols.add("Mã giá điện");
        cols.add("Ngày áp dụng");
        cols.add("Từ KW");
        cols.add("Đến KW");
        cols.add("Giá");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector mucGiaDien = new Vector();
                mucGiaDien.addElement(rs.getInt("MaGiaDien"));
                mucGiaDien.addElement(rs.getDate("NgayApDung"));
                mucGiaDien.addElement(rs.getInt("TuKW"));
                mucGiaDien.addElement(rs.getInt("DenKW"));
                mucGiaDien.addElement(rs.getInt("GiaDien"));
                data.add(mucGiaDien);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(int maGiaDien, Date ngayApDung, float tuKw, float denKw, String gia) {
        String sql = "update tb_MucGiaDien set NgayApDung = '" + ngayApDung + "' , TuKW = '" + tuKw + "', DenKW = '" + denKw + "', GiaDien = '" + gia + "'\n"
                + "where MaGiaDien = '" + maGiaDien + "'";
        try {

            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Hello");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

}
