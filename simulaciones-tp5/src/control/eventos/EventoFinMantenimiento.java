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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Configuracion;
import objects.Alumno;
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
        actual.setAlumnos(clonarAlumnos(anterior.getAlumnos()));
        actual.setColaAlumnos(anterior.getColaAlumnos().clone());
        actual.setEncargado(anterior.getEncargado().clone());
        actual.setFinInscripcion(anterior.getFinInscripcion().clone());
        actual.setInicioMantenimiento(anterior.getInicioMantenimiento().clone());
        actual.setFinMantenimiento(new FinMantenimiento());
           
        actual.setLlegadaAlumno(anterior.getLlegadaAlumno().clone());
        actual.setMaquinas(clonarMaquinas(anterior.getMaquinasList()));
        
        Maquina maquinaQueTerminoDeMantenerse = new Maquina();
        
        for (Maquina maquina : actual.getMaquinasList())
        {
            if (maquina.getEstado().equals(Maquina.Estado.SIENDO_MANTENIDA)) {
                maquinaQueTerminoDeMantenerse = maquina;
                break;
            }
        }
        
        if(maquinaQueTerminoDeMantenerse != null) {
            maquinaQueTerminoDeMantenerse.setFueAtendida(true);
            
            if(actual.getColaAlumnos().getColaAlumnos() > 0) {
                tocaInscribir(maquinaQueTerminoDeMantenerse, actual);
                
            } else {
                maquinaQueTerminoDeMantenerse.setEstado(Maquina.Estado.LIBRE);
            }
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
                
                //Pongo a todas las maquinas sin atender para la proxima ronda
                for (Maquina maquina: actual.getMaquinasList())
                {
                    maquina.setFueAtendida(false);
                }
            }
        }
    }
    
    private void tocaInscribir(Maquina maquinaQueTerminoDeInscribir, VectorEstado actual) {
        //Toca inscribir
        //Disminuyo la cola
        actual.getColaAlumnos().setCantidad(actual.getColaAlumnos().getColaAlumnos() - 1);
        
        //seteo estado a la maquina
        maquinaQueTerminoDeInscribir.setEstado(Maquina.Estado.OCUPADA);

        //TODO: Buscar el alumno que sigue y setearle estado
        Alumno alumnoQueSigue = buscarAlumnoQueSigueParaInscripcion(actual);
        alumnoQueSigue.setEstado(Alumno.Estado.INSCRIBIENDOSE);
        alumnoQueSigue.setMaquinaInscripcion(maquinaQueTerminoDeInscribir.getId());

        //Generar Fin Inscripcion
        FinInscripcion finInscripcion = new FinInscripcion();
        finInscripcion.setRnd(new Random().nextDouble());
        finInscripcion.settInscripcion(Distribuciones.calcular_uniforme(
                Configuracion.getConfiguracion().getTiempoInscripcionDesde(),
                Configuracion.getConfiguracion().getTiempoInscripcionHasta(),
                finInscripcion.getRnd()));
        //Seteo los datos en el vector
        actual.setFinInscripcion(finInscripcion);
        //Le digo a la maquina cuando termina de inscribir
        maquinaQueTerminoDeInscribir.setFinInscripcion(
                actual.getReloj() + actual.getFinInscripcion().gettInscripcion());
    }
    
    private Alumno buscarAlumnoQueSigueParaInscripcion(VectorEstado actual) {
        //El alumno que sigue va a ser el primero que esté en el estado Esperando Maquina Libre
        for (Alumno alumno : actual.getAlumnos())
        {
            if (alumno.getEstado().equals(Alumno.Estado.ESPERANDO_MAQUINA))
            {
                return alumno;
            }
        }
        throw new NullPointerException ( "No habia Alumno esperando maquina");
    }
    
}
