

package peramalan.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import peramalan.koneksi.Koneksi;


public class ModelPeramalan extends Koneksi{
    
    public ResultSet read(){
        ResultSet i = null;
        String sql = "SELECT tbl_peramalan.kd_peramalan, tbl_peramalan.tgl_peramalan, tbl_jenis.nama_jenis, tbl_persediaan.ukuran, tbl_peramalan.alpha, tbl_peramalan.mse, tbl_peramalan.hasil FROM tbl_peramalan, tbl_persediaan, tbl_jenis WHERE tbl_jenis.kd_jenis=tbl_persediaan.kd_jenis AND tbl_persediaan.kd_persediaan=tbl_peramalan.kd_persediaan order by tbl_peramalan.kd_peramalan asc ";
        //String sql = "SELECT tbl_peramalan.kd_peramalan, DATE_FORMAT(tbl_peramalan.tgl_peramalan,'%d-%m-%Y') AS tgl, tbl_jenis.nama_jenis, tbl_persediaan.ukuran, tbl_peramalan.alpha, tbl_peramalan.mse, tbl_peramalan.hasil FROM tbl_peramalan, tbl_persediaan, tbl_jenis WHERE tbl_jenis.kd_jenis=tbl_persediaan.kd_jenis AND tbl_persediaan.kd_persediaan=tbl_peramalan.kd_persediaan";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelPeramalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public int delete(String []param){
        int i = 0;
        String sql = "DELETE FROM tbl_peramalan WHERE kd_peramalan=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelPeramalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
}
