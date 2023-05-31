package VoiceGPT.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaRespuesta extends JFrame {
    private JTextArea chatGPTArea;
    private JTextArea asistenteArea;

    public VentanaRespuesta() {
        // Configurar la ventana de respuesta
        setTitle("VoiceGPT - Respuesta");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear componentes
        JLabel chatGPTLabel = new JLabel("Respuesta ChatGPT:");
        chatGPTArea = new JTextArea();
        chatGPTArea.setEditable(false);

        JLabel asistenteLabel = new JLabel("Respuesta Asistente:");
        asistenteArea = new JTextArea();
        asistenteArea.setEditable(false);

        // Panel para los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(chatGPTLabel);
        panel.add(new JScrollPane(chatGPTArea));
        panel.add(asistenteLabel);
        panel.add(new JScrollPane(asistenteArea));

        // Agregar panel a la ventana de respuesta
        add(panel, BorderLayout.CENTER);
    }

    public void mostrar() {
        setVisible(true);
    }

    public JTextArea getChatGPTArea() {
        return chatGPTArea;
    }

    public JTextArea getAsistenteArea() {
        return asistenteArea;
    }
}
