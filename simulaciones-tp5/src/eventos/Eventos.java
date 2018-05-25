package eventos;

import control.VectorEstado;
import java.util.Random;
import objects.Distribuciones;


public class Eventos {
    
        private Random rnd = new Random();
        
    public void generar_llegada_alumno(VectorEstado vector, double media, double prox_reloj) {
        
        double rnd_para_iteracion = rnd.nextDouble();
        
        double tEntreLlegadas = Distribuciones.calcular_exponencial(media, rnd_para_iteracion);
        double proxLlegada = Distribuciones.calcular_exponencial(media,rnd_para_iteracion)+prox_reloj;
        
        //   1) Modificar la parte de llegada alumno dependiendo como este el vector de estado
        //vector.setRndLlegadaAlumno(rnd.nextDouble());
        //vector.setTEntreLlegadas(tEntreLlegadas);
        //vector.setProxLlegada(proxLlegada);
        
        //   2) Observar si la cola esta vacia, sino acumularla
        //if(vector.getCola() != 0) {
        //    vector.setCola(vector.getCola()+1);
        //} 
        //   3) Deberia copiar todo lo que tiene antes que no se hace en la llegada del alumno y pasarlo al vector actual
    }
    
    public void generar_fin_inscripcion(VectorEstado vector) {
        
    }
    
    public void generar_fin_mantenimiento(VectorEstado vector) {
        
    }
    
    public void generar_regreso_alumno(VectorEstado vector) {
        
    }
}
