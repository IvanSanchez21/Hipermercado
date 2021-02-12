/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.awt.Dimension;

/**
 *
 * @author José A. Ramírez C.
 */
public class VistaAnuladora extends javax.swing.JInternalFrame {

    private AnularFactura af;
    private Principal principal;
    private VistaPeticion vp;

    /**
     * Creates new form VistaAnuladora
     */
    public VistaAnuladora(String tipo) {
        if (tipo.equalsIgnoreCase("f")) {
            initComponents();
            bAnulacion.setVisible(false);
        } else {
            initComponents();

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

        bAnulacion = new javax.swing.JButton();
        bPeticion = new javax.swing.JButton();

        setClosable(true);

        bAnulacion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        bAnulacion.setText("Anular Factura");
        bAnulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnulacionActionPerformed(evt);
            }
        });

        bPeticion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        bPeticion.setText("Petición para Anulación");
        bPeticion.setBorderPainted(false);
        bPeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPeticionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPeticion)
                    .addComponent(bAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnulacionActionPerformed
        if (af == null || af.isVisible() == false) {
            af = new AnularFactura();
            af.setVisible(true);
            principal.jDesktopPane1.add(af);
            Dimension desktopSize = principal.jDesktopPane1.getSize();
            Dimension frameSize = af.getSize();
            af.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
            af.toFront();
        } else {
            af.toFront();
        }
    }//GEN-LAST:event_bAnulacionActionPerformed

    private void bPeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPeticionActionPerformed
        if (vp == null || vp.isVisible() == false) {
            vp = new VistaPeticion();
            vp.setVisible(true);
            principal.jDesktopPane1.add(vp);
            Dimension desktopSize = principal.jDesktopPane1.getSize();
            Dimension frameSize = vp.getSize();
            vp.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);
            vp.toFront();
        } else {
            vp.toFront();
        }
    }//GEN-LAST:event_bPeticionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnulacion;
    private javax.swing.JButton bPeticion;
    // End of variables declaration//GEN-END:variables
}
