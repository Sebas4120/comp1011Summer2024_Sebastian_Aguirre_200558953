package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.SQLOutput;

public class Week11 {

    static void example1() throws IOException, InterruptedException {

        APIUtility apiUtility = new APIUtility();
        String json = apiUtility.sendRequest("https://dog.ceo/api/breeds/image/random");
        System.out.println(json);
    }

    static void example2(){

        //call DogAPI request
        DogAPIRequest request = new DogAPIRequest();
        Dog dog = request.getData("https://dog.ceo/api/breeds/image/random");
        System.out.println(dog.getStatus());
        System.out.println(dog.getMessage());

    }

    static void example3() throws IOException, InterruptedException {
        DogAPIRequest request = new DogAPIRequest();
        DogByBreed dog = request.getDogByBreed();
        System.out.println(dog.getStatus());
        for(String img: dog.getMessage()){
            System.out.println(img);
        }
    }

    static void example4() throws IOException, InterruptedException {
        DogAPIRequest request = new DogAPIRequest();

        DogListAllBreeds breeds = request.getAllDogBreeds();

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        example1();
    }

}
