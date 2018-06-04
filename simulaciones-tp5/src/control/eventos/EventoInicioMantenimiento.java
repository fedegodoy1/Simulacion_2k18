/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;
import eventos.FinMantenimiento;
import eventos.InicioMantenimiento;
import java.util.ArrayList;
import java.util.Random;
import model.Configuracion;
import objects.Distribuciones;
import objects.Encargado;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class EventoInicioMantenimiento extends Evento
{

    public EventoInicioMantenimiento(String nombre) {
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
        
        actual.setInicioMantenimiento(new InicioMantenimiento());
        
        actual.setLlegadaAlumno(anterior.getLlegadaAlumno().clone());
        actual.setMaquinas(clonarMaquinas(anterior.getMaquinasList()));
        
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
        
        if (hayMaquinaLibre && maquinaLibre != null)
        {
            maquinaLibre.setEstado(Maquina.Estado.SIENDO_MANTENIDA);
            
            actual.getEncargado().setEstado(Encargado.Estado.REPARANDO_MAQUINA);
            
            FinMantenimiento finMantenimiento = new FinMantenimiento();
            finMantenimiento.setRnd1(new Random().nextDouble());
            finMantenimiento.setRnd2(new Random().nextDouble());
            double tiempoMantenimiento = Distribuciones.calcular_normal(
                    Configuracion.getConfiguracion().getTiempoMantenimientoMedio(),
                    Configuracion.getConfiguracion().getTiempoMantenimientoDesviacion(),
                    finMantenimiento.getRnd1(),
                    finMantenimiento.getRnd2());
            finMantenimiento.setTMatenimiento(tiempoMantenimiento);
            finMantenimiento.setFinMantenimiento(actual.getReloj() + tiempoMantenimiento);
            
            actual.setFinMantenimiento(finMantenimiento);
            
        }
        else
        {
            actual.getEncargado().setEstado(Encargado.Estado.ESPERANDO_MAQUINA_LIBRE);
        }
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
