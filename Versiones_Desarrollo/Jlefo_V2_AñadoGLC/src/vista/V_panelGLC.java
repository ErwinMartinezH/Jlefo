package vista;

import HerramientasGLC.C_gramatica;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class V_panelGLC extends JPanel {//panel grafico de el lenguaje de gramatica libre de contexto

    public V_panelGLC() {
        componentes();
    }
    private C_gramatica ctrlGLC;
    public JTable getTablaCadenas() {
        return tablaCadenas;
    }
    public void setTablaCadenas(JTable tablaCadenas) {
        this.tablaCadenas = tablaCadenas;
    }
    public JLabel getEtqColumna() {
        return etqColumna;
    }

    public JLabel getEtqError() {
        return etqError;
    }

    public void setVisibleEtqError(boolean b) {
        etqColumna.setVisible(b);
    }

    public JTextField getEntrada() {
        return entrada;
    }

    public void setjTextER(String c) {
        entrada.setText(c);
    }

    public void setEtqError(String c) {
        etqError.setText(c);
    }


    private void componentes() {
        ctrlGLC = new C_gramatica(this);
        setLayout(null);
        setBounds(0, 0, 800, 600);
        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(null, "Gramática Libre de Contexto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 14), new Color(102, 102, 102))); // NOI18N
        setForeground(new Color(102, 102, 102));
        setFont(new Font("Arial", 0, 12)); // NOI18N
        setPreferredSize(new Dimension(800, 600));

        entrada = new JTextField();
        entrada.setBounds(20, 30, 760, 30);
        entrada.setFont(new Font("Arial", 0, 14)); // NOI18N
        entrada.setForeground(new Color(102, 102, 102));
        entrada.setBorder(BorderFactory.createTitledBorder(null, "Cadena a evaluar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 12), new Color(102, 102, 102))); // NOI18N
        entrada.setCaretColor(new Color(102, 102, 102));
        entrada.setSelectionColor(new Color(102, 102, 102));
        add(entrada);

        etqError = new JLabel();
        etqError.setBounds(20, 70, 760, 30);
        etqError.setFont(new Font("Arial", 0, 14)); // NOI18N
        etqError.setForeground(new Color(102, 102, 102));
        etqError.setBorder(BorderFactory.createTitledBorder(null, "Error", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 12), new Color(102, 102, 102))); // NOI18N
        add(etqError);

        etqColumna = new JLabel();
        etqColumna.setBounds(20, 110, 760, 30);
        etqColumna.setFont(new Font("Arial", 0, 14)); // NOI18N
        etqColumna.setForeground(new Color(102, 102, 102));
        etqColumna.setBorder(BorderFactory.createTitledBorder(null, "Columna", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 12), new Color(102, 102, 102))); // NOI18N
        add(etqColumna);

        tablaCadenas = new JTable();
        tablaCadenas.setBounds(20, 150, 760, 400);
        tablaCadenas.setFont(new Font("Arial", 0, 14)); // NOI18N
        tablaCadenas.setForeground(new Color(102, 102, 102));
        tablaCadenas.setBorder(BorderFactory.createTitledBorder(null, "Tabla de Cadenas", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", 1, 12), new Color(102, 102, 102))); // NOI18N;
        add(tablaCadenas);

    }
    private JLabel etqError;
    private JLabel etqColumna;
    private JTextField entrada;
    private JTable tablaCadenas;


}
