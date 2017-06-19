/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.SinhVienEntity;
import Entities.TruongEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class TruongDAL {

    //private final String SQL = "SELECT MaTruong FROM tb_Truong WHERE TenTruong = ?";
    PreparedStatement ps;
    ResultSet rs;

    public String LayMaTruong(String tenTruong) {
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "SELECT MaTruong FROM tb_Truong WHERE TenTruong = N'" + tenTruong + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                sinhVienEntity.setMaTruong(rs.getString("MaTruong"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return sinhVienEntity.getMaTruong();
    }

    public String LayTenTruong(String maTruong) {
        TruongEntity truongEntity = new TruongEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "SELECT TenTruong FROM tb_Truong WHERE MaTruong = N'" + maTruong + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                truongEntity.setTenTruong(rs.getString("TenTruong"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return truongEntity.getTenTruong();
    }

    public ArrayList<String> LayDanhSachTruong() {
        String sql = "SELECT TenTruong FROM tb_Truong";
        ArrayList<String> danhSachTruong = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachTruong.add(rs.getString("TenTruong"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachTruong;
    }

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select * from tb_Truong";
        cols.add("Mã Trường");
        cols.add("Tên Trường");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector truong = new Vector();
                truong.addElement(rs.getString("MaTruong"));
                truong.addElement(rs.getString("TenTruong"));
                data.add(truong);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Insert(String maTruong, String tenTruong) {
        String sql = "insert into tb_Truong(MaTruong,TenTruong) values ('" + maTruong + "',N'" + tenTruong + "')";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(String maTruong) {
        String sql = "delete from tb_Truong where maTruong = '" + maTruong + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(String maTruong, String tenTruong) {
        String sql = "update tb_Truong set TenTruong = N'" + tenTruong + "' where MaTruong = '" + maTruong + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public boolean TimTruong(String tenTruong,String maTruong) {
        String sql = "select * from tb_Truong where TenTruong = N'" + tenTruong + "' or MaTruong = '"+maTruong+"'";
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

    public boolean KiemTraXoaTruong(String maTruong) {
        String sql = "select * from tb_SinhVien inner join tb_Truong on tb_SinhVien.MaTruong = tb_Truong.MaTruong\n"
                + "where TenTruong = '" + maTruong + "'";
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
