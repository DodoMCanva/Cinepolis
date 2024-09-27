
package presentacion;

/**
 *
 * @author Valeria
 */
public class frmResumenCompra extends javax.swing.JFrame {

    /**
     * Creates new form frmResumenCompra
     */
    public frmResumenCompra() {
        initComponents();
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
        lblTitulo = new javax.swing.JLabel();
        DatosPelicula = new javax.swing.JPanel();
        jLInicio = new javax.swing.JLabel();
        lblTotalResumenCompra = new javax.swing.JLabel();
        lblHoraFin = new javax.swing.JLabel();
        jLFin = new javax.swing.JLabel();
        jLPeli = new javax.swing.JLabel();
        lblPelicula = new javax.swing.JLabel();
        lblEntrada = new javax.swing.JLabel();
        lblHoraInicio = new javax.swing.JLabel();
        jLEntrada = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        btnMetodoPago = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblPoster = new javax.swing.JLabel();
        lblInfPelicula = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resumen de compra");
        setBackground(new java.awt.Color(0, 51, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 107, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Resumen de compra");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        DatosPelicula.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DatosPelicula.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLInicio.setText("Horario inicio:");
        DatosPelicula.add(jLInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 25));

        lblTotalResumenCompra.setText("Total");
        DatosPelicula.add(lblTotalResumenCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 70, 25));

        lblHoraFin.setText("Fin");
        DatosPelicula.add(lblHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 120, 25));
        lblHoraFin.getAccessibleContext().setAccessibleName("Pelicula");

        jLFin.setText("Horario fin:");
        DatosPelicula.add(jLFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 25));

        jLPeli.setText("Película: ");
        DatosPelicula.add(jLPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 25));

        lblPelicula.setText("Pelicula");
        DatosPelicula.add(lblPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 25));

        lblEntrada.setText("Entrada");
        DatosPelicula.add(lblEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 120, 25));

        lblHoraInicio.setText("Inicio");
        DatosPelicula.add(lblHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 120, 25));

        jLEntrada.setText("Tipo de entrada:");
        DatosPelicula.add(jLEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 25));

        jLTotal.setText("Costo total: ");
        DatosPelicula.add(jLTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 70, 25));

        btnMetodoPago.setBackground(new java.awt.Color(153, 204, 255));
        btnMetodoPago.setText("Método de pago");
        btnMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMetodoPagoActionPerformed(evt);
            }
        });
        DatosPelicula.add(btnMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 120, 30));

        jPanel1.add(DatosPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 270, 250));

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblPoster.setForeground(new java.awt.Color(255, 255, 255));
        lblPoster.setText("PosterPelicula");
        lblPoster.setToolTipText("");
        lblPoster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(lblPoster, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 140, 180));

        lblInfPelicula.setForeground(new java.awt.Color(255, 255, 255));
        lblInfPelicula.setText("Informacion de la pelicula");
        jPanel1.add(lblInfPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMetodoPagoActionPerformed
//        frmInicioSesionCliente regresar = new frmInicioSesionCliente();
//        regresar.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnMetodoPagoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
 /*   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
   /*     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmResumenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmResumenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmResumenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmResumenCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmResumenCompra().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DatosPelicula;
    private javax.swing.JButton btnMetodoPago;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLEntrada;
    private javax.swing.JLabel jLFin;
    private javax.swing.JLabel jLInicio;
    private javax.swing.JLabel jLPeli;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblHoraFin;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblInfPelicula;
    private javax.swing.JLabel lblPelicula;
    private javax.swing.JLabel lblPoster;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalResumenCompra;
    // End of variables declaration//GEN-END:variables
}
