package presentacion;

import dto.PeliculaDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.NegocioException;
import negocio.PeliculaNegocio;

/**
 *
 * @author Valeria
 */
public class frmCatalogoPeliculas extends javax.swing.JFrame {

    public frmCatalogoPeliculas() {
        initComponents();
        cargarPeliculasEnTabla();
        ajustarColumnas();
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

        txtBuscarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPeliculaActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(txtBuscarPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 610, 25));

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

        jPanelCatalogoPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 890, 370));

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
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
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

        getContentPane().add(jPanelCatalogoPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private PeliculaNegocio peliculaNegocio = new PeliculaNegocio();

    private void cargarPeliculasEnTabla() {

        try {
            // Obtener la lista de películas desde la capa de negocio
            List<PeliculaDTO> listaPeliculas = peliculaNegocio.listarPeliculas();

            // Crear un modelo de tabla
            DefaultTableModel model = (DefaultTableModel) tblPeliculas.getModel();

            // Limpiar las filas actuales de la tabla
            model.setRowCount(0);

            // Llenar la tabla con los datos de las películas
            for (PeliculaDTO pelicula : listaPeliculas) {
                model.addRow(new Object[]{
                    pelicula.getId(),
                    pelicula.getTitulo(),
                    pelicula.getClasificacion(),
                    pelicula.getDuracion(),
                    pelicula.getGenero(),
                    pelicula.getPaisOrigen(),
                    pelicula.getSinopsis()
                });
            }
        } catch (NegocioException e) {
            // Mostrar el mensaje de error si ocurre una excepción
            JOptionPane.showMessageDialog(this, "Error al cargar las películas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
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

    private void txtBuscarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPeliculaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
          String tituloBuscado = txtBuscarPelicula.getText().trim();
    DefaultTableModel model = (DefaultTableModel) tblPeliculas.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    tblPeliculas.setRowSorter(sorter);

    // Aplicar filtro
    if (tituloBuscado.length() == 0) {
        sorter.setRowFilter(null); // Muestra todas las películas si el campo está vacío
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + tituloBuscado)); // Filtro que ignora mayúsculas y minúsculas
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

private void ajustarColumnas() {
    // Establecer el ancho de la columna ID
    tblPeliculas.getColumnModel().getColumn(0).setPreferredWidth(50); // Ancho de la columna ID

    // Establecer el ancho de las demás columnas
    tblPeliculas.getColumnModel().getColumn(1).setPreferredWidth(150); // Titulo
    tblPeliculas.getColumnModel().getColumn(2).setPreferredWidth(100); // Clasificación
    tblPeliculas.getColumnModel().getColumn(3).setPreferredWidth(70); // Minutos
    tblPeliculas.getColumnModel().getColumn(4).setPreferredWidth(70); // Género
    tblPeliculas.getColumnModel().getColumn(5).setPreferredWidth(100); // País
    tblPeliculas.getColumnModel().getColumn(6).setPreferredWidth(300); // Sinopsis
}

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
