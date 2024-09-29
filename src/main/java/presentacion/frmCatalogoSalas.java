package presentacion;

import dto.SalaDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.ClienteNegocio;
import negocio.ISalaNegocio;
import negocio.NegocioException;
import negocio.SalaNegocio;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;
import persistencia.ISalaDAO;
import persistencia.SalaDAO;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
import utilerias.Tabla;

/**
 *
 * @author Valeria
 */
public class frmCatalogoSalas extends javax.swing.JFrame {

    private int pag = 0;
    private final static int LIMITE = 10;
    private ISalaNegocio salaNegocio;
    private int idSucursal;

    /**
     * Creates new form frmCatalogoSalas
     */
    public frmCatalogoSalas(int idSucursal) {
        incializar(idSucursal);
        this.salaNegocio = salaNegocio;
        initComponents(); // Solo una vez
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnAtrasCatSalas.setEnabled(false);
        this.cargarConfiguracionInicialTabla();
        this.cargarTabla(); // Ahora está bien llamar a cargarTabla()
        ajustarColumnas();
    }

    private void incializar(int n) {
        this.idSucursal=idSucursal;
        ISalaDAO salaDAO = new SalaDAO(new ConexionBD());
        this.salaNegocio = new SalaNegocio(n);

    }

    public void setSalaNegocio(ISalaNegocio salaNegocio) {
        this.salaNegocio = salaNegocio;
        cargarTabla(); // Cargar la tabla después de establecer el negocio
    }

    private void cargarTabla() {
        try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<SalaDTO> lista = this.salaNegocio.buscarSalas(filtro);
            this.BorrarRegistrosTabla();
            this.AgregarRegistrosTabla(lista);

            if (lista.size() == 0 && pag > 0) {
                pag--; // Decrementa la página solo si hay más páginas
            }

            lblNumPagCatSala.setText("Página " + (pag + 1));

            // Habilitar/deshabilitar botones de paginación
            btnAtrasCatSalas.setEnabled(pag > 0);
            btnSiguienteCatSala.setEnabled(lista.size() == LIMITE);

        } catch (NegocioException ex) {
            this.BorrarRegistrosTabla();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AgregarRegistrosTabla(List<SalaDTO> lista) {
        if (lista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSala.getModel();
        lista.forEach(row -> {
            Object[] fila = new Object[2];
            fila[0] = row.getNombre();
            fila[1] = "Eliminar"; // Texto del botón de eliminar
            modeloTabla.addRow(fila);
        });
    }

    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblSala.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblSala.getModel();
            int indiceColumnaId = 0;
            int idSalaSeleccionada = (int) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idSalaSeleccionada;
        } else {
            return 0;
        }
    }

    private void eliminar() throws NegocioException {
        int id = this.getIdSeleccionadoTabla();
        salaNegocio.eliminar(id);
        cargarTabla();
    }

    private void BorrarRegistrosTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSala.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int row = modeloTabla.getRowCount() - 1; row > -1; row--) {
                modeloTabla.removeRow(row);
            }
        }
    }

    private Tabla obtenerFiltrosTabla() {
        return new Tabla(this.LIMITE, this.pag, txtBuscarSala.getText());
    }

    private void cargarConfiguracionInicialTabla() {
        TableColumnModel modeloColumnas = this.tblSala.getColumnModel();

        // Configurar botón "Eliminar"
        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar();
                } catch (NegocioException ex) {
                    Logger.getLogger(frmCatalogoSalas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        modeloColumnas.getColumn(1).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(1).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
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
        tblSala = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBuscarSala = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAtrasCatSalas = new javax.swing.JButton();
        lblNumPagCatSala = new javax.swing.JLabel();
        btnSiguienteCatSala = new javax.swing.JButton();

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

        tblSala.setBackground(new java.awt.Color(153, 204, 255));
        tblSala.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSala);

        jPanelCatalogoSucursales.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 800, 370));

        btnAgregar.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 100, 30));

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
        jLabel1.setText("Salas");
        jPanelCatalogoSucursales.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        btnAtrasCatSalas.setText("Atras");
        btnAtrasCatSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCatSalasActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnAtrasCatSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        lblNumPagCatSala.setText("numPag");
        jPanelCatalogoSucursales.add(lblNumPagCatSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, -1, -1));

        btnSiguienteCatSala.setText("Siguiente");
        btnSiguienteCatSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCatSalaActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnSiguienteCatSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, -1, -1));

        getContentPane().add(jPanelCatalogoSucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmDatosSucursal regresar = new frmDatosSucursal();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmDatosSala agregar = new frmDatosSala(this.idSucursal);
        agregar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarSalaActionPerformed

    private void btnSiguienteCatSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCatSalaActionPerformed
        this.pag++;
        int imp = pag + 1;
        lblNumPagCatSala.setText("Página " + imp);
        this.cargarTabla();
        btnAtrasCatSalas.setEnabled(true);    }//GEN-LAST:event_btnSiguienteCatSalaActionPerformed

    private void btnAtrasCatSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCatSalasActionPerformed
        if (pag == 0) {
            btnAtrasCatSalas.setEnabled(false);
        } else {
            this.pag--;
            int impresion = pag + 1;
            lblNumPagCatSala.setText("Página " + impresion);
            this.cargarTabla();
        }
    }//GEN-LAST:event_btnAtrasCatSalasActionPerformed
    private void ajustarColumnas() {
        // Ajustar el ancho de las columnas según el índice
        tblSala.getColumnModel().getColumn(0).setPreferredWidth(150); // Nombre de la Sala
        tblSala.getColumnModel().getColumn(1).setPreferredWidth(100); // Capacidad

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtrasCatSalas;
    private javax.swing.JButton btnBuscarSala;
    private javax.swing.JButton btnSiguienteCatSala;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCatalogoSucursales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumPagCatSala;
    private javax.swing.JTable tblSala;
    private javax.swing.JTextField txtBuscarSala;
    // End of variables declaration//GEN-END:variables
}
