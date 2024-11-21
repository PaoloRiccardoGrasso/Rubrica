package rubrica;

import java.util.ArrayList;

/**
 * Questa classe rappresenta una semplice rubrica telefonica contenente i
 * contatti.
 *
 * @author Paolo Riccardo Gasso, Alessandro Di Nella, Mario Favoino, Matteo
 * Lucia, Giuseppe Salomita
 * @version 1.0
 * @since 1.0
 */
public class Rubrica {

    // Lista che contiene i contatti
    private ArrayList<Contatto> rubrica = new ArrayList();

    /**
     * Aggiunge un contatto alla rubrica.
     *
     * @param nome Il nome del contatto.
     * @param cognome Il cognome del contatto.
     * @param numTel Il numero di telefono del contatto.
     * @param email L'email del contatto (può essere null).
     */
    public void aggiungiContatto(Contatto contatto) {

        // Controlla se il contatto esiste già nella rubrica
        if (rubrica.contains(contatto)) {
            System.out.println("Contatto già esistente! Non è stato aggiunto.");
            return;
        } else {
            rubrica.add(contatto);
        }
    }

    /**
     * Rimuove un contatto dalla rubrica.
     *
     * @param contatto Il contatto da rimuovere.
     */
    public void rimuoviContatto(Contatto contatto) {
        if (rubrica.remove(contatto)) {
            System.out.println("Contatto rimosso con successo!");
        } else {
            System.out.println("Contatto non trovato nella rubrica!");
        }
    }

    /**
     * Cerca un contatto per cognome.
     *
     * @param nome Il nome del contatto da cercare.
     * @param cognome Il cognome del contatto da cercare.
     */
    //TODO Aggiustare il metodociao
    public void cercaContatto(String nome, String cognome) {
        boolean isContattoTrovato = false;
        int i = 0;

        do {

            //se il cognome del contatto di posizione i^esima nella rubrica è uguale al 
            if (rubrica.get(i).nome.equals(nome) && rubrica.get(i).cognome.equals(cognome)) {
                isContattoTrovato = true;
                System.out.println("Contatto trovato! ");
                System.out.println(rubrica.get(i).toString());

            }
            i++;
        } while (!isContattoTrovato);

    }

    @Override
    public String toString() {
        if (rubrica.isEmpty()) {
            return "La rubrica è vuota.";
        }

        String s = "";
        for (Contatto contatto : rubrica) {
            s += (contatto);
        }

        return s;
    }
}
