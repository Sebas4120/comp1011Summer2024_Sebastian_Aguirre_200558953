package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;
import javafx.scene.control.Separator;

import java.io.SerializablePermission;
import java.sql.*;
import java.util.Properties;

public class Database {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql","admin",
                    "Narangita412.");

            Statement statement = connection.createStatement();
            //statement.execute(); // sql query with no result
            ResultSet resultSet = statement.executeQuery("");//returns rows

        }catch(SQLException e){
            System.err.println(e);
        }


    }
}
