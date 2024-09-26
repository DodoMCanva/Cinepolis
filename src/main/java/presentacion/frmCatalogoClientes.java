package presentacion;

/**
 *
 * @author Equipo 3
 */
public class frmCatalogoClientes extends javax.swing.JFrame {

    public frmCatalogoClientes() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCatalogoPeliculas = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePeliculas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogo Peliculas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCatalogoPeliculas.setBackground(new java.awt.Color(0, 51, 153));
        jPanelCatalogoPeliculas.setPreferredSize(new java.awt.Dimension(920, 600));
        jPanelCatalogoPeliculas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));
        jPanelCatalogoPeliculas.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 490, 25));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        jTablePeliculas.setBackground(new java.awt.Color(153, 204, 255));
        jTablePeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Correo ", "Fecha Nacimiento", "Geolocalizacion", "Contrasena", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(jTablePeliculas);

        jPanelCatalogoPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 800, 380));

        btnAgregar.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 100, 30));

        btnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscar.setText("Buscar");
        jPanelCatalogoPeliculas.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        getContentPane().add(jPanelCatalogoPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
//        frmMetodosPagos regresar = new frmMetodosPagos();
//        regresar.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        /*frmDatosPelicula agregar = new frmDatosPelicula();
        agregar.setVisible(true);
        this.dispose();*/
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanelCatalogoPeliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePeliculas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
