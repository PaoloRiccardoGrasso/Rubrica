package rubrica;

import java.util.*;

/**
 * Questa classe rappresenta una semplice rubrica telefonica contenenti i
 * contatti.
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Mario Favoino, Matteo
 * Lucia, Giuseppe Salomita
 * @version 1.0
 * @since 1.0
 */
public class Rubrica {

    public ArrayList<Contatto> rubrica = new ArrayList<>();

    /**
     * Aggiunge un contatto alla rubrica.
     *
     * @param contatto I dati del contatto.
     * @see Contatto.java
     * @return Void
     *
     */
    public void aggiungiContatto(Contatto contatto) {
    if (rubrica.contains(contatto)) {
        System.out.println("Contatto già esistente! Operazione annullata.");
        return;
    }
    rubrica.add(contatto);
    System.out.println("Contatto aggiunto con successo!");
}


    /**
     * Rimuove un contatto dalla rubrica.
     *
     * @param contatto I dati del contatto.
     * @see Contatto.java
     * @return Void
     *
     */
    public void rimuoviContatto(Contatto contatto) {
        rubrica.remove(contatto);
        System.out.println("Contatto rimosso con successo!");
    }

    @Override
    public String toString() {
        String s = "";
        for (Contatto contatto : rubrica) {
            s += "\n" + contatto;
        }

        return s;
    }

}
