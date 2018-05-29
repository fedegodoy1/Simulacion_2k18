package eventos;

import java.util.logging.Level;
import java.util.logging.Logger;


public class InicioMantenimiento {
    
    private double rnd;
    //TODO: no hay q agregar mas nada acá?
    
    @Override
    public InicioMantenimiento clone() 
    {
        try {
            InicioMantenimiento clon = (InicioMantenimiento) super.clone();
            clon.rnd = Double.MAX_VALUE;
            return clon;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(InicioMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new InicioMantenimiento();
    }
}
