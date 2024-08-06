package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

import javafx.fxml.FXML;

public class SB2Controller {

    private StringAndBuilderModel model;

    public void setModel(StringAndBuilderModel model){
        this.model = model;
    }

    @FXML
    private void initialize(){


        System.out.println(model.getDataType());
        System.out.println(model.getContent());
    }

}
