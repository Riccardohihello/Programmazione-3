package it.uniparthenope.sette_e_mezzo.UI;

import it.uniparthenope.sette_e_mezzo.Main;
import it.uniparthenope.sette_e_mezzo.StatePattern.PlayerGameCell;
import it.uniparthenope.sette_e_mezzo.memento.gameSettings;
import it.uniparthenope.sette_e_mezzo.strategyPattern.Giocatore;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StatsUI {
    @FXML
    private Label vittoriaLabel;

    @FXML
    private Label sconfittaLabel;

    @FXML
    private ListView<Giocatore> vincitori;

    @FXML
    private ListView<Giocatore> sconfitti;

    @FXML
    private ListView<Giocatore> mazziere;


    @FXML
    public void initialize() {
        vittoriaLabel.setStyle("-fx-text-fill: gold; -fx-background-color: black;");
        sconfittaLabel.setStyle("-fx-text-fill: red; -fx-background-color: black;");
        setPlayerStats();
        vincitori.setCellFactory(param -> new PlayerGameCell());
        sconfitti.setCellFactory(param -> new PlayerGameCell());
        mazziere.setCellFactory(param -> new PlayerGameCell());
    }

    private void setPlayerStats() {
        vincitori.setItems(FXCollections.observableArrayList(gameSettings.getSettings().getWinners()));
        sconfitti.setItems(FXCollections.observableArrayList(gameSettings.getSettings().getLosers()));
        mazziere.setItems(FXCollections.observableArrayList(gameSettings.getSettings().getMazziere()));
    }

    @FXML
    public void nuovaPartita(ActionEvent event) throws Exception {
            Main.cambiaScena("playerSelection.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    @FXML
    public void rigiocaPartita(ActionEvent event) throws Exception {
        Main.cambiaScena("game.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());

    }

    @FXML
    public void backToMenu(ActionEvent event) throws Exception {
        Main.cambiaScena("menu.fxml", (Stage) ((Node) event.getSource()).getScene().getWindow());
    }
}
