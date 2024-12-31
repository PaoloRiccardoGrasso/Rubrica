package io.github.PaoloRiccardoGrasso.Controller;

import io.github.PaoloRiccardoGrasso.Model.Contatto;
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
                    rimuoviContatto();
                    break;
                case 3:
                    modificaContatto();
                    pausa();
                    break;
                case 4:
                    menu.inviaMessaggio("Hai scelto 4");
                    pausa();
                    break;
                case 5:
                    menu.inviaMessaggio(rubrica.toString());
                    scanner.nextLine();
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
        menu.inviaMessaggio("\nPremere invio per continuare...");
        scanner.nextLine();
    }

    /**
     * Metodo per attivare il salvataggio automatico dei file.
     *
     * Se il parametro isAsctiveAutomaticSave è:
     * <ul>
     * <li> Attivo (True): Rende disponibile all'utente l'opzione per
     * disattivare il salvataggio</li>
     * <li> Disattivo (False): Rende disponibile all'utente l'opzione per
     * attivare il salvataggio</li>
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
    private void aggiungiContatto() {
        String nome, cognome, numeroDiTelefono, email;

        scanner.nextLine();

        do {
            menu.inviaMessaggio("Inserire nome>");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        do {
            menu.inviaMessaggio("Inserire cognome>");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        if (rubrica.cercaContatto(nome, cognome) == -1) {
            while (true) {
                try {
                    menu.inviaMessaggio("Inserisci numero> ");
                    numeroDiTelefono = scanner.next();

                    // Controllo con regex
                    /*
                    ^: inizio della stringa.
                    +?: il simbolo + è facoltativo.
                        d{9,}:
                            \\d indica una cifra.
                            {9,} indica che devono esserci almeno 9 cifre (non c'è limite superiore).
                    $: fine della stringa.*/
                    if (!numeroDiTelefono.matches("^\\+?\\d{9,}$")) {
                        throw new IllegalArgumentException("Il numero deve contenere solo cifre (min. 9) , opzionalmente, un '+' all'inizio.\n");
                    }

                    break;

                } catch (IllegalArgumentException e) {
                    menu.inviaMessaggio("Errore: " + e.getMessage());
                }
            }

            scanner.nextLine();

            while (true) {
                try {
                    System.out.print("Inserisci Email (premere invio se sprovvisti)> ");
                    email = scanner.nextLine();

                    if (email.isEmpty()) {
                        email = "";
                        break;
                    }

                    // Controllo con regex
                    /*
                    - ^                 : Inizio della stringa.
                    - [a-zA-Z0-9._%+-]+ : Uno o più caratteri ammessi nella parte locale:
                                          lettere, numeri, punto (.), underscore (_), percentuale (%), più (+), meno (-).
                    - @                 : Separatore obbligatorio tra parte locale e dominio.
                    - [a-zA-Z0-9.-]+    : Uno o più caratteri ammessi nel dominio:
                                          lettere, numeri, punto (.), trattino (-).
                    - \.                : Punto letterale per separare il dominio dal TLD.
                    - [a-zA-Z]{2,}      : TLD (Top Level Domain), almeno 2 caratteri alfabetici (es. .com, .org).
                    - $                 : Fine della stringa.
                     */
                    if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                        throw new IllegalArgumentException("L'indirizzo email non è valido. Assicurati che sia nel formato corretto, ad esempio: nomeutente@dominio.com\n");
                    }

                    break; // Email valida, esci dal ciclo
                } catch (IllegalArgumentException e) {
                    menu.inviaMessaggio("Errore: " + e.getMessage());
                }
            }
            Contatto contatto = new Contatto(nome, cognome, numeroDiTelefono, email);

            if (rubrica.aggiungiContatto(contatto)) {
                menu.inviaMessaggio("Contatto aggiunto con successo!\n");
            } else {
                menu.inviaMessaggio("Errore nell'inserimento del contatto nella rubrica\n");
            }

        } else {
            menu.inviaMessaggio("Contatto già esistente! Non Aggiunto\n");
            pausa();
            menu.apriMenu();
        }

    }

    private void rimuoviContatto() {
        String nome, cognome;

        scanner.nextLine();

        do {
            menu.inviaMessaggio("Inserire nome>");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        do {
            menu.inviaMessaggio("Inserire cognome>");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        int indice = rubrica.cercaContatto(nome, cognome);
        if (indice != -1) {
            menu.inviaMessaggio("Stai per rimuovere il seguente contatto: ");
            menu.inviaMessaggio(rubrica.rubrica.get(indice).toString());
            pausa();
            if (rubrica.rimuoviContatto(indice)) {
                menu.inviaMessaggio("Contatto rimosso con successo!");
                pausa();
            } else {
                menu.inviaMessaggio("Errore nella rimozione del contatto!");
                pausa();
            }
        }

    }

    private void modificaContatto() {
        String nome, cognome, email = null, numeroDiTelefono = null;

        scanner.nextLine();

        do {
            menu.inviaMessaggio("Inserire nome>");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        do {
            menu.inviaMessaggio("Inserire cognome>");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        int indice = rubrica.cercaContatto(nome, cognome);
        menu.inviaMessaggio("Stai per modificare questo contatto:\n");
        menu.inviaMessaggio(rubrica.rubrica.get(indice).toString());
        do {
            menu.inviaMessaggio("\nInserire nome>");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        do {
            menu.inviaMessaggio("Inserire cognome>");
            cognome = scanner.nextLine();
        } while (nome.equals(""));
        
        while (true) {
            try {
                menu.inviaMessaggio("Inserisci numero> ");
                numeroDiTelefono = scanner.next();

                // Controllo con regex
                /*
                    ^: inizio della stringa.
                    +?: il simbolo + è facoltativo.
                        d{9,}:
                            \\d indica una cifra.
                            {9,} indica che devono esserci almeno 9 cifre (non c'è limite superiore).
                    $: fine della stringa.*/
                if (!numeroDiTelefono.matches("^\\+?\\d{9,}$")) {
                    throw new IllegalArgumentException("Il numero deve contenere solo cifre (min. 9) , opzionalmente, un '+' all'inizio.\n");
                }

                break;

            } catch (IllegalArgumentException e) {
                menu.inviaMessaggio("Errore: " + e.getMessage());
            }
        }

        scanner.nextLine();

        while (true) {
            try {
                System.out.print("Inserisci Email (premere invio se sprovvisti)> ");
                email = scanner.nextLine();

                if (email.isEmpty()) {
                    email = "";
                    break;
                }

                // Controllo con regex
                /*
                    - ^                 : Inizio della stringa.
                    - [a-zA-Z0-9._%+-]+ : Uno o più caratteri ammessi nella parte locale:
                                          lettere, numeri, punto (.), underscore (_), percentuale (%), più (+), meno (-).
                    - @                 : Separatore obbligatorio tra parte locale e dominio.
                    - [a-zA-Z0-9.-]+    : Uno o più caratteri ammessi nel dominio:
                                          lettere, numeri, punto (.), trattino (-).
                    - \.                : Punto letterale per separare il dominio dal TLD.
                    - [a-zA-Z]{2,}      : TLD (Top Level Domain), almeno 2 caratteri alfabetici (es. .com, .org).
                    - $                 : Fine della stringa.
                 */
                if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    throw new IllegalArgumentException("L'indirizzo email non è valido. Assicurati che sia nel formato corretto, ad esempio: nomeutente@dominio.com\n");
                }

                break; // Email valida, esci dal ciclo
            } catch (IllegalArgumentException e) {
                menu.inviaMessaggio("Errore: " + e.getMessage());
            }
        }

        Contatto contatto = new Contatto(nome, cognome, numeroDiTelefono, email);
        if (rubrica.modificaContatto(contatto, indice)) {
            menu.inviaMessaggio("Contatto modificato con successo!");
        } else {
            menu.inviaMessaggio("Errore nella modifica del contatto!");
        }
    }
}
