/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.SucursalDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.NegocioException;
import negocio.SucursalNegocio;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;
import utilerias.Tabla;

public class frmCatalogoSucursales extends javax.swing.JFrame {

    private int pag = 0;
    private final static int LIMITE = 10;
    private SucursalNegocio sucursalNegocio = new SucursalNegocio();

    public frmCatalogoSucursales() {
        initComponents();
        cargarTabla();
        ajustarColumnas();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnAtrasCatSucursles.setEnabled(false);
        this.cargarConfiguracionInicialTabla();
    }

    private void cargarTabla() {
        try {
            Tabla filtro = this.obtenerFiltrosTabla();
            List<SucursalDTO> Lista = this.sucursalNegocio.buscarSucursal(filtro);
            this.BorrarRegistrosTabla();
            this.AgregarRegistrosTabla(Lista);
            if (Lista.size() == 0 && pag > 0) {
                pag--; // Decrementa la página solo si hay más páginas
            }
            lblNumPagCatSucursal.setText("Página " + (pag + 1));
        } catch (NegocioException ex) {
            this.BorrarRegistrosTabla();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AgregarRegistrosTabla(List<SucursalDTO> lista) {
        if (lista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSucursales.getModel();
        lista.forEach(row -> {
            Object[] fila = new Object[5];
            String direccion = row.getCalle() + " " + row.getCiudad() + " " + row.getEstado() + " " + row.getCodigoPostal();
            fila[0] = row.getNombre();
            fila[1] = direccion;
            fila[2] = "Función";  // Texto del botón de función
            fila[3] = "Salas";    // Texto del botón de salas
            fila[4] = "Eliminar"; // Texto del botón de eliminar
            modeloTabla.addRow(fila);
        });
    }

    private void BorrarRegistrosTablaClientes() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSucursales.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int row = modeloTabla.getRowCount() - 1; row > -1; row--) {
                modeloTabla.removeRow(row);
            }
        }
    }

    private void cargarConfiguracionInicialTabla() {
        TableColumnModel modeloColumnas = this.tblSucursales.getColumnModel();

        // Configurar botón "Función"
        ActionListener onFuncionClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí manejas el evento de clic para el botón "Función"
                JOptionPane.showMessageDialog(null, "Botón Función presionado");
            }
        };
        modeloColumnas.getColumn(2).setCellRenderer(new JButtonRenderer("Función"));
        modeloColumnas.getColumn(2).setCellEditor(new JButtonCellEditor("Función", onFuncionClickListener));

        // Configurar botón "Salas"
        ActionListener onSalasClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí manejas el evento de clic para el botón "Salas"
                JOptionPane.showMessageDialog(null, "Botón Salas presionado");
            }
        };
        modeloColumnas.getColumn(3).setCellRenderer(new JButtonRenderer("Salas"));
        modeloColumnas.getColumn(3).setCellEditor(new JButtonCellEditor("Salas", onSalasClickListener));

        // Configurar botón "Eliminar"
        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar();
                } catch (NegocioException ex) {
                    Logger.getLogger(frmCatalogoSucursales.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        modeloColumnas.getColumn(4).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(4).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    
    private void eliminar() throws NegocioException {
        int id = this.getIdSeleccionadoTabla();
        sucursalNegocio.eliminar(id);
        cargarTabla();
    }

    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblSucursales.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblSucursales.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void BorrarRegistrosTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblSucursales.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int row = modeloTabla.getRowCount() - 1; row > -1; row--) {
                modeloTabla.removeRow(row);
            }
        }
    }

    private Tabla obtenerFiltrosTabla() {
        return new Tabla(this.LIMITE, this.pag, txtBuscar.getText());
    }

    private void ajustarColumnas() {
        // Ajustar el ancho de las columnas según el índice
        tblSucursales.getColumnModel().getColumn(0).setPreferredWidth(150); // Nombre
        tblSucursales.getColumnModel().getColumn(1).setPreferredWidth(300); // Dirección
        tblSucursales.getColumnModel().getColumn(2).setPreferredWidth(100); // Función (Botón)
        tblSucursales.getColumnModel().getColumn(3).setPreferredWidth(100); // Salas (Botón)
        tblSucursales.getColumnModel().getColumn(4).setPreferredWidth(100); // Eliminar (Botón)
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCatalogoSucursales = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSucursales = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnAtrasCatSucursles = new javax.swing.JButton();
        btnSiguienteCatSucursal = new javax.swing.JButton();
        lblNumPagCatSucursal = new javax.swing.JLabel();

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
        jPanelCatalogoSucursales.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 590, 25));

        jScrollPane1.setBackground(new java.awt.Color(153, 204, 255));

        tblSucursales.setBackground(new java.awt.Color(153, 204, 255));
        tblSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Direccion", "Funcion", "Salas", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblSucursales);

        jPanelCatalogoSucursales.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 800, 380));

        btnAgregar.setBackground(new java.awt.Color(153, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 100, 30));

        btnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Sucursales");
        jPanelCatalogoSucursales.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        btnAtrasCatSucursles.setText("Atras");
        btnAtrasCatSucursles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasCatSucurslesActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnAtrasCatSucursles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        btnSiguienteCatSucursal.setText("Siguiente");
        btnSiguienteCatSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteCatSucursalActionPerformed(evt);
            }
        });
        jPanelCatalogoSucursales.add(btnSiguienteCatSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 550, -1, -1));

        lblNumPagCatSucursal.setText("NumPag");
        jPanelCatalogoSucursales.add(lblNumPagCatSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, -1, -1));

        getContentPane().add(jPanelCatalogoSucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 600));

        pack();
        setLocationRelativeTo(null);
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAtrasCatSucurslesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasCatSucurslesActionPerformed
        if (pag == 0) {
            btnAtrasCatSucursles.setEnabled(false);
        } else {
            this.pag--;
            int impresion = pag + 1;
            lblNumPagCatSucursal.setText("Página " + impresion);
            this.cargarTabla();
        }
    }//GEN-LAST:event_btnAtrasCatSucurslesActionPerformed

    private void btnSiguienteCatSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteCatSucursalActionPerformed
        this.pag++;
        int imp = pag + 1;
        lblNumPagCatSucursal.setText("Página " + imp);
        this.cargarTabla();
        btnAtrasCatSucursles.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteCatSucursalActionPerformed

    /**
     * @param args the command line arguments
     */
    /*    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCatalogoSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCatalogoSucursales().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtrasCatSucursles;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSiguienteCatSucursal;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanelCatalogoSucursales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumPagCatSucursal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblSucursales;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
