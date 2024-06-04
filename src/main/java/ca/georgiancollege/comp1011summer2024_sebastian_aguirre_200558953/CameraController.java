package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CameraController {

    @FXML
    Button btn;

    //Agrego el nodo donde apareceran las fotos
    @FXML
    private ImageView mainPhoto;

    private ArrayList<String> photoList = new ArrayList<>();

    private int photoListIndex;

    //Creo esta lista de camaras para poder agregarlas a mi comboBox
        private ArrayList<Camera> camerasList = new ArrayList<>();
        @FXML
        private ComboBox<String>combo;
    //---------------------------------------------------------
    @FXML
    private TextField color,lens,make,model,sensor;

    @FXML
    private Label error,output;



//    Create a Camera Object OUTSIDE of any method
    // Aca lo que estamos haciendo es reutiliza la botella de agua, no comprarnos una botella
// nueva cada vez que tengamos sed
    // Esto no tiene @FXML porque no es un nodo del Scenebuilder
//    private Camera camera = new Camera();

    @FXML
    void onSubmit(ActionEvent event) {
        model.getText();//gets the text inputted by the user in the TextField
        error.getText();

        /*
            Add the code to the controller
                evaluated each Textfield
                    determine that each TextField has a length() of at least 1
                        if not, send an error message to the error label
                        if so, instantiate a new Camera object and pass the values of TextFields
         */
        try {
            Camera camera = new Camera(model.getText(), make.getText(),
                    color.getText(), sensor.getText(), lens.getText());
//            camera.setMake(make.getText());
//            camera.setModel(model.getText());
//            camera.setLens(lens.getText());
//            camera.setColor(color.getText());
//            camera.setSensor(sensor.getText());


            //Lab 2 - aparece los datos que ingreso el usuario
            output.setText(camera.toString());

            //Si el usuario a ingresado los datos coorectos en cada seccion, agregamos esos datos
            // de la camara a la ArrayList
            camerasList.add(camera);

            //Imprimo la lista para verificar que datos se han puesto
            displayCamera();

            addToComboBox(camera);
//
//            error.setText("");
//            model.setText("");
//            make.setText("");
//            color.setText("");
//            sensor.setText("");
//            lens.setText("");
        }
        catch(IllegalArgumentException e){
            error.setText(e.getMessage());
        }
    }

    private void displayCamera(){
        for (Camera c : camerasList){
            System.out.println(c);
        }
        System.out.println("-".repeat(20));
    }
    
    public void initialize(){

        //This is an event listener, listen the button any time someone clicks on
        //Esto es una Anonymus function, porque las usamos? because it is an interface that
        // declares a method and this method needs a body

        //Anonymus function no pertenece a ninguna clase, 99% de las veces esta atado a data
        // source or an event
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        String path = getClass().getResource("photos").getPath();
        System.out.println(path);

        try{
            Path p = Path.of(getClass().getResource("photos").toURI());
            System.out.println(p.toFile().exists());

            //Obtenemos la lista de las camaras
//            camera1.jpeg
//            camera2.jpg
//            camera3.jpg
            for (File f : p.toFile().listFiles()){
                System.out.println(f.getName());
            }
        }catch(Exception e){
            System.err.println(e);
        }




        output.setText("");
        error.setText("");

    }

    //Este metodo agrega las camaras que el usuario ingresa, y en cada ingresada actualiza el
    // dropdown.
    @FXML
    private void addToComboBox(Camera c){
        combo.getItems().add(c.getMake() + ": " + c.getModel());
    }

    @FXML
    void onChange(ActionEvent event) {
//        System.out.println("change!");

        //Selection Model
        int index = combo.getSelectionModel().getSelectedIndex();

        output.setText(camerasList.get(index).toString());


    }

    @FXML
    void onArrowClick(ActionEvent event) {
//        String text = ((Button) event.getSource()).getText();
//        System.out.println(text);
        //Este codigo lo saco de los slides de la semana 3
//        mainPhoto.setImage(new Image(String.valueOf(getClass().getResource("photos/camera2.jpg"))));
//////        if (text.equals(">")) {
////            if (photoListIndex >= photoList.size() - 1) {
////                photoListIndex = 0;
////            } else {
////                photoListIndex++;
////            }
////        } else {
////            if (photoListIndex <= 0) {
////                photoListIndex = photoList.size() - 1;
////            } else {
////                photoListIndex--;
////            }
////        }
//
//        photoListIndex = text.equals(">") ? photoListIndex >= photoList.size() -1 ? 0 : photoListIndex + 1
//                : photoListIndex <= 0 ? photoList.size() - 1 : photoListIndex - 1;
//        System.out.println(photoList.get(photoListIndex));
//        mainPhoto.setImage(new Image(photoList.get(photoListIndex)));
//
    }









}
