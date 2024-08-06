package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class BallController {

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<String> cbPlayer;

    @FXML
    private ComboBox<String> cbTeam;

    @FXML
    private Label lblPlayer;

    @FXML
    private Label lblTeam;

    @FXML
    private ProgressBar progress;

    @FXML
    private TextField txtSearch;

    ListOfBallTeams teams;
    void populateTeamComboBox() throws Exception{

        teams = new BallDontLieAPI().getAllTeams();

        cbTeam.getItems().addAll( teams.data.stream().map(s -> s.full_name).toList());
        cbPlayer.getSelectionModel().selectFirst();

    }

    @FXML
    void initialize() throws Exception{

        lblTeam.setText("");
        lblPlayer.setText("");

        progress.setProgress(0);
        progress.setVisible(false);

        populateTeamComboBox();

        cbTeam.setOnAction(
                event -> {
                    int selectedIndex = cbTeam.getSelectionModel().getSelectedIndex();
                    lblTeam.setText(
                            teams.data.get(selectedIndex).toString()
                    );
                }
        );

    }
}
