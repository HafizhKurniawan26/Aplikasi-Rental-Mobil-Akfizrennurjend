/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pelanggan;


import config.databaseConnection;
import config.userSession;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hafizh Kurniawan
 */
public class pembayaran extends javax.swing.JFrame {
    public String gpembayaran, gstatus;

    /**
     * Creates new form pembayaran
     */
    public pembayaran() {
        initComponents();
        tampilkanPembayaran();
    }
    
     public void tampilkanPembayaran() {
        try{
            int idUserSession = userSession.getIdUser();
        Connection conn = databaseConnection.connect();
        String sql = "SELECT p.id_pembayaran, r.id_rental, p.metode_pembayaran, p.jumlah_bayar, p.tanggal_bayar, p.status "
                + "FROM pembayaran p INNER JOIN rental r ON p.id_rental = r.id_rental WHERE r.id_user = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUserSession);
        ResultSet rs = stmt.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pembayaran");
        model.addColumn("ID Rental");
        model.addColumn("Metode Pembayaran");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Tanggal Bayar");
        model.addColumn("Status");
        
        while (rs.next()){
            model.addRow(new Object[]{
            rs.getInt("id_pembayaran"),
            rs.getInt("id_rental"),
            rs.getString("metode_pembayaran"),
            rs.getString("jumlah_bayar"),
            rs.getString("tanggal_bayar"),
            rs.getString("status")
            });
        }
        
        jTextField1.setEnabled(false);
        jComboBox2.setEnabled(false);
        
        int idRentalSession = userSession.getIdRental();
        jTextField2.setText(String.valueOf(idRentalSession));
        
        jComboBox2.setSelectedIndex(0);
    
        jTable1.setModel(model);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: "+ e.getMessage());
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("FORM PEMBAYARAN");

        jLabel2.setText("ID Pembayaran");

        jLabel3.setText("ID Rental");

        jLabel4.setText("Metode Pembayaran");

        jLabel5.setText("Jumlah Bayar");

        jLabel6.setText("Tanggal Bayar");

        jLabel7.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "transfer", "tunai" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pending", "lunas", "gagal" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Bayar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(49, 49, 49)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex() == 0){
            gpembayaran = "transfer";
        }else if(jComboBox1.getSelectedIndex() == 1){
            gpembayaran = "tunai";
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex() == 0){
            gstatus = "pending";
        }else if(jComboBox2.getSelectedIndex() == 1){
            gstatus = "lunas";
        }else if(jComboBox2.getSelectedIndex() == 2){
            gstatus = "gagal";
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try {
            // Validasi input
            if (jTextField2.getText().trim().isEmpty() || 
                jTextField3.getText().trim().isEmpty() || 
                jTextField4.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field wajib diisi");
                return;
            }

            int idRental = Integer.parseInt(jTextField2.getText());
            int jumlahBayar = Integer.parseInt(jTextField3.getText());
            String statuspembayaran = (String) jComboBox2.getSelectedItem();
            String tanggalBayar = jTextField4.getText().trim();

            try (Connection conn = databaseConnection.connect()) {
                conn.setAutoCommit(false); // Mulai transaction

                try {
                    // 1. Cek apakah rental exists dan statusnya
                    String checkQuery = "SELECT status, total_biaya FROM rental WHERE id_rental = ?";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                        checkStmt.setInt(1, idRental);
                        ResultSet rs = checkStmt.executeQuery();

                        if (!rs.next()) {
                            JOptionPane.showMessageDialog(this, "Rental tidak ditemukan");
                            return;
                        }

//                        String statusRental = rs.getString("status");
                        double totalBiaya = rs.getDouble("total_biaya");

                        // Cek apakah rental sudah dibayar
                        if ("lunas".equals(statuspembayaran)) {
                            JOptionPane.showMessageDialog(this, "Rental sudah lunas dibayar");
                            return;
                        }

                        // Optional: Validasi jumlah pembayaran
                        if (jumlahBayar < totalBiaya) {
                            JOptionPane.showMessageDialog(this, "Jumlah bayar kurang dari total biaya (Rp" + String.format("%.2f", totalBiaya) + 
                                ")");
                            return;
                        }
                    }

                    // 2. Insert data pembayaran
                    String insertQuery = "INSERT INTO pembayaran (id_rental, metode_pembayaran, jumlah_bayar, tanggal_bayar, status) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                        insertStmt.setInt(1, idRental);
                        insertStmt.setString(2, gpembayaran);
                        insertStmt.setInt(3, jumlahBayar);
                        insertStmt.setString(4, tanggalBayar);
                        insertStmt.setString(5, "pending");
                        insertStmt.executeUpdate();
                    }

                    // 3. Update status rental menjadi "diproses"
                    updateStatusRental(conn, idRental, "diproses");

                    conn.commit(); // Commit transaction

                    JOptionPane.showMessageDialog(this, "Pembayaran berhasil disimpan dan status rental diperbarui.");

                    // Reset form
                    resetFormPembayaran();

                } catch (SQLException e) {
                    conn.rollback(); // Rollback jika ada error
                    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format angka tidak valid");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
            e.printStackTrace();
        }

        tampilkanPembayaran();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateStatusRental(Connection conn, int idRental, String statusBaru) throws SQLException {
        String sql = "UPDATE rental SET status = ? WHERE id_rental = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, statusBaru);
            stmt.setInt(2, idRental);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Status rental berhasil diupdate menjadi: " + statusBaru + " untuk ID: " + idRental);
            } else {
                throw new SQLException("Gagal update status rental untuk ID: " + idRental);
            }
        }
    }
    
