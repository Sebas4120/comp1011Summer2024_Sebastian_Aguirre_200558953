package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11;

import com.google.gson.Gson;

import java.io.IOException;

public class DogAPIRequest extends APIUtility {

    StringBuilder json = new StringBuilder();
    private Gson gson = new Gson();

    public Dog getData(String url){
        try {
            json.setLength(0);
            json.append(sendRequest(url));


            Dog dog = gson.fromJson(json.toString(), Dog.class);

            return dog;
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public DogByBreed getDogByBreed() throws IOException, InterruptedException {
        String url = "https://dog.ceo/api/breed/hound/images";
        json.setLength(0);
        json.append(sendRequest(url));

        return gson.fromJson(json.toString(), DogByBreed.class);
    }

//    public DogListAllBreeds getAllDogBreeds() throws IOException, InterruptedException {
//        String url = "https://dog.ceo/api/breeds/list/all";
//        json.setLength(0);
//        json.append(sendRequest(url));
//
//        return gson.fromJson(json.toString(), DogListAllBreeds.class);
//    }

}
