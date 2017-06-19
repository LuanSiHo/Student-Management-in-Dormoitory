/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;


public class QuyDinhMucKyLuatDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select * from tb_QuyDinhMucKyLuat";
        cols.add("Mã Kỷ Luật");
        cols.add("Tên Kỷ Luật");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector mucKyLuat = new Vector();
                mucKyLuat.addElement(rs.getInt("MaKyLuat"));
                mucKyLuat.addElement(rs.getString("TenKyLuat"));
                data.add(mucKyLuat);
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Insert(String tenKyLuat) {
        String sql = "insert into tb_QuyDinhMucKyLuat(TenKyLuat) Values(N'" + tenKyLuat + "')";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(String tenKyLuat) {
        String sql = "delete  from tb_QuyDinhMucKyLuat where TenKyLuat = N'" + tenKyLuat + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(String tenKyLuat, int maKyLuat) {
        String sql = "update   tb_QuyDinhMucKyLuat set TenKyLuat =  N'" + tenKyLuat + "' where MaKyLuat = '" + maKyLuat + "' ";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public ArrayList<String> LayDanhSachMucKyLuat() {
        String sql = "SELECT TenKyLuat FROM tb_QuyDinhMucKyLuat";
        ArrayList<String> danhSachMucKyLuat = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachMucKyLuat.add(rs.getString("TenKyLuat"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachMucKyLuat;
    }

    public boolean TimTenKyLuat(String tenKyLuat) {
        String sql = "select * from tb_QuyDinhMucKyLuat where TenKyLuat = N'" + tenKyLuat + "'";
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
