/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ec.edu.ups.modelo.Cliente;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johnny
 */
public class VistaCliente1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaCliente1
     */
    private Date fechactual;
    ControladorCliente ctCliente;
    DefaultTableModel dtm;
    Object[] o = new Object[9];

//    public VistaCliente1() {
//        initComponents();
//        ctCliente = new ControladorCliente();
//        ftFecha.setText(getFechaActual());
//        //llenar Codigo
//        jTextId.setText("" + ctCliente.llenarId());
//        dtm = (DefaultTableModel) jTable1.getModel();
//
//        llenarTabla();
//        cargaraJtext();
//    }

    public String getFechaActual() {
        fechactual = new Date();
        String vFechaOK = new SimpleDateFormat("dd/MM/yyyy").format(this.fechactual);
        return vFechaOK;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JButtonCrear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextId = new javax.swing.JTextField();
        jTextCedula = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ftFecha = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextCelular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFiltro = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cliente");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JButtonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/crearUsuario.png"))); // NOI18N
        JButtonCrear.setText("Registrar");
        JButtonCrear.setAlignmentX(0.1F);
        JButtonCrear.setIconTextGap(5);
        JButtonCrear.setMaximumSize(new java.awt.Dimension(10, 10));
        JButtonCrear.setMinimumSize(new java.awt.Dimension(10, 10));
        JButtonCrear.setPreferredSize(new java.awt.Dimension(171, 35));
        JButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCrearActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/actualizar.png"))); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.setIconTextGap(5);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/eliminar.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.setIconTextGap(5);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        jButton4.setText("Salir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(JButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 210, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(JButtonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextId.setEditable(false);
        jTextId.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdActionPerformed(evt);
            }
        });

        jTextCedula.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCedulaActionPerformed(evt);
            }
        });

        jTextApellido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoActionPerformed(evt);
            }
        });

        jTextNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Cédula:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("Apellido:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setText("Fecha de Registro:");

        ftFecha.setEditable(false);
        ftFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setText("Telefono:");

        jTextTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setText("Celular:");

        jTextCelular.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCelularActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setText("E-mail:");

        jTextEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setText("Direccion:");

        jTextDireccion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDireccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextDireccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jTextApellido)
                            .addComponent(jTextCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jTextId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jTextTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ftFecha, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(ftFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Cédula:");

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagenes/buscar.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jTable1.setBackground(new java.awt.Color(0, 153, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cedula", "Nombre", "Apellido", "Fecha", "Direccion", "Telefono", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdActionPerformed

    private void jTextCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCedulaActionPerformed

    private void jTextApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    private void jTextDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDireccionActionPerformed

    private void jTextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoActionPerformed

    private void jTextCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCelularActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        if (jTextId.equals("") || jTextCedula.equals("")
//                || jTextNombre.equals("") || jTextApellido.equals("")
//                || ftFecha.equals("") || jTextDireccion.equals("")
//                || jTextTelefono.equals("")
//                || jTextCelular.equals("") || jTextEmail.equals("")) {
//            JOptionPane.showMessageDialog(null, "Ingrese datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            dispose();
//        } else {
//            actualizarDatos();
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        if (ctCliente.eliminarCliente(Integer.parseInt(jTextId.getText())) == true) {
//            JOptionPane.showMessageDialog(null, "Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            dispose();
//        } else {
//            JOptionPane.showMessageDialog(null, "Datos Ocupando Otras Tablas ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCrearActionPerformed
        // TODO add your handling code here:
//        if (jTextId.equals("") || jTextCedula.equals("")
//                || jTextNombre.equals("") || jTextApellido.equals("")
//                || ftFecha.equals("") || jTextDireccion.equals("")
//                || jTextTelefono.equals("")
//                || jTextCelular.equals("") || jTextEmail.equals("")) {
//            JOptionPane.showMessageDialog(null, "Ingrese datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            dispose();
//        } else {
//            llenarCasillas();
//        }
    }//GEN-LAST:event_JButtonCrearActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
//        Cliente cl = new Cliente();
//        boolean c = ctCliente.valida(jTextFiltro.getText());
//        System.out.println(jTextFiltro.getText());
//
//        if (c == true) {
//            cl.setCli_cedula(jTextFiltro.getText());
//            dtm.setRowCount(0);
//            dtm = (DefaultTableModel) jTable1.getModel();
//            String ObjetoS[] = new String[6];
//            ctCliente.filtro(dtm, o, cl);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Cedula Incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//
//        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

//    private void actualizarDatos() {
//        Cliente cl = new Cliente();
//
//        cl.setCli_id(Integer.parseInt(jTextId.getText()));
//        cl.setCli_id(Integer.parseInt(jTextId.getText()));
//        boolean c = ctCliente.valida(jTextCedula.getText());
//        boolean e = ctCliente.validarEmail(jTextEmail.getText());
//        if (c == true) {
//            if (e = true) {
//                cl.setCli_correo_electronico(jTextEmail.getText());
//                cl.setCli_cedula(jTextCedula.getText());
//                cl.setCli_nombre(jTextNombre.getText());
//                cl.setCli_apellido(jTextApellido.getText());
//
//                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
//                String strFecha = ftFecha.getText();
//                Date fecha = null;
//                try {
//
//                    fecha = formatoDelTexto.parse(strFecha);
//
//                } catch (ParseException ex) {
//
//                    ex.printStackTrace();
//
//                }
//
//                java.sql.Date fin2 = new java.sql.Date(fecha.getTime());
//                cl.setCli_fecha_registro(fin2);
//                System.out.println(fin2);
//                cl.setCli_direccion(jTextDireccion.getText());
//                cl.setCli_tel_convencional(jTextTelefono.getText());
//                cl.setCli_celular(jTextCelular.getText());
//
//                if (ctCliente.actualizarCliente(cl) == true) {
//                    JOptionPane.showMessageDialog(null, "Actualizacion Correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                    dispose();
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "Datos Erroneos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Email invalido", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Cedula Incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//        }
//
//    }

//    private void llenarCasillas() {
//        Cliente cl = new Cliente();
//
//        cl.setCli_id(Integer.parseInt(jTextId.getText()));
//        boolean c = ctCliente.valida(jTextCedula.getText());
//        boolean e = ctCliente.validarEmail(jTextEmail.getText());
//        if (c == true) {
//            if (e == true) {
//                cl.setCli_correo_electronico(jTextEmail.getText());
//                cl.setCli_cedula(jTextCedula.getText());
//                cl.setCli_nombre(jTextNombre.getText());
//                cl.setCli_apellido(jTextApellido.getText());
//
//                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/mm/yyyy");
//                String strFecha = ftFecha.getText();
//                Date fecha = null;
//                try {
//
//                    fecha = formatoDelTexto.parse(strFecha);
//
//                } catch (ParseException ex) {
//
//                    ex.printStackTrace();
//
//                }
//
//                java.sql.Date fin2 = new java.sql.Date(fecha.getTime());
//                cl.setCli_fecha_registro(fin2);
//                cl.setCli_direccion(jTextDireccion.getText());
//                cl.setCli_tel_convencional(jTextTelefono.getText());
//                cl.setCli_celular(jTextCelular.getText());
//
//                if (ctCliente.anadirCliente(cl) == true) {
//                    JOptionPane.showMessageDialog(null, "Creacion Correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                    dispose();
//                    jTextCedula.setText("");
//                    jTextNombre.setText("");
//                    jTextApellido.setText("");
//                    ftFecha.setText("");
//                    jTextDireccion.setText("");
//                    jTextTelefono.setText("");
//                    jTextCelular.setText("");
//                    jTextEmail.setText("");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Datos Duplicados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Email invalido", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Cedula Incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//        }
//
//    }

//    public void llenarTabla() {
//        dtm.setRowCount(0);
//        dtm = (DefaultTableModel) jTable1.getModel();
//        String ObjetoS[] = new String[6];
//        ctCliente.llenarTabla(dtm, o);
//    }

//    private void cargaraJtext() {
//        jTable1.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent mouse_evt) {
//                JTable table = (JTable) mouse_evt.getSource();
//                Point point = mouse_evt.getPoint();
//                int row = table.rowAtPoint(point);
//                if (mouse_evt.getClickCount() == 2) {
//                    jTextId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
//                    jTextCedula.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
//                    jTextNombre.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
//                    jTextApellido.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
//                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
//                    String fecha = (jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
//                    Date d = null;
//                    try {
//                        d = formato.parse(fecha);
//                        formato.applyPattern("dd/mm/yyyy");
//                        String nv = formato.format(d);
//                        ftFecha.setText(nv);
//                        jTextDireccion.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
//                        jTextTelefono.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
//                        jTextCelular.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
//                        jTextEmail.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
//                    } catch (ParseException ex) {
//                        Logger.getLogger(VistaCliente1.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCrear;
    private javax.swing.JFormattedTextField ftFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCelular;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextFiltro;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables

}
