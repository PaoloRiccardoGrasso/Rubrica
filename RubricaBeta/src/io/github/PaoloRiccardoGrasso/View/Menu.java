package io.github.PaoloRiccardoGrasso.View;

import io.github.PaoloRiccardoGrasso.Controller.GestoreRubrica;
import java.util.Scanner;

/**
 * Questa classe rappresenta la visualizzazione del menù per effettuare le
 * classiche operazioni definita dalla struttura CRUD
 *
 * Funzionalità principali:
 * <ul>
 * <li>Visualizzare all'utente il menu</li>
 * <li>Metodo per ripulire lo schermo</li>
 * <li>Metodo per mettere in pausa la visualizzazione</li>
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

    public Menu() {
        this.gestoreRubrica = new GestoreRubrica(this);
    }

    /**
     * Metodo principale per la visualizzazione del menù
     *
     *
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     * @since Alpha (1.0)
     */
    public void apriMenu() {
        do {
            cls();        // Pulisce la console
            interfaccia(); // Mostra l'interfaccia del menu
            gestoreRubrica.gestisciScelta(); // Tutta la logica è nel Controller
        } while (true); // L'uscita dal ciclo è gestita dal Controller
    }

    /**
     * Metodo per ripulire lo schermo attraverso il sistema operativo
     *
     * <ul>
     * <li> Windows: Utilizza il comando 'cls'</li>
     * <li> Linux o MacOS: Utilizza il comando 'clear'</li>
     * </ul>
     *
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     * @since Alpha (1.0)
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
     * Metodo per visualizzare l'interfaccia del menù a riga di comando
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     * @since Alpha (1.0)
     */
    private void interfaccia() {
        if (gestoreRubrica.isActiveAutomaticSave == false) {
            System.out.println("=======================================");
            System.out.println("|             RUBRICA CLI             |");
            System.out.println("|=====================================|");
            System.out.println("|  1. Aggiungi Contatto               |");
            System.out.println("|  2. Rimuovi Contatto                |");
            System.out.println("|  3. Modifica Contatto               |");
            System.out.println("|  4. Ricerca Contatto                |");
            System.out.println("|  5. Visualizza Rubrica              |");
            System.out.println("|  6. Attiva Salvataggio Automatico   |");
            System.out.println("|  7. Esci                            |");
            System.out.println("=======================================");
        } else {
            System.out.println("=======================================");
            System.out.println("|             RUBRICA CLI             |");
            System.out.println("|=====================================|");
            System.out.println("|  1. Aggiungi Contatto               |");
            System.out.println("|  2. Rimuovi Contatto                |");
            System.out.println("|  3. Modifica Contatto               |");
            System.out.println("|  4. Ricerca Contatto                |");
            System.out.println("|  5. Visualizza Rubrica              |");
            System.out.println("|  6. Disattivare Salvataggio Auto.   |");
            System.out.println("|  7. Esci                            |");
            System.out.println("=======================================");
        }
    }

    /**
     * Metodo utile al controller per inviare messaggi attraverso il view
     *
     * @param messaggio Messaggio da inviare attraverso la view
     * 
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     */
    public void inviaMessaggio(String messaggio) {
        System.out.println(messaggio);
    }

}
