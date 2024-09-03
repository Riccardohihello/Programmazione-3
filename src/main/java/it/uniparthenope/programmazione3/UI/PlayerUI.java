package it.uniparthenope.programmazione3.UI;

import it.uniparthenope.programmazione3.strategyPattern.Giocatore;
import it.uniparthenope.programmazione3.observerPattern.Action;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.util.Objects;

public class PlayerUI extends ListCell<Giocatore> {
    private static final String DEFAULT_BACKGROUND_COLOR = "#f5f5dc";
    private static final String DEALER_BACKGROUND_COLOR = "#0a55a6";
    private static final String BORDER_RADIUS = "10px";
    private static final String DEFAULT_TEXT_COLOR = "#2a2828";
    private static final String BORDER_GREEN = "#28a745";
    private static final String BORDER_RED = "#dc3545";

    VBox vbox = new VBox();
    Label nameLabel = new Label("");
    Label role = new Label("");
    Label balanceLabel = new Label("");
    Label stateLabel = new Label("");
    ImageView img = new ImageView();
    boolean isActive = false;

    public PlayerUI() {
        super();
        img.setFitWidth(120);
        img.setFitHeight(70);
        img.setPreserveRatio(true);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(img, nameLabel, balanceLabel, stateLabel, role);
        setGraphic(vbox);

        setDefaultStyles();
    }

    private void setDefaultStyles() {
        vbox.setStyle(String.format("-fx-background-color: %s; -fx-border-radius: %s; -fx-background-radius: %s", DEFAULT_BACKGROUND_COLOR, BORDER_RADIUS, BORDER_RADIUS));
        setTextStyle(nameLabel, DEFAULT_TEXT_COLOR, true);
        setTextStyle(balanceLabel, DEFAULT_TEXT_COLOR, false);
        setTextStyle(stateLabel, DEFAULT_TEXT_COLOR, false);
        setTextStyle(role, DEFAULT_TEXT_COLOR, false);
    }

    private void setTextStyle(Label label, String color, boolean bold) {
        label.setStyle(String.format("-fx-text-fill: %s; %s", color, bold ? "-fx-font-weight: bold" : ""));
    }

    private void setBackgroundColor(String color) {
        vbox.setStyle(String.format("-fx-background-color: %s; -fx-border-radius: %s; -fx-background-radius: %s", color, BORDER_RADIUS, BORDER_RADIUS));
    }

    private void setBorderColor(String color) {
        vbox.setStyle(String.format("-fx-background-color: %s; -fx-border-color: %s; -fx-border-radius: %s; -fx-background-radius: %s; -fx-border-width: 5;", DEFAULT_BACKGROUND_COLOR, color, BORDER_RADIUS, BORDER_RADIUS));
    }

    @Override
    public void updateItem(Giocatore player, boolean empty) {
        super.updateItem(player, empty);
        setText(null);

        if (player != null && !empty) {
            nameLabel.setText(player.getNome());
            balanceLabel.setText("Gettoni: " + player.getGettoni());
            setBorderColor(DEFAULT_BACKGROUND_COLOR);
            setTextStyle(stateLabel,DEFAULT_TEXT_COLOR,true);
            if (player.isMazziere) {
                role.setText("Mazziere");
                setBackgroundColor(DEALER_BACKGROUND_COLOR);
            } else
                setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
            if (player.getStato() != null) {
                switch (player.getStato()) {
                    case bid:
                        stateLabel.setText("Deve versare");
                        setBorderColor(BORDER_GREEN);
                        setTextStyle(stateLabel,BORDER_GREEN,true);
                        break;

                    case match:
                        stateLabel.setText("Gioca");
                        setBorderColor(BORDER_GREEN);
                        setTextStyle(stateLabel,BORDER_GREEN,true);
                        balanceLabel.setText("Valore mano: " + player.getMano().getValore());
                        break;

                    case bidded:
                        stateLabel.setText("Versato...");
                        break;

                    case wait:
                        stateLabel.setText("In attesa...");
                        break;

                    case busted:
                        setBorderColor(BORDER_RED);
                        stateLabel.setText("Sballato!");
                        break;

                    case results:
                        balanceLabel.setVisible(true);
                        stateLabel.setVisible(true);
                        stateLabel.setText("Valore mano: " + player.getMano().getValore());
                        break;

                    default:
                        setDefaultStyles();
                        break;
                }
            }
            img.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/it/uniparthenope/programmazione3/images/avatar.png"))));
            setGraphic(vbox);
        } else {
            setGraphic(null);
        }
    }

}

