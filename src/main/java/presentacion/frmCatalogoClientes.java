package presentacion;

import dto.ClienteDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.ClienteNegocio;
import negocio.IClienteNegocio;
import negocio.NegocioException;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
import utilerias.Tabla;

/**
 *
 * @author Equipo 3
 */
public class frmCatalogoClientes extends javax.swing.JFrame {

    private int pag = 0;
    private final static int LIMITE = 10;
    private IClienteNegocio clienteNegocio;

    public frmCatalogoClientes() {
        incializar();
        this.clienteNegocio = clienteNegocio;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnAtras.setEnabled(false);
        this.cargarConfiguracionInicialTablaClientes();
        this.cargarTablaClientes();
        
    }

    private void incializar() {
        //try {
            IClienteDAO clienteDAO = new ClienteDAO(new ConexionBD());
            this.clienteNegocio = new ClienteNegocio();
        /*} catch (SQLException ex) {
            Logger.getLogger(frmCatalogoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCatalogoPeliculas = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblNumeroPagCatClientes = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

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
        jPanelCatalogoPeliculas.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 490, 25));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        tblClientes.setBackground(new java.awt.Color(153, 204, 255));
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

        jPanelCatalogoPeliculas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 800, 380));

        btnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 560, -1, -1));

        lblNumeroPagCatClientes.setText("numero Pag");
        jPanelCatalogoPeliculas.add(lblNumeroPagCatClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanelCatalogoPeliculas.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        getContentPane().add(jPanelCatalogoPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmMenu regresar = new frmMenu();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = txtBuscar.getText();
        System.out.println(nombre);
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
        lblNumeroPagCatClientes.setText("Página " + imp);
        this.cargarTablaClientes();
        btnAtras.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (pag == 0) {
            btnAtras.setEnabled(false);
        } else {
            this.pag--;
            int impresion = pag + 1;
            lblNumeroPagCatClientes.setText("Página " + impresion);
            this.cargarTablaClientes();
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void cargarConfiguracionInicialTablaClientes() {
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
        int indiceColumnaEliminar = 6;
        TableColumnModel modeloColumnas = this.tblClientes.getColumnModel();
        modeloColumnas = this.tblClientes.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private int getIdSeleccionadoTablaClientes() {
        int indiceFilaSeleccionada = this.tblClientes.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblClientes.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void eliminar() throws NegocioException {
        int id = this.getIdSeleccionadoTablaClientes();
        clienteNegocio.eliminar(id);
        cargarTablaClientes();
    }

    private void cargarTablaClientes() {
        try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<ClienteDTO> clientesLista = this.clienteNegocio.buscarClientes(filtro);
            this.BorrarRegistrosTablaClientes();
            this.AgregarRegistrosTablaCliente(clientesLista);
            if (clientesLista.size() == 0) {
                pag--;
                int imp = pag + 1;
                lblNumeroPagCatClientes.setText("Página " + imp);
                this.cargarTablaClientes();
            }
        } catch (NegocioException ex) {
            this.BorrarRegistrosTablaClientes();
            this.pag--;
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTablaBusqueda(String nombre) {
        try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<ClienteDTO> clientesLista = this.clienteNegocio.buscarporNombre(nombre, filtro);
            this.BorrarRegistrosTablaClientes();
            this.AgregarRegistrosTablaCliente(clientesLista);
            if (clientesLista.size() == 0) {
                pag--;
                int imp = pag + 1;
                lblNumeroPagCatClientes.setText("Página " + imp);
                this.cargarTablaBusqueda(nombre);
            }
        } catch (NegocioException ex) {
            this.BorrarRegistrosTablaClientes();
            this.pag--;
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AgregarRegistrosTablaCliente(List<ClienteDTO> clientesLista) {
        if (clientesLista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblClientes.getModel();
        clientesLista.forEach(row -> {
            Object[] fila = new Object[7];
            String NombreCompleto =(row.getNombre()+" "+row.getApellidoPaterno()+" "+row.getApellidoMaterno());
            fila[0] = row.getId();
            fila[1] = NombreCompleto;
            fila[2] = row.getCorreoElectronico();
            fila[3] = row.getFechaNacimiento();
            fila[4] = row.getGeolocalizacion();
            fila[5] = row.getContrasena();
            modeloTabla.addRow(fila);
        });
    }

    private void BorrarRegistrosTablaClientes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblClientes.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int row = modeloTabla.getRowCount() - 1; row > -1; row--) {
                modeloTabla.removeRow(row);
            }
        }
    }

    private Tabla obtenerFiltrosTabla() {
        return new Tabla(this.LIMITE, this.pag, txtBuscar.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanelCatalogoPeliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumeroPagCatClientes;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
