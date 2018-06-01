package eventos;

import java.util.logging.Level;
import java.util.logging.Logger;


public class InicioMantenimiento implements Cloneable{
    
    private double rnd;
    private double tMantenimiento;
    private double proxInicioMantenimiento;

    public InicioMantenimiento(double rnd, double tMantenimiento, double proxInicioMantenimiento) {
        this.rnd = rnd;
        this.tMantenimiento = tMantenimiento;
        this.proxInicioMantenimiento = proxInicioMantenimiento;
    }

    public InicioMantenimiento() {
        proxInicioMantenimiento = Double.MAX_VALUE;
    }

    public double getRnd() {
        return rnd;
    }

    public void setRnd(double rnd) {
        this.rnd = rnd;
    }

    public double gettMantenimiento() {
        return tMantenimiento;
    }

    public void settMantenimiento(double tMantenimiento) {
        this.tMantenimiento = tMantenimiento;
    }

    public double getProxInicioMantenimiento() {
        return proxInicioMantenimiento;
    }

    public void setProxInicioMantenimiento(double proxInicioMantenimiento) {
        this.proxInicioMantenimiento = proxInicioMantenimiento;
    }
    
    
    
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
