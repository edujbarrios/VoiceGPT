package VoiceGPT.asistente;

import com.google.cloud.dialogflow.v2.*;

public class AsistenteGoogle {
    private SessionsClient sessionsClient;
    private String projectId;

    public AsistenteGoogle(String apiKey, String projectId) {
        // Inicializar el cliente de Dialogflow
        sessionsClient = createSessionsClient(apiKey);
        this.projectId = projectId;
    }

    private SessionsClient createSessionsClient(String apiKey) {
        // Configurar las credenciales para el cliente de Dialogflow
        GoogleCredentials credentials;
        try {
            credentials = GoogleCredentials.fromStream(new FileInputStream(apiKey));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    
        // Crear un proveedor de credenciales para el cliente de Dialogflow
        CredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);
    
        // Configurar el ID de proyecto de Dialogflow
        String[] arr = apiKey.split("/");
        String projectId = arr[arr.length - 1].split("\\.")[0];
    
        SessionsSettings sessionsSettings;
        try {
            sessionsSettings = SessionsSettings.newBuilder()
                    .setCredentialsProvider(credentialsProvider)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    
        SessionsClient sessionsClient = SessionsClient.create(sessionsSettings);
    
        return sessionsClient;
    }    

    public String obtenerRespuesta(String pregunta) {
        // Crear la solicitud de detección de intención
        DetectIntentResponse response = detectIntent(pregunta);

        // Obtener la respuesta del asistente de Google
        String respuesta = extractMessageText(response);

        return respuesta;
    }

    private DetectIntentResponse detectIntent(String pregunta) {
        // Configurar la solicitud de detección de intención
        SessionName session = SessionName.of(projectId, "sessionId");
        TextInput.Builder textInput = TextInput.newBuilder().setText(pregunta).setLanguageCode("es");
        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        // Enviar la solicitud al asistente de Google
        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

        return response;
    }

    private String extractMessageText(DetectIntentResponse response) {
        // Obtener el mensaje de respuesta del asistente de Google
        String respuesta = response.getQueryResult().getFulfillmentText();

        return respuesta;
    }
}
