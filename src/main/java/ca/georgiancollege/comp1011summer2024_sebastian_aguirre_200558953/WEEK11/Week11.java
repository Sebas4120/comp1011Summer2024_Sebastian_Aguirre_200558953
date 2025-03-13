package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11;

import java.io.IOException;
import java.util.ArrayList;

public class Week11 {

    static void example1() throws IOException, InterruptedException {
        APIUtility apiUtility = new APIUtility();
        String json = apiUtility.sendRequest("https://dog.ceo/api/breeds/image/random");
        System.out.println(json);
    }
    static void example2() throws IOException, InterruptedException {

        //call DogAPI request
        DogAPIRequest request = new DogAPIRequest();
        Dog dog = request.getData("https://dog.ceo/api/breeds/image/random");
        //output the message and status using two output statements
        System.out.println(dog.getStatus());
        System.out.println(dog.getMessage());
    }
    static void example3() throws IOException, InterruptedException {
        DogAPIRequest request = new DogAPIRequest();
        DogByBreed dogByBreed = request.getDogByBreed();

        System.out.println(dogByBreed.getStatus());

        for(String img : dogByBreed.getMessage()){
            System.out.println(img);
        }
    }
    static void example4() throws IOException, InterruptedException {
        DogAPIRequest request = new DogAPIRequest();
        DogListAllBreeds breeds = request.getAllDogBreeds();

        System.out.println(breeds.getStatus());

        String breed = breeds.getMessage().bulldog.get(2);

        System.out.println(breed);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        example4();
    }
}
