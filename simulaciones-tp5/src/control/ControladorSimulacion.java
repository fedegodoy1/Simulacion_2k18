/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import front.principal.VistaAplicacion;
import front.tablemodel.SetearValores;

/**
 *
 * @author heftyn
 */
public class ControladorSimulacion 
{
    SetearValores vistaAplicacion;
    
    private static VectorEstado actual;
    private static VectorEstado anterior;
    
    ControladorSimulacion()
    {
        vistaAplicacion = new SetearValores(this);
        
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
    
    public static VectorEstado getVectorActual()
    {
        return actual;
    }
    
    public static VectorEstado getVectorAnterior()
    {
        return anterior;
    }
}
