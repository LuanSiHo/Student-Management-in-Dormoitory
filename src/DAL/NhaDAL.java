/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.NhaEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;


public class NhaDAL {

    PreparedStatement ps;
    ResultSet rs;

    public int LayMaNha(String tenNha) {
        NhaEntity nhaEntity = new NhaEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "SELECT MaNha FROM tb_Nha WHERE TenNha = N'" + tenNha + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                nhaEntity.setMaNha(rs.getInt("MaNha"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return nhaEntity.getMaNha();
    }

    public String LayTenNha(String MaKTX) {
        NhaEntity nhaEntity = new NhaEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "select tb_Nha.TenNha from tb_Nha,tb_XepPhong where tb_XepPhong.MaNha = tb_Nha.MaNha and tb_XepPhong.MaKTX = '" + MaKTX + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                nhaEntity.setTenNha(rs.getString("TenNha"));
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return nhaEntity.getTenNha();
    }

    public String LayTenNhaTuMaXepPhong(int MaXepPhong) {
        NhaEntity nhaEntity = new NhaEntity();
        try {
            DataAccessHelper.getConnection();
            String SQL = "select TenNha\n"
                    + "from tb_XepPhong inner join tb_Nha ON tb_XepPhong.MaNha = tb_Nha.MaNha\n"
                    + "where MaXepPhong ='" + MaXepPhong + "'";
            ps = DataAccessHelper.con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                nhaEntity.setTenNha(rs.getString("TenNha").trim());
            }
        } catch (Exception e) {
            System.out.println("Sai roi " + e);
        }
        return nhaEntity.getTenNha();
    }

    public ArrayList<String> LayDanhSachNha() {
        String sql = "SELECT TenNha FROM tb_Nha";
        ArrayList<String> danhSachNha = new ArrayList<>();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                danhSachNha.add(rs.getString("TenNha"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return danhSachNha;
    }

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select MaNha,TenNha,SoNguoi,GioiTinh from tb_Nha inner join tb_LoaiNha on tb_Nha.MaLoaiNha = tb_LoaiNha.MaLoaiNha";
        cols.add("Mã Nhà");
        cols.add("Tên Nhà");
        cols.add("Số Người");
        cols.add("Giới Tính");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector nha = new Vector();
                nha.addElement(rs.getInt("MaNha"));
                nha.addElement(rs.getString("TenNha"));
                nha.addElement(rs.getInt("SoNguoi"));
                nha.addElement(rs.getString("GioiTinh"));
                data.add(nha);
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Insert(String tenNha, int maLoaiNha) {
        String sql = "insert into tb_Nha(TenNha,MaLoaiNha) values('" + tenNha + "','" + maLoaiNha + "')";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public Boolean TimNha(String tenNha) {
        String sql = "select * from tb_Nha where TenNha = N'" + tenNha + "'";
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

    public void Delete(String tenNha) {
        String sql = "delete  from tb_Nha where TenNha = N'" + tenNha + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(String tenNha, int maNha,int maLoaiNha) {
        String sql = "update tb_nha set TenNha = '"+tenNha+"', MaLoaiNha = '"+maLoaiNha+"' where MaNha = '"+maNha+"'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public boolean KiemTraXoaNha(String tenNha) {
        String sql = "select * from tb_Nha, tb_XepPhong\n"
                + "where tb_Nha.MaNha = tb_XepPhong.MaNha and TenNha = '" + tenNha + "'";
        String sql1 = "select * from tb_Nha, tb_GhiNhanDienNuoc,tb_ThuPhiDienNuoc\n"
                + "where tb_Nha.MaNha = tb_GhiNhanDienNuoc.MaNha and tb_Nha.MaNha = tb_ThuPhiDienNuoc.MaNha and TenNha = '" + tenNha + "'";
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

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql1);
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
