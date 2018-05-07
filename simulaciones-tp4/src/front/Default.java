/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front;

import objects.Controller;

/**
 *
 * @author gabrielneil
 */
public class Default extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    Controller controller;
    int cantRondas = 0, puntosPrimerTiro, puntosSegundoTiro, valorASuperar;

    public Default(Controller cont) {
        controller = cont;
        initComponents();
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cantSim_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        desde_txt = new javax.swing.JTextField();
        hasta_txt = new javax.swing.JTextField();
        comenzar_btn = new javax.swing.JButton();
        salir_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cantSim_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantSim_txtActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese la cantidad de simulaciones:");

        jLabel2.setText("Ingrese el desde:");

        jLabel3.setText("Ingrese el hasta:");

        comenzar_btn.setText("Comenzar");
        comenzar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzar_btnActionPerformed(evt);
            }
        });

        salir_btn.setText("Salir");
        salir_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir_btnActionPerformed(evt);
            }
        });

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hasta_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desde_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantSim_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(salir_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comenzar_btn)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantSim_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(desde_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hasta_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comenzar_btn)
                    .addComponent(salir_btn)
                    .addComponent(jButton1))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cantSim_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantSim_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantSim_txtActionPerformed

    private void salir_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir_btnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_salir_btnActionPerformed

    private void comenzar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzar_btnActionPerformed
        this.setVisible(false);
        comenzar();
    }//GEN-LAST:event_comenzar_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        controller.showEdition();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantSim_txt;
    private javax.swing.JButton comenzar_btn;
    private javax.swing.JTextField desde_txt;
    private javax.swing.JTextField hasta_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton salir_btn;
    // End of variables declaration//GEN-END:variables

    public void setValoresEspecificos(int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        this.cantRondas = cantRondas;
        this.puntosPrimerTiro = puntosPrimerTiro;
        this.puntosSegundoTiro = puntosSegundoTiro;
        this.valorASuperar = valorASuperar;
    }
    
    public void comenzar(){
         if ((cantSim_txt.getText() != "" && desde_txt.getText() != "" && hasta_txt.getText() != "") && (Integer.parseInt(cantSim_txt.getText()) > 0 && Integer.parseInt(desde_txt.getText()) > 0 && Integer.parseInt(hasta_txt.getText()) > 0) && (Integer.parseInt(desde_txt.getText()) < Integer.parseInt(hasta_txt.getText())) && (Integer.parseInt(hasta_txt.getText()) < Integer.parseInt(cantSim_txt.getText()))) {
            this.setVisible(false);
            if (cantRondas == 0) {
                controller.iniciar(Integer.parseInt(cantSim_txt.getText()), Integer.parseInt(desde_txt.getText()), Integer.parseInt(hasta_txt.getText()));
            } else {
                controller.iniciarEspecífico(Integer.parseInt(cantSim_txt.getText()), Integer.parseInt(desde_txt.getText()), Integer.parseInt(hasta_txt.getText()), cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
            }
        }
    }
  
}
