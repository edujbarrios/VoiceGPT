package VoiceGPT.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTextField preguntaField;
    private JButton enviarButton;

    public VentanaPrincipal() {
        // Configurar la ventana principal
        setTitle("VoiceGPT");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear componentes
        JLabel preguntaLabel = new JLabel("Escribe tu pregunta:");
        preguntaField = new JTextField();
        enviarButton = new JButton("Enviar");

        // Panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(preguntaLabel);
        panel.add(preguntaField);
        panel.add(enviarButton);

        // Agregar panel a la ventana principal
        add(panel, BorderLayout.CENTER);
    }

    public void mostrar() {
        setVisible(true);
    }

    public JTextField getPreguntaField() {
        return preguntaField;
    }

    public JButton getEnviarButton() {
        return enviarButton;
    }
}
