package presentacion;

/**
 *
 * @author Valeria
 */
public class frmCatalogoPeliculas extends javax.swing.JFrame {

    public frmCatalogoPeliculas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCatalogoPeliculas = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        txtBuscarPelicula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAtrasCatPeli = new javax.swing.JButton();
        lblnumPagCatPeli = new javax.swing.JLabel();
        btnSiguienteCatPeli = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogo Peliculas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCatalogoPeliculas.setBackground(new java.awt.Color(58, 107, 203));
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
        jPanelCatalogoPeliculas.add(txtBuscarPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 590, 25));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        tblPeliculas.setBackground(new java.awt.Color(153, 204, 255));
        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Clasificacion", "Minutos", "Genero", "Pais", "Sinopsis", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblPeliculas);

        jPanelCatalogoPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 800, 370));

        btnAgregar.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 100, 30));

        btnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscar.setText("Buscar");
        jPanelCatalogoPeliculas.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));

        btnAtrasCatPeli.setText("Atras");
        btnAtrasCatPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCatPeliActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnAtrasCatPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, -1, -1));

        lblnumPagCatPeli.setText("NumPag");
        jPanelCatalogoPeliculas.add(lblnumPagCatPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, -1, -1));

        btnSiguienteCatPeli.setText("Siguiente");
        jPanelCatalogoPeliculas.add(btnSiguienteCatPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Películas");
        jPanelCatalogoPeliculas.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

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
        frmDatosPelicula agregar = new frmDatosPelicula();
        agregar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAtrasCatPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCatPeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasCatPeliActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtrasCatPeli;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSiguienteCatPeli;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanelCatalogoPeliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblnumPagCatPeli;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTextField txtBuscarPelicula;
    // End of variables declaration//GEN-END:variables
}
