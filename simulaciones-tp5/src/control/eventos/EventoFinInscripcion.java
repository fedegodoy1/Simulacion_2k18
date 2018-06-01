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
import model.Configuracion;
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
        
        Asi en teoria se clona una lista:
        new ArrayList<>(listaAnterior); Pero los objetos tienen q tener impl el clone()
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
        if (maquinaQueTerminoDeInscribir != null)
        {
            maquinaQueTerminoDeInscribir.agregarInscripto();
            maquinaQueTerminoDeInscribir.setFinInscripcion(Double.MAX_VALUE); //La UI no deberia mostrarlo
        }
        /*
        Tambien tenes que buscar cual es el Alumno que se estaba inscribiendo en
        esa maquina y guardar o clonar la referencia a ese objeto.
        Sobre este lo que tenes q hacer es ya borrarlo de la lista porque se
        va del sistema.
        */
        List<Alumno> alumnosActuales = new ArrayList<>(anterior.getAlumnos());
        Alumno alumnoQueSeTerminoDeInscribir = obtenerAlumnoQueSeTerminoDeInscribir(alumnosActuales, maquinaQueTerminoDeInscribir.getId());
        alumnosActuales.remove(alumnoQueSeTerminoDeInscribir); //Si dios quiere nadie mas lo referenciaba jaja
        alumnoQueSeTerminoDeInscribir = null;
        actual.setAlumnos(alumnosActuales);
        
        /*
        Copio todo por las duddas
        */
        actual.setAcumuladoAlumnosQueLlegan(anterior.getAcumuladoAlumnosQueLlegan());
        actual.setAcumuladoAlumnosQueLleganYSeVan(anterior.getAcumuladoAlumnosQueLleganYSeVan());
        //Actualizo el acumulador de inscripciones
        actual.setAcumuladoInscripciones(anterior.getAcumuladoInscripciones() + 1);
        
        actual.setEncargado(anterior.getEncargado().clone());
        actual.setFinInscripcion(anterior.getFinInscripcion().clone()); //Este lo clono asi no mas porque la que tiene la hora es la maquina
        actual.setFinMantenimiento(anterior.getFinMantenimiento().clone()); //Por las dudas lo clono
        actual.setInicioMantenimiento(anterior.getInicioMantenimiento().clone());
        actual.setLlegadaAlumno(anterior.getLlegadaAlumno().clone());
        
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
        
        if (maquinaQueTerminoDeInscribir != null && actual.getEncargado().estaEsperandoMaquinaLibre())
        {
            if (!maquinaQueTerminoDeInscribir.fueAtendida())
            {
                //Le toca que la mantengan
                actual.getEncargado().setEstado(Encargado.Estado.REPARANDO_MAQUINA);
                maquinaQueTerminoDeInscribir.setEstado(Maquina.Estado.SIENDO_MANTENIDA);
                
                FinMantenimiento finMantenimiento = new FinMantenimiento();
                finMantenimiento.setRnd1(new Random().nextDouble());
                finMantenimiento.setRnd2(new Random().nextDouble());
                double tiempoMantenimiento = Distribuciones.
                        calcular_normal(Configuracion.getConfiguracion().getTiempoMantenimientoMedio(),
                                Configuracion.getConfiguracion().getTiempoMantenimientoDesviacion(),
                                finMantenimiento.getRnd1(), finMantenimiento.getRnd2());
                finMantenimiento.setTMatenimiento(tiempoMantenimiento);
                finMantenimiento.setFinMantenimiento(actual.getReloj() + tiempoMantenimiento);
                
                actual.setFinMantenimiento(finMantenimiento);
                
            }
            else if (actual.getColaAlumnos().getColaAlumnos() > 0)
            {
                tocaInscribir(maquinaQueTerminoDeInscribir, actual);
            }
            else
            {
                maquinaQueTerminoDeInscribir.setEstado(Maquina.Estado.LIBRE);
            }
        }
        else if (maquinaQueTerminoDeInscribir != null && actual.getColaAlumnos().getColaAlumnos() > 0)
        {
            tocaInscribir(maquinaQueTerminoDeInscribir, actual);
        }
        else if (maquinaQueTerminoDeInscribir != null)
        {
            maquinaQueTerminoDeInscribir.setEstado(Maquina.Estado.LIBRE);
        }
        //Listo?        
    }

    private Alumno obtenerAlumnoQueSeTerminoDeInscribir(List<Alumno> alumnos, int idMaquina) 
    {
        for (Alumno alumno: alumnos)
        {
            if (alumno.getMaquinaInscripcion() == idMaquina)
            {
                return alumno;
            }
        }
        throw new NullPointerException("No se encontro el alumno que se estaba inscribiendo en la maquina: "+ idMaquina);
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
