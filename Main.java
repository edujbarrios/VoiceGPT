
package VoiceGPT;

import VoiceGPT.gui.VentanaPrincipal;
import VoiceGPT.gui.VentanaRespuesta;
import VoiceGPT.chat.ChatGPT;
import VoiceGPT.asistente.AsistenteGoogle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de la ventana principal
        VentanaPrincipal ventana = new VentanaPrincipal();
        
        // Crear instancia del ChatGPT y el asistente de Google
        ChatGPT chatGPT = new ChatGPT();
        AsistenteGoogle asistenteGoogle = new AsistenteGoogle();
        
        // Agregar acción al botón de enviar en la ventana principal
        ventana.getEnviarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la pregunta ingresada por el usuario
                String pregunta = ventana.getPreguntaField().getText();
                
                // Obtener la respuesta del ChatGPT y el asistente de Google
                String respuestaChatGPT = chatGPT.generarRespuesta(pregunta);
                String respuestaAsistenteGoogle = asistenteGoogle.obtenerRespuesta(pregunta);
                
                // Mostrar la respuesta en la ventana de respuesta
                VentanaRespuesta ventanaRespuesta = new VentanaRespuesta();
                ventanaRespuesta.getChatGPTArea().setText(respuestaChatGPT);
                ventanaRespuesta.getAsistenteArea().setText(respuestaAsistenteGoogle);
                ventanaRespuesta.mostrar();
            }
        });
        
        // Mostrar la ventana principal
        ventana.mostrar();
    }
}
