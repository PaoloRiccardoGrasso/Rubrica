package io.github.PaoloRiccardoGrasso.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import io.github.PaoloRiccardoGrasso.Model.Contatto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Rappresenta una rubrica telefonica che consente di gestire un elenco di
 * contatti.
 * <p>
 * Funzionalità principali:
 * <ul>
 * <li>Aggiungere contatti alla rubrica</li>
 * <li>Rimuovere contatti dalla rubrica</li>
 * <li>Modificare i dettagli di un contatto</li>
 * <li>Ricercare un contatto tramite nome e cognome</li>
 * <li>Salvare ed esportare i contatti su file</li>
 * <li>Importare i contatti da un file</li>
 * </ul>
 * 
 *
 * @version Beta (2.0)
 * @since Alpha (1.0)
 */
public class Rubrica {

    // ArrayList di contatti
    public ArrayList<Contatto> rubrica = new ArrayList();

    /**
     * Aggiunge un contatto alla rubrica.
     *
     * @param contatto Il contatto da aggiungere.
     * @return true se il contatto è stato aggiunto con successo, false se il
     * contatto esiste già.
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
     * Rimuove un contatto dalla rubrica dato il suo indice.
     *
     * @param indiceContatto Indice del contatto da rimuovere.
     * @return true se il contatto è stato rimosso con successo, false
     * altrimenti.
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
     * Cerca un contatto nella rubrica in base a nome e cognome.
     *
     * @param nome Nome del contatto da cercare.
     * @param cognome Cognome del contatto da cercare.
     * @return L'indice del contatto se trovato, -1 altrimenti.
     */
    public int cercaContatto(String nome, String cognome) {
        boolean isContattoTrovato = false;
        int indiceContatto;

        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getNome().equalsIgnoreCase(nome) && rubrica.get(i).getCognome().equalsIgnoreCase(cognome)) {
                isContattoTrovato = true;
                indiceContatto = i;
                return indiceContatto;
            }
        }

        if (!isContattoTrovato) {
            indiceContatto = -1;
            return indiceContatto;
        }

        return -1;
    }

    /**
     * Modifica i dati di un contatto esistente dato l'indice e il nuovo
     * contatto.
     *
     * @param contatto Nuovo contatto con i dati aggiornati.
     * @param indiceContatto Indice del contatto da modificare.
     * @return true se il contatto è stato modificato con successo, false
     * altrimenti.
     */
    public boolean modificaContatto(Contatto contatto, int indiceContatto) {

        if (indiceContatto != -1) {
            rubrica.set(indiceContatto, contatto);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Restituisce una rappresentazione testuale della rubrica.
     *
     * @return Una stringa contenente i dettagli di tutti i contatti o "-1" se
     * la rubrica è vuota.
     */
    @Override
    public String toString() {
        String s = "";
        if (rubrica.isEmpty()) {
            return "-1";
        } else {
            for (int i = 0; i < rubrica.size(); i++) {
                s += rubrica.get(i).toString() + "\n";
            }
        }

        return s;
    }

    //----------------------------------------------SALVATAGGIO SU FILE----------------------------------------------
    private final String fileRubrica = "rubrica.txt";

    /**
     * Salva un contatto sul file della rubrica.
     *
     * @param contatto Il contatto da salvare.
     * @return true se il salvataggio è avvenuto con successo, false altrimenti.
     */
    public boolean salvaContattoSuFile(Contatto contatto) {
        try {
            FileWriter w = new FileWriter(fileRubrica, true);
            PrintWriter fout = new PrintWriter(w);

            fout.println(contatto.getNome() + ";" + contatto.getCognome() + ";" + contatto.getNumeroTelefono() + ";" + contatto.getEmail());
            fout.flush();
            w.close();
            return true;

        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Esporta tutti i contatti della rubrica su file.
     *
     * @return true se l'esportazione è avvenuta con successo, false altrimenti.
     */
    public boolean esportaContatti() {
        try {
            FileWriter w = new FileWriter(fileRubrica, false);
            PrintWriter fout = new PrintWriter(w);

            if (rubrica.isEmpty()) {
                w.close();
            } else {
                for (int i = 0; i < rubrica.size(); i++) {
                    fout.println(rubrica.get(i).getNome() + ";" + rubrica.get(i).getCognome() + ";" + rubrica.get(i).getNumeroTelefono() + ";" + rubrica.get(i).getEmail());

                }
                fout.flush();
                w.close();
            }

            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Importa i contatti dal file della rubrica nell'ArrayList.
     *
     * @return true se l'importazione è avvenuta con successo, false altrimenti.
     */
    public boolean importaContatti() {
        try {
            FileReader r = new FileReader(fileRubrica);
            BufferedReader fin = new BufferedReader(r);
            StringTokenizer stringa = null;
            String riga = fin.readLine();

            while (riga != null) {
                stringa = new StringTokenizer(riga, ";");
                Contatto contatto = new Contatto(stringa.nextToken(), stringa.nextToken(), stringa.nextToken(), stringa.nextToken());
                rubrica.add(contatto);
                riga = fin.readLine();
            }

            return true;

        } catch (IOException ex) {
            return false;
        }
    }
}
