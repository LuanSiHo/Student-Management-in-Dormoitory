/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import doan.TinhFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;


public class TinhDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select * from tb_Tinh";
        cols.add("Mã Tỉnh");
        cols.add("Tên Tỉnh");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector tinh = new Vector();
                tinh.addElement(rs.getInt("MaTinh"));
                tinh.addElement(rs.getString("TenTinh"));
                data.add(tinh);
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public boolean TimTenTinh(String tenTinh) {
        String sql = "select * from tb_Tinh where TenTinh = N'" + tenTinh + "'";
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

    public void Insert(String tenTinh) {
        String sql = "insert into tb_Tinh(TenTinh) Values(N'" + tenTinh + "')";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(String tenTinh) {
        String sql = "delete  from tb_Tinh where TenTinh = N'" + tenTinh + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(String tenTinh,int maTinh) {
        String sql = "update   tb_Tinh set TenTinh =  N'" + tenTinh + "' where MaTinh = '"+maTinh+"' ";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public String LayTenTinh(int maTinh) {
        String sql = "Select TenTinh from tb_Tinh where MaTinh = '" + maTinh + "'";

        String tentinh = "";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tentinh = rs.getString("TenTinh");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

        return tentinh;
    }

    public int LayMaTinh(String tenTinh) {
        String sql = "Select MaTinh from tb_Tinh where TenTinh = N'" + tenTinh + "'";

        int maTinh = 0;
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maTinh = rs.getInt("MaTinh");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

        return maTinh;
    }

    public ArrayList<String> LayDanhSachTinh() {
        String sql = "SELECT TenTinh FROM tb_Tinh";
        ArrayList<String> danhSachTinh = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachTinh.add(rs.getString("TenTinh"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachTinh;
    }

    public boolean KiemTraXoaTinh(String tenTinh) {
        String sql = "select * from tb_SinhVien inner join tb_Tinh on tb_SinhVien.MaTinh = tb_Tinh.MaTinh\n"
                + "where TenTinh = N'" + tenTinh + "'";
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
