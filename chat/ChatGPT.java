package VoiceGPT.chat;

import ai.openai.gpt.ChatCompletion;
import ai.openai.gpt.Gpt3Client;

public class ChatGPT {
    private Gpt3Client gpt3Client;

    public ChatGPT(String apiKey) {
        // Inicializar el cliente de ChatGPT
        gpt3Client = new Gpt3Client(apiKey);
    }

    public String generarRespuesta(String pregunta) {
        // Solicitar respuesta a ChatGPT
        ChatCompletion.Result respuesta = gpt3Client.completeConversation("chatgpt-123", pregunta);

        // Obtener la respuesta generada por ChatGPT
        String respuestaGenerada = respuesta.getChoices().get(0).getText();

        return respuestaGenerada;
    }
}
