/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.GhiNhanKyLuatDAL;
import java.sql.Date;
import java.util.Vector;


public class GhiNhanKyLuatBLL {
    
    GhiNhanKyLuatDAL ghiNhanKyLuatDAL  = new GhiNhanKyLuatDAL();
    
    public void Insert(String MaKTX,Date NgayGhiNhan,String MucKyLuat,String GhiChu) 
    {
        ghiNhanKyLuatDAL.Insert(MaKTX, NgayGhiNhan, MucKyLuat, GhiChu);
    }
    
    public void ShowTable(Vector cols, Vector data)
    {
        ghiNhanKyLuatDAL.ShowTable(cols, data);
    }
    
    public void Delete(String MaKTX)
    {
        ghiNhanKyLuatDAL.Delete(MaKTX);
    }
    
    
    
}
