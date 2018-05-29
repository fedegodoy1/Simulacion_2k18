package objects;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ColaAlumnos {
    
    private double cantidad;

    public ColaAlumnos(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getColaAlumnos() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    public void agregarAlumnoCola() {
        cantidad ++;
    }
    
    @Override
    public ColaAlumnos clone() 
    {
        try {
            ColaAlumnos clonada = (ColaAlumnos) super.clone();
            clonada.cantidad = this.cantidad;
            return clonada;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ColaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ColaAlumnos(this.cantidad);
    }
}
