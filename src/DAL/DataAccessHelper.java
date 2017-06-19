/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessHelper {

  public static Connection con;

  //private  Statement stat = con.createStatement();
  public static Connection getConnection() throws FileNotFoundException {
    String input = "password.txt";
    FileInputStream fis = new FileInputStream(new File(input));
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

//            String current = new java.io.File(".").getCanonicalPath();
//            System.out.println("Current dir:" + current);
//            String currentDir = System.getProperty("user.dir");
//            System.out.println("Current dir using System:" + currentDir);
//      con = DriverManager.getConnection("jbdc:sqlserver://" +currentDir+ ";database=QLKTX;username = sa; password = 123456");
      con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; database=QLKTX;integratedsecurity = true");
      String line = br.readLine();
      //con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; database=QLKTX; username = sa; password = 123456" + line.trim());
      //con = DriverManager.getConnection("");
      if (con != null) {
        System.out.println("connected");
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | SQLException e) {
      System.out.println("Ket noi bi loi!" + e.getMessage());
    } finally {
      try {
        br.close();
        fis.close();
      } catch (IOException ex) {
      }
    }
    return con;
  }

  public static void closeConnection() {
    try {
      con.close();
    } catch (Exception e) {
      System.out.println("Đóng kết nối bị lỗi " + e.toString());
    }

  }

}
