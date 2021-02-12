/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.controladorProveedor;
import ec.edu.ups.modelo.Proveedor;
import static ec.edu.ups.vista.Principal.jDesktopPane1;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class VistaProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaProveedor
     */
    private Date fecha;
    private VistaCompraProveedor vpr;
    private Principal principal;
    controladorProveedor ctProveedor;
    Proveedor proveedor;
    DefaultTableModel dtm;
    Object[] o = new Object[5];

    public VistaProveedor() {
        initComponents();
        ctProveedor = new controladorProveedor();
        txtCodigo.setText("" + ctProveedor.llenarId());
        txtFecha.setText(getFechaActual());
        dtm = (DefaultTableModel) tabProv.getModel();
        llenarTabla();
        clickearTabla();
    }

    public String getFechaActual() {
        fecha = new Date();
        String vFechaOK = new SimpleDateFormat("yyyy-MM-dd").format(this.fecha);
        return vFechaOK;
    }

    public void llenarTabla() {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tabProv.getModel();
        ctProveedor.llenarTabla(dtm, o);
    }

    public void buscarProv() {
        dtm.setRowCount(0);
        dtm = (DefaultTableModel) tabProv.getModel();
        String palabra = tBuscar.getText().trim();
        ctProveedor.filtroTabla(dtm, o, palabra);
    }

    private void clickearTabla() {
        tabProv.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouse_evt) {
                Point point = mouse_evt.getPoint();
                if (mouse_evt.getClickCount() == 2) {
                    txtCodigo.setText(tabProv.getValueAt(tabProv.getSelectedRow(), 0).toString());
                    txtRuc.setText(tabProv.getValueAt(tabProv.getSelectedRow(), 1).toString());
                    txtFecha.setText(tabProv.getValueAt(tabProv.getSelectedRow(), 2).toString());
                    txtNombre.setText(tabProv.getValueAt(tabProv.getSelectedRow(), 3).toString());
                    txtCorreo.setText(tabProv.getValueAt(tabProv.getSelectedRow(), 4).toString());
                }
            }
        });
    }

    private void limpiarTexto() {
        txtCodigo.setText("" + ctProveedor.llenarId());
        txtFecha.setText(getFechaActual());
        txtNombre.setText("");
        txtRuc.setText("");
        txtCorreo.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblRazon = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnActuali = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        tBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProv = new javax.swing.JTable();

        setClosable(true);
        setTitle("Gestión de Proveedores");

        lblCodigo.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setFocusable(false);

        jLabel1.setText("RUC:");

        jLabel2.setText("Fecha de Registro:");

        txtFecha.setEditable(false);

        lblRazon.setText("Correo electrónico:");

        lblNombre.setText("Razón Social:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnActuali.setText("Actualizar");
        btnActuali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiActionPerformed(evt);
            }
        });

        bBuscar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/buscar.png"))); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        bBuscar.setIconTextGap(0);
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        tabProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "RUC", "Fecha Registro", "Razón Social", "Correo electrónico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabProv);
        if (tabProv.getColumnModel().getColumnCount() > 0) {
            tabProv.getColumnModel().getColumn(0).setResizable(false);
            tabProv.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRazon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCodigo)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActuali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActuali, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRazon)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        txtCodigo.setText("" + ctProveedor.llenarId());
        txtFecha.setText(getFechaActual());
        if (txtRuc.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacíos", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } else {

            proveedor = new Proveedor();
            proveedor.setCodigo(Integer.parseInt(txtCodigo.getText()));
            proveedor.setRuc(txtRuc.getText().trim());
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = txtFecha.getText();
            Date fecha = null;
            try {
                fecha = formatoDelTexto.parse(strFecha);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            java.sql.Date fin2 = new java.sql.Date(fecha.getTime());
            proveedor.setFecha_registro(fin2);
            proveedor.setRazon_social(txtNombre.getText().trim());
            proveedor.setCorreo(txtCorreo.getText().trim());
            if (ctProveedor.crearProveedor(proveedor) == true) {
                JOptionPane.showMessageDialog(this, "Se ha creado el proveedor",
                        "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear proveedor",
                        "Incorrecto", JOptionPane.WARNING_MESSAGE);
            }
        }
        limpiarTexto();
        llenarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtRuc.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacíos", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            if (ctProveedor.eliminarProveedor(Integer.parseInt(txtCodigo.getText())) == true) {
                JOptionPane.showMessageDialog(this, "Se ha eliminado el proveedor",
                        "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar proveedor",
                        "Incorrecto", JOptionPane.WARNING_MESSAGE);
            }
        }
        limpiarTexto();
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiActionPerformed
        // TODO add your handling code here:
        if (txtRuc.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty()
                || txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacíos", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } else {

            proveedor = new Proveedor();
            proveedor.setCodigo(Integer.parseInt(txtCodigo.getText()));
            proveedor.setRuc(txtRuc.getText());
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
            String strFecha = txtFecha.getText();
            Date fecha = null;
            try {

                fecha = formatoDelTexto.parse(strFecha);

            } catch (ParseException ex) {

                ex.printStackTrace();

            }

            java.sql.Date fin2 = new java.sql.Date(fecha.getTime());
            proveedor.setFecha_registro(fin2);
            proveedor.setRazon_social(txtNombre.getText());
            proveedor.setCorreo(txtCorreo.getText());
            if (ctProveedor.actualizarProveedor(proveedor) == true) {
                JOptionPane.showMessageDialog(this, "Se ha editado el proveedor",
                        "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al editar proveedor",
                        "Incorrecto", JOptionPane.WARNING_MESSAGE);
            }
        }
        limpiarTexto();
        llenarTabla();
    }//GEN-LAST:event_btnActualiActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTexto();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        buscarProv();
    }//GEN-LAST:event_bBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton btnActuali;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRazon;
    private javax.swing.JTextField tBuscar;
    private javax.swing.JTable tabProv;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
