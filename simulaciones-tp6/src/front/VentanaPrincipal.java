package front;

import control.ControladorSimulacion;
import front.tablemodel.VectorEstadoTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Configuracion;
import model.VectorEstadoUI;
import objects.Alumno;
import objects.CantidadDeArchivos;
import objects.Euler;

public class VentanaPrincipal extends javax.swing.JFrame {

    private ControladorSimulacion controlador;
    private VectorEstadoTableModel model;
    private JTable tabla;
    private JTable tablaMontecarlo;
    private DefaultTableModel modeloMontecarlo;
    private PopUpAlumnos popUpAlumnos;
    private PopUpEuler popUpEuler;
    
    public VentanaPrincipal(ControladorSimulacion controlador) {
        this.controlador = controlador;
        popUpAlumnos = new PopUpAlumnos();
        popUpEuler = new PopUpEuler();
        initComponents();
        crearTabla();
        setearModeloDeTextos();
        btn_setear_defectoActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_simular = new javax.swing.JButton();
        btn_setear_defecto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMinutosASimular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMinutoDesde = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIteracionesAMostrar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLlegadaAlumnoMedia = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtInicioMantenimientoDesde = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtInicioMantenimientoHasta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPasoEulerH = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        panelMontecarlo = new javax.swing.JPanel();
        scpMontecarlo = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTiempoInscripcionDesde = new javax.swing.JTextField();
        txtTiempoInscripcionHasta = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txt_capacidad_maq1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_capacidad_maq2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_capacidad_maq3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_capacidad_maq4 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_capacidad_maq5 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txt_capacidad_sistema = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        txt_porcentaje_que_se_van = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        btnEuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TP6");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Del Rio, Lucas\nGodoy, Federico Nicolás\nHefty, Nicolás\nToloza, Macarena");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Integrantes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ejercicio E: Inscripción Exámenes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Grupo 5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(524, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        btn_simular.setText("Simular");
        btn_simular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simularActionPerformed(evt);
            }
        });

        btn_setear_defecto.setText("Setear valores por defecto");
        btn_setear_defecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setear_defectoActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar tabla alumnos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion inicial", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel4.setText("Tiempo a simular: (en minutos)");

        jLabel5.setText("Minuto para mostrar vector desde: ");

        jLabel6.setText("Cantidad de iteraciones a mostrar: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMinutosASimular, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMinutoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIteracionesAMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMinutosASimular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtMinutoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtIteracionesAMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Llegada Alumno"));

        jLabel7.setText("Distribución exponencial");

        jLabel8.setText("Media:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLlegadaAlumnoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLlegadaAlumnoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Mantenimiento"));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio Ronda Mantenimiento"));

        jLabel10.setText("Distribución Uniforme");

        jLabel11.setText("Desde:");

        jLabel12.setText("minutos");

        jLabel13.setText("Hasta:");

        jLabel14.setText("minutos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtInicioMantenimientoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtInicioMantenimientoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtInicioMantenimientoDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtInicioMantenimientoHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Demora Mantenimiento"));

        jLabel9.setText("Continua. Por Euler");

        jLabel15.setText("Paso (h):");

        jLabel17.setText("minutos");

        panelMontecarlo.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad de archivos"));

        scpMontecarlo.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scpMontecarlo.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scpMontecarlo.setMaximumSize(new java.awt.Dimension(350, 175));
        scpMontecarlo.setMinimumSize(new java.awt.Dimension(350, 175));
        scpMontecarlo.setPreferredSize(new java.awt.Dimension(350, 175));

        javax.swing.GroupLayout panelMontecarloLayout = new javax.swing.GroupLayout(panelMontecarlo);
        panelMontecarlo.setLayout(panelMontecarloLayout);
        panelMontecarloLayout.setHorizontalGroup(
            panelMontecarloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpMontecarlo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelMontecarloLayout.setVerticalGroup(
            panelMontecarloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpMontecarlo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMontecarlo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(35, 35, 35)
                                .addComponent(txtPasoEulerH, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPasoEulerH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMontecarlo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Demora Inscripcion"));

        jLabel19.setText("Distribución Uniforme");

        jLabel20.setText("Desde:");

        jLabel21.setText("Hasta:");

        jLabel22.setText("minutos");

        jLabel23.setText("minutos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtTiempoInscripcionHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtTiempoInscripcionDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTiempoInscripcionDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTiempoInscripcionHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configuracion", jPanel3);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.addTab("Vector Estado", null, jScrollPane3, "");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados estadisticos"));

        jLabel25.setText("Capacidad Maquina 1");

        txt_capacidad_maq1.setEditable(false);

        jLabel26.setText("Capacidad Maquina 2");

        txt_capacidad_maq2.setEditable(false);

        jLabel27.setText("Capacidad Maquina 3");

        txt_capacidad_maq3.setEditable(false);

        jLabel28.setText("Capacidad Maquina 4");

        txt_capacidad_maq4.setEditable(false);

        jLabel29.setText("Capacidad Maquina 5");

        txt_capacidad_maq5.setEditable(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(txt_capacidad_maq1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txt_capacidad_maq2))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txt_capacidad_maq3))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txt_capacidad_maq4))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(txt_capacidad_maq5)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_capacidad_maq1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(txt_capacidad_maq2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txt_capacidad_maq3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_capacidad_maq4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txt_capacidad_maq5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setText("Capacidad del sistema");

        txt_capacidad_sistema.setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_capacidad_sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_capacidad_sistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_porcentaje_que_se_van.setEditable(false);

        jLabel30.setText("Porcentaje de alumnos que llegan y se van");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_porcentaje_que_se_van, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_porcentaje_que_se_van, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        jLabel31.setText("Todas las capacidades expresadas en cantidad de alumnos atendidos por hora");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel31)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Resultados", jPanel10);

        btnEuler.setText("Mostrar tabla euler");
        btnEuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_setear_defecto)
                        .addGap(18, 18, 18)
                        .addComponent(btnEuler, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_simular)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_setear_defecto)
                    .addComponent(jButton1)
                    .addComponent(btn_simular)
                    .addComponent(btnEuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_setear_defectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setear_defectoActionPerformed
        Configuracion config = Configuracion.getConfiguracionPorDefecto();
        txtMinutosASimular.setText("" + config.getMinutosASimular());
        txtIteracionesAMostrar.setText("" + config.getIteracionesAMostrar());
        txtMinutoDesde.setText("" + config.getMinutoDesde());
        txtTiempoInscripcionDesde.setText("" + config.getTiempoInscripcionDesde());
        txtTiempoInscripcionHasta.setText("" + config.getTiempoInscripcionHasta());
        txtInicioMantenimientoDesde.setText("" + config.getInicioMantenimientoDesde());
        txtInicioMantenimientoHasta.setText("" + config.getInicioMantenimientoHasta());
        txtLlegadaAlumnoMedia.setText("" + config.getMediaLlegadaAlumnos());
        txtPasoEulerH.setText("" + config.getPasoEuler());
    }//GEN-LAST:event_btn_setear_defectoActionPerformed

    private void btn_simularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simularActionPerformed
        try
        {
            actualizarConfiguracion();
        }
        catch (InputException ie)
        {
            JOptionPane.showMessageDialog(null, ie.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(validarMinutoDesdeMayorACantMinutosASimular()) {
            JOptionPane.showMessageDialog(null,"El minuto desde no puede ser mayor a la cantidad de minutos a simular.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else if (Integer.parseInt(txtIteracionesAMostrar.getText()) <= 0){
            JOptionPane.showMessageDialog(null,"Cantidad de iteraciones no puede ser 0.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            model.setDatos(new ArrayList<>());
            controlador.simular();
            calcular_estadisticas();
            SwingUtilities.invokeLater( () -> { jTabbedPane1.setSelectedIndex(1);});
        }
    }//GEN-LAST:event_btn_simularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        popUpAlumnos.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEulerActionPerformed
        popUpEuler.setVisible(true);
    }//GEN-LAST:event_btnEulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEuler;
    private javax.swing.JButton btn_setear_defecto;
    private javax.swing.JButton btn_simular;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelMontecarlo;
    private javax.swing.JScrollPane scpMontecarlo;
    private javax.swing.JTextField txtInicioMantenimientoDesde;
    private javax.swing.JTextField txtInicioMantenimientoHasta;
    private javax.swing.JTextField txtIteracionesAMostrar;
    private javax.swing.JTextField txtLlegadaAlumnoMedia;
    private javax.swing.JTextField txtMinutoDesde;
    private javax.swing.JTextField txtMinutosASimular;
    private javax.swing.JTextField txtPasoEulerH;
    private javax.swing.JTextField txtTiempoInscripcionDesde;
    private javax.swing.JTextField txtTiempoInscripcionHasta;
    private javax.swing.JTextField txt_capacidad_maq1;
    private javax.swing.JTextField txt_capacidad_maq2;
    private javax.swing.JTextField txt_capacidad_maq3;
    private javax.swing.JTextField txt_capacidad_maq4;
    private javax.swing.JTextField txt_capacidad_maq5;
    private javax.swing.JTextField txt_capacidad_sistema;
    private javax.swing.JTextField txt_porcentaje_que_se_van;
    // End of variables declaration//GEN-END:variables

    private boolean validarMinutoDesdeMayorACantMinutosASimular() {
        return (Double.parseDouble(txtMinutoDesde.getText()) > Double.parseDouble(txtIteracionesAMostrar.getText()));
    }
    
    private void crearTabla() {
        /**
         * Crear variable de clase para JTable
         * Crear variable de clase para VectorEstadoTableModel
         */
        model = new VectorEstadoTableModel();
        tabla = new JTable(model);

        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.setColumnsWidth(tabla.getColumnModel());
        //Ask to be notified of selection changes.
        ListSelectionModel rowSM = tabla.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Ignore extra messages.
                if (e.getValueIsAdjusting()) return;

                ListSelectionModel lsm =
                    (ListSelectionModel)e.getSource();

                if (lsm.isSelectionEmpty()) {
                    //...//no rows are selected
                } else {
                    int selectedRow = lsm.getMinSelectionIndex();
                    if (model.getDato(selectedRow) != null)
                    {
                        setAlumnosModel(model.getDato(selectedRow).getAlumnos());
                        setEulerModel(model.getDato(selectedRow).getEuler());
                    }

                }
            }

            private void setEulerModel(List<Euler> euler) {
                popUpEuler.setEuler(euler);
            }
            
            private void setAlumnosModel(List<Alumno> alumnos) {
                popUpAlumnos.setAlumnos(alumnos);
            }
        });
        
        //Montecarlo
        tablaMontecarlo = new JTable();
        modeloMontecarlo = new MontecarloTM(Configuracion.getConfiguracion().getCantidadArchivos());
        tablaMontecarlo.setModel(modeloMontecarlo);
        tablaMontecarlo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMontecarlo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        scpMontecarlo.setViewportView(tablaMontecarlo);
        
    }

    public void setearModelo(List<VectorEstadoUI> modelo) 
    {
        model.setDatos(modelo);
        model.fireTableDataChanged();
    }
    
    private void calcular_estadisticas() {
        DecimalFormat formater = new DecimalFormat("0.0000");
        
        txt_capacidad_sistema.setText(String.valueOf(formater.format(controlador.getEstadisticas().getCapacidad_sistema())));
        txt_capacidad_maq1.setText(String.valueOf(formater.format(controlador.getEstadisticas().getCapacidad_maq1())));
        txt_capacidad_maq2.setText(String.valueOf(formater.format(controlador.getEstadisticas().getCapacidad_maq2())));
        txt_capacidad_maq3.setText(String.valueOf(formater.format(controlador.getEstadisticas().getCapacidad_maq3())));
        txt_capacidad_maq4.setText(String.valueOf(formater.format(controlador.getEstadisticas().getCapacidad_maq4())));
        txt_capacidad_maq5.setText(String.valueOf(formater.format(controlador.getEstadisticas().getCapacidad_maq5())));
        txt_porcentaje_que_se_van.setText(String.valueOf(formater.format(controlador.getEstadisticas().getPorcentaje_alumnos_que_se_van())) + " %");
    }

    private void setearModeloDeTextos() {
        
        btn_simular.setMnemonic('S');
        DoubleInputVerifier doubleVer = new DoubleInputVerifier();
        txtInicioMantenimientoDesde.setInputVerifier(doubleVer);
        txtInicioMantenimientoDesde.setInputVerifier(doubleVer);
        txtLlegadaAlumnoMedia.setInputVerifier(doubleVer);
        txtTiempoInscripcionDesde.setInputVerifier(doubleVer);
        txtTiempoInscripcionHasta.setInputVerifier(doubleVer);
        txtPasoEulerH.setInputVerifier(doubleVer);
        IntegerInputVerifier intVer = new IntegerInputVerifier();
        txtIteracionesAMostrar.setInputVerifier(intVer);
        txtMinutoDesde.setInputVerifier(intVer);
        txtMinutosASimular.setInputVerifier(intVer);
        
    }

    private void actualizarConfiguracion() throws InputException
    {
        try
        {
            if (Double.isNaN(Double.parseDouble(txtInicioMantenimientoDesde.getText())) ||
                    Double.parseDouble(txtInicioMantenimientoDesde.getText()) < 0)
            {
                throw new InputException("Inicio Mantenimiento Desde invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Inicio Mantenimiento Desde invalido");
        }
        Double mantDesde = Double.parseDouble(txtInicioMantenimientoDesde.getText());
        
        try
        {
            if (Double.isNaN(Double.parseDouble(txtInicioMantenimientoHasta.getText())) ||
                    Double.parseDouble(txtInicioMantenimientoHasta.getText()) < 0)
            {
                throw new InputException("Inicio Mantenimiento Hasta invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Inicio Mantenimiento Hasta invalido");
        }
        Double mantHasta = Double.parseDouble(txtInicioMantenimientoHasta.getText());
        
        if (mantHasta <= mantDesde)
        {
            throw new InputException("Inicio Mantenimiento el desde debe ser menor al hasta");
        }
        try
        {
            if (Double.isNaN(Double.parseDouble(txtTiempoInscripcionDesde.getText())) ||
                    Double.parseDouble(txtTiempoInscripcionDesde.getText()) < 0)
            {
                throw new InputException("Tiempo inscripcion desde invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Tiempo inscripcion desde invalido");
        }
        Double tiempoInscripcionDesde = Double.parseDouble(txtTiempoInscripcionDesde.getText());
        
        
        try
        {
            if (Double.isNaN(Double.parseDouble(txtTiempoInscripcionHasta.getText())) ||
                    Double.parseDouble(txtTiempoInscripcionHasta.getText()) < 0)
            {
                throw new InputException("Tiempo inscripcion hasta invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Tiempo inscripcion hasta invalido");
        }
        Double tiempoInscripcionHasta = Double.parseDouble(txtTiempoInscripcionHasta.getText());
        
        if (tiempoInscripcionHasta <= tiempoInscripcionDesde)
        {
            throw new InputException("Tiempo inscripcion el desde debe ser menor al hasta");
        }
        
        
        try
        {
            if (Double.isNaN(Double.parseDouble(txtLlegadaAlumnoMedia.getText())) ||
                    Double.parseDouble(txtLlegadaAlumnoMedia.getText()) < 0)
            {
                throw new InputException("Media llegada alumnos invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Media llegada alumnos invalido");
        }
        Double mediaLlegadaAlumnos = Double.parseDouble(txtLlegadaAlumnoMedia.getText());
        
        try
        {
            if (Double.isNaN(Double.parseDouble(txtPasoEulerH.getText())) ||
                    Double.parseDouble(txtPasoEulerH.getText()) < 0)
            {
                throw new InputException("Paso para Euler (h) invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Paso para Euler (h) invalido");
        }
        Double pasoEuler = Double.parseDouble(txtPasoEulerH.getText());
           
        try
        {
            if (Integer.parseInt(txtMinutosASimular.getText()) < 0)
            {
                throw new InputException("Minutos a sumular invalidos");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Minutos a sumular invalidos");
        }
        int minutosASimular = Integer.parseInt(txtMinutosASimular.getText());
        
        try
        {
            if (Integer.parseInt(txtMinutoDesde.getText()) < 0)
            {
                throw new InputException("Minuto desde invalido");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Minuto desde invalido");
        }
        int minutoDesde = Integer.parseInt(txtMinutoDesde.getText());
        
        try
        {
            if (Integer.parseInt(txtIteracionesAMostrar.getText()) < 0)
            {
                throw new InputException("Iteraciones a mostrar invalidos");
            }
        }
        catch (NumberFormatException nfe)
        {
            throw new InputException("Iteraciones a mostrar invalidos");
        }
        int iteracionesAMostrar = Integer.parseInt(txtIteracionesAMostrar.getText());
        
        Configuracion conf = Configuracion.getConfiguracion();
        conf.setInicioMantenimientoDesde(mantDesde);
        conf.setInicioMantenimientoHasta(mantHasta);
        conf.setIteracionesAMostrar(iteracionesAMostrar);
        conf.setMediaLlegadaAlumnos(mediaLlegadaAlumnos);
        conf.setMinutoDesde(minutoDesde);
        conf.setMinutosASimular(minutosASimular);
        conf.setTiempoInscripcionDesde(tiempoInscripcionDesde);
        conf.setTiempoInscripcionHasta(tiempoInscripcionHasta);
        conf.setPasoEulerH(pasoEuler);
//        conf.setTiempoMantenimientoDesviacion(tiempoMantenimientoDesviacion);
//        conf.setTiempoMantenimientoMedio(tiempoMantenimientoMedio);
        //Successs
    }

    private static class InputException extends Exception{

        public InputException(String msg)
        {
            super(msg);
        }
    }
    
    private class DoubleInputVerifier extends InputVerifier
    {
        @Override
        public boolean verify(JComponent input) {
            if (input instanceof JTextField)
            {
                JTextField txt = (JTextField) input;
                try
                {
                    Double val = obtenerValorDeCampo(txt);

                    if (val > 0)
                    {
                        return true;
                    }
                }
                catch (NumberFormatException nfe)
                {
                    return false;
                }
            }
            return false;
        }
        @Override
        public boolean shouldYieldFocus(JComponent input)
        {
            return true;
        }
    }
    
    private Double obtenerValorDeCampo(JTextField txt)
    {
        String entrada = txt.getText();
        if (entrada != null && !entrada.isEmpty())
        {
            return Double.parseDouble(entrada);
        }
        throw new NumberFormatException(entrada);
    }
    
    private class IntegerInputVerifier extends InputVerifier
    {

        @Override
        public boolean verify(JComponent input) {
            if (input instanceof JTextField)
            {
                JTextField txt = (JTextField) input;
                try
                {
                    Integer val = obtenerValorDeCampoEnInt(txt);

                    if (val > 0)
                    {
                        return true;
                    }
                }
                catch (NumberFormatException nfe)
                {
                    return false;
                }
            }
            return false;
        }
        
        @Override
        public boolean shouldYieldFocus(JComponent input)
        {
            return true;
        }
    }
    
    private Integer obtenerValorDeCampoEnInt(JTextField txt)
    {
        String entrada = txt.getText();
        if (entrada != null && !entrada.isEmpty())
        {
            return Integer.parseInt(entrada);
        }
        throw new NumberFormatException(entrada);
    }
    
    class MontecarloTM extends DefaultTableModel
    {
        private List<CantidadDeArchivos> datos;
        
        public MontecarloTM(List<CantidadDeArchivos> list)
        {
            datos = list;
        }
        
        @Override
        public int getRowCount() {
            return (datos != null ? datos.size() : 0);
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int columnIndex) {
            
            switch (columnIndex)
            {
                case 0:
                {
                    return "Cantidad de archivos";
                }
                case 1:
                {
                    return "Probabilidad";
                }
                case 2:
                {
                    return "Probabilidad Acumulada";
                }
                default: return "";
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Double.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            CantidadDeArchivos row = null;
            if (datos == null || rowIndex >= datos.size())
            {
                return null;
            }
            row = datos.get(rowIndex);
            switch (columnIndex)
            {
                case 0:
                {
                    return row.getCantidad();
                }
                case 1:
                {
                    return row.getProbabilidad();
                }
                case 2:
                {
                    return row.getProbabilidadAcumulada();
                }
                default:
                {
                    return null;
                }
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            return;
        }
    }
}
