//Se creara una ventana que funcionara para evaluar cadenas manualmente por el usuario
package vista;

import javax.swing.*;
import java.awt.*;

public class V_evaluoCadenas {
    private JFrame frame;
    private JTextField textField;
    private JLabel resultLabel;

    public V_evaluoCadenas(){
        frame = new JFrame("Evaluación de Cadenas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Ingrese una cadena:");
        textField = new JTextField(20);
        JButton evaluateButton = new JButton("Evaluar");
        inputPanel.add(inputLabel);
        inputPanel.add(textField);
        inputPanel.add(evaluateButton);

        resultLabel = new JLabel();

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
