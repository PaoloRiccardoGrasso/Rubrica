package io.github.PaoloRiccardoGrasso.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import io.github.PaoloRiccardoGrasso.Model.Contatto;

/**
 * Questa classe rappresenta una semplice rubrica telefonica contenente i
 * contatti.
 *
 * 
 * Funzionalità principali:
 * <ul>
 * <li>Aggiunta contatto alla rubrica</li>
 * <li>Rimozione contatto dalla rubrica</li>
 * <li>Modifica contatto nella rubrica</li>
 * <li>Ricerca contatto nella rubrica</li>
 * </ul>
 * 
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita, Mario
 * Favoino, Matteo Lucia
 * @version Beta (2.0)
 * @since Alpha (1.0)
 */
public class Rubrica {

    // ArrayList di contatti
    public ArrayList<Contatto> rubrica = new ArrayList();
    private static final String NOME_FILE = "rubrica.txt";

    /**
     * Aggiunge un contatto alla rubrica.
     *
     * @param contatto
     */
    public boolean aggiungiContatto(Contatto contatto) {

        // Controlla se il contatto esiste già nella rubrica
        if (rubrica.contains(contatto)) {
            return false;
        } else {
            rubrica.add(contatto);
            return true;
        }
    }

    /**
     * Rimuove un contatto dalla rubrica.
     *
     * @param indiceContatto
     */
    public boolean rimuoviContatto(int indiceContatto) {

        if (indiceContatto != -1) { // Verifica che il contatto esista
            rubrica.remove(indiceContatto); // Rimuove il contatto dalla lista
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cerca il contatto e lo visualizza
     *
     * @param nome
     * @param cognome
     * @return int - Index del contatto
     */
    public int cercaContatto(String nome, String cognome) {
        boolean isContattoTrovato = false;
        int indiceContatto;

        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getNome().equalsIgnoreCase(nome) && rubrica.get(i).getCognome().equalsIgnoreCase(cognome)) {
                isContattoTrovato = true;
                indiceContatto = i;
                System.out.println(rubrica.get(i).toString());
                return indiceContatto;
            }
        }

        if (!isContattoTrovato) {
            indiceContatto = -1;
            return indiceContatto;
        }

        return -1;
    }

    public boolean modificaContatto(int indiceContatto, Contatto contatto) {

        if (indiceContatto != -1) {
            rubrica.set(indiceContatto, contatto);
            return true;

        } else {
            return false;
        }
    }
}

//----------------------------------------------SALVATAGGIO SU FILE----------------------------------------------

