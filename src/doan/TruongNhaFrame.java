/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import BLL.BackupGhiNhanDienNuocBLL;
import BLL.BackupThuPhiDienNuocBLL;
import BLL.GhiNhanDienNuocBLL;
import BLL.GhiNhanKyLuatBLL;
import BLL.NhaBLL;
import BLL.PhongBLL;
import BLL.SinhVienBLL;
import BLL.ThuPhiDienNuocBLL;
import BLL.TruongBLL;
import Entities.GhiNhanDienNuocEntity;
import Entities.SinhVienEntity;
import Entities.TruongEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class TruongNhaFrame extends javax.swing.JFrame {

    public TruongNhaFrame() {
        initComponents();
        showComboBoxNha_GhiNhanDienNuoc();
        showComboBoxNha_TraCuuPhong();
        showComboBoxNha_TraCuuDN();
        ShowTable_GhiNhanKyLuat();
    }

    public void showComboBoxNha_GhiNhanDienNuoc() {
        NhaBLL nhaBLL = new NhaBLL();
        ArrayList<String> danhSachNha = nhaBLL.LayDanhSachNha();
        for (int i = 0; i < danhSachNha.size(); i++) {
            cb_GhiNhanDienNuoc_Nha.addItem(danhSachNha.get(i));
        }
    }

    public void showComboBoxPhong_GhiNhanDienNuoc(String tenNha) {
        PhongBLL phongBLL = new PhongBLL();
        ArrayList<String> danhSachPhong = phongBLL.LayDanhSachPhong(tenNha);
        for (int i = 0; i < danhSachPhong.size(); i++) {
            cb_GhiNhanDienNuoc_Phong.addItem(danhSachPhong.get(i));
        }
    }

    public void showTable_GhiNhanDienNuoc(String TenNha, String TenPhong) {
        Vector cols = new Vector();
        Vector data = new Vector();
        GhiNhanDienNuocBLL ghiNhanDienNuocBLL = new GhiNhanDienNuocBLL();
        ghiNhanDienNuocBLL.ShowTable(cols, data, TenNha, TenPhong);
        tb_GhiNhanDienNuoc.setModel(new AbstractTableModel() {
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

        tb_TraCuuSinhVien.setModel(new AbstractTableModel() {
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

    public void ShowTable_TraCuuPhong(String tenNha, String tenPhong) {
        SinhVienBLL svBLL = new SinhVienBLL();

        Vector cols = new Vector();
        Vector data = new Vector();

        svBLL.searchSV_Nha_Phong(cols, data, tenNha, tenPhong);
        tb_TraCuuPhong.setModel(new AbstractTableModel() {
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

    public void ShowTable_GhiNhanKyLuat() {
        Vector cols = new Vector();
        Vector data = new Vector();
        GhiNhanKyLuatBLL ghiNhanKyLuatBLL = new GhiNhanKyLuatBLL();
        ghiNhanKyLuatBLL.ShowTable(cols, data);
        tb_GhiNhanKyLuat.setModel(new AbstractTableModel() {
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

    /**
     * Phương thức lấy danh sách nhà đổ vào comboBox;
     *
     * @param comboBox
     */
    public void showComboBoxNha_TraCuuPhong() {
        NhaBLL nhaBLL = new NhaBLL();
        ArrayList<String> danhSachNha = nhaBLL.LayDanhSachNha();
        for (int i = 0; i < danhSachNha.size(); i++) {
            cb_TraCuuPhong_Nha.addItem(danhSachNha.get(i));
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
            cb_TraCuuPhong_Phong.addItem(danhSachPhong.get(i));
        }
    }

    public void showComboBoxNha_TraCuuDN() {
        NhaBLL nhaBLL = new NhaBLL();
        ArrayList<String> danhSachNha = nhaBLL.LayDanhSachNha();
        for (int i = 0; i < danhSachNha.size(); i++) {
            cb_TraCuuDienNuoc_Nha.addItem(danhSachNha.get(i));
        }
    }

    public void showComboBoxPhong_TraCuuDN(String tenNha) {
        PhongBLL phongBLL = new PhongBLL();
        ArrayList<String> danhSachPhong = phongBLL.LayDanhSachPhong(tenNha);
        for (int i = 0; i < danhSachPhong.size(); i++) {
            cb_TraCuuDienNuoc_Phong.addItem(danhSachPhong.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        scrollPanelTaiKhoan = new javax.swing.JScrollPane();
        pn_TaiKhoan = new javax.swing.JPanel();
        lb_QuanLyTaiKhoan = new javax.swing.JLabel();
        pn_TaiKhoan_ChiTiet = new javax.swing.JPanel();
        btn_DoiMatKhau = new javax.swing.JButton();
        btn_DangXuat = new javax.swing.JButton();
        scrollPanelTraCuu = new javax.swing.JScrollPane();
        pn_TraCuu = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pn_TraCuuSinhVien = new javax.swing.JPanel();
        lb_TraCuuSinhVien = new javax.swing.JLabel();
        tf_TraCuuSinhVien = new javax.swing.JTextField();
        btn_TraCuuSinhVien_Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_TraCuuSinhVien = new javax.swing.JTable();
        pn_TraCuuPhong = new javax.swing.JPanel();
        lb_TraCuuPhong = new javax.swing.JLabel();
        lb_TraCuuPhong_Nha = new javax.swing.JLabel();
        cb_TraCuuPhong_Nha = new javax.swing.JComboBox<>();
        lb_TraCuuPhong_Phong = new javax.swing.JLabel();
        cb_TraCuuPhong_Phong = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_TraCuuPhong = new javax.swing.JTable();
        pn_TraCuuDienNuoc = new javax.swing.JPanel();
        lb_TraCuuDienNuoc = new javax.swing.JLabel();
        pn_TraCuuDienNuoc_ThongTin = new javax.swing.JPanel();
        lb_TraCuuDienNuoc_Nha = new javax.swing.JLabel();
        lb_TraCuuDienNuoc_Phong = new javax.swing.JLabel();
        cb_TraCuuDienNuoc_Nha = new javax.swing.JComboBox<>();
        cb_TraCuuDienNuoc_Phong = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_TraCuuDienNuoc = new javax.swing.JTable();
        scrollPanelGhiNhanDN = new javax.swing.JScrollPane();
        pn_GhiNhanDienNuoc = new javax.swing.JPanel();
        lb_GhiNhanDienNuoc = new javax.swing.JLabel();
        pn_GhiNhanDienNuoc_ThongTin = new javax.swing.JPanel();
        lb_GhiNhanDienNuoc_Nha = new javax.swing.JLabel();
        cb_GhiNhanDienNuoc_Nha = new javax.swing.JComboBox<>();
        lb_GhiNhanDienNuoc_Phong = new javax.swing.JLabel();
        cb_GhiNhanDienNuoc_Phong = new javax.swing.JComboBox<>();
        lb_GhiNhanDienNuoc_ChiSoDienCuoi = new javax.swing.JLabel();
        tf_GhiNhanDienNuoc_ChiSoDienCuoi = new javax.swing.JTextField();
        lb_GhiNhanDienNuoc_ChiSoNuocCuoi = new javax.swing.JLabel();
        tf_GhiNhanDienNuoc_ChiSoNuocCuoi = new javax.swing.JTextField();
        lb_GhiNhanDienNuoc_KWH = new javax.swing.JLabel();
        lb_GhiNhanDienNuoc_Khoi = new javax.swing.JLabel();
        lb_GhiNhanDienNuoc_ThangNam = new javax.swing.JLabel();
        lb_GhiNhanDienNuoc_ThangNam_ChiTiet = new javax.swing.JLabel();
        btn_GhiNhanDienNuoc_XacNhan = new javax.swing.JButton();
        btn_GhiNhanDienNuoc_Huy = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_GhiNhanDienNuoc = new javax.swing.JTable();
        scrollPanelGhiNhanKyLuat = new javax.swing.JScrollPane();
        pn_GhiNhanKyLuat = new javax.swing.JPanel();
        lb_GhiNhanKyLuat = new javax.swing.JLabel();
        pn_GhiNhanKyLuat_TimKiem = new javax.swing.JPanel();
        lb_MaKTX_GhiNhanKyLuat = new javax.swing.JLabel();
        tf_MaKTX_GhiNhanKyLuat = new javax.swing.JTextField();
        lb_HoTen_GhiNhanKyLuat = new javax.swing.JLabel();
        lb_HoTen_GhiNhanKyLuat_ChiTiet = new javax.swing.JLabel();
        lb_MSSV_GhiNhanKyLuat = new javax.swing.JLabel();
        lb_MSSV_GhiNhanKyLuat_ChiTiet = new javax.swing.JLabel();
        lb_Truong_GhiNhanKyLuat = new javax.swing.JLabel();
        lb_Truong_GhiNhanKyLuat_ChiTiet = new javax.swing.JLabel();
        lb_Phong_GhiNhanKyLuat = new javax.swing.JLabel();
        lb_Phong_GhiNhanKyLuat_ChiTiet = new javax.swing.JLabel();
        lb_Nha_GhiNhanKyLuat = new javax.swing.JLabel();
        lb_Nha_GhiNhanKyLuat_ChiTiet = new javax.swing.JLabel();
        pn_GhiNhanKyLuat_ThongTin = new javax.swing.JPanel();
        lb_MucKyLuat_GhiNhanKyLuat = new javax.swing.JLabel();
        cb_MucKyLuat_GhiNhanKyLuat = new javax.swing.JComboBox<>();
        lb_GhiChu_GhiNhanKyLuat = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_GhiChu_GhiNhanKyLuat = new javax.swing.JTextArea();
        btn_XacNhan_GhiNhanKyLuat = new javax.swing.JButton();
        btn_Huy_GhiNhanKyLuat = new javax.swing.JButton();
        btn_KyLuatSinhVien_QuanLyMucKyLuat = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_GhiNhanKyLuat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        pn_TaiKhoan.setBackground(new java.awt.Color(255, 255, 255));

        lb_QuanLyTaiKhoan.setBackground(new java.awt.Color(0, 153, 255));
        lb_QuanLyTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_QuanLyTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lb_QuanLyTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_QuanLyTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png"))); // NOI18N
        lb_QuanLyTaiKhoan.setText("QUẢN LÝ TÀI KHOẢN");
        lb_QuanLyTaiKhoan.setOpaque(true);

        pn_TaiKhoan_ChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pn_TaiKhoan_ChiTiet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tài Khoản"));

        btn_DoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh-icon.png"))); // NOI18N
        btn_DoiMatKhau.setText("Đổi Mật Khẩu");
        btn_DoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoiMatKhauActionPerformed(evt);
            }
        });

        btn_DangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        btn_DangXuat.setText("Đăng Xuất");
        btn_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_TaiKhoan_ChiTietLayout = new javax.swing.GroupLayout(pn_TaiKhoan_ChiTiet);
        pn_TaiKhoan_ChiTiet.setLayout(pn_TaiKhoan_ChiTietLayout);
        pn_TaiKhoan_ChiTietLayout.setHorizontalGroup(
            pn_TaiKhoan_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TaiKhoan_ChiTietLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btn_DoiMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btn_DangXuat)
                .addGap(48, 48, 48))
        );

        pn_TaiKhoan_ChiTietLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_DangXuat, btn_DoiMatKhau});

        pn_TaiKhoan_ChiTietLayout.setVerticalGroup(
            pn_TaiKhoan_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TaiKhoan_ChiTietLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pn_TaiKhoan_ChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_DoiMatKhau)
                    .addComponent(btn_DangXuat))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pn_TaiKhoan_ChiTietLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_DangXuat, btn_DoiMatKhau});

        javax.swing.GroupLayout pn_TaiKhoanLayout = new javax.swing.GroupLayout(pn_TaiKhoan);
        pn_TaiKhoan.setLayout(pn_TaiKhoanLayout);
        pn_TaiKhoanLayout.setHorizontalGroup(
            pn_TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TaiKhoanLayout.createSequentialGroup()
                .addContainerGap(434, Short.MAX_VALUE)
                .addComponent(pn_TaiKhoan_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(413, 413, 413))
            .addComponent(lb_QuanLyTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_TaiKhoanLayout.setVerticalGroup(
            pn_TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TaiKhoanLayout.createSequentialGroup()
                .addComponent(lb_QuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(pn_TaiKhoan_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );

        scrollPanelTaiKhoan.setViewportView(pn_TaiKhoan);

        jTabbedPane1.addTab("Tài Khoản", new javax.swing.ImageIcon(getClass().getResource("/Images/user.png")), scrollPanelTaiKhoan); // NOI18N

        pn_TraCuu.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        pn_TraCuuSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        lb_TraCuuSinhVien.setBackground(new java.awt.Color(0, 153, 255));
        lb_TraCuuSinhVien.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lb_TraCuuSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        lb_TraCuuSinhVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TraCuuSinhVien.setText("TRA CỨU SINH VIÊN");
        lb_TraCuuSinhVien.setOpaque(true);

        tf_TraCuuSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TraCuuSinhVienActionPerformed(evt);
            }
        });

        btn_TraCuuSinhVien_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-engine.png"))); // NOI18N
        btn_TraCuuSinhVien_Search.setText("Search");
        btn_TraCuuSinhVien_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TraCuuSinhVien_SearchActionPerformed(evt);
            }
        });

        tb_TraCuuSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KTX", "Họ", "Tên", "Giới Tính", "Ngày Sinh", "MSSV", "Trường", "Phòng", "Nhà", "Tỉnh", "Dân Tộc", "Tôn Giáo", "Quốc Tịch"
            }
        ));
        jScrollPane1.setViewportView(tb_TraCuuSinhVien);

        javax.swing.GroupLayout pn_TraCuuSinhVienLayout = new javax.swing.GroupLayout(pn_TraCuuSinhVien);
        pn_TraCuuSinhVien.setLayout(pn_TraCuuSinhVienLayout);
        pn_TraCuuSinhVienLayout.setHorizontalGroup(
            pn_TraCuuSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addComponent(lb_TraCuuSinhVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TraCuuSinhVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_TraCuuSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TraCuuSinhVien_Search)
                .addGap(333, 333, 333))
        );
        pn_TraCuuSinhVienLayout.setVerticalGroup(
            pn_TraCuuSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuSinhVienLayout.createSequentialGroup()
                .addComponent(lb_TraCuuSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(pn_TraCuuSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TraCuuSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TraCuuSinhVien_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tra Cứu Sinh Viên", new javax.swing.ImageIcon(getClass().getResource("/Images/network.png")), pn_TraCuuSinhVien); // NOI18N

        pn_TraCuuPhong.setBackground(new java.awt.Color(255, 255, 255));

        lb_TraCuuPhong.setBackground(new java.awt.Color(0, 153, 255));
        lb_TraCuuPhong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_TraCuuPhong.setForeground(new java.awt.Color(255, 255, 255));
        lb_TraCuuPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TraCuuPhong.setText("TRA CỨU PHÒNG");
        lb_TraCuuPhong.setOpaque(true);

        lb_TraCuuPhong_Nha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuPhong_Nha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1478717707_line-49.png"))); // NOI18N
        lb_TraCuuPhong_Nha.setText("Nhà:");

        cb_TraCuuPhong_Nha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuuPhong_NhaActionPerformed(evt);
            }
        });

        lb_TraCuuPhong_Phong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuPhong_Phong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1478718156_icons_home.png"))); // NOI18N
        lb_TraCuuPhong_Phong.setText("Phòng:");

        cb_TraCuuPhong_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuuPhong_PhongActionPerformed(evt);
            }
        });

        tb_TraCuuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tb_TraCuuPhong);

        javax.swing.GroupLayout pn_TraCuuPhongLayout = new javax.swing.GroupLayout(pn_TraCuuPhong);
        pn_TraCuuPhong.setLayout(pn_TraCuuPhongLayout);
        pn_TraCuuPhongLayout.setHorizontalGroup(
            pn_TraCuuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addGroup(pn_TraCuuPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TraCuuPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_TraCuuPhongLayout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(lb_TraCuuPhong_Nha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_TraCuuPhong_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lb_TraCuuPhong_Phong)
                .addGap(18, 18, 18)
                .addComponent(cb_TraCuuPhong_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_TraCuuPhongLayout.setVerticalGroup(
            pn_TraCuuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TraCuuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pn_TraCuuPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TraCuuPhong_Nha)
                    .addComponent(cb_TraCuuPhong_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TraCuuPhong_Phong)
                    .addComponent(cb_TraCuuPhong_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Tra Cứu Phòng", new javax.swing.ImageIcon(getClass().getResource("/Images/house.png")), pn_TraCuuPhong); // NOI18N

        pn_TraCuuDienNuoc.setBackground(new java.awt.Color(255, 255, 255));

        lb_TraCuuDienNuoc.setBackground(new java.awt.Color(0, 153, 255));
        lb_TraCuuDienNuoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_TraCuuDienNuoc.setForeground(new java.awt.Color(255, 255, 255));
        lb_TraCuuDienNuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_TraCuuDienNuoc.setText("THÔNG TIN ĐIỆN NƯỚC");
        lb_TraCuuDienNuoc.setOpaque(true);

        pn_TraCuuDienNuoc_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_TraCuuDienNuoc_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_TraCuuDienNuoc_Nha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuDienNuoc_Nha.setText("Khối Nhà:");

        lb_TraCuuDienNuoc_Phong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_TraCuuDienNuoc_Phong.setText("Phòng:");

        cb_TraCuuDienNuoc_Nha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TraCuuDienNuoc_NhaActionPerformed(evt);
            }
        });

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
                .addGap(21, 21, 21)
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_TraCuuDienNuoc_Nha)
                    .addComponent(lb_TraCuuDienNuoc_Phong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_TraCuuDienNuoc_Nha, 0, 161, Short.MAX_VALUE)
                    .addComponent(cb_TraCuuDienNuoc_Phong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 91, Short.MAX_VALUE))
        );
        pn_TraCuuDienNuoc_ThongTinLayout.setVerticalGroup(
            pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TraCuuDienNuoc_Nha)
                    .addComponent(cb_TraCuuDienNuoc_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_TraCuuDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_TraCuuDienNuoc_Phong)
                    .addComponent(cb_TraCuuDienNuoc_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tb_TraCuuDienNuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tb_TraCuuDienNuoc);

        javax.swing.GroupLayout pn_TraCuuDienNuocLayout = new javax.swing.GroupLayout(pn_TraCuuDienNuoc);
        pn_TraCuuDienNuoc.setLayout(pn_TraCuuDienNuocLayout);
        pn_TraCuuDienNuocLayout.setHorizontalGroup(
            pn_TraCuuDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addComponent(lb_TraCuuDienNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TraCuuDienNuocLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_TraCuuDienNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );
        pn_TraCuuDienNuocLayout.setVerticalGroup(
            pn_TraCuuDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuDienNuocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TraCuuDienNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_TraCuuDienNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jTabbedPane2.addTab("Thông Tin Điện Nước", new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png")), pn_TraCuuDienNuoc); // NOI18N

        javax.swing.GroupLayout pn_TraCuuLayout = new javax.swing.GroupLayout(pn_TraCuu);
        pn_TraCuu.setLayout(pn_TraCuuLayout);
        pn_TraCuuLayout.setHorizontalGroup(
            pn_TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        pn_TraCuuLayout.setVerticalGroup(
            pn_TraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TraCuuLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        scrollPanelTraCuu.setViewportView(pn_TraCuu);

        jTabbedPane1.addTab("Tra Cứu", new javax.swing.ImageIcon(getClass().getResource("/Images/search-engine.png")), scrollPanelTraCuu); // NOI18N

        pn_GhiNhanDienNuoc.setBackground(new java.awt.Color(255, 255, 255));

        lb_GhiNhanDienNuoc.setBackground(new java.awt.Color(0, 153, 255));
        lb_GhiNhanDienNuoc.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lb_GhiNhanDienNuoc.setForeground(new java.awt.Color(255, 255, 255));
        lb_GhiNhanDienNuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_GhiNhanDienNuoc.setText("GHI NHẬN ĐIỆN NƯỚC");
        lb_GhiNhanDienNuoc.setOpaque(true);

        pn_GhiNhanDienNuoc_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_GhiNhanDienNuoc_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_GhiNhanDienNuoc_Nha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_GhiNhanDienNuoc_Nha.setText("Khối Nhà:");

        cb_GhiNhanDienNuoc_Nha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GhiNhanDienNuoc_NhaActionPerformed(evt);
            }
        });

        lb_GhiNhanDienNuoc_Phong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_GhiNhanDienNuoc_Phong.setText("Phòng:");

        cb_GhiNhanDienNuoc_Phong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GhiNhanDienNuoc_PhongActionPerformed(evt);
            }
        });

        lb_GhiNhanDienNuoc_ChiSoDienCuoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_GhiNhanDienNuoc_ChiSoDienCuoi.setText("Chỉ Số Điện Cuối:");

        lb_GhiNhanDienNuoc_ChiSoNuocCuoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_GhiNhanDienNuoc_ChiSoNuocCuoi.setText("Chỉ Số Nước Cuối:");

        lb_GhiNhanDienNuoc_KWH.setText("Kwh");

        lb_GhiNhanDienNuoc_Khoi.setText("Khối");

        lb_GhiNhanDienNuoc_ThangNam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_GhiNhanDienNuoc_ThangNam.setText("Tháng - Năm:");

        lb_GhiNhanDienNuoc_ThangNam_ChiTiet.setText("Tháng/Năm");

        javax.swing.GroupLayout pn_GhiNhanDienNuoc_ThongTinLayout = new javax.swing.GroupLayout(pn_GhiNhanDienNuoc_ThongTin);
        pn_GhiNhanDienNuoc_ThongTin.setLayout(pn_GhiNhanDienNuoc_ThongTinLayout);
        pn_GhiNhanDienNuoc_ThongTinLayout.setHorizontalGroup(
            pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_GhiNhanDienNuoc_ThongTinLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_GhiNhanDienNuoc_Nha)
                    .addComponent(lb_GhiNhanDienNuoc_Phong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_GhiNhanDienNuoc_Nha, 0, 104, Short.MAX_VALUE)
                    .addComponent(cb_GhiNhanDienNuoc_Phong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createSequentialGroup()
                            .addComponent(lb_GhiNhanDienNuoc_ChiSoDienCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24))
                        .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createSequentialGroup()
                            .addComponent(lb_GhiNhanDienNuoc_ChiSoNuocCuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)))
                    .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_GhiNhanDienNuoc_ThangNam)
                        .addGap(63, 63, 63)))
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_GhiNhanDienNuoc_ThangNam_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(tf_GhiNhanDienNuoc_ChiSoDienCuoi)
                    .addComponent(tf_GhiNhanDienNuoc_ChiSoNuocCuoi))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_GhiNhanDienNuoc_KWH)
                    .addComponent(lb_GhiNhanDienNuoc_Khoi))
                .addGap(189, 189, 189))
        );
        pn_GhiNhanDienNuoc_ThongTinLayout.setVerticalGroup(
            pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createSequentialGroup()
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_GhiNhanDienNuoc_ChiSoDienCuoi)
                    .addComponent(tf_GhiNhanDienNuoc_ChiSoDienCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_GhiNhanDienNuoc_KWH)
                    .addComponent(lb_GhiNhanDienNuoc_Nha)
                    .addComponent(cb_GhiNhanDienNuoc_Nha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_GhiNhanDienNuoc_ChiSoNuocCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_GhiNhanDienNuoc_ChiSoNuocCuoi)
                    .addComponent(lb_GhiNhanDienNuoc_Khoi)
                    .addComponent(lb_GhiNhanDienNuoc_Phong)
                    .addComponent(cb_GhiNhanDienNuoc_Phong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanDienNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_GhiNhanDienNuoc_ThangNam)
                    .addComponent(lb_GhiNhanDienNuoc_ThangNam_ChiTiet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_GhiNhanDienNuoc_XacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_GhiNhanDienNuoc_XacNhan.setText("Xác Nhận");
        btn_GhiNhanDienNuoc_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GhiNhanDienNuoc_XacNhanActionPerformed(evt);
            }
        });

        btn_GhiNhanDienNuoc_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
        btn_GhiNhanDienNuoc_Huy.setText("Hủy");
        btn_GhiNhanDienNuoc_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GhiNhanDienNuoc_HuyActionPerformed(evt);
            }
        });

        tb_GhiNhanDienNuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tb_GhiNhanDienNuoc);

        javax.swing.GroupLayout pn_GhiNhanDienNuocLayout = new javax.swing.GroupLayout(pn_GhiNhanDienNuoc);
        pn_GhiNhanDienNuoc.setLayout(pn_GhiNhanDienNuocLayout);
        pn_GhiNhanDienNuocLayout.setHorizontalGroup(
            pn_GhiNhanDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1305, Short.MAX_VALUE)
            .addComponent(lb_GhiNhanDienNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_GhiNhanDienNuocLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_GhiNhanDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_GhiNhanDienNuocLayout.createSequentialGroup()
                        .addComponent(btn_GhiNhanDienNuoc_XacNhan)
                        .addGap(18, 18, 18)
                        .addComponent(btn_GhiNhanDienNuoc_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_GhiNhanDienNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(304, 304, 304))
        );

        pn_GhiNhanDienNuocLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_GhiNhanDienNuoc_Huy, btn_GhiNhanDienNuoc_XacNhan});

        pn_GhiNhanDienNuocLayout.setVerticalGroup(
            pn_GhiNhanDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_GhiNhanDienNuocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_GhiNhanDienNuoc)
                .addGap(33, 33, 33)
                .addComponent(pn_GhiNhanDienNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pn_GhiNhanDienNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_GhiNhanDienNuoc_XacNhan)
                    .addComponent(btn_GhiNhanDienNuoc_Huy))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_GhiNhanDienNuocLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_GhiNhanDienNuoc_Huy, btn_GhiNhanDienNuoc_XacNhan});

        scrollPanelGhiNhanDN.setViewportView(pn_GhiNhanDienNuoc);

        jTabbedPane1.addTab("Ghi Nhận Điện Nước", new javax.swing.ImageIcon(getClass().getResource("/Images/light-bulb.png")), scrollPanelGhiNhanDN); // NOI18N

        pn_GhiNhanKyLuat.setBackground(new java.awt.Color(255, 255, 255));

        lb_GhiNhanKyLuat.setBackground(new java.awt.Color(0, 153, 255));
        lb_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_GhiNhanKyLuat.setForeground(new java.awt.Color(255, 255, 255));
        lb_GhiNhanKyLuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_GhiNhanKyLuat.setText("KỶ LUẬT SINH VIÊN");
        lb_GhiNhanKyLuat.setOpaque(true);

        pn_GhiNhanKyLuat_TimKiem.setBackground(new java.awt.Color(255, 255, 255));
        pn_GhiNhanKyLuat_TimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm Kiếm"));

        lb_MaKTX_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_MaKTX_GhiNhanKyLuat.setText("Mã KTX:");

        tf_MaKTX_GhiNhanKyLuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_MaKTX_GhiNhanKyLuatActionPerformed(evt);
            }
        });

        lb_HoTen_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_HoTen_GhiNhanKyLuat.setText("Họ Tên:");

        lb_MSSV_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_MSSV_GhiNhanKyLuat.setText("MSSV:");

        lb_Truong_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_Truong_GhiNhanKyLuat.setText("Trường:");

        lb_Phong_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_Phong_GhiNhanKyLuat.setText("Phòng:");

        lb_Nha_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_Nha_GhiNhanKyLuat.setText("Nhà:");

        javax.swing.GroupLayout pn_GhiNhanKyLuat_TimKiemLayout = new javax.swing.GroupLayout(pn_GhiNhanKyLuat_TimKiem);
        pn_GhiNhanKyLuat_TimKiem.setLayout(pn_GhiNhanKyLuat_TimKiemLayout);
        pn_GhiNhanKyLuat_TimKiemLayout.setHorizontalGroup(
            pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_MaKTX_GhiNhanKyLuat)
                    .addComponent(lb_HoTen_GhiNhanKyLuat)
                    .addComponent(lb_MSSV_GhiNhanKyLuat)
                    .addComponent(lb_Truong_GhiNhanKyLuat)
                    .addComponent(lb_Phong_GhiNhanKyLuat)
                    .addComponent(lb_Nha_GhiNhanKyLuat))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_MaKTX_GhiNhanKyLuat, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(lb_HoTen_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_MSSV_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Truong_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Phong_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Nha_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_GhiNhanKyLuat_TimKiemLayout.setVerticalGroup(
            pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MaKTX_GhiNhanKyLuat)
                    .addComponent(tf_MaKTX_GhiNhanKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_HoTen_GhiNhanKyLuat)
                    .addComponent(lb_HoTen_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_MSSV_GhiNhanKyLuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_MSSV_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_Truong_GhiNhanKyLuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Truong_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_Phong_GhiNhanKyLuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_Phong_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanKyLuat_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_Nha_GhiNhanKyLuat_ChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Nha_GhiNhanKyLuat))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pn_GhiNhanKyLuat_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
        pn_GhiNhanKyLuat_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin"));

        lb_MucKyLuat_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_MucKyLuat_GhiNhanKyLuat.setText("Mức Kỷ Luật:");

        cb_MucKyLuat_GhiNhanKyLuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cảnh cáo", " " }));

        lb_GhiChu_GhiNhanKyLuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_GhiChu_GhiNhanKyLuat.setText("Ghi Chú:");

        ta_GhiChu_GhiNhanKyLuat.setColumns(20);
        ta_GhiChu_GhiNhanKyLuat.setRows(5);
        jScrollPane4.setViewportView(ta_GhiChu_GhiNhanKyLuat);

        btn_XacNhan_GhiNhanKyLuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        btn_XacNhan_GhiNhanKyLuat.setText("Xác Nhận");
        btn_XacNhan_GhiNhanKyLuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XacNhan_GhiNhanKyLuatActionPerformed(evt);
            }
        });

        btn_Huy_GhiNhanKyLuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
        btn_Huy_GhiNhanKyLuat.setText("Hủy");
        btn_Huy_GhiNhanKyLuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Huy_GhiNhanKyLuatActionPerformed(evt);
            }
        });

        btn_KyLuatSinhVien_QuanLyMucKyLuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/auction.png"))); // NOI18N
        btn_KyLuatSinhVien_QuanLyMucKyLuat.setText("Quản Lý Mức Kỷ Luật");
        btn_KyLuatSinhVien_QuanLyMucKyLuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KyLuatSinhVien_QuanLyMucKyLuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_GhiNhanKyLuat_ThongTinLayout = new javax.swing.GroupLayout(pn_GhiNhanKyLuat_ThongTin);
        pn_GhiNhanKyLuat_ThongTin.setLayout(pn_GhiNhanKyLuat_ThongTinLayout);
        pn_GhiNhanKyLuat_ThongTinLayout.setHorizontalGroup(
            pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_GhiNhanKyLuat_ThongTinLayout.createSequentialGroup()
                .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_MucKyLuat_GhiNhanKyLuat)
                            .addComponent(lb_GhiChu_GhiNhanKyLuat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createSequentialGroup()
                                .addComponent(cb_MucKyLuat_GhiNhanKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addComponent(btn_KyLuatSinhVien_QuanLyMucKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_XacNhan_GhiNhanKyLuat)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Huy_GhiNhanKyLuat)))
                .addGap(25, 25, 25))
        );

        pn_GhiNhanKyLuat_ThongTinLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Huy_GhiNhanKyLuat, btn_XacNhan_GhiNhanKyLuat});

        pn_GhiNhanKyLuat_ThongTinLayout.setVerticalGroup(
            pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MucKyLuat_GhiNhanKyLuat)
                    .addComponent(cb_MucKyLuat_GhiNhanKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_KyLuatSinhVien_QuanLyMucKyLuat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createSequentialGroup()
                        .addComponent(lb_GhiChu_GhiNhanKyLuat)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_GhiNhanKyLuat_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XacNhan_GhiNhanKyLuat)
                    .addComponent(btn_Huy_GhiNhanKyLuat)))
        );

        pn_GhiNhanKyLuat_ThongTinLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Huy_GhiNhanKyLuat, btn_XacNhan_GhiNhanKyLuat});

        tb_GhiNhanKyLuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_GhiNhanKyLuat.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tb_GhiNhanKyLuat);

        javax.swing.GroupLayout pn_GhiNhanKyLuatLayout = new javax.swing.GroupLayout(pn_GhiNhanKyLuat);
        pn_GhiNhanKyLuat.setLayout(pn_GhiNhanKyLuatLayout);
        pn_GhiNhanKyLuatLayout.setHorizontalGroup(
            pn_GhiNhanKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_GhiNhanKyLuatLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(pn_GhiNhanKyLuat_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pn_GhiNhanKyLuat_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addComponent(lb_GhiNhanKyLuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_GhiNhanKyLuatLayout.setVerticalGroup(
            pn_GhiNhanKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_GhiNhanKyLuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_GhiNhanKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pn_GhiNhanKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_GhiNhanKyLuat_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_GhiNhanKyLuat_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scrollPanelGhiNhanKyLuat.setViewportView(pn_GhiNhanKyLuat);

        jTabbedPane1.addTab("Ghi Nhận Kỷ Luật", new javax.swing.ImageIcon(getClass().getResource("/Images/auction.png")), scrollPanelGhiNhanKyLuat); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GhiNhanDienNuoc_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GhiNhanDienNuoc_XacNhanActionPerformed
        // TODO add your handling code here:

        if (tf_GhiNhanDienNuoc_ChiSoDienCuoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống chỉ số điện");
            return;
        }
        if (tf_GhiNhanDienNuoc_ChiSoNuocCuoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống chỉ số nước");
            return;
        }

        Calendar cal = Calendar.getInstance();
        int thang = cal.get(Calendar.MONTH) + 1;
        int nam = cal.get(Calendar.YEAR);

        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlToday = new Date(today.getTime());

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        float SoKWDien;
        float SoKhoiNuoc;
        int MaNha = nhaBLL.LayMaNha(cb_GhiNhanDienNuoc_Nha.getSelectedItem().toString().trim());
        int MaPhong = phongBLL.LayMaPhong(Integer.parseInt(cb_GhiNhanDienNuoc_Phong.getSelectedItem().toString().trim()), cb_GhiNhanDienNuoc_Nha.getSelectedItem().toString().trim());
        float ChiSoDienCuoi = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoDienCuoi.getText().trim());
        float ChiSoNuocCuoi = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoNuocCuoi.getText().trim());

        GhiNhanDienNuocBLL ghiNhanDienNuocBLL = new GhiNhanDienNuocBLL();
        BackupGhiNhanDienNuocBLL backupGhiNhanDienNuocBLL = new BackupGhiNhanDienNuocBLL();
        GhiNhanDienNuocEntity ghiNhanDienNuocEntity;

        ThuPhiDienNuocBLL thuPhiDienNuocBLL = new ThuPhiDienNuocBLL();
        BackupThuPhiDienNuocBLL backupThuPhiDienNuocBLL = new BackupThuPhiDienNuocBLL();
        if (thang == 1) {
            ghiNhanDienNuocEntity = ghiNhanDienNuocBLL.LayGhiNhanDienNuoc(12, nam - 1, MaNha, MaPhong);
            if (ghiNhanDienNuocEntity.getSoKWDien() == 0 && ghiNhanDienNuocEntity.getSoKhoiNuoc() == 0) {
                SoKWDien = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoDienCuoi.getText().trim());
                SoKhoiNuoc = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoNuocCuoi.getText().trim());
            } else {
                SoKWDien = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoDienCuoi.getText().trim()) - ghiNhanDienNuocEntity.getSoKWDien();
                SoKhoiNuoc = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoNuocCuoi.getText().trim()) - ghiNhanDienNuocEntity.getSoKhoiNuoc();
            }

        } else {
            ghiNhanDienNuocEntity = ghiNhanDienNuocBLL.LayGhiNhanDienNuoc(thang - 1, nam, MaNha, MaPhong);
            if (ghiNhanDienNuocEntity.getSoKWDien() == 0 && ghiNhanDienNuocEntity.getSoKhoiNuoc() == 0) {
                SoKWDien = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoDienCuoi.getText().trim());
                SoKhoiNuoc = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoNuocCuoi.getText().trim());
            } else {

                SoKWDien = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoDienCuoi.getText().trim()) - ghiNhanDienNuocEntity.getSoKWDien();
                SoKhoiNuoc = Float.parseFloat(tf_GhiNhanDienNuoc_ChiSoNuocCuoi.getText().trim()) - ghiNhanDienNuocEntity.getSoKhoiNuoc();
            }
        }
        if (ghiNhanDienNuocBLL.KiemTraGhiNhanDienNuoc(MaNha, MaPhong, thang, nam)) {
            JOptionPane.showMessageDialog(this, "Không thể lưu. Phòng này đã được ghi điện nước");
            return;
        }

        if (SoKWDien < 0) {
            JOptionPane.showMessageDialog(this, "Chỉ số điện không được thấp hơn chỉ số điện của tháng trước.");
            return;
        }
        if (SoKhoiNuoc < 0) {
            JOptionPane.showMessageDialog(this, "Chỉ số nước không được thấp hơn chỉ số nước của tháng trước");
            return;
        }
        ghiNhanDienNuocBLL.Insert(MaNha, MaPhong, thang, nam, sqlToday, SoKWDien, SoKhoiNuoc, ChiSoDienCuoi, ChiSoNuocCuoi);
        backupGhiNhanDienNuocBLL.Insert(MaNha, MaPhong, thang, nam, sqlToday, SoKWDien, SoKhoiNuoc, ChiSoDienCuoi, ChiSoNuocCuoi);

        thuPhiDienNuocBLL.Insert(MaNha, MaPhong, thang, nam);
        backupThuPhiDienNuocBLL.Insert(MaNha, MaPhong, thang, nam);

        thuPhiDienNuocBLL.Update(MaNha, MaPhong, thang, nam, SoKWDien, SoKhoiNuoc);
        backupThuPhiDienNuocBLL.Update(MaNha, MaPhong, thang, nam, SoKWDien, SoKhoiNuoc);

        showTable_GhiNhanDienNuoc(cb_GhiNhanDienNuoc_Nha.getSelectedItem().toString().trim(), cb_GhiNhanDienNuoc_Phong.getSelectedItem().toString().trim());
    }//GEN-LAST:event_btn_GhiNhanDienNuoc_XacNhanActionPerformed

    private void cb_GhiNhanDienNuoc_NhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GhiNhanDienNuoc_NhaActionPerformed
        // TODO add your handling code here:
        cb_GhiNhanDienNuoc_Phong.removeAllItems();
        Calendar cal = Calendar.getInstance();
        int thang = cal.get(Calendar.MONTH) + 1;
        int nam = cal.get(Calendar.YEAR);

        String tenNha = cb_GhiNhanDienNuoc_Nha.getSelectedItem().toString().trim();
        showComboBoxPhong_GhiNhanDienNuoc(tenNha);
        lb_GhiNhanDienNuoc_ThangNam_ChiTiet.setText(thang + " / " + nam);
    }//GEN-LAST:event_cb_GhiNhanDienNuoc_NhaActionPerformed

    private void cb_GhiNhanDienNuoc_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GhiNhanDienNuoc_PhongActionPerformed
        // TODO add your handling code here:
        if (cb_GhiNhanDienNuoc_Phong.getSelectedItem() == null) {
            return;
        }
        String tenNha = cb_GhiNhanDienNuoc_Nha.getSelectedItem().toString().trim();
        String tenPhong = cb_GhiNhanDienNuoc_Phong.getSelectedItem().toString().trim();

        showTable_GhiNhanDienNuoc(tenNha, tenPhong);
    }//GEN-LAST:event_cb_GhiNhanDienNuoc_PhongActionPerformed

    private void btn_GhiNhanDienNuoc_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GhiNhanDienNuoc_HuyActionPerformed
        // TODO add your handling code here:
        tf_GhiNhanDienNuoc_ChiSoDienCuoi.setText("");
        tf_GhiNhanDienNuoc_ChiSoNuocCuoi.setText("");
    }//GEN-LAST:event_btn_GhiNhanDienNuoc_HuyActionPerformed

    private void tf_TraCuuSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TraCuuSinhVienActionPerformed
        // TODO add your handling code here:

        String clue = tf_TraCuuSinhVien.getText().trim();
        if (!"".equals(tf_TraCuuSinhVien.getText().trim())) {
            ShowTable_TraCuuSinhVien(clue);
        }
    }//GEN-LAST:event_tf_TraCuuSinhVienActionPerformed

    private void btn_TraCuuSinhVien_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TraCuuSinhVien_SearchActionPerformed
        // TODO add your handling code here:

        String clue = tf_TraCuuSinhVien.getText().trim();
        if (!"".equals(tf_TraCuuSinhVien.getText().trim())) {
            ShowTable_TraCuuSinhVien(clue);
        }
    }//GEN-LAST:event_btn_TraCuuSinhVien_SearchActionPerformed

    private void cb_TraCuuPhong_NhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuuPhong_NhaActionPerformed
        // TODO add your handling code here:
        Object obj = cb_TraCuuPhong_Nha.getSelectedItem();

        if (obj == null) {
            System.out.println(cb_TraCuuPhong_Nha.getName() + " Error!:");
        } else {
            cb_TraCuuPhong_Phong.removeAllItems();
            showComboBoxPhong_TraCuuPhong((String) obj.toString());
        }
    }//GEN-LAST:event_cb_TraCuuPhong_NhaActionPerformed

    private void cb_TraCuuPhong_PhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuuPhong_PhongActionPerformed
        // TODO add your handling code here:

        if (cb_TraCuuPhong_Phong.getSelectedItem() == null || cb_TraCuuPhong_Nha.getSelectedItem() == null) {
            return;
        }

        String tenNha = cb_TraCuuPhong_Nha.getSelectedItem().toString().trim();
        String tenPhong = cb_TraCuuPhong_Phong.getSelectedItem().toString().trim();

        ShowTable_TraCuuPhong(tenNha, tenPhong);
    }//GEN-LAST:event_cb_TraCuuPhong_PhongActionPerformed

    private void btn_DoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoiMatKhauActionPerformed
        // TODO add your handling code here:
        DoiMatKhauFrame doiMatKhauFrame = new DoiMatKhauFrame();
        doiMatKhauFrame.setVisible(true);
        doiMatKhauFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_btn_DoiMatKhauActionPerformed

    private void btn_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangXuatActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất???", "Exit", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_DangXuatActionPerformed

    private void tf_MaKTX_GhiNhanKyLuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_MaKTX_GhiNhanKyLuatActionPerformed
        // TODO add your handling code here:
        SinhVienEntity sinhVienEntity = new SinhVienEntity();
        TruongEntity truongEntity = new TruongEntity();

        NhaBLL nhaBLL = new NhaBLL();
        PhongBLL phongBLL = new PhongBLL();
        TruongBLL truongBLL = new TruongBLL();
        SinhVienBLL sinhVienBLL = new SinhVienBLL();

        sinhVienEntity = sinhVienBLL.Search_SV_MaKTX(tf_MaKTX_GhiNhanKyLuat.getText().trim());

        if (sinhVienEntity.getHoSinhVien() == null) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Sinh Viên");
            return;
        }

        truongEntity.setTenTruong(truongBLL.LayTenTruong(sinhVienEntity.getMaTruong()));

        lb_HoTen_GhiNhanKyLuat_ChiTiet.setText(sinhVienEntity.getHoSinhVien() + " " + sinhVienEntity.getTenSinhVien());
        lb_MSSV_GhiNhanKyLuat_ChiTiet.setText(sinhVienEntity.getMSSV());
        lb_Truong_GhiNhanKyLuat_ChiTiet.setText(truongEntity.getTenTruong());

        if (nhaBLL.LayTenNha(tf_MaKTX_GhiNhanKyLuat.getText().trim()) != null) {
            lb_Nha_GhiNhanKyLuat_ChiTiet.setText(nhaBLL.LayTenNha(tf_MaKTX_GhiNhanKyLuat.getText().trim()));
        }

        if (phongBLL.LayTenPhong(tf_MaKTX_GhiNhanKyLuat.getText()) != null) {
            lb_Phong_GhiNhanKyLuat_ChiTiet.setText(phongBLL.LayTenPhong(tf_MaKTX_GhiNhanKyLuat.getText().trim()));
        }

    }//GEN-LAST:event_tf_MaKTX_GhiNhanKyLuatActionPerformed

    private void btn_XacNhan_GhiNhanKyLuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XacNhan_GhiNhanKyLuatActionPerformed
        // TODO add your handling code here:
        if (lb_HoTen_GhiNhanKyLuat_ChiTiet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã KTX của sinh viên bị kỷ luật.");
            return;
        }
        GhiNhanKyLuatBLL ghiNhanKyLuatBLL = new GhiNhanKyLuatBLL();

        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlToday = new Date(today.getTime());
        String mucKyLuat = cb_MucKyLuat_GhiNhanKyLuat.getSelectedItem().toString().trim();
        String ghiChu = ta_GhiChu_GhiNhanKyLuat.getText().trim();

        ghiNhanKyLuatBLL.Insert(tf_MaKTX_GhiNhanKyLuat.getText(), sqlToday, mucKyLuat, ghiChu);
        JOptionPane.showMessageDialog(this, "Ghi Nhận thành công");
        ShowTable_GhiNhanKyLuat();

    }//GEN-LAST:event_btn_XacNhan_GhiNhanKyLuatActionPerformed

    private void btn_Huy_GhiNhanKyLuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Huy_GhiNhanKyLuatActionPerformed
        // TODO add your handling code here:
        tf_MaKTX_GhiNhanKyLuat.setText("");
        lb_HoTen_GhiNhanKyLuat_ChiTiet.setText("");
        lb_MSSV_GhiNhanKyLuat_ChiTiet.setText("");
        lb_Nha_GhiNhanKyLuat_ChiTiet.setText("");
        lb_Phong_GhiNhanKyLuat_ChiTiet.setText("");
        lb_Truong_GhiNhanKyLuat_ChiTiet.setText("");
        ta_GhiChu_GhiNhanKyLuat.setText("");
    }//GEN-LAST:event_btn_Huy_GhiNhanKyLuatActionPerformed

    private void cb_TraCuuDienNuoc_NhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TraCuuDienNuoc_NhaActionPerformed
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

    private void btn_KyLuatSinhVien_QuanLyMucKyLuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KyLuatSinhVien_QuanLyMucKyLuatActionPerformed
        // TODO add your handling code here:
        QuyDinhMucKyLuatFrame quyDinhMucKyLuatFrame = new QuyDinhMucKyLuatFrame();
        quyDinhMucKyLuatFrame.setVisible(true);
        quyDinhMucKyLuatFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_KyLuatSinhVien_QuanLyMucKyLuatActionPerformed

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
            java.util.logging.Logger.getLogger(TruongNhaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TruongNhaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TruongNhaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TruongNhaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TruongNhaFrame truongNhaFrame = new TruongNhaFrame();
                truongNhaFrame.setVisible(true);
                truongNhaFrame.setExtendedState(truongNhaFrame.MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangXuat;
    private javax.swing.JButton btn_DoiMatKhau;
    private javax.swing.JButton btn_GhiNhanDienNuoc_Huy;
    private javax.swing.JButton btn_GhiNhanDienNuoc_XacNhan;
    private javax.swing.JButton btn_Huy_GhiNhanKyLuat;
    private javax.swing.JButton btn_KyLuatSinhVien_QuanLyMucKyLuat;
    private javax.swing.JButton btn_TraCuuSinhVien_Search;
    private javax.swing.JButton btn_XacNhan_GhiNhanKyLuat;
    private javax.swing.JComboBox<String> cb_GhiNhanDienNuoc_Nha;
    private javax.swing.JComboBox<String> cb_GhiNhanDienNuoc_Phong;
    private javax.swing.JComboBox<String> cb_MucKyLuat_GhiNhanKyLuat;
    private javax.swing.JComboBox<String> cb_TraCuuDienNuoc_Nha;
    private javax.swing.JComboBox<String> cb_TraCuuDienNuoc_Phong;
    private javax.swing.JComboBox<String> cb_TraCuuPhong_Nha;
    private javax.swing.JComboBox<String> cb_TraCuuPhong_Phong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lb_GhiChu_GhiNhanKyLuat;
    private javax.swing.JLabel lb_GhiNhanDienNuoc;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_ChiSoDienCuoi;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_ChiSoNuocCuoi;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_KWH;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_Khoi;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_Nha;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_Phong;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_ThangNam;
    private javax.swing.JLabel lb_GhiNhanDienNuoc_ThangNam_ChiTiet;
    private javax.swing.JLabel lb_GhiNhanKyLuat;
    private javax.swing.JLabel lb_HoTen_GhiNhanKyLuat;
    private javax.swing.JLabel lb_HoTen_GhiNhanKyLuat_ChiTiet;
    private javax.swing.JLabel lb_MSSV_GhiNhanKyLuat;
    private javax.swing.JLabel lb_MSSV_GhiNhanKyLuat_ChiTiet;
    private javax.swing.JLabel lb_MaKTX_GhiNhanKyLuat;
    private javax.swing.JLabel lb_MucKyLuat_GhiNhanKyLuat;
    private javax.swing.JLabel lb_Nha_GhiNhanKyLuat;
    private javax.swing.JLabel lb_Nha_GhiNhanKyLuat_ChiTiet;
    private javax.swing.JLabel lb_Phong_GhiNhanKyLuat;
    private javax.swing.JLabel lb_Phong_GhiNhanKyLuat_ChiTiet;
    private javax.swing.JLabel lb_QuanLyTaiKhoan;
    private javax.swing.JLabel lb_TraCuuDienNuoc;
    private javax.swing.JLabel lb_TraCuuDienNuoc_Nha;
    private javax.swing.JLabel lb_TraCuuDienNuoc_Phong;
    private javax.swing.JLabel lb_TraCuuPhong;
    private javax.swing.JLabel lb_TraCuuPhong_Nha;
    private javax.swing.JLabel lb_TraCuuPhong_Phong;
    private javax.swing.JLabel lb_TraCuuSinhVien;
    private javax.swing.JLabel lb_Truong_GhiNhanKyLuat;
    private javax.swing.JLabel lb_Truong_GhiNhanKyLuat_ChiTiet;
    private javax.swing.JPanel pn_GhiNhanDienNuoc;
    private javax.swing.JPanel pn_GhiNhanDienNuoc_ThongTin;
    private javax.swing.JPanel pn_GhiNhanKyLuat;
    private javax.swing.JPanel pn_GhiNhanKyLuat_ThongTin;
    private javax.swing.JPanel pn_GhiNhanKyLuat_TimKiem;
    private javax.swing.JPanel pn_TaiKhoan;
    private javax.swing.JPanel pn_TaiKhoan_ChiTiet;
    private javax.swing.JPanel pn_TraCuu;
    private javax.swing.JPanel pn_TraCuuDienNuoc;
    private javax.swing.JPanel pn_TraCuuDienNuoc_ThongTin;
    private javax.swing.JPanel pn_TraCuuPhong;
    private javax.swing.JPanel pn_TraCuuSinhVien;
    private javax.swing.JScrollPane scrollPanelGhiNhanDN;
    private javax.swing.JScrollPane scrollPanelGhiNhanKyLuat;
    private javax.swing.JScrollPane scrollPanelTaiKhoan;
    private javax.swing.JScrollPane scrollPanelTraCuu;
    private javax.swing.JTextArea ta_GhiChu_GhiNhanKyLuat;
    private javax.swing.JTable tb_GhiNhanDienNuoc;
    private javax.swing.JTable tb_GhiNhanKyLuat;
    private javax.swing.JTable tb_TraCuuDienNuoc;
    private javax.swing.JTable tb_TraCuuPhong;
    private javax.swing.JTable tb_TraCuuSinhVien;
    private javax.swing.JTextField tf_GhiNhanDienNuoc_ChiSoDienCuoi;
    private javax.swing.JTextField tf_GhiNhanDienNuoc_ChiSoNuocCuoi;
    private javax.swing.JTextField tf_MaKTX_GhiNhanKyLuat;
    private javax.swing.JTextField tf_TraCuuSinhVien;
    // End of variables declaration//GEN-END:variables
}
