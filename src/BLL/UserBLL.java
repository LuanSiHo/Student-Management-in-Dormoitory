/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.UserDAL;
import Entities.UserEntity;
import java.util.ArrayList;


public class UserBLL {

  UserDAL loginDAL = new UserDAL();

  public int getLogin(String username, String password) {
    return loginDAL.getLogin(username, password);
  }

  public void Insert(String tenDangNhap, String matKhau, String userType, String fullName) {
    loginDAL.Insert(tenDangNhap, matKhau, userType, fullName);
  }

  public void Update(String tenDangNhap, String matKhau) {
    loginDAL.Update(tenDangNhap, matKhau);
  }

  public ArrayList<String> LayChucVu() {
    return loginDAL.LayChucVu();
  }

  public boolean SearchUser(String tenDangNhap) {
    return loginDAL.SearchUser(tenDangNhap);
  }

  public UserEntity getUser(String username, String password) {
    return loginDAL.getUser(username, password);
  }
}
