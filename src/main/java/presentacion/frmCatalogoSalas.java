
package presentacion;

/**
 *
 * @author Valeria
 */
public class frmCatalogoSalas extends javax.swing.JFrame {

    /**
     * Creates new form frmCatalogoSalas
     */
    public frmCatalogoSalas() {
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

        jPanelCatalogoSucursales = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        txtBuscarSala = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSucursales = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBuscarSala = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCatalogoSucursales.setBackground(new java.awt.Color(58, 107, 203));
        jPanelCatalogoSucursales.setPreferredSize(new java.awt.Dimension(920, 600));
        jPanelCatalogoSucursales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        txtBuscarSala.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanelCatalogoSucursales.add(txtBuscarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 590, 25));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        jTableSucursales.setBackground(new java.awt.Color(153, 204, 255));
        jTableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(jTableSucursales);

        jPanelCatalogoSucursales.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 800, 380));

        btnAgregar.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 100, 30));

        btnBuscarSala.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscarSala.setText("Buscar");
        btnBuscarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSalaActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnBuscarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sucursales");
        jPanelCatalogoSucursales.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        getContentPane().add(jPanelCatalogoSucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //        frmMetodosPagos regresar = new frmMetodosPagos();
        //        regresar.setVisible(true);
        //        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmDatosSucursal agregar = new frmDatosSucursal();
        agregar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarSalaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarSala;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCatalogoSucursales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSucursales;
    private javax.swing.JTextField txtBuscarSala;
    // End of variables declaration//GEN-END:variables
}
