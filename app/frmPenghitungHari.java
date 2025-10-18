package app;

import java.time.YearMonth;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.JOptionPane;
import com.toedter.calendar.JCalendar; // requires toedter library

public class frmPenghitungHari extends javax.swing.JFrame {

    public frmPenghitungHari() {
        initComponents();
    }

    private void initComponents() {
        panelUtama = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        lblBulan = new javax.swing.JLabel();
        cmbBulan = new javax.swing.JComboBox<>();
        lblTahun = new javax.swing.JLabel();
        spnTahun = new javax.swing.JSpinner();
        btnHitung = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        lblHasil = new javax.swing.JLabel();
        // JCalendar components for selisih tanggal
        lblSelisih = new javax.swing.JLabel();
        cal1 = new JCalendar();
        cal2 = new JCalendar();
        btnSelisih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penghitungan Hari");

        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setText("Aplikasi Penghitungan Hari");

        lblBulan.setText("Bulan:");

        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        }));

        lblTahun.setText("Tahun:");

        spnTahun.setModel(new javax.swing.SpinnerNumberModel(2025, 1, 9999, 1));

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        lblHasil.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblHasil.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSelisih.setText("Hitung Selisih Dua Tanggal:");

        btnSelisih.setText("Hitung Selisih");
        btnSelisih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelisihActionPerformed(evt);
            }
        });

        // Layout using GroupLayout for a clean NetBeans-like layout
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBulan)
                            .addComponent(lblTahun))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHitung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKeluar))
                            .addComponent(spnTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBulan)
                    .addComponent(cmbBulan)
                    .addComponent(btnHitung)
                    .addComponent(btnKeluar))
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTahun)
                    .addComponent(spnTahun))
                .addGap(12, 12, 12)
                .addComponent(lblHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSelisih)
                .addGap(6,6,6)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cal1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cal2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6,6,6)
                .addComponent(btnSelisih)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(panelUtama);

        pack();
    }

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String namaBulan = (String) cmbBulan.getSelectedItem();
            int bulan = cmbBulan.getSelectedIndex() + 1;
            int tahun = (Integer) spnTahun.getValue();

            YearMonth ym = YearMonth.of(tahun, bulan);
            int jumlahHari = ym.lengthOfMonth();
            LocalDate hariPertama = ym.atDay(1);
            LocalDate hariTerakhir = ym.atEndOfMonth();

            String hasil = "<html>Bulan: " + namaBulan + " Tahun: " + tahun + "<br>"
                    + "Jumlah Hari: " + jumlahHari + "<br>"
                    + "Hari Pertama: " + hariPertama.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale(\"id\")) + "<br>"
                    + "Hari Terakhir: " + hariTerakhir.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale(\"id\"))
                    + "</html>";

            lblHasil.setText(hasil);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage());
        }
    }

    private void btnSelisihActionPerformed(java.awt.event.ActionEvent evt) {
        java.util.Date d1 = cal1.getDate();
        java.util.Date d2 = cal2.getDate();
        long diff = Math.abs(d2.getTime() - d1.getTime());
        long hari = diff / (1000L * 60 * 60 * 24);
        lblHasil.setText("<html>Selisih antara tanggal: " + hari + " hari</html>");
    }

    // Variables declaration
    private javax.swing.JPanel panelUtama;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblBulan;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JLabel lblTahun;
    private javax.swing.JSpinner spnTahun;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JLabel lblHasil;

    private javax.swing.JLabel lblSelisih;
    private JCalendar cal1;
    private JCalendar cal2;
    private javax.swing.JButton btnSelisih;
    // End of variables declaration
}