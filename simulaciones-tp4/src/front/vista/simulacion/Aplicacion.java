/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.vista.simulacion;

import objects.Controller;

/**
 *
 * @author nicolashefty
 */
public class Aplicacion {
    public static void main (String args[])
    {
        iniciarAplicacion();
    }
    
    private static void iniciarAplicacion()
    {
        Controller controlador;
        controlador = Controller.getInstance();
        controlador.mostrarVentana();
    }
}
