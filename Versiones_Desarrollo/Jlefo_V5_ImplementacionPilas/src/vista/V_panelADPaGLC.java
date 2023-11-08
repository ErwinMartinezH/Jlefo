package vista;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import modelo.M_estado;
import modelo.M_transicion;

public class V_panelADPaGLC extends JPanel {

    private List<M_estado> estados;
    private List<M_transicion> transiciones;

    public V_panelADPaGLC(List<M_estado> estados, List<M_transicion> transiciones) {
        this.estados = estados;
        this.transiciones = transiciones;
        this.setBackground(Color.GREEN);

        String s = "";

        for (M_estado edo : this.estados) {
            s += edo.toString() + "\n";

        }

        for (M_transicion transicion : this.transiciones) {
            s += transicion.toString() + "\n";
        }

        JTextArea textArea = new JTextArea(s);
        textArea.setEnabled(false);
        this.add(textArea);

    }

}
