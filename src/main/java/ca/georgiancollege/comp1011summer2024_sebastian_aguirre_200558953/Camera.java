package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

public class Camera {
    //holaaa
    private String lens=""; // Estos cuando los declaras asi nunca seran nulos
    private String sensor="";

    private String color = "";
    private String make="";

    private String model="";

    private float weight;
    private float videoHoursRecorded;

    protected int yearRealeased;

    private int numOfPhotosTaken;

    public Camera(){

    }
    public Camera(String lens, String sensor, String color, String make, String model) {
//        this.lens = lens;
//        this.sensor = sensor;
//        this.color = color;
//        this.make = make;
//        this.model = model;
        setModel(model);
        setMake(make);
        setColor(color);
        setSensor(sensor);
        setLens(lens);
    }

    private void validate(String title, String data){
        if (data.trim().isEmpty()){
            throw new IllegalArgumentException(title + "is too short");
        }
    }
    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        validate("Lens", lens);
        this.lens = lens;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        validate("Sensor", sensor);
        this.sensor = sensor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        validate ("color", color);
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        validate("make", make);
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        validate("model", model);
        this.model = model;
    }

    public boolean takePicture (int howMany){
        numOfPhotosTaken+=howMany;
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
