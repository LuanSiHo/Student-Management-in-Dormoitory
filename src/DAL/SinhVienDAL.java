/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.XepPhongBLL;
import Entities.SinhVienEntity;
import Entities.XepPhongEntity;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
//import java.util.Date;

public class SinhVienDAL {

    PreparedStatement ps;
    ResultSet rs;

    java.sql.Date sqlNgaySinh;
    java.sql.Date sqlNgayCap;

    public void Insert(String MaKTX, String HoSinhVien, String TenSinhVien, Date NgaySinh, String GioiTinh, String CMND, Date NgayCap, String MSSV, String MaTruong) {

        String SQL_INSERT = "INSERT INTO tb_SinhVien(MaKTX,HoSinhVien,TenSinhVien,NgaySinh,GioiTinh,CMND,NgayCap,MSSV,MaTruong) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            sqlNgaySinh = new java.sql.Date(NgaySinh.getTime());
            sqlNgayCap = new java.sql.Date(NgayCap.getTime());

            ps = DataAccessHelper.con.prepareStatement(SQL_INSERT);
            ps.setString(1, MaKTX);
            ps.setString(2, HoSinhVien);
            ps.setString(3, TenSinhVien);
            ps.setDate(4, sqlNgaySinh);
            ps.setString(5, GioiTinh);
            ps.setString(6, CMND);
            ps.setDate(7, sqlNgayCap);
            ps.setString(8, MSSV);
            ps.setString(9, MaTruong);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void Delete(String MaKTX) {

        String sql = "DELETE FROM tb_SinhVien WHERE MaKTX = '" + MaKTX + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

    }

    public void Update(String MaKTX, String HoSinhVien, String TenSinhVien, Date NgayCap, Date NgaySinh, String SDT, String DanToc, String TonGiao, String QuocTich, int maTinh, String DiaChi, String CMND, String GioiTinh, String MSSV, String MaTruong) {

        String sql = "update tb_SinhVien set\n"
                + "HoSinhVien = N'" + HoSinhVien + "' ,TenSinhVien = N'" + TenSinhVien + "' ,NgayCap = '" + NgayCap + "' ,NgaySinh = '" + NgaySinh + "' \n"
                + ", SoDienThoai = '" + SDT + "' ,\n"
                + "DanToc = N'" + DanToc + "' ,TonGiao = N'" + TonGiao + "' , QuocTich = N'" + QuocTich + "' , MaTinh = '" + maTinh + "'\n"
                + ", DiaChiNha = N'" + DiaChi + "', CMND = '" + CMND + "', GioiTinh = N'" + GioiTinh + "' ,MSSV = '" + MSSV + "' ,MaTruong = '" + MaTruong + "' \n"
                + "where MaKTX = '" + MaKTX + "'";

        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public void ShowTable_TNSV(Vector cols, Vector data, String MaKTX) {
        String sql_ShowTable = "SELECT MaKTX,MSSV,HoSinhVien,TenSinhVien,GioiTinh,NgaySinh,CMND,NgayCap,TenTruong,STT\n"
                + "FROM tb_SinhVien INNER JOIN tb_Truong ON tb_SinhVien.MaTruong = tb_Truong.MaTruong\n"
                + "ORDER BY STT DESC";
        //tao ten cot
        cols.addElement("Mã KTX");
        cols.addElement("MSSV");
        cols.addElement("Họ Sinh Viên");
        cols.addElement("Tên Sinh Viên");
        cols.addElement("Giới Tính");
        cols.addElement("Ngày Sinh");
        cols.addElement("CMND");
        cols.addElement("Ngày Cấp");
        cols.addElement("Trường");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql_ShowTable);
            rs = ps.executeQuery();
            while (rs.next()) {

                Vector SinhVien = new Vector();
                SinhVien.addElement(rs.getString("MaKTX"));
                SinhVien.addElement(rs.getString("MSSV"));
                SinhVien.addElement(rs.getString("HoSinhVien"));
                SinhVien.addElement(rs.getString("TenSinhVien"));
                SinhVien.addElement(rs.getString("GioiTinh"));
                SinhVien.addElement(rs.getString("NgaySinh"));
                SinhVien.addElement(rs.getString("CMND"));
                SinhVien.addElement(rs.getString("NgayCap"));
                SinhVien.addElement(rs.getString("TenTruong"));
                data.add(SinhVien);
            }
        } catch (Exception e) {
            System.out.println("Lỗi rồi " + e.toString());
        }
    }

