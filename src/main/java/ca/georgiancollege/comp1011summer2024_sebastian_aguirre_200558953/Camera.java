package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

public class Camera {
    //holaaa
    private String lens=""; // Estos cuando los declaras asi nunca seran nulos
    private String sensor="";

    private String color = "red";
    private String make="";

    private String model="";

    private float weight;
    private float videoHoursRecorded;

    protected int yearRealeased;

    private int numOfPhotosTaken;

    public Camera(){

    }
    public Camera(String lens, String sensor, String color, String make, String model) {
        this.lens = lens;
        this.sensor = sensor;
        this.color = color;
        this.make = make;
        this.model = model;
    }



    public boolean takePicture (int howMany){
        numOfPhotosTaken+= howMany;
        return true;
    }

    public boolean recordVideo(float howLong){

        videoHoursRecorded+=howLong;
        return true;
    }

    public boolean isOldCamera(){
        int currentYear=2024;
        return currentYear - yearRealeased>=3;
    }

    public boolean displayVideo(String... filters){
        for (String filter : filters){
            System.out.println("Applying filter: " + filter);
        }
        return true;
    }
}
