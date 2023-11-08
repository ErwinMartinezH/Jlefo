/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.GLC;

import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class Gramatica2 {
    /*Una gramatica esta compuesta por reglas; este objeto es una gramatica
    por lo tanto tiene un conjunto de reglas.*/
    private ArrayList<Regla2> reglas = new ArrayList();
    private String ep = "?";
    private String cad = "", hojas="", Cadena;
    
    /*una producion es igual a el objeto regla, puede constar de no terminales y
    terminales, por lo tanto para crear una se deben tener estos dos argumentos*/
    public void addProduccion(Regla2 r){
        this.reglas.add(r);
    }
    
    public void removeProduccion(char c){
        ArrayList<Regla2> nuevalista = new ArrayList<>();
        for(Regla2 r : reglas){
            if(r.getInstruccion()[0] != '?')
                nuevalista.add(r);
        }
        reglas = nuevalista;
    }
}
