package io.github.PaoloRiccardoGrasso.Model;

import java.util.Objects;

/**
 * La classe Contatto rappresenta un singolo contatto nella rubrica telefonica.
 * Contiene informazioni personali come nome, cognome, numero di telefono ed
 * email. Offre metodi per accedere e modificare i dati, oltre a confrontare due
 * contatti.
 *
 *
 * Funzionalità principali:
 * <ul>
 * <li>Creazione di un contatto con informazioni personali.</li>
 * <li>Confronto tra due contatti basato su nome e cognome.</li>
 * </ul>
 *
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Giuseppe Salomita, Mario
 * Favoino, Matteo Lucia
 * @version Beta (2.0)
 * @since Alpha (1.0)
 */
public class Contatto {

    private String nome, cognome, numeroTelefono, email;

    /**
     * Costruttore utile per istanziare e inizializzare l'intero contatto con i
     * suoi parametri.
     *
     * @param nome Nome della persona da inserire
     * @param cognome Cognome della persona da inserire
     * @param numeroTelefono Numero di telefono della persona da inserire
     * @param email (Opzionale) Email della persona da inserire
     *
     */
    public Contatto(String nome, String cognome, String numeroTelefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        if (email.equals("")) {
            this.email = null;
        } else {
            this.email = email;
        }
    }

    /**
     * Metodo getter per leggere il contenuto dell'attributo nome
     *
     * @return String Nome della persona
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo setter per scrivere il contenuto nell'attributo nome
     * 
     * @param nome Nome da inserire
     *
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo setter per scrivere il contenuto nell'attributo cognome
     * 
     * @param cognome Cognome da inserire
     *
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * Metodo setter per scrivere il contenuto nell'attributo numeroTelefono
     * 
     * @param numeroTelefono Numero di telefono da inserire
     *
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cognome);
        return hash;
    }

    /**
     * Compara questo oggetto con un altro per verificare se sono uguali. Il
     * confronto è basato su i valori dei campi `nome` e `cognome` dell'oggetto
     * `Contatto`. Due oggetti sono considerati uguali se sono della stessa
     * classe, non sono nulli e i loro campi `nome` e `cognome` sono uguali.
     *
     * @param obj l'oggetto con cui confrontare questo oggetto. Deve essere
     * della stessa classe, altrimenti il metodo restituirà `false`.
     * @return `true` se gli oggetti sono uguali, `false` altrimenti.
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

    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "--------------- Contatto ---------------\n";
        s += "Nome: " + nome + "\n";
        s += "Cognome: " + cognome + "\n";
        s += "Numero di Telefono: " + numeroTelefono + "\n";
        s += "E-Mail: " + (email != null ? email : "N/D") + "\n";
        s += "----------------------------------------";
        return s;
    }

}
