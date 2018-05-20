/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import front.vista.simulacion.SimulacionMontecarloSetear;

/**
 *
 * @author nicolashefty
 */
public class Controller {
    
    private static Controller controller;
    static Calculator calculator;
    private final SimulacionMontecarloSetear tablaSimulacionSet;
    
    private Controller ()
    {
        setLookAndFeel();
        tablaSimulacionSet = new SimulacionMontecarloSetear(this);
    }
    
    public static Controller getInstance() 
    {
        if (controller == null) {
            controller = new Controller();
        }         
        return controller;
    }
    
    public void mostrarVentana()
    {
        tablaSimulacionSet.setLocationRelativeTo(null);
        tablaSimulacionSet.setVisible(true);
    }
    
    
    private void setLookAndFeel() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimulacionMontecarloSetear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulacionMontecarloSetear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulacionMontecarloSetear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulacionMontecarloSetear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
