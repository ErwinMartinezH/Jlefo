
package HerramientasGLC.GenerarArbol1.src.arbolABB;

import javax.swing.JPanel;

/**
 *
 * @author Toloza XD
 */
public class SimuladorArboles {

    ArbolBB miArbol = new ArbolBB();

    public SimuladorArboles() {
    }

    public boolean insertar(String texto) {
        return (this.miArbol.agregar(texto));
    }
   
/*    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }
*/
    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
