package io.github.PaoloRiccardoGrasso.Model;

import java.util.Objects;

/**
 * Rappresenta un contatto all'interno di una rubrica telefonica.
 * <p>
 * La classe fornisce informazioni personali come nome, cognome, numero di telefono ed email, 
 * ed include metodi per accedere, modificare e confrontare i contatti.
 * </p>
 * 
 * Funzionalità principali:
 * <ul>
 *   <li>Creazione e gestione dei dati di un contatto.</li>
 *   <li>Confronto tra due contatti basato su nome e cognome.</li>
 *   <li>Generazione di una rappresentazione testuale dei dati del contatto.</li>
 * </ul>
 * 
 * @version Beta (2.0)
 * @since Alpha (1.0)
 */
public class Contatto {

    private String nome, cognome, numeroTelefono, email;

    /**
     * Costruisce un nuovo contatto con i dettagli forniti.
     * 
     * @param nome Nome della persona.
     * @param cognome Cognome della persona.
     * @param numeroTelefono Numero di telefono della persona.
     * @param email Email della persona (opzionale; se vuota o "null", viene impostata a null).
     */
    public Contatto(String nome, String cognome, String numeroTelefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        if (email.equals("") || email.equals("null")) {
            this.email = null;
        } else {
            this.email = email;
        }
    }

    /**
     * Restituisce il nome del contatto.
     * 
     * @return Nome del contatto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del contatto.
     * 
     * @param nome Nuovo nome del contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

   /**
     * Restituisce il cognome del contatto.
     * 
     * @return Cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del contatto.
     * 
     * @param cognome Nuovo cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce il numero di telefono del contatto.
     * 
     * @return Numero di telefono del contatto.
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Imposta il numero di telefono del contatto.
     * 
     * @param numeroTelefono Nuovo numero di telefono del contatto.
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

   /**
     * Restituisce l'email del contatto.
     * 
     * @return Email del contatto, oppure null se non è definita.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email del contatto.
     * 
     * @param email Nuova email del contatto.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Calcola l'hash code del contatto, basato su nome e cognome.
     * 
     * @return Hash code del contatto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cognome);
        return hash;
    }

    /**
     * Confronta questo contatto con un altro oggetto.
     * <p>
     * Due contatti sono considerati uguali se hanno lo stesso nome e cognome.
     * </p>
     * 
     * @param obj Oggetto da confrontare.
     * @return true se i contatti sono uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contatto other = (Contatto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cognome, other.cognome);
    }

    /**
     * Restituisce una rappresentazione testuale del contatto.
     * <p>
     * Include tutte le informazioni principali come nome, cognome, numero di telefono ed email.
     * </p>
     * 
     * @return Stringa rappresentativa del contatto.
     */
    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "--------------- Contatto --------------\n";
        s += "Nome: " + nome + "\n";
        s += "Cognome: " + cognome + "\n";
        s += "Numero di Telefono: " + numeroTelefono + "\n";
        s += "E-Mail: " + (email != null ? email : "N/D") + "\n";
        s += "---------------------------------------";
        return s;
    }

}
