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
public class EventoFinInscripcion extends Evento
{
        @Override
    public void actualizarEstadoVector() {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        /**
         * Se fija si el Encargado estaba esperando maquina libre y esta maquina
         * no fue atendida, en ese caso le toca al Encargado.
         * Si no se fija en la cola de alumnos.
         * Si no hay alumnos en la cola se pone libre.
         * Actualiza ACs.
         * 
         * 
         */
    }
}
