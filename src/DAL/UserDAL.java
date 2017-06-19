/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.UserEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDAL extends DataAccessHelper {

  PreparedStatement ps;
  ResultSet rs;

  public int getLogin(String username, String password) {
    int type = 3;
    String sql = "SELECT * from tb_User WHERE Username = ? AND Password = ?";
    try {
      DataAccessHelper.getConnection();
      ps = DataAccessHelper.con.prepareStatement(sql);
      ps.setString(1, username);
      ps.setString(2, password);
      rs = ps.executeQuery();
      if (rs.next()) {
        String userType = rs.getString("UserType");
        switch (userType) {
          case "NhanVien": {
            type = 1;
            break;
          }
          case "TruongNha": {
            type = 2;
            break;
          }
          default: {
            type = 0;
          }
        }
      }
    } catch (Exception e) {
    }
    return type;
  }

  /**
   * Lấy thông tin user
   * @param username username của nhân viên
   * @param password password của nhân viên
   * @return thông tin nhân viên
   */
  public UserEntity getUser(String username, String password) {
    String sql = "select *\n"
            + "from tb_User\n"
            + "where UserName = '" + username + "'\n"
            + "	  and Password = '" + password + "'";
    UserEntity us = new UserEntity();
    try {
      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        us.setUsername(username);
        us.setPassword(password);
        us.setFullName(rs.getString("FullName"));
        us.setUserType(rs.getString("UserType"));
      }

    } catch (Exception e) {
      System.out.println("Lỗi: " + e.toString());
    }
    return us;
  }

  public void Insert(String tenDangNhap, String matKhau, String userType, String fullName) {
    String sql = "insert into tb_User(UserName,Password,UserType,FullName) Values(N'" + tenDangNhap + "','" + matKhau + "','" + userType + "', N'" + fullName + "')";
    try {
      ps = DataAccessHelper.con.prepareStatement(sql);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("Lỗi: " + e.toString());
    }
  }

  public void Update(String tenDangNhap, String matKhau) {
    String sql = "update tb_User set Password = '" + matKhau + "' where UserName = N'" + tenDangNhap + "'";
    try {
      ps = DataAccessHelper.con.prepareStatement(sql);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("Lỗi: " + e.toString());
    }
  }

  public ArrayList<String> LayChucVu() {
    String sql = "select distinct UserType from tb_User";
    ArrayList<String> danhSachChucVu = new ArrayList<>();
    try {
      DataAccessHelper.getConnection();
      ps = DataAccessHelper.con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        danhSachChucVu.add(rs.getString("UserType"));

      }
    } catch (Exception e) {
      System.out.println("Lỗi: " + e.toString());
    }
    return danhSachChucVu;
  }

  public boolean SearchUser(String tenDangNhap) {
    String sql = "select * from tb_User where Username = '" + tenDangNhap + "'";

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
}
