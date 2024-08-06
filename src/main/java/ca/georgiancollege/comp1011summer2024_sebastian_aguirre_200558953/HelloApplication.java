package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

import ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11.DogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sb1-view" +
//                ".fxml"));

//        SB1Controller controller = new SB1Controller();
//        controller.setValue("Howdy!");
//        fxmlLoader.setController(controller);

//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.setTitle("Go Time");
//        stage.setResizable(false);
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ball-view" +
                ".fxml"));
        DogController controller = new DogController();
        fxmlLoader.setController(controller);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
//        stage.setTitle("Dog API");
        stage.setTitle("Ball Time");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}