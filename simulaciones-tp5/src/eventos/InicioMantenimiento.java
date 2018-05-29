package eventos;


public class InicioMantenimiento {
    
    private double rnd;
    //TODO: no hay q agregar mas nada acá?
    
    @Override
    public InicioMantenimiento clone() throws CloneNotSupportedException
    {
        InicioMantenimiento clon = (InicioMantenimiento) super.clone();
        clon.rnd = Double.MAX_VALUE;
        return clon;
    }
}
