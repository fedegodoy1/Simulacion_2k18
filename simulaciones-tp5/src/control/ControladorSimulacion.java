/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.eventos.Evento;
import front.tablemodel.SetearValores;
import java.util.*;
import model.Configuracion;
import objects.*;

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
            //Mover vector "actual" a "anterior"
            rotacionVector();
            Evento nuevoEvento = determinarProximoEvento();
            //Actualizar reloj a la hora de este evento.
            actual.setReloj(nuevoEvento.getHoraEvento());
            //Setear este evento dentro del vector actual y llamar al metodo polimorfico:
            actual.setEvento(nuevoEvento);
            actual.getEvento().actualizarEstadoVector();
            
            if (seMuestra())
            {
                //Guardar en la lista a devolver
                guardarVectorParaVista();
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
        
        if (seMuestra())
        {
            //Guardar en la lista a devolver
            guardarVectorParaVista();
        }
    }

    private Evento determinarProximoEvento() {
        //Aca lo que hacemos es obtener todas las horas que hay en el sistema que pueden generar el proximo evento
        //Elegir la menor, crear un objeto evento de ese, setearle la hora y devolverlo.
        HashMap<Double,Evento> mapaDeTiempos = new HashMap<>();
        
        if (anterior.getLlegadaAlumno() != null && 
                anterior.getLlegadaAlumno().getProx_llegada() > 0 && 
                anterior.getLlegadaAlumno().getProx_llegada() < Double.MAX_VALUE)
        {
            mapaDeTiempos.put(anterior.getLlegadaAlumno().getProx_llegada(), Evento.LlegadaAlumno);
        }
        if (anterior.getFinMantenimiento() != null &&
                anterior.getFinMantenimiento().getFinMantenimiento() > 0 &&
                anterior.getFinMantenimiento().getFinMantenimiento() < Double.MAX_VALUE)
        {
            mapaDeTiempos.put(anterior.getFinMantenimiento().getFinMantenimiento(), Evento.FinMantenimiento);
        }
        if (anterior.getInicioMantenimiento() != null &&
                anterior.getInicioMantenimiento().getProxInicioMantenimiento() > 0 &&
                anterior.getInicioMantenimiento().getProxInicioMantenimiento() < Double.MAX_VALUE)
        {
            mapaDeTiempos.put(anterior.getInicioMantenimiento().getProxInicioMantenimiento(), Evento.InicioMantenimiento);
        }
        if (anterior.getMaquinasList() != null && anterior.getMaquinasList().size() > 0)
        {
            for (Maquina maquina : anterior.getMaquinasList())
            {
                if (maquina.getFinInscripcion() > 0 && maquina.getFinInscripcion() < Double.MAX_VALUE)
                {
                    mapaDeTiempos.put(maquina.getFinInscripcion(), Evento.FinInscripcion);
                }
            }
        }
        if (anterior.getAlumnos() != null && anterior.getAlumnos().size() > 0)
        {
            for (Alumno alumno : anterior.getAlumnos())
            {
                if (alumno.getHora_regreso_sistema() > 0 &&
                        alumno.getHora_regreso_sistema() < Double.MAX_VALUE)
                {
                    mapaDeTiempos.put(alumno.getHora_regreso_sistema(), Evento.RegresoAlumno);
                }
            }
        }
        
        Set<Double> tiempos = mapaDeTiempos.keySet();
        Double tiempoSiguiente = Collections.min(tiempos);
        
        Evento returnValue = mapaDeTiempos.get(tiempoSiguiente);
        returnValue.setHoraEvento(tiempoSiguiente);
        
        return returnValue;
    }

    private boolean seMuestra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void rotacionVector() {
        anterior = actual;
        actual = new VectorEstado();
    }

    private void guardarVectorParaVista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
