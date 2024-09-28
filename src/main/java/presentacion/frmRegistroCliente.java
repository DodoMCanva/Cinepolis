package presentacion;

import dto.ClienteDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import negocio.ClienteNegocio;
import negocio.NegocioException;

/**
 *
 * @author Valeria
 */
public class frmRegistroCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmRegistroCliente
     */
    public frmRegistroCliente() {
        setSize(600, 380);
        setResizable(true);
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

        RegistroCliente = new javax.swing.JPanel();
        txtApMaternoRegistro = new javax.swing.JTextField();
        txtCorreoResgirstro = new javax.swing.JTextField();
        txtApPaternoRegitro = new javax.swing.JTextField();
        txtNumCelularRegistro = new javax.swing.JTextField();
        txtConfContraseñaRegistro = new javax.swing.JTextField();
        txtNombreRegistro = new javax.swing.JTextField();
        txtContraseñaRegistro = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        lblTituloRegistro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");
        setName("Registro"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RegistroCliente.setBackground(new java.awt.Color(58, 107, 203));
        RegistroCliente.setMinimumSize(new java.awt.Dimension(500, 340));
        RegistroCliente.setPreferredSize(new java.awt.Dimension(500, 340));
        RegistroCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtApMaternoRegistro.setBackground(new java.awt.Color(0, 51, 153));
        txtApMaternoRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtApMaternoRegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        txtApMaternoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApMaternoRegistroActionPerformed(evt);
            }
        });
        RegistroCliente.add(txtApMaternoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 170, 30));

        txtCorreoResgirstro.setBackground(new java.awt.Color(0, 51, 153));
        txtCorreoResgirstro.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreoResgirstro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        txtCorreoResgirstro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoResgirstroActionPerformed(evt);
            }
        });
        RegistroCliente.add(txtCorreoResgirstro, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 170, 30));

        txtApPaternoRegitro.setBackground(new java.awt.Color(0, 51, 153));
        txtApPaternoRegitro.setForeground(new java.awt.Color(255, 255, 255));
        txtApPaternoRegitro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        txtApPaternoRegitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApPaternoRegitroActionPerformed(evt);
            }
        });
        RegistroCliente.add(txtApPaternoRegitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 170, 30));

        txtNumCelularRegistro.setBackground(new java.awt.Color(0, 51, 153));
        txtNumCelularRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtNumCelularRegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        txtNumCelularRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumCelularRegistroActionPerformed(evt);
            }
        });
        RegistroCliente.add(txtNumCelularRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 170, 30));

        txtConfContraseñaRegistro.setBackground(new java.awt.Color(0, 51, 153));
        txtConfContraseñaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtConfContraseñaRegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        RegistroCliente.add(txtConfContraseñaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 170, 30));

        txtNombreRegistro.setBackground(new java.awt.Color(0, 51, 153));
        txtNombreRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreRegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        RegistroCliente.add(txtNombreRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 170, 30));

        txtContraseñaRegistro.setBackground(new java.awt.Color(0, 51, 153));
        txtContraseñaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseñaRegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true));
        RegistroCliente.add(txtContraseñaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 170, 30));

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        RegistroCliente.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        btnRegistrarse.setBackground(new java.awt.Color(153, 204, 255));
        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        RegistroCliente.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 120, 30));

        lblTituloRegistro.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloRegistro.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloRegistro.setText("Registro");
        RegistroCliente.add(lblTituloRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("campos obligatorios *");
        RegistroCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*");
        RegistroCliente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*");
        RegistroCliente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 10, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*");
        RegistroCliente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 10, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("*");
        RegistroCliente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 10, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*");
        RegistroCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 10, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*");
        RegistroCliente.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 10, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("*");
        RegistroCliente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 10, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*");
        RegistroCliente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 10, 20));
        RegistroCliente.add(dcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 180, 30));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fecha Nacimiento");
        RegistroCliente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre");
        RegistroCliente.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Apellido Paterno");
        RegistroCliente.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Apellido Materno");
        RegistroCliente.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Numero celular");
        RegistroCliente.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Correo");
        RegistroCliente.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Contraseña");
        RegistroCliente.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Confirmar contraseña");
        RegistroCliente.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        getContentPane().add(RegistroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 380));
        RegistroCliente.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtApMaternoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApMaternoRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApMaternoRegistroActionPerformed

    private void txtApPaternoRegitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApPaternoRegitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApPaternoRegitroActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmInicioSesionCliente regresar = new frmInicioSesionCliente();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        String nombre = txtNombreRegistro.getText();
        String apellidoPaterno = txtApPaternoRegitro.getText();
        String apellidoMaterno = txtApMaternoRegistro.getText();
        String celular = txtNumCelularRegistro.getText();
        String correo = txtCorreoResgirstro.getText();
        Date fechaNacimientoDate = dcFechaNacimiento.getDate();
        String contrasena = txtContraseñaRegistro.getText();
        String confContrasena = txtConfContraseñaRegistro.getText();

        // Validación de campos vacíos
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su nombre.");
            return;
        }
        if (apellidoPaterno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su apellido paterno.");
            return;
        }
        if (apellidoMaterno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su apellido materno.");
            return;
        }
        if (celular.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su número de celular.");
            return;
        }
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su correo electrónico.");
            return;
        }
        if (fechaNacimientoDate == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha de nacimiento válida.");
            return;
        }
        if (contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una contraseña.");
            return;
        }
        if (confContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, confirme su contraseña.");
            return;
        }

        // Validación de contraseñas
        if (!contrasena.equals(confContrasena)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

       
        // Convertir la fecha al formato MySQL (yyyy-MM-dd)
        SimpleDateFormat formatoMysql = new SimpleDateFormat("yyyy-MM-dd");
        String fechaMysql = formatoMysql.format(fechaNacimientoDate);

        // Crear un ClienteDTO
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(nombre);
        clienteDTO.setApellidoPaterno(apellidoPaterno);
        clienteDTO.setApellidoMaterno(apellidoMaterno);
        clienteDTO.setCelular(celular);
        clienteDTO.setCorreoElectronico(correo);
        clienteDTO.setFechaNacimiento(fechaMysql);
        clienteDTO.setContrasena(contrasena);

        try {
            // Llamar a la capa de negocio
            ClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);
            clienteNegocio.guardarCliente(clienteDTO);
            JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");
            
            this.dispose();
            
            frmInicioSesionCliente ini=new frmInicioSesionCliente();
            ini.setVisible(true);
            
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el cliente: " + e.getMessage());
        }


    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtNumCelularRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumCelularRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumCelularRegistroActionPerformed

    private void txtCorreoResgirstroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoResgirstroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoResgirstroActionPerformed

    /**
     * @param args the command line arguments
     */
    //  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*   try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistroCliente().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RegistroCliente;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnVolver;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblTituloRegistro;
    private javax.swing.JTextField txtApMaternoRegistro;
    private javax.swing.JTextField txtApPaternoRegitro;
    private javax.swing.JTextField txtConfContraseñaRegistro;
    private javax.swing.JTextField txtContraseñaRegistro;
    private javax.swing.JTextField txtCorreoResgirstro;
    private javax.swing.JTextField txtNombreRegistro;
    private javax.swing.JTextField txtNumCelularRegistro;
    // End of variables declaration//GEN-END:variables
}
