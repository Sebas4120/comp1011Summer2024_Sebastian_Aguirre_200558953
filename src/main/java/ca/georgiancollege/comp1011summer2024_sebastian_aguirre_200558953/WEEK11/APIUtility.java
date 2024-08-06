package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//ESTO SE QUEDA TAL CUAL ESTA!!!!
public class APIUtility {

    public String sendRequest(String uri) throws IOException, InterruptedException {

        String json = "";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();
        }
        catch (Exception e) {
            System.err.println(e);
        }

        return json;

    }


}
