/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peramalan.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import peramalan.koneksi.Koneksi;

/**
 *
 * @author 6P52
 */
public class ModelLaporan extends Koneksi{
    public ResultSet tanggal(){
        ResultSet i = null;
        String sql = "SELECT tgl_peramalan FROM tbl_peramalan";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            i = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ModelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  i;
    }
}
