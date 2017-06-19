/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BackupThuPhiDienNuocDAL {

    PreparedStatement ps;
    ResultSet rs;

    public void Insert(int MaNha, int MaPhong, int thang, int nam) {
        String sql = "INSERT into tb_BackupThuPhiDienNuoc(MaNha,MaPhong,Thang,Nam) VALUES (?,?,?,?)";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.setInt(1, MaNha);
            ps.setInt(2, MaPhong);
            ps.setInt(3, thang);
            ps.setInt(4, nam);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

    //cap nhat tien dien, tien nuoc, tong tien
    public void Update(int MaNha, int MaPhong, int thang, int nam, float SoKWDien, float SoKhoiNuoc) {
        String sql = "declare @numrowDien int = (Select count(DenKW) from tb_MucGiaDien where DenKW <= (select max(DenKW) from tb_MucGiaDien) AND DenKW > 0)\n"
                + "declare @i int = 1\n"
                + "update tb_BackupThuPhiDienNuoc set TienDien =  0  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "		WHILE (@i <= @numrowDien)\n"
                + "		BEGIN\n"
                + "			IF '" + SoKWDien + "' <= (SELECT top (@i) DenKW from tb_MucGiaDien except select top (@i - 1) DenKW from tb_MucGiaDien)\n"
                + "				BEGIN\n"
                + "					update tb_BackupThuPhiDienNuoc set TienDien = TienDien +  (select top (@i) ('" + SoKWDien + "' - TuKW) * GiaDien from tb_MucGiaDien \n"
                + "					except select top (@i -1) ('" + SoKWDien + "' - TuKW) * GiaDien from tb_MucGiaDien) where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "					break\n"
                + "				END\n"
                + "			ELSE\n"
                + "				update tb_BackupThuPhiDienNuoc set TienDien =  TienDien + (select top (@i) (DenKW - TuKW) * GiaDien from tb_MucGiaDien\n"
                + "				 except select top (@i-1) (DenKW - TuKW) * GiaDien from tb_MucGiaDien )  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "			set @i = @i + 1\n"
                + "		END\n"
                + "IF '" + SoKWDien + "' > (select max(DenKW) from tb_MucGiaDien)\n"
                + "update tb_BackupThuPhiDienNuoc set TienDien =  TienDien + (select top (@numrowDien) ('" + SoKWDien + "' - DenKW) * GiaDien from tb_MucGiaDien\n"
                + "except select top (@numrowDien-1) ('" + SoKWDien + "' - DenKW) * GiaDien from tb_MucGiaDien )  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "declare @numrowNuoc int = (Select count(DenKhoi) from tb_MucGiaNuoc where DenKhoi <= (select max(DenKhoi) from tb_MucGiaNuoc) AND DenKhoi > 0)\n"
                + "declare @iNuoc int = 1\n"
                + "update tb_BackupThuPhiDienNuoc set TienNuoc = 0  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "	WHILE (@iNuoc <= @numrowNuoc)\n"
                + "	BEGIN\n"
                + "		IF '" + SoKhoiNuoc + "' < = (SELECT top (@iNuoc) DenKhoi from tb_MucGiaNuoc except select top (@iNuoc - 1) DenKhoi from tb_MucGiaNuoc)\n"
                + "			BEGIN\n"
                + "				update tb_ThuPhiDienNuoc set TienNuoc = TienNuoc + (select top (@iNuoc) ('" + SoKhoiNuoc + "' - TuKhoi) * GiaNuoc from tb_MucGiaNuoc  \n"
                + "				except select top (@iNuoc - 1) ('" + SoKhoiNuoc + "' - TuKhoi) * GiaNuoc from tb_MucGiaNuoc)  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "				break\n"
                + "			END\n"
                + "		ELSE\n"
                + "			update tb_BackupThuPhiDienNuoc set TienNuoc = TienNuoc + (select top (@iNuoc) (DenKhoi - TuKhoi) * GiaNuoc from tb_MucGiaNuoc \n"
                + "			 except select top (@iNuoc - 1) (DenKhoi - TuKhoi) * GiaNuoc from tb_MucGiaNuoc) where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "		set @iNuoc = @iNuoc + 1\n"
                + "	END\n"
                + "IF '" + SoKhoiNuoc + "' > (SELECT max(DenKhoi) from tb_MucGiaNuoc)\n"
                + "update tb_BackupThuPhiDienNuoc set TienNuoc = TienNuoc + (select top (@numrowNuoc) ('" + SoKhoiNuoc + "' - DenKhoi) * GiaNuoc from tb_MucGiaNuoc\n"
                + "except select top (@numrowNuoc - 1) ('" + SoKhoiNuoc + "' - DenKhoi) * GiaNuoc from tb_MucGiaNuoc )  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "\n"
                + "update tb_BackupThuPhiDienNuoc set TongCong = TienDien + TienNuoc  where Thang = '" + thang + "' and Nam = '" + nam + "' and MaNha =  '" + MaNha + "'and MaPhong = '" + MaPhong + "'\n"
                + "\n"
                + "";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }

    }

    public void Update_NgayThu_DaThu(int MaNha, int MaPhong, int thang, int nam, Date ngayThu) {
        String sql = "update tb_BackupThuPhiDienNuoc set NgayThu = '" + ngayThu + "', DaThu = TongCong where MaNha= '" + MaNha + "' and MaPhong = '" + MaPhong + "'"
                + "and Thang = '" + thang + "' and Nam = '" + nam + "'";
        try {
            ps = DataAccessHelper.con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.toString());
        }
    }

}
