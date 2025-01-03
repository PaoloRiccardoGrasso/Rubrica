package io.github.PaoloRiccardoGrasso;

import io.github.PaoloRiccardoGrasso.Model.*;
import io.github.PaoloRiccardoGrasso.View.Menu;


/**
 * Classe principale dell'applicazione.
 * <p>
 * Questa classe avvia l'esecuzione del programma. Il metodo `main` è il punto di ingresso,
 * e richiama il metodo `Run` per inizializzare e avviare il menu principale dell'applicazione.
 */
public class App {
    /**
     * Metodo principale del programma.
     * <p>
     * Questo metodo crea un'istanza della classe `App` e avvia l'applicazione
     * chiamando il metodo {@link #Run()}.
     *
     * @param args eventuali argomenti passati da linea di comando (non utilizzati in questa implementazione).
     */
    public static void main(String[] args) {
        App app = new App();
        
        app.Run();
    }
    
    /**
     * Avvia il flusso principale dell'applicazione.
     * <p>
     * Questo metodo inizializza il menu principale dell'applicazione, rappresentato dalla classe {@link Menu},
     * e richiama il metodo {@code apriMenu()} per gestire l'interfaccia utente e le operazioni disponibili.
     */
    public void Run(){
        Menu menu = new Menu();
        
        
        menu.apriMenu();
        
    }
}
