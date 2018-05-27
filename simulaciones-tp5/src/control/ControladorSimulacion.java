/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.eventos.Evento;
import front.principal.VistaAplicacion;
import front.tablemodel.SetearValores;
import java.util.ArrayList;
import model.Configuracion;
import objects.ColaAlumnos;

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
        int iteracionActual = 0;
        inicializar();
        int minutosASimular = Configuracion.getConfiguracion().getMinutosASimular();
        while (iteracionActual < 1000000 || anterior.getReloj() <= minutosASimular)
        {
            //TODO: Mover vector "actual" a "anterior"
            // y el actual que sea un new copiando lo que haga falta de arriba (o eso capaz en el evento)
            Evento nuevoEvento = determinarProximoEvento();
            nuevoEvento.actualizarEstadoVector();
            if (seMuestra())
            {
                //Guardar en la lista a devolver
            }
        }
        //Actualizar Vista
    }
    
    public static VectorEstado getVectorActual()
    {
        return actual;
    }
    
    public static VectorEstado getVectorAnterior()
    {
        return anterior;
    }

    private void inicializar() 
    {
        actual = new VectorEstado();
        actual.setReloj(0);
        actual.setEvento(Evento.Inicial);
        actual.getEvento().actualizarEstadoVector();
    }

    private Evento determinarProximoEvento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean seMuestra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
