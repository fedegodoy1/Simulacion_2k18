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
public class EventoLlegadaAlumno extends Evento
{

    @Override
    public void actualizarEstadoVector() {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        //Calcular proxima llegada alumno
        //Crear Alumno y agregarlo a la lista de alumnos
        //Ver si hay maquina libre
        /**
         * si hay tengo q calcular fin inscripcion, si no hay se tiene que ir 
         * a la cola (setear estados)
         * Si en la cola hay mas de 4, se va y vuelve 30 mins mas tarde
         * En ese caso sumar 1 al AC de alumnos que llegan y se van.
         * Sumar 1 al AC de alumnos que llegan sin importar que hizo.
         */
    }
    
}
