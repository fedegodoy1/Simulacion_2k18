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
import java.util.Random;
import model.Configuracion;
import objects.ColaAlumnos;
import objects.Distribuciones;
import objects.Encargado;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class EventoInicial extends Evento
{

    public EventoInicial(String nombre) {
        super(nombre);
    }

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
        actual.setMaquinas(getMaquinasList());
        
        //Seteo de la proxima llegada
        LlegadaAlumno proximaLlegada = new LlegadaAlumno();
        proximaLlegada.setRnd(new Random().nextDouble());
        double tiempoEntreLlegadas = Distribuciones.calcular_exponencial(
                Configuracion.getConfiguracion().getMediaLlegadaAlumnos(),
                proximaLlegada.getRnd());
        proximaLlegada.setTiempo_entre_llegadas(tiempoEntreLlegadas);
        proximaLlegada.setProx_llegada(actual.getReloj() + tiempoEntreLlegadas);
        
        InicioMantenimiento inicioMantenimiento = new InicioMantenimiento();
        inicioMantenimiento.setRnd(new Random().nextDouble());
        double tiempoEntreLlegadas_inicio = Distribuciones.calcular_uniforme(
                Configuracion.getConfiguracion().getInicioMantenimientoDesde(), 
                Configuracion.getConfiguracion().getInicioMantenimientoHasta(), 
                inicioMantenimiento.getRnd());
        inicioMantenimiento.settMantenimiento(tiempoEntreLlegadas_inicio);
        inicioMantenimiento.setProxInicioMantenimiento(actual.getReloj() + tiempoEntreLlegadas_inicio);
        
        actual.setLlegadaAlumno(proximaLlegada);
        actual.setInicioMantenimiento(inicioMantenimiento);
    }

    private List<Maquina> getMaquinasList() {
        ArrayList<Maquina> maquinas = new ArrayList<>(5);
        maquinas.add(new Maquina(1, 0, Maquina.Estado.LIBRE, false, Double.MAX_VALUE));
        maquinas.add(new Maquina(2, 0, Maquina.Estado.LIBRE, false, Double.MAX_VALUE));
        maquinas.add(new Maquina(3, 0, Maquina.Estado.LIBRE, false, Double.MAX_VALUE));
        maquinas.add(new Maquina(4, 0, Maquina.Estado.LIBRE, false, Double.MAX_VALUE));
        maquinas.add(new Maquina(5, 0, Maquina.Estado.LIBRE, false, Double.MAX_VALUE));
        return maquinas;
    }
    
}
