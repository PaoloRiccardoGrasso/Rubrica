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

        int scelta;
        do {

            cls();
            interfaccia();
            System.out.print("Scelta> ");

            try {
                scelta = scanner.nextInt();
                gestisciScelta(scelta);
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserire un numero intero valido.");
                scelta = -1;
            }
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
        System.out.println("---------------------");
    }

    private static void gestisciScelta(int scelta) {
        switch (scelta) {
            case 1:
                aggiungiContatto();
                break;
            case 2:
                rimuoviContatto();
                break;
            case 3:
                modificaContatto();
                break;
            case 4:
                ricercaContatto();
                break;
            case 5:
                scanner.nextLine();
                System.out.println(rubrica1);
                System.out.print("Premi invio per continuare... ");
                scanner.nextLine();
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

    private static void aggiungiContatto() {
        String nome, cognome, numTel, email;
        boolean isContattoEsiste = false;
        scanner.nextLine();
        try {

            /*
            
            do {
                    System.out.print("Inserisci nome> ");
                    nome = scanner.nextLine();
                } while (nome.equals(""));

                do {
                    System.out.print("Inserisci cognome> ");
                    cognome = scanner.nextLine();
                } while (cognome.equals(""));
             */
            //-------------------------------------------------
            do {
                do {
                    System.out.print("Inserisci nome> ");
                    nome = scanner.nextLine();
                } while (nome.equals(""));

                do {
                    System.out.print("Inserisci cognome> ");
                    cognome = scanner.nextLine();
                } while (cognome.equals(""));

                for (int i = 0; i < rubrica1.rubrica.size(); i++) {
                    if (nome.equals(rubrica1.rubrica.get(i).nome)) {
                        if (cognome.equals(rubrica1.rubrica.get(i).cognome)) {
                            isContattoEsiste = true;
                            System.out.println("Contatto già esistente! Non Aggiunto");
                            System.out.print("Premi invio per continuare... ");
                            scanner.nextLine();
                            cls();
                        } else {
                            isContattoEsiste = false;
                        }
                    }
                }
            } while (isContattoEsiste == true);

            //------------------------------------------------------
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
            
            
            //TODO Controllo Email
            System.out.print("Inserisci Email (premere invio se sprovvisti)> ");
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

    private static void rimuoviContatto() {
        String nome = null, cognome = null;
        try {

            do {
                System.out.print("Inserisci nome> ");
                nome = scanner.nextLine();
            } while (nome.equals(""));

            do {
                System.out.print("Inserisci cognome> ");
                cognome = scanner.nextLine();
            } while (cognome.equals(""));

        } catch (Exception e) {
            System.out.println("Errore generico! ");
        }

        System.out.println("Stai per rimuovere: ");
        int indiceContatto = rubrica1.cercaContatto(nome, cognome);
        System.out.print("Premi invio per continuare... ");
        scanner.nextLine();
        rubrica1.rimuoviContatto(indiceContatto);
        System.out.print("Premi invio per continuare... ");
        scanner.nextLine();

    }

    private static void modificaContatto() {
        String nome = null, cognome = null, nome1, cognome1, numTel, email;
        boolean isContattoEsiste = false;
        scanner.nextLine();
        try {
            do {
                System.out.print("Inserisci nome> ");
                nome = scanner.nextLine();
            } while (nome.equals(""));

            do {
                System.out.print("Inserisci cognome> ");
                cognome = scanner.nextLine();
            } while (cognome.equals(""));
        } catch (Exception e) {
            System.out.println("Errore generico! ");
        }

        int indiceContatto = rubrica1.cercaContatto(nome, cognome);

        scanner.nextLine();
        if (indiceContatto != -1) {

            try {
                do {
                do {
                    System.out.print("Inserisci nome> ");
                    nome = scanner.nextLine();
                } while (nome.equals(""));

                do {
                    System.out.print("Inserisci cognome> ");
                    cognome = scanner.nextLine();
                } while (cognome.equals(""));

                for (int i = 0; i < rubrica1.rubrica.size(); i++) {
                    if (nome.equals(rubrica1.rubrica.get(i).nome)) {
                        if (cognome.equals(rubrica1.rubrica.get(i).cognome)) {
                            isContattoEsiste = true;
                            System.out.println("Contatto già esistente! Non Modificabile!");
                            System.out.print("Premi invio per continuare... ");
                            scanner.nextLine();
                        } else {
                            isContattoEsiste = false;
                        }
                    }
                }
            } while (isContattoEsiste == true);

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
                
                //TODO Controllo email
                System.out.print("Inserisci Email (premere invio se sprovvisti)> ");
                email = scanner.nextLine();

                
                
                Contatto contatto = new Contatto(nome, cognome, numTel, email);
                rubrica1.modificaContatto(indiceContatto, contatto);
                System.out.println(contatto);

                System.out.print("Premi invio per continuare... ");
                scanner.nextLine();

                //TODO Eccezzioni
            } catch (Exception e) {
            }
        } else {
            System.out.print("Premi invio per continuare... ");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    private static void ricercaContatto() {
        String nome = null, cognome = null;

        scanner.nextLine();
        try {
            do {
                System.out.print("Inserisci nome> ");
                nome = scanner.nextLine();
            } while (nome.equals(""));

            do {
                System.out.print("Inserisci cognome> ");
                cognome = scanner.nextLine();
            } while (cognome.equals(""));
        } catch (Exception e) {
            System.out.println("Errore generico! ");
        }

        rubrica1.cercaContatto(nome, cognome);
        System.out.print("Premi invio per continuare... ");
        scanner.nextLine();
        scanner.nextLine();

    }

}
