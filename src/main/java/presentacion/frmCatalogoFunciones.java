package presentacion;

import dto.FuncionDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.FuncionNegocio;
import negocio.IFuncionNegocio;
import negocio.NegocioException;
import persistencia.ConexionBD;
import persistencia.FuncionDAO;
import persistencia.IFuncionDAO;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
import utilerias.Tabla;

public class frmCatalogoFunciones extends javax.swing.JFrame {

    private int pag = 0;
    private final static int LIMITE = 10;
    private IFuncionNegocio funcionNegocio;
    private int idSucursal;

    public frmCatalogoFunciones(int idSucursal) {
        incializar(idSucursal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnAtras.setEnabled(false);
        this.cargarConfiguracionInicialTabla();
        this.cargarTabla();
    }

    private void incializar(int n) {
        this.idSucursal = n;
        IFuncionDAO funcionDAO = (IFuncionDAO) new FuncionDAO(new ConexionBD());
        this.funcionNegocio = new FuncionNegocio(idSucursal);
    }

    public void setSalaNegocio(IFuncionNegocio salaNegocio) {
        this.funcionNegocio = salaNegocio;
        cargarTabla(); // Cargar la tabla después de establecer el negocio
    }

    private void cargarTabla() {
        try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<FuncionDTO> lista = this.funcionNegocio.buscarFunciones(filtro, idSucursal);
            this.BorrarRegistrosTabla();
            this.AgregarRegistrosTabla(lista);

            if (lista.size() == 0 && pag > 0) {
                pag--; // Decrementa la página solo si hay más páginas
            }

            lblNumPagCatFuncio.setText("Página " + (pag + 1));

            // Habilitar/deshabilitar botones de paginación
            btnAtras.setEnabled(pag > 0);
            btnSiguiente.setEnabled(lista.size() == LIMITE);

        } catch (NegocioException ex) {
            this.BorrarRegistrosTabla();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AgregarRegistrosTabla(List<FuncionDTO> lista) {
        if (lista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblFunciones.getModel();
        lista.forEach(row -> {
            Object[] fila = new Object[6];
            Calendar cal = Calendar.getInstance();
            cal.setTime(row.getHoraFin());
            cal.add(Calendar.MINUTE, 20);

            Time Limpieza = new Time(cal.getTimeInMillis());
            fila[0] = Limpieza;
            fila[1] = row.getFechaHoraRegistro();
            fila[2] = row.getHoraInicio();
            fila[3] = row.getHoraFin();
            fila[4] = row.getIdPelicula();
            fila[5] = "Eliminar";
            modeloTabla.addRow(fila);
        });
    }

    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblFunciones.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblFunciones.getModel();
            int indiceColumnaId = 0;
            int idSalaSeleccionada = (int) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idSalaSeleccionada;
        } else {
            return 0;
        }
    }

    private void eliminar() throws NegocioException {
        int id = this.getIdSeleccionadoTabla();
        funcionNegocio.eliminar(id);
        cargarTabla();

    }

    private void BorrarRegistrosTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblFunciones.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int row = modeloTabla.getRowCount() - 1; row > -1; row--) {
                modeloTabla.removeRow(row);
            }
        }
    }

    private Tabla obtenerFiltrosTabla() {
        return new Tabla(this.LIMITE, this.pag, "");
    }

    private void cargarConfiguracionInicialTabla() {
        TableColumnModel modeloColumnas = this.tblFunciones.getColumnModel();

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

        modeloColumnas.getColumn(5).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(5).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCatalogoFunciones = new javax.swing.JPanel();
        btnVolverFuncion = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFunciones = new javax.swing.JTable();
        btnAgregarFuncion = new javax.swing.JButton();
        btnBuscarFuncion = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblNumPagCatFuncio = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCatalogoFunciones.setBackground(new java.awt.Color(58, 107, 203));
        jPanelCatalogoFunciones.setPreferredSize(new java.awt.Dimension(920, 600));
        jPanelCatalogoFunciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolverFuncion.setBackground(new java.awt.Color(153, 204, 255));
        btnVolverFuncion.setText("Volver");
        btnVolverFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverFuncionActionPerformed(evt);
            }
        });
        jPanelCatalogoFunciones.add(btnVolverFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));
        jPanelCatalogoFunciones.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 590, 25));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        tblFunciones.setBackground(new java.awt.Color(153, 204, 255));
        tblFunciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fin + limpieza", "Fecha", "Inicio", "Fin", "Pelicula", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblFunciones);

        jPanelCatalogoFunciones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 800, 360));

        btnAgregarFuncion.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregarFuncion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarFuncion.setText("Agregar");
        btnAgregarFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFuncionActionPerformed(evt);
            }
        });
        jPanelCatalogoFunciones.add(btnAgregarFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 100, 30));

        btnBuscarFuncion.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscarFuncion.setText("Buscar");
        jPanelCatalogoFunciones.add(btnBuscarFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));

        btnAtras.setText("Atras");
        jPanelCatalogoFunciones.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        btnSiguiente.setText("Siguiente");
        jPanelCatalogoFunciones.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, -1));

        lblNumPagCatFuncio.setText("numeroPag");
        jPanelCatalogoFunciones.add(lblNumPagCatFuncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Funciones");
        jPanelCatalogoFunciones.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        getContentPane().add(jPanelCatalogoFunciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverFuncionActionPerformed
        frmMenu regresar = new frmMenu();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverFuncionActionPerformed

    private void btnAgregarFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFuncionActionPerformed
        frmDatosFunciones agregar = new frmDatosFunciones(idSucursal);
        agregar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarFuncionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFuncion;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarFuncion;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolverFuncion;
    private javax.swing.JPanel jPanelCatalogoFunciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumPagCatFuncio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblFunciones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
