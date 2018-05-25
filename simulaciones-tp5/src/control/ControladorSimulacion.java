/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import front.principal.VistaAplicacion;

/**
 *
 * @author heftyn
 */
public class ControladorSimulacion 
{
    VistaAplicacion vistaAplicacion;
    
    ControladorSimulacion()
    {
        vistaAplicacion = new VistaAplicacion(this);
        
    }
    public void mostrarVentanaPrincipal()
    {
        vistaAplicacion.setVisible(true);        
    }
}
