package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.concurrent.TimeUnit;

public class BallController {


    @FXML
    ProgressBar progress;

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<String> cbPlayer,cbTeam;

    @FXML
    private Label lblPlayer,lblTeam;

    @FXML
    private TextField txtSearch;

    private Runnable taskUpdateProgressBar = () ->{

        txtSearch.setDisable(true);
        btnSubmit.setDisable(true);
        progress.setVisible(true);
        progress.setProgress(0);

        for(int i = 0; i < 20; i++){

            try{
                progress.setProgress(progress.getProgress() + .05);
                Thread.sleep(100);
            }
            catch (Exception e){
                System.err.println();
            }

        }

        progress.setVisible(false);
        txtSearch.setDisable(false);
        btnSubmit.setDisable(false);
    };


    private BallDontLieAllPlayers players;
    private ListOfBallTeams teams;
    void populateTeamComboBox() throws Exception{

        teams = new BallDontLieAPI().getAllTeams();

        cbTeam.getItems().addAll( teams.data.stream().map(s -> s.full_name).toList()  );
        cbTeam.getSelectionModel().selectFirst();

    }

    void getPlayerData(String term){

        players = new BallDontLieAPI().getAllPlayers(term);

        cbPlayer.getItems().clear();

        cbPlayer.getItems().addAll(
                players.data.stream().map(s->s.first_name + " " + s.last_name).toList()
        );


    }

    void onSubmit(ActionEvent event){

        System.out.println("Submitted");

        String term = txtSearch.getText();

        //display the search text field and submit button
        //update the progress bar from 0 to 100 every 100ms, update by .1
        //accomplish via a thread call
        //create a run a new thread
        new Thread(taskUpdateProgressBar).start();

        getPlayerData(term);
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

        cbPlayer.setOnAction(
                event -> {
                    int selectedIndex = cbPlayer.getSelectionModel().getSelectedIndex();
                    lblPlayer.setText(
                            players.data.get(selectedIndex).toString()
                    );
                }
        );


        btnSubmit.setOnAction(this::onSubmit);

    }





}
