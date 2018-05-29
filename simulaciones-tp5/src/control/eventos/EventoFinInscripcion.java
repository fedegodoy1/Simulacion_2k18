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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import objects.Alumno;
import objects.Distribuciones;
import objects.Encargado;
import objects.Maquina;

/**
 *
 * @author heftyn
 */
public class EventoFinInscripcion extends Evento
{
        @Override
    public void actualizarEstadoVector() {
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        Random randomObject = new Random();
        
        /*
        Aca lo que tenes que hacer es obtener la hora de este evento, 
        la cual tiene que haberse seteado en el vector actual *antes* de
        llamar a este metodo (siempre).
        VER: ControladorSimulacion.simular()
        */
        double horaActual = actual.getReloj();
        /*
        Depues con ese tiempo buscas en las maquinas a ver cual es la que tiene 
        ese tiempo de fin de inscripcion. Guardas la referencia (o la clonas)
        
        */
        actual.setMaquinas(new ArrayList<>(anterior.getMaquinasList()));
        Maquina maquinaQueTerminoDeInscribir = null;
        for (Maquina maquina : actual.getMaquinasList())
        {
            if (horaActual == maquina.getFinInscripcion())
            {
                maquinaQueTerminoDeInscribir = maquina;
                break;
            }
        }
        maquinaQueTerminoDeInscribir.agregarInscripto();
        /*
        Tambien tenes que buscar cual es el Alumno que se estaba inscribiendo en
        esa maquina y guardar o clonar la referencia a ese objeto.
        Sobre este lo que tenes q hacer es ya borrarlo de la lista porque se
        va del sistema.
        */
        List<Alumno> alumnosActuales = new ArrayList<>(anterior.getAlumnos());
        Alumno alumnoQueSeTerminoDeInscribir = obtenerAlumnoQueSeTerminoDeInscribir(alumnosActuales);
        alumnosActuales.remove(alumnoQueSeTerminoDeInscribir);
        actual.setAlumnos(alumnosActuales);
        /*
        Ahora si tenemos que decidir qué hacer con la maquina:
        Vemos si hay encargado esperando maquina libre
        SI: vemos si esta maquina NO fue mantenida
            De ser asi: movemos el estado de esta maquina a siendo mantenida
                o como se llame. Tambien marcamos al encargado como Ocupado.
            De no ser asi: Significa que puede tomar un alumno de la cola.
                Si no hay alumnos en la cola queda libre.
        NO hay encargado esperando maquina libre, podemos tomar alumno de la cola
            Si no hay nadie en la cola, pasamos esta maquina a libre.
            Si si hay entonces buscamos el siguiente alumno esperando y lo ponemos 
            a que se inscriba acá-
        */
        
        FinInscripcion newFinInscripcion = new FinInscripcion();
        FinMantenimiento newFinMantenimiento = new FinMantenimiento();
        double rndFinMantenimiento = 0.0;
        double tMantenimiento = 0.0;
        double finMantenimiento = 0.0;
        double rndInscripcion = 0.0;
        double tInscripcion = 0.0;
        double finInscripcion = 0.0;
        
        
        actual.setMaquinas(anterior.getMaquinasList());
        
        List<Maquina> maquinas = anterior.getMaquinasList();
        Maquina maquinaFinInscripcion = new Maquina();
        maquinaFinInscripcion.setFinInscripcion(200000.0);
        for(Maquina m : maquinas) {
            if( m.getFinInscripcion() != 0 && m.getFinInscripcion() < maquinaFinInscripcion.getFinInscripcion()) {
                maquinaFinInscripcion.setAcumuladoInscriptos(m.getAcumuladoInscriptos());
                maquinaFinInscripcion.setEstado(m.getEstado());
                maquinaFinInscripcion.setFueAtendida(m.fueAtendida());
                maquinaFinInscripcion.setFinInscripcion(m.getAcumuladoInscriptos());
            }
        }
        
        if(anterior.getEncargado().getEstado().equals(Encargado.Estado.ESPERANDO_MAQUINA_LIBRE) && maquinaFinInscripcion.fueAtendida() == false) {
            // Logica para cuando termina de inscribir un alumno pero hay un encargado esperando maquina libre, ocurre un fin mantenimiento
            rndFinMantenimiento = randomObject.nextDouble();
            // -----------Aca como seria para dos rnd? Calculamos dos rnd y anotamos los dos en el vector?
            tMantenimiento = Distribuciones.calcular_normal(3.0, 0.0027, rndFinMantenimiento, rndFinMantenimiento);
            finMantenimiento = tMantenimiento + actual.getReloj();
            
            List<Alumno> anteriorListaInscribiendose = anterior.getAlumnosInscribiendose();
            anteriorListaInscribiendose.remove(0);
            
            newFinMantenimiento.setRnd(rndFinMantenimiento);
            newFinMantenimiento.setTMatenimiento(tMantenimiento);
            newFinMantenimiento.setFinMantenimiento(finMantenimiento);
            
            maquinaFinInscripcion.setEstado(Maquina.Estado.SIENDO_MANTENIDA);
            
            actual.setAlumnosInscribiendose(anteriorListaInscribiendose);
            actual.setAlumnosEnCola(anterior.getAlumnosEnCola());
            actual.setearFinMantenimientoEnMaquina(maquinaFinInscripcion);
            actual.setFinMantenimiento(newFinMantenimiento);
            actual.setFinInscripcion(anterior.getFinInscripcion());
            actual.setAcumuladoInscripciones(anterior.getAcumuladoInscripciones());
            actual.setColaAlumnos(anterior.getColaAlumnos());
        } else {
            // Logica para fin inscripcion comun
            if(anterior.getColaAlumnos().getColaAlumnos() > 0) {
                rndInscripcion = randomObject.nextDouble();
                tInscripcion = Distribuciones.calcular_uniforme(5.0, 8.0, rndInscripcion);
                finInscripcion = tInscripcion + actual.getReloj();
                
                actual.disminuirColaAlumnos();
                
                newFinInscripcion.setRnd(rndInscripcion);
                newFinInscripcion.settInscripcion(tInscripcion);
                
                actual.setFinInscripcion(newFinInscripcion);
                // Este metodo incluye el seteo del estado de la maquina y del fin inscripcion
                actual.setearFinInscripcionEnMaquina(maquinaFinInscripcion.getId(), finInscripcion);
                actual.setearAcInscripcionEnMaquina(maquinaFinInscripcion.getId());
                actual.acumularInscripcion();
            }
        }
        
        actual.setAcumuladoAlumnosQueLlegan(anterior.getAcumuladoAlumnosQueLlegan());
        actual.setAcumuladoAlumnosQueLleganYSeVan(anterior.getAcumuladoAlumnosQueLleganYSeVan());
        actual.setAlumnos(anterior.getAlumnos());
        actual.setInicioMantenimiento(anterior.getInicioMantenimiento());
        actual.setLlegadaAlumno(anterior.getLlegadaAlumno());
        
        /**
         * Se fija si el Encargado estaba esperando maquina libre y esta maquina
         * no fue atendida, en ese caso le toca al Encargado.
         * Si no se fija en la cola de alumnos.
         * Si no hay alumnos en la cola se pone libre.
         * Actualiza ACs.
         * 
         * 
         */
    }

    private Alumno obtenerAlumnoQueSeTerminoDeInscribir(List<Alumno> alumnos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
