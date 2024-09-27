package presentacion;

/**
 *
 * @author Valeria
 */
public class frmMetodosPagos extends javax.swing.JFrame {

    /**
     * Creates new form frmMetodosPagos
     */
    public frmMetodosPagos() {
        setSize(300, 400);
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

        jPanelMetdosPago = new javax.swing.JPanel();
        btnPagoEfectivo = new javax.swing.JButton();
        btnPagoTarjeta1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        spTarjeta = new javax.swing.JSpinner();
        lblLogoTarjeta = new javax.swing.JLabel();
        spEfectivo = new javax.swing.JSpinner();
        lblLogoDinero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Metodo de pago");

        jPanelMetdosPago.setBackground(new java.awt.Color(58, 107, 203));
        jPanelMetdosPago.setMinimumSize(new java.awt.Dimension(350, 450));
        jPanelMetdosPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPagoEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnPagoEfectivo.setText("Efectivo");
        jPanelMetdosPago.add(btnPagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 270, 90));

        btnPagoTarjeta1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnPagoTarjeta1.setText("Tarjeta de credito / Debito");
        btnPagoTarjeta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoTarjeta1ActionPerformed(evt);
            }
        });
        jPanelMetdosPago.add(btnPagoTarjeta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 270, 90));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Métodos de pago");
        jPanelMetdosPago.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));
        jPanelMetdosPago.add(spTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        lblLogoTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tarjeta.png"))); // NOI18N
        jPanelMetdosPago.add(lblLogoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));
        jPanelMetdosPago.add(spEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        lblLogoDinero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dinero.png"))); // NOI18N
        jPanelMetdosPago.add(lblLogoDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMetdosPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMetdosPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagoTarjeta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoTarjeta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagoTarjeta1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagoEfectivo;
    private javax.swing.JButton btnPagoTarjeta1;
    private javax.swing.JPanel jPanelMetdosPago;
    private javax.swing.JLabel lblLogoDinero;
    private javax.swing.JLabel lblLogoTarjeta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spEfectivo;
    private javax.swing.JSpinner spTarjeta;
    // End of variables declaration//GEN-END:variables
}
