/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @author Toloza XD
 */
public class Nodo {
    private int dato;
    private String texto;
    private Nodo izq,der;

    public Nodo(int dato,String texto, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
        this.texto = texto;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    public String getTexto(){
      return texto;
    }
    public void setTexto(String texto){
      this.texto = texto;
    }
    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
 
}