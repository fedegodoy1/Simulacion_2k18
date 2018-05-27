/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;

/**
 *
 * @author heftyn
 */
public class EventoFinMantenimiento extends Evento
{
    
        @Override
    public void actualizarEstadoVector() {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        /**
         * Tiene que fijarse si ya se mantuvieron todas las maquinas,
         * si es asi entonces calculamos el proximo inicio de mantenimiento
         * (ronda).
         * Si no se mantuvieron busca la siguiente maquina que no fue mantenida 
         * y esta libre, si no hay libre se pone en espera.
         * 
         */
    }
}
