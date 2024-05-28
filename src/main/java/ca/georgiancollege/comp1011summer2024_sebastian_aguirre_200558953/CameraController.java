package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CameraController {

    private ArrayList<String> camerasList =new ArrayList<String>();
    @FXML
    private ComboBox<String>combo;
    @FXML
    private TextField color,lens,make,model,sensor;

    @FXML
    private Label error,output;

    @FXML
    private ImageView image;

//    Create a Camera Object OUTSIDE of any method
    private Camera camera = new Camera();

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
//            Camera camera = new Camera(model.getText(), make.getText(),
//                    color.getText(), sensor.getText(), lens.getText());
            camera.setMake(make.getText());
            camera.setModel(model.getText());
            camera.setLens(lens.getText());
            camera.setColor(color.getText());
            camera.setSensor(sensor.getText());


            //Lab 2
            output.setText(camera.toString());

            camerasList.add(camera.toString());

            System.out.println(camerasList);

            addToComboBox(camera);

            error.setText("");
            model.setText("");
            make.setText("");
            color.setText("");
            sensor.setText("");
            lens.setText("");
        }
        catch(IllegalArgumentException e){
            error.setText(e.getMessage());
        }
    }

    public void initialize(){

        String path = getClass().getResource("photos").getPath();
        System.out.println(path);

        //runs right before the Stage is shown

        output.setText("");
        error.setText("");



    }

    @FXML
    private void addToComboBox(Camera c){
        combo.getItems().add(c.getMake() + ": " + c.getModel());
    }

    @FXML
    void onChange(ActionEvent event) {
        int index = combo.getSelectionModel().getSelectedIndex();

        output.setText(camerasList.get(index).toString());


    }

    @FXML
    void after(ActionEvent event) {
        String text = ((Button) event.getSource()).getText();
        System.out.println(text);



    }

    @FXML
    void before(ActionEvent event) {
        String text = ((Button) event.getSource()).getText();
        System.out.println(text);
    }





}
