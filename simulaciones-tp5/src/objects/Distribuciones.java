
package objects;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;
import java.util.Random;


public class Distribuciones {
    
    private static Random rnd1 = new Random();
    private static Random rnd2 = new Random();
    private static int var = 0;
    
    public static double calcular_uniforme(double a, double b) {
        return a + (rnd1.nextDouble()* (b-a));
    }
             
    public static double calcular_normal(double media, double desviacion) {
        
        double raiz = sqrt((-2)* log(rnd1.nextDouble()));
        
        double segundo_miembro = var % 2 == 0 ? cos(2*PI*rnd2.nextDouble()) : sin(2*PI*rnd2.nextDouble());
        var++;
        return ((raiz * segundo_miembro) * desviacion + media);
        
    }
    
    public static double calcular_exponencial(double media) {
        return (media*-1) * Math.log(1-rnd1.nextDouble());
    }
   
}
