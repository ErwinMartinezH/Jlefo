/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerramientaADP;

/**
 * @author jesus
 * Clase dedicada al formato de reglas en las transiones segun lo marcado en la
 * sintaxis de un Atomata De Pila
 * <p>
 * Input   ,           pop             ,           push
 * Dato leido   , dato a sacar de la pila   , dato a ingresar en la pila
 */
public class Transicion {
    int estde;
    String input, pop, push;

    public Transicion(int destino, String lectura, String pop, String push) {
        this.estde = destino;
        this.input = lectura;
        this.pop = pop;
        this.push = push;
    }

    @Override
    public String toString() {
        return input + ", " + pop + ", " + push + " /" + estde;
    }
}
