package eventos;

public class FinMantenimiento {
    
    private double rnd;
    private double tMantenimiento;
    private double finMantenimiento;

    public FinMantenimiento() {
    }

    public FinMantenimiento(double rnd, double tMantenimiento, double finMantenimiento) {
        this.rnd = rnd;
        this.tMantenimiento = tMantenimiento;
        this.finMantenimiento = finMantenimiento;
    }
    
    public double getRnd() {
        return rnd;
    }
    
    public void setRnd(double rnd) {
        this.rnd = rnd;
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
}
