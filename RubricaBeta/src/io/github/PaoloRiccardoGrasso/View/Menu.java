package io.github.PaoloRiccardoGrasso.View;

import io.github.PaoloRiccardoGrasso.Controller.GestoreRubrica;
import java.util.Scanner;

/**
 * Classe per la visualizzazione del menù delle operazioni CRUD nella rubrica.
 * <p>
 * Funzionalità principali:
 * <ul>
 * <li>Visualizzazione del menu all'utente</li>
 * <li>Pulizia dello schermo</li>
 * <li>Invio di messaggi al terminale</li>
 * </ul>
 * 
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita, Mario
 * Favoino, Matteo Lucia
 * @version Beta (2.0)
 * @since Alpha (1.0)
 */
public class Menu {

    private GestoreRubrica gestoreRubrica;

    /**
     * Costruttore per inizializzare il GestoreRubrica associato.
     */
    public Menu() {
        this.gestoreRubrica = new GestoreRubrica(this);

    }

    /**
     * Metodo principale per la visualizzazione del menù e gestione iterativa.
     */
    public void apriMenu() {
        do {
            cls();        // Pulisce la console
            interfaccia(); // Mostra l'interfaccia del menu
            gestoreRubrica.gestisciScelta(); // Tutta la logica è nel Controller
        } while (true); // L'uscita dal ciclo è gestita dal Controller
    }

    /**
     * Metodo per pulire lo schermo utilizzando i comandi di sistema.
     * <ul>
     * <li>Windows: usa il comando 'cls'</li>
     * <li>Linux/MacOS: usa il comando 'clear'</li>
     * </ul>
     */
    public void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per visualizzare l'interfaccia del menù a riga di comando.
     */
    private void interfaccia() {
        System.out.println("=======================================");
        System.out.println("|             RUBRICA CLI             |");
        System.out.println("|=====================================|");
        System.out.println("|  1. Aggiungi Contatto               |");
        System.out.println("|  2. Rimuovi Contatto                |");
        System.out.println("|  3. Modifica Contatto               |");
        System.out.println("|  4. Ricerca Contatto                |");
        System.out.println("|  5. Visualizza Rubrica              |");
        System.out.println("|  6. Esci                            |");
        System.out.println("=======================================");
    }

    /**
     * Metodo per inviare messaggi alla vista dal controller.
     *
     * @param messaggio Messaggio da visualizzare
     */
    public void inviaMessaggio(String messaggio) {
        System.out.print(messaggio);
    }

}
