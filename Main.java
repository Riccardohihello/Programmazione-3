


public class Main {



        public static void main(String[] args){
                Mazzo mazzoo = Mazzo.creaMazzo();
                mazzoo.stampa();
                Giocatore giocatore1 = new Giocatore("Giulio");
                Mazziere mazziere = new Mazziere(giocatore1.getNome(), mazzoo);
                System.out.println(mazziere.getNome());

        }
        
}