    public boolean KiemTraThemSinhVien_CMND(String CMND) {
        String sql = "SELECT * FROM tb_SinhVien WHERE CMND = ? ";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, CMND);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean KiemTraThemSinhVien_MSSV(String MSSV) {
        String sql = "SELECT * FROM tb_SinhVien WHERE MSSV = ? ";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MSSV);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean KiemTraCapNhatSinhVien(String MaKTX) {
        String sql = "select SoDienThoai,DiaChiNha,DanToc,TonGiao,QuocTich,MaTinh\n"
                + "from tb_SinhVien where MaKTX  = '" + MaKTX + "'";
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

    public boolean TimSinhVien(String MaKTX) {
        String sql = "select * from tb_SinhVien where MaKTX = '" + MaKTX + "'";
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

    public SinhVienEntity Search_SV_MaKTX(String MaKTX) {
        String sql = "SELECT * FROM tb_SinhVien WHERE tb_SinhVien.MaKTX = ?";
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setString(1, MaKTX);
            rs = ps.executeQuery();
            while (rs.next()) {
                sinhVienEntity.setMaKTX(rs.getString("MaKTX"));
                sinhVienEntity.setHoSinhVien(rs.getString("HoSinhVien"));
                sinhVienEntity.setTenSinhVien(rs.getString("TenSinhVien"));
                sinhVienEntity.setCMND(rs.getString("CMND"));
                sqlNgayCap = new Date(rs.getDate("NgayCap").getTime());
                sinhVienEntity.setNgayCap(sqlNgayCap);
                sinhVienEntity.setGioiTinh(rs.getString("GioiTinh"));
                sinhVienEntity.setMSSV(rs.getString("MSSV"));
                sinhVienEntity.setMaTruong(rs.getString("MaTruong"));
                sinhVienEntity.setQuocTich(rs.getString("QuocTich"));
                sinhVienEntity.setMaTinh(rs.getInt("MaTinh"));
                sinhVienEntity.setDanToc(rs.getString("DanToc"));
                sinhVienEntity.setTonGiao(rs.getString("TonGiao"));
                sqlNgaySinh = new Date(rs.getDate("NgaySinh").getTime());
                sinhVienEntity.setNgaySinh(sqlNgaySinh);
                sinhVienEntity.setSoDienThoai(rs.getString("SoDienThoai"));
                sinhVienEntity.setDiaChiNha(rs.getString("DiaChiNha"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi rồi " + e.toString());
        }
        return sinhVienEntity;
    }

    public void ShowTable_CapNhatThongTin(Vector cols, Vector data, String MaKTX) {
        String sql_ShowTable = "select MaKTX,MSSV,HoSinhVien,TenSinhVien,GioiTinh,NgaySinh,CMND,NgayCap,TenTruong,SoDienThoai,DiaChiNha,TenTinh,DanToc,TonGiao,QuocTich\n"
                + "from tb_Tinh right join \n"
                + "(SELECT MaKTX,MSSV,HoSinhVien,TenSinhVien,GioiTinh,NgaySinh,CMND,NgayCap,TenTruong,SoDienThoai,DiaChiNha,DanToc,MaTinh,TonGiao,QuocTich\n"
                + "from tb_SinhVien inner join tb_Truong on tb_SinhVien.MaTruong = tb_Truong.MaTruong) as temp\n"
                + "on tb_Tinh.MaTinh = temp.MaTinh\n"
                + "where MaKTX = '" + MaKTX + "'";
        //tao ten cot
        cols.addElement("Mã KTX");
        cols.addElement("MSSV");
        cols.addElement("Họ Sinh Viên");
        cols.addElement("Tên Sinh Viên");
        cols.addElement("Giới Tính");
        cols.addElement("Ngày Sinh");
        cols.addElement("CMND");
        cols.addElement("Ngày Cấp");
        cols.addElement("Trường");
        cols.addElement("SĐT");
        cols.addElement("Địa Chỉ");
        cols.addElement("Tỉnh");
        cols.addElement("Dân tộc");
        cols.addElement("Tôn giáo");
        cols.addElement("Quốc tịch");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql_ShowTable);
            rs = ps.executeQuery();
            while (rs.next()) {

                Vector SinhVien = new Vector();
                SinhVien.addElement(rs.getString("MaKTX"));
                SinhVien.addElement(rs.getString("MSSV"));
                SinhVien.addElement(rs.getString("HoSinhVien"));
                SinhVien.addElement(rs.getString("TenSinhVien"));
                SinhVien.addElement(rs.getString("GioiTinh"));
                SinhVien.addElement(rs.getString("NgaySinh"));
                SinhVien.addElement(rs.getString("CMND"));
                SinhVien.addElement(rs.getString("NgayCap"));
                SinhVien.addElement(rs.getString("TenTruong"));
                SinhVien.addElement(rs.getString("SoDienThoai"));
                SinhVien.addElement(rs.getString("DiaChiNha"));
                SinhVien.addElement(rs.getString("TenTinh"));
                SinhVien.addElement(rs.getString("DanToc"));
                SinhVien.addElement(rs.getString("TonGiao"));
                SinhVien.addElement(rs.getString("QuocTich"));
                data.add(SinhVien);
            }
        } catch (Exception e) {
            System.out.println("Lỗi rồi " + e.toString());
        }
    }

    /**
     * Hiển thị danh sách tìm kiếm sinh viên từ điều kiện cho trước
     *
     * @param cols tiêu đề mỗi cột
     * @param data dữ liệu của bảng
     * @param clue điều kiện tìm kiếm
     */
    public void search_TraCuuSV(Vector cols, Vector data, String clue) {

        String sql = "select A.MaKTX,HoSinhVien, TenSinhVien, GioiTinh, NgaySinh, MSSV, TenTruong, TenPhong, TenNha, TenTinh, DanToc, TonGiao, QuocTich\n"
                + "from\n"
                + "	(select tb_SinhVien.MaKTX,HoSinhVien, TenSinhVien, GioiTinh, NgaySinh, MSSV, TenTruong, TenPhong, TenNha, tb_SinhVien.MaTinh, DanToc, TonGiao, QuocTich\n"
                + "	 from tb_Truong,tb_SinhVien left join (select  MaKTX,TenNha, TenPhong\n"
                + "										  from tb_Phong, tb_Nha, tb_XepPhong\n"
                + "										  where tb_Phong.MaPhong = tb_XepPhong.MaPhong\n"
                + "											    AND tb_Nha.MaNha = tb_XepPhong.MaNha\n"
                + "											    AND tb_Nha.MaNha = tb_Phong.MaNha) as D ON D.MaKTX = tb_SinhVien.MaKTX\n"
                + "	 where tb_SinhVien.MaTruong = tb_Truong.MaTruong ) AS A left join tb_Tinh ON A.MaTinh = tb_Tinh.MaTinh\n"
                + "where HoSinhVien like N'%" + clue + "%'\n"
                + "	  OR TenSinhVien like N'%" + clue + "%'\n"
                + "	  OR GioiTinh like N'%" + clue + "%'\n"
                + "	  OR NgaySinh like '%" + clue + "%'\n"
                + "	  OR MSSV like '%" + clue + "%'\n"
                + "	  OR TenTruong like N'%" + clue + "%'\n"
                + "	  OR TenPhong like '%" + clue + "%'\n"
                + "	  OR TenNha like '%" + clue + "%'\n"
                + "	  OR TenTinh like N'%" + clue + "%'\n"
                + "	  OR DanToc like N'%" + clue + "%'\n"
                + "	  OR TonGiao like N'%" + clue + "%'\n"
                + "	  OR QuocTich like N'%" + clue + "%'";
        cols.addElement("Mã KTX");
        cols.addElement("Họ Sinh Viên");
        cols.addElement("Tên Sinh Viên");
        cols.addElement("Giới Tính");
        cols.addElement("Ngày Sinh");
        cols.addElement("MSSV");
        cols.addElement("Trường");
        cols.addElement("Phòng");
        cols.addElement("Nhà");
        cols.addElement("Tỉnh");
        cols.addElement("Dân Tộc");
        cols.addElement("Tôn Giáo");
        cols.addElement("Quốc Tịch");

        try {
            DataAccessHelper.getConnection();

            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next() == true) {
                Vector SinhVien = new Vector();

                SinhVien.addElement(rs.getString("MaKTX"));
                SinhVien.addElement(rs.getString("HoSinhVien"));
                SinhVien.addElement(rs.getString("TenSinhVien"));
                SinhVien.addElement(rs.getString("GioiTinh"));
                SinhVien.addElement(rs.getString("NgaySinh"));
                SinhVien.addElement(rs.getString("MSSV"));
                SinhVien.addElement(rs.getString("TenTruong"));
                SinhVien.addElement(rs.getString("TenPhong"));
                SinhVien.addElement(rs.getString("TenNha"));
                SinhVien.addElement(rs.getString("TenTinh"));
                SinhVien.addElement(rs.getString("DanToc"));
                SinhVien.addElement(rs.getString("TonGiao"));
                SinhVien.addElement(rs.getString("QuocTich"));
                data.add(SinhVien);
            }
            DataAccessHelper.closeConnection();

        } catch (Exception e) {
            System.out.println("Error: abc " + e.toString());
        }

    }

    /**
     * Dùng để đổ dữ liệu sinh viên vào table với điều kiện tìm kiếm theo Tên
     * Nhà và Tên Phòng;
     *
     * @param cols tiêu đề của mỗi cột
     * @param data dữ liệu trong bảng
     * @param tenNha tên nhà cho trước;
     * @param tenPhong tên phòng cho trước;
     */
    public void searchSV_Nha_Phong(Vector cols, Vector data, String tenNha, String tenPhong) {
        String sql = "select HoSinhVien,TenSinhVien,GioiTinh, MSSV,TenTruong, NgaySinh,TenNha,TenPhong,NamHoc,HocKy  from tb_ThuPhiNoiTru right join\n"
                + "(select  distinct tb_SinhVien.MaKTX, TenTruong,HoSinhVien,TenSinhVien,MSSV,GioiTinh,CMND,NgaySinh, tb_XepPhong.MaXepPhong,TenNha,TenPhong,NamHoc,HocKy\n"
                + "from tb_SinhVien, tb_XepPhong, tb_Nha, tb_Phong, tb_Truong\n"
                + "where tb_SinhVien.MaKTX = tb_XepPhong.MaKTX and tb_XepPhong.MaNha = tb_Nha.MaNha and tb_Nha.MaNha = tb_Phong.MaNha and tb_XepPhong.MaPhong = tb_Phong.MaPhong and tb_SinhVien.MaTruong = tb_Truong.MaTruong) as temp\n"
                + "ON tb_ThuPhiNoiTru.MaXepPhong = temp.MaXepPhong\n"
                + "where temp.TenNha = '" + tenNha + "' and temp.TenPhong = '" + tenPhong + "' "
                + "order by NamHoc, HocKy";

        cols.addElement((String) "Họ sinh viên");
        cols.addElement((String) "Tên sinh viên");
        cols.addElement((String) "Giới tính");
        cols.addElement((String) "MSSV");
        cols.addElement((String) "Trường");
        cols.addElement((String) "Ngày Sinh");
        cols.addElement((String) "Tên nhà");
        cols.addElement((String) "Tên phòng");
        cols.addElement((String) "Năm học");
        cols.addElement((String) "Học kỳ");

        try {
            DataAccessHelper.getConnection();

            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector rows = new Vector();

                rows.addElement(rs.getString("HoSinhVien"));
                rows.addElement(rs.getString("TenSinhVien"));
                rows.addElement(rs.getString("GioiTinh"));
                rows.addElement(rs.getString("MSSV"));
                rows.addElement(rs.getString("TenTruong"));
                rows.addElement(rs.getString("NgaySinh"));
                rows.addElement(rs.getString("TenNha"));
                rows.addElement(rs.getString("TenPhong"));
                rows.addElement(rs.getString("NamHoc"));
                rows.addElement(rs.getString("HocKy"));

                data.add(rows);
            }

            DataAccessHelper.closeConnection();
        } catch (Exception e) {
            System.out.println("Error!: " + e.getMessage());
        }
    }

