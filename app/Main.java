package app;

public class Main {
    public static void main(String[] args) {
        // Run GUI in Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frmPenghitungHari frame = new frmPenghitungHari();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}