/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;
import java.util.ArrayList;
import objects.Alumno;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class EventoRegresoAlumno extends Evento
{

    public EventoRegresoAlumno(String nombre) {
        super(nombre);
    }
        @Override
    public void actualizarEstadoVector() {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        actual.setAcumuladoAlumnosQueLlegan(anterior.getAcumuladoAlumnosQueLlegan());
        actual.setAcumuladoAlumnosQueLleganYSeVan(anterior.getAcumuladoAlumnosQueLleganYSeVan());
        actual.setAcumuladoInscripciones(anterior.getAcumuladoInscripciones());
        actual.setAlumnos(clonarAlumnos(anterior.getAlumnos()));
        actual.setColaAlumnos(anterior.getColaAlumnos().clone());
        actual.setEncargado(anterior.getEncargado().clone());
        actual.setFinInscripcion(anterior.getFinInscripcion().clone());
        actual.setFinMantenimiento(anterior.getFinMantenimiento().clone());
        actual.setInicioMantenimiento(anterior.getInicioMantenimiento().clone());
        actual.setLlegadaAlumno(anterior.getLlegadaAlumno().clone());
        actual.setMaquinas(clonarMaquinas(anterior.getMaquinasList()));
        actual.setEuler(new ArrayList<>());
        
        Alumno alumnoQueVuelve = encontrarAlumnoQueVuelve(actual);
        
        if (actual.getColaAlumnos().getColaAlumnos() > 4)
        {
            //Se va de nuevo el...
            alumnoQueVuelve.setEstado(Alumno.Estado.ESPERANDO_PARA_REGRESAR);
            alumnoQueVuelve.setHora_regreso_sistema(actual.getReloj() + 30);
        }
        else if (actual.getColaAlumnos().getColaAlumnos() > 0)
        {
            //A la cola
            alumnoQueVuelve.setEstado(Alumno.Estado.ESPERANDO_MAQUINA);
            alumnoQueVuelve.setHora_regreso_sistema(Double.MAX_VALUE);
            
            actual.getColaAlumnos().agregarAlumnoCola();
        }
        else
        {
            //Vemos si hay maquina libre
            boolean hayMaquinaLibre = false;
            Maquina maquinaLibre = null;
            
            for (Maquina maq : actual.getMaquinasList())
            {
                if (maq.getEstado().equals(Maquina.Estado.LIBRE))
                {
                    hayMaquinaLibre = true;
                    maquinaLibre = maq;
                    break;
                }
            }
            
            if (hayMaquinaLibre)
            {
                alumnoQueVuelve.setEstado(Alumno.Estado.INSCRIBIENDOSE);
                alumnoQueVuelve.setHora_regreso_sistema(Double.MAX_VALUE);
                alumnoQueVuelve.setMaquinaInscripcion(maquinaLibre.getId());
            }
            else
            {
                alumnoQueVuelve.setEstado(Alumno.Estado.ESPERANDO_MAQUINA);
                alumnoQueVuelve.setHora_regreso_sistema(Double.MAX_VALUE);
                
                actual.getColaAlumnos().agregarAlumnoCola();
            }
        }
        
        /**
         * Borrar atributo de regreso del alumno.
         * Hacer lo mismo q en LlegadaAlumno pero sin incrementar ACs
         */
    }

    private Alumno encontrarAlumnoQueVuelve(VectorEstado actual) {
        
        for (Alumno alumno : actual.getAlumnos())
        {
            if (alumno.getEstado().equals(Alumno.Estado.ESPERANDO_PARA_REGRESAR)
                    && actual.getReloj() == alumno.getHora_regreso_sistema())
            {
                return alumno;
            }
        }
        throw new NullPointerException("No se encontro el alumno que regresaba a los : " + actual.getReloj());
    }
}
