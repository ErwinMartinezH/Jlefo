/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerramientaADP;

import java.util.ArrayList;

/**
 * @author jesus
 */
public class Prueba {
    public static void main(String args[]) {

        ArrayList<Estado> estados = new ArrayList();

        Estado est = new Estado(0, false);
        est.addTransicion(new Transicion(1, "a", "?", "?"));
        estados.add(est);


        est = new Estado(1, false);
        est.addTransicion(new Transicion(1, "a", "?", "?"));
        est.addTransicion(new Transicion(2, "b", "?", "?"));
        estados.add(est);

        est = new Estado(2, false);
        est.addTransicion(new Transicion(2, "b", "?", "?"));
        est.addTransicion(new Transicion(3, "?", "Z", "?"));
        estados.add(est);

        est = new Estado(3, true);
        estados.add(est);

        Automata au = new Automata(estados);
        au.movimiento("bb");
        
        /*
        ArrayList <Estado> e = au.getAutomata_ArrayList();        
        for(Estado e1: e){
            e1.getNombre();
        }
        */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Automata(estados).movimiento("aaaccccccccbbb");
            }
        });*/
    }

}
