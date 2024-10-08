package it.uniparthenope.sette_e_mezzo.UI;

import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class CardCell extends ListCell<String> {
    // rappresentazione dell'immagine della carta
    private final ImageView img = new ImageView();

    public CardCell() {
        super();
        img.setFitWidth(100);
        img.setFitHeight(150);
        img.setPreserveRatio(true);
        setGraphic(img);

    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            img.setImage(null);
        } else {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(item)));
            img.setImage(image);
        }
    }

}