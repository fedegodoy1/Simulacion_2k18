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

    public void simular() {
        /**
         * Ademas de simular aca vamos a actualizar la vista...
         * onda la SetarValores tiene que proveer un metodo para 
         * obtener el TableModel (VectorEstadoTableModel) asi 
         * nosotros le pasamos todos los datos y le informamos que cambio la data
         */
    }
}
