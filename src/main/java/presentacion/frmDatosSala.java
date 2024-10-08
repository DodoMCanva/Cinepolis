/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.SalaDTO;
import entidad.SalaEntidad;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.NegocioException;
import negocio.SalaNegocio;
import persistencia.SalaDAO;

/**
 *
 * @author cesar
 */
public class frmDatosSala extends javax.swing.JFrame {

    /**
     * Creates new form frmDatosSala
     */
    private int idSucursal;

    public frmDatosSala(int idSucursal) {
        this.idSucursal = idSucursal;
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtNombreSucursal = new javax.swing.JTextField();
        btnGuardarSucursal = new javax.swing.JButton();
        lblCapacidad = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(58, 107, 203));
        jPanel1.setMinimumSize(new java.awt.Dimension(540, 370));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 370));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Datos de la Sala");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 60, 30));

        lblCosto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(255, 255, 255));
        lblCosto.setText("Costo");
        jPanel1.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 50, 30));

        txtNombreSucursal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtNombreSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 260, 30));

        btnGuardarSucursal.setBackground(new java.awt.Color(153, 204, 255));
        btnGuardarSucursal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarSucursal.setText("Guardar");
        btnGuardarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 110, 30));

        lblCapacidad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCapacidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacidad.setText("Capacidad");
        jPanel1.add(lblCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 260, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSucursalActionPerformed
        // Recoger los datos del formulario
        String nombre = txtNombreSucursal.getText();
        String costoStr = jTextField2.getText();
        String capacidadStr = jTextField1.getText();

        // Validaciones básicas (opcional)
        if (nombre.isEmpty() || costoStr.isEmpty() || capacidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convertir los valores ingresados
            double costo = Double.parseDouble(costoStr);
            int capacidad = Integer.parseInt(capacidadStr);

            // Crear la entidad Sala
            SalaDTO sala = new SalaDTO();
            sala.setNombre(nombre);
            sala.setCosto((int) costo);
            sala.setCapacidad(capacidad);
            sala.setIdSucursal(this.idSucursal); // Método que trae el ID de la sucursal actual

            // Guardar en la base de datos
            SalaNegocio salaNegocio = new SalaNegocio(idSucursal);
            salaNegocio.guardar(sala, idSucursal);

            // Mensaje de éxito
            JOptionPane.showMessageDialog(this, "Sala guardada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos
            txtNombreSucursal.setText("");
            jTextField1.setText("");
            jTextField2.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El costo y la capacidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Error al guardar la sala: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NegocioException ex) {
            Logger.getLogger(frmDatosSala.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnGuardarSucursalActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarSucursal;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombreSucursal;
    // End of variables declaration//GEN-END:variables
}
