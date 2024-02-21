package it.uniparthenope.programmazione3.observerPattern;

import it.uniparthenope.programmazione3.game.Carta;
import it.uniparthenope.programmazione3.game.Giocatore;
import it.uniparthenope.programmazione3.game.MazzoIterator;
import it.uniparthenope.programmazione3.game.SettingsSingleton;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Random;

public class Partita  {
    private ArrayList<gameObserver> osservatori;
    private int indiceScorrimento = 0;

    private ArrayList<Giocatore> giocatori = new ArrayList<>();
    MazzoIterator mazzoIterator = MazzoIterator.getInstance();
    public int piatto;

    public void notificaOsservatore( String label) {
        if (osservatori != null) {
            System.out.println("Mando notifica!");
            osservatori.get(indiceScorrimento).update(label);
        }
    }

    public int getNumeroGiocatori(){
        return giocatori.size();
    }

    // Costruttore privato per impedire istanze multiple
    public Partita() {
        mazzoIterator.mischia();
        // Inizializza eventuali valori predefiniti
        osservatori = null;
    }

    public void addOsservatore(gameObserver osservatore) {
        this.osservatori.add(osservatore);
    }

    public void sceltaMazziere() {
        if (giocatori.size() > 2) {
            Random random = new Random();
            int randomIndex = random.nextInt(giocatori.size()-1);

        }
    }

    public ObservableList<Carta> getManoGiocatore(){
        return giocatori.get(indiceScorrimento).getMano().getCarte();
    }


    public void addGiocatore(String nome) {
        giocatori = (ArrayList<Giocatore>) SettingsSingleton.getInstance().getListaGiocatori();
        notificaOsservatore("addGiocatore");
    }

    public Giocatore scorriGiocatori(){
        int temp = indiceScorrimento % giocatori.size();
        indiceScorrimento += 1;
        return giocatori.get(temp);
    }


    public void riempiPiatto(int quota){
        this.piatto += quota;
    }
}
