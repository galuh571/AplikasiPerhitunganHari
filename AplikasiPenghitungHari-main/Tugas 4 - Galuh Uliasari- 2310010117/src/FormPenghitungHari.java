import javax.swing.SpinnerNumberModel;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.temporal.ChronoUnit;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FormPenghitungHari extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPenghitungHari.class.getName());

    /**
     * Creates new form FormPenghitungHari
     */
    public FormPenghitungHari() {
        initComponents();
        setTitle("Aplikasi Penghitung Hari");
        setLocationRelativeTo(null);

        // Isi ComboBox bulan
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        cbBulan.removeAllItems();
        for (String b : bulan) {
            cbBulan.addItem(b);
        }

        // Set nilai awal tahun = tahun sekarang
        int tahunSekarang = java.time.LocalDate.now().getYear();
       spnTahun.setModel(new javax.swing.SpinnerNumberModel(tahunSekarang, 1, 9999, 1));

        // Tambahkan event listener
        btnHitung.addActionListener(evt -> hitungJumlahHari());
        btnSelisih.addActionListener(evt -> hitungSelisihHari());
    }

    /**
     * Menghitung jumlah hari dalam bulan & tahun yang dipilih
     */
    private void hitungJumlahHari() {
        int bulan = cbBulan.getSelectedIndex() + 1;
       int tahun = ((Number) spnTahun.getValue()).intValue();

        java.time.YearMonth ym = java.time.YearMonth.of(tahun, bulan);
        int jumlahHari = ym.lengthOfMonth();

        lblHasil.setText("Jumlah hari: " + jumlahHari);

        // Variasi: tampilkan hari pertama & terakhir
        java.time.LocalDate firstDay = ym.atDay(1);
        java.time.LocalDate lastDay = ym.atEndOfMonth();

        lblHariPertama.setText("Hari pertama: " + firstDay.getDayOfWeek());
        lblHariTerakhir.setText("Hari terakhir: " + lastDay.getDayOfWeek());
    }

    /**
     * Menghitung selisih hari antara hari ini dan tanggal di kalender
     */
    private void hitungSelisihHari() {
        java.util.Date tglSekarang = java.util.Date.from(
                java.time.LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
        java.util.Date tglKalender = calender2.getDate();

        if (tglKalender == null) {
            lblSelisih.setText("Pilih tanggal terlebih dahulu!");
            return;
        }

        long selisihMillis = Math.abs(tglKalender.getTime() - tglSekarang.getTime());
        long selisihHari = selisihMillis / (1000 * 60 * 60 * 24);

        lblSelisih.setText("Selisih hari: " + selisihHari + " hari dari hari ini");
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblBulan = new javax.swing.JLabel();
        spnTahun = new javax.swing.JSpinner();
        lblTahun = new javax.swing.JLabel();
        cbBulan = new javax.swing.JComboBox<>();
        btnHitung = new javax.swing.JButton();
        lblHasil = new javax.swing.JLabel();
        lblHariPertama = new javax.swing.JLabel();
        lblHariTerakhir = new javax.swing.JLabel();
        calender2 = new com.toedter.calendar.JCalendar();
        btnSelisih = new javax.swing.JButton();
        lblSelisih = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penghitung Hari - Muhammad Ilqy Rahmatullah ");
        setBackground(new java.awt.Color(255, 255, 255));

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setText("Aplikasi Penghitung Hari");

        lblBulan.setText("Bulan");

        lblTahun.setText("Tahun");

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbBulan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbBulanFocusLost(evt);
            }
        });
        cbBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBulanActionPerformed(evt);
            }
        });

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        lblHasil.setText("Jumlah Hari:");

        lblHariPertama.setText("Hari Pertama:");

        lblHariTerakhir.setText("Hari Terakhir");

        calender2.setToolTipText("");

        btnSelisih.setText("Hitung Selisih");

        lblSelisih.setText("Selisih Hari:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSelisih, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(calender2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSelisih, javax.swing.GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHasil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHariPertama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHariTerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbBulan, 0, 105, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spnTahun, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(lblTahun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lblJudul)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBulan)
                    .addComponent(lblTahun))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHitung)
                .addGap(12, 12, 12)
                .addComponent(lblHasil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHariPertama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHariTerakhir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelisih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calender2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSelisih)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbBulanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbBulanFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBulanFocusLost

    private void cbBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBulanActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHitungActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
        e.printStackTrace();
    }
    java.awt.EventQueue.invokeLater(() -> new FormPenghitungHari().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnSelisih;
    private com.toedter.calendar.JCalendar calender2;
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JLabel lblBulan;
    private javax.swing.JLabel lblHariPertama;
    private javax.swing.JLabel lblHariTerakhir;
    private javax.swing.JLabel lblHasil;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblSelisih;
    private javax.swing.JLabel lblTahun;
    private javax.swing.JSpinner spnTahun;
    // End of variables declaration//GEN-END:variables

}