/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerramientasGLC;

import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class Gramatica {
    private ArrayList<regla> reglas = new ArrayList();
    private String Cadena = "", hojas="";
            
    public void setCadena(String s){
        this.Cadena = s;
    }
    
    public void addProduccion(String noT, String T){
        /*
        String nombre = "",instruccion = "",cache = "";
        
        for(int i = 0; i<s.length(); i++){//se separa el nombre de la regla
            
            cache = s.substring(i, i+1);
            
            if(cache.equals("-")) break;//cuado se llege al delimitador se detiene el ciclo
            else nombre+=cache;//hasta que no se llegue al delimitador se continua almacenando el nombre
        }
        
        instruccion = s.substring(nombre.length()+1);*/
        this.reglas.add(new regla(noT, T));
    }
    
    public String getProducciones(){
        String s = "";
        for(regla sr: this.reglas){
            s += sr.toString() + "\n";
        }
        return s;
    }   
    
    public regla getRegla(String nombre){//retorna una regla tomando como argumento su nombre
        regla r = null;
        for (regla e: reglas){
            if(e.nombre.equals(nombre)) {
                r =e;
                break;
            }            
        }
        return r;
    }
    
    public regla getRegla(String nombre, ArrayList<String> reglaInvalida ){//retorna una regla basandose en su nombre, y descarte de producciones
        regla r = null;
        for (regla e: this.reglas){
            if (e.nombre.equals(nombre)){//ciclo para regla
                boolean val = true;
                for(String i: reglaInvalida){//ciclo para reglainvalida
                    if(e.instruccion.equals(i)) val = false; 
                }
                if(val){
                    r = e;
                    break;
                }
            }       
        }
        return r;
    }
    
    public String subCadena(String s){
        String ss = "",cache = "";
        for(int i = 0; i < s.length(); i++){            
            cache = s.substring(i, i+1);
            
            if(cache.equals(cache.toUpperCase()))break;            
            else ss += cache;
        }
        return ss;
    }
    
    public void recorrido(String cadena){//primer metodo que hace llamada a la regla raiz
        regla r = getRegla("S");
        this.Cadena = cadena;
        this.hojas = "";
        
        int lona = r.subInstruccionA().length(), lonb = r.subInstruccionB().length();
        
        if(cadena.length() >= (lona + lonb)){//se valida que la longitud de la produccion sea menor o igual que la cadena
            if(r.subInstruccionA().equals(cadena.substring(0, lona))) {//aqui inicia y termina el arbol
            //if(r.subInstruccionA().equals(subCadena(cadena))) {
                hojas += r.subInstruccionA();
                
                
                ///----------analizar
                /*cadena = cadena.substring(lona);
                if (r.noTerminal() != null)
                    recorrido(cadena, getRegla(r.noTerminal()), new ArrayList());
                */
                if(hojas.equals(this.Cadena))
                    System.out.println("Cadena aceptada: " + hojas);
                    else System.out.println("No se encontro una produccion valida");//anilizar este camino, quizas sea la respuesta para no terminales
            }else {
                ArrayList<String> reglasInvalidas = new ArrayList();
                reglasInvalidas.add(r.instruccion);
                recorrido(cadena, getRegla(r.nombre, reglasInvalidas) , reglasInvalidas);
            }
        }
        
    }
    
    private void recorrido(String cadena, regla r, ArrayList<String> reglaInvalida){        
        if(r != null){
            
            int lona = r.subInstruccionA().length(), lonb = r.subInstruccionB().length();
            if(cadena.length() >= (lona + lonb)){//se valida que la longitud de la produccion sea menor o igual que la cadena
                if(r.subInstruccionA().equals(cadena.substring(0, lona))) {
                //if(r.subInstruccionA().equals(subCadena(cadena))) {//aqui inicia y termina el arbol
                    hojas += r.subInstruccionA();
                    
                    /*
                    cadena = cadena.substring(lona);
                    if (r.noTerminal() != null)
                        recorrido(cadena, getRegla(cadena.substring(0,1)), new ArrayList());*/
                    if(hojas.equals(this.Cadena))
                    System.out.println("Cadena aceptada: " + hojas);
                    else System.out.println("No se encontro una produccion valida");
                }
                else { 
                    //this.hojas=""; parte de lo que hay que analizar
                    reglaInvalida.add(r.instruccion);
                    recorrido(cadena, getRegla(r.nombre, reglaInvalida), reglaInvalida);
                }
            }else System.out.println("No se encontro una produccion valida");
        }else System.out.println("No se encontro una produccion valida");
    }
    
    public String recorridoRecursivo(String regla, String cadena){
        /*for (String e: reglas){
            
        }*/
        
        return "";
    }
}
