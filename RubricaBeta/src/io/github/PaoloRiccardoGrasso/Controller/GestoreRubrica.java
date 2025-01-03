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
     * Attributo pubblico per controllare lo stato del salvataggio automatico:
     *
     * <ul>
     * <li> True: Il salvataggio automatico è attivo </li>
     * <li> False: Il salvataggio automaticoo è disattivato </li>
     * </ul>
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     */
    public boolean isActiveAutomaticSave = false;
    Scanner scanner = new Scanner(System.in);
    Rubrica rubrica = new Rubrica();

    /**
     * Costruttore personalizzato, utile per creare anche un oggetto di tipo
     * Menu.
     *
     * @param menu Oggetto Menu
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     */
    public GestoreRubrica(Menu menu) {
        this.menu = menu;
    }

    /**
     * Switch-Case per la scelta effettuata dall'utente.
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     */
    public void gestisciScelta() {
        int scelta;
        try {
            menu.inviaMessaggio("Scelta> ");
            scelta = scanner.nextInt(); // Acquisisce l'input

            switch (scelta) {
                case 1:
                    /*Chiamata al metodo utile per prelevare gli input da 
                    tastiera e salvare il contatto all'interno dell'arraylist*/
                    aggiungiContatto();
                    pausa();
                    break;
                case 2:
                    /*Chiamata al metodo utile per prelevare gli input da 
                    tastiera e rimuovere il contatto dall'interno dell'arraylist*/
                    rimuoviContatto();
                    break;
                case 3:
                    /*Chiamata al metodo utile per prelevare gli input da 
                    tastiera e modificare il contatto contenuto all'interno dell'arraylist*/
                    modificaContatto();
                    pausa();
                    break;
                case 4:
                    /*Chiamata al metodo utile per prelevare gli input da 
                    tastiera e ricerca il contatto all'interno dell'arraylist*/
                    ricercaContatto();
                    pausa();
                    break;
                case 5:
                    /*Chiamata al metodo utile per visualizzare la rubrica
                    memorizzata nell'arraylist*/
                    visualizzaRubrica();
                    pausa();
                    break;
                case 6:
                    /*Chiamata al metodo utile per attivare/disattivare il salvataggio automatico*/
                    ActiveOrDisableAutomaticSave();
                    break;
                case 7:
                    //Istruzioni utili per l'uscita da parte dell'utente dal programma
                    menu.inviaMessaggio("Uscita dal programma.");
                    pausa();
                    System.exit(0); // Esci dal programma
                    break;
                default:
                    //Istruzioni utili per attenzionare l'utente della scelta non valida
                    menu.inviaMessaggio("Scelta non valida. Riprova.");
                    scanner.nextLine();
                    pausa();
                    break;
            }
        } catch (InputMismatchException e) {
            /*Viene lanciata l'eccezzione qualora venisse 
            inserito un carattere diverso da quelli numerici*/
            menu.inviaMessaggio("Errore: inserire un numero intero valido.");
            pausa();
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
    /**
     *
     * Metodo utile per interfacciarsi tra il model e la view per aggiungere un
     * contatto alla rubrica
     *
     * Possono essere visualizzati i seguenti messaggi durante la creazione e
     * l'aggiunta del contatto.
     *
     * <ul>
     * <li> Contatto aggiunto con successo: <b>Il contatto è stato aggiunto
     * senza errori</b></li>
     * <li> Errore nell'inserimento del contat.: <b>Il contatto non è stato
     * aggiunto per errori generici inerenti all'esecuzione del
     * programma</b></li>
     * </ul>
     *
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     * @since Alpha (1.0)
     */
    private void aggiungiContatto() {
        String nome, cognome, numeroDiTelefono, email;

        scanner.nextLine();

        menu.cls();

        //Interfaccia inviata dal controller attraverso la view
        menu.inviaMessaggio("=======================================");
        menu.inviaMessaggio("\n|          Aggiungi Contatto          |");
        menu.inviaMessaggio("\n=======================================\n");
        menu.inviaMessaggio("\n");

        //Inserimento del nome
        do {
            menu.inviaMessaggio("Inserire nome> ");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        //Inserimento del cognome
        do {
            menu.inviaMessaggio("Inserire cognome> ");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        //Controllo di un eventuale esistenza del contatto
        /*
            Se: int > 1 - Il contatto esiste.
            Se: int == -1 - Il contatto non esiste e si procede alla creazione
         */
        if (rubrica.cercaContatto(nome, cognome) == -1) {
            while (true) {
                try {
                    /*Inserimento del numero di telefono e controllo attraverso 
                    regex del corretto inserimento*/
                    menu.inviaMessaggio("Inserire numero> ");
                    numeroDiTelefono = scanner.next();

                    // Controllo con regex
                    /*
                    ^: inizio della stringa.
                    +?: il simbolo + è facoltativo.
                        d{9,}:
                            \\d indica una cifra.
                            {9,} indica che devono esserci almeno 9 cifre (non c'è limite superiore).
                    $: fine della stringa.*/
                    //Lancia eccezzione qualora il numero di telefono non rispetta le regole imposte dal regex
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
                    //Inserimento dell'email e controllo attraverso regole regex
                    System.out.print("Inserire Email (premere invio se sprovvisti)> ");
                    email = scanner.nextLine();

                    //Se l'email è vuota viene saltato il controllo di regex
                    if (email.isEmpty()) {
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

            /*Creazione dell'oggetto contatto, viene inizializzato attraverso 
            il suo costruttore personalizzato*/
            Contatto contatto = new Contatto(nome, cognome, numeroDiTelefono, email);

            //Interfacce da visualizzare come esito dell'inserimento del contatto nella rubrica
            if (rubrica.aggiungiContatto(contatto)) {
                /*Se restituito true dalla funzione aggiungiContatto, verrà stampata 
                attraverso la view la seguente schermata*/
                menu.inviaMessaggio("\n");
                menu.inviaMessaggio("\n=======================================");
                menu.inviaMessaggio("\n|   Contatto Aggiunto con successo!   |");
                menu.inviaMessaggio("\n=======================================\n");
            } else {
                /*Se restituito false dalla funzione aggiungiContatto, verrà stampata
                attraverso la view la seguente schermata*/
                menu.inviaMessaggio("\n");
                menu.inviaMessaggio("\n=======================================");
                menu.inviaMessaggio("\n| Errore nell'inserimento del contat. |");
                menu.inviaMessaggio("\n=======================================\n");
            }

        } else {
            //Qualora il contatto dovesse già esistere verrà stampato attraverso la view il seguente messagggio:
            menu.inviaMessaggio("Contatto già esistente! Non Aggiunto\n");
            pausa();
            menu.apriMenu();
        }

    }

    /**
     *
     * Metodo utile per interfacciarsi tra il model e la view per rimuovere un
     * contatto alla rubrica
     *
     * Possono essere visualizzati i seguenti messaggi durante la creazione e
     * l'aggiunta del contatto.
     *
     * <ul>
     * <li> Contatto rimosso con successo: <b>Il contatto è stato aggiunto senza
     * errori</b></li>
     * <li> Errore nella rimozione del contatto: <b>Il contatto non è stato
     * aggiunto per errori generici inerenti all'esecuzione del
     * programma</b></li>
     * </ul>
     *
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     * @since Alpha (1.0)
     */
    private void rimuoviContatto() {
        String nome, cognome;

        //Interfaccia inviata dal controller attraverso la view
        scanner.nextLine();
        menu.cls();
        menu.inviaMessaggio("=======================================");
        menu.inviaMessaggio("\n|           Rimuovi Contatto          |");
        menu.inviaMessaggio("\n=======================================\n");
        menu.inviaMessaggio("\n");

        //Inserimmento del nome
        do {
            menu.inviaMessaggio("Inserire nome> ");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        //Inserimento del cognome
        do {
            menu.inviaMessaggio("Inserire cognome> ");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        /*Salvataggio dell'indice in cui è salvato il 
        contatto da rimuovere all'interno dell'arraylist*/
        int indice = rubrica.cercaContatto(nome, cognome);
        //Contrllo se il contatto esiste
        if (indice != -1) {
            menu.inviaMessaggio("\n");
            //Viene stampato il contatto che si sta per rimuovere
            menu.inviaMessaggio("Stai per rimuovere il seguente contatto: ");
            menu.inviaMessaggio(rubrica.rubrica.get(indice).toString());
            pausa();
            if (rubrica.rimuoviContatto(indice)) {
                /*se il metodo rimuoviContatto restituisce true, viene stampata attraverso la view
                la seguente schermata*/
                menu.inviaMessaggio("\n");
                menu.inviaMessaggio("\n=======================================");
                menu.inviaMessaggio("\n|    Contatto Rimosso con successo!   |");
                menu.inviaMessaggio("\n=======================================\n");
                pausa();
            } else {
                /*se il metodo rimuoviContatto restituisce false, viene stampata attraverso la view
                la seguente schermata*/
                menu.inviaMessaggio("\n");
                menu.inviaMessaggio("\n=======================================");
                menu.inviaMessaggio("\n| Errore nella rimozione del contatto |");
                menu.inviaMessaggio("\n=======================================\n");
                pausa();
            }
        } else {
            //Messaggio inviato dalla view qualora non dovesse trovare il contatto da rimuovere
            menu.inviaMessaggio("Contatto non trovato!");
            pausa();
        }

    }

    /**
     *
     * Metodo utile per interfacciarsi tra il model e la view per modificare un
     * contatto della rubrica
     *
     * Possono essere visualizzati i seguenti messaggi durante la creazione e
     * l'aggiunta del contatto.
     *
     * <ul>
     * <li> Contatto modificato con successo: <b>Il contatto è stato aggiunto
     * senza errori</b></li>
     * <li> Errore nella modifica del contatto: <b>Il contatto non è stato
     * aggiunto per errori generici inerenti all'esecuzione del
     * programma</b></li>
     * </ul>
     *
     *
     * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita,
     * Mario Favoino, Matteo Lucia
     * @version Beta (2.0)
     * @since Alpha (1.0)
     */
    private void modificaContatto() {
        String nome, cognome, email = null, numeroDiTelefono = null;

        scanner.nextLine();
        menu.cls();

        //Interfaccia inviata attraverso la view.
        menu.inviaMessaggio("========================================");
        menu.inviaMessaggio("\n|          Modifica Contatto           |");
        menu.inviaMessaggio("\n|                                      |");
        menu.inviaMessaggio("\n|                Ricerca               |");
        menu.inviaMessaggio("\n========================================\n");
        menu.inviaMessaggio("\n");

        //Inserimento del nome
        do {
            menu.inviaMessaggio("Inserire nome> ");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        //Inserimento del cognome
        do {
            menu.inviaMessaggio("Inserire cognome> ");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        //ricerca del contatto attraverso il nome e il cognome
        int indice = rubrica.cercaContatto(nome, cognome);
        if (indice != -1) {
            //Se il contatto viene trovato viene visualizzato e apportato le modifiche successive
            menu.inviaMessaggio("\nStai per modificare questo contatto:");
            menu.inviaMessaggio(rubrica.rubrica.get(indice).toString());

            menu.inviaMessaggio("\n========================================");
            menu.inviaMessaggio("\n|          Modifica Contatto           |");
            menu.inviaMessaggio("\n|                                      |");
            menu.inviaMessaggio("\n|   Premere invio per non modificare   |");
            menu.inviaMessaggio("\n========================================\n");
            menu.inviaMessaggio("\n");

            // Inserimento del nuovo nome (Opzionale)
            menu.inviaMessaggio("Inserire nome> ");
            String inputNome = scanner.nextLine();
            if (inputNome.isEmpty()) {
                menu.inviaMessaggio("Nome non modificato\n");
            }

            // Inserimento del nuovo cognome (Opzionale)
            menu.inviaMessaggio("Inserire cognome> ");
            String inputCognome = scanner.nextLine();
            if (inputCognome.isEmpty()) {
                menu.inviaMessaggio("Cognome non modificato\n");
            }

            menu.inviaMessaggio("Inserire numero> ");
            while (true) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    menu.inviaMessaggio("Numero non modificato\n");
                    numeroDiTelefono = rubrica.rubrica.get(indice).getNumeroTelefono();
                    break;
                } else {
                    try {
                        // Controllo con regex
                        /*
                        ^: inizio della stringa.
                        +?: il simbolo + è facoltativo.
                        \\d{9,}:
                            \\d indica una cifra.
                            {9,} indica che devono esserci almeno 9 cifre (non c'è limite superiore).
                        $: fine della stringa.
                         */
                        if (!input.matches("^\\+?\\d{9,}$")) {
                            throw new IllegalArgumentException("Il numero deve contenere solo cifre (min. 9) e, opzionalmente, un '+' all'inizio.\n");
                        }

                        numeroDiTelefono = input;
                        break;

                    } catch (IllegalArgumentException e) {
                        menu.inviaMessaggio("Errore: " + e.getMessage());
                        menu.inviaMessaggio("Inserire numero> ");
                    }
                }
            }

            menu.inviaMessaggio("Inserire email> ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                menu.inviaMessaggio("Email non modificata\n");
                String emailCorrente = rubrica.rubrica.get(indice).getEmail();

                if (emailCorrente == null || emailCorrente.isEmpty()) {
                    email = ""; // Mantieni email vuota se non esiste già un valore
                } else {
                    email = emailCorrente; // Mantieni email esistente
                }
                
            } else {
                while (true) {
                    try {
                        email = input.trim();

                        // Controllo con regex
                        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                            throw new IllegalArgumentException("L'indirizzo email non è valido. Assicurati che sia nel formato corretto, ad esempio: nomeutente@dominio.com\n");
                        }

                        break; // Email valida, esci dal ciclo
                    } catch (IllegalArgumentException e) {
                        menu.inviaMessaggio("Errore: " + e.getMessage());
                        menu.inviaMessaggio("Inserire email> "); // Richiedi di nuovo l'input
                        input = scanner.nextLine();
                    }
                }
            }

            Contatto contatto = new Contatto(nome, cognome, numeroDiTelefono, email);
            if (rubrica.modificaContatto(contatto, indice)) {
                menu.inviaMessaggio("\n");
                menu.inviaMessaggio("\n=======================================");
                menu.inviaMessaggio("\n|  Contatto Modificato con successo!  |");
                menu.inviaMessaggio("\n=======================================\n");
            } else {
                menu.inviaMessaggio("\n");
                menu.inviaMessaggio("\n=======================================");
                menu.inviaMessaggio("\n|  Errore nella modifica del contat.  |");
                menu.inviaMessaggio("\n=======================================\n");
            }
        } else {
            menu.inviaMessaggio("Contatto non trovato!");
        }
    }

    private void ricercaContatto() {
        String nome, cognome;

        scanner.nextLine();
        menu.cls();

        menu.inviaMessaggio("=======================================");
        menu.inviaMessaggio("\n|          Ricerca Contatto          |");
        menu.inviaMessaggio("\n=======================================\n");
        menu.inviaMessaggio("\n");

        do {
            menu.inviaMessaggio("Inserire nome> ");
            nome = scanner.nextLine();
        } while (nome.equals(""));

        do {
            menu.inviaMessaggio("Inserire cognome> ");
            cognome = scanner.nextLine();
        } while (nome.equals(""));

        int indice = rubrica.cercaContatto(nome, cognome);
        if (indice != -1) {
            menu.inviaMessaggio("\n");
            menu.inviaMessaggio("=======================================");
            menu.inviaMessaggio("\n|           Contatto trovato          |");
            menu.inviaMessaggio("\n=======================================\n");
            menu.inviaMessaggio(rubrica.rubrica.get(indice).toString());
        } else {
            menu.inviaMessaggio("\n");
            menu.inviaMessaggio("=======================================");
            menu.inviaMessaggio("\n|         Contatto non trovato        |");
            menu.inviaMessaggio("\n=======================================\n");
        }

    }

    private void visualizzaRubrica() {
        menu.cls();
        menu.inviaMessaggio("=======================================");
        menu.inviaMessaggio("\n|             RUBRICA CLI             |");

        if (rubrica.toString().equals("-1")) {
            menu.inviaMessaggio("\n|                                     |");
            menu.inviaMessaggio("\n|          La rubrica è vuota         |");
            menu.inviaMessaggio("\n|                                     |");
            menu.inviaMessaggio("\n=======================================");
        } else {
            menu.inviaMessaggio("\n=======================================");
            menu.inviaMessaggio(rubrica.toString());
        }

        scanner.nextLine();
    }

}
