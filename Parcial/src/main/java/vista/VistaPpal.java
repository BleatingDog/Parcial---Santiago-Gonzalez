/*
* Parcial programación
* Santiago González Gálvez - 202183392
* John Freddy Belalcázar - 202182464
* Profesor: Luis Yovany Romo Portilla
*/

package vista;

import controlador.GestorVistaPpal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VistaPpal extends javax.swing.JFrame {

    private final DefaultTableModel modeloTablaHistorico = new DefaultTableModel();
    private final DefaultTableModel modeloTablaPronostico = new DefaultTableModel();
    private JTableHeader th;
    private JTableHeader th2;
    
    public VistaPpal() {
        llenarColumnasHistorico();
        llenarColumnasPronostico();
        initComponents();
        diseñoTablaHistórico();
        diseñoTablaPronostico();
        GestorVistaPpal gestorPpal = new GestorVistaPpal(this);
        setVisible(true);
        setTitle("Pronóstico de ventas");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void anadirFilaTablaHistorico(Object[] fila) {
        modeloTablaHistorico.addRow(fila);
    }
    
    public void anadirFilaTablaPronostico(Object[] fila) {
        modeloTablaPronostico.addRow(fila);
    }
    
    public final void llenarColumnasHistorico(){
        modeloTablaHistorico.addColumn("Año");
        modeloTablaHistorico.addColumn("Cantidad de ventas");
        modeloTablaHistorico.addColumn("");
        modeloTablaHistorico.addColumn("");
    }
    
    public final void llenarColumnasPronostico(){
        modeloTablaPronostico.addColumn("Año");
        modeloTablaPronostico.addColumn("Pronóstico de ventas");
    }
    
    public final void diseñoTablaHistórico(){
        
        //Fuente de cabecera
        th = tablaHistorico.getTableHeader();
        Font fuente = new Font("Agency FB", Font.BOLD, 22);
        th.setFont(fuente);
        
        //Color cabecera
        tablaHistorico.setOpaque(false);
        Color colorCabecera = new Color(204, 204, 204);
        th.setBackground(colorCabecera);
        
        //Color fondo
        Color colorFondo = new Color(255, 255, 255);
        scroll1.getViewport().setBackground(colorFondo);
    }
    
    public final void diseñoTablaPronostico(){
        
        //Fuente de cabecera
        th2 = tablaPronostico.getTableHeader();
        Font fuente = new Font("Agency FB", Font.BOLD, 22);
        th2.setFont(fuente);
        
        //Color cabecera
        tablaPronostico.setOpaque(false);
        Color colorCabecera = new Color(204, 204, 204);
        th2.setBackground(colorCabecera);
        
        //Color fondo
        Color colorFondo = new Color(255, 255, 255);
        scroll2.getViewport().setBackground(colorFondo);
    }

    
    public void addBtnAgregarListener(MouseListener listenerBoton){
        btnAgregar.addMouseListener(listenerBoton);
    }
    
    public void addBtnBorrarListener(MouseListener listenerBoton){
        btnBorrar.addMouseListener(listenerBoton);
    }
    
    public void addBtnModificarListener(MouseListener listenerBoton){
        btnModificar.addMouseListener(listenerBoton);
    }
    
    public void addBtnNuevoListener(MouseListener listenerBoton){
        btnNuevo.addMouseListener(listenerBoton);
    }
    
    public void addBtnAceptarListener(MouseListener listenerBoton){
        btnAceptar.addMouseListener(listenerBoton);
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }
    
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JTable getTablaHistorico() {
        return tablaHistorico;
    }

    public void setTablaHistorico(JTable tablaHistorico) {
        this.tablaHistorico = tablaHistorico;
    }

    public JTable getTablaPronostico() {
        return tablaPronostico;
    }

    public void setTablaPronostico(JTable tablaPronostico) {
        this.tablaPronostico = tablaPronostico;
    }

    public JTextField getTxtAnios() {
        return txtAnios;
    }

    public void setTxtAnios(JTextField txtAnios) {
        this.txtAnios = txtAnios;
    }

    public JTextField getTxtCantidadVenta() {
        return txtCantidadVenta;
    }

    public void setTxtCantidadVenta(JTextField txtCantidadVenta) {
        this.txtCantidadVenta = txtCantidadVenta;
    }

    public JTextField getTxtPromedio() {
        return txtPromedio;
    }

    public void setTxtPromedio(JTextField txtPromedio) {
        this.txtPromedio = txtPromedio;
    }
    public DefaultTableModel getModeloTablaHistorico(){
        return modeloTablaHistorico;
    }
    
    public DefaultTableModel getModeloTablaPronostico(){
        return modeloTablaPronostico;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public void setTxtAnio(JTextField txtAnio) {
        this.txtAnio = txtAnio;
    }
    
    public int filaSeleccionada() {
        return tablaHistorico.getSelectedRow();
    }
    public int anioSeleccionado(int fila) {
        return (int) tablaHistorico.getValueAt(fila,0);
    }
    public long ventaAnioSeleccionado(int fila) {
        return (long) tablaHistorico.getValueAt(fila,1);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAnios = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        tablaHistorico = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        scroll2 = new javax.swing.JScrollPane();
        tablaPronostico = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPromedio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad de venta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Año");

        txtAnio.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadVenta)
                    .addComponent(txtAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Años a pronosticar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtAnios, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAnios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 350, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar año");

        btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar año");

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificar.setText("Modificar año");

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo pronóstico");

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrar)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnAceptar))
                .addGap(12, 12, 12)
                .addComponent(btnNuevo)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 340, 200));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histórico de ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tablaHistorico.setModel(modeloTablaHistorico);
        scroll1.setViewportView(tablaHistorico);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 700, 290));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pronóstico de ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tablaPronostico.setModel(modeloTablaPronostico);
        scroll2.setViewportView(tablaPronostico);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Promedio de variación");

        txtPromedio.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, 300));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 840, 750, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JTable tablaHistorico;
    private javax.swing.JTable tablaPronostico;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAnios;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtPromedio;
    // End of variables declaration//GEN-END:variables
}
