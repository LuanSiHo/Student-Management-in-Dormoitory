/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import BLL.MucGiaDienBLL;
import BLL.MucGiaNuocBLL;
import Entities.MucGiaDienEntity;
import Entities.MucGiaNuocEntity;
import java.sql.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class QuyDinhGiaNuocFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuyDinhGiaNuoc
     */
    public QuyDinhGiaNuocFrame() {
        initComponents();
        ShowTable();
    }

    public void ShowTable() {
        Vector cols = new Vector();
        Vector data = new Vector();
        MucGiaNuocBLL mucGiaNuocBLL = new MucGiaNuocBLL();
        mucGiaNuocBLL.ShowTable(cols, data);
        tb_QuyDinhGiaNuoc.setModel(new AbstractTableModel() {
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pn_QuyDinhGiaNuoc = new javax.swing.JPanel();
    lb_QuyDinhGiaNuoc_GiaNuoc = new javax.swing.JLabel();
    btn_QuyDinhGiaNuoc_huy = new javax.swing.JButton();
    btn_QuyDinhGiaNuoc_Luu = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tb_QuyDinhGiaNuoc = new javax.swing.JTable();
    pn_QuyDinhGiaNuoc_ThongTin = new javax.swing.JPanel();
    lb_QuyDinhGiaNuoc_TuKhoi = new javax.swing.JLabel();
    tf_QuyDinhGiaNuoc_TuKhoi = new javax.swing.JTextField();
    lb_QuyDinhGiaNuoc_DenKhoi = new javax.swing.JLabel();
    tf_QuyDinhGiaNuoc_DenKhoi = new javax.swing.JTextField();
    lb_QuyDinhGiaNuoc_Gia = new javax.swing.JLabel();
    tf_QuyDinhGiaNuoc_Gia = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);

    pn_QuyDinhGiaNuoc.setBackground(new java.awt.Color(255, 255, 255));

    lb_QuyDinhGiaNuoc_GiaNuoc.setBackground(new java.awt.Color(255, 255, 255));
    lb_QuyDinhGiaNuoc_GiaNuoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    lb_QuyDinhGiaNuoc_GiaNuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lb_QuyDinhGiaNuoc_GiaNuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drop.png"))); // NOI18N
    lb_QuyDinhGiaNuoc_GiaNuoc.setText("GIÁ NƯỚC");

    btn_QuyDinhGiaNuoc_huy.setBackground(new java.awt.Color(255, 255, 255));
    btn_QuyDinhGiaNuoc_huy.setForeground(new java.awt.Color(255, 255, 255));
    btn_QuyDinhGiaNuoc_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unchecked.png"))); // NOI18N
    btn_QuyDinhGiaNuoc_huy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_QuyDinhGiaNuoc_huyActionPerformed(evt);
      }
    });

    btn_QuyDinhGiaNuoc_Luu.setBackground(new java.awt.Color(255, 255, 255));
    btn_QuyDinhGiaNuoc_Luu.setForeground(new java.awt.Color(255, 255, 255));
    btn_QuyDinhGiaNuoc_Luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
    btn_QuyDinhGiaNuoc_Luu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btn_QuyDinhGiaNuoc_LuuActionPerformed(evt);
      }
    });

    tb_QuyDinhGiaNuoc.setModel(new javax.swing.table.DefaultTableModel(
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
    tb_QuyDinhGiaNuoc.setGridColor(new java.awt.Color(0, 0, 0));
    tb_QuyDinhGiaNuoc.getTableHeader().setReorderingAllowed(false);
    tb_QuyDinhGiaNuoc.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tb_QuyDinhGiaNuocMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tb_QuyDinhGiaNuoc);

    pn_QuyDinhGiaNuoc_ThongTin.setBackground(new java.awt.Color(255, 255, 255));
    pn_QuyDinhGiaNuoc_ThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    lb_QuyDinhGiaNuoc_TuKhoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_QuyDinhGiaNuoc_TuKhoi.setText("Từ Khối:");

    lb_QuyDinhGiaNuoc_DenKhoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_QuyDinhGiaNuoc_DenKhoi.setText("Đến Khối:");

    lb_QuyDinhGiaNuoc_Gia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_QuyDinhGiaNuoc_Gia.setText("Giá:");

    javax.swing.GroupLayout pn_QuyDinhGiaNuoc_ThongTinLayout = new javax.swing.GroupLayout(pn_QuyDinhGiaNuoc_ThongTin);
    pn_QuyDinhGiaNuoc_ThongTin.setLayout(pn_QuyDinhGiaNuoc_ThongTinLayout);
    pn_QuyDinhGiaNuoc_ThongTinLayout.setHorizontalGroup(
      pn_QuyDinhGiaNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createSequentialGroup()
            .addComponent(lb_QuyDinhGiaNuoc_TuKhoi)
            .addGap(18, 18, 18)
            .addComponent(tf_QuyDinhGiaNuoc_TuKhoi))
          .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createSequentialGroup()
            .addComponent(lb_QuyDinhGiaNuoc_DenKhoi)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tf_QuyDinhGiaNuoc_DenKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
        .addComponent(lb_QuyDinhGiaNuoc_Gia)
        .addGap(18, 18, 18)
        .addComponent(tf_QuyDinhGiaNuoc_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(54, 54, 54))
    );
    pn_QuyDinhGiaNuoc_ThongTinLayout.setVerticalGroup(
      pn_QuyDinhGiaNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lb_QuyDinhGiaNuoc_TuKhoi)
          .addComponent(tf_QuyDinhGiaNuoc_TuKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(tf_QuyDinhGiaNuoc_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lb_QuyDinhGiaNuoc_Gia))
        .addGap(26, 26, 26)
        .addGroup(pn_QuyDinhGiaNuoc_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lb_QuyDinhGiaNuoc_DenKhoi)
          .addComponent(tf_QuyDinhGiaNuoc_DenKhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pn_QuyDinhGiaNuocLayout = new javax.swing.GroupLayout(pn_QuyDinhGiaNuoc);
    pn_QuyDinhGiaNuoc.setLayout(pn_QuyDinhGiaNuocLayout);
    pn_QuyDinhGiaNuocLayout.setHorizontalGroup(
      pn_QuyDinhGiaNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(lb_QuyDinhGiaNuoc_GiaNuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(pn_QuyDinhGiaNuocLayout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
      .addGroup(pn_QuyDinhGiaNuocLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(pn_QuyDinhGiaNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QuyDinhGiaNuocLayout.createSequentialGroup()
            .addComponent(btn_QuyDinhGiaNuoc_Luu)
            .addGap(18, 18, 18)
            .addComponent(btn_QuyDinhGiaNuoc_huy))
          .addComponent(pn_QuyDinhGiaNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pn_QuyDinhGiaNuocLayout.setVerticalGroup(
      pn_QuyDinhGiaNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pn_QuyDinhGiaNuocLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lb_QuyDinhGiaNuoc_GiaNuoc)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(pn_QuyDinhGiaNuoc_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pn_QuyDinhGiaNuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btn_QuyDinhGiaNuoc_huy, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(btn_QuyDinhGiaNuoc_Luu, javax.swing.GroupLayout.Alignment.TRAILING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pn_QuyDinhGiaNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pn_QuyDinhGiaNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btn_QuyDinhGiaNuoc_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuyDinhGiaNuoc_huyActionPerformed
        // TODO add your handling code here:
        tf_QuyDinhGiaNuoc_DenKhoi.setText("");
        tf_QuyDinhGiaNuoc_TuKhoi.setText("");
        tf_QuyDinhGiaNuoc_Gia.setText("");
    }//GEN-LAST:event_btn_QuyDinhGiaNuoc_huyActionPerformed

    private void btn_QuyDinhGiaNuoc_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuyDinhGiaNuoc_LuuActionPerformed
        // TODO add your handling code here:
        MucGiaNuocBLL mucGiaNuocBLL = new MucGiaNuocBLL();

        java.util.Date today = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlToday = new Date(today.getTime());

        if (tf_QuyDinhGiaNuoc_TuKhoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống từ khối");
            return;
        }

        if (tf_QuyDinhGiaNuoc_DenKhoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống đến khối");
            return;
        }

        if (tf_QuyDinhGiaNuoc_Gia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống giá nước");
            return;
        }

        if (!tb_QuyDinhGiaNuoc.isColumnSelected(0) && !tb_QuyDinhGiaNuoc.isColumnSelected(1) && !tb_QuyDinhGiaNuoc.isColumnSelected(2) && !tb_QuyDinhGiaNuoc.isColumnSelected(3)
                && !tb_QuyDinhGiaNuoc.isColumnSelected(4)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã giá nước ở bảng phía dưới sau đó nhập thông tin cập nhật vào khung ở trên.");
            return;
        }

        int index = tb_QuyDinhGiaNuoc.getSelectedRow();
        MucGiaNuocEntity mucGiaNuocEntity = new MucGiaNuocEntity();
        mucGiaNuocEntity.setMaGiaNuoc(Integer.parseInt(tb_QuyDinhGiaNuoc.getValueAt(index, 0).toString()));
        mucGiaNuocEntity.setNgayApDung(sqlToday);
        mucGiaNuocEntity.setTuKhoi(Float.parseFloat(tf_QuyDinhGiaNuoc_TuKhoi.getText().trim()));
        mucGiaNuocEntity.setDenKhoi(Float.parseFloat(tf_QuyDinhGiaNuoc_DenKhoi.getText().trim()));
        mucGiaNuocEntity.setGiaNuoc(tf_QuyDinhGiaNuoc_Gia.getText().trim());
        
        mucGiaNuocBLL.Update(mucGiaNuocEntity.getMaGiaNuoc(), mucGiaNuocEntity.getNgayApDung(), mucGiaNuocEntity.getTuKhoi(), mucGiaNuocEntity.getDenKhoi(), mucGiaNuocEntity.getGiaNuoc());
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        ShowTable();
    }//GEN-LAST:event_btn_QuyDinhGiaNuoc_LuuActionPerformed

    private void tb_QuyDinhGiaNuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_QuyDinhGiaNuocMouseClicked
        // TODO add your handling code here:
        int index = tb_QuyDinhGiaNuoc.getSelectedRow();
        tf_QuyDinhGiaNuoc_TuKhoi.setText(tb_QuyDinhGiaNuoc.getValueAt(index, 2).toString());
        tf_QuyDinhGiaNuoc_DenKhoi.setText(tb_QuyDinhGiaNuoc.getValueAt(index, 3).toString());
        tf_QuyDinhGiaNuoc_Gia.setText(tb_QuyDinhGiaNuoc.getValueAt(index, 4).toString());
    }//GEN-LAST:event_tb_QuyDinhGiaNuocMouseClicked

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
            java.util.logging.Logger.getLogger(QuyDinhGiaNuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuyDinhGiaNuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuyDinhGiaNuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuyDinhGiaNuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuyDinhGiaNuocFrame().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btn_QuyDinhGiaNuoc_Luu;
  private javax.swing.JButton btn_QuyDinhGiaNuoc_huy;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lb_QuyDinhGiaNuoc_DenKhoi;
  private javax.swing.JLabel lb_QuyDinhGiaNuoc_Gia;
  private javax.swing.JLabel lb_QuyDinhGiaNuoc_GiaNuoc;
  private javax.swing.JLabel lb_QuyDinhGiaNuoc_TuKhoi;
  private javax.swing.JPanel pn_QuyDinhGiaNuoc;
  private javax.swing.JPanel pn_QuyDinhGiaNuoc_ThongTin;
  private javax.swing.JTable tb_QuyDinhGiaNuoc;
  private javax.swing.JTextField tf_QuyDinhGiaNuoc_DenKhoi;
  private javax.swing.JTextField tf_QuyDinhGiaNuoc_Gia;
  private javax.swing.JTextField tf_QuyDinhGiaNuoc_TuKhoi;
  // End of variables declaration//GEN-END:variables
}
