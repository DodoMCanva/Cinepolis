package presentacion;

import dto.PeliculaDTO;
import entidad.PeliculaEntidad;
import entidad.SucursalEntidad;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import negocio.NegocioException;
import negocio.PeliculaNegocio;
import persistencia.ConexionBD;
import persistencia.IConexionBD;
import persistencia.SucursalDAO;

/**
 *
 * @author Valeria
 */
public class frmCartelera extends javax.swing.JFrame {

    private SucursalDAO sucursalDAO;
    private PeliculaNegocio peliculaNegocio;

    public frmCartelera() {
        this(new ConexionBD(), new PeliculaNegocio()); // O usar objetos de conexión predeterminados
        initComponents();

    }

    // Constructor con parámetros
    public frmCartelera(IConexionBD conexionBD, PeliculaNegocio peliculaNegocio) {
        this.sucursalDAO = new SucursalDAO(conexionBD);
        this.peliculaNegocio = peliculaNegocio;
        initComponents();

        cargarCiudades(); // Llama al método para cargar ciudades
        agregarEventoSeleccionCiudad();
    }

    private void cargarCiudades() {
        try {
            List<String> ciudades = sucursalDAO.obtenerCiudades();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Seleccione una ciudad");
            for (String ciudad : ciudades) {
                model.addElement(ciudad);
            }
            cbxCiudad.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmCartelera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarEventoSeleccionCiudad() {
        cbxCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudadSeleccionada = (String) cbxCiudad.getSelectedItem();

                if (!ciudadSeleccionada.equals("Seleccione una ciudad")) {
                    cargarSucursales(ciudadSeleccionada);
                }
            }
        });
    }

    private void cargarSucursales(String ciudad) {
        try {
            List<SucursalEntidad> sucursales = sucursalDAO.obtenerPorCiudad(ciudad);
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Seleccione una sucursal");
            for (SucursalEntidad sucursal : sucursales) {
                model.addElement(sucursal.getNombre());
            }
            cbxSucursal.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmCartelera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Image convertirBytesAImagen(byte[] bytes) {
        try {
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // o una imagen por defecto
        }
    }

    private Image redimensionarImagen(Image img, int ancho, int alto) {
        return img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    }

    private void mostrarPeliculas(String sucursal, String ciudad) throws NegocioException {
        List<PeliculaDTO> peliculas = peliculaNegocio.buscarPeliculasPorSucursalYCiudad(sucursal, ciudad);
        if (peliculas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Image img = redimensionarImagen(convertirBytesAImagen(peliculas.get(i).getPoster()),
                        lblPelicula1.getWidth(), lblPelicula1.getHeight());
                switch (i) {
                    case 0:
                        lblPelicula1.setIcon(new ImageIcon(img));
                        lblPelicula1.repaint();
                        break;
                    case 1:
                        lblPelicula2.setIcon(new ImageIcon(img));
                        lblPelicula2.repaint();
                        break;
                    case 2:
                        lblPelicula3.setIcon(new ImageIcon(img));
                        lblPelicula3.repaint();
                        break;
                    case 3:
                        lblPelicula4.setIcon(new ImageIcon(img));
                        lblPelicula4.repaint();
                        break;
                    case 4:
                        lblPelicula5.setIcon(new ImageIcon(img));
                        lblPelicula5.repaint();
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay suficientes películas para mostrar.");
        }
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
        btnVolver = new javax.swing.JButton();
        lblTituloCartelera = new javax.swing.JLabel();
        lblPelicula4 = new javax.swing.JLabel();
        cbxCiudad = new javax.swing.JComboBox<>();
        cbxSucursal = new javax.swing.JComboBox<>();
        btnSiguiente = new javax.swing.JButton();
        lblPelicula3 = new javax.swing.JLabel();
        lblPelicula1 = new javax.swing.JLabel();
        lblPelicula5 = new javax.swing.JLabel();
        lblPelicula2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSeleccionar5 = new javax.swing.JButton();
        btnSeleccionar1 = new javax.swing.JButton();
        btnSeleccionar2 = new javax.swing.JButton();
        btnSeleccionar3 = new javax.swing.JButton();
        bntSeleccionar4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 107, 203));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(153, 204, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTituloCartelera.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTituloCartelera.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloCartelera.setText("Cartelera");
        jPanel1.add(lblTituloCartelera, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblPelicula4.setForeground(new java.awt.Color(255, 255, 255));
        lblPelicula4.setText("Pelicula4");
        lblPelicula4.setToolTipText("");
        lblPelicula4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPelicula4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 130, 160));

        cbxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciudad", "Item 2", "Item 3", "Item 4" }));
        cbxCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCiudadActionPerformed(evt);
            }
        });
        jPanel1.add(cbxCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 120, 25));

        cbxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal", "Item 2", "Item 3", "Item 4" }));
        cbxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(cbxSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 120, 25));

        btnSiguiente.setText("Siguiente");
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        lblPelicula3.setBackground(new java.awt.Color(204, 204, 204));
        lblPelicula3.setForeground(new java.awt.Color(255, 255, 255));
        lblPelicula3.setText("Pelicula3");
        lblPelicula3.setToolTipText("");
        lblPelicula3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPelicula3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 130, 160));

        lblPelicula1.setForeground(new java.awt.Color(255, 255, 255));
        lblPelicula1.setText("Pelicula1");
        lblPelicula1.setToolTipText("");
        lblPelicula1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPelicula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, 160));

        lblPelicula5.setForeground(new java.awt.Color(255, 255, 255));
        lblPelicula5.setText("Pelicula5");
        lblPelicula5.setToolTipText("");
        lblPelicula5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPelicula5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 130, 160));

        lblPelicula2.setForeground(new java.awt.Color(255, 255, 255));
        lblPelicula2.setText("Pelicula2");
        lblPelicula2.setToolTipText("");
        lblPelicula2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblPelicula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, 160));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, 25));

        btnAtras.setText("Atras");
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        btnSeleccionar5.setBackground(new java.awt.Color(255, 225, 0));
        btnSeleccionar5.setText("Seleccionar");
        jPanel1.add(btnSeleccionar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, -1, -1));

        btnSeleccionar1.setBackground(new java.awt.Color(255, 225, 0));
        btnSeleccionar1.setText("Seleccionar");
        jPanel1.add(btnSeleccionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        btnSeleccionar2.setBackground(new java.awt.Color(255, 225, 0));
        btnSeleccionar2.setText("Seleccionar");
        jPanel1.add(btnSeleccionar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        btnSeleccionar3.setBackground(new java.awt.Color(255, 225, 0));
        btnSeleccionar3.setText("Seleccionar");
        jPanel1.add(btnSeleccionar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, -1));

        bntSeleccionar4.setBackground(new java.awt.Color(255, 225, 0));
        bntSeleccionar4.setText("Seleccionar");
        jPanel1.add(bntSeleccionar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmInicioSesionCliente regresar = new frmInicioSesionCliente();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cbxCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCiudadActionPerformed
        String ciudadSeleccionada = cbxCiudad.getSelectedItem().toString();
        if (!ciudadSeleccionada.equals("Seleccione una ciudad")) {
            cargarSucursales(ciudadSeleccionada); // Cargar sucursales según la ciudad seleccionada
        }

    }//GEN-LAST:event_cbxCiudadActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String sucursal = cbxSucursal.getSelectedItem().toString();
        String ciudad = cbxCiudad.getSelectedItem().toString();

        try {
            mostrarPeliculas(sucursal, ciudad);
        } catch (NegocioException ex) {
            Logger.getLogger(frmCartelera.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSucursalActionPerformed
        String sucursalSeleccionada = cbxSucursal.getSelectedItem().toString();
        if (!sucursalSeleccionada.equals("Seleccione una sucursal")) {
            btnBuscar.setEnabled(true);
        } else {
            btnBuscar.setEnabled(false);
        }

    }//GEN-LAST:event_cbxSucursalActionPerformed

    /**
     * @param args the command line arguments
     */
    /* public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frmCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCartelera().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSeleccionar4;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar1;
    private javax.swing.JButton btnSeleccionar2;
    private javax.swing.JButton btnSeleccionar3;
    private javax.swing.JButton btnSeleccionar5;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxCiudad;
    private javax.swing.JComboBox<String> cbxSucursal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPelicula1;
    private javax.swing.JLabel lblPelicula2;
    private javax.swing.JLabel lblPelicula3;
    private javax.swing.JLabel lblPelicula4;
    private javax.swing.JLabel lblPelicula5;
    private javax.swing.JLabel lblTituloCartelera;
    // End of variables declaration//GEN-END:variables
}
