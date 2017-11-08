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
public class ModelJenis extends Koneksi{
    public ResultSet read() {
        ResultSet r = null;
        String sql = "SELECT * FROM tbl_jenis";
        try {
            PreparedStatement p = con.prepareStatement(sql);           
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int insert(String[] param) {
        int i = 0;
        try {
            String sql = "INSERT INTO tbl_jenis VALUES(?,?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            p.setString(2, param[1]);                        
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int update(String[] param) {
        int i = 0;
        String sql = "UPDATE tbl_jenis SET nama_jenis=? WHERE kd_jenis=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(2, param[0]);
            p.setString(1, param[1]);                                           
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public int delete(String[] param) {
        int i = 0;
        String sql = "DELETE FROM tbl_jenis WHERE kd_jenis=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, param[0]);
            i = p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }    
    public String getId(){
        String id = "";       
        String sql = "SELECT kd_jenis FROM tbl_jenis ORDER BY kd_jenis DESC";
        try{
            PreparedStatement p = con.prepareStatement(sql);  
            ResultSet resultSet = p.executeQuery(sql);
            if(resultSet.next()){
                id = resultSet.getString(1);
            }
        }catch(SQLException e){            
        }
        return id;
    }
    public ResultSet select(String kd) {
        ResultSet  r = null;        
        String sql = "SELECT * FROM tbl_jenis where kd_jenis= '"+kd+"'";
        try {
            PreparedStatement p = con.prepareStatement(sql);                    
            r = p.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ModelJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
