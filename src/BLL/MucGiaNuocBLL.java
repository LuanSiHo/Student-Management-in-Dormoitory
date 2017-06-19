/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.MucGiaNuocDAL;
import java.sql.Date;
import java.util.Vector;


public class MucGiaNuocBLL {
    MucGiaNuocDAL mucGiaNuocDAL = new MucGiaNuocDAL();
    
    public void ShowTable(Vector cols, Vector data) 
    {
        mucGiaNuocDAL.ShowTable(cols, data);
    }
    
     public void Update(int maGiaNuoc, Date ngayApDung, float tuKhoi, float denKhoi, String gia)
     {
         mucGiaNuocDAL.Update(maGiaNuoc, ngayApDung, tuKhoi, denKhoi, gia);
     }
}
