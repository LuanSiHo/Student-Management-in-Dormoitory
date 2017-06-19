/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.GhiNhanDienNuocEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class GhiNhanDienNuocDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Insert(int MaNha, int MaPhong, int thang, int nam, Date ngayChot, float SoKWDien, float SoKhoiNuoc, float ChiSoDienCuoi, float ChiSoNuocCuoi) {
        String sql = "INSERT INTO tb_GhiNhanDienNuoc(MaNha,MaPhong,Thang,Nam,NgayChot,SoKWDien,SoKhoiNuoc,ChiSoDienCuoi,ChiSoNuocCuoi) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setInt(1, MaNha);
            ps.setInt(2, MaPhong);
            ps.setInt(3, thang);
            ps.setInt(4, nam);
            ps.setDate(5, ngayChot);
            ps.setFloat(6, SoKWDien);
            ps.setFloat(7, SoKhoiNuoc);
            ps.setFloat(8, ChiSoDienCuoi);
            ps.setFloat(9, ChiSoNuocCuoi);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(int MaNha)
    {
        String sql = "delete from tb_GhiNhanDienNuoc where MaNha = '"+MaNha+"'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }
    
    
    public GhiNhanDienNuocEntity LayGhiNhanDienNuoc(int thang, int nam, int MaNha, int MaPhong) {
        String sql = "SELECT * FROM tb_GhiNhanDienNuoc  WHERE thang = '" + thang + "' AND nam = '" + nam + "' and MaNha = '" + MaNha + "' and MaPhong = '" + MaPhong + "'";
        GhiNhanDienNuocEntity ghiNhanDienNuocEntity = new GhiNhanDienNuocEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ghiNhanDienNuocEntity.setMaGhiNhan(rs.getInt("MaGhiNhan"));
                ghiNhanDienNuocEntity.setMaNha(rs.getInt("MaNha"));
                ghiNhanDienNuocEntity.setMaPhong(rs.getInt("MaPhong"));
                ghiNhanDienNuocEntity.setThang(rs.getInt("Thang"));
                ghiNhanDienNuocEntity.setNam(rs.getInt("Nam"));
                ghiNhanDienNuocEntity.setNgayChot(rs.getDate("NgayChot"));
                ghiNhanDienNuocEntity.setSoKWDien(rs.getFloat("SoKWDien"));
                ghiNhanDienNuocEntity.setSoKhoiNuoc(rs.getFloat("SoKhoiNuoc"));
                ghiNhanDienNuocEntity.setChiSoDienCuoi(rs.getFloat("ChiSoDienCuoi"));
                ghiNhanDienNuocEntity.setChiSoNuocCuoi(rs.getFloat("ChiSoNuocCuoi"));

            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return ghiNhanDienNuocEntity;
    }

    public void ShowTable(Vector cols, Vector data, String TenNha, String TenPhong) {
        String sql = "select tb_Phong.TenPhong,tb_Nha.TenNha, Thang,Nam,NgayChot,ChiSoDienCuoi,ChiSoNuocCuoi,SoKWDien,SoKhoiNuoc\n"
                + "from tb_Nha, tb_Phong,tb_GhiNhanDienNuoc\n"
                + "where tb_Nha.MaNha = tb_GhiNhanDienNuoc.MaNha and tb_Phong.MaPhong = tb_GhiNhanDienNuoc.MaPhong\n"
                + "and tb_Phong.MaNha = tb_Nha.MaNha and tb_Nha.TenNha = '" + TenNha + "' and tb_Phong.TenPhong  = '" + TenPhong + "' order by Nam DESC, Thang DESC ";
        cols.add("Phòng");
        cols.add("Nhà");
        cols.add("Tháng");
        cols.add("Năm");
        cols.add("Ngày Chốt");
        cols.add("Chỉ số điện cuối");
        cols.add("Chỉ số nước cuối");
        cols.add("Điện tiêu thụ");
        cols.add("Nước tiêu thụ");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector ghiNhaDienNuoc = new Vector();
                ghiNhaDienNuoc.addElement(rs.getString("TenPhong"));
                ghiNhaDienNuoc.addElement(rs.getString("TenNha"));
                ghiNhaDienNuoc.addElement(rs.getInt("Thang"));
                ghiNhaDienNuoc.addElement(rs.getInt("Nam"));
                ghiNhaDienNuoc.addElement(rs.getDate("NgayChot"));
                ghiNhaDienNuoc.addElement(rs.getFloat("ChiSoDienCuoi"));
                ghiNhaDienNuoc.addElement(rs.getFloat("ChiSoNuocCuoi"));
                ghiNhaDienNuoc.addElement(rs.getFloat("SoKWDien"));
                ghiNhaDienNuoc.addElement(rs.getFloat("SoKhoiNuoc"));
                data.add(ghiNhaDienNuoc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public boolean KiemTraGhiNhanDienNuoc(int MaNha, int MaPhong, int Thang, int Nam) {
        String sql = "select * from tb_GhiNhanDienNuoc where MaNha = '" + MaNha + "' and MaPhong = '" + MaPhong + "' and Thang = '" + Thang + "' and Nam = '" + Nam + "'";
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

  /**
   * Lấy dữ liệu điện nước cho column và data cho bảng dựa vào tên nhà và tên
   * phòng;
   *
   * @param cols tiêu đề cột
   * @param data dữ liệu cho bảng
   * @param tenNha tên nhà cần tìm
   * @param tenPhong tên phòng cần tìm
   */
  public void search_TraCuuDN(Vector cols, Vector data, String tenNha, String tenPhong) {
    String sql = "select distinct TenNha, TenPhong, A.Thang, A.Nam, NgayChot, ChiSoDienCuoi, SoKWDien, ChiSoNuocCuoi, SoKhoiNuoc, \n"
            + "	   tb_ThuPhiDienNuoc.TienDien, tb_ThuPhiDienNuoc.TienNuoc, tb_ThuPhiDienNuoc.TongCong, tb_ThuPhiDienNuoc.DaThu\n"
            + "from \n"
            + "	(select tb_GhiNhanDienNuoc.MaNha, tb_GhiNhanDienNuoc.MaPhong, tb_Nha.TenNha, tb_Phong.TenPhong, \n"
            + "			tb_GhiNhanDienNuoc.Thang, tb_GhiNhanDienNuoc.Nam, tb_GhiNhanDienNuoc.NgayChot,\n"
            + "			tb_GhiNhanDienNuoc.ChiSoDienCuoi, tb_GhiNhanDienNuoc.SoKWDien, tb_GhiNhanDienNuoc.ChiSoNuocCuoi,\n"
            + "			tb_GhiNhanDienNuoc.SoKhoiNuoc\n"
            + "	FROM tb_Phong,tb_Nha,tb_GhiNhanDienNuoc, tb_ThuPhiDienNuoc\n"
            + "	WHERE tb_GhiNhanDienNuoc.MaNha = tb_Nha.MaNha\n"
            + "		  AND tb_GhiNhanDienNuoc.MaPhong = tb_Phong.MaPhong) AS A left join tb_ThuPhiDienNuoc\n"
            + "	ON tb_ThuPhiDienNuoc.MaNha = A.MaNha\n"
            + "	   AND tb_ThuPhiDienNuoc.MaPhong = A.MaPhong\n"
            + "where TenNha = '" + tenNha + "'\n"
            + "	  AND TenPhong = '" + tenPhong + "'\n"
            + "ORDER BY A.Thang, A.nam";

    //Đặt tên cho cột trong bảng;
    cols.addElement("Tên nhà");
    cols.addElement("Tên phòng");
    cols.addElement("Tháng");
    cols.addElement("Năm");
    cols.addElement("Ngày chốt");
    cols.addElement("Chỉ số điện cuối");
    cols.addElement("Số KW điện");
    cols.addElement("Chỉ số nước cuối");
    cols.addElement("Số khối nước");
    cols.addElement("Tiền điện");
    cols.addElement("Tiền nước");
    cols.addElement("Tổng cộng");
    cols.addElement("Đã thu");

    //Lấy dữ liệu cho bảng;
    try {
      DataAccessHelper.getConnection();

      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        Vector rows = new Vector();
        rows.addElement(rs.getString("TenNha"));
        rows.addElement(rs.getString("TenPhong"));
        rows.addElement(rs.getString("Thang"));
        rows.addElement(rs.getString("Nam"));
        rows.addElement(rs.getString("NgayChot"));
        rows.addElement(rs.getString("ChiSoDienCuoi"));
        rows.addElement(rs.getString("SoKWDien"));
        rows.addElement(rs.getString("ChiSoNuocCuoi"));
        rows.addElement(rs.getString("SoKhoiNuoc"));
        rows.addElement(rs.getString("TienDien"));
        rows.addElement(rs.getString("TienNuoc"));
        rows.addElement(rs.getString("TongCong"));
        if (rs.getString("DaThu") == null) {
          rows.addElement("Chưa đóng");
        } else {
          rows.addElement(rs.getString("DaThu"));
        }
        System.out.println(rows.elementAt(12));

        data.add(rows);
      }

      DataAccessHelper.closeConnection();
    } catch (Exception e) {
      System.out.println("Error!: " + e.toString());
    }
  }
}
