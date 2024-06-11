package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SB1Controller {

    @FXML
    Button btn1, btn2;

    private String value;
    StringAndBuilderModel model;

    public void setValue (String value){
        this.value=value;
    }

    @FXML
    private void initialize(){

        btn1.setText("Add Data " + value);

        btn1.setOnAction(e->{
            try{

                model = new StringAndBuilderModel(
                        "string", "hello", "toUpperCase()",""

                );
                model.insertEntry();
            }
            catch (Exception ex){
                System.err.println(ex);
            }

        });

        btn2.setOnAction(e->
        {
            try{
                model = new StringAndBuilderModel(
                        "string", "hello", "toUpperCase()","");


                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sb2-view.fxml"));
                Stage stage = new Stage();
                SB2Controller controller = new SB2Controller();
                controller.setModel(model);
                fxmlLoader.setController(controller);


                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.setTitle("Go Time");
                stage.setResizable(false);
                stage.show();


            }
            catch (Exception ex){
                System.err.println(ex);
            }



        });

    }



}
