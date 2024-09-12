package it.uniparthenope.programmazione3.observerPattern;

import javafx.application.Platform;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.net.URISyntaxException;


public class Sounds implements gameObserver {
    @Override
    public void update(Action action, String... message) {
        Platform.runLater(() -> {
            String path = "src/main/resources/it/uniparthenope/programmazione3/sounds/";
            try {
                switch (action) {
                    case match:
                        break;
                    case busted:
                        playSounds(path + "game-over.wav");
                        break;
                    case setteMezzo:
                        playSounds(path + "applause.mp3");
                        break;
                    case pescato:
                        break;
                    case matta:
                        playSounds(path + "success.wav");
                        break;
                }
            }   catch(URISyntaxException e){
                    throw new RuntimeException(e);
                }

        });
    }

    private void playSounds(String fileAudio) throws URISyntaxException {
        AudioClip sound = new AudioClip(new File(fileAudio).toURI().toString());
        sound.play();
    }
}
