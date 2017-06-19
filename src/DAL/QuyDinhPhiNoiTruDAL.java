/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.QuyDinhPhiNoiTruEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class QuyDinhPhiNoiTruDAL {

    PreparedStatement ps;
    ResultSet rs;

    public QuyDinhPhiNoiTruEntity LayPhiNoiTru(String MaKTX) {
        String sql = "select tb_QuyDinhPhiNoiTru.MaPhiNoiTru, tb_QuyDinhPhiNoiTru.MaLoaiNha, (tb_QuyDinhPhiNoiTru.PhiNoiTru) as PhiNoiTru\n"
                + " from tb_SinhVien, tb_XepPhong, tb_Nha, tb_LoaiNha, tb_QuyDinhPhiNoiTru\n"
                + "where tb_SinhVien.MaKTX = tb_XepPhong.MaKTX and tb_XepPhong.MaNha = tb_Nha.MaNha and tb_Nha.MaLoaiNha = tb_LoaiNha.MaLoaiNha\n"
                + "and tb_LoaiNha.MaLoaiNha = tb_QuyDinhPhiNoiTru.MaLoaiNha and tb_XepPhong.MaKTX= '" + MaKTX + "'";

        QuyDinhPhiNoiTruEntity quyDinhPhiNoiTruEntity = new QuyDinhPhiNoiTruEntity();
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                quyDinhPhiNoiTruEntity.setMaPhiNoiTru(rs.getInt("MaPhiNoiTru"));
                quyDinhPhiNoiTruEntity.setMaLoaiNha(rs.getInt("MaLoaiNha"));
                quyDinhPhiNoiTruEntity.setPhiNoiTru(String.valueOf(rs.getInt("PhiNoiTru")));
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return quyDinhPhiNoiTruEntity;

    }

    public void ShowTable(Vector cols, Vector data) {
        String sql = "select * from tb_QuyDinhPhiNoiTru";
        cols.add("Mã Quy Định");
        cols.add("Mã Loại Nhà");
        cols.add("Mức Phí");

        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vector quyDinhPhiNoiTru = new Vector();
                quyDinhPhiNoiTru.addElement(rs.getInt("MaPhiNoiTru"));
                quyDinhPhiNoiTru.addElement(rs.getInt("MaLoaiNha"));
                quyDinhPhiNoiTru.addElement(String.valueOf(rs.getInt("PhiNoiTru")));
                data.add(quyDinhPhiNoiTru);
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    public String LayPhiNoiTruTheoLoaiNha(int soNguoi) {
        String sql = "select  distinct PhiNoiTru\n"
                + "from tb_QuyDinhPhiNoiTru inner join tb_LoaiNha on tb_QuyDinhPhiNoiTru.MaLoaiNha = tb_LoaiNha.MaLoaiNha\n"
                + "where SoNguoi = '" + soNguoi + "'";

        String phiNoiTru = "";
        try {
            DataAccessHelper.getConnection();
            ps = DataAccessHelper.con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                phiNoiTru = rs.getString("PhiNoiTru");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
        return phiNoiTru;
    }

    public void Update(int soNguoi, String phiNoiTru) {
        String sql = "update tb_QuyDinhPhiNoiTru set PhiNoiTru = '"+phiNoiTru+"'\n"
                + "where MaLoaiNha IN(select MaLoaiNha\n"
                + "from tb_LoaiNha\n"
                + "where SoNguoi = '"+soNguoi+"')";
        
        try {
            ps  = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }
}
