/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import front.vista.simulacion.SimulacionMontecarlo;
import front.vista.simulacion.SimulacionMontecarloSetear;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabrielneil
 */
public class Calculator {

//cantidad de simulaciones realizadas 
    int cantExperimentos = 1;

    int acumSiSuperaLimite = 0;
    DefaultTableModel tm;
    DefaultTableModel tmPrimerTiro;
    DefaultTableModel tmSegundoTiroPara7;
    DefaultTableModel tmSegundoTiroPara8;
    DefaultTableModel tmSegundoTiroPara9;
    DefaultTableModel tmSegundoTiro;

    public Calculator() {

    }

    public void tablas(SimulacionMontecarlo tablaSimulacion, int cantSim, int desde, int hasta) {
        seteoTablas(tablaSimulacion);

        for (int i = 0; i < cantSim; i++) {
            if ((cantExperimentos >= desde && cantExperimentos <= hasta) || i == cantSim - 1) {
                simulacionEnGrafico(10, 20, 15, 120);
            } else {
                simulacion(10, 20, 15, 120);
            }
        }
        tablaSimulacion.setVisible(true);
    }

    public void tablas(SimulacionMontecarlo tablaSimulacion, int cantSim, int desde, int hasta, int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        seteoTablas(tablaSimulacion);

        for (int i = 0; i < cantSim; i++) {
            if ((cantExperimentos >= desde && cantExperimentos <= hasta) || i == cantSim - 1) {
                simulacionEnGrafico(cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
            } else {
                simulacion(cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
            }
        }
        tablaSimulacion.setVisible(true);
    }
    
    public void especificoTablas(SimulacionMontecarloSetear tablaSimulacion, int cantSim, int desde, int hasta, int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        especificoSeteoTablas(tablaSimulacion);

        for (int i = 0; i < cantSim; i++) {
            if ((cantExperimentos >= desde && cantExperimentos <= hasta) || i == cantSim - 1) {
                simulacionEnGrafico(cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
            } else {
                simulacion(cantRondas, puntosPrimerTiro, puntosSegundoTiro, valorASuperar);
            }
        }
    }
    

    public void simulacion(int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        Random r = new Random();
        int puntaje;
        int puntosAcum = 0;
        boolean flag = false;

        //       0       1       2          3        4         5                6                  7               8                       9            10
        // simulacion  ronda    rnd1    1erTiro     rnd2    2doTiro     totalPinosTirados   puntosTotales   puntosAcumulados    booleano superoLos120   acumuladorSiSupera120  
        for (int i = 0; i < cantRondas; i++) {
            float rnd1 = r.nextFloat();
            int tiro1 = calculoTiro1(rnd1);

            if (tiro1 == 10) {
                puntaje = puntosPrimerTiro;
                puntosAcum += puntaje;
                if (puntosAcum >= valorASuperar && flag == false) {
                    acumSiSuperaLimite++;
                    flag = true;
                }
            } else {

                float rnd2 = r.nextFloat();
                int tiro2 = calculoTiro2(tiro1, rnd2);
                int cantPinosTirados = tiro1 + tiro2;
                puntaje = (cantPinosTirados == 10) ? puntosSegundoTiro : cantPinosTirados;
                puntosAcum += puntaje;
                if (puntosAcum >= valorASuperar && flag == false) {
                    acumSiSuperaLimite++;
                    flag = true;
                }
            }

        }
        cantExperimentos++;
    }

    public void simulacionEnGrafico(int cantRondas, int puntosPrimerTiro, int puntosSegundoTiro, int valorASuperar) {
        Random r = new Random();
        int contador = 1;
        int puntaje;
        int puntosAcum = 0;
        boolean flag = false;
        
        //       0       1       2          3        4         5                6                  7               8                       9            10
        // simulacion  ronda    rnd1    1erTiro     rnd2    2doTiro     totalPinosTirados   puntosTotales   puntosAcumulados    booleano superoLos120   acumuladorSiSupera120  
        for (int i = 0; i < cantRondas; i++) {

            float rnd1 = r.nextFloat();
            int tiro1 = calculoTiro1(rnd1);

            if (tiro1 == 10) {
                puntaje = puntosPrimerTiro;
                puntosAcum += puntaje;
                tm.addRow(new Object[]{cantExperimentos, contador, rnd1, tiro1, "-", "-", tiro1, puntaje, puntosAcum, (puntosAcum >= valorASuperar) ? true : false, acumSiSuperaLimite});
                if (puntosAcum >= valorASuperar && flag == false) {
                    acumSiSuperaLimite++;
                    flag = true;
                }
            } else {

                float rnd2 = r.nextFloat();
                int tiro2 = calculoTiro2(tiro1, rnd2);
                int cantPinosTirados = tiro1 + tiro2;
                puntaje = (cantPinosTirados == 10) ? puntosSegundoTiro : cantPinosTirados;
                puntosAcum += puntaje;
                tm.addRow(new Object[]{cantExperimentos, contador, rnd1, tiro1, rnd2, tiro2, cantPinosTirados, puntaje, puntosAcum, (puntosAcum >= valorASuperar) ? true : false, acumSiSuperaLimite});
                if (puntosAcum >= valorASuperar && flag == false) {
                    acumSiSuperaLimite++;
                    flag = true;
                }
            }

            contador++;
        }
        cantExperimentos++;
    }

    private int calculoTiro1(float rnd1) {
        int nPinosTirados = 0;
        for (int i = 0; i < tmPrimerTiro.getRowCount(); i++) {
            if (rnd1 < (float) tmPrimerTiro.getValueAt(i, 2)) {
                nPinosTirados = Integer.parseInt((String)tmPrimerTiro.getValueAt(i, 0));
                break;
            }
        }
        return nPinosTirados;
    }

    private int calculoTiro2(int tiro1, float rnd2) {
        int nPinosTirados = 0;

        switch (tiro1) {
            case 7:
                for (int i = 0; i < tmSegundoTiroPara7.getRowCount(); i++) {
                    if (rnd2 < (float) tmSegundoTiroPara7.getValueAt(i, 2)) {
                        nPinosTirados = Integer.parseInt((String)tmSegundoTiroPara7.getValueAt(i, 0));
                        break;
                    }
                }
                break;
            case 8:
                for (int i = 0; i < tmSegundoTiroPara8.getRowCount(); i++) {
                    if (rnd2 < (float) tmSegundoTiroPara8.getValueAt(i, 2)) {
                        nPinosTirados = Integer.parseInt((String)tmSegundoTiroPara8.getValueAt(i, 0));
                        break;
                    }
                }
                break;
            case 9:
                for (int i = 0; i < tmSegundoTiroPara9.getRowCount(); i++) {
                    if (rnd2 < (float) tmSegundoTiroPara9.getValueAt(i, 2)) {
                        nPinosTirados = Integer.parseInt((String)tmSegundoTiroPara9.getValueAt(i, 0));
                        break;
                    }
                }
                break;
        }
        return nPinosTirados;
    }

    private void seteoTablas(SimulacionMontecarlo tablaSimulacion) {
        tm = (DefaultTableModel) tablaSimulacion._tblMontecarlo.getModel();
        tmPrimerTiro = (DefaultTableModel) tablaSimulacion.tblPrimerTiro.getModel();
        tmSegundoTiroPara7 = (DefaultTableModel) tablaSimulacion.tblDespues7.getModel();
        tmSegundoTiroPara8 = (DefaultTableModel) tablaSimulacion.tblDespues8.getModel();
        tmSegundoTiroPara9 = (DefaultTableModel) tablaSimulacion.tblDespues9.getModel();
    }
    
    private void especificoSeteoTablas(SimulacionMontecarloSetear tablaSimulacion) {
        tm = (DefaultTableModel) tablaSimulacion._tblMontecarlo.getModel();
        tmPrimerTiro = (DefaultTableModel) tablaSimulacion.tblPrimerTiro.getModel();
        tmSegundoTiroPara7 = (DefaultTableModel) tablaSimulacion.tblDespues7.getModel();
        tmSegundoTiroPara8 = (DefaultTableModel) tablaSimulacion.tblDespues8.getModel();
        tmSegundoTiroPara9 = (DefaultTableModel) tablaSimulacion.tblDespues9.getModel();
    }

    public int cantidadExperimentosValidos() {
        return acumSiSuperaLimite;
    }
}
