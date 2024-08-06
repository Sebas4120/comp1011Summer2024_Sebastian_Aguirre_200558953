package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BallDontLieAPI {

    private String key = "vacvzvvadvad-fhdghdhd";
    private Gson gson = new Gson();
    public BallDontLieAPI(){
        try{
            key = Files.readString(Path.of("src/main/resources/ca/georgiancollege/ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953/data/ball_api.txt"));
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    private String sendRequest(String uri){

        String json = "";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(
                            URI.create(uri)
                    )
                    .header("Authorization", key)
                    .build();


            HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();

        }
        catch (Exception e){
            System.err.println(e);
        }

        return json;
    }

    public BallDontLieAllPlayers example1(){

        String uri = "https://api.balldontlie.io/v1/players?search=john&team_ids[]=20";
        return gson.fromJson(sendRequest(uri), BallDontLieAllPlayers.class);

    }

    public ListOfBallTeams getAllTeams() throws Exception{

        String uri = "https://api.balldontlie.io/v1/teams";

        Path path = Path.of("src/main/resources/ca/georgiancollege/ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953/data/teams_data.json");

        ListOfBallTeams teams;
        if(!Files.exists(path)){
            String json = sendRequest(uri);
            teams = gson.fromJson(json, ListOfBallTeams.class);
            Files.writeString(path, json);

            System.out.println("Sent API CAll");

        }
        else{
            teams = gson.fromJson(Files.readString(path), ListOfBallTeams.class);
            System.out.println("Read from file");

        }


        return teams;
    }


}
