package presentacion;

import dto.FuncionDTO;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.FuncionNegocio;
import negocio.NegocioException;
import negocio.SalaNegocio;
import persistencia.PersistenciaException;
import persistencia.SalaDAO;

public class frmDatosFunciones extends javax.swing.JFrame {

    private int idSucursal;

    public frmDatosFunciones(int idSucursal) {
        initComponents();
        this.idSucursal = idSucursal;

    }

    public void rellenarComboBox() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        lblTituloClasifi = new javax.swing.JLabel();
        lblTituloGenero = new javax.swing.JLabel();
        cboxPelicula = new javax.swing.JComboBox<>();
        cbxSala = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        btnGuardarDatosPeli1 = new javax.swing.JButton();
        txtminutoi = new javax.swing.JTextField();
        lblTituloGenero1 = new javax.swing.JLabel();
        txthorai = new javax.swing.JTextField();
        lblTituloGenero2 = new javax.swing.JLabel();
        txtminutof = new javax.swing.JTextField();
        txthoraf = new javax.swing.JTextField();
        lblTituloGenero3 = new javax.swing.JLabel();
        lblTituloGenero4 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lblTituloClasifi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloClasifi.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloClasifi.setText("Pelicula");
        jPanel1.add(lblTituloClasifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 90, 30));

        lblTituloGenero.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGenero.setText(":");
        jPanel1.add(lblTituloGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 10, 30));

        cboxPelicula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxPelicula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "B15", "C", "R" }));
        cboxPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPeliculaActionPerformed(evt);
            }
        });
        jPanel1.add(cboxPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 280, 30));

        cbxSala.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terror", "Drama", "Comedia", "Ciencia Ficcion", "Musical" }));
        jPanel1.add(cbxSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 280, 30));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Funcion");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btnGuardarDatosPeli1.setBackground(new java.awt.Color(153, 204, 255));
        btnGuardarDatosPeli1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarDatosPeli1.setText("Guardar");
        btnGuardarDatosPeli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosPeli1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarDatosPeli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));
        jPanel1.add(txtminutoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 30, -1));

        lblTituloGenero1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloGenero1.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGenero1.setText("Fin");
        jPanel1.add(lblTituloGenero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 60, 30));
        jPanel1.add(txthorai, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 30, -1));

        lblTituloGenero2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloGenero2.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGenero2.setText(":");
        jPanel1.add(lblTituloGenero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 10, 30));
        jPanel1.add(txtminutof, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 30, -1));
        jPanel1.add(txthoraf, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 30, -1));

        lblTituloGenero3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloGenero3.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGenero3.setText("Sala");
        jPanel1.add(lblTituloGenero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 60, 30));

        lblTituloGenero4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTituloGenero4.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloGenero4.setText("Inicio");
        jPanel1.add(lblTituloGenero4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 60, 30));
        jPanel1.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmCatalogoFunciones regresar = new frmCatalogoFunciones(idSucursal);
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cboxPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxPeliculaActionPerformed

    private void btnGuardarDatosPeli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosPeli1ActionPerformed
        int idPelicula = (int) cbxSala.getSelectedItem();
        int idSala = (int) cbxSala.getSelectedItem();
        String horai = txthorai.getText();
        String minutosi = txtminutoi.getText(); 
        String horaI = horai + ":" + minutosi + ":00";
        LocalTime horaIt = LocalTime.parse(horaI);
        String horaf = txthoraf.getText();
        String minutosf = txtminutof.getText(); 
        String horaF = horaf + ":" + minutosf + ":00";
        LocalTime horaFt = LocalTime.parse(horaF);
        if (horai.isEmpty() || horaf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            SimpleDateFormat formatoMysql = new SimpleDateFormat("yyyy-MM-dd");
        String fechaMysql = formatoMysql.format(dcFecha);
            SalaDAO d = new SalaDAO();
            int costo = (int) d.obtenerCosto(idSala);
            FuncionDTO funcion = new FuncionDTO();
            funcion.setCosto((int) costo);
            funcion.setIdSucursal(this.idSucursal); 
            funcion.setIdPelicula(idPelicula); 
            funcion.setIdSala(idSala);
            funcion.setFechaHoraRegistro(fechaMysql);
            FuncionNegocio funcionNegocio = new FuncionNegocio(idSucursal);
            funcionNegocio.guardar(funcion, idSucursal, idPelicula, idSala);
            JOptionPane.showMessageDialog(this, "Funcion guardada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El costo y la capacidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Error al guardar la sala: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (PersistenciaException ex) {
            Logger.getLogger(frmDatosFunciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(frmDatosFunciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarDatosPeli1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarDatosPeli1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboxPelicula;
    private javax.swing.JComboBox<String> cbxSala;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloClasifi;
    private javax.swing.JLabel lblTituloGenero;
    private javax.swing.JLabel lblTituloGenero1;
    private javax.swing.JLabel lblTituloGenero2;
    private javax.swing.JLabel lblTituloGenero3;
    private javax.swing.JLabel lblTituloGenero4;
    private javax.swing.JTextField txthoraf;
    private javax.swing.JTextField txthorai;
    private javax.swing.JTextField txtminutof;
    private javax.swing.JTextField txtminutoi;
    // End of variables declaration//GEN-END:variables
}
