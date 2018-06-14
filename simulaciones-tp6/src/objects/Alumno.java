package objects;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Alumno implements Cloneable{
    
    private double hora_regreso_sistema;
    private int idMaqInscr;

    public void setMaquinaInscripcion(int id) {
        
        idMaqInscr = id;
    }
    
    public int getMaquinaInscripcion()
    {
        return idMaqInscr;
    }
    
    public enum Estado {
        ESPERANDO_MAQUINA,
        INSCRIBIENDOSE,
        ESPERANDO_PARA_REGRESAR
    };
    
    private Estado estado;

    public Alumno() {
        
    }
    
    public Alumno(float hora_regreso_sistema, Estado estado) {
        this.hora_regreso_sistema = hora_regreso_sistema;
        this.estado = estado;
    }

    public double getHora_regreso_sistema() {
        return hora_regreso_sistema;
    }

    public void setHora_regreso_sistema(double hora_regreso_sistema) {
        this.hora_regreso_sistema = hora_regreso_sistema;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    @Override
    public Alumno clone() 
    {
        try {
            Alumno clonado = (Alumno) super.clone();
            clonado.estado = this.estado;
            clonado.hora_regreso_sistema = this.hora_regreso_sistema;
            clonado.idMaqInscr = this.idMaqInscr;
            
            return clonado;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Alumno();
    }
}
