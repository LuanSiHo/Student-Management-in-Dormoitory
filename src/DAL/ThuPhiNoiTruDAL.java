/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.NhaBLL;
import BLL.PhongBLL;
import BLL.QuyDinhPhiNoiTruBLL;
import BLL.TruongBLL;
import BLL.XepPhongBLL;
import Entities.QuyDinhPhiNoiTruEntity;
import Entities.ThuPhiNoiTruEntity;
import Entities.XepPhongEntity;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ThuPhiNoiTruDAL {

  PreparedStatement ps;
  ResultSet rs;

  public void ShowTable(Vector cols, Vector data, String MaKTX) {
    String sql = "select * from tb_ThuPhiNoiTru right join\n"
            + "(select  distinct tb_SinhVien.MaKTX, TenTruong,HoSinhVien,TenSinhVien,MSSV,GioiTinh,CMND,NgaySinh, MaXepPhong,TenNha,TenPhong,NamHoc,HocKy\n"
            + "from tb_SinhVien, tb_XepPhong, tb_Nha, tb_Phong, tb_Truong\n"
            + "where tb_SinhVien.MaKTX = tb_XepPhong.MaKTX and tb_XepPhong.MaNha = tb_Nha.MaNha and tb_Nha.MaNha = tb_Phong.MaNha and tb_XepPhong.MaPhong = tb_Phong.MaPhong and tb_SinhVien.MaTruong = tb_Truong.MaTruong) as temp\n"
            + "ON tb_ThuPhiNoiTru.MaXepPhong = temp.MaXepPhong where MaKTX = '" + MaKTX + "'";

    //tao ten cot
    cols.add("Họ Sinh Viên");
    cols.add("Tên Sinh Viên");
    cols.add("MSSV");
    cols.add("Trường");
    cols.add("Nhà");
    cols.add("Phòng");
    cols.add("Năm Học");
    cols.add("Học Kỳ");
    cols.add("Đã Thu");

    try {
      DataAccessHelper.getConnection();
      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        Vector ThuPhi = new Vector();

        ThuPhi.addElement(rs.getString("HoSinhVien"));
        ThuPhi.addElement(rs.getString("TenSinhVien"));
        ThuPhi.addElement(rs.getString("MSSV"));
        ThuPhi.addElement(rs.getString("TenTruong"));
        ThuPhi.addElement(rs.getString("TenNha"));
        ThuPhi.addElement(rs.getString("TenPhong"));
        ThuPhi.addElement(rs.getString("NamHoc"));
        ThuPhi.addElement(rs.getString("HocKy"));
        ThuPhi.addElement(String.valueOf(rs.getInt("SoTienThu")));
        data.add(ThuPhi);
      }

    } catch (Exception e) {
      System.out.println("Lỗi:123 " + e.toString());
    }
  }

  public void Insert(String MaKTX, String HocKy, String DaThu) {

    XepPhongBLL xepPhongBLL = new XepPhongBLL();
    QuyDinhPhiNoiTruBLL quyDinhPhiNoiTruBLL = new QuyDinhPhiNoiTruBLL();

    XepPhongEntity xepPhongEntity = xepPhongBLL.Search_XepPhong_MaKTX(MaKTX);
    java.util.Date today = new java.util.Date(System.currentTimeMillis());
    java.sql.Date sqlToday = new Date(today.getTime());

    String sql = "INSERT INTO tb_ThuPhiNoiTru(MaXepPhong,NgayThu,SoTienThu) VALUES(?,?,?)";
    try {
      ps = DataAccessHelper.con.prepareStatement(sql);
      ps.setInt(1, xepPhongEntity.getMaXepPhong());
      ps.setDate(2, sqlToday);
      ps.setString(3, String.valueOf(DaThu));
      ps.executeUpdate();

    } catch (Exception e) {
      System.out.println("Lỗi: abc" + e.toString());
    }
  }

  public void Delete(String MaKTX) {

    String sql = "delete from tb_ThuPhiNoiTru \n"
            + "where MaXepPhong IN\n"
            + "(select tb_ThuPhiNoiTru.MaXepPhong \n"
            + "from tb_ThuPhiNoiTru, tb_BackupThuPhiNoiTru, tb_XepPhong\n"
            + "where tb_ThuPhiNoiTru.MaXepPhong = tb_XepPhong.MaXepPhong and tb_XepPhong.MaKTX = tb_BackupThuPhiNoiTru.MaKTX\n"
            + "and tb_XepPhong.MaKTX = '" + MaKTX + "')";
    try {
      ps = DataAccessHelper.con.prepareStatement(sql);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("Lỗi:abc " + e.toString());
    }

  }

  public void delete(String NamHoc) {
    String sql = "delete from tb_ThuPhiNoiTru where MaXepPhong not in \n"
            + "(select MaXepPhong from tb_XepPhong where NamHoc = '" + NamHoc + "')";
    try {
      ps = DataAccessHelper.con.prepareStatement(sql);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("Lỗi:" + e.toString());
    }
  }

  public boolean KiemTraThuPhi(String MaKTX) {
    XepPhongBLL xepPhongBLL = new XepPhongBLL();
    XepPhongEntity xepPhongEntity = xepPhongBLL.Search_XepPhong_MaKTX(MaKTX);
    String sql = "SELECT * from tb_ThuPhiNoiTru where MaXepPhong = '" + xepPhongEntity.getMaXepPhong() + "'";
    try {
      DataAccessHelper.getConnection();
      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        return true;
      }
    } catch (Exception e) {
      System.out.println("Lỗi:" + e.toString());
    }
    return false;
  }

  public void inBienLai(String maKTX, String user) throws FileNotFoundException {
    String sql = "select * from tb_ThuPhiNoiTru right join\n"
            + "(select  distinct tb_SinhVien.MaKTX, TenTruong,HoSinhVien,TenSinhVien,MSSV,GioiTinh,CMND,NgaySinh, MaXepPhong,TenNha,TenPhong,NamHoc,HocKy\n"
            + "from tb_SinhVien, tb_XepPhong, tb_Nha, tb_Phong, tb_Truong\n"
            + "where tb_SinhVien.MaKTX = tb_XepPhong.MaKTX and tb_XepPhong.MaNha = tb_Nha.MaNha and tb_Nha.MaNha = tb_Phong.MaNha and tb_XepPhong.MaPhong = tb_Phong.MaPhong and tb_SinhVien.MaTruong = tb_Truong.MaTruong) as temp\n"
            + "ON tb_ThuPhiNoiTru.MaXepPhong = temp.MaXepPhong where MaKTX = '" + maKTX + "'";

    try {
      DataAccessHelper.getConnection();

      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();

      String tenSV = "";
      String hoSV = "";
      String truongSV = "";
      String phongKTX = "";
      String noiDungThu = "";
      String soTien = "";
      String ngay = "";
      String thang = "";
      String nam = "";
      String maThu = "";

      GregorianCalendar cld = new GregorianCalendar();
      ngay = String.valueOf(cld.get(GregorianCalendar.DAY_OF_MONTH));
      thang = String.valueOf(cld.get(GregorianCalendar.MONTH) + 1);
      nam = String.valueOf(cld.get(GregorianCalendar.YEAR));

      while (rs.next()) {
        hoSV = rs.getString("HoSinhVien");
        tenSV = rs.getString("TenSinhVien");
        truongSV = rs.getString("TenTruong");
        phongKTX = "Nhà " + rs.getString("TenNha").trim() + " - phòng " + rs.getString("TenPhong").trim();

        noiDungThu = "Thu lệ phí nội trú học kỳ " + rs.getString("HocKy").trim() + " năm học " + rs.getString("NamHoc").trim() + ",Tiền CSVC";
        soTien = String.valueOf(rs.getInt("SoTienThu")) + " VND";
        maThu = String.valueOf(rs.getInt("MaThuPhi"));
      }

      String currentDir = System.getProperty("user.dir");
      JasperDesign jd = JRXmlLoader.load(currentDir + "\\src\\Report\\report2.jrxml");
      JasperReport jr = JasperCompileManager.compileReport(currentDir + "\\src\\Report\\report2.jrxml");

      Map<String, Object> params = new HashMap<String, Object>();
      params.put("tenSV", hoSV + " " + tenSV);
      params.put("tenTruong", truongSV);
      params.put("phongKTX", phongKTX);
      params.put("noiDungThu", noiDungThu);
      params.put("soTien", soTien);
      params.put("ngay", ngay);
      params.put("thang", thang);
      params.put("nam", nam);
      params.put("maThu", maThu);
      params.put("currentDir", currentDir);
      params.put("user", user);

      JasperPrint jp = JasperFillManager.fillReport(jr, params, DataAccessHelper.con);
      JasperViewer.viewReport(jp, false);
      //JasperExportManager.exportReportToPdfFile(jp, "D:\\report.pdf");

      DataAccessHelper.closeConnection();
    } catch (SQLException | JRException e) {
      e.printStackTrace();
    }
  }

  /**
   * Lấy danh sách năm đã thu phí
   *
   * @return
   */
  public ArrayList<String> getNamThuPhi() {
    String sql = "select distinct NamHoc\n"
            + "from tb_XepPhong, tb_ThuPhiNoiTru\n"
            + "where tb_XepPhong.MaXepPhong = tb_ThuPhiNoiTru.MaXepPhong\n"
            + "union\n"
            + "select distinct NamHoc\n"
            + "from tb_BackupThuPhiNoiTru";
    ArrayList<String> arrlist = new ArrayList<>();
    try {
      DataAccessHelper.getConnection();

      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        arrlist.add(rs.getString("NamHoc"));
      }

      DataAccessHelper.closeConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return arrlist;
  }

  /**
   * Lấy danh sách học kỳ đã được thu phí trong năm đó
   *
   * @param namHoc
   * @return
   */
  public ArrayList<String> getHK(String namHoc) {
    String sql = "select distinct HocKy\n"
            + "from tb_XepPhong, tb_ThuPhiNoiTru\n"
            + "where tb_XepPhong.MaXepPhong = tb_ThuPhiNoiTru.MaXepPhong\n"
            + "	  and NamHoc = '" + namHoc + "'\n"
            + "union\n"
            + "select distinct HocKy\n"
            + "from tb_BackupThuPhiNoiTru\n"
            + "where NamHoc = '" + namHoc + "'";

    ArrayList<String> arrlist = new ArrayList<>();
    try {
      DataAccessHelper.getConnection();

      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        arrlist.add(rs.getString("HocKy"));
      }

      DataAccessHelper.closeConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return arrlist;
  }

  /**
   * in Thống kê các khoản thu chi của sinh viên trong ký túc xá
   *
   * @param namHoc năm học cần thống kê
   * @param hocKy học kỳ cần thống kê
   */
  public void inThongKeThuPhi(String namHoc, String hocKy) {
    String sqlNoiTru = "select sum(SoTienThu) as tongTienThu\n"
            + "from tb_BackupThuPhiNoiTru\n"
            + "where NamHoc = ?\n"
            + "	  and HocKy = ?";

    int namDN = Integer.parseInt(namHoc.substring(0, 4));

    String sqlDienNuoc = "";
    if (null != hocKy) {
      switch (hocKy) {
        case "1":
          sqlDienNuoc = "select sum(DaThu) as tienDN\n"
                  + "from tb_BackupThuPhiDienNuoc\n"
                  + "where (Nam = " + namDN + "\n"
                  + "	  and Thang in ('9','10','11','12'))\n"
                  + "	  or\n"
                  + "	  (Nam = " + (namDN + 1) + " and Thang in ('1'))";
          break;
        case "2":
          sqlDienNuoc = "select sum(DaThu) as tienDN\n"
                  + "from tb_BackupThuPhiDienNuoc\n"
                  + "where Nam = " + (namDN + 1) + "\n"
                  + "	  and Thang in ('2','3','4','5','6')";
          break;
        default:
          sqlDienNuoc = "select sum(DaThu) as tienDN\n"
                  + "from tb_BackupThuPhiDienNuoc\n"
                  + "where Nam = " + (namDN + 1) + "\n"
                  + "	  and Thang in ('7','8')";
          break;
      }
    }

    String sqlHoanTra = "";
    if (null != hocKy) {
      switch (hocKy) {
        case "1":
          sqlHoanTra = "select sum(PhiHoanTra) as tienHoanTra\n"
                  + "from tb_XuLySVRaKhoiKTX\n"
                  + "where (MONTH(NgayRaKTX) in (9,10,11,12)\n"
                  + "	  and YEAR(NgayRaKTX) = " + namDN + ")\n"
                  + "	  or (MONTH(NgayRaKTX) in (1) and YEAR(NgayRaKTX) = " + namDN + ")";
          break;
        case "2":
          sqlHoanTra = "select sum(PhiHoanTra) as tienHoanTra\n"
                  + "from tb_XuLySVRaKhoiKTX\n"
                  + "where MONTH(NgayRaKTX) in (2,3,4,5,6)\n"
                  + "	  and YEAR(NgayRaKTX) = " + (namDN + 1);
          break;
        default:
          sqlHoanTra = "select sum(PhiHoanTra) as tienHoanTra\n"
                  + "from tb_XuLySVRaKhoiKTX\n"
                  + "where MONTH(NgayRaKTX) in (7,8)\n"
                  + "	  and YEAR(NgayRaKTX) = " + (namDN + 1);
          break;
      }
    }

    try {
      DataAccessHelper.getConnection();

      ps = DataAccessHelper.con.prepareStatement(sqlNoiTru);
      //tien phi noi tru
      ps.setString(1, namHoc);
      ps.setString(2, hocKy);

      rs = ps.executeQuery();
      String tongThu = "";
      while (rs.next()) {
        tongThu = rs.getString("tongTienThu");
      }

      //tien dien nuoc
      PreparedStatement ps2 = DataAccessHelper.con.prepareStatement(sqlDienNuoc);
      ResultSet rs2 = ps2.executeQuery();

      String tienDN = "";
      while (rs2.next()) {
        tienDN = rs2.getString("tienDN");
      }

      //tien hoan tra
      PreparedStatement ps3 = DataAccessHelper.con.prepareStatement(sqlHoanTra);
      ResultSet rs3 = ps3.executeQuery();

      String tienHoanTra = "";
      while (rs3.next()) {
        tienHoanTra = rs3.getString("tienHoanTra");
      }

      GregorianCalendar gregoCal = new GregorianCalendar();
      String ngay = String.valueOf(gregoCal.get(GregorianCalendar.DAY_OF_MONTH));
      String thang = String.valueOf(gregoCal.get(GregorianCalendar.MONTH));
      String nam = String.valueOf(gregoCal.get(GregorianCalendar.YEAR));

      String currentDir = System.getProperty("user.dir");
      JasperDesign jd = JRXmlLoader.load(currentDir + "/src/Report/thongKeTongThu.jrxml");
      JasperReport jr = JasperCompileManager.compileReport(currentDir + "/src/Report/thongKeTongThu.jrxml");

      DecimalFormat df = new DecimalFormat("###,###.0000 đồng");

      Map<String, Object> params = new HashMap<>();
      params.put("nam", nam);
      params.put("thang", thang);
      params.put("ngay", ngay);
      params.put("namHoc", "HỌC KỲ " + hocKy + " " + namHoc);
      if (tongThu != null) {
        params.put("tongThu", df.format(Double.parseDouble(tongThu)));
      } else {
        params.put("tongThu", "0");
        tongThu = "0";
      }
      if (tienDN != null) {
        params.put("tienDienNuoc", df.format(Double.parseDouble(tienDN)));
      } else {
        params.put("tienDienNuoc", "0");
        tienDN = "0";
      }
      if (tienHoanTra != null) {
        params.put("tienHoanTra", df.format(Double.parseDouble(tienHoanTra)));
      } else {
        params.put("tienHoanTra", "0");
        tienHoanTra = "0";
      }

      double tongCong = Double.parseDouble(tongThu) - Double.parseDouble(tienHoanTra) + Double.parseDouble(tienDN);
      params.put("tongCong", df.format(tongCong));

      JasperPrint jp = JasperFillManager.fillReport(jr, params, DataAccessHelper.con);
      JasperViewer.viewReport(jp, false);

      DataAccessHelper.closeConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
