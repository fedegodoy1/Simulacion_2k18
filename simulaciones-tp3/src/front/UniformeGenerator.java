/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front;
import javax.swing.JOptionPane;
import objects.*;

/**
 *
 * @author federico
 */
public class UniformeGenerator extends javax.swing.JFrame {

    Controller controller;
    
    public UniformeGenerator(Controller cont) {
        controller = cont;
        initComponents();
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_desde = new javax.swing.JTextField();
        txt_hasta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_cant_num = new javax.swing.JTextField();
        btn_comenzar = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese su intervalo de números aleatorios");

        jLabel2.setText("Desde");

        jLabel3.setText("Hasta");

        txt_desde.setText("0");

        txt_hasta.setText("1");

        jLabel4.setText("Cantidad de números a generar");

        btn_comenzar.setText("Comenzar");
        btn_comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comenzarActionPerformed(evt);
            }
        });

        btn_back.setText("Volver");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_comenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(txt_cant_num, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_back)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txt_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_cant_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btn_comenzar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_comenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comenzarActionPerformed
        if(validInput())
        {
        this.setVisible(false);
        controller.randomFloatUniforme(
                Float.parseFloat(txt_desde.getText()), 
                Float.parseFloat(txt_hasta.getText()),                
                Integer.parseInt(txt_cant_num.getText()) );
        }
    }//GEN-LAST:event_btn_comenzarActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.setVisible(false);
        controller.showMenu();
    }//GEN-LAST:event_btn_backActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_comenzar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txt_cant_num;
    private javax.swing.JTextField txt_desde;
    private javax.swing.JTextField txt_hasta;
    // End of variables declaration//GEN-END:variables

    private boolean validInput() 
    {
        //Sigma tiene q ser positivo
        if(txt_desde != null &&
                txt_desde.getText() != null)
        {
            String desde = txt_desde.getText();
            if (desde.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Ingrese extremo inferior (Desde)", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            try
            {
                float desdeFloat = Float.parseFloat(desde);
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(this, "Extremo inferior debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ingrese extremo inferior", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Sigma tiene q ser positivo
        if(txt_hasta != null &&
                txt_hasta.getText() != null)
        {
            String hasta = txt_hasta.getText();
            if (hasta.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Ingrese extremo superior (Hasta)", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            try
            {
                float hastaFloat = Float.parseFloat(hasta);
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(this, "Extremo superior debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ingrese extremo superior", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        float desdeFloat = Float.parseFloat(txt_desde.getText());
        float hastaFloat = Float.parseFloat(txt_hasta.getText());
        if (desdeFloat >= hastaFloat)
        {
            JOptionPane.showMessageDialog(this, "Desde debe ser menor a Hasta", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //Sigma tiene q ser positivo
        if(txt_cant_num != null &&
                txt_cant_num.getText() != null)
        {
            String cantNum = txt_cant_num.getText();
            if (cantNum.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Ingrese cantidad de numeros", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            try
            {
                float cantFloat = Float.parseFloat(cantNum);
                
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(this, "Ingrese cantidad de numeros valida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ingrese cantidad de numeros", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}