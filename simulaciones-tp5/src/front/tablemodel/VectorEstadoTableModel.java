/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
        return datos != null ? datos.size() : 0;
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
            case COL_EVENTO:
            {
                value = datos.get(row).getEvento().getNombre();
                break;
            }
            case COL_LLEGADA_ALUMNO_RND:
            {
                value = datos.get(row).getLlegadaAlumno().getRnd() ;
                break;
            }
            case COL_LLEGADA_ALUMNO_TIEMPO:
            {
                value = datos.get(row).getLlegadaAlumno().getTiempo_entre_llegadas() ;
                break;
            }
            case COL_LLEGADA_ALUMNO_PROXIMA:
            {
                value = datos.get(row).getLlegadaAlumno().getProx_llegada() ;
                break;
            }
            case COL_LLEGADA_MANTENIMIENTO_RND:
            {
                value = datos.get(row).getInicioMantenimiento().getRnd() ;
                break;
            }
            case COL_LLEGADA_MANTENIMIENTO_TIEMPO:
            {
                value = datos.get(row).getInicioMantenimiento().gettMantenimiento() ;
                break;
            }
            case COL_LLEGADA_MANTENIMIENTO_PROXIMO:
            {
                value = datos.get(row).getInicioMantenimiento().getProxInicioMantenimiento() ;
                break;
            }
            case COL_FIN_MANTENIMIENTO_RND1:
            {
                value = datos.get(row).getFinMantenimiento().getRnd1() ;
                break;
            }
            case COL_FIN_MANTENIMIENTO_RND2:
            {
                value = datos.get(row).getFinMantenimiento().getRnd2() ;
                break;
            }
            case COL_FIN_MANTENIMIENTO_TIEMPO:
            {
                value = datos.get(row).getFinMantenimiento().getTMantenimiento() ;
                break;
            }
            case COL_FIN_MANTENIMIENTO_PROXIMO:
            {
                value = datos.get(row).getFinMantenimiento().getFinMantenimiento() ;
                break;
            }
            case COL_COLA:
            {
                value = datos.get(row).getColaAlumnos().getColaAlumnos() ;
                break;
            }
            case COL_FIN_INSCRIPCION_RND:
            {
                value = datos.get(row).getFinInscripcion().getRnd() ;
                break;
            }
            case COL_FIN_INSCRIPCION_TIEMPO:
            {
                value = datos.get(row).getFinInscripcion().gettInscripcion() ;
                break;
            }
            case COL_MAQUINA_1_ESTADO:
            {
                value = datos.get(row).getMaquinasList().get(0).getEstado().name() ;
                break;
            }
            case COL_MAQUINA_1_AC_INSCRIPTOS:
            {
                //Devuelve float, pero mostramos double... problem?
                value = datos.get(row).getMaquinasList().get(0).getAcumuladoInscriptos() ;
                break;
            }
            case COL_MAQUINA_1_HORA_FIN_INSCRIPCION:
            {
                value = datos.get(row).getMaquinasList().get(0).getFinInscripcion() ;
                break;
            }
            case COL_MAQUINA_1_FUE_MANTENIDA:
            {
                value = datos.get(row).getMaquinasList().get(0).fueAtendida() ;
                break;
            }            
            case COL_MAQUINA_2_ESTADO:
            {
                value = datos.get(row).getMaquinasList().get(1).getEstado().name() ;
                break;
            }
            case COL_MAQUINA_2_AC_INSCRIPTOS:
            {
                value = datos.get(row).getMaquinasList().get(1).getAcumuladoInscriptos() ;
                break;
            }
            case COL_MAQUINA_2_HORA_FIN_INSCRIPCION:
            {
                value = datos.get(row).getMaquinasList().get(1).getFinInscripcion() ;
                break;
            }
            case COL_MAQUINA_2_FUE_MANTENIDA:
            {
                value = datos.get(row).getMaquinasList().get(1).fueAtendida() ;
                break;
            }          
            case COL_MAQUINA_3_ESTADO:
            {
                value = datos.get(row).getMaquinasList().get(2).getEstado().name() ;
                break;
            }
            case COL_MAQUINA_3_AC_INSCRIPTOS:
            {
                value = datos.get(row).getMaquinasList().get(2).getAcumuladoInscriptos() ;
                break;
            }
            case COL_MAQUINA_3_HORA_FIN_INSCRIPCION:
            {
                value = datos.get(row).getMaquinasList().get(2).getFinInscripcion() ;
                break;
            }
            case COL_MAQUINA_3_FUE_MANTENIDA:
            {
                value = datos.get(row).getMaquinasList().get(2).fueAtendida() ;
                break;
            }
            case COL_MAQUINA_4_ESTADO:
            {
                value = datos.get(row).getMaquinasList().get(3).getEstado().name() ;
                break;
            }
            case COL_MAQUINA_4_AC_INSCRIPTOS:
            {
                value = datos.get(row).getMaquinasList().get(3).getAcumuladoInscriptos() ;
                break;
            }
            case COL_MAQUINA_4_HORA_FIN_INSCRIPCION:
            {
                value = datos.get(row).getMaquinasList().get(3).getFinInscripcion() ;
                break;
            }
            case COL_MAQUINA_4_FUE_MANTENIDA:
            {
                value = datos.get(row).getMaquinasList().get(3).fueAtendida() ;
                break;
            }
            case COL_MAQUINA_5_ESTADO:
            {
                value = datos.get(row).getMaquinasList().get(4).getEstado().name() ;
                break;
            }
            case COL_MAQUINA_5_AC_INSCRIPTOS:
            {
                value = datos.get(row).getMaquinasList().get(4).getAcumuladoInscriptos() ;
                break;
            }
            case COL_MAQUINA_5_HORA_FIN_INSCRIPCION:
            {
                value = datos.get(row).getMaquinasList().get(4).getFinInscripcion() ;
                break;
            }
            case COL_MAQUINA_5_FUE_MANTENIDA:
            {
                value = datos.get(row).getMaquinasList().get(4).fueAtendida() ;
                break;
            }
            case COL_AC_INSCRIPCIONES:
            {
                value = datos.get(row).getAcumuladoInscripciones() ;
                break;
            }
            case COL_AC_ALUMNOS_QUE_LLEGAN:
            {
                value = datos.get(row).getAcumuladoAlumnosQueLlegan() ;
                break;
            }
            case COL_AC_ALUMNOS_QUE_SE_VAN:
            {
                value = datos.get(row).getAcumuladoAlumnosQueLleganYSeVan() ;
                break;
            }
            case COL_ENCARGADO_ESTADO:
            {
                value = datos.get(row).getEncargado().getEstado().name() ;
                break;
            }
        }
        //TODO: Antes de devolver estos hay que parsear para que se vea bien en la tabla
        // Por ejemplo: 1.2232345435 -> 1.22323 o algo asi (de ser posible que sea en el 
        // mismo tipo de datos, sino hay q cambiar el createColumnList)
        if (value instanceof Double)
        {
            Double val = (Double) value;
            if (val == Double.MAX_VALUE)
            {
                value = 0;
            }
            //value = value; //Acá. Ojo con reloj y eso.
        }
        return value;
    }

    private void createColumnList() 
    {
        columns = new ArrayList<>();
        
        //Agregar cada objeto de columna a la lista

        //https://coderanch.com/t/333340/java/set-Line-wrap-Column-JTable 
        columns.add(new Columna("Reloj", Double.class, 75));
        columns.add(new Columna("Evento", String.class, 150));
        columns.add(new Columna("RND: LLegada Alumnos", Double.class, 150));
        columns.add(new Columna("Tiempo: Llegada Alumnos", Double.class, 150));
        columns.add(new Columna("Proxima Llegada Alumnos", Double.class, 160));
        columns.add(new Columna("RND: Llegada Mantenimiento: RND", Double.class, 150));
        columns.add(new Columna("Tiempo: Llegada Mantenimiento", Double.class, 150));
        columns.add(new Columna("Proxima Llegada Mantenimiento", Double.class, 160));
        columns.add(new Columna("RND1: Fin Mantenimiento: RND1", Double.class, 150));
        columns.add(new Columna("RND2: Fin Mantenimiento: RND2", Double.class, 150));
        columns.add(new Columna("Tiempo Fin Mantenimiento", Double.class, 150));
        columns.add(new Columna("Fin Mantenimiento: Hora fin", Double.class, 160));
        columns.add(new Columna("Cola Alumnos", Integer.class, 50));
        columns.add(new Columna("RND: Fin Inscripcion: RND", Double.class, 150));
        columns.add(new Columna("Tiempo Fin Inscripcion", Double.class, 150));
        columns.add(new Columna("Estado Maquina 1", String.class, 150));
        columns.add(new Columna("AC inscriptos Maquina 1", Integer.class, 50));
        columns.add(new Columna("Hora fin inscripcion Maquina 1", Double.class, 100));
        columns.add(new Columna("Fue mantenida? Maquina 1", Boolean.class, 50));
        columns.add(new Columna("Estado Maquina 2", String.class, 150));
        columns.add(new Columna("AC inscriptos Maquina 2", Integer.class, 50));
        columns.add(new Columna("Hora fin inscripcion Maquina 2", Double.class, 100));
        columns.add(new Columna("Fue mantenida? Maquina 2", Boolean.class, 50));
        columns.add(new Columna("Estado Maquina 3", String.class, 150));
        columns.add(new Columna("AC inscriptos Maquina 3", Integer.class, 50));
        columns.add(new Columna("Hora fin inscripcion Maquina 3", Double.class, 100));
        columns.add(new Columna("Fue mantenida? Maquina 3", Boolean.class, 50));
        columns.add(new Columna("Estado Maquina 4", String.class, 150));
        columns.add(new Columna("AC inscriptos Maquina 4", Integer.class, 50));
        columns.add(new Columna("Hora fin inscripcion Maquina 4", Double.class, 100));
        columns.add(new Columna("Fue mantenida? Maquina 4", Boolean.class, 50));
        columns.add(new Columna("Estado Maquina 5", String.class, 150));
        columns.add(new Columna("AC inscriptos Maquina 5", Integer.class, 50));
        columns.add(new Columna("Hora fin inscripcion Maquina 5", Double.class, 100));
        columns.add(new Columna("Fue mantenida? Maquina 5", Boolean.class, 50));
        columns.add(new Columna("Acum. Inscripciones", String.class, 125));
        columns.add(new Columna("Acum. Alumnos que llegan", String.class, 200));
        columns.add(new Columna("Acum. Alumnos que llegan y se van", String.class, 200));
        columns.add(new Columna("Estado Encargado", String.class, 300));
        
    }
    
//    public List<Columna> getColumnaList()
//    {
//        return columns;
//    }
//
//    public TableColumnModel getColumnModel() {
//        DefaultTableColumnModel tcModel = new DefaultTableColumnModel();
//        for (int i = 0; i < columns.size() ; i++)
//        {
//            TableColumn tc = new TableColumn(i, columns.get(i).getSize());
//            tc.setCellRenderer(new VECellRenderer());
//            tcModel.addColumn(tc);
//        }
//        return tcModel;
//    }

    public void setDatos(List<VectorEstadoUI> modelo) {
        datos = modelo;
    }

    public VectorEstadoUI getDato(int selectedRow) {
        return datos.get(selectedRow);
    }

    public void setColumnsWidth(TableColumnModel columnModel) {
        for (int i = 0; i < columnModel.getColumnCount(); i++)
        {
            columnModel.getColumn(i).setPreferredWidth(columns.get(i).getSize());
        }
    }
    
}
