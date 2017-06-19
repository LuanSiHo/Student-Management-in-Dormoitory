/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.BackupThuPhiNoiTruBLL;
import BLL.QuyDinhPhiNoiTruBLL;
import BLL.ThuPhiNoiTruBLL;
import BLL.XepPhongBLL;
import BLL.XuLySinhVienRaKhoiKTXBLL;
import Entities.BackupThuPhiNoiTruEntity;
import Entities.QuyDinhPhiNoiTruEntity;
import Entities.ThuPhiNoiTruEntity;
import Entities.XepPhongEntity;
import Entities.XuLySinhVienRaKhoiKTXEntity;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


public class XuLySinhVienRaKhoiKTXDAL {

    PreparedStatement ps;
    ResultSet rs;

    public String TinhPhiHoanTra(String MaKTX) {

        QuyDinhPhiNoiTruBLL quyDinhPhiNoiTruBLL = new QuyDinhPhiNoiTruBLL();

        QuyDinhPhiNoiTruEntity quyDinhPhiNoiTruEntity = quyDinhPhiNoiTruBLL.LayPhiNoiTru(MaKTX);
        XuLySinhVienRaKhoiKTXEntity xuLySinhVienRaKhoiKTXEntity = new XuLySinhVienRaKhoiKTXEntity();

        Calendar cal = Calendar.getInstance();
        int thang = cal.get(Calendar.MONTH) + 1;
        int ngay = cal.get(Calendar.DATE);
        double phiHoanTra = 0;

        switch (thang) {
            case 1: {
                if (ngay > 15) {
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra("0");
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }

                break;
            }
            case 2: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 4;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim()));
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }
                break;

            }
            case 3: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 3;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 4;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }
                break;

            }
            case 4: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 2;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 3;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }
                break;
            }
            case 5: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 2;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }
                break;
            }
            case 6: {
                if (ngay > 15) {
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra("0");
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }
                break;
            }
            case 7: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim()));
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 2));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 2.0;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 2));
                }
                break;
            }
            case 8: {
                if (ngay > 15) {
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra("0");
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 2.0;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                }
                break;
            }
            case 9: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 4;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim()));
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                }
                break;
            }
            case 10: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 3;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 4;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                }
                break;
            }
            case 11: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 2;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 3;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra));
                }

                break;
            }
            case 12: {
                if (ngay > 15) {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                } else {
                    phiHoanTra = (Double.parseDouble(quyDinhPhiNoiTruEntity.getPhiNoiTru().trim())) / 5.0 * 2;
                    xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(String.valueOf(phiHoanTra * 5));
                }
                break;
            }
        }
        return xuLySinhVienRaKhoiKTXEntity.getPhiHoanTra();

    }

    public void Insert(String MaKTX) {
        XepPhongBLL xepPhongBLL = new XepPhongBLL();
        XepPhongEntity xepPhongEntity = xepPhongBLL.Search_XepPhong_MaKTX(MaKTX);
        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlToday = new Date(today.getTime());

        String PhiHoanTra = TinhPhiHoanTra(MaKTX);

        String sql = "INSERT INTO tb_XuLySVRaKhoiKTX(MaXepPhong,NgayRaKTX,PhiHoanTra) VALUES(?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setInt(1, xepPhongEntity.getMaXepPhong());
            ps.setDate(2, sqlToday);
            ps.setString(3, PhiHoanTra);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
    }

    public void ShowTable(Vector cols, Vector data, String MaKTX) {
        String sql = "select tb_BackupThuPhiNoiTru.MaXepPhong,HoSinhVien,TenSinhVien,MSSV,TenTruong,TenNha,TenPhong,NamHoc,HocKy,SoTienThu,PhiHoanTra\n"
                + "from tb_BackupThuPhiNoiTru left join tb_XuLySVRaKhoiKTX\n"
                + "on tb_BackupThuPhiNoiTru.MaXepPhong = tb_XuLySVRaKhoiKTX.MaXepPhong\n"
                + "where MaKTX = '" + MaKTX + "'";

        cols.add("Họ");
        cols.add("Tên");
        cols.add("MSSV");
        cols.add("Trường");
        cols.add("Nhà");
        cols.add("Phòng");
        cols.add("Năm Học");
        cols.add("Học Kỳ");
        cols.add("Đã Thu");
        cols.add("Hoàn Trả");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector HoanTraPhi = new Vector();
                HoanTraPhi.addElement(rs.getString("HoSinhVien"));
                HoanTraPhi.addElement(rs.getString("TenSinhVien"));
                HoanTraPhi.addElement(rs.getString("MSSV"));
                HoanTraPhi.addElement(rs.getString("TenTruong"));
                HoanTraPhi.addElement(rs.getString("TenNha"));
                HoanTraPhi.addElement(rs.getString("TenPhong"));
                HoanTraPhi.addElement(rs.getString("NamHoc"));
                HoanTraPhi.addElement(rs.getString("HocKy"));
                HoanTraPhi.addElement(String.valueOf(rs.getInt("SoTienThu")));
                HoanTraPhi.addElement(String.valueOf(rs.getInt("PhiHoanTra")));
                data.add(HoanTraPhi);
            }
        } catch (Exception e) {
            System.out.println("Lỗi:" + e.toString());
        }
    }

    public boolean KiemTraXuLySVRaKhoiKTX(String MaKTX) {
        BackupThuPhiNoiTruBLL backupThuPhiNoiTruBLL = new BackupThuPhiNoiTruBLL();
        BackupThuPhiNoiTruEntity backupThuPhiNoiTruEntity = backupThuPhiNoiTruBLL.GetBackup(MaKTX);
        int MaXepPhong = backupThuPhiNoiTruEntity.getMaXepPhong();
        String sql = "SELECT * FROM tb_XuLySVRaKhoiKTX WHERE MaXepPhong = '" + MaXepPhong + "'";
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

    public void inBienLaiHoanTra(String maKTX, String user) throws FileNotFoundException {
        String sql = "select tb_BackupThuPhiNoiTru.MaXepPhong,tb_XuLySVRaKhoiKTX.MaXuLy, HoSinhVien,TenSinhVien,MSSV,TenTruong,TenNha,TenPhong,NamHoc,HocKy,SoTienThu,PhiHoanTra\n"
                + "from tb_BackupThuPhiNoiTru left join tb_XuLySVRaKhoiKTX\n"
                + "on tb_BackupThuPhiNoiTru.MaXepPhong = tb_XuLySVRaKhoiKTX.MaXepPhong\n"
                + "where MaKTX = '" + maKTX + "'";

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            BackupThuPhiNoiTruBLL bkBLL = new BackupThuPhiNoiTruBLL();
            BackupThuPhiNoiTruEntity bkEntity = bkBLL.GetBackup(maKTX);

            String sotienTra = "";
            String somaThu = "";
            while (rs.next()) {
                sotienTra =String.valueOf(rs.getInt("PhiHoanTra")) ;
                somaThu = rs.getString("MaXuLy");
            }

            GregorianCalendar cld = new GregorianCalendar();
            String ngay = String.valueOf(cld.get(GregorianCalendar.DAY_OF_MONTH));
            String thang = String.valueOf(cld.get(GregorianCalendar.MONTH) + 1);
            String nam = String.valueOf(cld.get(GregorianCalendar.YEAR));

            String currentDir = System.getProperty("user.dir");

            JasperDesign jd = JRXmlLoader.load(currentDir + "/src/Report/bienlaiHoanTraPhi.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(currentDir + "/src/Report/bienlaiHoanTraPhi.jrxml");

            Map<String, Object> params = new HashMap<>();
            params.put("tenSV", bkEntity.getHoSinhVien().trim() + " " + bkEntity.getTenSinhVien().trim());
            params.put("truongSV", bkEntity.getTenTruong().trim());
            params.put("phongSV", "Nhà " + bkEntity.getTenNha().trim() + " phòng " + bkEntity.getTenPhong().trim());
            params.put("noidungThu", "Hoàn trả  phí ra khỏi KTX học kỳ " + bkEntity.getHocKy().trim() + " năm học " + bkEntity.getNamHoc().trim());
            params.put("sotienTra", sotienTra + " VND");
            params.put("ngayThu", ngay);
            params.put("thangThu", thang);
            params.put("namThu", nam);
            params.put("currentDir", currentDir);
            params.put("somaThu", somaThu);
            params.put("user", user);

            // đổ report và bật report viewer lên
            JasperPrint jp = JasperFillManager.fillReport(jr, params, DataAccessHelper.con);
            JasperViewer.viewReport(jp, false); // false để khi tắt viewer report không làm tắt toàn bộ chương trình đang chạy

            DataAccessHelper.closeConnection();
        } catch (SQLException | JRException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
