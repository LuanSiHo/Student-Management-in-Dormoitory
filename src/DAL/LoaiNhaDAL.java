/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.LoaiNhaEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LoaiNhaDAL {

    PreparedStatement ps;
    ResultSet rs;

    public String LayGioiTinh_Phong(int MaPhong) {
        LoaiNhaEntity loaiNhaEntity = new LoaiNhaEntity();
        String sql = "select GioiTinh from tb_Phong,tb_Nha,tb_LoaiNha\n"
                + "where tb_Phong.MaNha = tb_Nha.MaNha and tb_Nha.MaLoaiNha = tb_LoaiNha.MaLoaiNha and MaPhong = '" + MaPhong + "'";
        try {
            DataAccessHelper.getConnection();

            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                loaiNhaEntity.setGioiTinh(rs.getString("GioiTinh"));
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return loaiNhaEntity.getGioiTinh();
    }

    public LoaiNhaEntity LayLoaiNha(String tenNha) {
        LoaiNhaEntity loaiNhaEntity = new LoaiNhaEntity();
        try {
            DataAccessHelper.getConnection();
            String sql = "SELECT * FROM tb_Nha inner join tb_LoaiNha ON tb_Nha.MaLoaiNha = tb_LoaiNha.MaLoaiNha AND tb_Nha.TenNha = '" + tenNha + "'";
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                loaiNhaEntity.setSoNguoi(rs.getInt("SoNguoi"));
            }

        } catch (Exception e) {
        }
        return loaiNhaEntity;
    }

    public ArrayList<Integer> LaySoNguoi() {
        String sql = "select distinct SoNguoi from tb_LoaiNha";
        ArrayList<Integer> danhSachSonguoi = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachSonguoi.add(rs.getInt("SoNguoi"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachSonguoi;

    }

    public ArrayList<String> LayGioiTinh() {
        String sql = "select distinct GioiTinh from tb_LoaiNha";
        ArrayList<String> danhSachGioiTinh = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachGioiTinh.add(rs.getString("GioiTInh"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachGioiTinh;
    }

    public int LayMaLoaiNha(int soNguoi, String gioiTinh) {
        int maLoaiNha = 0;
        String sql = "Select MaLoaiNha from tb_LoaiNha where SoNguoi = '" + soNguoi + "' and GioiTinh = N'" + gioiTinh + "'";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maLoaiNha = rs.getInt("MaLoaiNha");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return maLoaiNha;
    }
}
