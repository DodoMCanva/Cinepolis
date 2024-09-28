
package presentacion;

import dto.ClienteDTO;
import javax.swing.JOptionPane;
import negocio.ClienteNegocio;
import negocio.NegocioException;

/**
 *
 * @author Valeria
 */
public class frmInicioSesionCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmInicioSesion
     */
    public frmInicioSesionCliente() {
        setSize(350, 450);
        setResizable(false);
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

        InicioSesion = new javax.swing.JPanel();
        txtContrasena = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnRegistrarce = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        lblTituloPregunta = new javax.swing.JLabel();
        lblinicioLogo = new javax.swing.JLabel();
        lblTituloNombreInicio = new javax.swing.JLabel();
        lblTituloContrasenaInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio sesion");

        InicioSesion.setBackground(new java.awt.Color(58, 107, 203));
        InicioSesion.setMinimumSize(new java.awt.Dimension(350, 450));
        InicioSesion.setPreferredSize(new java.awt.Dimension(350, 450));
        InicioSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContrasena.setBackground(new java.awt.Color(51, 51, 51));
        txtContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(255, 255, 255));
        txtContrasena.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255))));
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });
        InicioSesion.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 220, 30));

        txtUsuario.setBackground(new java.awt.Color(51, 51, 51));
        txtUsuario.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255))));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        InicioSesion.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 220, 30));

        btnRegistrarce.setBackground(new java.awt.Color(153, 204, 255));
        btnRegistrarce.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarce.setText("Registrarse");
        btnRegistrarce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarceActionPerformed(evt);
            }
        });
        InicioSesion.add(btnRegistrarce, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 120, 30));

        btnIniciarSesion.setBackground(new java.awt.Color(153, 204, 255));
        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        InicioSesion.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 120, 30));

        lblTituloPregunta.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPregunta.setText("¿Aún no esta registrado?");
        InicioSesion.add(lblTituloPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        lblinicioLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoinicio.png"))); // NOI18N
        InicioSesion.add(lblinicioLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 90, 90));

        lblTituloNombreInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTituloNombreInicio.setText("Correo");
        InicioSesion.add(lblTituloNombreInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        lblTituloContrasenaInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTituloContrasenaInicio.setText("Contraseña");
        InicioSesion.add(lblTituloContrasenaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void btnRegistrarceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarceActionPerformed
        frmRegistroCliente ir = new frmRegistroCliente();
        ir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarceActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
                                                   
    String correo = txtUsuario.getText();
    String contrasena = txtContrasena.getText();

    // Validación de campos vacíos
    if (correo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese su correo electrónico.");
        return;
    }
    if (contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese su contraseña.");
        return;
    }

    // Crear un ClienteDTO para el inicio de sesión
    ClienteDTO clienteDTO = new ClienteDTO();
    clienteDTO.setCorreoElectronico(correo);
    clienteDTO.setContrasena(contrasena);

    try {
        // Llamar a la capa de negocio para verificar el inicio de sesión
        ClienteNegocio clienteNegocio = new ClienteNegocio();
        ClienteDTO clienteAutenticado = clienteNegocio.autenticarCliente(clienteDTO);
        
        if (clienteAutenticado != null) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
            // Aquí puedes abrir la siguiente pantalla o realizar otras acciones
            this.dispose();
            frmCartelera crte= new frmCartelera();
            crte.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.");
        }
    } catch (NegocioException e) {
        JOptionPane.showMessageDialog(this, "Error al iniciar sesión: " + e.getMessage());
    }


    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicioSesionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicioSesionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InicioSesion;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarce;
    private javax.swing.JLabel lblTituloContrasenaInicio;
    private javax.swing.JLabel lblTituloNombreInicio;
    private javax.swing.JLabel lblTituloPregunta;
    private javax.swing.JLabel lblinicioLogo;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
