/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import front.Main;
import front.Default;
import front.Edition;
import front.vista.simulacion.Aplicacion;
import front.vista.simulacion.SimulacionMontecarlo;
import front.vista.simulacion.SimulacionMontecarloSetear;

/**
 *
 * @author nicolashefty
 */
public class Controller {
    
    private static Controller controller;
    static Main inicio;
    static Default defaul;
    static Calculator calculator;
    private SimulacionMontecarlo tablaSimulacion;
    private SimulacionMontecarloSetear tablaSimulacionSet;
    static Edition edition;
    
    protected Controller(Main menu) {
        inicio = menu;
        defaul = new Default(this);
        calculator = new Calculator();
        edition = new Edition();
        tablaSimulacionSet = new SimulacionMontecarloSetear(this);
    }
    
    private Controller ()
    {
        setLookAndFeel();
        tablaSimulacionSet = new SimulacionMontecarloSetear(this);
    }
    
    public static Controller getInstance(Main menu) {
        if (controller == null) {
            controller = new Controller(menu);
        } else {
            controller.setMain(menu);
        }
        
        return controller;
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
    
    public void setMain(Main in) {
        inicio = in;
    }
    
    public Main getInicio() {
        return inicio;
    }
    
    public void iniciar(int cantSim, int desde, int hasta) {
        tablaSimulacion = new SimulacionMontecarlo(cantSim, desde, hasta, this);
        tablaSimulacion.setVisible(true);
    }
    
    
    public void iniciarEspecífico(int cantSim, int desde, int hasta, int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        tablaSimulacion = new SimulacionMontecarlo(cantSim, desde, hasta, this, cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
        tablaSimulacion.setVisible(true);
    }
    
    public void selectedDefault() {
        inicio.setVisible(false);
        this.defaul.setVisible(true);
    }
    
    public void selectedSet() {
        this.tablaSimulacionSet.setVisible(true);
    }
    
    public void showDefault() {
        defaul.setVisible(true);
    }
    
    public void showMenu() {
        inicio.setVisible(true);
    }
    
    public void showEdition() {
        edition.setController(controller);
        edition.setVisible(true);
    }

    public void setValoresEspecificos(int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        defaul.setVisible(true);
        defaul.setValoresEspecificos(cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
        //tablaSimulacion = new SimulacionMontecarlo(cantSim, desde, hasta, this);
        //iniciarEspecífico();
    }
    public void setEspecificos(int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        defaul.setValoresEspecificos(cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
        //tablaSimulacion = new SimulacionMontecarlo(cantSim, desde, hasta, this);
        //iniciarEspecífico();
    }
}
