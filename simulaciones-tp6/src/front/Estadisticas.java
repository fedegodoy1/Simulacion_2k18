package front;


public class Estadisticas {
    private double capacidad_sistema;
    private double capacidad_maq1;
    private double capacidad_maq2;
    private double capacidad_maq3;
    private double capacidad_maq4;
    private double capacidad_maq5;
    private double porcentaje_alumnos_que_se_van;

    public Estadisticas(double capacidad_sistema, double capacidad_maq1, double capacidad_maq2, double capacidad_maq3, double capacidad_maq4, double capacidad_maq5, double porcentaje_alumnos_que_se_van) {
        this.capacidad_sistema = capacidad_sistema;
        this.capacidad_maq1 = capacidad_maq1;
        this.capacidad_maq2 = capacidad_maq2;
        this.capacidad_maq3 = capacidad_maq3;
        this.capacidad_maq4 = capacidad_maq4;
        this.capacidad_maq5 = capacidad_maq5;
        this.porcentaje_alumnos_que_se_van = porcentaje_alumnos_que_se_van;
    }

    public Estadisticas() {
    }

    public double getCapacidad_sistema() {
        return capacidad_sistema;
    }

    public void setCapacidad_sistema(double capacidad_sistema) {
        this.capacidad_sistema = capacidad_sistema;
    }

    public double getCapacidad_maq1() {
        return capacidad_maq1;
    }

    public void setCapacidad_maq1(double capacidad_maq1) {
        this.capacidad_maq1 = capacidad_maq1;
    }

    public double getCapacidad_maq2() {
        return capacidad_maq2;
    }

    public void setCapacidad_maq2(double capacidad_maq2) {
        this.capacidad_maq2 = capacidad_maq2;
    }

    public double getCapacidad_maq3() {
        return capacidad_maq3;
    }

    public void setCapacidad_maq3(double capacidad_maq3) {
        this.capacidad_maq3 = capacidad_maq3;
    }

    public double getCapacidad_maq4() {
        return capacidad_maq4;
    }

    public void setCapacidad_maq4(double capacidad_maq4) {
        this.capacidad_maq4 = capacidad_maq4;
    }

    public double getCapacidad_maq5() {
        return capacidad_maq5;
    }

    public void setCapacidad_maq5(double capacidad_maq5) {
        this.capacidad_maq5 = capacidad_maq5;
    }
    
    public void setPorcentaje_alumnos_que_se_van(double porcentaje_alumnos_que_se_van)
    {
        this.porcentaje_alumnos_que_se_van = porcentaje_alumnos_que_se_van;
    }
    
    public double getPorcentaje_alumnos_que_se_van()
    {
        return porcentaje_alumnos_que_se_van;
    }
    
    
    
}
