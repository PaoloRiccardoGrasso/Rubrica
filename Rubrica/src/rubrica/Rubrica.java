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
    public ArrayList<Contatto> rubrica = new ArrayList();

    /**
     * Aggiunge un contatto alla rubrica.
     *
     * @param nome Il nome del contatto.
     * @param cognome Il cognome del contatto.
     * @param numTel Il numero di telefono del contatto.
     * @param email L'email del contatto (può essere null).
     * 
     * @return void
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
    public void rimuoviContatto(int indiceContatto) {

        if (indiceContatto != -1) { // Verifica che il contatto esista
            rubrica.remove(indiceContatto); // Rimuove il contatto dalla lista
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
    //TODO Aggiustare il metodo
    public int cercaContatto(String nome, String cognome) {
        boolean isContattoTrovato = false;
        int indiceContatto;

        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).nome.equalsIgnoreCase(nome) && rubrica.get(i).cognome.equalsIgnoreCase(cognome)) {
                isContattoTrovato = true;
                indiceContatto = i;
                System.out.println(rubrica.get(i).toString());
                return indiceContatto;
            }
        }

        if (!isContattoTrovato) {
            System.out.println("Contatto non trovato!");
            indiceContatto = -1;
            return indiceContatto;
        }

        return -1;
    }

    public void modificaContatto(int indiceContatto, Contatto contatto) {

        if (indiceContatto != -1) {
            rubrica.set(indiceContatto, contatto);
            System.out.println("Contatto aggiornato con successo! ");

        } else {
            System.out.println("Contatto non aggiornato perchè non trovato! ");
        }
    }

    @Override
    public String toString() {
        if (rubrica.isEmpty()) {
            return "La rubrica è vuota.";
        }

        String s = "";
        s += "--------------- Rubrica ----------------\n";
        for (Contatto contatto : rubrica) {
            s += (contatto);
        }

        return s;
    }
}
