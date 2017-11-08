/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peramalan.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import peramalan.models.ModelJenis;

/**
 *
 * @author 6P52
 */
public class FrmJenis extends javax.swing.JInternalFrame {
    DefaultTableModel model = new DefaultTableModel(){
         public boolean isCellEditable(int rowIndex, int collIndex) {
            return false;
        }
    };

    /**
     * Creates new form FrmJenis
     */
    public FrmJenis() {
        initComponents();
        tblJenis.setModel(model);
        model.addColumn("Kode Jenis");
        model.addColumn("Nama Jenis");
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBaru = new usu.widget.ButtonGlass();
        btnSimpan = new usu.widget.ButtonGlass();
        btnUpdate = new usu.widget.ButtonGlass();
        btnHapus = new usu.widget.ButtonGlass();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtJenis = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJenis = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 78, 9));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Form Jenis Kayu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 78, 9));

        btnBaru.setText("Baru");
        btnBaru.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setText("Edit");
        btnUpdate.setEnabled(false);
        btnUpdate.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.setFont(new java.awt.Font("Lucida Calligraphy", 0, 11)); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel2.setText("Kode");

        jLabel5.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        jLabel5.setText("Nama");

        txtKode.setEditable(false);
        txtKode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtJenis.setEditable(false);
        txtJenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKode)
                    .addComponent(txtJenis))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblJenis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblJenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJenisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJenis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String autoNumber() {
        ModelJenis mj = new ModelJenis();
        String number = mj.getId();
        if (number.equals("")) {
            number = "J001";
        } else {
            number = number.substring(2);
            int angka = Integer.parseInt(number);
            angka++;
            if (angka < 10) {
                number = "00" + angka;
            } else if (angka >= 10 && angka < 100) {
                number = "0" + angka;
            } else if (angka >= 100 && angka < 1000) {
                number = "" + angka;
            } else {
                number = String.valueOf(angka);
            }
            if (number.length() > 5) {
                number = number.substring(number.length() - 5, number.length());
            }
            number = "J" + number;
        }
        return number;
    }

    public void loadId() {
        txtKode.setText(autoNumber());
    }

    public void loadData() {
        ModelJenis m = new ModelJenis();
        ResultSet r = m.read();
        try {
            model.getDataVector().removeAllElements();
            while (r.next()) {
                Object obj[] = new Object[2];
                obj[0] = r.getString("kd_jenis");
                obj[1] = r.getString("nama_jenis");
                model.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        // TODO add your handling code here:
        if (btnBaru.getText().equals("Baru")) {
            btnBaru.setText("Batal");
            btnSimpan.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtJenis.setEditable(true);            
            loadId();
        } else {
            btnBaru.setText("Baru");
            btnUpdate.setText("Edit");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtJenis.setEditable(false);           
            txtKode.setText("");
            txtJenis.setText("");           
        }
    }//GEN-LAST:event_btnBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String a = txtJenis.getText();       
        if (!a.equals("")) {
            ModelJenis mh = new ModelJenis();                     
            String data[] = {txtKode.getText(),
                txtJenis.getText()                
            };
            if (mh.insert(data) > 0) {
                JOptionPane.showMessageDialog(null, "Data tersimpan");
                loadId();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
            loadData();
            btnBaru.setText("Baru");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnHapus.setEnabled(true);
            txtJenis.setEditable(false);            
            txtKode.setText("");
            txtJenis.setText("");           
        } else {
            JOptionPane.showMessageDialog(null, "Mohon lengkapi data", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         if (btnUpdate.getText().equals("Edit")) {
            btnUpdate.setText("Update");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnHapus.setEnabled(false);
            btnBaru.setText("Batal");
            txtJenis.setEditable(true);            
        } else {          
            ModelJenis mj = new ModelJenis();            
            if (txtJenis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mohon lengkapi data");
            } else {
                String data[] = {txtKode.getText(),
                    txtJenis.getText()
                 };
                if (mj.update(data) > 0) {
                    loadData();
                    JOptionPane.showMessageDialog(null, "Data terupdate");
                    txtJenis.setText("");                    
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            }
            btnBaru.setText("Baru");
            btnUpdate.setText("Edit");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtJenis.setEditable(false);            
            txtKode.setText("");
            txtJenis.setText("");           
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = tblJenis.getSelectedRow();
        String id_user = (String) tblJenis.getValueAt(i, 0);
        ModelJenis mk = new ModelJenis();
        String data[] = {id_user};
        if (JOptionPane.showConfirmDialog(this, "Yakin menghapus data?", "Peringatan", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            mk.delete(data);
            JOptionPane.showMessageDialog(null, "Data terhapus");
            //
            loadData();
            btnBaru.setText("Baru");
            btnSimpan.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnHapus.setEnabled(false);
            txtJenis.setEditable(false);            
            txtKode.setText("");
            txtJenis.setText("");           
        } else {
            JOptionPane.showMessageDialog(null, "Batal Menghapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblJenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJenisMouseClicked
        // TODO add your handling code here:
        int i = tblJenis.getSelectedRow();
        String id = (String) tblJenis.getValueAt(i, 0);
        btnUpdate.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBaru.setText("Batal");
        ModelJenis m = new ModelJenis();
        ResultSet r = m.select(id);
        try {
            r.next();
            txtKode.setText(r.getString("kd_jenis"));
            txtJenis.setText(r.getString("nama_jenis"));            
        } catch (SQLException ex) {
            Logger.getLogger(FrmJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblJenisMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btnBaru;
    private usu.widget.ButtonGlass btnHapus;
    private usu.widget.ButtonGlass btnSimpan;
    private usu.widget.ButtonGlass btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblJenis;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKode;
    // End of variables declaration//GEN-END:variables
}
