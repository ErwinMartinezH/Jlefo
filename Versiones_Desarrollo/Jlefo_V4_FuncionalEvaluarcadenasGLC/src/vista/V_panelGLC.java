package vista;

import HerramientasGLC.Arbol;
import HerramientasGLC.Gramatica;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class V_panelGLC extends JPanel {//panel grafico de el lenguaje de gramatica libre de contexto

    /*Se establecera en el panel un cuadro con 2 columnas, la primer columna
     * es para los no terminales y la segunda columna son para los terminales */

    private JPanel panel;//panel principal de la tabla
    private JPanel panel2;//Panel para los botones
    private JPanel panel3;//Panel para el arbol de derivacion
    private JFrame frame;//Panel para la ventana del arbol de derivacion
    private JTextField cadena;//Cadena a evaluar
    private JTable tabla;
    private JScrollPane scroll;
    private JButton b_probar;
    private JButton b_eliminartb;
    private JButton b_añadir;
    private JButton b_eliminarF;
    private JButton b_abrir;
    private JButton b_nuevo;

    public V_panelGLC() {
        componentes();
        accionRaton();
        accionBotones();
        dibujarArbol();
    }

    private void componentes() {
        panel = new JPanel();
        panel.setBorder(new TitledBorder("Lenguaje de Gramatica Libre de Contexto"));
        panel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.setBackground(new Color(255, 255, 255, 255));
        panel.setPreferredSize(new Dimension(700, 500));
        panel.setLayout(new BorderLayout());
        //Posicionar la tabla en el centro del panel
        tabla = new JTable();
        tabla.setFont(new Font("Arial", Font.BOLD, 12));
        tabla.setBackground(new Color(255, 255, 255));
        tabla.setForeground(new Color(0, 0, 0));
        tabla.setShowGrid(true);
        tabla.setGridColor(new Color(0, 0, 0));
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(true);
        tabla.setPreferredScrollableViewportSize(new Dimension(650, 400));
        tabla.setFillsViewportHeight(true);
        scroll = new JScrollPane(tabla);
        panel.add(scroll);
        this.add(panel);
        //Agregar botones abajo de la tabla: agregar, eliminar, editar, guardar, abrir, nuevo
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        cadena = new JTextField(20);
        b_probar = new JButton("Ejecutar");
        b_eliminartb = new JButton("Eliminar datos en tabla");
        b_añadir = new JButton("Añadir filas");
        b_eliminarF = new JButton("Eliminar fila");
        b_abrir = new JButton("Abrir");
        b_nuevo = new JButton("Nuevo");
        panel2.add(cadena);
        panel2.add(b_probar);
        panel2.add(b_eliminartb);
        panel2.add(b_añadir);
        panel2.add(b_eliminarF);
        panel2.add(b_abrir);
        panel2.add(b_nuevo);
        panel.add(panel2, BorderLayout.SOUTH);

        //Añadimos un ejemplo de gramatica libre de contexto a la tabla
        String[] columnas = {"No terminales", "Terminales"};
        String[][] datos = {{"S", "ab"}, {"S", "abc"}, {"S", "acb"}};
        tabla.setModel(new DefaultTableModel(datos, columnas));
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tabla.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.setEnabled(true);

    }

    public void accionRaton() {
        //Se crea accion de deseleccionar la fila de la tabla al hacer click en cualquier parte del panel1 o panel2
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla.clearSelection();
            }
        });
    }

    public void accionBotones() {
        //usaremos el b_probar para ejecutar la gramatica libre de contexto
        b_probar.addActionListener(e -> {
            /*Apreto el b_probar con click izquierdo del raton?, si lo apreto mostrar dibujararbol*/
            if (e.getModifiers() == 16) {
                /*toma los datos de la tabla y se guardan en una matriz*/
                Gramatica gr = new Gramatica();
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    gr.addProduccion(tabla.getValueAt(i, 0).toString(), tabla.getValueAt(i, 1).toString());
                }
                /*se evalua las cadenas*/
                gr.recorrido(cadena.getText());
                /*se crea un frame para mostrar el arbol de derivacion*/
                dibujarArbol();
                frame.setVisible(true);

            } else {
                //Colapsa frame de la ventana del arbol de derivacion
                frame.setVisible(false);
            }
        });
        //usaremos el b_eliminartb para eliminar todos los datos de la tabla
        b_eliminartb.addActionListener(e -> {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        });
        //usaremos el b_añadir para añadir filas a la tabla
        b_añadir.addActionListener(e -> {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{"", ""});
        });
        //usaremos el b_eliminarF para eliminar filas de la tabla de abajo hacia arriba
        b_eliminarF.addActionListener(e -> {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            if (filas > 0) {
                modelo.removeRow(filas - 1);
            }
        });
    }

    public void dibujarArbol() {//Crearemos arboles de derivacion en el frame y dentro el panel3
        frame = new JFrame("Arbol de derivacion");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        //Agregar icono a la ventana
        ImageIcon icono = new ImageIcon("src/img_icon/arbol.png");
        frame.setIconImage(icono.getImage());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(false);
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.setBackground(new Color(255, 255, 255));
        frame.add(panel3);
        /*Tomara los valores de las filas de la tabla y los dibujara un arbol de derivacion en el panel3*/
        String[] columnas = {"No terminales", "Terminales"};
        String[][] datos = new String[tabla.getRowCount()][2];
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < 2; j++) {
                datos[i][j] = (String) tabla.getValueAt(i, j);
            }
        }
        //Crear arbol de derivacion
        Arbol arbol = new Arbol(datos);
        //Crear arbol de derivacion en el panel3
        arbol.crearArbol(panel3);
    }

}
