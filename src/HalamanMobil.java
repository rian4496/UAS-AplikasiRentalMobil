
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import model.Mobil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Hadi PC
 */
public class HalamanMobil extends javax.swing.JPanel {

    /**
     * Creates new form HalamanMobil
     */
    public HalamanMobil() {
        initComponents();
        
        // Inisialisasi ButtonGroup untuk status radio button
        buttonGroup1 = new ButtonGroup();
         buttonGroup1 .add(jRadioButton1); // Tersedia
         buttonGroup1 .add(jRadioButton2); // Disewa

        loadMobilList();
        
        // Listener untuk menampilkan detail mobil yang dipilih
         listMobil.addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                Mobil selectedMobil = listMobil.getSelectedValue();
                if (selectedMobil != null) {
                    tampilkanDetailMobil(selectedMobil);
                }
            }
        });
    }
    
    private void tampilkanDetailMobil(Mobil mobil) {
        txtNamaMobil.setText(mobil.namaMobil());
        txtNomorPolisi.setText(mobil.nomorPolisi());
        cmbTipeMobil.setSelectedItem(mobil.tipe());
        spinHargaSewa.setValue(mobil.hargaSewaPerHari());
        jRadioButton1.setSelected(mobil.status()); // Tersedia
        jRadioButton2.setSelected(!mobil.status()); // Disewa
        
      // Tampilkan gambar
        byte[] gambar = mobil.gambar();
        if (gambar != null) {
            try {
                java.awt.Image image = javax.imageio.ImageIO.read(new java.io.ByteArrayInputStream(gambar));
                lblGambarMobil.setIcon(new javax.swing.ImageIcon(image.getScaledInstance(
                        lblGambarMobil.getWidth(), lblGambarMobil.getHeight(), java.awt.Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat gambar: " + e.getMessage(),
                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            lblGambarMobil.setIcon(null);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblGambarMobil = new javax.swing.JLabel();
        btnPilihGambar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaMobil = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomorPolisi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbTipeMobil = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        spinHargaSewa = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMobil = new javax.swing.JList<>();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gambar Mobil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblGambarMobil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGambarMobil.setPreferredSize(new java.awt.Dimension(320, 180));
        jPanel2.add(lblGambarMobil, java.awt.BorderLayout.CENTER);

        btnPilihGambar.setText("Pilih Gambar");
        btnPilihGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihGambarActionPerformed(evt);
            }
        });
        jPanel2.add(btnPilihGambar, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel4.setLayout(new java.awt.GridLayout(3, 4, 12, 8));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Merk Mobil");
        jPanel4.add(jLabel2);
        jPanel4.add(txtNamaMobil);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nomor Polisi");
        jPanel4.add(jLabel3);
        jPanel4.add(txtNomorPolisi);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Tipe Mobil");
        jPanel4.add(jLabel4);

        cmbTipeMobil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedan", "Sport", "Offroad", "MPV (Multi-Purpose Vehicle)", "Pick Up Truck / Double Cabin" }));
        jPanel4.add(cmbTipeMobil);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Harga Sewa per Hari");
        jPanel4.add(jLabel5);

        spinHargaSewa.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 50000.0d));
        jPanel4.add(spinHargaSewa);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Status");
        jPanel4.add(jLabel6);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Tersedia");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Disewa");
        jPanel4.add(jRadioButton2);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 12, 4));

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setPreferredSize(new java.awt.Dimension(150, 50));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel6.add(btnSimpan);

        btnUbah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setPreferredSize(new java.awt.Dimension(150, 50));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel6.add(btnUbah);

        btnHapus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(150, 50));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel6.add(btnHapus);

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(150, 50));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel6.add(btnReset);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        txtCari.setPreferredSize(new java.awt.Dimension(360, 30));
        jPanel7.add(txtCari);

        btnCari.setText("Cari");
        btnCari.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        jPanel7.add(btnCari);

        jPanel1.add(jPanel7, java.awt.BorderLayout.SOUTH);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

        listMobil.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listMobil);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihGambarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            try {
                // Membaca file gambar dan mengubahnya menjadi ImageIcon
                javax.swing.ImageIcon imageIcon = new javax.swing.ImageIcon(selectedFile.getAbsolutePath());

                // Mengatur ukuran gambar sesuai dengan lblGambarMobil
                java.awt.Image image = imageIcon.getImage();
                java.awt.Image resizedImage = image.getScaledInstance(lblGambarMobil.getWidth(), lblGambarMobil.getHeight(), java.awt.Image.SCALE_SMOOTH);

                // Menampilkan gambar di lblGambarMobil
                lblGambarMobil.setIcon(new javax.swing.ImageIcon(resizedImage));
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat gambar: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPilihGambarActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Mobil mobil = getMobilFromInput();
        if (mobil == null) {
            return;
        }

        try {
            mobil.save();
            loadMobilList();
            clearInputFields();
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menyimpan mobil: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // Pastikan ada mobil yang dipilih
        Mobil selectedMobil = listMobil.getSelectedValue();
        if (selectedMobil == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih mobil yang ingin diubah!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Dapatkan data dari input form
        Mobil updatedMobil = getMobilFromInput(selectedMobil.idMobil());
        if (updatedMobil == null) {
            // Validasi gagal
            return;
        }

        try {
            // Lakukan update pada database
            updatedMobil.update();
            loadMobilList();
            clearInputFields();
            javax.swing.JOptionPane.showMessageDialog(this, "Data mobil berhasil diperbarui!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            // Tampilkan pesan error jika terjadi kesalahan
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memperbarui mobil: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // Pastikan ada mobil yang dipilih
        Mobil selectedMobil = listMobil.getSelectedValue();
        if (selectedMobil == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih mobil yang ingin dihapus!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Konfirmasi penghapusan
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin menghapus mobil " + selectedMobil.namaMobil() + " dengan nomor polisi " + selectedMobil.nomorPolisi() + "?",
                "Konfirmasi Hapus",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            // Penghapusan dibatalkan
            return;
        }

        try {
            // Hapus mobil dari database
            selectedMobil.delete();
            loadMobilList();
            clearInputFields();
            javax.swing.JOptionPane.showMessageDialog(this, "Mobil berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            // Tampilkan pesan error jika terjadi kesalahan
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal menghapus mobil: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        loadMobilList(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearInputFields();   
        txtCari.setText("");
        loadMobilList();
    }//GEN-LAST:event_btnResetActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        clearInputFields();
        txtCari.setText("");
        loadMobilList();
    }//GEN-LAST:event_formComponentShown

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void loadMobilList() {
        loadMobilList(null);
    }

    private void loadMobilList(String keyword) {
        try {
            // Mendapatkan data mobil dari database
            List<Mobil> mobilList = Mobil.getAll(keyword);

            // Membuat model untuk JList
            DefaultListModel<Mobil> listModel = new DefaultListModel<>();
            for (Mobil mobil : mobilList) {
                listModel.addElement(mobil);
            }

            // Mengatur model ke JList
            listMobil.setModel(listModel);
        } catch (SQLException e) {
            // Menampilkan pesan error jika terjadi kesalahan
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memuat data mobil: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private Mobil getMobilFromInput() {
        return getMobilFromInput(null);
    }

    private Mobil getMobilFromInput(Integer id) {
        // Validasi input form
        String namaMobil = txtNamaMobil.getText().trim();
        if (namaMobil.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nama mobil tidak boleh kosong!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return null;
        }

        String nomorPolisi = txtNomorPolisi.getText().trim();
        if (nomorPolisi.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nomor polisi tidak boleh kosong!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return null;
        }

        if (cmbTipeMobil.getSelectedIndex() == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Tipe mobil harus dipilih!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return null;
        }

        double hargaSewaPerHari = (double) spinHargaSewa.getValue();
        if (hargaSewaPerHari <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Harga sewa per hari harus lebih dari 0!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return null;
        }

        // Mendapatkan status dari checkbox
        boolean status = jRadioButton1.isSelected();

        // Validasi gambar
        byte[] gambar = null;
        if (lblGambarMobil.getIcon() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gambar mobil harus dipilih!", "Validasi Gagal", javax.swing.JOptionPane.WARNING_MESSAGE);
            return null;
        }

        // Konversi icon pada lblGambarMobil menjadi byte array
        try {
            java.awt.Image image = ((javax.swing.ImageIcon) lblGambarMobil.getIcon()).getImage();
            java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    java.awt.image.BufferedImage.TYPE_INT_ARGB
            );
            java.awt.Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            // Konversi buffered image ke byte array
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            javax.imageio.ImageIO.write(bufferedImage, "png", baos);
            gambar = baos.toByteArray();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal memproses gambar: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Membuat objek Mobil dari input form
        if (id != null) {
            return new Mobil(id, namaMobil, nomorPolisi, cmbTipeMobil.getSelectedItem().toString(), hargaSewaPerHari, status, gambar);
        } else {
            return new Mobil(namaMobil, nomorPolisi, cmbTipeMobil.getSelectedItem().toString(), hargaSewaPerHari, status, gambar);
        }
    }

    private void clearInputFields() {
        txtNamaMobil.setText("");
        txtNomorPolisi.setText("");
        cmbTipeMobil.setSelectedIndex(-1);
        spinHargaSewa.setValue(0.0d);
        jRadioButton1.setSelected(false);
        lblGambarMobil.setIcon(null);
        listMobil.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPilihGambar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbTipeMobil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGambarMobil;
    private javax.swing.JList<model.Mobil> listMobil;
    private javax.swing.JSpinner spinHargaSewa;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNamaMobil;
    private javax.swing.JTextField txtNomorPolisi;
    // End of variables declaration//GEN-END:variables
}
