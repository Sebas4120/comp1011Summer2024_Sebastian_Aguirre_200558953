package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DogController {

    @FXML
    private ImageView picture;

    @FXML
    private TextField status;

    @FXML
    private Label lblCounter;

    @FXML
    private Button btnStart,btnStop;

    private DogAPIRequest request = new DogAPIRequest();
    private String uri = "https://dog.ceo/api/breeds/image/random";

    @FXML
    void updateDog(){
        Dog dog = request.getData(uri);
        Platform.runLater(()->
                status.setText(dog.getStatus())
        );
        picture.setImage(
                new Image(
                        dog.getMessage()
                )
        );

        updateCounter();
    }

    @FXML
    void updateCounter(){

        int value = Integer.parseInt(lblCounter.getText());
        value++;
        String updatedValue = value + "";
        Platform.runLater(()-> lblCounter.setText(updatedValue));

    }

    @FXML
    public void initialize() throws Exception{
        updateDog();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        btnStart.setOnAction(
                event -> {
                    service.scheduleAtFixedRate(this::updateDog, 0, 2500, TimeUnit.MILLISECONDS);

                }
        );

        btnStop.setOnAction(event -> service.shutdown());
    }
}