    private void resetFormPembayaran() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");

        if (jComboBox2 != null) {
            jComboBox2.setSelectedIndex(-1);
        }
        if (jComboBox1 != null) {
            jComboBox1.setSelectedIndex(-1);
        }        
        userSession.clearSelectedMobil();        
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit");
            return;
        }

        try {
            // Ambil data dari tabel
            int idPembayaran = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            int idRental = Integer.parseInt(jTable1.getValueAt(selectedRow, 1).toString());
            String metodePembayaran = jTable1.getValueAt(selectedRow, 2).toString();
            int jumlahBayar = Integer.parseInt(jTable1.getValueAt(selectedRow, 3).toString());

            // Format tanggal (hilangkan jam dan menit)
            Object tanggalValue = jTable1.getValueAt(selectedRow, 4);
            String tanggalBayar;

            if (tanggalValue instanceof java.sql.Timestamp) {
                // Jika dari database berupa Timestamp
                java.sql.Timestamp ts = (java.sql.Timestamp) tanggalValue;
                java.util.Date date = new java.util.Date(ts.getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                tanggalBayar = sdf.format(date);
            } else if (tanggalValue instanceof java.util.Date) {
                // Jika berupa Date object
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                tanggalBayar = sdf.format((java.util.Date) tanggalValue);
            } else {
                // Jika berupa String, ambil bagian tanggal saja
                tanggalBayar = tanggalValue.toString().split(" ")[0];
            }

            String status = jTable1.getValueAt(selectedRow, 5).toString();

            // Set nilai ke form
            jTextField1.setText(String.valueOf(idPembayaran));
            jTextField2.setText(String.valueOf(idRental));
            jComboBox1.setSelectedItem(metodePembayaran);
            jTextField3.setText(String.valueOf(jumlahBayar));
            jTextField4.setText(tanggalBayar);
            jComboBox2.setSelectedItem(status);

            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jComboBox2.setEnabled(false);

            // Ubah tombol simpan menjadi update
            jButton1.setText("Update");
            // Hapus semua action listener sebelumnya
            for (ActionListener al : jButton1.getActionListeners()) {
                jButton1.removeActionListener(al);
            }
            // Tambahkan action listener untuk update
            jButton1.addActionListener(e -> updateDataPembayaran());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error mengambil data: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new dashboardPelanggan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void updateDataPembayaran(){
        int idPembayaran = Integer.parseInt(jTextField1.getText());
        int idRental = Integer.parseInt(jTextField2.getText());
        String metodePembayaran = (String) jComboBox1.getSelectedItem();
        int jumlahBayar = Integer.parseInt(jTextField3.getText());
        String tanggalBayar = jTextField4.getText().trim();
       

        if (idRental == 0 || jComboBox1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!");
            return;
        }

        try (Connection conn = databaseConnection.connect()) {
            String sql = "UPDATE pembayaran SET id_rental=?, metode_pembayaran=?, jumlah_bayar=?, tanggal_bayar=?, status=? WHERE id_pembayaran=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idRental);
            stmt.setString(2, metodePembayaran);
            stmt.setInt(3, jumlahBayar);
            stmt.setString(4, tanggalBayar);
            stmt.setString(5, gstatus);
            stmt.setInt(6, idPembayaran);
           
           

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.");
                // Reset form
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                
                jComboBox1.setSelectedIndex(-1);
                jComboBox2.setSelectedIndex(-1);
                jTextField1.setEnabled(true);
         
             

                // Change button back to save mode
                jButton1.setText("Simpan");
                jButton1.removeActionListener(jButton1.getActionListeners()[0]);
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });

                tampilkanPembayaran();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate: " + e.getMessage());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
