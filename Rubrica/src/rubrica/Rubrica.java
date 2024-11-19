package rubrica;

import java.util.*;

/**
 * Questa classe rappresenta una semplice rubrica telefonica contenenti i
 * contatti.
 *
 * @author Paolo Riccardo Gasso, Alessandro Di Nella, Mario Favoino, Matteo
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
        String s = "";
        for (Contatto contatto : rubrica) {
            s += "\n" + contatto;
        }

        return s;
    }

}
