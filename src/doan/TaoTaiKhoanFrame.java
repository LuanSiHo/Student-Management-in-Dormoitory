/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import BLL.NhaBLL;
import BLL.UserBLL;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class TaoTaiKhoanFrame extends javax.swing.JFrame {

    /**
     * Creates new form TaoTaiKhoanFrame
     */
    public TaoTaiKhoanFrame() {
        initComponents();
        showComboBoxChucVu();
    }

    public void showComboBoxChucVu() {
        UserBLL userBLL = new UserBLL();
        ArrayList<String> danhSachChucVu = userBLL.LayChucVu();
        for (int i = 0; i < danhSachChucVu.size(); i++) {
            cb_ChucVu.addItem(danhSachChucVu.get(i));
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

    pn_TaoTaiKhoan = new javax.swing.JPanel();
    lb_TaoTaiKhoan = new javax.swing.JLabel();
    lb_TenDangNhap = new javax.swing.JLabel();
    tf_TenDangNhap = new javax.swing.JTextField();
    lb_MatKhau = new javax.swing.JLabel();
    pf_MatKhau = new javax.swing.JPasswordField();
    lb_XacNhanMatKhau = new javax.swing.JLabel();
    pf_XacNhanMatKhau = new javax.swing.JPasswordField();
    lb_ChucVu = new javax.swing.JLabel();
    cb_ChucVu = new javax.swing.JComboBox<>();
    btn_XacNhan = new javax.swing.JButton();
    btn_Huy = new javax.swing.JButton();
    lb_tenNV = new javax.swing.JLabel();
    tf_tenNV = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setBackground(new java.awt.Color(255, 255, 255));
    setResizable(false);

    pn_TaoTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));

    lb_TaoTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    lb_TaoTaiKhoan.setText("TẠO TÀI KHOẢN");

    lb_TenDangNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_TenDangNhap.setText("Tên Đăng Nhập:");

    lb_MatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_MatKhau.setText("Mật Khẩu:");

    lb_XacNhanMatKhau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_XacNhanMatKhau.setText("Xác Nhận Mật Khẩu:");

    lb_ChucVu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_ChucVu.setText("Chức vụ:");

    btn_XacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
    btn_XacNhan.setText("Xác Nhận");
    btn_XacNhan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_XacNhanActionPerformed(evt);
      }
    });

    btn_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
    btn_Huy.setText("Hủy");
    btn_Huy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_HuyActionPerformed(evt);
      }
    });

    lb_tenNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_tenNV.setText("Họ tên nhân viên:");

    javax.swing.GroupLayout pn_TaoTaiKhoanLayout = new javax.swing.GroupLayout(pn_TaoTaiKhoan);
    pn_TaoTaiKhoan.setLayout(pn_TaoTaiKhoanLayout);
    pn_TaoTaiKhoanLayout.setHorizontalGroup(
      pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_TaoTaiKhoanLayout.createSequentialGroup()
        .addContainerGap(133, Short.MAX_VALUE)
        .addComponent(lb_TaoTaiKhoan)
        .addGap(128, 128, 128))
      .addGroup(pn_TaoTaiKhoanLayout.createSequentialGroup()
        .addGap(80, 80, 80)
        .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pn_TaoTaiKhoanLayout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addComponent(btn_XacNhan)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btn_Huy))
          .addGroup(pn_TaoTaiKhoanLayout.createSequentialGroup()
            .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lb_MatKhau)
              .addComponent(lb_TenDangNhap)
              .addComponent(lb_XacNhanMatKhau)
              .addComponent(lb_ChucVu)
              .addComponent(lb_tenNV))
            .addGap(18, 18, 18)
            .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tf_TenDangNhap)
              .addComponent(cb_ChucVu, 0, 130, Short.MAX_VALUE)
              .addComponent(pf_MatKhau)
              .addComponent(pf_XacNhanMatKhau)
              .addComponent(tf_tenNV))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pn_TaoTaiKhoanLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Huy, btn_XacNhan});

    pn_TaoTaiKhoanLayout.setVerticalGroup(
      pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pn_TaoTaiKhoanLayout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(lb_TaoTaiKhoan)
        .addGap(31, 31, 31)
        .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(pn_TaoTaiKhoanLayout.createSequentialGroup()
            .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(lb_TenDangNhap)
              .addComponent(tf_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(lb_MatKhau))
          .addComponent(pf_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(lb_XacNhanMatKhau)
          .addComponent(pf_XacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lb_ChucVu)
          .addComponent(cb_ChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lb_tenNV)
          .addComponent(tf_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        .addGroup(pn_TaoTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btn_XacNhan)
          .addComponent(btn_Huy))
        .addGap(43, 43, 43))
    );

    pn_TaoTaiKhoanLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Huy, btn_XacNhan});

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pn_TaoTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pn_TaoTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btn_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XacNhanActionPerformed
        // TODO add your handling code here:

        UserBLL userBLL = new UserBLL();
        String tenDangNhap = tf_TenDangNhap.getText().trim();
        String matKhau = String.valueOf(pf_MatKhau.getPassword());
        String userType = cb_ChucVu.getSelectedItem().toString().trim();
        String fullName = tf_tenNV.getText().toString().trim();

        if (tf_TenDangNhap.getText().isEmpty() || String.valueOf(pf_MatKhau.getPassword()).isEmpty() || String.valueOf(pf_XacNhanMatKhau.getPassword()).isEmpty() || cb_ChucVu.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin.");
            return;
        }

        if (!String.valueOf(pf_MatKhau.getPassword()).equals(String.valueOf(pf_XacNhanMatKhau.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Mật khẩu  vừa nhập không trùng khớp với mật khẩu xác nhận.");
            return;
        }
        
        if(userBLL.SearchUser(tenDangNhap))
        {
            JOptionPane.showMessageDialog(this, "Không thể thêm. Tên đăng nhập đã tồn tại");
            return;
        }

        userBLL.Insert(tenDangNhap, matKhau, userType, fullName);
        JOptionPane.showMessageDialog(this, "Tạo tài khoản thành công.");

    }//GEN-LAST:event_btn_XacNhanActionPerformed

    private void btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyActionPerformed
        // TODO add your handling code here:
        tf_TenDangNhap.setText("");
        pf_MatKhau.setText("");
        pf_XacNhanMatKhau.setText("");
        tf_tenNV.setText("");
    }//GEN-LAST:event_btn_HuyActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaoTaiKhoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaoTaiKhoanFrame().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btn_Huy;
  private javax.swing.JButton btn_XacNhan;
  private javax.swing.JComboBox<String> cb_ChucVu;
  private javax.swing.JLabel lb_ChucVu;
  private javax.swing.JLabel lb_MatKhau;
  private javax.swing.JLabel lb_TaoTaiKhoan;
  private javax.swing.JLabel lb_TenDangNhap;
  private javax.swing.JLabel lb_XacNhanMatKhau;
  private javax.swing.JLabel lb_tenNV;
  private javax.swing.JPasswordField pf_MatKhau;
  private javax.swing.JPasswordField pf_XacNhanMatKhau;
  private javax.swing.JPanel pn_TaoTaiKhoan;
  private javax.swing.JTextField tf_TenDangNhap;
  private javax.swing.JTextField tf_tenNV;
  // End of variables declaration//GEN-END:variables
}
