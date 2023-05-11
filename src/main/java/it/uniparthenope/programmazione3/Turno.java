package it.uniparthenope.programmazione3;

import java.util.ArrayList;

class Turno {
    Mazzo mazzo;
    private int quota; //quota totale versata dai giocatori

    public Turno(int imazziere) {
        this.mazzo = Mazzo.creaMazzo();
        String[] nomi = {"Pippo","Pluto","Paperino","Topolino"};
        ArrayList<Giocatore> giocatori = new ArrayList<>(); //creazione dei giocatori

        for(int i = 0; i < Costanti.n; i++)
            giocatori.add(new Giocatore(nomi[i]));
        for (Giocatore giocatore : giocatori) {
            System.out.print(giocatore.getNome()+", ");
        }

        new Mazziere(giocatori.get(imazziere%giocatori.size()));
        this.mazzo.mischia();
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

}
