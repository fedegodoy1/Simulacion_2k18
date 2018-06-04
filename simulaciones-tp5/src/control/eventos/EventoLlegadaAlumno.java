package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;
import eventos.FinInscripcion;
import eventos.LlegadaAlumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Configuracion;
import objects.Alumno;
import objects.Distribuciones;
import objects.Maquina;

public class EventoLlegadaAlumno extends Evento {

    public EventoLlegadaAlumno(String nombre) {
        super(nombre);
    }

    @Override
    public void actualizarEstadoVector() {
        
        /**
         * si hay tengo q calcular fin inscripcion, si no hay se tiene que ir 
         * a la cola (setear estados)
         * Si en la cola hay mas de 4, se va y vuelve 30 mins mas tarde
         * En ese caso sumar 1 al AC de alumnos que llegan y se van.
         * Sumar 1 al AC de alumnos que llegan sin importar que hizo.
         */
        
        VectorEstado actual = ControladorSimulacion.getVectorActual();
        VectorEstado anterior = ControladorSimulacion.getVectorAnterior();
        
        actual.setAcumuladoAlumnosQueLlegan(anterior.getAcumuladoAlumnosQueLlegan() + 1);
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
        
        Random randomObject = new Random();
        LlegadaAlumno newLlegada = new LlegadaAlumno();
        FinInscripcion newFinInscripcion = new FinInscripcion();
        
        Alumno newAlumno = new Alumno();
        actual.getAlumnos().add(newAlumno);
        //Variables para fin inscripcion
        double rndInscripcion = 0.0;
        double tInscripcion = 0.0;
        double finInscripcion = 0.0;
        
        /**
         * Si maquinasLibres es true, significa que encontro al menos una y esta siendo inscripto,
         * sino se queda en false y tiene que ir a la cola
         */
        boolean maquinasLibres = false;
        
        // Calcular proxima llegada alumno
        double rndProxLlegada = randomObject.nextDouble();
        double tEntreLlegada = Distribuciones.calcular_exponencial(
                Configuracion.getConfiguracion().getMediaLlegadaAlumnos(),
                rndProxLlegada);
        double proxLlegada = tEntreLlegada + actual.getReloj();
        
        
        // Se fija primero si hay alumnos en la cola y luego en base a eso calcula los tiempos de las inscripciones o acumula en la cola
        if(anterior.getColaAlumnos().getColaAlumnos() == 0) 
        {
            List<Maquina> maquinas = actual.getMaquinasList();
            for (Maquina m : maquinas) 
            {
                if(m.getEstado().equals(Maquina.Estado.LIBRE))
                {
                    // Calcula el fin inscripcion y actualiza el estado del alumno y de la maquina correspondiente
                    rndInscripcion = randomObject.nextDouble();
                    tInscripcion = Distribuciones.calcular_uniforme(
                            Configuracion.getConfiguracion().getTiempoInscripcionDesde(),
                            Configuracion.getConfiguracion().getTiempoInscripcionHasta(),
                            rndInscripcion);
                    finInscripcion = tInscripcion + actual.getReloj();
                    
                    newFinInscripcion.setRnd(rndInscripcion);
                    newFinInscripcion.settInscripcion(tInscripcion);
                    
                    actual.setFinInscripcion(newFinInscripcion);
                    m.setEstado(Maquina.Estado.OCUPADA);
                    m.setFinInscripcion(actual.getReloj() + tInscripcion);
                    
                    newAlumno.setEstado(Alumno.Estado.INSCRIBIENDOSE);
                    newAlumno.setMaquinaInscripcion(m.getId());
                    
                    maquinasLibres = true;
                    break;
                } 
            }
            if(!maquinasLibres) 
            {
                newAlumno.setEstado(Alumno.Estado.ESPERANDO_MAQUINA);
                actual.getColaAlumnos().agregarAlumnoCola();
            }
             
        } 
        else if (actual.getColaAlumnos().getColaAlumnos() > 4)
        {
                      
            // Logica para cuando la cola es mayor a 4
            double minutosQueRegresa = 30.0;
            newAlumno.setHora_regreso_sistema(actual.getReloj() + minutosQueRegresa);
            newAlumno.setEstado(Alumno.Estado.ESPERANDO_PARA_REGRESAR);
            actual.setAcumuladoAlumnosQueLleganYSeVan(actual.getAcumuladoAlumnosQueLleganYSeVan() + 1);
        }
        else
        {
            newAlumno.setEstado(Alumno.Estado.ESPERANDO_MAQUINA);
            actual.getColaAlumnos().agregarAlumnoCola();
        }
                
        //Seteo de la proxima llegada
        newLlegada.setRnd(rndProxLlegada);
        newLlegada.setTiempo_entre_llegadas(tEntreLlegada);
        newLlegada.setProx_llegada(proxLlegada);
        actual.setLlegadaAlumno(newLlegada);
    }
}
