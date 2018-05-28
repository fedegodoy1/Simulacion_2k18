/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;
import eventos.FinInscripcion;
import eventos.FinMantenimiento;
import eventos.InicioMantenimiento;
import eventos.LlegadaAlumno;
import java.util.ArrayList;
import java.util.List;
import objects.ColaAlumnos;
import objects.Encargado;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class EventoInicial extends Evento
{

    @Override
    public void actualizarEstadoVector() 
    {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        
        actual.setAcumuladoAlumnosQueLlegan(0);
        actual.setAcumuladoAlumnosQueLleganYSeVan(0);
        actual.setAcumuladoInscripciones(0);
        actual.setAlumnos(new ArrayList<>());
        actual.setColaAlumnos(new ColaAlumnos(0));
        actual.setEncargado(new Encargado(Encargado.Estado.ESPERANDO_PROX_RONDA_MANTENIMIENTO));
        actual.setFinInscripcion(new FinInscripcion());
        actual.setFinMantenimiento(new FinMantenimiento());
        actual.setInicioMantenimiento(new InicioMantenimiento());
        actual.setLlegadaAlumno(new LlegadaAlumno());
        actual.setMaquinas(getMaquinasList());
    }

    private List<Maquina> getMaquinasList() {
        ArrayList<Maquina> maquinas = new ArrayList<>(5);
        maquinas.add(new Maquina(1, 0, Maquina.Estado.LIBRE, false, 0.0));
        maquinas.add(new Maquina(2, 0, Maquina.Estado.LIBRE, false, 0.0));
        maquinas.add(new Maquina(3, 0, Maquina.Estado.LIBRE, false, 0.0));
        maquinas.add(new Maquina(4, 0, Maquina.Estado.LIBRE, false, 0.0));
        maquinas.add(new Maquina(5, 0, Maquina.Estado.LIBRE, false, 0.0));
        return maquinas;
    }
    
}
