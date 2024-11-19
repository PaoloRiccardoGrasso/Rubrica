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
    private ArrayList<Contatto> rubrica = new ArrayList<>();

    /**
     * Aggiunge un contatto alla rubrica.
     *
     * @param nome   Il nome del contatto.
     * @param cognome Il cognome del contatto.
     * @param numTel Il numero di telefono del contatto.
     * @param email  L'email del contatto (può essere null).
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
     * @param cognome Il cognome del contatto da cercare.
     */
    //TODO Aggiustare il metodo
    /*public void cercaContatto(){
        String cognome;
        boolean isContattoTrovato= false;
        int i=0;
        
        System.out.println("Inserire il cognome del contatto che si sta cercando: ");
        //cognome=tastiera.readLine();    //Fare la presa dell'input lol
        
        do{
            
            if(rubrica.get(i).cognome == cognome){
                    isContattoTrovato=true;
                    rubrica.get(i).toString();

                }
            i++;
        }while(! isContattoTrovato);
        
            
            
        
        
        
        
    }*/

    @Override
    public String toString() {
        if (rubrica.isEmpty()) {
            return "La rubrica è vuota.";
        }

        StringBuilder s = new StringBuilder("Rubrica:");
        for (Contatto contatto : rubrica) {
            s.append("\n").append(contatto);
        }

        return s.toString();
    }
}

