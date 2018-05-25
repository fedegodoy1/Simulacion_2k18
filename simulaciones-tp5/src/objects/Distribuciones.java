
package objects;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;
import java.util.Random;


public class Distribuciones {
    
    private static Random rnd1 = new Random();
    private static Random rnd2 = new Random();
    
    public static float calcular_uniforme(float a, float b) {
        return a + (rnd1.nextFloat() * (b-a));
    }
             
    public static float calcular_normal(float media, float desviacion) {
        
        double raiz = sqrt((-2)* log(rnd1.nextFloat()));
        double coseno = cos(2*PI*rnd2.nextFloat());
        return (float) ((raiz * coseno) * desviacion + media);
        
    }
    
    public static float calcular_exponencial(float media) {
        return (media*-1) * (float)Math.log(1-rnd1.nextFloat());
    }
   
}
