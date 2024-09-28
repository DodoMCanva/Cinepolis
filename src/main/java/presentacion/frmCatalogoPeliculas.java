package presentacion;

import dto.PeliculaDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import negocio.NegocioException;
import negocio.PeliculaNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
import utilerias.Tabla;

/**
 *
 * @author Valeria
 */
public class frmCatalogoPeliculas extends javax.swing.JFrame {

    private int pag = 0;
    private final static int LIMITE = 10;
    private PeliculaNegocio peliculaNegocio = new PeliculaNegocio();
    
    public frmCatalogoPeliculas() {
        initComponents();
        cargarTabla();
        ajustarColumnas();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnAtras.setEnabled(false);
        this.cargarConfiguracionInicialTabla();
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
        btnAtras = new javax.swing.JButton();
        lblnumPagCatPeli = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
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

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, -1, -1));

        lblnumPagCatPeli.setText("NumPag");
        jPanelCatalogoPeliculas.add(lblnumPagCatPeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 550, -1, -1));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Películas");
        jPanelCatalogoPeliculas.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        getContentPane().add(jPanelCatalogoPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void cargarTabla() {
        try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<PeliculaDTO> Lista = this.peliculaNegocio.buscarPeliculas(filtro);
            this.BorrarRegistrosTabla();
            this.AgregarRegistrosTabla(Lista);
            if (Lista.size() == 0) {
                pag--;
                int imp = pag + 1;
                lblnumPagCatPeli.setText("Página " + imp);
                this.cargarTabla();
            }
        } catch (NegocioException ex) {
            this.BorrarRegistrosTabla();
            this.pag--;
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void AgregarRegistrosTabla(List<PeliculaDTO> Lista) {
        if (Lista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPeliculas.getModel();
        Lista.forEach(row -> {
            Object[] fila = new Object[8];
            fila[0] = row.getId();
            fila[1] = row.getTitulo();
            fila[2] = row.getClasificacion();
            fila[3] = row.getDuracion();
            fila[4] = row.getGenero();
            fila[5] = row.getPaisOrigen();
            fila[6] = row.getSinopsis();
            modeloTabla.addRow(fila);
        });
    }
    
    
    private void cargarConfiguracionInicialTabla() {
        ActionListener onEliminarClickListener = new ActionListener() {
            final int columnaId = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar();
                } catch (NegocioException ex) {
                    Logger.getLogger(frmCatalogoClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        int indiceColumnaEliminar = 7;
        TableColumnModel modeloColumnas = this.tblPeliculas.getColumnModel();
        modeloColumnas = this.tblPeliculas.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }
    
    private void eliminar() throws NegocioException {
        int id = this.getIdSeleccionadoTabla();
        peliculaNegocio.eliminarPelicula(id);
        cargarTabla();
    }
    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblPeliculas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblPeliculas.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void BorrarRegistrosTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPeliculas.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int row = modeloTabla.getRowCount() - 1; row > -1; row--) {
                modeloTabla.removeRow(row);
            }
        }
    }

    private void cargarTablaBusqueda(String nombre) {
        /*try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<PeliculaDTO> Lista = this.peliculaNegocio.buscarporNombre(nombre, filtro);
            this.BorrarRegistrosTabla();
            this.AgregarRegistrosTabla(Lista);
            if (Lista.size() == 0) {
                pag--;
                int imp = pag + 1;
                lblnumPagCatPeli.setText("Página " + imp);
                this.cargarTablaBusqueda(nombre);
            }
        } catch (NegocioException ex) {
            this.BorrarRegistrosTabla();
            this.pag--;
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }*/
    }
    
    private Tabla obtenerFiltrosTabla() {
        return new Tabla(this.LIMITE, this.pag, txtBuscarPelicula.getText());
    }
    
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmMenu regresar = new frmMenu();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmDatosPelicula agregar = new frmDatosPelicula();
        agregar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (pag == 0) {
            btnAtras.setEnabled(false);
        } else {
            this.pag--;
            int impresion = pag + 1;
            lblnumPagCatPeli.setText("Página " + impresion);
            this.cargarTabla();
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtBuscarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPeliculaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = txtBuscarPelicula.getText();
        if (!nombre.isEmpty()) {
            this.cargarTablaBusqueda(nombre);
        } else {
            this.dispose();
            frmCatalogoClientes c = new frmCatalogoClientes();
            c.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.pag++;
        int imp = pag + 1;
        lblnumPagCatPeli.setText("Página " + imp);
        this.cargarTabla();
        btnAtras.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanelCatalogoPeliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblnumPagCatPeli;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTextField txtBuscarPelicula;
    // End of variables declaration//GEN-END:variables
}
