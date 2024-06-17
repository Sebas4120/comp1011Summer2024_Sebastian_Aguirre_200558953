package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CameraController {


    EventHandler<MouseEvent> mouseEventEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Random Mouse Event");
        }
    };

    @FXML
    Button btn,btnEdit,btnDelete;

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

    @FXML
    private ImageView rightPhoto;

    @FXML
    private Slider slider;

//**********************************************************************
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
                    color.getText(), sensor.getText(), lens.getText(),(int)slider.getValue());



            //Establezco la foto de la camara en la imagen derecha
            camera.setPhoto(photoList.get(photoListIndex));

            rightPhoto.setImage(
                    new Image(String.valueOf(getClass().getResource(camera.getPhoto()))
                    )
            );


//            rightPhoto.setImage(
//                    new Image(
//                            String.valueOf(getClass().getResource("photos/edit.png"))
//                    )
//            );

            //Lab 2 - aparece los datos que ingreso el usuario
            output.setText(camera.toString());

            //Si el usuario a ingresado los datos correctos en cada seccion, agregamos esos datos
            // de la camara a la ArrayList, y esta lista es la que estara en el combobox
            camerasList.add(camera);

            //Imprimo la lista para verificar que datos se han puesto
            displayCamera();

            addToComboBox(camera);

            error.setText("");
            model.setText("");
            make.setText("");
            color.setText("");
            sensor.setText("");
            lens.setText("");

            //Add megapixels to the camera from the slider
            camera.setMegaPixels((int) slider.getValue());
            System.out.println(camera.getMegaPixels());

            //Why is like this: camera.setMegaPixels((int) slider.getValue()); ?
            //Because the slider returns a double, and the setMegaPixels method is expecting an int
            // so we need to cast the double to an int


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

 //LAMBDA ****************************************
        //Right Click!!!
        btn.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent e) {
                System.out.println("Clicked the context menu");
            }
        });

//        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                System.out.println("Clicked the mouse");
//            }
//        });

        //lEFT CLICK
        btn.setOnMouseClicked( (e) -> {
            System.out.println("Clicked LEFT mouse");
        });

        //Cuando el mouse sale del boton
        btn.setOnMouseExited(e -> System.out.println("Exited mouse"));

        //Cuando el mouse entra al boton
        btn.setOnMouseEntered( (e) -> {System.out.println("Entered mouse");   }    );

        //Cuando el mouse se mueve dentro del boton
        btn.setOnMouseMoved(mouseEventEventHandler);

//*******************************************************************

//This is an event listener, listen the button any time someone clicks on
//Esto es una Anonymus function, porque las usamos? because it is an interface that
// declares a method and this method needs a body

//Porque existe? porque es una interface que tiene un metodo, y este metodo neceista un
// cuerpo.

//Anonymus function no pertenece a ninguna clase, 99% de las veces esta atado a data
// source or an event
        btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("click from the mouse");
            }
        });

    //IMAGENESSSSSSSSSSSSSSSSSS
        String path = getClass().getResource("photos").getPath();
        System.out.println(path);

        try{
            Path p = Path.of(getClass().getResource("photos").toURI());
            System.out.println(p.toFile().exists());

            //Obtenemos la lista de las camaras
//            camera1.jpeg
//            camera2.jpg
//            camera3.jpg
            for (File filePath : p.toFile().listFiles()){
               // photoList.add("photos/"+filePath);

                //Con esto evito que se vean las imagenes que no son camaras
                if(filePath.getName().contains("default")){
                    continue;
                } else if (filePath.getName().contains("edit")){
                    continue;

                }else if (filePath.getName().contains("app")){
                    continue;
                }

                photoList.add("photos/" + filePath.getName());
                System.out.println(filePath.getName());
            }

//            btnEdit.setText("");
//            btnEdit.setGraphic(
//                    new ImageView(
//                            new Image(getClass().getResource("photos/edit.png")))
//            );


            //Agrego la imagen a mi boton de "edit"
            btnEdit.setGraphic(
                    new ImageView(
                            new Image(String.valueOf(getClass().getResource("photos/edit.png"))
                    ))
            );


            //Agrego la imagen a mi boton de "delete"
            btnDelete.setGraphic(
                    new ImageView(
                            new Image(String.valueOf(getClass().getResource("photos/delete.png"))
                    ))
            );

            btnEdit.setOnAction(event -> {

                int index = combo.getSelectionModel().getSelectedIndex();
                //Known loophole, if the user has not selected a camera, the index will be -1

                Camera selected = camerasList.get(index);

                model.setText(selected.getModel());
                make.setText(selected.getMake());
                color.setText(selected.getColor());
                sensor.setText(selected.getSensor());
                lens.setText(selected.getLens());
                slider.setValue(selected.getMegaPixels());

                mainPhoto.setImage(
                        new Image(
                                String.valueOf(getClass().getResource(selected.getPhoto()))
                        )
                );
            });

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

    //Este metodo se activa cuando el usuario selecciona una camara de la lista
    // Coloque un "OnAction" en el comboBox llamado "onChange"
    @FXML
    void onChange(ActionEvent event) {
//        System.out.println("change!");

        //Selection Model
        int index = combo.getSelectionModel().getSelectedIndex();
        System.out.println(index);

        output.setText(camerasList.get(index).toString());
    }

    @FXML
    void onArrowClick(ActionEvent event) {
        //Este metodo de abajo es para saber que boton se ha presionado y obtener el texto
        String text = ((Button) event.getSource()).getText();
        System.out.println(text);
        //Este codigo lo saco de los slides de la semana 3
//        mainPhoto.setImage(new Image(String.valueOf(getClass().getResource("photos/camera2.jpg"))));

//        photoListIndex = text.equals(">") ? photoListIndex >= photoList.size() -1 ? 0 : photoListIndex + 1
//                : photoListIndex <= 0 ? photoList.size() - 1 : photoListIndex - 1;

        if (text.equals(">")) {
            if (photoListIndex >= photoList.size() - 1) {
                photoListIndex = 0;
            } else {
                photoListIndex += 1;
            }
        } else {
            if (photoListIndex <= 0) {
                photoListIndex = photoList.size() - 1;
            } else {
                photoListIndex -= 1;
            }
        }

        //        System.out.println(photoList.get(photoListIndex));
        System.out.println(photoList.get(photoListIndex));
        mainPhoto.setImage(new Image(String.valueOf(getClass().getResource(photoList.get(photoListIndex)))));

    }


    public void appearRightImage(){


    }






}
