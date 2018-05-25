/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.principal;

import control.ControladorSimulacion;
import javax.swing.JFrame;

/**
 *
 * @author heftyn
 */
public class VistaAplicacion extends JFrame
{

    ControladorSimulacion controlador;
    
    public VistaAplicacion(ControladorSimulacion controlador)
    {
        super("TP5");
        this.controlador = controlador;
    }
}
