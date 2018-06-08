package eventos;

import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Distribuciones;
import static objects.Distribuciones.COS;
import static objects.Distribuciones.SENO;

public class FinMantenimiento implements Cloneable{
    
    private double rnd1;
    private double rnd2;
    private double tMantenimiento;
    private double finMantenimiento;
    private String senocoseno;

    public FinMantenimiento() 
    {
        rnd1 = rnd2 = tMantenimiento = finMantenimiento = Double.MAX_VALUE;
        senocoseno = COS;
    }

    public FinMantenimiento(double rnd1, double rnd2, double tMantenimiento, double finMantenimiento) {
        this.rnd1 = rnd1;
        this.rnd2 = rnd2;
        this.tMantenimiento = tMantenimiento;
        this.finMantenimiento = finMantenimiento;
    }
    
    public double getRnd1() {
        return rnd1;
    }
    
    public void setRnd1(double rnd) {
        this.rnd1 = rnd;
    }
    
    public double getRnd2() {
        return rnd2;
    }
    
    public void setRnd2(double rnd) {
        this.rnd2 = rnd;
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
            clon.rnd1 = Double.MAX_VALUE; //En la UI estos valores no se deberian ver
            clon.rnd2 = Double.MAX_VALUE;
            clon.tMantenimiento = Double.MAX_VALUE;
            clon.senocoseno = this.senocoseno;
            
            return clon;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FinMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new FinMantenimiento();
    }

    public String getSenoOCoseno() {
        return senocoseno;
    }
    
    public void setSenoOCoseno(String senocoseno)
    {
        if (COS.equals(senocoseno) || SENO.equals(senocoseno))
        {
            this.senocoseno = senocoseno;
        }
    }
}
