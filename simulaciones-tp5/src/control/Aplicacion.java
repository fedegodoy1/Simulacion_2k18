/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author heftyn
 */
public class Aplicacion 
{
    public static void main(String args[])
    {
        System.out.println("Hello.");
        //Crear controlador.
        ControladorSimulacion controlador = new ControladorSimulacion();
        controlador.mostrarVentanaPrincipal();
    }
}