    /**
     * In thống kê sinh vien từng trường theo năm học hiện tại
     *
     * @param namHoc năm học cần thống kê
     */
    public void inThongKeTheoTruong(String namHoc) throws FileNotFoundException {
        String sql = "select *\n"
                + "from (select COUNT(MaKTX) as SoSinhVienVao\n"
                + "	from tb_BackupThuPhiNoiTru\n"
                + "	where NamHoc = '" + namHoc + "') as D,\n"
                + "	(select COUNT(MaKTX) as SoSinhVienRa\n"
                + "	from tb_BackupThuPhiNoiTru\n"
                + "	where tb_BackupThuPhiNoiTru.MaKTX not in (select MaKTX\n"
                + "											  from tb_SinhVien)\n"
                + "		  and tb_BackupThuPhiNoiTru.NamHoc = '" + namHoc + "') as C";

        try {
            DataAccessHelper.getConnection();

            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            String tongVao = "";
            String tongRa = "";

            while (rs.next()) {
                tongVao = rs.getString("SoSinhVienVao");
                tongRa = rs.getString("SoSinhVienRa");
            }

            String currentDir = System.getProperty("user.dir");
            JasperDesign jd = JRXmlLoader.load(currentDir + "\\src\\Report\\thongketheotruong.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(currentDir + "\\src\\Report\\thongketheotruong.jrxml");

            Map<String, Object> params = new HashMap<>();
            params.put("nam", namHoc);
            params.put("tongVao", tongVao);
            params.put("tongRa", tongRa);

            JasperPrint jp = JasperFillManager.fillReport(jr, params, DataAccessHelper.con);
            JasperViewer.viewReport(jp, false);
            //JasperExportManager.exportReportToPdfFile(jp, "D:\\report.pdf");

            DataAccessHelper.closeConnection();
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }

    /**
     * Thống kê sinh viên theo nhà
     *
     * @param namHoc năm học cần thống kê
     */
    public void inThongKeTheoNha(String namHoc) throws FileNotFoundException {

        try {
            DataAccessHelper.getConnection();

            String currentDir = System.getProperty("user.dir");
            JasperDesign jd = JRXmlLoader.load(currentDir + "\\src\\Report\\thongKeTheoNha.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(currentDir + "\\src\\Report\\thongKeTheoNha.jrxml");

            Map<String, Object> params = new HashMap<>();
            params.put("namHoc", namHoc);

            JasperPrint jp = JasperFillManager.fillReport(jr, params, DataAccessHelper.con);
            JasperViewer.viewReport(jp, false);
            //JasperExportManager.exportReportToPdfFile(jp, "D:\\report.pdf");

            DataAccessHelper.closeConnection();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
