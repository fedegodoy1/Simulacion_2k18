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
import java.util.List;
import java.util.Random;
import model.Configuracion;
import objects.Distribuciones;
import objects.Encargado;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class EventoFinMantenimiento extends Evento
{

    public EventoFinMantenimiento(String nombre) {
        super(nombre);
    }
    
        @Override
    public void actualizarEstadoVector() {
        
        /**
         * Tiene que fijarse si ya se mantuvieron todas las maquinas,
         * si es asi entonces calculamos el proximo inicio de mantenimiento
         * (ronda).
         * Si no se mantuvieron busca la siguiente maquina que no fue mantenida 
         * y esta libre, si no hay libre se pone en espera.
         * 
         */
        
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        double tMantenimiento = 0.0;
        double finTMantenimiento = 0.0;
        
        double tInicioMantenimiento = 0.0;
        double proxInicioMantenimiento = 0.0;
        double horaActual = anterior.getReloj();
        
        actual.setAcumuladoAlumnosQueLlegan(anterior.getAcumuladoAlumnosQueLlegan());
        actual.setAcumuladoAlumnosQueLleganYSeVan(anterior.getAcumuladoAlumnosQueLleganYSeVan());
        actual.setAcumuladoInscripciones(anterior.getAcumuladoInscripciones());
        actual.setAlumnos(new ArrayList<>(anterior.getAlumnos()));
        actual.setColaAlumnos(anterior.getColaAlumnos().clone());
        actual.setEncargado(anterior.getEncargado().clone());
        actual.setFinInscripcion(anterior.getFinInscripcion().clone());
        actual.setInicioMantenimiento(anterior.getInicioMantenimiento().clone());
        actual.setFinMantenimiento(new FinMantenimiento());
           
        actual.setLlegadaAlumno(anterior.getLlegadaAlumno().clone());
        actual.setMaquinas(new ArrayList<>(anterior.getMaquinasList()));
        
        Maquina maquinaQueTerminoDeMantenerse = new Maquina();
        
        for (Maquina maquina : actual.getMaquinasList())
        {
            if (maquina.getEstado().equals(Maquina.Estado.SIENDO_MANTENIDA)) {
                maquinaQueTerminoDeMantenerse = maquina;
                break;
            }
        }
        
        if(maquinaQueTerminoDeMantenerse != null) {
            maquinaQueTerminoDeMantenerse.setEstado(Maquina.Estado.LIBRE);
            maquinaQueTerminoDeMantenerse.setFueAtendida(true);
        } 
        
        List<Maquina> maquinas = actual.getMaquinasList();
        
        boolean hayMaquinaLibre = false;
        boolean hayMaquinaSinAtender = false;
        Maquina maquinaLibre = null;
        for (Maquina maq : maquinas)
        {
            if (maq.fueAtendida() == false) 
            {
                hayMaquinaSinAtender = true;
                if(maq.getEstado().equals(Maquina.Estado.LIBRE)) 
                {
                    hayMaquinaLibre = true;
                    maquinaLibre = maq;
                    break;
                }
            }
        }
        
        if (hayMaquinaLibre && hayMaquinaSinAtender && maquinaLibre != null) {
            maquinaLibre.setEstado(Maquina.Estado.SIENDO_MANTENIDA);
            
            actual.getEncargado().setEstado(Encargado.Estado.REPARANDO_MAQUINA);
            
            FinMantenimiento finMantenimiento = new FinMantenimiento();
            finMantenimiento.setRnd1(new Random().nextDouble());
            finMantenimiento.setRnd2(new Random().nextDouble());
            
            tMantenimiento = Distribuciones.calcular_normal(Configuracion.getConfiguracion().getTiempoMantenimientoMedio(),
                    Configuracion.getConfiguracion().getTiempoMantenimientoDesviacion(),
                    finMantenimiento.getRnd1(),
                    finMantenimiento.getRnd2());
            finTMantenimiento = tMantenimiento + actual.getReloj();
            
            finMantenimiento.setTMatenimiento(tMantenimiento);
            finMantenimiento.setFinMantenimiento(finTMantenimiento);
            actual.setFinMantenimiento(finMantenimiento);
        } 
        else 
        {
            
            if(hayMaquinaSinAtender) 
            {
                
                actual.getEncargado().setEstado(Encargado.Estado.ESPERANDO_MAQUINA_LIBRE);
                
            } 
            else 
            {
                
                actual.getEncargado().setEstado(Encargado.Estado.ESPERANDO_PROX_RONDA_MANTENIMIENTO);
                
                InicioMantenimiento inicioMantenimiento = new InicioMantenimiento();
                inicioMantenimiento.setRnd(new Random().nextDouble());
                
                tInicioMantenimiento = Distribuciones.calcular_uniforme(Configuracion.getConfiguracion().getInicioMantenimientoDesde(), 
                        Configuracion.getConfiguracion().getInicioMantenimientoHasta(), 
                        inicioMantenimiento.getRnd());
                proxInicioMantenimiento = tInicioMantenimiento + actual.getReloj();
                inicioMantenimiento.settMantenimiento(tInicioMantenimiento);
                inicioMantenimiento.setProxInicioMantenimiento(proxInicioMantenimiento);
                
                actual.setInicioMantenimiento(inicioMantenimiento);
            }
        }
    }
}
