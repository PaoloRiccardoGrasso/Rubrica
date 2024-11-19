package rubrica;

import java.util.*;

/**
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Mario Favoino, Matteo
 * Lucia, Giuseppe Salomita
 *
 *
 */
public class Menu {

    private static Rubrica rubrica1 = new Rubrica();
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {

        int scelta = 0;
        do {
            cls();
            interfaccia();
            try {
                System.out.print("Scelta> ");
                scelta = scanner.nextInt();
                //TODO Eccezzioni
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            gestisciScelta(scelta);
        } while (scelta != 6);
    }

    private static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void interfaccia() {
        System.out.println("-----RUBRICA CLS-----");
        System.out.println("1. Aggiungi Contatto");
        System.out.println("2. Rimuovi Contatto");
        System.out.println("3. Modifica Contatto");
        System.out.println("4. Ricerca Contatto");
        System.out.println("5. Visualizza Rubrica");
        System.out.println("6. Esci");
    }

    public static void scelta1() {
        String nome, cognome, numTel, email;
        try {
            System.out.print("Inserisci nome> ");
            nome = scanner.next();
            System.out.print("Inserisci cognome> ");
            cognome = scanner.next();
            while (true) {
                try {
                    System.out.print("Inserisci numero> ");
                    numTel = scanner.next();

                    // Controllo con regex
                    /*
                    ^: inizio della stringa.
                    +?: il simbolo + è facoltativo.
                        d{9,}:
                            \\d indica una cifra.
                            {9,} indica che devono esserci almeno 9 cifre (non c'è limite superiore).
                    $: fine della stringa.*/
                    if (!numTel.matches("^\\+?\\d{9,}$")) {
                        throw new IllegalArgumentException("Il numero deve contenere solo cifre (min. 9) , opzionalmente, un '+' all'inizio.");
                    }

                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }
            scanner.nextLine();
            System.out.print("Inserisci Email (premere invio se sprovvisti> ");
            email = scanner.nextLine();

            Contatto contatto = new Contatto(nome, cognome, numTel, email);
            rubrica1.aggiungiContatto(contatto);
            System.out.println(contatto);

            System.out.print("Premi invio per continuare... ");
            scanner.nextLine();

            //TODO Eccezzioni
        } catch (Exception e) {
        }

    }

    private static void gestisciScelta(int scelta) {
        switch (scelta) {
            case 1:
                scelta1();
                break;
            case 2:
                System.out.println("Rimuovi Contatto selezionato.");
                break;
            case 3:
                System.out.println("Modifica Contatto selezionato.");
                break;
            case 4:
                System.out.println("Ricerca Contatto selezionato.");
                break;
            case 5:
                System.out.println(rubrica1);
                break;
            case 6:
                System.out.println("Uscita dal programma.");
                System.out.print("Premi invio per continuare... ");
                scanner.nextLine();
                break;
            default:
                System.out.println("Scelta non valida. Riprova.");
                break;
        }
    }

}
