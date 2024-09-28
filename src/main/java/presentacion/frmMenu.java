package presentacion;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ClienteNegocio;
import negocio.IClienteNegocio;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;

public class frmMenu extends javax.swing.JFrame {

    private IClienteNegocio clienteNegocio;

    public frmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnsucursales = new javax.swing.JButton();
        btnGenerarReportes = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnPeliculas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 107, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsucursales.setBackground(new java.awt.Color(153, 204, 255));
        btnsucursales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnsucursales.setText("Sucursales");
        btnsucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsucursalesActionPerformed(evt);
            }
        });
        jPanel1.add(btnsucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 230, 70));

        btnGenerarReportes.setBackground(new java.awt.Color(153, 204, 255));
        btnGenerarReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerarReportes.setText("Generar reportes");
        jPanel1.add(btnGenerarReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 230, 70));

        btnClientes.setBackground(new java.awt.Color(153, 204, 255));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 230, 70));

        btnPeliculas.setBackground(new java.awt.Color(153, 204, 255));
        btnPeliculas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPeliculas.setText("Películas");
        btnPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeliculasActionPerformed(evt);
            }
        });
        jPanel1.add(btnPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 230, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        frmCatalogoClientes cc = new frmCatalogoClientes();
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeliculasActionPerformed
        frmCatalogoPeliculas ir = new frmCatalogoPeliculas();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPeliculasActionPerformed

    private void btnsucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsucursalesActionPerformed
        frmCatalogoSucursales catS = new frmCatalogoSucursales();
        catS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsucursalesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnGenerarReportes;
    private javax.swing.JButton btnPeliculas;
    private javax.swing.JButton btnsucursales;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
