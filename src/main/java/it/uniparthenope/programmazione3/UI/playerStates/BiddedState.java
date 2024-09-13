package it.uniparthenope.programmazione3.UI.playerStates;

import it.uniparthenope.programmazione3.strategyPattern.Giocatore;

public class BiddedState implements PlayerState {
    @Override
    public void updateState(PlayerUI playerUI, Giocatore player) {
        playerUI.stateLabel.setText("Versato...");
        playerUI.setBorderColor(PlayerUI.DEFAULT_BACKGROUND_COLOR);
        playerUI.setTextStyle(playerUI.stateLabel, PlayerUI.DEFAULT_TEXT_COLOR);
    }
}