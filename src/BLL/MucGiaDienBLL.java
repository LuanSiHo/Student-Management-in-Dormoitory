/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.MucGiaDienDAL;
import java.sql.Date;
import java.util.Vector;


public class MucGiaDienBLL {

    MucGiaDienDAL mucGiaDienDAL = new MucGiaDienDAL();

    public void ShowTable(Vector cols, Vector data) {
        mucGiaDienDAL.ShowTable(cols, data);
    }
    
     public void Update(int maGiaDien, Date ngayApDung, float tuKw, float denKw, String gia)
     {
         mucGiaDienDAL.Update(maGiaDien, ngayApDung, tuKw, denKw, gia);
     }
}
