/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import objects.Distribuciones;
import objects.Maquina;

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
        Random randomObject = new Random();
        boolean terminoDeRecorrerYNoHayLibre = false;
        
        double horaActual = actual.getReloj();
        double rndFinMantenimiento = 0.0;
        double tMantenimiento = 0.0;
        double finMantenimiento = 0.0;
        
        actual.setMaquinas(new ArrayList<>(anterior.getMaquinasList()));
        
        Maquina newMaquina = new Maquina();
        
        List<Maquina> maquinas = actual.getMaquinasList();
        for(Maquina m : maquinas) {
            if(m.fueAtendida() == false && m.getEstado().equals(Maquina.Estado.LIBRE)) {
                rndFinMantenimiento = randomObject.nextDouble();
                tMantenimiento = Distribuciones.calcular_normal(3.0, 0.0027, rndFinMantenimiento, rndFinMantenimiento);
                finMantenimiento = tMantenimiento + actual.getReloj();
                
            }
        }
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
