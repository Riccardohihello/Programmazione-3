package it.uniparthenope.sette_e_mezzo.memento;

import java.io.Serializable;

public class Memento implements Serializable {
    // implementazione del pattern memento
    private gameSettings settings;
    public Memento(gameSettings settings) {
        this.settings = settings;
    }
    public void setSettings(gameSettings settings) {this.settings = settings;}
    public gameSettings getSettings() {
        return settings;
    }
}
