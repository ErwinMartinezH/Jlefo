/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import HerramientaADP.Estado;
import HerramientaADP.Transicion;
import funciones.LienzoFromScroll;
import modelo.M_estado;
import modelo.M_transicion;
import vista.V_evaluoCadenas;
import vista.V_lienzo;
import vista.V_popupmenu;
import vista.V_tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static funciones.NmComponentes.*;


/**
 * @author herma
 */
public class C_slideMenu implements ActionListener {

    static boolean estados = false;
    private V_popupmenu menu;
    private List<M_estado> activo;
    private final String ACEPTACION = "Edo-Aceptacion";
    private final boolean EDOACEP = true;
    private final boolean EDONOACEP = false;
    static boolean seleccionar = false;
    static boolean transicion = false;
    private boolean analizar = false;
    private boolean evaluar = false;
    V_tabs tabs;
    public V_lienzo lienzo;
    public V_evaluoCadenas evaluo;
    ArrayList<Estado> estado = new ArrayList();

    public C_slideMenu(V_tabs tabs) {
        this.tabs = tabs;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Component cmp = (Component) e.getSource();
        switch (cmp.getName()) {
            case ESTADO:
                if (!estados) {
                    estados = true;
                    seleccionar = false;
                    transicion = false;
                    evaluar = false;
                    V_lienzo cursor = new LienzoFromScroll().obtener(tabs);
                    cursor.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                break;
            case TRANSICION:
                if (!transicion) {
                    transicion = true;
                    estados = false;
                    seleccionar = false;
                    evaluar = false;
                    V_lienzo cursor = new LienzoFromScroll().obtener(tabs);
                    cursor.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                break;
            case SELECCIONAR:
                if (!seleccionar) {
                    seleccionar = true;
                    estados = false;
                    transicion = false;
                    evaluar = false;
                    V_lienzo cursor = new LienzoFromScroll().obtener(tabs);
                    cursor.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                break;
            case ANALIZAR:
                if (!analizar) {
                    analizar = true;
                    seleccionar = false;
                    evaluar = false;
                    estados = false;
                    transicion = false;

                }
                analizar = false;

                if (tabs.getSelectedComponent() != null) {
                    V_lienzo check = new LienzoFromScroll().obtener(tabs);
                    check.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    MouseListener[] ml = check.getMouseListeners();
                    C_automata c = (C_automata) ml[0];
                    //boolean bandera = false;
                    if (check.getTipoPanel().equals(ADP)) {
                        /*try {
                            JOptionPane.showMessageDialog(null, "Aun no implementado");
                            bandera = true;
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Aun no implementado");
                            bandera = true;

                        }*/
                        List<M_transicion> transiciones = c.getTransiciones();
                        if (!transiciones.isEmpty() /*&& bandera == false*/) {
                            int i = 0;

                            while (i < transiciones.size()) {
                                //System.out.println(transiciones.get(i).getAlfabeto());
                                // Dividir la cadena usando coma y paréntesis como delimitadores
                                String alfabeto = transiciones.get(i).getAlfabeto();
                                String[] valores = alfabeto.replaceAll("[\\(\\)\\,]", "").split("\\s+");
                                Estado est = new Estado(transiciones.get(i).getDestino(), EDONOACEP);
                                est.addTransicion(new Transicion(transiciones.get(i).getDestino(), valores[1], valores[0], valores[2]));
                                estado.add(est);
                                //System.out.println(est);
                                //System.out.println(transiciones.get(i).getOrigen()+" "+valores[1]+ " "+valores[2] + " "+ valores[3]);
                                // Imprimir los valores de la cadena
                                /*for (String valor : valores) {
                                    System.out.println(valor);
                                }*/
                                /*ordenar los estados e imprimir las transiciones dependiendo del estado de donde sale, acumula las transiciones, ejemplo.
                                estado: 0
                                1,?,?,?
                                0,?,?,?

                                estado: 1
                                1,?,?,?
                                */


                                i++;
                            }
                        } else {
                            System.out.println("La lista de transiciones está vacía.");
                        }
                    }

                    if (!check.getTipoPanel().equals(ER) && !c.getEstados().isEmpty()
                            && !c.getTransiciones().isEmpty() && !check.getTipoPanel().equals(GLC)) {//analiza el automata correctamente
                        check.rastreo();
                    } else {
                        JOptionPane.showMessageDialog(tabs, "No hay nada que analizar",
                                "Analizar Autómata", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                } else {
                    JOptionPane.showMessageDialog(tabs, "No hay nada que analizar",
                            "Analizar Autómata", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                break;

            case EVALUAR:
                if (!evaluar) {
                    evaluar = true;
                    estados = false;
                    seleccionar = false;
                    transicion = false;
                    analizar = false;
                }
                evaluar = false;
                //Llamo a la clase evaluo
                evaluo = new V_evaluoCadenas();

                break;
        }
    }
}
