package it.uniparthenope.sette_e_mezzo.UI.StatePattern;

import it.uniparthenope.sette_e_mezzo.strategyPattern.Giocatore;

public interface PlayerState {
    void updateState(PlayerGameCell playerGameCell, Giocatore player);
}