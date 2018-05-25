/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.tablemodel;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.VectorEstadoConstants;
import model.VectorEstadoUI;

/**
 *
 * @author heftyn
 */
public final class VectorEstadoTableModel extends DefaultTableModel implements VectorEstadoConstants {

    private List<VectorEstadoUI> datos;
    private List<Columna> columns;

    public VectorEstadoTableModel() 
    {
        datos = new ArrayList<>();
        createColumnList();
    }
    
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns.get(columnIndex).getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columns.get(columnIndex).getTipo();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) 
    {
        Object value = null;
        switch (col)
        {
            //Por cada columna de la tabla
            case COL_RELOJ:
            {
                //Aca podemos formatear la salida
                value = datos.get(row).getReloj();
                break;//No olvidar
            }
        }
        return value;
    }

    private void createColumnList() 
    {
        columns = new ArrayList<>();
        
        //Agregar cada objeto de columna a la lista

        //https://coderanch.com/t/333340/java/set-Line-wrap-Column-JTable 
        columns.add(new Columna("Evento", String.class, 100));
        columns.add(new Columna("Reloj", LocalTime.class, 75));
        columns.add(new Columna("LLegada Alumnos: RND", LocalTime.class, 75));
        columns.add(new Columna("Llegada Alumnos: Tiempo llegada", LocalTime.class, 75));
        columns.add(new Columna("Llegada Alumnos: Proxima llegada", LocalTime.class, 75));
        columns.add(new Columna("Llegada Mantenimiento: RND", LocalTime.class, 75));
        columns.add(new Columna("Llegada Mantenimiento: Tiempo llegada", LocalTime.class, 75));
        columns.add(new Columna("Llegada Mantenimiento: Proxima llegada", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: RND", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: Tiempo inscripcion", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: Fin inscripcion equipo 1", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: Fin inscripcion equipo 2", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: Fin inscripcion equipo 3", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: Fin inscripcion equipo 4", LocalTime.class, 75));
        columns.add(new Columna("Fin Inscripcion: Fin inscripcion equipo 5", LocalTime.class, 75));
        columns.add(new Columna("Fin Mantenimiento: RND", LocalTime.class, 75));
        columns.add(new Columna("Fin Mantenimiento: Tiempo mantenimiento", LocalTime.class, 75));
        columns.add(new Columna("Fin Mantenimiento: Hora fin", LocalTime.class, 75));
        columns.add(new Columna("Cola Alumnos", LocalTime.class, 75));
        columns.add(new Columna("Cola Mantenimiento", LocalTime.class, 75));
        columns.add(new Columna("Maquina 1: Estado", LocalTime.class, 75));
        //Resto de las máquinas
        columns.add(new Columna("Acum. Inscripciones", LocalTime.class, 75));
        columns.add(new Columna("Acum. Alumnos que llegan", LocalTime.class, 75));
        columns.add(new Columna("Acum. Alumnos que llegan y se van", LocalTime.class, 75));
        columns.add(new Columna("Alumnos", LocalTime.class, 75));
        columns.add(new Columna("Mantenimiento", LocalTime.class, 75));
    }
    
    public List<Columna> getColumnaList()
    {
        return columns;
    }
}
