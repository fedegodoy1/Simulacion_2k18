package control.eventos;

import control.ControladorSimulacion;
import control.VectorEstado;
import eventos.FinInscripcion;
import eventos.LlegadaAlumno;
import java.util.List;
import java.util.Random;
import objects.Alumno;
import objects.Distribuciones;
import objects.Maquina;

public class EventoLlegadaAlumno extends Evento {

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
        Random randomObject = new Random();
        LlegadaAlumno newLlegada = new LlegadaAlumno();
        FinInscripcion newFinInscripcion = new FinInscripcion();
        Alumno newAlumno = new Alumno();
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
        double tEntreLlegada = Distribuciones.calcular_exponencial(-2, rndProxLlegada);
        double proxLlegada = tEntreLlegada + actual.getReloj();
        
        // Se fija primero si hay alumnos en la cola y luego en base a eso calcula los tiempos de las inscripciones o acumula en la cola
        if(anterior.getColaAlumnos().getColaAlumnos() == 0) {
            List<Maquina> maquinas = anterior.getMaquinasList();
            for (Maquina m : maquinas) {
                if(m.getEstado().equals(Maquina.Estado.LIBRE)){
                    // Calcula el fin inscripcion y actualiza el estado del alumno y de la maquina correspondiente
                    rndInscripcion = randomObject.nextDouble();
                    tInscripcion = Distribuciones.calcular_uniforme(5.0, 8.0, rndInscripcion);
                    finInscripcion = tInscripcion + actual.getReloj();
                    
                    newFinInscripcion.setRnd(rndInscripcion);
                    newFinInscripcion.settInscripcion(tInscripcion);
                    
                    actual.setFinInscripcion(newFinInscripcion);
                    actual.setearFinInscripcionEnMaquina(m.getId(), finInscripcion);
                    newAlumno.setEstado(Alumno.Estado.INSCRIBIENDOSE);
                    maquinasLibres = true;
                    break;
                } 
            }
            if(maquinasLibres == false) {
                newAlumno.setEstado(Alumno.Estado.ESPERANDO_MAQUINA);
                actual.agregarAlumnoACola();
                actual.setFinInscripcion(anterior.getFinInscripcion());
            }
             
        } else {
            
            // Logica para cuando hay cola de 1 hasta 4
            if(anterior.getColaAlumnos().getColaAlumnos() >= 1 && anterior.getColaAlumnos().getColaAlumnos() <= 4) {
                newAlumno.setEstado(Alumno.Estado.ESPERANDO_MAQUINA);
                actual.agregarAlumnoACola();
                actual.setFinInscripcion(anterior.getFinInscripcion());
            }
            
            // Logica para cuando la cola es mayor a 4
            if(anterior.getColaAlumnos().getColaAlumnos() > 4) {
                double minutosQueRegresa = 30.0;
                newAlumno.setHora_regreso_sistema(anterior.getReloj() + minutosQueRegresa);
                newAlumno.setEstado(Alumno.Estado.ESPERANDO_PARA_REGRESAR);
                actual.acumularAlumnoQueLlegaYSeVa();
                actual.setFinInscripcion(anterior.getFinInscripcion());
            }
        }
        
        // Actualiza todo el vector actual con los acumuladores y todo el resto que no se todo del vector anterior
        actual.addAlumno(newAlumno);
        
        //Seteo de la proxima llegada
        newLlegada.setRnd(rndProxLlegada);
        newLlegada.setTiempo_entre_llegadas(tEntreLlegada);
        newLlegada.setProx_llegada(proxLlegada);
        actual.setLlegadaAlumno(newLlegada);
        
        // Siempre que haya una llegada alumno se acumula la llegada del alumno
        actual.acumularAlumnoQueLlega();
        
        // Seteo del evento actual
        actual.setEvento(Evento.LlegadaAlumno);
        
        //Actualiza el resto como estaba antes
        actual.setAcumuladoInscripciones(anterior.getAcumuladoInscripciones());
        actual.setEncargado(anterior.getEncargado());
        actual.setFinMantenimiento(anterior.getFinMantenimiento());
        actual.setInicioMantenimiento(anterior.getInicioMantenimiento());
        actual.setMaquinas(anterior.getMaquinasList());
        actual.setReloj(anterior.getLlegadaAlumno().getProx_llegada());
    }
}
