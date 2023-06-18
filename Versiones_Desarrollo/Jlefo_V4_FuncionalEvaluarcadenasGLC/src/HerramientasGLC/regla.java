/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerramientasGLC;

/**
 *
 * @author jesus
 */
public class regla {
    String nombre, instruccion;
    
    public regla(String s, String ss){
        this.nombre = s;
        this.instruccion = ss;
    }
    
    public String subInstruccionA(){
        String s = "", cache = "";
        for(int i = 0; i < instruccion.length(); i++){            
            cache = instruccion.substring(i, i+1);
            
            if(cache.equals(cache.toUpperCase()))break;            
            else s += cache;
        }
        return s;
    }
    
    public String subInstruccionB(){
        if(subInstruccionA().length() == instruccion.length()) return "";
        else return instruccion.substring(subInstruccionA().length()+1);
    }
    
    public String noTerminal(){
        if(subInstruccionA().length() == instruccion.length()) return null;
        else return instruccion.substring(subInstruccionA().length(), subInstruccionA().length()+1);
    }
    
    @Override
    public String toString(){
        return nombre +"-"+instruccion;
    }
}
