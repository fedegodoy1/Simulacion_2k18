package eventos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FinMantenimiento implements Cloneable{
    
    private double rnd;
    private double cantidadDeArchivos;
    private double tMantenimiento;
    private double finMantenimiento;

    public FinMantenimiento() 
    {
        rnd = cantidadDeArchivos = tMantenimiento = finMantenimiento = Double.MAX_VALUE;
    }

    public FinMantenimiento(double rnd, double cantidadDeArchivos, double tMantenimiento, double finMantenimiento, int test) {
        this.rnd = rnd;
        this.cantidadDeArchivos = cantidadDeArchivos;
        this.tMantenimiento = tMantenimiento;
        this.finMantenimiento = finMantenimiento;
    }
    
    public double getRnd() {
        return rnd;
    }
    
    public void setRnd(double rnd) {
        this.rnd = rnd;
    }
    
    public double getCantidadDeArchivos() {
        return cantidadDeArchivos;
    }
    
    public void setCantidadDeArchivos(double cantArchivos) {
        this.cantidadDeArchivos = cantArchivos;
    }
    public double getTMantenimiento() {
        return tMantenimiento;
    }
    
    public void setTMatenimiento(double tMantenimiento) {
        this.tMantenimiento = tMantenimiento;
    }
    
    public double getFinMantenimiento() {
        return finMantenimiento;
    }
    
    public void setFinMantenimiento(double finMantenimiento) {
        this.finMantenimiento = finMantenimiento;
    }
    
    @Override
    public FinMantenimiento clone() 
    {
        try {
            FinMantenimiento clon = (FinMantenimiento) super.clone();
            clon.finMantenimiento = this.finMantenimiento;
            clon.rnd = Double.MAX_VALUE; 
            clon.cantidadDeArchivos = Double.MAX_VALUE;
            clon.tMantenimiento = Double.MAX_VALUE; //En la UI estos valores no se deberian ver
            
            return clon;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FinMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new FinMantenimiento();
    }
}
