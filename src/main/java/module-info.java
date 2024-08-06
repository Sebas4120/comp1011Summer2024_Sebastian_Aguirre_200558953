module ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires java.net.http;


    opens ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953 to javafx.fxml;
    exports ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;
    exports ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK8;
    opens ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK8 to javafx.fxml;
    opens ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK10 to com.google.gson;
    opens ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK11 to javafx.fxml
            , com.google.gson;
    opens ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12 to com.google.gson, javafx.fxml;
}