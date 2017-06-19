/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.XepPhongBLL;
import Entities.SinhVienEntity;
import Entities.XepPhongEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class XepPhongDAL {

    PreparedStatement ps;
    ResultSet rs;
    java.sql.Date sqlNgaySinh;
    java.sql.Date sqlNgayCap;

    public void ShowTable(Vector cols, Vector data, int SoNguoi, String GioiTinh, String NamHoc, String HocKy) {
        String SQL_SHOWTABLE = "select  temp.TenNha as 'Nhà', temp.TenPhong as 'Phòng', temp.SoNguoi as 'Số Người', temp.GioiTinh as 'Giới Tính'\n"
                + "                ,count(tb_XepPhong.MaKTX) as 'Đang ở' from tb_XepPhong right join (SELECT  tb_Nha.TenNha, tb_Phong.TenPhong, tb_LoaiNha.SoNguoi\n"
                + "                , tb_LoaiNha.GioiTinh, tb_Nha.MaNha, tb_Phong.MaPhong FROM tb_Nha, tb_LoaiNha,tb_Phong \n"
                + "                WHERE  tb_Nha.MaLoaiNha = tb_LoaiNha.MaLoaiNha AND tb_Nha.MaNha = tb_Phong.MaNha\n"
                + "                AND tb_LoaiNha.SoNguoi = '" + SoNguoi + "'  AND tb_LoaiNha.GioiTinh = N'" + GioiTinh + "') as temp  \n"
                + "                ON tb_XepPhong.MaPhong = temp.MaPhong AND tb_XepPhong.MaNha = temp.MaNha AND tb_XepPhong.NamHoc = '" + NamHoc + "' AND tb_XepPhong.HocKy = N'" + HocKy + "'\n"
                + "                Group by  temp.TenNha, temp.TenPhong, temp.SoNguoi, temp.GioiTinh, temp.MaNha, temp.MaPhong ";

        //tao ten cot
        cols.addElement("Nhà");
        cols.addElement("Phòng");
        cols.addElement("Số Người");
        cols.addElement("Loại Phòng");
        cols.addElement("Đang ở");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(SQL_SHOWTABLE);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector XemPhong = new Vector();
                XemPhong.addElement(rs.getString("Nhà"));
                XemPhong.addElement(rs.getString("Phòng"));
                XemPhong.addElement(rs.getString("Số Người"));
                XemPhong.addElement(rs.getString("Giới Tính"));
                XemPhong.addElement(rs.getString("Đang ở"));
                data.add(XemPhong);
            }
        } catch (Exception e) {
            System.out.println("Lỗi rồi " + e.toString());
        }

    }

    public void Insert(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        String sql = "INSERT INTO tb_XepPhong(MaKTX,MaNha,MaPhong,NamHoc,HocKy) VALUES(?,?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MaKTX);
            ps.setInt(2, MaNha);
            ps.setInt(3, MaPhong);
            ps.setString(4, NamHoc);
            ps.setString(5, HocKy);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Update(String MaKTX, int MaNha, int MaPhong, String NamHoc, String HocKy) {
        String sql = "UPDATE tb_XepPhong SET MaNha = ?, MaPhong = ? WHERE MaKTX = ? AND NamHoc = ? AND HocKy = ?";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setInt(1, MaNha);
            ps.setInt(2, MaPhong);
            ps.setString(3, MaKTX);
            ps.setString(4, NamHoc);
            ps.setString(5, HocKy);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(String MaKTX) {

        String sql = "DELETE FROM tb_XepPhong WHERE MaKTX = '" + MaKTX + "' ";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

    }

    public void Delete(int MaNha) {
        String sql = "delete from tb_XepPhong where MaNha = '" + MaNha + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void delete(int maPhong) {
        String sql = "delete from tb_XepPhong where MaPhong = '" + maPhong + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public boolean KiemTraXepPhong(int MaNha, String NamHoc) {
        String sql = "select NamHoc from tb_XepPhong where MaNha = '" + MaNha + "' and NamHoc = '" + NamHoc + "'";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }

    public boolean KiemTraXepPhong(String MaKTX, String NamHoc, String HocKy) {
        String sql = "SELECT * FROM tb_XepPhong WHERE MaKTX = ? AND NamHoc = ? AND HocKy = ?";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MaKTX);
            ps.setString(2, NamHoc);
            ps.setString(3, HocKy);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }

    public XepPhongEntity Search_XepPhong_MaKTX(String MaKTX) {
        String sql = "SELECT top 1 * FROM tb_XepPhong WHERE MaKTX = '" + MaKTX + "' order by NamHoc DESC ,HocKy  DESC";
        XepPhongEntity xepPhongEntity = new XepPhongEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xepPhongEntity.setMaXepPhong(rs.getInt("MaXepPhong"));
                xepPhongEntity.setMaKTX(rs.getString("MaKTX"));
                xepPhongEntity.setMaNha(rs.getInt("MaNha"));
                xepPhongEntity.setMaPhong(rs.getInt("MaPhong"));
                xepPhongEntity.setNamHoc(rs.getString("NamHoc"));
                xepPhongEntity.setHocKy(rs.getString("HocKy"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return xepPhongEntity;
    }

    public boolean KiemTraXepPhong(String MaKTX) {
        String sql = "SELECT count(MaXepPhong) as sl FROM tb_XepPhong WHERE MaKTX = '" + MaKTX + "'\n"
                + "group by MaKTX";
        int temp;
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                temp = rs.getInt("sl");
                if (temp > 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }

    public boolean kiemTraXepPhong(int maPhong, String NamHoc) {
        String sql = "select NamHoc from tb_XepPhong where MaPhong = '" + maPhong + "' and NamHoc = '" + NamHoc + "'";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return false;
    }

    public int KiemTraXepPhong(int maPhong, String NamHoc, String HocKy) {
        String sql = "select count(*) as sl from tb_XepPhong where MaPhong = '" + maPhong + "' and NamHoc = '" + NamHoc + "' and HocKy = '" + HocKy + "'";
        int count = 0;
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               count = rs.getInt("sl");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return count;
    }

}
