package objects;

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
    public ColaAlumnos clone() throws CloneNotSupportedException
    {
        ColaAlumnos clonada = (ColaAlumnos) super.clone();
        clonada.cantidad = this.cantidad;
        return clonada;
    }
}
