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
import model.VectorEstado;
import model.VectorEstadoConstants;

/**
 *
 * @author heftyn
 */
public final class VectorEstadoTableModel extends DefaultTableModel implements VectorEstadoConstants {

    private List<VectorEstado> datos;
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

        columns.add(new Columna("Reloj", LocalTime.class, 75));
    }
}
