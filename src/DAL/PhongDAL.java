/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.LoaiNhaEntity;
import Entities.PhongEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;


public class PhongDAL {

    PreparedStatement ps;
    ResultSet rs;

    public int LayMaPhong(int tenPhong, String tenNha) {
        PhongEntity phongEntity = new PhongEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "SELECT MaPhong FROM tb_Nha inner join tb_Phong ON tb_Nha.MaNha = tb_Phong.MaNha WHERE tb_Phong.TenPhong = '" + tenPhong + "' AND tb_Nha.TenNha = N'" + tenNha + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                phongEntity.setMaPhong(rs.getInt("MaPhong"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return phongEntity.getMaPhong();
    }

    public String LayTenPhong(String MaKTX) {
        PhongEntity phongEntity = new PhongEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "select tb_Phong.TenPhong from tb_XepPhong, tb_Phong, tb_Nha"
                    + " where tb_XepPhong.MaNha = tb_Nha.MaNha and tb_XepPhong.MaPhong = tb_Phong.MaPhong and tb_XepPhong.MaKTX = '" + MaKTX + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                phongEntity.setTenPhong(rs.getString("TenPhong"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return phongEntity.getTenPhong();
    }

    public String LayTenPhongTuMaXepPhong(int MaXepPhong) {
        PhongEntity phongEntity = new PhongEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "select tb_Phong.TenPhong from tb_XepPhong, tb_Phong, tb_Nha"
                    + " where tb_XepPhong.MaNha = tb_Nha.MaNha and tb_XepPhong.MaPhong = tb_Phong.MaPhong and tb_XepPhong.MaXepPhong = '" + MaXepPhong + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                phongEntity.setTenPhong(rs.getString("TenPhong"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return phongEntity.getTenPhong();
    }

    public ArrayList<String> LayDanhSachPhong(String tenNha) {
        String sql = "SELECT TenPhong FROM tb_Phong,tb_Nha WHERE tb_Phong.MaNha = tb_Nha.MaNha and tb_Nha.TenNha = '" + tenNha + "'";
        ArrayList<String> danhSachPhong = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachPhong.add(rs.getString("TenPhong"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachPhong;
    }

    public void Delete(int maPhong) {
        String sql = "delete from tb_Phong where MaPhong = '" + maPhong + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: abc" + e.toString());
        }

    }

    public void ShowTable(Vector cols, Vector data, String tenNha) {
        String sql = "select MaPhong,TenPhong,tb_Phong.MaNha from tb_Phong,tb_Nha where tb_Phong.MaNha = tb_Nha.MaNha and TenNha = '" + tenNha + "'";
        cols.add("Mã Phòng");
        cols.add("Tên Phòng");
        cols.add("Mã Nhà");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector phong = new Vector();
                phong.addElement(rs.getInt("MaPhong"));
                phong.addElement(rs.getString("TenPhong"));
                phong.addElement(rs.getInt("MaNha"));
                data.add(phong);
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Insert(String tenPhong, int maNha) {
        String sql = "insert into tb_Phong(TenPhong,MaNha) values('" + tenPhong + "','" + maNha + "')";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }
    public boolean TimTenPhong(String tenPhong,int maNha)
    {
        String sql = "select * from tb_Phong where TenPhong = '"+tenPhong+"' and MaNha = '"+maNha+"'";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }
}
