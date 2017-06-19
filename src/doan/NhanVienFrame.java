/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import BLL.BackupHoanTraPhiCSVCBLL;
import BLL.BackupThuPhiDienNuocBLL;
import BLL.BackupThuPhiNoiTruBLL;
import BLL.BackupXepPhongBLL;
import BLL.GhiNhanDienNuocBLL;
import BLL.GhiNhanKyLuatBLL;
import BLL.HoanTraPhiCSVCBLL;
import BLL.LoaiNhaBLL;
import BLL.NhaBLL;
import BLL.PhongBLL;
import BLL.QuyDinhPhiNoiTruBLL;
import BLL.QuyDinhThoiGianBLL;
import BLL.SinhVienBLL;
import BLL.ThuPhiDienNuocBLL;
import BLL.ThuPhiNoiTruBLL;
import BLL.TinhBLL;
import BLL.TruongBLL;
import BLL.XepPhongBLL;
import BLL.XuLySinhVienRaKhoiKTXBLL;
import Entities.BackupThuPhiNoiTruEntity;
import Entities.GhiNhanDienNuocEntity;
import Entities.LoaiNhaEntity;
import Entities.NhaEntity;
import Entities.PhongEntity;
import Entities.QuyDinhPhiNoiTruEntity;
import Entities.QuyDinhThoiGianEntity;
import Entities.SinhVienEntity;
import Entities.ThuPhiDienNuocEntity;
import Entities.ThuPhiNoiTruEntity;
import Entities.TruongEntity;
import Entities.XepPhongEntity;
import Entities.XuLySinhVienRaKhoiKTXEntity;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class NhanVienFrame extends javax.swing.JFrame {

    /**
     * Creates new form NhanVienFrame
     */
    public NhanVienFrame() {
        initComponents();
        setLocationRelativeTo(null);
        ShowComboBoxTruong_TabTiepNhanSV();
        ShowComboBoxNamHoc_HocKy_TabXepPhong();
        showComboBoxNha_ThuPhiDienNuoc();
        showComboBoxNha_TraCuuPhong();
        showComboBoxNha_TraCuuDN();
        ShowCombobox_Tinh_CapNhatThongTinSV();
        ShowComboBoxTruong_CapNhatThongTinSV();
        ShowComboBoxNamHoc_HoanTraPhiCSVC();
        showComboBox_Namhoc_ThongKe();
        btn_QLSV_XepPhong_ThuPhi.setVisible(false);
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setVisible(false);
    }

    public NhanVienFrame(String username) {
        initComponents();
        this.username = username;
        setLocationRelativeTo(null);
        ShowComboBoxTruong_TabTiepNhanSV();
        ShowComboBoxNamHoc_HocKy_TabXepPhong();
        showComboBoxNha_ThuPhiDienNuoc();
        showComboBoxNha_TraCuuPhong();
        showComboBoxNha_TraCuuDN();
        ShowCombobox_Tinh_CapNhatThongTinSV();
        ShowComboBoxTruong_CapNhatThongTinSV();
        ShowComboBoxNamHoc_HoanTraPhiCSVC();
        showComboBox_Namhoc_ThongKe();
        btn_QLSV_XepPhong_ThuPhi.setVisible(false);
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setVisible(false);
    }

    private String MaKTX = "";
    private String username = "N/A";

    public void ShowTableTiepNhanSV(String MaKTX) {
        SinhVienBLL tiepNhanSVBLL = new SinhVienBLL();
        Vector cols = new Vector();
        Vector data = new Vector();
        tiepNhanSVBLL.ShowTable(cols, data, MaKTX);
        tb_QLSV_TiepNhanSV.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }

        });

    }

    public void ShowTableXepPhong(int SoNguoi, String GioiTinh, String NamHoc, String HocKy) {
        XepPhongBLL xepPhognBLL = new XepPhongBLL();
        Vector cols = new Vector();
        Vector data = new Vector();
        xepPhognBLL.ShowTable(cols, data, SoNguoi, GioiTinh, NamHoc, HocKy);
        tb_QLSV_XepPhong.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }

        });

    }

    public void ShowTable_ThuPhiNoiTru(String MaKTX) {
        ThuPhiNoiTruBLL thuPhiNoiTruBLL = new ThuPhiNoiTruBLL();
        Vector cols = new Vector();
        Vector data = new Vector();
        thuPhiNoiTruBLL.ShowTable(cols, data, MaKTX);
        tb_ThuPhi_PhiNoiTru.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }
        });

    }

    public void ShowTable_XuLySinhVienRaKhoiKTX(String MaKTX) {

        XuLySinhVienRaKhoiKTXBLL xuLySinhVienRaKhoiKTXBLL = new XuLySinhVienRaKhoiKTXBLL();

        Vector cols = new Vector();
        Vector data = new Vector();
        xuLySinhVienRaKhoiKTXBLL.ShowTable(cols, data, MaKTX);
        tb_QLSV_XuLySVKhoiKTX.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }
        });
    }

    public void showTable_ThuPhiDienNuoc(String TenNha, String TenPhong) {

        ThuPhiDienNuocBLL thuPhiDienNuocBLL = new ThuPhiDienNuocBLL();
        Vector cols = new Vector();
        Vector data = new Vector();

        thuPhiDienNuocBLL.ShowTable(cols, data, TenNha, TenPhong);
        tb_ThuPhiDienNuoc.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }
        });
    }

    public void ShowTable_TraCuuSinhVien(String clue) {

        SinhVienBLL svBLL = new SinhVienBLL();

        Vector cols = new Vector();
        Vector data = new Vector();

        svBLL.search_TraCuuSV(cols, data, clue);

        tb_TraCuu_SinhVien.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }
        });
    }

    /**
     * Hiện danh sách sinh viên theo tên Nhà và tên Phòng cho trước vào trong
     * bảng jTable7;
     *
     * @param tenNha tên nhà cần tìm;
     * @param tenPhong tên phòng cần tìm;
     */
    public void ShowTable_TraCuuPhong(String tenNha, String tenPhong) {
        SinhVienBLL svBLL = new SinhVienBLL();

        Vector cols = new Vector();
        Vector data = new Vector();

        svBLL.searchSV_Nha_Phong(cols, data, tenNha, tenPhong);
        tb_TraCuu_ThongTinPhong.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int colIndex) {
                Vector rowsData = (Vector) (data.elementAt(rowIndex));
                return rowsData.elementAt(colIndex);
            }

            @Override
            public String getColumnName(int col) {
                return (String) cols.elementAt(col);
            }
        });
    }

    public void ShowTable_HoanTraPhiCSVC(String maKTX, String namHoc) {
        Vector cols = new Vector();
        Vector data = new Vector();

        BackupHoanTraPhiCSVCBLL backupHoanTraPhiCSVCBLL = new BackupHoanTraPhiCSVCBLL();
        backupHoanTraPhiCSVCBLL.ShowTable(cols, data, maKTX, namHoc);
        tb_HoanTraPhiCSVC.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int colIndex) {
                Vector rowsData = (Vector) (data.elementAt(rowIndex));
                return rowsData.elementAt(colIndex);
            }

            @Override
            public String getColumnName(int col) {
                return (String) cols.elementAt(col);
            }
        });
    }

    /**
     * Phương thức hiện thông tin điện nước theo nhà và phòng lên trên bảng;
     *
     * @param tenNha tên nhà cần tìm;
     * @param tenPhong tên phòng cần tìm;
     */
    public void showTable_TraCuuDN(String tenNha, String tenPhong) {

        GhiNhanDienNuocBLL dnBLL = new GhiNhanDienNuocBLL();

        Vector cols = new Vector();
        Vector data = new Vector();

        dnBLL.search_TraCuuDN(cols, data, tenNha, tenPhong);

        tb_TraCuuDienNuoc.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int colIndex) {
                Vector row = (Vector) data.elementAt(rowIndex);
                return row.elementAt(colIndex);
            }

            @Override
            public String getColumnName(int col) {
                return (String) cols.elementAt(col);
            }
        });

    }

    public void ShowTable_CapNhatThongTinSinhVien(String MaKTX) {
        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        Vector cols = new Vector();
        Vector data = new Vector();
        sinhVienBLL.ShowTable_CapNhatThongTin(cols, data, MaKTX);
        tb_CapNhatThongTinSinhVien.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return cols.size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Vector rowData = (Vector) (data.elementAt(rowIndex));
                return rowData.elementAt(columnIndex);
            }

            @Override
            public String getColumnName(int column) {
                return (String) cols.elementAt(column);
            }

        });
    }

    public void ShowComboBoxTruong_TabTiepNhanSV() {
        TruongBLL truongBLL = new TruongBLL();
        ArrayList<String> danhSachTruong = truongBLL.LayDanhSachTruong();
        for (int i = 0; i < danhSachTruong.size(); i++) {
            cb_QLSV_TiepNhanSV_ThongTin_Truong.addItem(danhSachTruong.get(i));
        }
    }

    public void ShowComboBoxNamHoc_HocKy_TabXepPhong() {
        QuyDinhThoiGianBLL quyDinhThoiGianBLL = new QuyDinhThoiGianBLL();
        QuyDinhThoiGianEntity quyDinhThoiGianEntity = quyDinhThoiGianBLL.LayThoiGian();

        cb_QLSV_XepPhong_NamHoc.addItem(quyDinhThoiGianEntity.getNamHoc());
        cb_QLSV_XepPhong_HocKy.addItem(quyDinhThoiGianEntity.getHocKy());

    }

    public void showComboBoxNha_ThuPhiDienNuoc() {
        NhaBLL nhaBLL = new NhaBLL();
        ArrayList<String> danhSachNha = nhaBLL.LayDanhSachNha();
        for (int i = 0; i < danhSachNha.size(); i++) {
            cb_ThuPhi_PhiDienNuoc_KhoiNha.addItem(danhSachNha.get(i));
        }
    }

    public void showComboBoxPhong_ThuPhiDienNuoc(String tenNha) {
        PhongBLL phongBLL = new PhongBLL();
        ArrayList<String> danhSachPhong = phongBLL.LayDanhSachPhong(tenNha);
        for (int i = 0; i < danhSachPhong.size(); i++) {
            cb_ThuPhi_PhiDienNuoc_Phong.addItem(danhSachPhong.get(i));
        }
    }

    /**
     * Hiển thị năm học cho combobox thống kê thu phí
     */
    private void showComboBox_Namhoc_ThongKe() {
        ThuPhiNoiTruBLL tpnt = new ThuPhiNoiTruBLL();
        ArrayList<String> arr = tpnt.getNamThuPhi();
        for (int i = 0; i < arr.size(); i++) {
            cb_ThongKeTongThu_NamHoc.addItem(arr.get(i));
        }
    }

    /**
     * Lấy học kỳ theo năm học có thể thống kê;
     *
     * @param namHoc năm học cần lấy;
     */
    private void showCombobox_HocKy_ThongKe(String namHoc) {
        ThuPhiNoiTruBLL tpnt = new ThuPhiNoiTruBLL();
        ArrayList<String> arr = tpnt.getHK(namHoc);
        for (int i = 0; i < arr.size(); i++) {
            cb_ThongKeTongThu_HocKy.addItem(arr.get(i));
        }
    }

    /**
     * Phương thức lấy danh sách nhà đổ vào comboBox;
     *
     * @param comboBox
     */
    public void showComboBoxNha_TraCuuPhong() {
        NhaBLL nhaBLL = new NhaBLL();
        ArrayList<String> danhSachNha = nhaBLL.LayDanhSachNha();
        for (int i = 0; i < danhSachNha.size(); i++) {
            cb_TraCuu_ThongTinPhong_Nha.addItem(danhSachNha.get(i));
        }
    }

    /**
     * Phương thức lấy danh sách phòng dựa vào nhà cho trước đổ vào comboBox;
     *
     * @param tenNha
     * @param comboBox
     */
    public void showComboBoxPhong_TraCuuPhong(String tenNha) {
        PhongBLL phongBLL = new PhongBLL();
        ArrayList<String> danhSachPhong = phongBLL.LayDanhSachPhong(tenNha);
        for (int i = 0; i < danhSachPhong.size(); i++) {
            cb_TraCuu_ThongTinPhong_Phong.addItem(danhSachPhong.get(i));
        }
    }

    /**
     * Hiện combobox nhà của tra cứu điện nước
     */
    public void showComboBoxNha_TraCuuDN() {
        NhaBLL nhaBLL = new NhaBLL();
        ArrayList<String> danhSachNha = nhaBLL.LayDanhSachNha();
        for (int i = 0; i < danhSachNha.size(); i++) {
            cb_TraCuuDienNuoc_Nha.addItem(danhSachNha.get(i));
        }
    }

    /**
     * Hiện combobox phòng của tra cứu điện nước
     *
     * @param tenNha
     */
    public void showComboBoxPhong_TraCuuDN(String tenNha) {
        PhongBLL phongBLL = new PhongBLL();
        ArrayList<String> danhSachPhong = phongBLL.LayDanhSachPhong(tenNha);
        for (int i = 0; i < danhSachPhong.size(); i++) {
            cb_TraCuuDienNuoc_Phong.addItem(danhSachPhong.get(i));
        }
    }

    public void ShowCombobox_Tinh_CapNhatThongTinSV() {
        TinhBLL tinhBLL = new TinhBLL();
        ArrayList<String> danhSachTinh = tinhBLL.LayDanhSachTinh();
        for (int i = 0; i < danhSachTinh.size(); i++) {
            cb_CapNhatThongTinSV_ThongTin_Tinh.addItem(danhSachTinh.get(i));
        }
    }

    public void ShowComboBoxTruong_CapNhatThongTinSV() {
        TruongBLL truongBLL = new TruongBLL();
        ArrayList<String> danhSachTruong = truongBLL.LayDanhSachTruong();
        for (int i = 0; i < danhSachTruong.size(); i++) {
            cb_CapNhatThongTinSV_Truong.addItem(danhSachTruong.get(i));
        }
    }

    public void ShowComboBoxNamHoc_HoanTraPhiCSVC() {
        QuyDinhThoiGianBLL quyDinhThoiGianBLL = new QuyDinhThoiGianBLL();
        QuyDinhThoiGianEntity quyDinhThoiGianEntity = quyDinhThoiGianBLL.LayThoiGian();
        HoanTraPhiCSVCBLL hoanTraPhiCSVCBLL = new HoanTraPhiCSVCBLL();
        String namHoc = hoanTraPhiCSVCBLL.layNamHoc(quyDinhThoiGianEntity.getNamHoc());
        cb_HoanTraPhiCSVC_NamHoc.addItem(namHoc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnGroup_QLSV_TiepNhanSV_GioiTinh = new javax.swing.ButtonGroup();
        tab_Main = new javax.swing.JTabbedPane();
        scrollPanel_HeThong = new javax.swing.JScrollPane();
        tab_HeThong = new javax.swing.JTabbedPane();
        pn_HeThong_QuanLyDanhMuc = new javax.swing.JPanel();
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc = new javax.swing.JLabel();
        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc = new javax.swing.JPanel();
        btn_HeThong_QuanLyDanhMuc_Tinh = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_Truong = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_KhoiNha = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_ThoiGian = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_MucGiaDien = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_MucGiaNuoc = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_MucPhiKTX = new javax.swing.JButton();
        btn_HeThong_QuanLyDanhMuc_Phong = new javax.swing.JButton();
        pn_HeThong_TaiKhoan = new javax.swing.JPanel();
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan = new javax.swing.JLabel();
        pn_HeThong_TaiKhoan_ThongTin = new javax.swing.JPanel();
        btn_HeThong_TaiKhoan_TaoTaiKhoan = new javax.swing.JButton();
        btn_HeThong_TaiKhoan_DoiMatKhau = new javax.swing.JButton();
        btn_HeThong_TaiKhoan_DangXuat = new javax.swing.JButton();
        pn_HeThong_TroGiup = new javax.swing.JPanel();
        scrollPanel_QLSV = new javax.swing.JScrollPane();
        tab_QuanLySinhVien = new javax.swing.JTabbedPane();
        pn_TiepNhanSinhVien = new javax.swing.JPanel();
        lb_QLSV_TiepNhanSV_HoSoSV = new javax.swing.JLabel();
        pn_QLSV_TiepNhanSV_ThongTin = new javax.swing.JPanel();
        lb_QLSV_TiepNhanSV_ThongTin_HoSV = new javax.swing.JLabel();
        tf_QLSV_TiepNhanSV_ThongTin_HoSV = new javax.swing.JTextField();
        lb_QLSV_TiepNhanSV_ThongTin_TenSV = new javax.swing.JLabel();
        tf_QLSV_TiepNhanSV_ThongTin_TenSV = new javax.swing.JTextField();
        lb_QLSV_TiepNhanSV_ThongTin_NgaySinh = new javax.swing.JLabel();
        dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh = new com.toedter.calendar.JDateChooser();
        lb_QLSV_TiepNhanSV_ThongTin_GioiTinh = new javax.swing.JLabel();
        lb_QLSV_TiepNhanSV_ThongTin_CMND = new javax.swing.JLabel();
        tf_QLSV_TiepNhanSV_ThongTin_CMND = new javax.swing.JTextField();
        lb_QLSV_TiepNhanSV_ThongTin_NgayCap = new javax.swing.JLabel();
        dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap = new com.toedter.calendar.JDateChooser();
        lb_QLSV_TiepNhanSV_ThongTin_MSSV = new javax.swing.JLabel();
        tf_QLSV_TiepNhanSV_ThongTin_MSSV = new javax.swing.JTextField();
        lb_QLSV_TiepNhanSV_ThongTin_Truong = new javax.swing.JLabel();
        btn_QLSV_TiepNhanSV_ThongTin_Luu = new javax.swing.JButton();
        btn_QLSV_TiepNhanSV_ThongTin_Huy = new javax.swing.JButton();
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong = new javax.swing.JButton();
        cb_QLSV_TiepNhanSV_ThongTin_Truong = new javax.swing.JComboBox<>();
        rb_QLSV_TiepNhanSV_GioiTinh_Nam = new javax.swing.JRadioButton();
        rb_QLSV_TiepNhanSV_GioiTinh_Nu = new javax.swing.JRadioButton();
        scrollPane_QLSV_TiepNhanSV_Table = new javax.swing.JScrollPane();
        tb_QLSV_TiepNhanSV = new javax.swing.JTable();
        pn_XepPhong = new javax.swing.JPanel();
        lb_QLSV_XepPhong_XepPhongSV = new javax.swing.JLabel();
        pn_QLSV_XepPhong_ThongTin = new javax.swing.JPanel();
        lb_QLSV_XepPhong_MaKTX = new javax.swing.JLabel();
        tf_QLSV_XepPhong_MaKTX = new javax.swing.JTextField();
        pn_QLSV_XepPhong_ThongTinChiTiet = new javax.swing.JPanel();
        lb_QLSV_XepPhong_HoTen = new javax.swing.JLabel();
        lb_QLSV_XepPhong_HoTen_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_CMND = new javax.swing.JLabel();
        lb_QLSV_XepPhong_NgaySinh = new javax.swing.JLabel();
        lb_QLSV_XepPhong_Truong = new javax.swing.JLabel();
        lb_QLSV_XepPhong_CMND_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_NgaySinh_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_Truong_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_MSSV = new javax.swing.JLabel();
        lb_QLSV_XepPhong_MSSV_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_Nha = new javax.swing.JLabel();
        lb_QLSV_XepPhong_Nha_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_Phong = new javax.swing.JLabel();
        lb_QLSV_XepPhong_Phong_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XepPhong_GioiTinh = new javax.swing.JLabel();
        lb_QLSV_XepPhong_GioiTinh_ChiTiet = new javax.swing.JLabel();
        pn_QLSV_XepPhong_LoaiPhong = new javax.swing.JPanel();
        lb_QLSV_XepPhong_LoaiPhong_SoNguoi = new javax.swing.JLabel();
        cb_QLSV_XepPhong_LoaiPhong_SoNguoi = new javax.swing.JComboBox<>();
        pn_QLSV_XepPhong_LoaiPhong_GioiTinh = new javax.swing.JPanel();
        rb_QLSV_XepPhong_LoaiPhong_Nu = new javax.swing.JRadioButton();
        rb_QLSV_XepPhong_LoaiPhong_Nam = new javax.swing.JRadioButton();
        btn_QLSV_XepPhong_Search = new javax.swing.JButton();
        lb_QLSV_XepPhong_NamHoc = new javax.swing.JLabel();
        cb_QLSV_XepPhong_NamHoc = new javax.swing.JComboBox<>();
        lb_QLSV_XepPhong_HocKy = new javax.swing.JLabel();
        cb_QLSV_XepPhong_HocKy = new javax.swing.JComboBox<>();
        scrollPane_QLSV_XepPhong_Table = new javax.swing.JScrollPane();
        tb_QLSV_XepPhong = new javax.swing.JTable();
        btn_QLSV_XepPhong_Luu = new javax.swing.JButton();
        btn_QLSV_XepPhong_Huy = new javax.swing.JButton();
        btn_QLSV_XepPhong_ThuPhi = new javax.swing.JButton();
        pn_CapNhatHoSoSinhVien = new javax.swing.JPanel();
        lb_CapNhatThongTinSV_HoSoSV = new javax.swing.JLabel();
        pn_CapNhatHoSo_ThongTin = new javax.swing.JPanel();
        lb_CapNhatThongTinSV_HoSinhVien = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_ThongTin_HoSinhVien = new javax.swing.JTextField();
        lb_CapNhatThongTinSV_ThongTin_TenSV = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_ThongTin_TenSV = new javax.swing.JTextField();
        lb_CapNhatThongTinSV_ThongTin_DanToc = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_ThongTin_DanToc = new javax.swing.JTextField();
        tf_CapNhatThongTinSV_ThongTin_TonGiao = new javax.swing.JTextField();
        lb_CapNhatThongTinSV_ThongTin_TonGiao = new javax.swing.JLabel();
        lb_CapNhatThongTinSV_ThongTin_CMND = new javax.swing.JLabel();
        lb_CapNhatThongTinSV_ThongTin_NgayCap = new javax.swing.JLabel();
        dateChooser_CapNhatThongTinSV_ThongTin_NgayCap = new com.toedter.calendar.JDateChooser();
        lb_CapNhatThongTinSV_ThongTin_QuocTich = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_ThongTin_QuocTich = new javax.swing.JTextField();
        lb_CapNhatThongTinSV_ThongTin_Tinh = new javax.swing.JLabel();
        cb_CapNhatThongTinSV_ThongTin_Tinh = new javax.swing.JComboBox<>();
        lb_CapNhatThongTinSV_ThongTin_NgaySinh = new javax.swing.JLabel();
        dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh = new com.toedter.calendar.JDateChooser();
        lb_CapNhatThongTinSV_ThongTin_GioiTinh = new javax.swing.JLabel();
        lb_CapNhatThongTinSV_ThongTin_DiaChiNha = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_ThongTin_DiaChiNha = new javax.swing.JTextField();
        lb_CapNhatThongTinSV_ThongTin_MSSV = new javax.swing.JLabel();
        lb_CapNhatThongTinSV_ThongTin_SDT = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_ThongTin_SDT = new javax.swing.JTextField();
        lb_CapNhatThongTinSV_ThongTin_Truong = new javax.swing.JLabel();
        tf_CapNhatThongTinSV_CMND = new javax.swing.JTextField();
        tf_CapNhatThongTinSV_MSSV = new javax.swing.JTextField();
        tf_CapNhatThongTinSV_GioiTinh = new javax.swing.JTextField();
        btn_CapNhatThongTinSV_Luu = new javax.swing.JButton();
        btn_CapNhatThongTinSV_Huy = new javax.swing.JButton();
        cb_CapNhatThongTinSV_Truong = new javax.swing.JComboBox<>();
        lb_CapNhatThongTinSV_MaKTX = new javax.swing.JLabel();
        tf_CapNhatThongTinSinhVien_MaKTX = new javax.swing.JTextField();
        btn_CapNhatThongTinSinhVien_Search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_CapNhatThongTinSinhVien = new javax.swing.JTable();
        pn_XuLySinhVienRaKhoiKTX = new javax.swing.JPanel();
        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX = new javax.swing.JLabel();
        pn_QLSV_XuLySVKhoiKTX_ThongTin = new javax.swing.JPanel();
        lb_QLSV_XuLySVKhoiKTX_MaKTX = new javax.swing.JLabel();
        tf_QLSV_XuLySVKhoiKTX_MaKTX = new javax.swing.JTextField();
        pn_QLSV_XuLySVRaKhoiKTX_ChiTiet = new javax.swing.JPanel();
        lb_QLSV_XuLySVRaKhoiKTX_HoTen = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_NgaySinh = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_GioiTinh = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_MSSV = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_Truong = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_Nha = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_Phong = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_NgaySinh_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_GioiTinh_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_MSSV_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_Truong_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_Nha_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_Phong_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_CMND = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_CMND_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_NamHoc = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_NamHoc_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_HocKy = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru_ChiTiet = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra = new javax.swing.JLabel();
        lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra_ChiTiet = new javax.swing.JLabel();
        btn_QLSV_XuLySVKhoiKTX_XacNhan = new javax.swing.JButton();
        btn_QLSV_XuLySVKhoiKTX_XuatHoaDon = new javax.swing.JButton();
        scrollPane_QLSV_XuLySVKhoiKTX_Table = new javax.swing.JScrollPane();
        tb_QLSV_XuLySVKhoiKTX = new javax.swing.JTable();
        scrollPanel_ThuPhi = new javax.swing.JScrollPane();
        tab_ThuPhi = new javax.swing.JTabbedPane();
        pn_ThuPhi_PhiNoiTru = new javax.swing.JPanel();
        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru = new javax.swing.JLabel();
        pn_ThuPhi_PhiNoiTru_ThongTin = new javax.swing.JPanel();
        lb_ThuPhi_PhiNoiTru_MaKTX = new javax.swing.JLabel();
        tf_ThuPhi_PhiNoiTru_MaKTX = new javax.swing.JTextField();
        pn_ThuPhi_PhiNoiTru_ThongTinChiTiet = new javax.swing.JPanel();
        lb_ThuPhi_PhiNoiTru_HoTen = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_NgaySinh = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_GioiTinh = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_MSSV = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_Truong = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_Nha = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_Phong = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_NgaySinh_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_GioiTinh_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_MSSV_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_Truong_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_Nha_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_Phong_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_CMND = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_CMND_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_NamHoc = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_NamHoc_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_HocKy = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_PhiNoiTru = new javax.swing.JLabel();
        lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet = new javax.swing.JLabel();
        btn_ThuPhi_PhiNoiTru = new javax.swing.JButton();
        btn_ThuPhi_PhiNoiTru_XuatHoaDon = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_ThuPhi_PhiNoiTru = new javax.swing.JTable();
        pn_ThuPhi_PhiDienNuoc = new javax.swing.JPanel();
        lb_ThuPhi_ThuPhiDienNuoc = new javax.swing.JLabel();
        pn_ThuPhi_PhiDienNuoc_ThongTinPhong = new javax.swing.JPanel();
        lb_ThuPhi_PhiDienNuoc_KhoiNha = new javax.swing.JLabel();
        cb_ThuPhi_PhiDienNuoc_KhoiNha = new javax.swing.JComboBox<>();
        lb_ThuPhi_PhiDienNuoc_TenPhong = new javax.swing.JLabel();
        cb_ThuPhi_PhiDienNuoc_Phong = new javax.swing.JComboBox<>();
        btn_ThuPhi_PhiDienNuoc_ThuPhi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_ThuPhiDienNuoc = new javax.swing.JTable();
        pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc = new javax.swing.JPanel();
        lb_ThuPhi_PhiDienNuoc_ThangNam = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_ThangNam_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_Phong = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_Phong_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_Nha = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_Nha_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_SoKWDien = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_SoKWDien_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_TienDien = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_TienDien_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_TienNuoc = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_TienNuoc_ChiTiet = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_TongCong = new javax.swing.JLabel();
        lb_ThuPhi_PhiDienNuoc_TongCong_ChiTiet = new javax.swing.JLabel();
        scrollPanel_HoanTraPhi = new javax.swing.JScrollPane();
        tab_HoanTraPhi = new javax.swing.JTabbedPane();
        pn_HoanTraPhiCSVC = new javax.swing.JPanel();
        lb_HoanTraPhiCSVC = new javax.swing.JLabel();
        pn_HoanTraPhiCSVC_ThongTin = new javax.swing.JPanel();
        lb_HoanTraPhiCSVC_NamHoc = new javax.swing.JLabel();
        cb_HoanTraPhiCSVC_NamHoc = new javax.swing.JComboBox<>();
        lb_HoanTraPhiCSVC_MaKTX = new javax.swing.JLabel();
        tf_HoanTraPhiCSVC_MaKTX = new javax.swing.JTextField();
        pn_HoanTraPhiCSVC_ChiTiet = new javax.swing.JPanel();
        lb_HoanTraPhiCSVC_HoTen = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_HoTen_ChiTiet = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_GioiTinh = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_GioiTinh_ChiTiet = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_MSSV = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_MSSV_ChiTiet = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_Truong = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_Truong_ChiTiet = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_Nha = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_Nha_ChiTiet = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_Phong = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_Phong_ChiTiet = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_PhiHoanTra = new javax.swing.JLabel();
        lb_HoanTraPhiCSVC_PhiHoanTra_ChiTiet = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_HoanTraPhiCSVC = new javax.swing.JTable();
        btn_HoanTraPhiCSVC_XacNhan = new javax.swing.JButton();
        scrollPanel_TraCuu = new javax.swing.JScrollPane();
        tab_TraCuu = new javax.swing.JTabbedPane();
        pn_TraCuuSinhVien = new javax.swing.JPanel();
        lb_TraCuu_SinhVien_TraCuuSV = new javax.swing.JLabel();
        tf_TraCuu_SinhVien = new javax.swing.JTextField();
        btn_TraCuu_SinhVien_Search = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_TraCuu_SinhVien = new javax.swing.JTable();
        pn_TraCuuPhong = new javax.swing.JPanel();
        lb_TraCuuPhong = new javax.swing.JLabel();
        lb_TraCuuPhong_Nha = new javax.swing.JLabel();
        cb_TraCuu_ThongTinPhong_Nha = new javax.swing.JComboBox<>();
        lb_TraCuuPhong_Phong = new javax.swing.JLabel();
        cb_TraCuu_ThongTinPhong_Phong = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_TraCuu_ThongTinPhong = new javax.swing.JTable();
        pn_TraCuuDienNuoc = new javax.swing.JPanel();
        lb_TraCuuDienNuoc = new javax.swing.JLabel();
        pn_TraCuuDienNuoc_ThongTin = new javax.swing.JPanel();
        lb_TraCuuDienNuoc_Nha = new javax.swing.JLabel();
        cb_TraCuuDienNuoc_Nha = new javax.swing.JComboBox<>();
        lb_TraCuuDienNuoc_Phong = new javax.swing.JLabel();
        cb_TraCuuDienNuoc_Phong = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_TraCuuDienNuoc = new javax.swing.JTable();
        scrollPanel_ThongKe = new javax.swing.JScrollPane();
        tab_ThongKe = new javax.swing.JTabbedPane();
        pn_ThongKeTongThu = new javax.swing.JPanel();
        lb_ThongKeTongThu = new javax.swing.JLabel();
        pn_ThongKeTongThu_ThongTin = new javax.swing.JPanel();
        lb_ThongKeTongThu_NamHoc = new javax.swing.JLabel();
        cb_ThongKeTongThu_NamHoc = new javax.swing.JComboBox<>();
        lb_ThongKeTongThu_HocKy = new javax.swing.JLabel();
        cb_ThongKeTongThu_HocKy = new javax.swing.JComboBox<>();
        btn_ThongKeTongThu = new javax.swing.JButton();
        pn_ThongKeSinhVien = new javax.swing.JPanel();
        lb_ThongKeSinhVien = new javax.swing.JLabel();
        pn_ThongKeSinhVien_HinhThucThongKe = new javax.swing.JPanel();
        btn_ThongKeSinhVien_Truong = new javax.swing.JButton();
        btn_ThongKeSinhVien_Nha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tab_Main.setBackground(new java.awt.Color(255, 255, 255));
        tab_Main.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tab_Main.setAlignmentX(1.0F);
        tab_Main.setAlignmentY(1.0F);
        tab_Main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tab_Main.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tab_HeThong.setBackground(new java.awt.Color(255, 255, 255));
        tab_HeThong.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_HeThong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pn_HeThong_QuanLyDanhMuc.setBackground(new java.awt.Color(255, 255, 255));

        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setBackground(new java.awt.Color(0, 153, 255));
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setForeground(new java.awt.Color(255, 255, 255));
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1478804623_category.png"))); // NOI18N
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setText("QUẢN LÝ DANH MỤC");
        lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setOpaque(true);

        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setBackground(new java.awt.Color(255, 255, 255));
        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh Sách Danh Mục"));

        btn_HeThong_QuanLyDanhMuc_Tinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1478803458_handrawn_Location_map_pointer.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_Tinh.setText("Tỉnh");
        btn_HeThong_QuanLyDanhMuc_Tinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_TinhActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_Truong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/school.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_Truong.setText("Trường");
        btn_HeThong_QuanLyDanhMuc_Truong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_TruongActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_KhoiNha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cityscape.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_KhoiNha.setText("Khối Nhà");
        btn_HeThong_QuanLyDanhMuc_KhoiNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_KhoiNhaActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_ThoiGian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1478805401_resolutions-04.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_ThoiGian.setText("Thời Gian");
        btn_HeThong_QuanLyDanhMuc_ThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_ThoiGianActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_MucGiaDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_MucGiaDien.setText("Mức Giá Điện");
        btn_HeThong_QuanLyDanhMuc_MucGiaDien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_MucGiaDienActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_MucGiaNuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drop.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_MucGiaNuoc.setText("Mức Giá Nước");
        btn_HeThong_QuanLyDanhMuc_MucGiaNuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_MucGiaNuocActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_MucPhiKTX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/get-money.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_MucPhiKTX.setText("Mức Phí KTX");
        btn_HeThong_QuanLyDanhMuc_MucPhiKTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_MucPhiKTXActionPerformed(evt);
            }
        });

        btn_HeThong_QuanLyDanhMuc_Phong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house.png"))); // NOI18N
        btn_HeThong_QuanLyDanhMuc_Phong.setText("Phòng");
        btn_HeThong_QuanLyDanhMuc_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_QuanLyDanhMuc_PhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout = new javax.swing.GroupLayout(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc);
        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc.setLayout(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout);
        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.setHorizontalGroup(
            pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_Truong)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_ThoiGian))
                .addGap(104, 104, 104)
                .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_MucPhiKTX)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_KhoiNha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_Phong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_MucGiaDien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btn_HeThong_QuanLyDanhMuc_MucGiaNuoc))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btn_HeThong_QuanLyDanhMuc_Tinh)))
                .addGap(32, 32, 32))
        );

        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_HeThong_QuanLyDanhMuc_KhoiNha, btn_HeThong_QuanLyDanhMuc_MucGiaDien, btn_HeThong_QuanLyDanhMuc_MucGiaNuoc, btn_HeThong_QuanLyDanhMuc_MucPhiKTX, btn_HeThong_QuanLyDanhMuc_ThoiGian, btn_HeThong_QuanLyDanhMuc_Tinh, btn_HeThong_QuanLyDanhMuc_Truong});

        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.setVerticalGroup(
            pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_MucPhiKTX)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_ThoiGian)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_MucGiaDien)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_MucGiaNuoc))
                .addGap(86, 86, 86)
                .addGroup(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_Truong)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_KhoiNha)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_Tinh)
                    .addComponent(btn_HeThong_QuanLyDanhMuc_Phong))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pn_HeThong_QuanLyDanhMuc_QuanLyDanhMucLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_HeThong_QuanLyDanhMuc_KhoiNha, btn_HeThong_QuanLyDanhMuc_MucGiaDien, btn_HeThong_QuanLyDanhMuc_MucGiaNuoc, btn_HeThong_QuanLyDanhMuc_MucPhiKTX, btn_HeThong_QuanLyDanhMuc_ThoiGian, btn_HeThong_QuanLyDanhMuc_Tinh, btn_HeThong_QuanLyDanhMuc_Truong});

        javax.swing.GroupLayout pn_HeThong_QuanLyDanhMucLayout = new javax.swing.GroupLayout(pn_HeThong_QuanLyDanhMuc);
        pn_HeThong_QuanLyDanhMuc.setLayout(pn_HeThong_QuanLyDanhMucLayout);
        pn_HeThong_QuanLyDanhMucLayout.setHorizontalGroup(
            pn_HeThong_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_QuanLyDanhMucLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addComponent(lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_HeThong_QuanLyDanhMucLayout.setVerticalGroup(
            pn_HeThong_QuanLyDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_QuanLyDanhMucLayout.createSequentialGroup()
                .addComponent(lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        tab_HeThong.addTab("Quản Lý Danh Mục", new javax.swing.ImageIcon(getClass().getResource("/Images/check-mark.png")), pn_HeThong_QuanLyDanhMuc); // NOI18N

        pn_HeThong_TaiKhoan.setBackground(new java.awt.Color(255, 255, 255));

        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setBackground(new java.awt.Color(0, 153, 255));
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png"))); // NOI18N
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setText("QUẢN LÝ TÀI KHOẢN");
        lb_HeThong_TaiKhoan_QuanLyTaiKhoan.setOpaque(true);

        pn_HeThong_TaiKhoan_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_HeThong_TaiKhoan_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        btn_HeThong_TaiKhoan_TaoTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actions-contact-new-icon.png"))); // NOI18N
        btn_HeThong_TaiKhoan_TaoTaiKhoan.setText("Tạo Tài Khoản");
        btn_HeThong_TaiKhoan_TaoTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_TaiKhoan_TaoTaiKhoanActionPerformed(evt);
            }
        });

        btn_HeThong_TaiKhoan_DoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh-icon.png"))); // NOI18N
        btn_HeThong_TaiKhoan_DoiMatKhau.setText("Đổi Mật Khẩu");
        btn_HeThong_TaiKhoan_DoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_TaiKhoan_DoiMatKhauActionPerformed(evt);
            }
        });

        btn_HeThong_TaiKhoan_DangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        btn_HeThong_TaiKhoan_DangXuat.setText("Đăng Xuất");
        btn_HeThong_TaiKhoan_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HeThong_TaiKhoan_DangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_HeThong_TaiKhoan_ThongTinLayout = new javax.swing.GroupLayout(pn_HeThong_TaiKhoan_ThongTin);
        pn_HeThong_TaiKhoan_ThongTin.setLayout(pn_HeThong_TaiKhoan_ThongTinLayout);
        pn_HeThong_TaiKhoan_ThongTinLayout.setHorizontalGroup(
            pn_HeThong_TaiKhoan_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_TaiKhoan_ThongTinLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_HeThong_TaiKhoan_TaoTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btn_HeThong_TaiKhoan_DoiMatKhau)
                .addGap(61, 61, 61)
                .addComponent(btn_HeThong_TaiKhoan_DangXuat)
                .addGap(47, 47, 47))
        );

        pn_HeThong_TaiKhoan_ThongTinLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_HeThong_TaiKhoan_DangXuat, btn_HeThong_TaiKhoan_DoiMatKhau, btn_HeThong_TaiKhoan_TaoTaiKhoan});

        pn_HeThong_TaiKhoan_ThongTinLayout.setVerticalGroup(
            pn_HeThong_TaiKhoan_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_TaiKhoan_ThongTinLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pn_HeThong_TaiKhoan_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_HeThong_TaiKhoan_TaoTaiKhoan)
                    .addComponent(btn_HeThong_TaiKhoan_DoiMatKhau)
                    .addComponent(btn_HeThong_TaiKhoan_DangXuat))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pn_HeThong_TaiKhoan_ThongTinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_HeThong_TaiKhoan_DangXuat, btn_HeThong_TaiKhoan_DoiMatKhau, btn_HeThong_TaiKhoan_TaoTaiKhoan});

        javax.swing.GroupLayout pn_HeThong_TaiKhoanLayout = new javax.swing.GroupLayout(pn_HeThong_TaiKhoan);
        pn_HeThong_TaiKhoan.setLayout(pn_HeThong_TaiKhoanLayout);
        pn_HeThong_TaiKhoanLayout.setHorizontalGroup(
            pn_HeThong_TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_TaiKhoanLayout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(pn_HeThong_TaiKhoan_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
            .addComponent(lb_HeThong_TaiKhoan_QuanLyTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_HeThong_TaiKhoanLayout.setVerticalGroup(
            pn_HeThong_TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HeThong_TaiKhoanLayout.createSequentialGroup()
                .addComponent(lb_HeThong_TaiKhoan_QuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(pn_HeThong_TaiKhoan_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        tab_HeThong.addTab("Tài Khoản", new javax.swing.ImageIcon(getClass().getResource("/Images/customer-service (1).png")), pn_HeThong_TaiKhoan); // NOI18N

        pn_HeThong_TroGiup.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_HeThong_TroGiupLayout = new javax.swing.GroupLayout(pn_HeThong_TroGiup);
        pn_HeThong_TroGiup.setLayout(pn_HeThong_TroGiupLayout);
        pn_HeThong_TroGiupLayout.setHorizontalGroup(
            pn_HeThong_TroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1143, Short.MAX_VALUE)
        );
        pn_HeThong_TroGiupLayout.setVerticalGroup(
            pn_HeThong_TroGiupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        tab_HeThong.addTab("Trợ Giúp", new javax.swing.ImageIcon(getClass().getResource("/Images/customer-service.png")), pn_HeThong_TroGiup); // NOI18N

        tab_HeThong.setSelectedIndex(2);

        scrollPanel_HeThong.setViewportView(tab_HeThong);

        tab_Main.addTab("Hệ Thống", new javax.swing.ImageIcon(getClass().getResource("/Images/offices.png")), scrollPanel_HeThong); // NOI18N

        tab_QuanLySinhVien.setBackground(new java.awt.Color(255, 255, 255));
        tab_QuanLySinhVien.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_QuanLySinhVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pn_TiepNhanSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        lb_QLSV_TiepNhanSV_HoSoSV.setBackground(new java.awt.Color(0, 153, 255));
        lb_QLSV_TiepNhanSV_HoSoSV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_QLSV_TiepNhanSV_HoSoSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_HoSoSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_QLSV_TiepNhanSV_HoSoSV.setText("TIẾP NHẬN SINH VIÊN");
        lb_QLSV_TiepNhanSV_HoSoSV.setOpaque(true);

        pn_QLSV_TiepNhanSV_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_QLSV_TiepNhanSV_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 102))); // NOI18N

        lb_QLSV_TiepNhanSV_ThongTin_HoSV.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_HoSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_HoSV.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_HoSV.setText("Họ Sinh Viên:");
        lb_QLSV_TiepNhanSV_ThongTin_HoSV.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_TenSV.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_TenSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_TenSV.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_TenSV.setText("Tên Sinh Viên:");
        lb_QLSV_TiepNhanSV_ThongTin_TenSV.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_NgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_NgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_NgaySinh.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_NgaySinh.setText("Ngày Sinh:");
        lb_QLSV_TiepNhanSV_ThongTin_NgaySinh.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_GioiTinh.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_GioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_GioiTinh.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_GioiTinh.setText("Giới Tính:");
        lb_QLSV_TiepNhanSV_ThongTin_GioiTinh.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_CMND.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_CMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_CMND.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_CMND.setText("CMND:");
        lb_QLSV_TiepNhanSV_ThongTin_CMND.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_NgayCap.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_NgayCap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_NgayCap.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_NgayCap.setText("Ngày Cấp:");
        lb_QLSV_TiepNhanSV_ThongTin_NgayCap.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_MSSV.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_MSSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_MSSV.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_MSSV.setText("MSSV:");
        lb_QLSV_TiepNhanSV_ThongTin_MSSV.setOpaque(true);

        lb_QLSV_TiepNhanSV_ThongTin_Truong.setBackground(new java.awt.Color(255, 255, 255));
        lb_QLSV_TiepNhanSV_ThongTin_Truong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_TiepNhanSV_ThongTin_Truong.setForeground(new java.awt.Color(0, 0, 102));
        lb_QLSV_TiepNhanSV_ThongTin_Truong.setText("Trường:");
        lb_QLSV_TiepNhanSV_ThongTin_Truong.setOpaque(true);

        btn_QLSV_TiepNhanSV_ThongTin_Luu.setBackground(new java.awt.Color(255, 255, 255));
        btn_QLSV_TiepNhanSV_ThongTin_Luu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_QLSV_TiepNhanSV_ThongTin_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_QLSV_TiepNhanSV_ThongTin_Luu.setText("Lưu");
        btn_QLSV_TiepNhanSV_ThongTin_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_TiepNhanSV_ThongTin_LuuActionPerformed(evt);
            }
        });

        btn_QLSV_TiepNhanSV_ThongTin_Huy.setBackground(new java.awt.Color(255, 255, 255));
        btn_QLSV_TiepNhanSV_ThongTin_Huy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_QLSV_TiepNhanSV_ThongTin_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
        btn_QLSV_TiepNhanSV_ThongTin_Huy.setText("Hủy");
        btn_QLSV_TiepNhanSV_ThongTin_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_TiepNhanSV_ThongTin_HuyActionPerformed(evt);
            }
        });

        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setBackground(new java.awt.Color(255, 255, 255));
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fast-forward.png"))); // NOI18N
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setText("Xếp Phòng");
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_TiepNhanSV_ThongTin_XepPhongActionPerformed(evt);
            }
        });

        cb_QLSV_TiepNhanSV_ThongTin_Truong.setForeground(new java.awt.Color(0, 0, 102));

        rb_QLSV_TiepNhanSV_GioiTinh_Nam.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup_QLSV_TiepNhanSV_GioiTinh.add(rb_QLSV_TiepNhanSV_GioiTinh_Nam);
        rb_QLSV_TiepNhanSV_GioiTinh_Nam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rb_QLSV_TiepNhanSV_GioiTinh_Nam.setForeground(new java.awt.Color(0, 0, 102));
        rb_QLSV_TiepNhanSV_GioiTinh_Nam.setText("Nam");

        rb_QLSV_TiepNhanSV_GioiTinh_Nu.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup_QLSV_TiepNhanSV_GioiTinh.add(rb_QLSV_TiepNhanSV_GioiTinh_Nu);
        rb_QLSV_TiepNhanSV_GioiTinh_Nu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rb_QLSV_TiepNhanSV_GioiTinh_Nu.setForeground(new java.awt.Color(0, 0, 102));
        rb_QLSV_TiepNhanSV_GioiTinh_Nu.setText("Nữ");

        javax.swing.GroupLayout pn_QLSV_TiepNhanSV_ThongTinLayout = new javax.swing.GroupLayout(pn_QLSV_TiepNhanSV_ThongTin);
        pn_QLSV_TiepNhanSV_ThongTin.setLayout(pn_QLSV_TiepNhanSV_ThongTinLayout);
        pn_QLSV_TiepNhanSV_ThongTinLayout.setHorizontalGroup(
            pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_TiepNhanSV_ThongTin_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(77, 77, 77))
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_TiepNhanSV_ThongTin_HoSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_TiepNhanSV_ThongTin_CMND)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(tf_QLSV_TiepNhanSV_ThongTin_HoSV, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_QLSV_TiepNhanSV_ThongTin_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_NgayCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_QLSV_TiepNhanSV_ThongTin_GioiTinh)
                                    .addComponent(lb_QLSV_TiepNhanSV_ThongTin_TenSV))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                                    .addComponent(rb_QLSV_TiepNhanSV_GioiTinh_Nam)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rb_QLSV_TiepNhanSV_GioiTinh_Nu))
                                .addComponent(tf_QLSV_TiepNhanSV_ThongTin_TenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_MSSV)
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_Truong))
                        .addGap(30, 30, 30)
                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_QLSV_TiepNhanSV_ThongTin_MSSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_QLSV_TiepNhanSV_ThongTin_Truong, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(92, 92, 92))
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                        .addComponent(btn_QLSV_TiepNhanSV_ThongTin_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_QLSV_TiepNhanSV_ThongTin_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_QLSV_TiepNhanSV_ThongTin_XepPhong)
                        .addGap(41, 41, 41))))
        );

        pn_QLSV_TiepNhanSV_ThongTinLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_QLSV_TiepNhanSV_ThongTin_Truong, dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh, tf_QLSV_TiepNhanSV_ThongTin_CMND, tf_QLSV_TiepNhanSV_ThongTin_HoSV, tf_QLSV_TiepNhanSV_ThongTin_MSSV});

        pn_QLSV_TiepNhanSV_ThongTinLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_QLSV_TiepNhanSV_ThongTin_Huy, btn_QLSV_TiepNhanSV_ThongTin_Luu, btn_QLSV_TiepNhanSV_ThongTin_XepPhong});

        pn_QLSV_TiepNhanSV_ThongTinLayout.setVerticalGroup(
            pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_QLSV_TiepNhanSV_ThongTin_MSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_QLSV_TiepNhanSV_ThongTin_MSSV)
                                    .addComponent(tf_QLSV_TiepNhanSV_ThongTin_TenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_QLSV_TiepNhanSV_ThongTin_TenSV))
                                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_Truong)
                                            .addComponent(cb_QLSV_TiepNhanSV_ThongTin_Truong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_GioiTinh)
                                            .addComponent(rb_QLSV_TiepNhanSV_GioiTinh_Nam)
                                            .addComponent(rb_QLSV_TiepNhanSV_GioiTinh_Nu))))))
                        .addGap(28, 28, 28)
                        .addComponent(dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_HoSV)
                            .addGap(30, 30, 30)
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_NgaySinh))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_QLSV_TiepNhanSV_ThongTin_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_CMND)
                            .addComponent(lb_QLSV_TiepNhanSV_ThongTin_NgayCap))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QLSV_TiepNhanSV_ThongTinLayout.createSequentialGroup()
                            .addComponent(tf_QLSV_TiepNhanSV_ThongTin_HoSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46))))
                .addGap(36, 36, 36)
                .addGroup(pn_QLSV_TiepNhanSV_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_QLSV_TiepNhanSV_ThongTin_Luu)
                    .addComponent(btn_QLSV_TiepNhanSV_ThongTin_Huy)
                    .addComponent(btn_QLSV_TiepNhanSV_ThongTin_XepPhong))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pn_QLSV_TiepNhanSV_ThongTinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_QLSV_TiepNhanSV_ThongTin_Huy, btn_QLSV_TiepNhanSV_ThongTin_Luu, btn_QLSV_TiepNhanSV_ThongTin_XepPhong});

        pn_QLSV_TiepNhanSV_ThongTinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh, tf_QLSV_TiepNhanSV_ThongTin_CMND, tf_QLSV_TiepNhanSV_ThongTin_HoSV});

        pn_QLSV_TiepNhanSV_ThongTinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap, tf_QLSV_TiepNhanSV_ThongTin_TenSV});

        pn_QLSV_TiepNhanSV_ThongTinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_QLSV_TiepNhanSV_ThongTin_Truong, tf_QLSV_TiepNhanSV_ThongTin_MSSV});

        tb_QLSV_TiepNhanSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KTX", "MSSV", "Họ Sinh Viên", "Tên Sinh Viên", "Giới Tính", "Ngày Sinh", "CMND", "Ngày Cấp", "Trường"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_QLSV_TiepNhanSV.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb_QLSV_TiepNhanSV.setCellSelectionEnabled(true);
        tb_QLSV_TiepNhanSV.setShowVerticalLines(false);
        tb_QLSV_TiepNhanSV.getTableHeader().setReorderingAllowed(false);
        scrollPane_QLSV_TiepNhanSV_Table.setViewportView(tb_QLSV_TiepNhanSV);

        javax.swing.GroupLayout pn_TiepNhanSinhVienLayout = new javax.swing.GroupLayout(pn_TiepNhanSinhVien);
        pn_TiepNhanSinhVien.setLayout(pn_TiepNhanSinhVienLayout);
        pn_TiepNhanSinhVienLayout.setHorizontalGroup(
            pn_TiepNhanSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane_QLSV_TiepNhanSV_Table, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pn_TiepNhanSinhVienLayout.createSequentialGroup()
                .addComponent(pn_QLSV_TiepNhanSV_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lb_QLSV_TiepNhanSV_HoSoSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_TiepNhanSinhVienLayout.setVerticalGroup(
            pn_TiepNhanSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TiepNhanSinhVienLayout.createSequentialGroup()
                .addComponent(lb_QLSV_TiepNhanSV_HoSoSV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_QLSV_TiepNhanSV_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane_QLSV_TiepNhanSV_Table, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        );

        tab_QuanLySinhVien.addTab("Tiếp Nhận Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Images/user.png")), pn_TiepNhanSinhVien); // NOI18N

        pn_XepPhong.setBackground(new java.awt.Color(255, 255, 255));

        lb_QLSV_XepPhong_XepPhongSV.setBackground(new java.awt.Color(0, 153, 255));
        lb_QLSV_XepPhong_XepPhongSV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_QLSV_XepPhong_XepPhongSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_QLSV_XepPhong_XepPhongSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_QLSV_XepPhong_XepPhongSV.setText("XẾP PHÒNG SINH VIÊN");
        lb_QLSV_XepPhong_XepPhongSV.setOpaque(true);

        pn_QLSV_XepPhong_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_QLSV_XepPhong_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_QLSV_XepPhong_MaKTX.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_MaKTX.setText("Mã KTX:");

        tf_QLSV_XepPhong_MaKTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_QLSV_XepPhong_MaKTXActionPerformed(evt);
            }
        });

        pn_QLSV_XepPhong_ThongTinChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pn_QLSV_XepPhong_ThongTinChiTiet.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_QLSV_XepPhong_HoTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_HoTen.setText("Họ Tên:");

        lb_QLSV_XepPhong_CMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_CMND.setText("CMND:");

        lb_QLSV_XepPhong_NgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_NgaySinh.setText("Ngày Sinh:");

        lb_QLSV_XepPhong_Truong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_Truong.setText("Trường:");

        lb_QLSV_XepPhong_MSSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_MSSV.setText("MSSV:");

        lb_QLSV_XepPhong_Nha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_Nha.setText("Nhà:");

        lb_QLSV_XepPhong_Phong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_Phong.setText("Phòng:");

        lb_QLSV_XepPhong_GioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_GioiTinh.setText("Giới Tính:");

        javax.swing.GroupLayout pn_QLSV_XepPhong_ThongTinChiTietLayout = new javax.swing.GroupLayout(pn_QLSV_XepPhong_ThongTinChiTiet);
        pn_QLSV_XepPhong_ThongTinChiTiet.setLayout(pn_QLSV_XepPhong_ThongTinChiTietLayout);
        pn_QLSV_XepPhong_ThongTinChiTietLayout.setHorizontalGroup(
            pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createSequentialGroup()
                        .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_QLSV_XepPhong_HoTen)
                            .addComponent(lb_QLSV_XepPhong_CMND)
                            .addComponent(lb_QLSV_XepPhong_NgaySinh)
                            .addComponent(lb_QLSV_XepPhong_GioiTinh))
                        .addGap(18, 18, 18)
                        .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_QLSV_XepPhong_HoTen_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(lb_QLSV_XepPhong_CMND_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_QLSV_XepPhong_NgaySinh_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_QLSV_XepPhong_GioiTinh_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lb_QLSV_XepPhong_Nha)
                    .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createSequentialGroup()
                        .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_QLSV_XepPhong_MSSV)
                            .addComponent(lb_QLSV_XepPhong_Truong)
                            .addComponent(lb_QLSV_XepPhong_Phong))
                        .addGap(34, 34, 34)
                        .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_QLSV_XepPhong_Nha_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(lb_QLSV_XepPhong_MSSV_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_QLSV_XepPhong_Phong_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_QLSV_XepPhong_Truong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_QLSV_XepPhong_ThongTinChiTietLayout.setVerticalGroup(
            pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XepPhong_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XepPhong_HoTen_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XepPhong_CMND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XepPhong_CMND_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XepPhong_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XepPhong_NgaySinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XepPhong_GioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XepPhong_GioiTinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XepPhong_MSSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XepPhong_MSSV_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XepPhong_Truong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XepPhong_Truong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_XepPhong_Nha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_QLSV_XepPhong_Phong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_QLSV_XepPhong_ThongTinChiTietLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_XepPhong_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_QLSV_XepPhong_Phong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_QLSV_XepPhong_ThongTinLayout = new javax.swing.GroupLayout(pn_QLSV_XepPhong_ThongTin);
        pn_QLSV_XepPhong_ThongTin.setLayout(pn_QLSV_XepPhong_ThongTinLayout);
        pn_QLSV_XepPhong_ThongTinLayout.setHorizontalGroup(
            pn_QLSV_XepPhong_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XepPhong_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QLSV_XepPhong_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_XepPhong_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_QLSV_XepPhong_MaKTX))
                    .addComponent(pn_QLSV_XepPhong_ThongTinChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_QLSV_XepPhong_ThongTinLayout.setVerticalGroup(
            pn_QLSV_XepPhong_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_ThongTinLayout.createSequentialGroup()
                .addGroup(pn_QLSV_XepPhong_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XepPhong_MaKTX)
                    .addComponent(tf_QLSV_XepPhong_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_QLSV_XepPhong_ThongTinChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_QLSV_XepPhong_LoaiPhong.setBackground(new java.awt.Color(255, 255, 255));
        pn_QLSV_XepPhong_LoaiPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Loại Phòng"));

        lb_QLSV_XepPhong_LoaiPhong_SoNguoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_QLSV_XepPhong_LoaiPhong_SoNguoi.setText("Số Người:");

        cb_QLSV_XepPhong_LoaiPhong_SoNguoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8 ", "6 ", "4 " }));

        buttonGroup2.add(rb_QLSV_XepPhong_LoaiPhong_Nu);
        rb_QLSV_XepPhong_LoaiPhong_Nu.setText(" Nữ");

        buttonGroup2.add(rb_QLSV_XepPhong_LoaiPhong_Nam);
        rb_QLSV_XepPhong_LoaiPhong_Nam.setText("Nam");

        javax.swing.GroupLayout pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout = new javax.swing.GroupLayout(pn_QLSV_XepPhong_LoaiPhong_GioiTinh);
        pn_QLSV_XepPhong_LoaiPhong_GioiTinh.setLayout(pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout);
        pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.setHorizontalGroup(
            pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_QLSV_XepPhong_LoaiPhong_Nu)
                    .addComponent(rb_QLSV_XepPhong_LoaiPhong_Nam))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.setVerticalGroup(
            pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_LoaiPhong_GioiTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_QLSV_XepPhong_LoaiPhong_Nu)
                .addGap(18, 18, 18)
                .addComponent(rb_QLSV_XepPhong_LoaiPhong_Nam)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_QLSV_XepPhong_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-engine.png"))); // NOI18N
        btn_QLSV_XepPhong_Search.setText("Search");
        btn_QLSV_XepPhong_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_XepPhong_SearchActionPerformed(evt);
            }
        });

        lb_QLSV_XepPhong_NamHoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_NamHoc.setText("Năm Học:");

        lb_QLSV_XepPhong_HocKy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XepPhong_HocKy.setText("Học Kỳ:");

        javax.swing.GroupLayout pn_QLSV_XepPhong_LoaiPhongLayout = new javax.swing.GroupLayout(pn_QLSV_XepPhong_LoaiPhong);
        pn_QLSV_XepPhong_LoaiPhong.setLayout(pn_QLSV_XepPhong_LoaiPhongLayout);
        pn_QLSV_XepPhong_LoaiPhongLayout.setHorizontalGroup(
            pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_QLSV_XepPhong_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createSequentialGroup()
                        .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_QLSV_XepPhong_NamHoc)
                            .addComponent(lb_QLSV_XepPhong_HocKy)
                            .addComponent(lb_QLSV_XepPhong_LoaiPhong_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_QLSV_XepPhong_LoaiPhong_SoNguoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_QLSV_XepPhong_NamHoc, 0, 101, Short.MAX_VALUE)
                            .addComponent(cb_QLSV_XepPhong_HocKy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_QLSV_XepPhong_LoaiPhong_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pn_QLSV_XepPhong_LoaiPhongLayout.setVerticalGroup(
            pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createSequentialGroup()
                        .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_QLSV_XepPhong_LoaiPhong_SoNguoi)
                            .addComponent(cb_QLSV_XepPhong_LoaiPhong_SoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_QLSV_XepPhong_NamHoc)
                            .addComponent(cb_QLSV_XepPhong_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_QLSV_XepPhong_LoaiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_QLSV_XepPhong_HocKy)
                            .addComponent(cb_QLSV_XepPhong_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pn_QLSV_XepPhong_LoaiPhong_GioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_QLSV_XepPhong_Search)
                .addGap(7, 7, 7))
        );

        tb_QLSV_XepPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nhà", "Phòng", "Số Người", "Loại Phòng", "Đang ở"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_QLSV_XepPhong.getTableHeader().setReorderingAllowed(false);
        tb_QLSV_XepPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_QLSV_XepPhongMouseClicked(evt);
            }
        });
        scrollPane_QLSV_XepPhong_Table.setViewportView(tb_QLSV_XepPhong);

        btn_QLSV_XepPhong_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_QLSV_XepPhong_Luu.setText("Lưu");
        btn_QLSV_XepPhong_Luu.setToolTipText("");
        btn_QLSV_XepPhong_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_XepPhong_LuuActionPerformed(evt);
            }
        });

        btn_QLSV_XepPhong_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
        btn_QLSV_XepPhong_Huy.setText("Hủy");
        btn_QLSV_XepPhong_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_XepPhong_HuyActionPerformed(evt);
            }
        });

        btn_QLSV_XepPhong_ThuPhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/get-money.png"))); // NOI18N
        btn_QLSV_XepPhong_ThuPhi.setText("Thu Phí");
        btn_QLSV_XepPhong_ThuPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_XepPhong_ThuPhiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_XepPhongLayout = new javax.swing.GroupLayout(pn_XepPhong);
        pn_XepPhong.setLayout(pn_XepPhongLayout);
        pn_XepPhongLayout.setHorizontalGroup(
            pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_XepPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_QLSV_XepPhong_LoaiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_QLSV_XepPhong_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_QLSV_XepPhong_Huy)
                        .addComponent(btn_QLSV_XepPhong_ThuPhi))
                    .addComponent(btn_QLSV_XepPhong_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(scrollPane_QLSV_XepPhong_Table, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lb_QLSV_XepPhong_XepPhongSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_XepPhongLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_QLSV_XepPhong_Huy, btn_QLSV_XepPhong_Luu, btn_QLSV_XepPhong_ThuPhi});

        pn_XepPhongLayout.setVerticalGroup(
            pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_XepPhongLayout.createSequentialGroup()
                .addComponent(lb_QLSV_XepPhong_XepPhongSV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_XepPhongLayout.createSequentialGroup()
                        .addGroup(pn_XepPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_QLSV_XepPhong_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_XepPhongLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btn_QLSV_XepPhong_Luu)
                                .addGap(18, 18, 18)
                                .addComponent(btn_QLSV_XepPhong_Huy)
                                .addGap(18, 18, 18)
                                .addComponent(btn_QLSV_XepPhong_ThuPhi)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_QLSV_XepPhong_LoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(84, Short.MAX_VALUE))
                    .addComponent(scrollPane_QLSV_XepPhong_Table)))
        );

        pn_XepPhongLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_QLSV_XepPhong_Huy, btn_QLSV_XepPhong_Luu, btn_QLSV_XepPhong_ThuPhi});

        tab_QuanLySinhVien.addTab("Xếp Phòng", new javax.swing.ImageIcon(getClass().getResource("/Images/apartments.png")), pn_XepPhong); // NOI18N

        pn_CapNhatHoSoSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        lb_CapNhatThongTinSV_HoSoSV.setBackground(new java.awt.Color(0, 153, 255));
        lb_CapNhatThongTinSV_HoSoSV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_CapNhatThongTinSV_HoSoSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_CapNhatThongTinSV_HoSoSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_CapNhatThongTinSV_HoSoSV.setText("HỒ SƠ SINH VIÊN");
        lb_CapNhatThongTinSV_HoSoSV.setOpaque(true);

        pn_CapNhatHoSo_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_CapNhatHoSo_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_CapNhatThongTinSV_HoSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_HoSinhVien.setText("Họ Sinh Viên:");

        lb_CapNhatThongTinSV_ThongTin_TenSV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_TenSV.setText("Tên Sinh Viên:");

        lb_CapNhatThongTinSV_ThongTin_DanToc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_DanToc.setText("Dân Tộc:");

        lb_CapNhatThongTinSV_ThongTin_TonGiao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_TonGiao.setText("Tôn Giáo:");

        lb_CapNhatThongTinSV_ThongTin_CMND.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_CMND.setText("CMND:");

        lb_CapNhatThongTinSV_ThongTin_NgayCap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_NgayCap.setText("Ngày Cấp:");

        lb_CapNhatThongTinSV_ThongTin_QuocTich.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_QuocTich.setText("Quốc Tịch:");

        lb_CapNhatThongTinSV_ThongTin_Tinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_Tinh.setText("Tỉnh/TP:");

        lb_CapNhatThongTinSV_ThongTin_NgaySinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_NgaySinh.setText("Ngày Sinh:");

        lb_CapNhatThongTinSV_ThongTin_GioiTinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_GioiTinh.setText("Giới Tính:");

        lb_CapNhatThongTinSV_ThongTin_DiaChiNha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_DiaChiNha.setText("Địa Chỉ Nhà:");

        lb_CapNhatThongTinSV_ThongTin_MSSV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_MSSV.setText("MSSV:");

        lb_CapNhatThongTinSV_ThongTin_SDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_SDT.setText("Số Điện Thoại:");

        lb_CapNhatThongTinSV_ThongTin_Truong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_ThongTin_Truong.setText("Trường:");

        btn_CapNhatThongTinSV_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_CapNhatThongTinSV_Luu.setText("Lưu");
        btn_CapNhatThongTinSV_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatThongTinSV_LuuActionPerformed(evt);
            }
        });

        btn_CapNhatThongTinSV_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
        btn_CapNhatThongTinSV_Huy.setText("Hủy");
        btn_CapNhatThongTinSV_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatThongTinSV_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_CapNhatHoSo_ThongTinLayout = new javax.swing.GroupLayout(pn_CapNhatHoSo_ThongTin);
        pn_CapNhatHoSo_ThongTin.setLayout(pn_CapNhatHoSo_ThongTinLayout);
        pn_CapNhatHoSo_ThongTinLayout.setHorizontalGroup(
            pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_MSSV)
                        .addGap(59, 59, 59))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_CapNhatThongTinSV_HoSinhVien)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_CMND)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_NgaySinh)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_Truong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_CapNhatThongTinSV_ThongTin_HoSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(tf_CapNhatThongTinSV_CMND)
                    .addComponent(dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(tf_CapNhatThongTinSV_MSSV)
                    .addComponent(cb_CapNhatThongTinSV_Truong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_TenSV)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_NgayCap)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_GioiTinh))
                        .addGap(5, 5, 5)
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_CapNhatThongTinSV_ThongTin_TenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(dateChooser_CapNhatThongTinSV_ThongTin_NgayCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_CapNhatThongTinSV_GioiTinh, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_SDT)))
                .addGap(45, 45, 45)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_CapNhatThongTinSV_ThongTin_DanToc)
                    .addComponent(lb_CapNhatThongTinSV_ThongTin_QuocTich)
                    .addComponent(lb_CapNhatThongTinSV_ThongTin_DiaChiNha))
                .addGap(23, 23, 23)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                                .addComponent(tf_CapNhatThongTinSV_ThongTin_DanToc, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lb_CapNhatThongTinSV_ThongTin_TonGiao))
                            .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                                .addComponent(tf_CapNhatThongTinSV_ThongTin_QuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lb_CapNhatThongTinSV_ThongTin_Tinh)))
                        .addGap(40, 40, 40)
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_CapNhatThongTinSV_ThongTin_TonGiao)
                            .addComponent(cb_CapNhatThongTinSV_ThongTin_Tinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_CapNhatThongTinSV_ThongTin_DiaChiNha, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                                .addComponent(btn_CapNhatThongTinSV_Luu)
                                .addGap(29, 29, 29)
                                .addComponent(btn_CapNhatThongTinSV_Huy)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_CapNhatHoSo_ThongTinLayout.setVerticalGroup(
            pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_TonGiao)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_DanToc)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_DanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_TonGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_TenSV)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_TenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_HoSinhVien)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_HoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_CapNhatThongTinSV_ThongTin_Tinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_CapNhatThongTinSV_ThongTin_CMND)
                            .addComponent(tf_CapNhatThongTinSV_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dateChooser_CapNhatThongTinSV_ThongTin_NgayCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_CapNhatThongTinSV_ThongTin_NgayCap)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_QuocTich)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_QuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_Tinh)))
                .addGap(28, 28, 28)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_NgaySinh)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_DiaChiNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_DiaChiNha))
                    .addComponent(dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_GioiTinh)
                        .addComponent(tf_CapNhatThongTinSV_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_MSSV)
                        .addComponent(tf_CapNhatThongTinSV_MSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_ThongTin_SDT)
                        .addComponent(tf_CapNhatThongTinSV_ThongTin_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_CapNhatThongTinSV_Luu)
                        .addComponent(btn_CapNhatThongTinSV_Huy)))
                .addGap(12, 12, 12)
                .addGroup(pn_CapNhatHoSo_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_CapNhatThongTinSV_Truong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_CapNhatThongTinSV_ThongTin_Truong))
                .addContainerGap())
        );

        lb_CapNhatThongTinSV_MaKTX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_CapNhatThongTinSV_MaKTX.setText("Mã KTX:");

        tf_CapNhatThongTinSinhVien_MaKTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CapNhatThongTinSinhVien_MaKTXActionPerformed(evt);
            }
        });

        btn_CapNhatThongTinSinhVien_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-engine.png"))); // NOI18N
        btn_CapNhatThongTinSinhVien_Search.setText("Search");
        btn_CapNhatThongTinSinhVien_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatThongTinSinhVien_SearchActionPerformed(evt);
            }
        });

        tb_CapNhatThongTinSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KTX", "MSSV", "Họ Sinh Viên", "Tên Sinh Viên", "Giới Tính", "Ngày Sinh", "CMND", "Ngày Cấp", "Trường", "SĐT", "Địa Chỉ", "Tỉnh", "Dân Tộc", "Tôn Giáo", "Quốc Tịch"
            }
        ));
        tb_CapNhatThongTinSinhVien.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tb_CapNhatThongTinSinhVien);

        javax.swing.GroupLayout pn_CapNhatHoSoSinhVienLayout = new javax.swing.GroupLayout(pn_CapNhatHoSoSinhVien);
        pn_CapNhatHoSoSinhVien.setLayout(pn_CapNhatHoSoSinhVienLayout);
        pn_CapNhatHoSoSinhVienLayout.setHorizontalGroup(
            pn_CapNhatHoSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_CapNhatThongTinSV_HoSoSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_CapNhatHoSo_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CapNhatHoSoSinhVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_CapNhatThongTinSV_MaKTX)
                .addGap(18, 18, 18)
                .addComponent(tf_CapNhatThongTinSinhVien_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_CapNhatThongTinSinhVien_Search)
                .addGap(320, 320, 320))
        );
        pn_CapNhatHoSoSinhVienLayout.setVerticalGroup(
            pn_CapNhatHoSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CapNhatHoSoSinhVienLayout.createSequentialGroup()
                .addComponent(lb_CapNhatThongTinSV_HoSoSV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_CapNhatHoSo_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_CapNhatHoSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_CapNhatThongTinSinhVien_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_CapNhatHoSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_CapNhatThongTinSV_MaKTX)
                        .addComponent(btn_CapNhatThongTinSinhVien_Search)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
        );

        tab_QuanLySinhVien.addTab("Cập Nhật Hồ Sơ Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Images/student.png")), pn_CapNhatHoSoSinhVien); // NOI18N

        pn_XuLySinhVienRaKhoiKTX.setBackground(new java.awt.Color(255, 255, 255));

        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX.setBackground(new java.awt.Color(0, 153, 255));
        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX.setForeground(new java.awt.Color(255, 255, 255));
        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX.setText("XỬ LÝ SINH VIÊN RA KTX");
        lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX.setOpaque(true);

        pn_QLSV_XuLySVKhoiKTX_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_QLSV_XuLySVKhoiKTX_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_QLSV_XuLySVKhoiKTX_MaKTX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_QLSV_XuLySVKhoiKTX_MaKTX.setText("Mã KTX:");

        tf_QLSV_XuLySVKhoiKTX_MaKTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_QLSV_XuLySVKhoiKTX_MaKTXActionPerformed(evt);
            }
        });

        pn_QLSV_XuLySVRaKhoiKTX_ChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pn_QLSV_XuLySVRaKhoiKTX_ChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chi Tiết"));

        lb_QLSV_XuLySVRaKhoiKTX_HoTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_HoTen.setText("Họ Tên:");

        lb_QLSV_XuLySVRaKhoiKTX_NgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_NgaySinh.setText("Ngày Sinh:");

        lb_QLSV_XuLySVRaKhoiKTX_GioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_GioiTinh.setText("Giới Tính:");

        lb_QLSV_XuLySVRaKhoiKTX_MSSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_MSSV.setText("MSSV:");

        lb_QLSV_XuLySVRaKhoiKTX_Truong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_Truong.setText("Trường:");

        lb_QLSV_XuLySVRaKhoiKTX_Nha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_Nha.setText("Nhà:");

        lb_QLSV_XuLySVRaKhoiKTX_Phong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_Phong.setText("Phòng:");

        lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lb_QLSV_XuLySVRaKhoiKTX_CMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_CMND.setText("CMND:");

        lb_QLSV_XuLySVRaKhoiKTX_NamHoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_NamHoc.setText("Năm Học:");

        lb_QLSV_XuLySVRaKhoiKTX_HocKy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_HocKy.setText("Học Kỳ:");

        lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru.setText("Phí Nội Trú:");

        lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra.setText("Phí Hoàn Trả:");

        javax.swing.GroupLayout pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout = new javax.swing.GroupLayout(pn_QLSV_XuLySVRaKhoiKTX_ChiTiet);
        pn_QLSV_XuLySVRaKhoiKTX_ChiTiet.setLayout(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout);
        pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.setHorizontalGroup(
            pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_QLSV_XuLySVRaKhoiKTX_MSSV)
                        .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Truong)
                        .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_QLSV_XuLySVRaKhoiKTX_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_CMND)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NamHoc)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HocKy)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HoTen)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Nha)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Phong)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Phong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NamHoc_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Nha_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Truong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_MSSV_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_GioiTinh_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NgaySinh_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_CMND_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.setVerticalGroup(
            pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createSequentialGroup()
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_CMND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_CMND_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NgaySinh)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NgaySinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_GioiTinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_GioiTinh))
                .addGap(14, 14, 14)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_MSSV)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_MSSV_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Truong)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Truong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Nha)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Phong)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_Phong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NamHoc)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_NamHoc_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HocKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_QLSV_XuLySVRaKhoiKTX_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_QLSV_XuLySVKhoiKTX_ThongTinLayout = new javax.swing.GroupLayout(pn_QLSV_XuLySVKhoiKTX_ThongTin);
        pn_QLSV_XuLySVKhoiKTX_ThongTin.setLayout(pn_QLSV_XuLySVKhoiKTX_ThongTinLayout);
        pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.setHorizontalGroup(
            pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_QLSV_XuLySVKhoiKTX_MaKTX)
                        .addGap(18, 18, 18)
                        .addComponent(tf_QLSV_XuLySVKhoiKTX_MaKTX))
                    .addComponent(pn_QLSV_XuLySVRaKhoiKTX_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.setVerticalGroup(
            pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_QLSV_XuLySVKhoiKTX_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_QLSV_XuLySVKhoiKTX_MaKTX)
                    .addComponent(tf_QLSV_XuLySVKhoiKTX_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_QLSV_XuLySVRaKhoiKTX_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_QLSV_XuLySVKhoiKTX_XacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_QLSV_XuLySVKhoiKTX_XacNhan.setText("Xác Nhận");
        btn_QLSV_XuLySVKhoiKTX_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_XuLySVKhoiKTX_XacNhanActionPerformed(evt);
            }
        });

        btn_QLSV_XuLySVKhoiKTX_XuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer.png"))); // NOI18N
        btn_QLSV_XuLySVKhoiKTX_XuatHoaDon.setText("Xuât Hóa Đơn");
        btn_QLSV_XuLySVKhoiKTX_XuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QLSV_XuLySVKhoiKTX_XuatHoaDonActionPerformed(evt);
            }
        });

        tb_QLSV_XuLySVKhoiKTX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ Sinh Viên", "Tên Sinh Viên", "MSSV", "Trường", "Nhà", "Phòng", "Năm Học", "Học Kỳ", "Đã Thu", "Phí Hoàn Trả"
            }
        ));
        scrollPane_QLSV_XuLySVKhoiKTX_Table.setViewportView(tb_QLSV_XuLySVKhoiKTX);

        javax.swing.GroupLayout pn_XuLySinhVienRaKhoiKTXLayout = new javax.swing.GroupLayout(pn_XuLySinhVienRaKhoiKTX);
        pn_XuLySinhVienRaKhoiKTX.setLayout(pn_XuLySinhVienRaKhoiKTXLayout);
        pn_XuLySinhVienRaKhoiKTXLayout.setHorizontalGroup(
            pn_XuLySinhVienRaKhoiKTXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createSequentialGroup()
                .addComponent(pn_QLSV_XuLySVKhoiKTX_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_QLSV_XuLySVKhoiKTX_XuatHoaDon)
                    .addComponent(btn_QLSV_XuLySVKhoiKTX_XacNhan))
                .addGap(18, 18, 18)
                .addComponent(scrollPane_QLSV_XuLySVKhoiKTX_Table, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
            .addComponent(lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_XuLySinhVienRaKhoiKTXLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_QLSV_XuLySVKhoiKTX_XacNhan, btn_QLSV_XuLySVKhoiKTX_XuatHoaDon});

        pn_XuLySinhVienRaKhoiKTXLayout.setVerticalGroup(
            pn_XuLySinhVienRaKhoiKTXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createSequentialGroup()
                .addComponent(lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pn_QLSV_XuLySVKhoiKTX_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btn_QLSV_XuLySVKhoiKTX_XacNhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_QLSV_XuLySVKhoiKTX_XuatHoaDon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn_XuLySinhVienRaKhoiKTXLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scrollPane_QLSV_XuLySVKhoiKTX_Table, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))))
        );

        pn_XuLySinhVienRaKhoiKTXLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_QLSV_XuLySVKhoiKTX_XacNhan, btn_QLSV_XuLySVKhoiKTX_XuatHoaDon});

        tab_QuanLySinhVien.addTab("Xử Lý Sinh Viên Ra Khỏi KTX", new javax.swing.ImageIcon(getClass().getResource("/Images/door.png")), pn_XuLySinhVienRaKhoiKTX); // NOI18N

        scrollPanel_QLSV.setViewportView(tab_QuanLySinhVien);

        tab_Main.addTab("Quản Lý Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Images/collaboration.png")), scrollPanel_QLSV); // NOI18N

        tab_ThuPhi.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_ThuPhi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pn_ThuPhi_PhiNoiTru.setBackground(new java.awt.Color(255, 255, 255));

        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru.setBackground(new java.awt.Color(0, 153, 255));
        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru.setForeground(new java.awt.Color(255, 255, 255));
        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru.setText("THU PHÍ NỘI TRÚ");
        lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru.setOpaque(true);

        pn_ThuPhi_PhiNoiTru_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThuPhi_PhiNoiTru_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_ThuPhi_PhiNoiTru_MaKTX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_ThuPhi_PhiNoiTru_MaKTX.setText("Mã KTX:");

        tf_ThuPhi_PhiNoiTru_MaKTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ThuPhi_PhiNoiTru_MaKTXActionPerformed(evt);
            }
        });

        pn_ThuPhi_PhiNoiTru_ThongTinChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThuPhi_PhiNoiTru_ThongTinChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chi Tiết"));

        lb_ThuPhi_PhiNoiTru_HoTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_HoTen.setText("Họ Tên:");

        lb_ThuPhi_PhiNoiTru_NgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_NgaySinh.setText("Ngày Sinh:");

        lb_ThuPhi_PhiNoiTru_GioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_GioiTinh.setText("Giới Tính:");

        lb_ThuPhi_PhiNoiTru_MSSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_MSSV.setText("MSSV:");

        lb_ThuPhi_PhiNoiTru_Truong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_Truong.setText("Trường:");

        lb_ThuPhi_PhiNoiTru_Nha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_Nha.setText("Nhà:");

        lb_ThuPhi_PhiNoiTru_Phong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_Phong.setText("Phòng:");

        lb_ThuPhi_PhiNoiTru_CMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_CMND.setText("CMND:");

        lb_ThuPhi_PhiNoiTru_NamHoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_NamHoc.setText("Năm Học:");

        lb_ThuPhi_PhiNoiTru_HocKy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_HocKy.setText("Học Kỳ:");

        lb_ThuPhi_PhiNoiTru_PhiNoiTru.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiNoiTru_PhiNoiTru.setText("Phí Nội Trú,CSVC:");

        javax.swing.GroupLayout pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout = new javax.swing.GroupLayout(pn_ThuPhi_PhiNoiTru_ThongTinChiTiet);
        pn_ThuPhi_PhiNoiTru_ThongTinChiTiet.setLayout(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout);
        pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.setHorizontalGroup(
            pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createSequentialGroup()
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_ThuPhi_PhiNoiTru_MSSV)
                        .addComponent(lb_ThuPhi_PhiNoiTru_Truong)
                        .addComponent(lb_ThuPhi_PhiNoiTru_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_ThuPhi_PhiNoiTru_CMND)
                    .addComponent(lb_ThuPhi_PhiNoiTru_NamHoc)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HocKy)
                    .addComponent(lb_ThuPhi_PhiNoiTru_PhiNoiTru)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HoTen)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Nha)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Phong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_ThuPhi_PhiNoiTru_NamHoc_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_CMND_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_NgaySinh_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_GioiTinh_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_MSSV_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_Truong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_Nha_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ThuPhi_PhiNoiTru_Phong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.setVerticalGroup(
            pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_ThuPhi_PhiNoiTru_CMND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_CMND_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_NgaySinh)
                    .addComponent(lb_ThuPhi_PhiNoiTru_NgaySinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_GioiTinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_GioiTinh))
                .addGap(14, 14, 14)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_MSSV_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_MSSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Truong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Truong))
                .addGap(12, 12, 12)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Nha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Phong_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_Phong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiNoiTru_NamHoc_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_NamHoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HocKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_ThuPhi_PhiNoiTru_PhiNoiTru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_ThuPhi_PhiNoiTru_ThongTinLayout = new javax.swing.GroupLayout(pn_ThuPhi_PhiNoiTru_ThongTin);
        pn_ThuPhi_PhiNoiTru_ThongTin.setLayout(pn_ThuPhi_PhiNoiTru_ThongTinLayout);
        pn_ThuPhi_PhiNoiTru_ThongTinLayout.setHorizontalGroup(
            pn_ThuPhi_PhiNoiTru_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ThuPhi_PhiNoiTru_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ThuPhi_PhiNoiTru_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pn_ThuPhi_PhiNoiTru_ThongTinChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_ThuPhi_PhiNoiTru_ThongTinLayout.setVerticalGroup(
            pn_ThuPhi_PhiNoiTru_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ThuPhi_PhiNoiTru_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ThuPhi_PhiNoiTru_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ThuPhi_PhiNoiTru_MaKTX))
                .addGap(18, 18, 18)
                .addComponent(pn_ThuPhi_PhiNoiTru_ThongTinChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_ThuPhi_PhiNoiTru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_ThuPhi_PhiNoiTru.setText("Thu Phí");
        btn_ThuPhi_PhiNoiTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThuPhi_PhiNoiTruActionPerformed(evt);
            }
        });

        btn_ThuPhi_PhiNoiTru_XuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer.png"))); // NOI18N
        btn_ThuPhi_PhiNoiTru_XuatHoaDon.setText("Xuất Hóa Đơn");
        btn_ThuPhi_PhiNoiTru_XuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThuPhi_PhiNoiTru_XuatHoaDonActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tb_ThuPhi_PhiNoiTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ Sinh Viên", "Tên Sinh Viên", "MSSV", "Trường", "Nhà", "Phòng", "Năm Học", "Học Kỳ", "Đã Thu"
            }
        ));
        tb_ThuPhi_PhiNoiTru.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tb_ThuPhi_PhiNoiTru);

        javax.swing.GroupLayout pn_ThuPhi_PhiNoiTruLayout = new javax.swing.GroupLayout(pn_ThuPhi_PhiNoiTru);
        pn_ThuPhi_PhiNoiTru.setLayout(pn_ThuPhi_PhiNoiTruLayout);
        pn_ThuPhi_PhiNoiTruLayout.setHorizontalGroup(
            pn_ThuPhi_PhiNoiTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThuPhi_PhiNoiTruLayout.createSequentialGroup()
                .addComponent(pn_ThuPhi_PhiNoiTru_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_ThuPhi_PhiNoiTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ThuPhi_PhiNoiTru)
                    .addComponent(btn_ThuPhi_PhiNoiTru_XuatHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pn_ThuPhi_PhiNoiTruLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_ThuPhi_PhiNoiTruLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_ThuPhi_PhiNoiTru, btn_ThuPhi_PhiNoiTru_XuatHoaDon});

        pn_ThuPhi_PhiNoiTruLayout.setVerticalGroup(
            pn_ThuPhi_PhiNoiTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiNoiTruLayout.createSequentialGroup()
                .addComponent(lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pn_ThuPhi_PhiNoiTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThuPhi_PhiNoiTruLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pn_ThuPhi_PhiNoiTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                            .addComponent(pn_ThuPhi_PhiNoiTru_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pn_ThuPhi_PhiNoiTruLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btn_ThuPhi_PhiNoiTru)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ThuPhi_PhiNoiTru_XuatHoaDon)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pn_ThuPhi_PhiNoiTruLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_ThuPhi_PhiNoiTru, btn_ThuPhi_PhiNoiTru_XuatHoaDon});

        tab_ThuPhi.addTab("Phí Nội Trú", new javax.swing.ImageIcon(getClass().getResource("/Images/cityscape.png")), pn_ThuPhi_PhiNoiTru); // NOI18N

        pn_ThuPhi_PhiDienNuoc.setBackground(new java.awt.Color(255, 255, 255));

        lb_ThuPhi_ThuPhiDienNuoc.setBackground(new java.awt.Color(0, 153, 255));
        lb_ThuPhi_ThuPhiDienNuoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_ThuPhi_ThuPhiDienNuoc.setForeground(new java.awt.Color(255, 255, 255));
        lb_ThuPhi_ThuPhiDienNuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ThuPhi_ThuPhiDienNuoc.setText("THU PHÍ ĐIỆN NƯỚC");
        lb_ThuPhi_ThuPhiDienNuoc.setOpaque(true);

        pn_ThuPhi_PhiDienNuoc_ThongTinPhong.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThuPhi_PhiDienNuoc_ThongTinPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_ThuPhi_PhiDienNuoc_KhoiNha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_KhoiNha.setText("Khối Nhà:");

        cb_ThuPhi_PhiDienNuoc_KhoiNha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ThuPhi_PhiDienNuoc_KhoiNhaActionPerformed(evt);
            }
        });

        lb_ThuPhi_PhiDienNuoc_TenPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_TenPhong.setText("Phòng:");

        cb_ThuPhi_PhiDienNuoc_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ThuPhi_PhiDienNuoc_PhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout = new javax.swing.GroupLayout(pn_ThuPhi_PhiDienNuoc_ThongTinPhong);
        pn_ThuPhi_PhiDienNuoc_ThongTinPhong.setLayout(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout);
        pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.setHorizontalGroup(
            pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_KhoiNha)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_TenPhong))
                .addGap(71, 71, 71)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_ThuPhi_PhiDienNuoc_KhoiNha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_ThuPhi_PhiDienNuoc_Phong, 0, 99, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.setVerticalGroup(
            pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_KhoiNha)
                    .addComponent(cb_ThuPhi_PhiDienNuoc_KhoiNha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_TenPhong)
                    .addComponent(cb_ThuPhi_PhiDienNuoc_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btn_ThuPhi_PhiDienNuoc_ThuPhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_ThuPhi_PhiDienNuoc_ThuPhi.setText("Thu Phí");
        btn_ThuPhi_PhiDienNuoc_ThuPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThuPhi_PhiDienNuoc_ThuPhiActionPerformed(evt);
            }
        });

        tb_ThuPhiDienNuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phòng", "Nhà", "Tháng", "Năm", "Ngày Thu", "Tiền Điện", "Tiền Nước", "Tổng Cộng", "Đã Thu"
            }
        ));
        jScrollPane3.setViewportView(tb_ThuPhiDienNuoc);

        pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_ThuPhi_PhiDienNuoc_ThangNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_ThangNam.setText("Tháng / Năm:");

        lb_ThuPhi_PhiDienNuoc_Phong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_Phong.setText("Phòng:");

        lb_ThuPhi_PhiDienNuoc_Nha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_Nha.setText("Nhà:");

        lb_ThuPhi_PhiDienNuoc_SoKWDien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_SoKWDien.setText("Điện tiêu thụ:");

        lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc.setText("Nước tiêu thụ:");

        lb_ThuPhi_PhiDienNuoc_TienDien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_TienDien.setText("Tiền Điện:");

        lb_ThuPhi_PhiDienNuoc_TienNuoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_TienNuoc.setText("Tiền Nước:");

        lb_ThuPhi_PhiDienNuoc_TongCong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_ThuPhi_PhiDienNuoc_TongCong.setText("Tổng Cộng:");

        javax.swing.GroupLayout pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout = new javax.swing.GroupLayout(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc);
        pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc.setLayout(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout);
        pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.setHorizontalGroup(
            pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_SoKWDien)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_Phong)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_TienDien)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_ThangNam)
                    .addComponent(lb_ThuPhi_PhiDienNuoc_TongCong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                        .addComponent(lb_ThuPhi_PhiDienNuoc_TongCong_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(200, 200, 200))
                    .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                        .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_SoKWDien_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_TienDien_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_Phong_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_TienNuoc)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_Nha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_TienNuoc_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_ThuPhi_PhiDienNuoc_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lb_ThuPhi_PhiDienNuoc_ThangNam_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.setVerticalGroup(
            pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lb_ThuPhi_PhiDienNuoc_Phong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                            .addComponent(lb_ThuPhi_PhiDienNuoc_ThangNam)
                            .addGap(28, 28, 28)
                            .addComponent(lb_ThuPhi_PhiDienNuoc_Phong))
                        .addComponent(lb_ThuPhi_PhiDienNuoc_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_ThuPhi_PhiDienNuoc_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_ThuPhi_PhiDienNuoc_ThangNam_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                        .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                                .addComponent(lb_ThuPhi_PhiDienNuoc_SoKWDien_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(38, 38, 38)
                        .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_ThuPhi_PhiDienNuoc_TienDien_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_ThuPhi_PhiDienNuoc_TienNuoc_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                        .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createSequentialGroup()
                                .addComponent(lb_ThuPhi_PhiDienNuoc_SoKWDien)
                                .addGap(40, 40, 40)
                                .addComponent(lb_ThuPhi_PhiDienNuoc_TienDien))
                            .addComponent(lb_ThuPhi_PhiDienNuoc_TienNuoc))
                        .addGap(34, 34, 34)
                        .addGroup(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_ThuPhi_PhiDienNuoc_TongCong)
                            .addComponent(lb_ThuPhi_PhiDienNuoc_TongCong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_ThuPhi_PhiDienNuocLayout = new javax.swing.GroupLayout(pn_ThuPhi_PhiDienNuoc);
        pn_ThuPhi_PhiDienNuoc.setLayout(pn_ThuPhi_PhiDienNuocLayout);
        pn_ThuPhi_PhiDienNuocLayout.setHorizontalGroup(
            pn_ThuPhi_PhiDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiDienNuocLayout.createSequentialGroup()
                .addGroup(pn_ThuPhi_PhiDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_ThuPhi_PhiDienNuoc_ThongTinPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ThuPhi_PhiDienNuoc_ThuPhi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lb_ThuPhi_ThuPhiDienNuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_ThuPhi_PhiDienNuocLayout.setVerticalGroup(
            pn_ThuPhi_PhiDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThuPhi_PhiDienNuocLayout.createSequentialGroup()
                .addComponent(lb_ThuPhi_ThuPhiDienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pn_ThuPhi_PhiDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ThuPhi_PhiDienNuocLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btn_ThuPhi_PhiDienNuoc_ThuPhi))
                    .addGroup(pn_ThuPhi_PhiDienNuocLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(pn_ThuPhi_PhiDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addGroup(pn_ThuPhi_PhiDienNuocLayout.createSequentialGroup()
                                .addComponent(pn_ThuPhi_PhiDienNuoc_ThongTinPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        tab_ThuPhi.addTab("Phí Điện Nước", new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png")), pn_ThuPhi_PhiDienNuoc); // NOI18N

        scrollPanel_ThuPhi.setViewportView(tab_ThuPhi);

        tab_Main.addTab("Thu Phí", new javax.swing.ImageIcon(getClass().getResource("/Images/dollar-symbol.png")), scrollPanel_ThuPhi); // NOI18N

        tab_HoanTraPhi.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_HoanTraPhi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pn_HoanTraPhiCSVC.setBackground(new java.awt.Color(255, 255, 255));

        lb_HoanTraPhiCSVC.setBackground(new java.awt.Color(0, 153, 255));
        lb_HoanTraPhiCSVC.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_HoanTraPhiCSVC.setForeground(new java.awt.Color(255, 255, 255));
        lb_HoanTraPhiCSVC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_HoanTraPhiCSVC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loan.png"))); // NOI18N
        lb_HoanTraPhiCSVC.setText("HOÀN TRẢ TIỀN THẾ CHÂN CƠ SỞ VẬT CHẤT");
        lb_HoanTraPhiCSVC.setOpaque(true);

        pn_HoanTraPhiCSVC_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_HoanTraPhiCSVC_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_HoanTraPhiCSVC_NamHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_HoanTraPhiCSVC_NamHoc.setText("Năm Học:");

        lb_HoanTraPhiCSVC_MaKTX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_HoanTraPhiCSVC_MaKTX.setText("Mã KTX:");

        tf_HoanTraPhiCSVC_MaKTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_HoanTraPhiCSVC_MaKTXActionPerformed(evt);
            }
        });

        pn_HoanTraPhiCSVC_ChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pn_HoanTraPhiCSVC_ChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chi Tiết"));

        lb_HoanTraPhiCSVC_HoTen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_HoTen.setText("Họ Tên:");

        lb_HoanTraPhiCSVC_GioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_GioiTinh.setText("Giới Tính:");
        lb_HoanTraPhiCSVC_GioiTinh.setToolTipText("");

        lb_HoanTraPhiCSVC_MSSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_MSSV.setText("MSSV:");

        lb_HoanTraPhiCSVC_Truong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_Truong.setText("Trường:");

        lb_HoanTraPhiCSVC_Nha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_Nha.setText("Nhà:");

        lb_HoanTraPhiCSVC_Phong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_Phong.setText("Phòng:");

        lb_HoanTraPhiCSVC_PhiHoanTra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoanTraPhiCSVC_PhiHoanTra.setText("Phí Hoàn Trả:");

        javax.swing.GroupLayout pn_HoanTraPhiCSVC_ChiTietLayout = new javax.swing.GroupLayout(pn_HoanTraPhiCSVC_ChiTiet);
        pn_HoanTraPhiCSVC_ChiTiet.setLayout(pn_HoanTraPhiCSVC_ChiTietLayout);
        pn_HoanTraPhiCSVC_ChiTietLayout.setHorizontalGroup(
            pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_HoanTraPhiCSVC_Phong)
                    .addComponent(lb_HoanTraPhiCSVC_Nha)
                    .addComponent(lb_HoanTraPhiCSVC_Truong)
                    .addComponent(lb_HoanTraPhiCSVC_MSSV)
                    .addComponent(lb_HoanTraPhiCSVC_GioiTinh)
                    .addComponent(lb_HoanTraPhiCSVC_HoTen)
                    .addComponent(lb_HoanTraPhiCSVC_PhiHoanTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_HoanTraPhiCSVC_Phong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_HoanTraPhiCSVC_PhiHoanTra_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_HoanTraPhiCSVC_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_HoanTraPhiCSVC_Truong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_HoanTraPhiCSVC_MSSV_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_HoanTraPhiCSVC_GioiTinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_HoanTraPhiCSVC_HoTen_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        pn_HoanTraPhiCSVC_ChiTietLayout.setVerticalGroup(
            pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_HoTen_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_GioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_GioiTinh_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_MSSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_MSSV_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_Truong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_Truong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_Nha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_Nha_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_Phong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_Phong_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_HoanTraPhiCSVC_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_HoanTraPhiCSVC_PhiHoanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_HoanTraPhiCSVC_PhiHoanTra_ChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_HoanTraPhiCSVC_ThongTinLayout = new javax.swing.GroupLayout(pn_HoanTraPhiCSVC_ThongTin);
        pn_HoanTraPhiCSVC_ThongTin.setLayout(pn_HoanTraPhiCSVC_ThongTinLayout);
        pn_HoanTraPhiCSVC_ThongTinLayout.setHorizontalGroup(
            pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_HoanTraPhiCSVC_ThongTinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_HoanTraPhiCSVC_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createSequentialGroup()
                        .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_HoanTraPhiCSVC_NamHoc)
                            .addComponent(lb_HoanTraPhiCSVC_MaKTX))
                        .addGap(18, 18, 18)
                        .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_HoanTraPhiCSVC_NamHoc, 0, 207, Short.MAX_VALUE)
                            .addComponent(tf_HoanTraPhiCSVC_MaKTX))))
                .addGap(18, 18, 18))
        );
        pn_HoanTraPhiCSVC_ThongTinLayout.setVerticalGroup(
            pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_HoanTraPhiCSVC_NamHoc)
                    .addComponent(cb_HoanTraPhiCSVC_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_HoanTraPhiCSVC_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_HoanTraPhiCSVC_MaKTX)
                    .addComponent(tf_HoanTraPhiCSVC_MaKTX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pn_HoanTraPhiCSVC_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 204));

        tb_HoanTraPhiCSVC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ Sinh Viên", "Tên Sinh Viên", "MSSV", "Trường", "Nhà", "Phòng", "Năm Học", "Phí Hoàn Trả"
            }
        ));
        jScrollPane1.setViewportView(tb_HoanTraPhiCSVC);

        btn_HoanTraPhiCSVC_XacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_HoanTraPhiCSVC_XacNhan.setText("Xác Nhận");
        btn_HoanTraPhiCSVC_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoanTraPhiCSVC_XacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_HoanTraPhiCSVCLayout = new javax.swing.GroupLayout(pn_HoanTraPhiCSVC);
        pn_HoanTraPhiCSVC.setLayout(pn_HoanTraPhiCSVCLayout);
        pn_HoanTraPhiCSVCLayout.setHorizontalGroup(
            pn_HoanTraPhiCSVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_HoanTraPhiCSVCLayout.createSequentialGroup()
                .addComponent(pn_HoanTraPhiCSVC_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_HoanTraPhiCSVC_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lb_HoanTraPhiCSVC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_HoanTraPhiCSVCLayout.setVerticalGroup(
            pn_HoanTraPhiCSVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HoanTraPhiCSVCLayout.createSequentialGroup()
                .addComponent(lb_HoanTraPhiCSVC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(pn_HoanTraPhiCSVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_HoanTraPhiCSVC_ThongTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_HoanTraPhiCSVCLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pn_HoanTraPhiCSVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_HoanTraPhiCSVCLayout.createSequentialGroup()
                                .addComponent(btn_HoanTraPhiCSVC_XacNhan)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))))
        );

        tab_HoanTraPhi.addTab("Tiền TC CSVC", new javax.swing.ImageIcon(getClass().getResource("/Images/desk.png")), pn_HoanTraPhiCSVC); // NOI18N

        scrollPanel_HoanTraPhi.setViewportView(tab_HoanTraPhi);

        tab_Main.addTab("Hoàn Trả Phí", new javax.swing.ImageIcon(getClass().getResource("/Images/banker.png")), scrollPanel_HoanTraPhi); // NOI18N

        tab_TraCuu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_TraCuu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pn_TraCuuSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        lb_TraCuu_SinhVien_TraCuuSV.setBackground(new java.awt.Color(0, 153, 255));
        lb_TraCuu_SinhVien_TraCuuSV.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_TraCuu_SinhVien_TraCuuSV.setForeground(new java.awt.Color(255, 255, 255));
        lb_TraCuu_SinhVien_TraCuuSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TraCuu_SinhVien_TraCuuSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student_32.png"))); // NOI18N
        lb_TraCuu_SinhVien_TraCuuSV.setText("TRA CỨU SINH VIÊN");
        lb_TraCuu_SinhVien_TraCuuSV.setOpaque(true);

        tf_TraCuu_SinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TraCuu_SinhVienActionPerformed(evt);
            }
        });

        btn_TraCuu_SinhVien_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-engine.png"))); // NOI18N
        btn_TraCuu_SinhVien_Search.setText("Search");
        btn_TraCuu_SinhVien_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TraCuu_SinhVien_SearchActionPerformed(evt);
            }
        });

        tb_TraCuu_SinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KTX", "Họ", "Tên", "Giới Tính", "Ngày Sinh", "MSSV", "Trường", "Nhà", "Phòng", "Tỉnh", "Dân Tộc", "Tôn Giáo", "Quốc Tịch"
            }
        ));
        tb_TraCuu_SinhVien.setCellSelectionEnabled(true);
        jScrollPane6.setViewportView(tb_TraCuu_SinhVien);

        javax.swing.GroupLayout pn_TraCuuSinhVienLayout = new javax.swing.GroupLayout(pn_TraCuuSinhVien);
        pn_TraCuuSinhVien.setLayout(pn_TraCuuSinhVienLayout);
        pn_TraCuuSinhVienLayout.setHorizontalGroup(
            pn_TraCuuSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TraCuuSinhVienLayout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addComponent(tf_TraCuu_SinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_TraCuu_SinhVien_Search)
                .addGap(368, 368, 368))
            .addComponent(lb_TraCuu_SinhVien_TraCuuSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_TraCuuSinhVienLayout.setVerticalGroup(
            pn_TraCuuSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuSinhVienLayout.createSequentialGroup()
                .addComponent(lb_TraCuu_SinhVien_TraCuuSV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pn_TraCuuSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TraCuu_SinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TraCuu_SinhVien_Search))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        tab_TraCuu.addTab("Thông Tin Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Images/collaboration.png")), pn_TraCuuSinhVien); // NOI18N

        pn_TraCuuPhong.setBackground(new java.awt.Color(255, 255, 255));

        lb_TraCuuPhong.setBackground(new java.awt.Color(0, 153, 255));
        lb_TraCuuPhong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_TraCuuPhong.setForeground(new java.awt.Color(255, 255, 255));
        lb_TraCuuPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TraCuuPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house.png"))); // NOI18N
        lb_TraCuuPhong.setText("TRA CỨU PHÒNG");
        lb_TraCuuPhong.setOpaque(true);

        lb_TraCuuPhong_Nha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuPhong_Nha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cityscape.png"))); // NOI18N
        lb_TraCuuPhong_Nha.setText("Nhà:");

        cb_TraCuu_ThongTinPhong_Nha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuu_ThongTinPhong_NhaActionPerformed(evt);
            }
        });

        lb_TraCuuPhong_Phong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuPhong_Phong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house.png"))); // NOI18N
        lb_TraCuuPhong_Phong.setText("Phòng:");

        cb_TraCuu_ThongTinPhong_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuu_ThongTinPhong_PhongActionPerformed(evt);
            }
        });

        tb_TraCuu_ThongTinPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tb_TraCuu_ThongTinPhong);

        javax.swing.GroupLayout pn_TraCuuPhongLayout = new javax.swing.GroupLayout(pn_TraCuuPhong);
        pn_TraCuuPhong.setLayout(pn_TraCuuPhongLayout);
        pn_TraCuuPhongLayout.setHorizontalGroup(
            pn_TraCuuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
            .addComponent(lb_TraCuuPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_TraCuuPhongLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(lb_TraCuuPhong_Nha)
                .addGap(18, 18, 18)
                .addComponent(cb_TraCuu_ThongTinPhong_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(lb_TraCuuPhong_Phong)
                .addGap(18, 18, 18)
                .addComponent(cb_TraCuu_ThongTinPhong_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_TraCuuPhongLayout.setVerticalGroup(
            pn_TraCuuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuPhongLayout.createSequentialGroup()
                .addComponent(lb_TraCuuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(pn_TraCuuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TraCuuPhong_Nha)
                    .addComponent(cb_TraCuu_ThongTinPhong_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TraCuuPhong_Phong)
                    .addComponent(cb_TraCuu_ThongTinPhong_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        tab_TraCuu.addTab("Thông Tin Phòng", new javax.swing.ImageIcon(getClass().getResource("/Images/apartments.png")), pn_TraCuuPhong); // NOI18N

        pn_TraCuuDienNuoc.setBackground(new java.awt.Color(255, 255, 255));

        lb_TraCuuDienNuoc.setBackground(new java.awt.Color(0, 153, 255));
        lb_TraCuuDienNuoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_TraCuuDienNuoc.setForeground(new java.awt.Color(255, 255, 255));
        lb_TraCuuDienNuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TraCuuDienNuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png"))); // NOI18N
        lb_TraCuuDienNuoc.setText("THÔNG TIN ĐIỆN NƯỚC");
        lb_TraCuuDienNuoc.setOpaque(true);

        pn_TraCuuDienNuoc_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_TraCuuDienNuoc_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_TraCuuDienNuoc_Nha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuDienNuoc_Nha.setText("Khối Nhà:");

        cb_TraCuuDienNuoc_Nha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuuDienNuoc_NhaActionPerformed(evt);
            }
        });

        lb_TraCuuDienNuoc_Phong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuDienNuoc_Phong.setText("Phòng:");

        cb_TraCuuDienNuoc_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuuDienNuoc_PhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_TraCuuDienNuoc_ThongTinLayout = new javax.swing.GroupLayout(pn_TraCuuDienNuoc_ThongTin);
        pn_TraCuuDienNuoc_ThongTin.setLayout(pn_TraCuuDienNuoc_ThongTinLayout);
        pn_TraCuuDienNuoc_ThongTinLayout.setHorizontalGroup(
            pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_TraCuuDienNuoc_Nha)
                    .addComponent(lb_TraCuuDienNuoc_Phong))
                .addGap(56, 56, 56)
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_TraCuuDienNuoc_Nha, 0, 142, Short.MAX_VALUE)
                    .addComponent(cb_TraCuuDienNuoc_Phong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pn_TraCuuDienNuoc_ThongTinLayout.setVerticalGroup(
            pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TraCuuDienNuoc_Nha)
                    .addComponent(cb_TraCuuDienNuoc_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TraCuuDienNuoc_Phong)
                    .addComponent(cb_TraCuuDienNuoc_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_TraCuuDienNuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tb_TraCuuDienNuoc);

        javax.swing.GroupLayout pn_TraCuuDienNuocLayout = new javax.swing.GroupLayout(pn_TraCuuDienNuoc);
        pn_TraCuuDienNuoc.setLayout(pn_TraCuuDienNuocLayout);
        pn_TraCuuDienNuocLayout.setHorizontalGroup(
            pn_TraCuuDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
            .addGroup(pn_TraCuuDienNuocLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(pn_TraCuuDienNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
            .addComponent(lb_TraCuuDienNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_TraCuuDienNuocLayout.setVerticalGroup(
            pn_TraCuuDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuDienNuocLayout.createSequentialGroup()
                .addComponent(lb_TraCuuDienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(pn_TraCuuDienNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
        );

        tab_TraCuu.addTab("Thông Tin Điện Nước", new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png")), pn_TraCuuDienNuoc); // NOI18N

        scrollPanel_TraCuu.setViewportView(tab_TraCuu);

        tab_Main.addTab("Tra Cứu", new javax.swing.ImageIcon(getClass().getResource("/Images/growth.png")), scrollPanel_TraCuu); // NOI18N

        tab_ThongKe.setBackground(new java.awt.Color(255, 255, 255));
        tab_ThongKe.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab_ThongKe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        pn_ThongKeTongThu.setBackground(new java.awt.Color(255, 255, 255));

        lb_ThongKeTongThu.setBackground(new java.awt.Color(0, 153, 255));
        lb_ThongKeTongThu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_ThongKeTongThu.setForeground(new java.awt.Color(255, 255, 255));
        lb_ThongKeTongThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ThongKeTongThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bars-chart.png"))); // NOI18N
        lb_ThongKeTongThu.setText("THỐNG KÊ TỔNG THU KTX ");
        lb_ThongKeTongThu.setOpaque(true);

        pn_ThongKeTongThu_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThongKeTongThu_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_ThongKeTongThu_NamHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_ThongKeTongThu_NamHoc.setText("Năm Học: ");

        cb_ThongKeTongThu_NamHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ThongKeTongThu_NamHocActionPerformed(evt);
            }
        });

        lb_ThongKeTongThu_HocKy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_ThongKeTongThu_HocKy.setText("Học Kỳ:");

        javax.swing.GroupLayout pn_ThongKeTongThu_ThongTinLayout = new javax.swing.GroupLayout(pn_ThongKeTongThu_ThongTin);
        pn_ThongKeTongThu_ThongTin.setLayout(pn_ThongKeTongThu_ThongTinLayout);
        pn_ThongKeTongThu_ThongTinLayout.setHorizontalGroup(
            pn_ThongKeTongThu_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeTongThu_ThongTinLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pn_ThongKeTongThu_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ThongKeTongThu_NamHoc)
                    .addComponent(lb_ThongKeTongThu_HocKy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(pn_ThongKeTongThu_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_ThongKeTongThu_NamHoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_ThongKeTongThu_HocKy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        pn_ThongKeTongThu_ThongTinLayout.setVerticalGroup(
            pn_ThongKeTongThu_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeTongThu_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ThongKeTongThu_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ThongKeTongThu_NamHoc)
                    .addComponent(cb_ThongKeTongThu_NamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pn_ThongKeTongThu_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ThongKeTongThu_HocKy)
                    .addComponent(cb_ThongKeTongThu_HocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_ThongKeTongThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer.png"))); // NOI18N
        btn_ThongKeTongThu.setText("In");
        btn_ThongKeTongThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongKeTongThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ThongKeTongThuLayout = new javax.swing.GroupLayout(pn_ThongKeTongThu);
        pn_ThongKeTongThu.setLayout(pn_ThongKeTongThuLayout);
        pn_ThongKeTongThuLayout.setHorizontalGroup(
            pn_ThongKeTongThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeTongThuLayout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addGroup(pn_ThongKeTongThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ThongKeTongThu)
                    .addComponent(pn_ThongKeTongThu_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(465, Short.MAX_VALUE))
            .addComponent(lb_ThongKeTongThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_ThongKeTongThuLayout.setVerticalGroup(
            pn_ThongKeTongThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeTongThuLayout.createSequentialGroup()
                .addComponent(lb_ThongKeTongThu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(pn_ThongKeTongThu_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_ThongKeTongThu)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        tab_ThongKe.addTab("Tổng Thu", new javax.swing.ImageIcon(getClass().getResource("/Images/get-money.png")), pn_ThongKeTongThu); // NOI18N

        pn_ThongKeSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        lb_ThongKeSinhVien.setBackground(new java.awt.Color(0, 153, 255));
        lb_ThongKeSinhVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_ThongKeSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        lb_ThongKeSinhVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ThongKeSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student_32.png"))); // NOI18N
        lb_ThongKeSinhVien.setText("THỐNG KÊ SINH VIÊN");
        lb_ThongKeSinhVien.setOpaque(true);

        pn_ThongKeSinhVien_HinhThucThongKe.setBackground(new java.awt.Color(255, 255, 255));
        pn_ThongKeSinhVien_HinhThucThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hình Thức Thống Kê"));

        btn_ThongKeSinhVien_Truong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/school.png"))); // NOI18N
        btn_ThongKeSinhVien_Truong.setText("Thống Kê Theo Trường");
        btn_ThongKeSinhVien_Truong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongKeSinhVien_TruongActionPerformed(evt);
            }
        });

        btn_ThongKeSinhVien_Nha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cityscape.png"))); // NOI18N
        btn_ThongKeSinhVien_Nha.setText("Thống Kê Theo Nhà");
        btn_ThongKeSinhVien_Nha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongKeSinhVien_NhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_ThongKeSinhVien_HinhThucThongKeLayout = new javax.swing.GroupLayout(pn_ThongKeSinhVien_HinhThucThongKe);
        pn_ThongKeSinhVien_HinhThucThongKe.setLayout(pn_ThongKeSinhVien_HinhThucThongKeLayout);
        pn_ThongKeSinhVien_HinhThucThongKeLayout.setHorizontalGroup(
            pn_ThongKeSinhVien_HinhThucThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeSinhVien_HinhThucThongKeLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(btn_ThongKeSinhVien_Truong)
                .addGap(158, 158, 158)
                .addComponent(btn_ThongKeSinhVien_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pn_ThongKeSinhVien_HinhThucThongKeLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_ThongKeSinhVien_Nha, btn_ThongKeSinhVien_Truong});

        pn_ThongKeSinhVien_HinhThucThongKeLayout.setVerticalGroup(
            pn_ThongKeSinhVien_HinhThucThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeSinhVien_HinhThucThongKeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pn_ThongKeSinhVien_HinhThucThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThongKeSinhVien_Truong)
                    .addComponent(btn_ThongKeSinhVien_Nha))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pn_ThongKeSinhVien_HinhThucThongKeLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_ThongKeSinhVien_Nha, btn_ThongKeSinhVien_Truong});

        javax.swing.GroupLayout pn_ThongKeSinhVienLayout = new javax.swing.GroupLayout(pn_ThongKeSinhVien);
        pn_ThongKeSinhVien.setLayout(pn_ThongKeSinhVienLayout);
        pn_ThongKeSinhVienLayout.setHorizontalGroup(
            pn_ThongKeSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeSinhVienLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(pn_ThongKeSinhVien_HinhThucThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lb_ThongKeSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_ThongKeSinhVienLayout.setVerticalGroup(
            pn_ThongKeSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeSinhVienLayout.createSequentialGroup()
                .addComponent(lb_ThongKeSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(pn_ThongKeSinhVien_HinhThucThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );

        tab_ThongKe.addTab("Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Images/student.png")), pn_ThongKeSinhVien); // NOI18N

        scrollPanel_ThongKe.setViewportView(tab_ThongKe);

        tab_Main.addTab("Thống Kê", new javax.swing.ImageIcon(getClass().getResource("/Images/business-presentation.png")), scrollPanel_ThongKe); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_QLSV_TiepNhanSV_ThongTin_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_TiepNhanSV_ThongTin_LuuActionPerformed

        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();
        TruongBLL truongBLL = new TruongBLL();

        if (tf_QLSV_TiepNhanSV_ThongTin_HoSV.getText().isEmpty() || tf_QLSV_TiepNhanSV_ThongTin_TenSV.getText().isEmpty()
                || tf_QLSV_TiepNhanSV_ThongTin_MSSV.getText().isEmpty() || tf_QLSV_TiepNhanSV_ThongTin_CMND.getText().isEmpty()
                || dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh.getDate() == null || dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap.getDate() == null
                || cb_QLSV_TiepNhanSV_ThongTin_Truong.getSelectedItem().toString().isEmpty() || btnGroup_QLSV_TiepNhanSV_GioiTinh.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin. Vui Lòng Nhập lại....");
            return;
        }

        if (tf_QLSV_TiepNhanSV_ThongTin_CMND.getText().length() != 9 && tf_QLSV_TiepNhanSV_ThongTin_CMND.getText().length() != 12) {
            JOptionPane.showMessageDialog(this, "CMND phải là 9 hoặc 12 kí tự");
            return;
        }

        SinhVienBLL tiepNhanSinhVienBLL = new SinhVienBLL();

        sinhVienEntity.setHoSinhVien(tf_QLSV_TiepNhanSV_ThongTin_HoSV.getText());
        sinhVienEntity.setTenSinhVien(tf_QLSV_TiepNhanSV_ThongTin_TenSV.getText());
        //sinhVienEntity.setNgaySinh((java.sql.Date) dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh.getDate());
        if (rb_QLSV_TiepNhanSV_GioiTinh_Nam.isSelected()) {
            sinhVienEntity.setGioiTinh(rb_QLSV_TiepNhanSV_GioiTinh_Nam.getText());
        } else {
            sinhVienEntity.setGioiTinh(rb_QLSV_TiepNhanSV_GioiTinh_Nu.getText());
        }
        sinhVienEntity.setCMND(tf_QLSV_TiepNhanSV_ThongTin_CMND.getText());

        java.sql.Date sqlNgaySinh = new java.sql.Date((dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh.getDate().getTime()));
        java.sql.Date sqlNgayCap = new java.sql.Date((dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap.getDate().getTime()));

        sinhVienEntity.setNgaySinh(sqlNgaySinh);
        sinhVienEntity.setNgayCap(sqlNgayCap);

        //sinhVienEntity.setNgayCap((java.sql.Date) dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap.getDate());
        sinhVienEntity.setMSSV(tf_QLSV_TiepNhanSV_ThongTin_MSSV.getText());

        truongEntity.setMaTruong(truongBLL.LayMaTruong(cb_QLSV_TiepNhanSV_ThongTin_Truong.getSelectedItem().toString().trim()));
        truongEntity.setTenTruong(cb_QLSV_TiepNhanSV_ThongTin_Truong.getSelectedItem().toString().trim());
        sinhVienEntity.setMaTruong(truongEntity.getMaTruong().trim());

        MaKTX = sinhVienEntity.getMaTruong().trim() + sinhVienEntity.getMSSV().trim() + sinhVienEntity.getCMND().trim();
        sinhVienEntity.setMaKTX(MaKTX);

        if (tiepNhanSinhVienBLL.KiemTraThemSinhVien_CMND(sinhVienEntity.getCMND())) {
            JOptionPane.showMessageDialog(this, "CMND đã có trong hệ thống. Vui lòng xem lại");
            return;
        }

        if (tiepNhanSinhVienBLL.KiemTraThemSinhVien_MSSV(sinhVienEntity.getMSSV())) {
            JOptionPane.showMessageDialog(this, "MSSV đã có trong hệ thống. Vui lòng xem lại");
            return;
        }

        tiepNhanSinhVienBLL.Insert(sinhVienEntity.getMaKTX(), sinhVienEntity.getHoSinhVien(), sinhVienEntity.getTenSinhVien(), sinhVienEntity.getNgaySinh(), sinhVienEntity.getGioiTinh(), sinhVienEntity.getCMND(), sinhVienEntity.getNgayCap(), sinhVienEntity.getMSSV(), sinhVienEntity.getMaTruong());
        JOptionPane.showMessageDialog(this, "Lưu Thông Tin Sinh Viên Thành Công.");

        ShowTableTiepNhanSV(MaKTX);
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setVisible(true);

    }//GEN-LAST:event_btn_QLSV_TiepNhanSV_ThongTin_LuuActionPerformed

    private void btn_QLSV_TiepNhanSV_ThongTin_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_TiepNhanSV_ThongTin_HuyActionPerformed
        tf_QLSV_TiepNhanSV_ThongTin_HoSV.setText("");
        tf_QLSV_TiepNhanSV_ThongTin_TenSV.setText("");
        tf_QLSV_TiepNhanSV_ThongTin_MSSV.setText("");
        tf_QLSV_TiepNhanSV_ThongTin_CMND.setText("");
        dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh.setDate(null);
        dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap.setDate(null);
        btnGroup_QLSV_TiepNhanSV_GioiTinh.clearSelection();
        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setVisible(false);
    }//GEN-LAST:event_btn_QLSV_TiepNhanSV_ThongTin_HuyActionPerformed

    private void btn_QLSV_TiepNhanSV_ThongTin_XepPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_TiepNhanSV_ThongTin_XepPhongActionPerformed
        // TODO add your handling code here:
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        TruongBLL truongBLL = new TruongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();

        tab_QuanLySinhVien.setSelectedComponent(pn_XepPhong);
        tf_QLSV_XepPhong_MaKTX.setText(MaKTX);

        sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_QLSV_XepPhong_MaKTX.getText());

        if (sinhVienEntity.getHoSinhVien() == null) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Sinh Viên");
            return;
        }

        truongEntity.setTenTruong(truongBLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        lb_QLSV_XepPhong_HoTen_ChiTiet.setText(sinhVienEntity.getHoSinhVien() + " " + sinhVienEntity.getTenSinhVien());
        lb_QLSV_XepPhong_CMND_ChiTiet.setText(sinhVienEntity.getCMND());
        lb_QLSV_XepPhong_NgaySinh_ChiTiet.setText(sinhVienEntity.getNgaySinh().toString());
        lb_QLSV_XepPhong_GioiTinh_ChiTiet.setText(sinhVienEntity.getGioiTinh());
        lb_QLSV_XepPhong_Truong_ChiTiet.setText(truongEntity.getTenTruong());
        lb_QLSV_XepPhong_MSSV_ChiTiet.setText(sinhVienEntity.getMSSV());
        lb_QLSV_XepPhong_Nha_ChiTiet.setText(nhaBLL.LayTenNha(tf_QLSV_XepPhong_MaKTX.getText()));
        lb_QLSV_XepPhong_Phong_ChiTiet.setText(phongBLL.LayTenPhong(tf_QLSV_XepPhong_MaKTX.getText()));

        btn_QLSV_TiepNhanSV_ThongTin_XepPhong.setVisible(false);
    }//GEN-LAST:event_btn_QLSV_TiepNhanSV_ThongTin_XepPhongActionPerformed

    private void btn_QLSV_XepPhong_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_XepPhong_SearchActionPerformed

        XepPhongEntity xepPhongEntity = new XepPhongEntity();
        LoaiNhaEntity loaiNhaEntity = new LoaiNhaEntity();

        loaiNhaEntity.setSoNguoi(Integer.parseInt(cb_QLSV_XepPhong_LoaiPhong_SoNguoi.getSelectedItem().toString().trim()));

        if (rb_QLSV_XepPhong_LoaiPhong_Nam.isSelected()) {
            loaiNhaEntity.setGioiTinh(rb_QLSV_XepPhong_LoaiPhong_Nam.getText().trim());
        } else if (rb_QLSV_XepPhong_LoaiPhong_Nu.isSelected()) {
            loaiNhaEntity.setGioiTinh(rb_QLSV_XepPhong_LoaiPhong_Nu.getText().trim());
        }
        xepPhongEntity.setNamHoc(cb_QLSV_XepPhong_NamHoc.getSelectedItem().toString().trim());
        xepPhongEntity.setHocKy(cb_QLSV_XepPhong_HocKy.getSelectedItem().toString().trim());
        ShowTableXepPhong(loaiNhaEntity.getSoNguoi(), loaiNhaEntity.getGioiTinh(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy());
    }//GEN-LAST:event_btn_QLSV_XepPhong_SearchActionPerformed

    private void tf_QLSV_XepPhong_MaKTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_QLSV_XepPhong_MaKTXActionPerformed

        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        TruongBLL truongBLL = new TruongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();

        sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_QLSV_XepPhong_MaKTX.getText());

        if (sinhVienEntity.getHoSinhVien() == null) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Sinh Viên");
            return;
        }

        truongEntity.setTenTruong(truongBLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        lb_QLSV_XepPhong_HoTen_ChiTiet.setText(sinhVienEntity.getHoSinhVien() + " " + sinhVienEntity.getTenSinhVien());
        lb_QLSV_XepPhong_CMND_ChiTiet.setText(sinhVienEntity.getCMND());
        lb_QLSV_XepPhong_NgaySinh_ChiTiet.setText(sinhVienEntity.getNgaySinh().toString());
        lb_QLSV_XepPhong_GioiTinh_ChiTiet.setText(sinhVienEntity.getGioiTinh());
        lb_QLSV_XepPhong_Truong_ChiTiet.setText(truongEntity.getTenTruong());
        lb_QLSV_XepPhong_MSSV_ChiTiet.setText(sinhVienEntity.getMSSV());

        if (nhaBLL.LayTenNha(tf_QLSV_XepPhong_MaKTX.getText().trim()) != null) {
            lb_QLSV_XepPhong_Nha_ChiTiet.setText(nhaBLL.LayTenNha(tf_QLSV_XepPhong_MaKTX.getText().trim()));
        }

        if (phongBLL.LayTenPhong(tf_QLSV_XepPhong_MaKTX.getText()) != null) {
            lb_QLSV_XepPhong_Phong_ChiTiet.setText(phongBLL.LayTenPhong(tf_QLSV_XepPhong_MaKTX.getText().trim()));
        }


    }//GEN-LAST:event_tf_QLSV_XepPhong_MaKTXActionPerformed

    private void tb_QLSV_XepPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_QLSV_XepPhongMouseClicked
        int index = tb_QLSV_XepPhong.getSelectedRow();
        lb_QLSV_XepPhong_Nha_ChiTiet.setText((String) tb_QLSV_XepPhong.getValueAt(index, 0));
        lb_QLSV_XepPhong_Phong_ChiTiet.setText((String) tb_QLSV_XepPhong.getValueAt(index, 1));
    }//GEN-LAST:event_tb_QLSV_XepPhongMouseClicked

    private void btn_QLSV_XepPhong_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_XepPhong_LuuActionPerformed
        // TODO add your handling code here:

        XepPhongEntity xepPhongEntity = new XepPhongEntity();
        LoaiNhaEntity loaiNhaEntity = new LoaiNhaEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        LoaiNhaBLL loaiNhaBLL = new LoaiNhaBLL();
        XepPhongBLL xepPhongBLL = new XepPhongBLL();
        BackupXepPhongBLL backupXepPhongBLL = new BackupXepPhongBLL();

        if (tf_QLSV_XepPhong_MaKTX.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã KTX");
            return;
        }
        if (lb_QLSV_XepPhong_Nha_ChiTiet.getText() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại phòng sau đó chọn phòng ở bảng bên phải màn hình");
            return;
        }
        if (lb_QLSV_XepPhong_HoTen_ChiTiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhấn enter sau khi nhập Mã KTX.");
            return;
        }

        xepPhongEntity.setMaKTX(tf_QLSV_XepPhong_MaKTX.getText().trim());
        if (!tb_QLSV_XepPhong.isColumnSelected(0) && !tb_QLSV_XepPhong.isColumnSelected(1)
                && !tb_QLSV_XepPhong.isColumnSelected(2) && !tb_QLSV_XepPhong.isColumnSelected(3) && !tb_QLSV_XepPhong.isColumnSelected(4)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại phòng sau đó chọn phòng ở bảng bên phải màn hình");
            return;
        }

        int index = tb_QLSV_XepPhong.getSelectedRow();
        xepPhongEntity.setMaNha(nhaBLL.LayMaNha((String) tb_QLSV_XepPhong.getValueAt(index, 0).toString().trim()));
        xepPhongEntity.setMaPhong(phongBLL.LayMaPhong(Integer.parseInt((String) tb_QLSV_XepPhong.getValueAt(index, 1).toString().trim()), (String) tb_QLSV_XepPhong.getValueAt(index, 0).toString().trim()));
        xepPhongEntity.setNamHoc(cb_QLSV_XepPhong_NamHoc.getSelectedItem().toString().trim());
        xepPhongEntity.setHocKy(cb_QLSV_XepPhong_HocKy.getSelectedItem().toString().trim());

        int soNguoi_tb_XepPhong = Integer.parseInt(tb_QLSV_XepPhong.getValueAt(index, 2).toString());

        loaiNhaEntity.setSoNguoi(Integer.parseInt(cb_QLSV_XepPhong_LoaiPhong_SoNguoi.getSelectedItem().toString().trim()));

        if (rb_QLSV_XepPhong_LoaiPhong_Nam.isSelected()) {
            loaiNhaEntity.setGioiTinh(rb_QLSV_XepPhong_LoaiPhong_Nam.getText().trim());
        } else if (rb_QLSV_XepPhong_LoaiPhong_Nu.isSelected()) {
            loaiNhaEntity.setGioiTinh(rb_QLSV_XepPhong_LoaiPhong_Nu.getText().trim());
        }

        MaKTX = xepPhongEntity.getMaKTX();

        if (loaiNhaBLL.LayGioiTinh_Phong(xepPhongEntity.getMaPhong()).equals(lb_QLSV_XepPhong_GioiTinh_ChiTiet.getText().trim())) {
            if (xepPhongBLL.KiemTraXepPhong(xepPhongEntity.getMaKTX(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy())) {
                int choice = JOptionPane.showConfirmDialog(this, "Sinh Viên này đang ở phòng \"" + phongBLL.LayTenPhong(xepPhongEntity.getMaKTX().trim()).trim() + "\" Nhà \""
                        + nhaBLL.LayTenNha(xepPhongEntity.getMaKTX().trim()).trim() + "\" \n Bạn có muốn chuyển sang phòng khác?");
                if (choice == JOptionPane.YES_OPTION) {
                    LoaiNhaBLL loainha = new LoaiNhaBLL();
                    int soNguoi_DaXepPhong = loainha.LayLoaiNha(nhaBLL.LayTenNha(xepPhongEntity.getMaKTX().trim()).trim()).getSoNguoi();
                    if (soNguoi_DaXepPhong != soNguoi_tb_XepPhong) {
                        JOptionPane.showMessageDialog(this, "Không thể chuyển phòng.\n Không thể chuyển phòng khác loại trung cùng học kỳ.");
                        return;
                    }
                    System.out.println(xepPhongBLL.KiemTraXepPhong(xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy()));
                    if (xepPhongBLL.KiemTraXepPhong(xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy()) >= soNguoi_tb_XepPhong) {
                        JOptionPane.showMessageDialog(this, "Phòng này đã đầy. Vui lòng xếp sang phòng khác.");
                        return;
                    }
                    xepPhongBLL.Update(xepPhongEntity.getMaKTX(), xepPhongEntity.getMaNha(), xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy());
                    backupXepPhongBLL.Update(xepPhongEntity.getMaKTX(), xepPhongEntity.getMaNha(), xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy());
                    JOptionPane.showMessageDialog(this, "Đã xếp thành công sinh viên \"" + lb_QLSV_XepPhong_HoTen_ChiTiet.getText().trim() + "\" vào phòng \""
                            + lb_QLSV_XepPhong_Phong_ChiTiet.getText().trim() + "\" nhà \"" + lb_QLSV_XepPhong_Nha_ChiTiet.getText().trim() + "\"");
                }
            } else {
                System.out.println(xepPhongBLL.KiemTraXepPhong(xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy()));
                if (xepPhongBLL.KiemTraXepPhong(xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy()) >= soNguoi_tb_XepPhong) {
                    JOptionPane.showMessageDialog(this, "Phòng này đã đầy. Vui lòng xếp sang phòng khác.");
                    return;
                }
                xepPhongBLL.Insert(xepPhongEntity.getMaKTX(), xepPhongEntity.getMaNha(), xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy());
                backupXepPhongBLL.Insert(xepPhongEntity.getMaKTX(), xepPhongEntity.getMaNha(), xepPhongEntity.getMaPhong(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy());
                JOptionPane.showMessageDialog(this, "Đã xếp thành công sinh viên \"" + lb_QLSV_XepPhong_HoTen_ChiTiet.getText().trim() + "\" vào phòng \""
                        + lb_QLSV_XepPhong_Phong_ChiTiet.getText().trim() + "\" nhà \"" + lb_QLSV_XepPhong_Nha_ChiTiet.getText().trim() + "\"");
            }
            ShowTableXepPhong(loaiNhaEntity.getSoNguoi(), loaiNhaEntity.getGioiTinh(), xepPhongEntity.getNamHoc(), xepPhongEntity.getHocKy());
            btn_QLSV_XepPhong_ThuPhi.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Sinh viên nam không được ở nhà nữ và ngược lại.\n Vui lòng xem lại");
            return;
        }
    }//GEN-LAST:event_btn_QLSV_XepPhong_LuuActionPerformed

    private void btn_QLSV_XepPhong_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_XepPhong_HuyActionPerformed
        // TODO add your handling code here:
        tf_QLSV_XepPhong_MaKTX.setText("");
        lb_QLSV_XepPhong_HoTen_ChiTiet.setText("");
        lb_QLSV_XepPhong_CMND_ChiTiet.setText("");
        lb_QLSV_XepPhong_NgaySinh_ChiTiet.setText("");
        lb_QLSV_XepPhong_GioiTinh_ChiTiet.setText("");
        lb_QLSV_XepPhong_MSSV_ChiTiet.setText("");
        lb_QLSV_XepPhong_Truong_ChiTiet.setText("");
        lb_QLSV_XepPhong_Nha_ChiTiet.setText("");
        lb_QLSV_XepPhong_Phong_ChiTiet.setText("");
        btn_QLSV_XepPhong_ThuPhi.setVisible(false);

    }//GEN-LAST:event_btn_QLSV_XepPhong_HuyActionPerformed

    private void tf_ThuPhi_PhiNoiTru_MaKTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ThuPhi_PhiNoiTru_MaKTXActionPerformed
        // TODO add your handling code here:
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();
        XepPhongEntity xepPhongEntity = new XepPhongEntity();
        QuyDinhPhiNoiTruEntity quyDinhPhiNoiTruEntity = new QuyDinhPhiNoiTruEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        TruongBLL truongBLL = new TruongBLL();
        XepPhongBLL xepPhongBLL = new XepPhongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        QuyDinhPhiNoiTruBLL quyDinhPhiNoiTruBLL = new QuyDinhPhiNoiTruBLL();

        xepPhongEntity = xepPhongBLL.Search_XepPhong_MaKTX(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());
        sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());

        if (xepPhongEntity.getNamHoc() == null) {
            JOptionPane.showMessageDialog(this, "Sinh Viên này chưa được xếp phòng.");
            return;
        }

        truongEntity.setTenTruong(truongBLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        quyDinhPhiNoiTruEntity = quyDinhPhiNoiTruBLL.LayPhiNoiTru(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());

        lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet.setText(sinhVienEntity.getHoSinhVien() + " " + sinhVienEntity.getTenSinhVien());
        lb_ThuPhi_PhiNoiTru_CMND_ChiTiet.setText(sinhVienEntity.getCMND());
        lb_ThuPhi_PhiNoiTru_NgaySinh_ChiTiet.setText(sinhVienEntity.getNgaySinh().toString());
        lb_ThuPhi_PhiNoiTru_GioiTinh_ChiTiet.setText(sinhVienEntity.getGioiTinh());
        lb_ThuPhi_PhiNoiTru_MSSV_ChiTiet.setText(sinhVienEntity.getMSSV());
        lb_ThuPhi_PhiNoiTru_Truong_ChiTiet.setText(truongEntity.getTenTruong());
        lb_ThuPhi_PhiNoiTru_Nha_ChiTiet.setText(nhaBLL.LayTenNha(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim()));
        lb_ThuPhi_PhiNoiTru_Phong_ChiTiet.setText(phongBLL.LayTenPhong(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim()));
        lb_ThuPhi_PhiNoiTru_NamHoc_ChiTiet.setText(xepPhongEntity.getNamHoc());
        lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.setText(xepPhongEntity.getHocKy());
        if (lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.getText().trim().equals("1")) {
            lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.setText(String.valueOf((Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 5) + 100000));
        } else if (lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.getText().trim().equals("2")) {

            if (xepPhongBLL.KiemTraXepPhong(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim())) {
                lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.setText(String.valueOf(Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 5));
            } else {
                lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.setText(String.valueOf((Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 5) + 100000));
            }
        } else {
            lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.setText(String.valueOf(Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 2));
        }

        ShowTable_ThuPhiNoiTru(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());
    }//GEN-LAST:event_tf_ThuPhi_PhiNoiTru_MaKTXActionPerformed

    private void btn_QLSV_XepPhong_ThuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_XepPhong_ThuPhiActionPerformed
        // TODO add your handling code here:
        tab_Main.setSelectedComponent(scrollPanel_ThuPhi);
        tab_ThuPhi.setSelectedComponent(pn_ThuPhi_PhiNoiTru);
        tf_ThuPhi_PhiNoiTru_MaKTX.setText(MaKTX);

        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();
        XepPhongEntity xepPhongEntity = new XepPhongEntity();
        QuyDinhPhiNoiTruEntity quyDinhPhiNoiTruEntity = new QuyDinhPhiNoiTruEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        TruongBLL truongBLL = new TruongBLL();
        XepPhongBLL xepPhongBLL = new XepPhongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        QuyDinhPhiNoiTruBLL quyDinhPhiNoiTruBLL = new QuyDinhPhiNoiTruBLL();

        xepPhongEntity = xepPhongBLL.Search_XepPhong_MaKTX(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());
        sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());

        if (sinhVienEntity.getHoSinhVien() == null) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Sinh Viên");
            return;
        }

        truongEntity.setTenTruong(truongBLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        quyDinhPhiNoiTruEntity = quyDinhPhiNoiTruBLL.LayPhiNoiTru(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());

        lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet.setText(sinhVienEntity.getHoSinhVien() + " " + sinhVienEntity.getTenSinhVien());
        lb_ThuPhi_PhiNoiTru_CMND_ChiTiet.setText(sinhVienEntity.getCMND());
        lb_ThuPhi_PhiNoiTru_NgaySinh_ChiTiet.setText(sinhVienEntity.getNgaySinh().toString());
        lb_ThuPhi_PhiNoiTru_GioiTinh_ChiTiet.setText(sinhVienEntity.getGioiTinh());
        lb_ThuPhi_PhiNoiTru_MSSV_ChiTiet.setText(sinhVienEntity.getMSSV());
        lb_ThuPhi_PhiNoiTru_Truong_ChiTiet.setText(truongEntity.getTenTruong());
        lb_ThuPhi_PhiNoiTru_Nha_ChiTiet.setText(nhaBLL.LayTenNha(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim()));
        lb_ThuPhi_PhiNoiTru_Phong_ChiTiet.setText(phongBLL.LayTenPhong(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim()));
        lb_ThuPhi_PhiNoiTru_NamHoc_ChiTiet.setText(xepPhongEntity.getNamHoc());
        lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.setText(xepPhongEntity.getHocKy());

        if (lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.getText().trim().equals("1") || lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.getText().trim().equals("2")) {
            lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.setText(String.valueOf((Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 5) + 100000));
        } else {
            lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.setText(String.valueOf(Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 2));
        }
        ShowTable_ThuPhiNoiTru(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());

        //xóa thông tin bên tab xếp phòng
        tf_QLSV_XepPhong_MaKTX.setText("");
        lb_QLSV_XepPhong_HoTen_ChiTiet.setText("");
        lb_QLSV_XepPhong_CMND_ChiTiet.setText("");
        lb_QLSV_XepPhong_NgaySinh_ChiTiet.setText("");
        lb_QLSV_XepPhong_GioiTinh_ChiTiet.setText("");
        lb_QLSV_XepPhong_MSSV_ChiTiet.setText("");
        lb_QLSV_XepPhong_Truong_ChiTiet.setText("");
        lb_QLSV_XepPhong_Nha_ChiTiet.setText("");
        lb_QLSV_XepPhong_Phong_ChiTiet.setText("");
        btn_QLSV_XepPhong_ThuPhi.setVisible(false);
    }//GEN-LAST:event_btn_QLSV_XepPhong_ThuPhiActionPerformed

    private void btn_ThuPhi_PhiNoiTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThuPhi_PhiNoiTruActionPerformed
        // TODO add your handling code here:
        ThuPhiNoiTruBLL thuPhiNoiTruBLL = new ThuPhiNoiTruBLL();
        BackupThuPhiNoiTruBLL backupThuPhiNoiTruBLL = new BackupThuPhiNoiTruBLL();

        if (tf_ThuPhi_PhiNoiTru_MaKTX.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập mã KTX và nhấn enter");
            return;
        }
        if (lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhấn enter sau khi nhập Mã KTX.");
            return;
        }

        if (thuPhiNoiTruBLL.KiemTraThuPhi(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim()) == true) {
            JOptionPane.showMessageDialog(this, "Không thể lưu. Sinh viên này đã đóng tiền rồi");
            return;
        }
        thuPhiNoiTruBLL.Insert(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim(), lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet.getText().trim(), String.valueOf(lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet.getText().trim()));
        backupThuPhiNoiTruBLL.Insert();

        JOptionPane.showMessageDialog(this, "Lưu thông tin thu phí thành công.");
        ShowTable_ThuPhiNoiTru(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim());
    }//GEN-LAST:event_btn_ThuPhi_PhiNoiTruActionPerformed

    private void btn_QLSV_XuLySVKhoiKTX_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_XuLySVKhoiKTX_XacNhanActionPerformed
        // TODO add your handling code here:
        XuLySinhVienRaKhoiKTXBLL xuLySinhVienRaKhoiKTXBLL = new XuLySinhVienRaKhoiKTXBLL();
        ThuPhiNoiTruBLL thuPhiNoiTruBLL = new ThuPhiNoiTruBLL();
        XepPhongBLL xepPhongBLL = new XepPhongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        GhiNhanKyLuatBLL ghiNhanKyLuatBLL = new GhiNhanKyLuatBLL();
        HoanTraPhiCSVCBLL hoanTraPhiCSVCBLL = new HoanTraPhiCSVCBLL();

        if (tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập mã KTX và nhấn enter");
            return;
        }

        if (lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhấn enter sau khi nhập Mã KTX.");
            return;
        }
        if (xuLySinhVienRaKhoiKTXBLL.KiemTraXuLySVRaKhoiKTX(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Không thể xác nhận.\n Sinh viên này đã được hoàn lại phí");
            return;
        }
        xuLySinhVienRaKhoiKTXBLL.Insert(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());

        ghiNhanKyLuatBLL.Delete(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        hoanTraPhiCSVCBLL.Delete(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        thuPhiNoiTruBLL.Delete(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        xepPhongBLL.Delete(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        sinhVienBLL.Delete(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        JOptionPane.showMessageDialog(this, "Xử lý thành công");
        ShowTable_XuLySinhVienRaKhoiKTX(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        //tf_QLSV_XuLySVKhoiKTX_MaKTX.setText("");

    }//GEN-LAST:event_btn_QLSV_XuLySVKhoiKTX_XacNhanActionPerformed

    private void tf_QLSV_XuLySVKhoiKTX_MaKTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_QLSV_XuLySVKhoiKTX_MaKTXActionPerformed
        // TODO add your handling code here:
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();
        XepPhongEntity xepPhongEntity = new XepPhongEntity();
        QuyDinhPhiNoiTruEntity quyDinhPhiNoiTruEntity = new QuyDinhPhiNoiTruEntity();
        XuLySinhVienRaKhoiKTXEntity xuLySinhVienRaKhoiKTXEntity = new XuLySinhVienRaKhoiKTXEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        TruongBLL truongBLL = new TruongBLL();
        XepPhongBLL xepPhongBLL = new XepPhongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        QuyDinhPhiNoiTruBLL quyDinhPhiNoiTruBLL = new QuyDinhPhiNoiTruBLL();
        XuLySinhVienRaKhoiKTXBLL xuLySinhVienRaKhoiKTXBLL = new XuLySinhVienRaKhoiKTXBLL();
        ThuPhiNoiTruBLL thuPhiNoiTruBLL = new ThuPhiNoiTruBLL();

        if (thuPhiNoiTruBLL.KiemTraThuPhi(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim()) == false) {
            JOptionPane.showMessageDialog(this, "Sinh Viên này chưa đóng phí nội trú.");
            return;
        }

        xepPhongEntity = xepPhongBLL.Search_XepPhong_MaKTX(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
        sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());

        if (xepPhongEntity.getNamHoc() == null) {
            JOptionPane.showMessageDialog(this, "Sinh Viên Này chưa đóng phí nội trú.");
            return;
        }

        truongEntity.setTenTruong(truongBLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        quyDinhPhiNoiTruEntity = quyDinhPhiNoiTruBLL.LayPhiNoiTru(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());

        lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet.setText(sinhVienEntity.getHoSinhVien().trim() + " " + sinhVienEntity.getTenSinhVien().trim());
        lb_QLSV_XuLySVRaKhoiKTX_CMND_ChiTiet.setText(sinhVienEntity.getCMND());
        lb_QLSV_XuLySVRaKhoiKTX_NgaySinh_ChiTiet.setText(sinhVienEntity.getNgaySinh().toString());
        lb_QLSV_XuLySVRaKhoiKTX_GioiTinh_ChiTiet.setText(sinhVienEntity.getGioiTinh());
        lb_QLSV_XuLySVRaKhoiKTX_MSSV_ChiTiet.setText(sinhVienEntity.getMSSV());
        lb_QLSV_XuLySVRaKhoiKTX_Truong_ChiTiet.setText(truongEntity.getTenTruong());
        lb_QLSV_XuLySVRaKhoiKTX_Nha_ChiTiet.setText(nhaBLL.LayTenNha(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim()));
        lb_QLSV_XuLySVRaKhoiKTX_Phong_ChiTiet.setText(phongBLL.LayTenPhong(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim()));
        lb_QLSV_XuLySVRaKhoiKTX_NamHoc_ChiTiet.setText(xepPhongEntity.getNamHoc());
        lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet.setText(xepPhongEntity.getHocKy());

        xuLySinhVienRaKhoiKTXEntity.setPhiHoanTra(xuLySinhVienRaKhoiKTXBLL.TinhPhiHoanTra(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim()));
        // String phiHoanTra = xuLySinhVienRaKhoiKTXEntity.getPhiHoanTra();
        if (lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet.getText().trim().equals("1") || lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet.getText().trim().equals("2")) {
            lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru_ChiTiet.setText(String.valueOf(Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 5) + " VND");
        } else {
            lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru_ChiTiet.setText(String.valueOf(Integer.parseInt(quyDinhPhiNoiTruEntity.getPhiNoiTru()) * 2) + " VND");
        }
        lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra_ChiTiet.setText(xuLySinhVienRaKhoiKTXEntity.getPhiHoanTra() + " VND");
        ShowTable_XuLySinhVienRaKhoiKTX(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim());
    }//GEN-LAST:event_tf_QLSV_XuLySVKhoiKTX_MaKTXActionPerformed

    private void btn_ThuPhi_PhiNoiTru_XuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThuPhi_PhiNoiTru_XuatHoaDonActionPerformed
        // TODO add your handling code here:
        if ("".equals(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Nhập mã KTX!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhấn enter sau khi nhập Mã KTX.");
            return;
        }
        if (tb_ThuPhi_PhiNoiTru.getValueAt(0, 8) == null) {
            JOptionPane.showMessageDialog(this, "Không thể xuất hóa đơn.\nSinh viên này chưa đóng phí nội trú.");
            return;
        }

        ThuPhiNoiTruBLL tpntBLL = new ThuPhiNoiTruBLL();
        try {
            tpntBLL.inBienLai(tf_ThuPhi_PhiNoiTru_MaKTX.getText().trim(), username);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_ThuPhi_PhiNoiTru_XuatHoaDonActionPerformed

    private void cb_ThuPhi_PhiDienNuoc_KhoiNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ThuPhi_PhiDienNuoc_KhoiNhaActionPerformed
        // TODO add your handling code here:
        cb_ThuPhi_PhiDienNuoc_Phong.removeAllItems();
        String tenNha = cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim();
        showComboBoxPhong_ThuPhiDienNuoc(tenNha);

    }//GEN-LAST:event_cb_ThuPhi_PhiDienNuoc_KhoiNhaActionPerformed

    private void btn_QLSV_XuLySVKhoiKTX_XuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QLSV_XuLySVKhoiKTX_XuatHoaDonActionPerformed
        // TODO add your handling code here:
        XuLySinhVienRaKhoiKTXBLL xlsvBLL = new XuLySinhVienRaKhoiKTXBLL();

        if ("".equals(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã KTX", "Thông báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            xlsvBLL.inBienLaiHoanTra(tf_QLSV_XuLySVKhoiKTX_MaKTX.getText().trim(), username);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_QLSV_XuLySVKhoiKTX_XuatHoaDonActionPerformed

    private boolean check = true;
    private void cb_ThuPhi_PhiDienNuoc_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ThuPhi_PhiDienNuoc_PhongActionPerformed
        // TODO add your handling code here:
        if (check) {
            check = false;
            return;
        }
        if (cb_ThuPhi_PhiDienNuoc_Phong.getSelectedItem() == null) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        int thang = cal.get(Calendar.MONTH) + 1;
        int nam = cal.get(Calendar.YEAR);
        lb_ThuPhi_PhiDienNuoc_ThangNam_ChiTiet.setText(thang + " / " + nam);

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();

        String tenNha = cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim();
        String tenPhong = cb_ThuPhi_PhiDienNuoc_Phong.getSelectedItem().toString().trim();

        int maNha = nhaBLL.LayMaNha(cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim());
        int maPhong = phongBLL.LayMaPhong(Integer.parseInt(cb_ThuPhi_PhiDienNuoc_Phong.getSelectedItem().toString().trim()), cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim());
        GhiNhanDienNuocBLL ghiNhanDienNuocBLL = new GhiNhanDienNuocBLL();
        GhiNhanDienNuocEntity ghiNhanDienNuocEntity = ghiNhanDienNuocBLL.LayGhiNhanDienNuoc(thang, nam, maNha, maPhong);
        ThuPhiDienNuocBLL thuPhiDienNuocBLL = new ThuPhiDienNuocBLL();
        ThuPhiDienNuocEntity thuPhiDienNuocEntity = thuPhiDienNuocBLL.LayThuPhiDienNuoc(maNha, maPhong, thang, nam);

        if (ghiNhanDienNuocEntity.getSoKWDien() == 0) {
            JOptionPane.showMessageDialog(this, "Phòng này chưa được cập nhật điện nước.");
            return;
        }

        lb_ThuPhi_PhiDienNuoc_Phong_ChiTiet.setText(tenPhong);
        lb_ThuPhi_PhiDienNuoc_Nha_ChiTiet.setText(tenNha);
        lb_ThuPhi_PhiDienNuoc_SoKWDien_ChiTiet.setText(String.valueOf(ghiNhanDienNuocEntity.getSoKWDien()) + " Kwh");
        lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc_ChiTiet.setText(String.valueOf(ghiNhanDienNuocEntity.getSoKhoiNuoc()) + " Khối");
        lb_ThuPhi_PhiDienNuoc_TienDien_ChiTiet.setText(thuPhiDienNuocEntity.getTienDien() + " VND");
        lb_ThuPhi_PhiDienNuoc_TienNuoc_ChiTiet.setText(thuPhiDienNuocEntity.getTienNuoc() + " VND");
        lb_ThuPhi_PhiDienNuoc_TongCong_ChiTiet.setText(thuPhiDienNuocEntity.getTongCong() + " VND");

        showTable_ThuPhiDienNuoc(tenNha, tenPhong);
    }//GEN-LAST:event_cb_ThuPhi_PhiDienNuoc_PhongActionPerformed

    private void btn_ThuPhi_PhiDienNuoc_ThuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThuPhi_PhiDienNuoc_ThuPhiActionPerformed
        // TODO add your handling code here:

        if (cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà và chọn phòng");
            return;
        }

        ThuPhiDienNuocBLL thuPhiDienNuocBLL = new ThuPhiDienNuocBLL();
        BackupThuPhiDienNuocBLL backupThuPhiDienNuocBLL = new BackupThuPhiDienNuocBLL();
        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();

        int maNha = nhaBLL.LayMaNha(cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim());
        int maPhong = phongBLL.LayMaPhong(Integer.parseInt(cb_ThuPhi_PhiDienNuoc_Phong.getSelectedItem().toString().trim()), cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim());

        Calendar cal = Calendar.getInstance();
        int thang = cal.get(Calendar.MONTH) + 1;
        int nam = cal.get(Calendar.YEAR);

        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thu phí điện nước cho phòng này?");
        if (choice == JOptionPane.YES_OPTION) {
            thuPhiDienNuocBLL.Update_NgayThu_DaThu(maNha, maPhong, thang, nam, sqlToday);
            backupThuPhiDienNuocBLL.Update_NgayThu_DaThu(maNha, maPhong, thang, nam, sqlToday);
            String tenNha = cb_ThuPhi_PhiDienNuoc_KhoiNha.getSelectedItem().toString().trim();
            String tenPhong = cb_ThuPhi_PhiDienNuoc_Phong.getSelectedItem().toString().trim();
            showTable_ThuPhiDienNuoc(tenNha, tenPhong);
        }

    }//GEN-LAST:event_btn_ThuPhi_PhiDienNuoc_ThuPhiActionPerformed

    private void tf_TraCuu_SinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TraCuu_SinhVienActionPerformed
        // TODO add your handling code here:

        String clue = tf_TraCuu_SinhVien.getText().trim();
        if (!"".equals(tf_TraCuu_SinhVien.getText().trim())) {
            ShowTable_TraCuuSinhVien(clue);
        }
    }//GEN-LAST:event_tf_TraCuu_SinhVienActionPerformed

    private void btn_TraCuu_SinhVien_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TraCuu_SinhVien_SearchActionPerformed
        // TODO add your handling code here:

        String clue = tf_TraCuu_SinhVien.getText().trim();
        if (!"".equals(tf_TraCuu_SinhVien.getText().trim())) {
            ShowTable_TraCuuSinhVien(clue);
        }
    }//GEN-LAST:event_btn_TraCuu_SinhVien_SearchActionPerformed

    private void cb_TraCuu_ThongTinPhong_NhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuu_ThongTinPhong_NhaActionPerformed
        // TODO add your handling code here:
        Object obj = cb_TraCuu_ThongTinPhong_Nha.getSelectedItem();

        if (obj == null) {
            System.out.println(cb_TraCuu_ThongTinPhong_Nha.getName() + " Error!:");
        } else {
            cb_TraCuu_ThongTinPhong_Phong.removeAllItems();
            showComboBoxPhong_TraCuuPhong((String) obj.toString());
        }
    }//GEN-LAST:event_cb_TraCuu_ThongTinPhong_NhaActionPerformed

    private void cb_TraCuu_ThongTinPhong_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuu_ThongTinPhong_PhongActionPerformed
        // TODO add your handling code here:

        if (cb_TraCuu_ThongTinPhong_Phong.getSelectedItem() == null || cb_TraCuu_ThongTinPhong_Nha.getSelectedItem() == null) {
            return;
        }

        String tenNha = cb_TraCuu_ThongTinPhong_Nha.getSelectedItem().toString().trim();
        String tenPhong = cb_TraCuu_ThongTinPhong_Phong.getSelectedItem().toString().trim();

        ShowTable_TraCuuPhong(tenNha, tenPhong);
    }//GEN-LAST:event_cb_TraCuu_ThongTinPhong_PhongActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_ThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_ThoiGianActionPerformed
        // TODO add your handling code here:
        ThoiGianFrame thoiGianFrame = new ThoiGianFrame();
        thoiGianFrame.setVisible(true);
        thoiGianFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_ThoiGianActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_MucPhiKTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_MucPhiKTXActionPerformed
        // TODO add your handling code here:
        QuyDinhPhiNoiTruFrame quyDinhPhiNoiTruFrame = new QuyDinhPhiNoiTruFrame();
        quyDinhPhiNoiTruFrame.setVisible(true);
        quyDinhPhiNoiTruFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_MucPhiKTXActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_MucGiaDienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_MucGiaDienActionPerformed
        // TODO add your handling code here:
        QuyDinhGiaDienFrame quyDinhGiaDienFrame = new QuyDinhGiaDienFrame();
        quyDinhGiaDienFrame.setVisible(true);
        quyDinhGiaDienFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_MucGiaDienActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_MucGiaNuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_MucGiaNuocActionPerformed
        // TODO add your handling code here:
        QuyDinhGiaNuocFrame quyDinhGiaNuocFrame = new QuyDinhGiaNuocFrame();
        quyDinhGiaNuocFrame.setVisible(true);
        quyDinhGiaNuocFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_MucGiaNuocActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_TruongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_TruongActionPerformed
        // TODO add your handling code here:
        TruongFrame truongFrame = new TruongFrame();
        truongFrame.setVisible(true);
        truongFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_TruongActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_KhoiNhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_KhoiNhaActionPerformed
        // TODO add your handling code here:
        KhoiNhaFrame khoiNhaFrame = new KhoiNhaFrame();
        khoiNhaFrame.setVisible(true);
        khoiNhaFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_KhoiNhaActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_TinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_TinhActionPerformed
        // TODO add your handling code here:
        TinhFrame tinhFrame = new TinhFrame();
        tinhFrame.setVisible(true);
        tinhFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_TinhActionPerformed

    private void tf_HoanTraPhiCSVC_MaKTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_HoanTraPhiCSVC_MaKTXActionPerformed
        // TODO add your handling code here:
        String maKTX = tf_HoanTraPhiCSVC_MaKTX.getText().trim();
        String namHoc = cb_HoanTraPhiCSVC_NamHoc.getSelectedItem().toString().trim();

        // HoanTraPhiCSVCBLL hoanTraPhiCSVCBLL = new HoanTraPhiCSVCBLL();
        BackupThuPhiNoiTruBLL backupThuPhiNoiTruBLL = new BackupThuPhiNoiTruBLL();
        BackupThuPhiNoiTruEntity backupThuPhiNoiTruEntity = backupThuPhiNoiTruBLL.GetBackup(maKTX, namHoc);
        if (backupThuPhiNoiTruEntity.getHoSinhVien() == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin thu phí nội trú của sinh viên trong năm học");
            return;
        }

        lb_HoanTraPhiCSVC_HoTen_ChiTiet.setText(backupThuPhiNoiTruEntity.getHoSinhVien() + " " + backupThuPhiNoiTruEntity.getTenSinhVien());
        lb_HoanTraPhiCSVC_GioiTinh_ChiTiet.setText(backupThuPhiNoiTruEntity.getGioiTinh());
        lb_HoanTraPhiCSVC_MSSV_ChiTiet.setText(backupThuPhiNoiTruEntity.getMSSV());
        lb_HoanTraPhiCSVC_Truong_ChiTiet.setText(backupThuPhiNoiTruEntity.getTenTruong());
        lb_HoanTraPhiCSVC_Nha_ChiTiet.setText(backupThuPhiNoiTruEntity.getTenNha());
        lb_HoanTraPhiCSVC_Phong_ChiTiet.setText(backupThuPhiNoiTruEntity.getTenPhong());
        lb_HoanTraPhiCSVC_PhiHoanTra_ChiTiet.setText("100000 VND");

        ShowTable_HoanTraPhiCSVC(maKTX, namHoc);
    }//GEN-LAST:event_tf_HoanTraPhiCSVC_MaKTXActionPerformed

    private void btn_HoanTraPhiCSVC_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoanTraPhiCSVC_XacNhanActionPerformed
        // TODO add your handling code here:
        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        HoanTraPhiCSVCBLL hoanTraPhiCSVCBLL = new HoanTraPhiCSVCBLL();
        BackupHoanTraPhiCSVCBLL backupHoanTraPhiCSVCBLL = new BackupHoanTraPhiCSVCBLL();
        String maKTX = tf_HoanTraPhiCSVC_MaKTX.getText().trim();
        String namHoc = cb_HoanTraPhiCSVC_NamHoc.getSelectedItem().toString().trim();
        String phiHoanTra = "100000";

        if (lb_HoanTraPhiCSVC_HoTen_ChiTiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã KTX của sinh viên trước khi bấm nút xác nhận.");
            return;
        }

        if (backupHoanTraPhiCSVCBLL.KiemTraHoanTraPhiCSVC(maKTX, namHoc)) {
            JOptionPane.showMessageDialog(this, "Không thể lưu. Sinh viên này đã được hoàn trả phí trước đó.");
            return;
        }
        if (sinhVienBLL.TimSinhVien(maKTX)) {
            hoanTraPhiCSVCBLL.Insert(maKTX, namHoc, phiHoanTra);
        }

        backupHoanTraPhiCSVCBLL.Insert(maKTX, namHoc, phiHoanTra);
        JOptionPane.showMessageDialog(this, "Hoàn trả phí thành công");
        ShowTable_HoanTraPhiCSVC(maKTX, namHoc);
    }//GEN-LAST:event_btn_HoanTraPhiCSVC_XacNhanActionPerformed

    private void btn_HeThong_TaiKhoan_DoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_TaiKhoan_DoiMatKhauActionPerformed
        // TODO add your handling code here:
        DoiMatKhauFrame doiMatKhauFrame = new DoiMatKhauFrame();
        doiMatKhauFrame.setVisible(true);
        doiMatKhauFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_TaiKhoan_DoiMatKhauActionPerformed

    private void cb_TraCuuDienNuoc_NhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuuDienNuoc_NhaActionPerformed
        // TODO add your handling code here:
        Object obj = cb_TraCuuDienNuoc_Nha.getSelectedItem();

        if (obj == null) {
            System.out.println(cb_TraCuuDienNuoc_Nha.getName() + " Error!:");
        } else {
            cb_TraCuuDienNuoc_Phong.removeAllItems();
            showComboBoxPhong_TraCuuDN(obj.toString());
        }

    }//GEN-LAST:event_cb_TraCuuDienNuoc_NhaActionPerformed

    private void cb_TraCuuDienNuoc_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuuDienNuoc_PhongActionPerformed
        // TODO add your handling code here:
        if (cb_TraCuuDienNuoc_Nha.getSelectedItem() == null || cb_TraCuuDienNuoc_Phong.getSelectedItem() == null) {
            return;
        }

        String tenNha = cb_TraCuuDienNuoc_Nha.getSelectedItem().toString().trim();
        String tenPhong = cb_TraCuuDienNuoc_Phong.getSelectedItem().toString().trim();

        showTable_TraCuuDN(tenNha, tenPhong);

    }//GEN-LAST:event_cb_TraCuuDienNuoc_PhongActionPerformed

    private void tf_CapNhatThongTinSinhVien_MaKTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CapNhatThongTinSinhVien_MaKTXActionPerformed
        // TODO add your handling code here:

        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        SinhVienEntity sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_CapNhatThongTinSinhVien_MaKTX.getText().trim());
        TruongBLL truongLL = new TruongBLL();
        TinhBLL tinhBLL = new TinhBLL();
        if (sinhVienEntity.getMaKTX() == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên");
            return;
        }

        tf_CapNhatThongTinSV_ThongTin_HoSinhVien.setText(sinhVienEntity.getHoSinhVien());
        tf_CapNhatThongTinSV_ThongTin_TenSV.setText(sinhVienEntity.getTenSinhVien());
        tf_CapNhatThongTinSV_CMND.setText(sinhVienEntity.getCMND());
        dateChooser_CapNhatThongTinSV_ThongTin_NgayCap.setDate(sinhVienEntity.getNgayCap());
        dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh.setDate(sinhVienEntity.getNgaySinh());
        tf_CapNhatThongTinSV_GioiTinh.setText(sinhVienEntity.getGioiTinh());
        tf_CapNhatThongTinSV_MSSV.setText(sinhVienEntity.getMSSV());
        cb_CapNhatThongTinSV_Truong.setSelectedItem(truongLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        tf_CapNhatThongTinSV_ThongTin_SDT.setText(sinhVienEntity.getSoDienThoai());
        tf_CapNhatThongTinSV_ThongTin_DanToc.setText(sinhVienEntity.getDanToc());
        tf_CapNhatThongTinSV_ThongTin_TonGiao.setText(sinhVienEntity.getTonGiao());
        tf_CapNhatThongTinSV_ThongTin_QuocTich.setText(sinhVienEntity.getQuocTich());
        cb_CapNhatThongTinSV_ThongTin_Tinh.setSelectedItem(tinhBLL.LayTenTinh(sinhVienEntity.getMaTinh()));
        tf_CapNhatThongTinSV_ThongTin_DiaChiNha.setText(sinhVienEntity.getDiaChiNha());

        ShowTable_CapNhatThongTinSinhVien(tf_CapNhatThongTinSinhVien_MaKTX.getText().trim());
    }//GEN-LAST:event_tf_CapNhatThongTinSinhVien_MaKTXActionPerformed

    private void btn_CapNhatThongTinSV_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatThongTinSV_LuuActionPerformed
        // TODO add your handling code here:

        if (tf_CapNhatThongTinSV_ThongTin_HoSinhVien.getText().isEmpty() || tf_CapNhatThongTinSV_ThongTin_TenSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống họ tên sinh viên");
            return;
        }

        if (dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày sinh");
            return;
        }

        if (dateChooser_CapNhatThongTinSV_ThongTin_NgayCap.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Không được để trống ngày cấp CMND");
            return;
        }

        if (tf_CapNhatThongTinSV_CMND.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống CMND");
            return;
        }
        if (tf_CapNhatThongTinSV_GioiTinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Giới Tính");
            return;
        }

        if (tf_CapNhatThongTinSV_MSSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống MSSV");
            return;
        }
        if (cb_CapNhatThongTinSV_Truong.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống Tên Trường");
            return;
        }
        if (tf_CapNhatThongTinSV_CMND.getText().length() != 9 && tf_CapNhatThongTinSV_CMND.getText().length() != 12) {
            JOptionPane.showMessageDialog(this, "CMND phải là 9 hoặc 12 kí tự");
            return;
        }

        TinhBLL tinhBLL = new TinhBLL();
        TruongBLL truongBLL = new TruongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();

        SinhVienEntity sinhVienEntity = new SinhVienEntity();

        sinhVienEntity.setMaKTX(tf_CapNhatThongTinSinhVien_MaKTX.getText().trim());
        sinhVienEntity.setHoSinhVien(tf_CapNhatThongTinSV_ThongTin_HoSinhVien.getText().trim());
        sinhVienEntity.setTenSinhVien(tf_CapNhatThongTinSV_ThongTin_TenSV.getText().trim());

        java.sql.Date sqlNgayCap = new java.sql.Date(dateChooser_CapNhatThongTinSV_ThongTin_NgayCap.getDate().getTime());
        java.sql.Date sqlNgaySinh = new java.sql.Date((dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh.getDate().getTime()));

        sinhVienEntity.setNgayCap(sqlNgayCap);
        sinhVienEntity.setNgaySinh(sqlNgaySinh);
        sinhVienEntity.setSoDienThoai(tf_CapNhatThongTinSV_ThongTin_SDT.getText().trim());
        sinhVienEntity.setDiaChiNha(tf_CapNhatThongTinSV_ThongTin_DiaChiNha.getText().trim());
        sinhVienEntity.setDanToc(tf_CapNhatThongTinSV_ThongTin_DanToc.getText().trim());
        sinhVienEntity.setTonGiao(tf_CapNhatThongTinSV_ThongTin_TonGiao.getText().trim());
        sinhVienEntity.setQuocTich(tf_CapNhatThongTinSV_ThongTin_QuocTich.getText().trim());
        sinhVienEntity.setMaTinh(tinhBLL.LayMaTinh(cb_CapNhatThongTinSV_ThongTin_Tinh.getSelectedItem().toString().trim()));
        sinhVienEntity.setCMND(tf_CapNhatThongTinSV_CMND.getText().trim());
        sinhVienEntity.setMSSV(tf_CapNhatThongTinSV_MSSV.getText().trim());
        sinhVienEntity.setMaTruong(truongBLL.LayMaTruong(cb_CapNhatThongTinSV_Truong.getSelectedItem().toString().trim()));
        sinhVienEntity.setGioiTinh(tf_CapNhatThongTinSV_GioiTinh.getText().trim());

        sinhVienBLL.Update(sinhVienEntity.getMaKTX(), sinhVienEntity.getHoSinhVien(), sinhVienEntity.getTenSinhVien(), sinhVienEntity.getNgayCap(), sinhVienEntity.getNgaySinh(), sinhVienEntity.getSoDienThoai(), sinhVienEntity.getDanToc(), sinhVienEntity.getTonGiao(), sinhVienEntity.getQuocTich(), sinhVienEntity.getMaTinh(), sinhVienEntity.getDiaChiNha(),
                sinhVienEntity.getCMND(), sinhVienEntity.getGioiTinh(), sinhVienEntity.getMSSV(), sinhVienEntity.getMaTruong());

        JOptionPane.showMessageDialog(this, "Cập Nhật thông tin thành công");
        ShowTable_CapNhatThongTinSinhVien(sinhVienEntity.getMaKTX());
    }//GEN-LAST:event_btn_CapNhatThongTinSV_LuuActionPerformed

    private void btn_CapNhatThongTinSinhVien_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatThongTinSinhVien_SearchActionPerformed
        // TODO add your handling code here:

        SinhVienBLL sinhVienBLL = new SinhVienBLL();
        SinhVienEntity sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_CapNhatThongTinSinhVien_MaKTX.getText().trim());
        TruongBLL truongLL = new TruongBLL();
        TinhBLL tinhBLL = new TinhBLL();
        if (sinhVienEntity.getMaKTX() == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên");
            return;
        }

        tf_CapNhatThongTinSV_ThongTin_HoSinhVien.setText(sinhVienEntity.getHoSinhVien());
        tf_CapNhatThongTinSV_ThongTin_TenSV.setText(sinhVienEntity.getTenSinhVien());
        tf_CapNhatThongTinSV_CMND.setText(sinhVienEntity.getCMND());
        dateChooser_CapNhatThongTinSV_ThongTin_NgayCap.setDate(sinhVienEntity.getNgayCap());
        dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh.setDate(sinhVienEntity.getNgaySinh());
        tf_CapNhatThongTinSV_GioiTinh.setText(sinhVienEntity.getGioiTinh());
        tf_CapNhatThongTinSV_MSSV.setText(sinhVienEntity.getMSSV());
        cb_CapNhatThongTinSV_Truong.setSelectedItem(truongLL.LayTenTruong(sinhVienEntity.getMaTruong()));
        tf_CapNhatThongTinSV_ThongTin_SDT.setText(sinhVienEntity.getSoDienThoai());
        tf_CapNhatThongTinSV_ThongTin_DanToc.setText(sinhVienEntity.getDanToc());
        tf_CapNhatThongTinSV_ThongTin_TonGiao.setText(sinhVienEntity.getTonGiao());
        tf_CapNhatThongTinSV_ThongTin_QuocTich.setText(sinhVienEntity.getQuocTich());
        cb_CapNhatThongTinSV_ThongTin_Tinh.setSelectedItem(tinhBLL.LayTenTinh(sinhVienEntity.getMaTinh()));
        tf_CapNhatThongTinSV_ThongTin_DiaChiNha.setText(sinhVienEntity.getDiaChiNha());

        ShowTable_CapNhatThongTinSinhVien(tf_CapNhatThongTinSinhVien_MaKTX.getText().trim());
    }//GEN-LAST:event_btn_CapNhatThongTinSinhVien_SearchActionPerformed

    private void btn_CapNhatThongTinSV_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatThongTinSV_HuyActionPerformed
        // TODO add your handling code here:
        tf_CapNhatThongTinSV_ThongTin_HoSinhVien.setText("");
        tf_CapNhatThongTinSV_ThongTin_TenSV.setText("");
        tf_CapNhatThongTinSV_CMND.setText("");
        dateChooser_CapNhatThongTinSV_ThongTin_NgayCap.setDate(null);
        dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh.setDate(null);
        tf_CapNhatThongTinSV_GioiTinh.setText("");
        tf_CapNhatThongTinSV_MSSV.setText("");
        cb_CapNhatThongTinSV_Truong.setSelectedItem("");
        tf_CapNhatThongTinSV_ThongTin_SDT.setText("");
        tf_CapNhatThongTinSV_ThongTin_DanToc.setText("");
        tf_CapNhatThongTinSV_ThongTin_TonGiao.setText("");
        tf_CapNhatThongTinSV_ThongTin_QuocTich.setText("");
        cb_CapNhatThongTinSV_ThongTin_Tinh.setSelectedItem("");
        tf_CapNhatThongTinSV_ThongTin_DiaChiNha.setText("");
        tb_CapNhatThongTinSinhVien.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btn_CapNhatThongTinSV_HuyActionPerformed

    private void btn_HeThong_TaiKhoan_TaoTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_TaiKhoan_TaoTaiKhoanActionPerformed
        // TODO add your handling code here:
        TaoTaiKhoanFrame taiKhoanFrame = new TaoTaiKhoanFrame();
        taiKhoanFrame.setVisible(true);
        taiKhoanFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_HeThong_TaiKhoan_TaoTaiKhoanActionPerformed

    private void btn_HeThong_TaiKhoan_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_TaiKhoan_DangXuatActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất???", "Exit", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_HeThong_TaiKhoan_DangXuatActionPerformed

    private void btn_HeThong_QuanLyDanhMuc_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HeThong_QuanLyDanhMuc_PhongActionPerformed
        // TODO add your handling code here:
        PhongFrame phongFrame = new PhongFrame();
        phongFrame.setVisible(true);
        phongFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_btn_HeThong_QuanLyDanhMuc_PhongActionPerformed

    /**
     * Sự kiện khi click vào combobox năm học của thống kê thu phí;
     *
     * @param evt
     */
  private void cb_ThongKeTongThu_NamHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ThongKeTongThu_NamHocActionPerformed
      Object obj = cb_ThongKeTongThu_NamHoc.getSelectedItem();

      if (obj == null) {
          System.out.println("Error: cb_ThongKeTongThu_NamHoc");
      } else {
          cb_ThongKeTongThu_HocKy.removeAllItems();
          showCombobox_HocKy_ThongKe((String) obj);
      }
  }//GEN-LAST:event_cb_ThongKeTongThu_NamHocActionPerformed
    /**
     * Sự kiện khi bấm vào nút in trong báo cáo thu phí;
     *
     * @param evt
     */
  private void btn_ThongKeTongThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongKeTongThuActionPerformed
      if (cb_ThongKeTongThu_HocKy.getSelectedItem() != null) {
          ThuPhiNoiTruBLL tpnt = new ThuPhiNoiTruBLL();

          String namHoc = cb_ThongKeTongThu_NamHoc.getSelectedItem().toString().trim();
          String hocKy = cb_ThongKeTongThu_HocKy.getSelectedItem().toString().trim();
          tpnt.inThongKeThuPhi(namHoc, hocKy);
      }
  }//GEN-LAST:event_btn_ThongKeTongThuActionPerformed

  private void btn_ThongKeSinhVien_TruongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongKeSinhVien_TruongActionPerformed

      QuyDinhThoiGianBLL qdtg = new QuyDinhThoiGianBLL();
      SinhVienBLL sv = new SinhVienBLL();

      QuyDinhThoiGianEntity qd = qdtg.LayThoiGian();
      String namHoc = qd.getNamHoc();

      try {
          sv.inThongKeTheoTruong(namHoc);
      } catch (FileNotFoundException ex) {
          Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
  }//GEN-LAST:event_btn_ThongKeSinhVien_TruongActionPerformed

  private void btn_ThongKeSinhVien_NhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongKeSinhVien_NhaActionPerformed

      QuyDinhThoiGianBLL qdtg = new QuyDinhThoiGianBLL();
      SinhVienBLL sv = new SinhVienBLL();

      QuyDinhThoiGianEntity qd = qdtg.LayThoiGian();
      String namHoc = qd.getNamHoc();

      try {
          sv.inThongKeTheoNha(namHoc);
      } catch (FileNotFoundException ex) {
          Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
      }

  }//GEN-LAST:event_btn_ThongKeSinhVien_NhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienFrame nhanVienFrame = new NhanVienFrame();
                nhanVienFrame.setTitle("Phần mềm quản lý ký túc xá");
                nhanVienFrame.setVisible(true);
                nhanVienFrame.setExtendedState(nhanVienFrame.MAXIMIZED_BOTH);
                nhanVienFrame.setResizable(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroup_QLSV_TiepNhanSV_GioiTinh;
    private javax.swing.JButton btn_CapNhatThongTinSV_Huy;
    private javax.swing.JButton btn_CapNhatThongTinSV_Luu;
    private javax.swing.JButton btn_CapNhatThongTinSinhVien_Search;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_KhoiNha;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_MucGiaDien;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_MucGiaNuoc;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_MucPhiKTX;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_Phong;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_ThoiGian;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_Tinh;
    private javax.swing.JButton btn_HeThong_QuanLyDanhMuc_Truong;
    private javax.swing.JButton btn_HeThong_TaiKhoan_DangXuat;
    private javax.swing.JButton btn_HeThong_TaiKhoan_DoiMatKhau;
    private javax.swing.JButton btn_HeThong_TaiKhoan_TaoTaiKhoan;
    private javax.swing.JButton btn_HoanTraPhiCSVC_XacNhan;
    private javax.swing.JButton btn_QLSV_TiepNhanSV_ThongTin_Huy;
    private javax.swing.JButton btn_QLSV_TiepNhanSV_ThongTin_Luu;
    private javax.swing.JButton btn_QLSV_TiepNhanSV_ThongTin_XepPhong;
    private javax.swing.JButton btn_QLSV_XepPhong_Huy;
    private javax.swing.JButton btn_QLSV_XepPhong_Luu;
    private javax.swing.JButton btn_QLSV_XepPhong_Search;
    private javax.swing.JButton btn_QLSV_XepPhong_ThuPhi;
    private javax.swing.JButton btn_QLSV_XuLySVKhoiKTX_XacNhan;
    private javax.swing.JButton btn_QLSV_XuLySVKhoiKTX_XuatHoaDon;
    private javax.swing.JButton btn_ThongKeSinhVien_Nha;
    private javax.swing.JButton btn_ThongKeSinhVien_Truong;
    private javax.swing.JButton btn_ThongKeTongThu;
    private javax.swing.JButton btn_ThuPhi_PhiDienNuoc_ThuPhi;
    private javax.swing.JButton btn_ThuPhi_PhiNoiTru;
    private javax.swing.JButton btn_ThuPhi_PhiNoiTru_XuatHoaDon;
    private javax.swing.JButton btn_TraCuu_SinhVien_Search;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb_CapNhatThongTinSV_ThongTin_Tinh;
    private javax.swing.JComboBox<String> cb_CapNhatThongTinSV_Truong;
    private javax.swing.JComboBox<String> cb_HoanTraPhiCSVC_NamHoc;
    private javax.swing.JComboBox<String> cb_QLSV_TiepNhanSV_ThongTin_Truong;
    private javax.swing.JComboBox<String> cb_QLSV_XepPhong_HocKy;
    private javax.swing.JComboBox<String> cb_QLSV_XepPhong_LoaiPhong_SoNguoi;
    private javax.swing.JComboBox<String> cb_QLSV_XepPhong_NamHoc;
    private javax.swing.JComboBox<String> cb_ThongKeTongThu_HocKy;
    private javax.swing.JComboBox<String> cb_ThongKeTongThu_NamHoc;
    private javax.swing.JComboBox<String> cb_ThuPhi_PhiDienNuoc_KhoiNha;
    private javax.swing.JComboBox<String> cb_ThuPhi_PhiDienNuoc_Phong;
    private javax.swing.JComboBox<String> cb_TraCuuDienNuoc_Nha;
    private javax.swing.JComboBox<String> cb_TraCuuDienNuoc_Phong;
    private javax.swing.JComboBox<String> cb_TraCuu_ThongTinPhong_Nha;
    private javax.swing.JComboBox<String> cb_TraCuu_ThongTinPhong_Phong;
    private com.toedter.calendar.JDateChooser dateChooser_CapNhatThongTinSV_ThongTin_NgayCap;
    private com.toedter.calendar.JDateChooser dateChooser_CapNhatThongTinSV_ThongTin_NgaySinh;
    private com.toedter.calendar.JDateChooser dateChooser_QLSV_TiepNhanSV_ThongTin_NgayCap;
    private com.toedter.calendar.JDateChooser dateChooser_QLSV_TiepNhanSV_ThongTin_NgaySinh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lb_CapNhatThongTinSV_HoSinhVien;
    private javax.swing.JLabel lb_CapNhatThongTinSV_HoSoSV;
    private javax.swing.JLabel lb_CapNhatThongTinSV_MaKTX;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_CMND;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_DanToc;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_DiaChiNha;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_GioiTinh;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_MSSV;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_NgayCap;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_NgaySinh;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_QuocTich;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_SDT;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_TenSV;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_Tinh;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_TonGiao;
    private javax.swing.JLabel lb_CapNhatThongTinSV_ThongTin_Truong;
    private javax.swing.JLabel lb_HeThong_QuanLyDanhMuc_QuanLyDanhMuc;
    private javax.swing.JLabel lb_HeThong_TaiKhoan_QuanLyTaiKhoan;
    private javax.swing.JLabel lb_HoanTraPhiCSVC;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_GioiTinh;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_GioiTinh_ChiTiet;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_HoTen;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_HoTen_ChiTiet;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_MSSV;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_MSSV_ChiTiet;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_MaKTX;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_NamHoc;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_Nha;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_Nha_ChiTiet;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_PhiHoanTra;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_PhiHoanTra_ChiTiet;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_Phong;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_Phong_ChiTiet;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_Truong;
    private javax.swing.JLabel lb_HoanTraPhiCSVC_Truong_ChiTiet;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_HoSoSV;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_CMND;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_GioiTinh;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_HoSV;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_MSSV;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_NgayCap;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_NgaySinh;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_TenSV;
    private javax.swing.JLabel lb_QLSV_TiepNhanSV_ThongTin_Truong;
    private javax.swing.JLabel lb_QLSV_XepPhong_CMND;
    private javax.swing.JLabel lb_QLSV_XepPhong_CMND_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_GioiTinh;
    private javax.swing.JLabel lb_QLSV_XepPhong_GioiTinh_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_HoTen;
    private javax.swing.JLabel lb_QLSV_XepPhong_HoTen_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_HocKy;
    private javax.swing.JLabel lb_QLSV_XepPhong_LoaiPhong_SoNguoi;
    private javax.swing.JLabel lb_QLSV_XepPhong_MSSV;
    private javax.swing.JLabel lb_QLSV_XepPhong_MSSV_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_MaKTX;
    private javax.swing.JLabel lb_QLSV_XepPhong_NamHoc;
    private javax.swing.JLabel lb_QLSV_XepPhong_NgaySinh;
    private javax.swing.JLabel lb_QLSV_XepPhong_NgaySinh_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_Nha;
    private javax.swing.JLabel lb_QLSV_XepPhong_Nha_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_Phong;
    private javax.swing.JLabel lb_QLSV_XepPhong_Phong_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_Truong;
    private javax.swing.JLabel lb_QLSV_XepPhong_Truong_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XepPhong_XepPhongSV;
    private javax.swing.JLabel lb_QLSV_XuLySVKhoiKTX_MaKTX;
    private javax.swing.JLabel lb_QLSV_XuLySVKhoiKTX_XuLySVKhoiKTX;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_CMND;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_CMND_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_GioiTinh;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_GioiTinh_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_HoTen;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_HoTen_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_HocKy;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_HocKy_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_MSSV;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_MSSV_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_NamHoc;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_NamHoc_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_NgaySinh;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_NgaySinh_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_Nha;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_Nha_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_PhiHoanTra_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_PhiNoiTru_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_Phong;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_Phong_ChiTiet;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_Truong;
    private javax.swing.JLabel lb_QLSV_XuLySVRaKhoiKTX_Truong_ChiTiet;
    private javax.swing.JLabel lb_ThongKeSinhVien;
    private javax.swing.JLabel lb_ThongKeTongThu;
    private javax.swing.JLabel lb_ThongKeTongThu_HocKy;
    private javax.swing.JLabel lb_ThongKeTongThu_NamHoc;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_KhoiNha;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_Nha;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_Nha_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_Phong;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_Phong_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_SoKWDien;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_SoKWDien_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_SoKhoiNuoc_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TenPhong;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_ThangNam;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_ThangNam_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TienDien;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TienDien_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TienNuoc;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TienNuoc_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TongCong;
    private javax.swing.JLabel lb_ThuPhi_PhiDienNuoc_TongCong_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_CMND;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_CMND_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_GioiTinh;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_GioiTinh_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_HoTen;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_HoTen_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_HocKy;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_HocKy_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_MSSV;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_MSSV_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_MaKTX;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_NamHoc;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_NamHoc_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_NgaySinh;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_NgaySinh_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_Nha;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_Nha_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_PhiNoiTru;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_PhiNoiTru_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_Phong;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_Phong_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_ThuPhiNoiTru;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_Truong;
    private javax.swing.JLabel lb_ThuPhi_PhiNoiTru_Truong_ChiTiet;
    private javax.swing.JLabel lb_ThuPhi_ThuPhiDienNuoc;
    private javax.swing.JLabel lb_TraCuuDienNuoc;
    private javax.swing.JLabel lb_TraCuuDienNuoc_Nha;
    private javax.swing.JLabel lb_TraCuuDienNuoc_Phong;
    private javax.swing.JLabel lb_TraCuuPhong;
    private javax.swing.JLabel lb_TraCuuPhong_Nha;
    private javax.swing.JLabel lb_TraCuuPhong_Phong;
    private javax.swing.JLabel lb_TraCuu_SinhVien_TraCuuSV;
    private javax.swing.JPanel pn_CapNhatHoSoSinhVien;
    private javax.swing.JPanel pn_CapNhatHoSo_ThongTin;
    private javax.swing.JPanel pn_HeThong_QuanLyDanhMuc;
    private javax.swing.JPanel pn_HeThong_QuanLyDanhMuc_QuanLyDanhMuc;
    private javax.swing.JPanel pn_HeThong_TaiKhoan;
    private javax.swing.JPanel pn_HeThong_TaiKhoan_ThongTin;
    private javax.swing.JPanel pn_HeThong_TroGiup;
    private javax.swing.JPanel pn_HoanTraPhiCSVC;
    private javax.swing.JPanel pn_HoanTraPhiCSVC_ChiTiet;
    private javax.swing.JPanel pn_HoanTraPhiCSVC_ThongTin;
    private javax.swing.JPanel pn_QLSV_TiepNhanSV_ThongTin;
    private javax.swing.JPanel pn_QLSV_XepPhong_LoaiPhong;
    private javax.swing.JPanel pn_QLSV_XepPhong_LoaiPhong_GioiTinh;
    private javax.swing.JPanel pn_QLSV_XepPhong_ThongTin;
    private javax.swing.JPanel pn_QLSV_XepPhong_ThongTinChiTiet;
    private javax.swing.JPanel pn_QLSV_XuLySVKhoiKTX_ThongTin;
    private javax.swing.JPanel pn_QLSV_XuLySVRaKhoiKTX_ChiTiet;
    private javax.swing.JPanel pn_ThongKeSinhVien;
    private javax.swing.JPanel pn_ThongKeSinhVien_HinhThucThongKe;
    private javax.swing.JPanel pn_ThongKeTongThu;
    private javax.swing.JPanel pn_ThongKeTongThu_ThongTin;
    private javax.swing.JPanel pn_ThuPhi_PhiDienNuoc;
    private javax.swing.JPanel pn_ThuPhi_PhiDienNuoc_ThongTinDienNuoc;
    private javax.swing.JPanel pn_ThuPhi_PhiDienNuoc_ThongTinPhong;
    private javax.swing.JPanel pn_ThuPhi_PhiNoiTru;
    private javax.swing.JPanel pn_ThuPhi_PhiNoiTru_ThongTin;
    private javax.swing.JPanel pn_ThuPhi_PhiNoiTru_ThongTinChiTiet;
    private javax.swing.JPanel pn_TiepNhanSinhVien;
    private javax.swing.JPanel pn_TraCuuDienNuoc;
    private javax.swing.JPanel pn_TraCuuDienNuoc_ThongTin;
    private javax.swing.JPanel pn_TraCuuPhong;
    private javax.swing.JPanel pn_TraCuuSinhVien;
    private javax.swing.JPanel pn_XepPhong;
    private javax.swing.JPanel pn_XuLySinhVienRaKhoiKTX;
    private javax.swing.JRadioButton rb_QLSV_TiepNhanSV_GioiTinh_Nam;
    private javax.swing.JRadioButton rb_QLSV_TiepNhanSV_GioiTinh_Nu;
    private javax.swing.JRadioButton rb_QLSV_XepPhong_LoaiPhong_Nam;
    private javax.swing.JRadioButton rb_QLSV_XepPhong_LoaiPhong_Nu;
    private javax.swing.JScrollPane scrollPane_QLSV_TiepNhanSV_Table;
    private javax.swing.JScrollPane scrollPane_QLSV_XepPhong_Table;
    private javax.swing.JScrollPane scrollPane_QLSV_XuLySVKhoiKTX_Table;
    private javax.swing.JScrollPane scrollPanel_HeThong;
    private javax.swing.JScrollPane scrollPanel_HoanTraPhi;
    private javax.swing.JScrollPane scrollPanel_QLSV;
    private javax.swing.JScrollPane scrollPanel_ThongKe;
    private javax.swing.JScrollPane scrollPanel_ThuPhi;
    private javax.swing.JScrollPane scrollPanel_TraCuu;
    private javax.swing.JTabbedPane tab_HeThong;
    private javax.swing.JTabbedPane tab_HoanTraPhi;
    private javax.swing.JTabbedPane tab_Main;
    private javax.swing.JTabbedPane tab_QuanLySinhVien;
    private javax.swing.JTabbedPane tab_ThongKe;
    private javax.swing.JTabbedPane tab_ThuPhi;
    private javax.swing.JTabbedPane tab_TraCuu;
    private javax.swing.JTable tb_CapNhatThongTinSinhVien;
    private javax.swing.JTable tb_HoanTraPhiCSVC;
    private javax.swing.JTable tb_QLSV_TiepNhanSV;
    private javax.swing.JTable tb_QLSV_XepPhong;
    private javax.swing.JTable tb_QLSV_XuLySVKhoiKTX;
    private javax.swing.JTable tb_ThuPhiDienNuoc;
    private javax.swing.JTable tb_ThuPhi_PhiNoiTru;
    private javax.swing.JTable tb_TraCuuDienNuoc;
    private javax.swing.JTable tb_TraCuu_SinhVien;
    private javax.swing.JTable tb_TraCuu_ThongTinPhong;
    private javax.swing.JTextField tf_CapNhatThongTinSV_CMND;
    private javax.swing.JTextField tf_CapNhatThongTinSV_GioiTinh;
    private javax.swing.JTextField tf_CapNhatThongTinSV_MSSV;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_DanToc;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_DiaChiNha;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_HoSinhVien;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_QuocTich;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_SDT;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_TenSV;
    private javax.swing.JTextField tf_CapNhatThongTinSV_ThongTin_TonGiao;
    private javax.swing.JTextField tf_CapNhatThongTinSinhVien_MaKTX;
    private javax.swing.JTextField tf_HoanTraPhiCSVC_MaKTX;
    private javax.swing.JTextField tf_QLSV_TiepNhanSV_ThongTin_CMND;
    private javax.swing.JTextField tf_QLSV_TiepNhanSV_ThongTin_HoSV;
    private javax.swing.JTextField tf_QLSV_TiepNhanSV_ThongTin_MSSV;
    private javax.swing.JTextField tf_QLSV_TiepNhanSV_ThongTin_TenSV;
    private javax.swing.JTextField tf_QLSV_XepPhong_MaKTX;
    private javax.swing.JTextField tf_QLSV_XuLySVKhoiKTX_MaKTX;
    private javax.swing.JTextField tf_ThuPhi_PhiNoiTru_MaKTX;
    private javax.swing.JTextField tf_TraCuu_SinhVien;
    // End of variables declaration//GEN-END:variables
}
