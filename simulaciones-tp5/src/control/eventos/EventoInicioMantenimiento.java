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
public class EventoInicioMantenimiento extends Evento
{
        @Override
    public void actualizarEstadoVector() {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        /**
         * Inicia Ronda de mantenimiento: (Llegada mantenimiento)
         * Ver si hay maquina libre para el encargado
         * si hay se ocupa de mantenerla por lo que 
         * hay q calcular el fin mantenimiento.
         * Si no hay maquina libre se pone en estado esperando maquina libre.
         * 
         */
    }
}
