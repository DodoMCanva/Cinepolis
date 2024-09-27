/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

/**
 *
 * @author Valeria
 */
public class frmDatosPelicula extends javax.swing.JFrame {

    /**
     * Creates new form frmDatosPelicula
     */
    public frmDatosPelicula() {
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
        btnVolver = new javax.swing.JButton();
        lblTituloLinkTrailer = new javax.swing.JLabel();
        lblTituloClasifi = new javax.swing.JLabel();
        lblTituloDuracion = new javax.swing.JLabel();
        lblTituloGenero = new javax.swing.JLabel();
        lblTituloTitulo = new javax.swing.JLabel();
        lblTituloPais = new javax.swing.JLabel();
        lblTituloSinopsis = new javax.swing.JLabel();
        jCBClasificacion = new javax.swing.JComboBox<>();
        txtDuracion = new javax.swing.JTextField();
        jCBGenero = new javax.swing.JComboBox<>();
        txtTitulo = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtSinopsis = new javax.swing.JTextField();
        txtLinkTrailer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardarDatosPeli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 107, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTituloLinkTrailer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloLinkTrailer.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloLinkTrailer.setText("Link trailer");
        jPanel1.add(lblTituloLinkTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 110, 30));

        lblTituloClasifi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloClasifi.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloClasifi.setText("Clasificasón");
        jPanel1.add(lblTituloClasifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 30));

        lblTituloDuracion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloDuracion.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloDuracion.setText("Duración (Min)");
        jPanel1.add(lblTituloDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 30));

        lblTituloGenero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGenero.setText("Genero");
        jPanel1.add(lblTituloGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 30));

        lblTituloTitulo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTitulo.setText("Título");
        jPanel1.add(lblTituloTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 30));

        lblTituloPais.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloPais.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPais.setText("País");
        jPanel1.add(lblTituloPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 110, 30));

        lblTituloSinopsis.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloSinopsis.setText("Sinopsis");
        jPanel1.add(lblTituloSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 110, 30));

        jCBClasificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "B15", "C", "R" }));
        jCBClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBClasificacionActionPerformed(evt);
            }
        });
        jPanel1.add(jCBClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 220, 30));

        txtDuracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 220, 30));

        jCBGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terror", "Drama", "Comedia", "Ciencia Ficcion", "Musical" }));
        jPanel1.add(jCBGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, 30));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 220, 30));

        txtPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 220, 30));

        txtSinopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 220, 70));

        txtLinkTrailer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtLinkTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 220, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Datos de la Película");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Poster");
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 230, 290));

        btnGuardarDatosPeli.setBackground(new java.awt.Color(153, 204, 255));
        btnGuardarDatosPeli.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarDatosPeli.setText("Guardar");
        jPanel1.add(btnGuardarDatosPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmCatalogoPeliculas regresar = new frmCatalogoPeliculas();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jCBClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBClasificacionActionPerformed

    /**
     * @param args the command line arguments
     */
    /*   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*  try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDatosPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDatosPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDatosPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDatosPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDatosPelicula().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarDatosPeli;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> jCBClasificacion;
    private javax.swing.JComboBox<String> jCBGenero;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTituloClasifi;
    private javax.swing.JLabel lblTituloDuracion;
    private javax.swing.JLabel lblTituloGenero;
    private javax.swing.JLabel lblTituloLinkTrailer;
    private javax.swing.JLabel lblTituloPais;
    private javax.swing.JLabel lblTituloSinopsis;
    private javax.swing.JLabel lblTituloTitulo;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtLinkTrailer;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtSinopsis;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
