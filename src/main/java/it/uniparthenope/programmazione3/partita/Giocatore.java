package it.uniparthenope.programmazione3.partita;

import it.uniparthenope.programmazione3.Costanti;

public class Giocatore extends GiocatoreAbstract {

    public Giocatore(String nome) {
        this.nome = nome;
        this.gettoni = Costanti.m;
        this.mano = new Mano();
    }


    public void aumentaGettoni(int vincita) {
    }

    public int quotaComputer(int piatto, int numeroPuntate, int quotaDaVersare) {
        return 0;
    }
}