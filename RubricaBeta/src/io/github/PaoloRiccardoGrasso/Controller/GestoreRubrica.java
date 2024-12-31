package io.github.PaoloRiccardoGrasso.Controller;

import io.github.PaoloRiccardoGrasso.Model.Rubrica;
import io.github.PaoloRiccardoGrasso.View.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Questa classe rappresenta il controller, effettua operazioni di intermezzo
 * tra la view (Menù) e il model (Rubrica)
 *
 * Funzionalità principali:
 * <ul>
 * <li>Gestire la scelta del menu</li>
 * <li>Gestire gli input dell'utente</li>
 * <li>Gestire View e Model correttamente</li>
 * </ul>
 *
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita, Mario
 * Favoino, Matteo Lucia
 * @version Beta (2.0)
 * @since Alpha (1.0)
 */
public class GestoreRubrica {

    private Menu menu;
    /**
     * TODO DA FARE COMMENTO
     */
    public boolean isActiveAutomaticSave = false;
    Scanner scanner = new Scanner(System.in);
    Rubrica rubrica = new Rubrica();

    /**
     * TODO DA FARE COMMENTO
     */
    public GestoreRubrica(Menu menu) {
        this.menu = menu;
    }

    /**
     * TODO DA FARE COMMENTO
     */
    public void gestisciScelta() {
        int scelta;
        try {
            System.out.print("Scelta> ");
            scelta = scanner.nextInt(); // Acquisisce l'input

            switch (scelta) {
                case 1:
                    aggiungiContatto();
                    pausa();
                    break;
                case 2:
                    menu.inviaMessaggio("Hai scelto 2");
                    pausa();
                    break;
                case 3:
                    menu.inviaMessaggio("Hai scelto 3");
                    pausa();
                    break;
                case 4:
                    menu.inviaMessaggio("Hai scelto 4");
                    pausa();
                    break;
                case 5:
                    menu.inviaMessaggio("Hai scelto 5");
                    pausa();
                    break;
                case 6:
                    ActiveOrDisableAutomaticSave();
                    break;
                case 7:
                    menu.inviaMessaggio("Uscita dal programma.");
                    pausa();
                    System.exit(0); // Esci dal programma
                    break;
                default:
                    menu.inviaMessaggio("Scelta non valida. Riprova.");
                    pausa();
                    break;
            }
        } catch (InputMismatchException e) {
            menu.inviaMessaggio("Errore: inserire un numero intero valido.");
            scanner.nextLine(); // Pulisce il buffer in caso di errore
        }
    }

    /**
     * Metodo per mettere in pausa la visualizzazione dei dati
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     */
    public void pausa() {
        menu.inviaMessaggio("Premere invio per continuare...");
        scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * Metodo per attivare il salvataggio automatico dei file.
     * 
     * Se il parametro isAsctiveAutomaticSave è:
     * <ul>
     * <li> Attivo (True): Rende disponibile all'utente l'opzione per disattivare il salvataggio</li>
     * <li> Disattivo (False): Rende disponibile all'utente l'opzione per attivare il salvataggio</li>
     * </ul>
     * 
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     */
    private void ActiveOrDisableAutomaticSave() {
        if (isActiveAutomaticSave == false) {
            menu.inviaMessaggio("Attivare salvataggio automatico? (S o N): ");
            String carattere;

            // Loop per continuare a chiedere una risposta valida
            do {
                carattere = scanner.next().trim().toUpperCase(); // Converte l'input in maiuscolo e rimuove spazi
                if (carattere.equals("S")) {
                    isActiveAutomaticSave = true;
                    menu.inviaMessaggio("Salvataggio automatico attivato con successo!");
                    pausa();
                    break; // Esce dal loop
                } else if (carattere.equals("N")) {
                    menu.inviaMessaggio("Il Salvataggio automatico non è stato attivato!");
                    pausa();
                    break; // Esce dal loop
                } else {
                    menu.inviaMessaggio("Input non valido. Inserire 'S' per Sì o 'N' per No: ");
                }
            } while (true);
        } else {
            menu.inviaMessaggio("Disattivare salvataggio automatico? (S o N): ");
            do {
                String carattere;
                carattere = scanner.next().trim().toUpperCase();
                if (carattere.equals("S")) {
                    isActiveAutomaticSave = false;
                    menu.inviaMessaggio("Salvataggio automatico disattivato con successo!");
                    pausa();
                    break; // Esce dal loop
                } else if (carattere.equals("N")) {
                    menu.inviaMessaggio("Il Salvataggio automatico non è stato disattivato!");
                    pausa();
                    break; // Esce dal loop
                } else {
                    menu.inviaMessaggio("Input non valido. Inserire 'S' per Sì o 'N' per No: ");
                }
            } while (true);
        }
    }
    
    //-----------------------------METODI CRUD-----------------------------
    private void aggiungiContatto(){
        
    }
    
    
    
    
}
