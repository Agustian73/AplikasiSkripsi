package peramalan.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6P52
 */
public class Koneksi {

    public Connection con;
    Statement st;

    public Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/db_peramalan?user=root&password=";
            con = DriverManager.getConnection(url);
            con.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
