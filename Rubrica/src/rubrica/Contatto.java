package rubrica;

import java.util.Objects;

/**
 *
 * @author Paolo Riccardo Grasso, Alessandro Di Nella, Mario Favoino, Matteo
 * Lucia, Giuseppe Salomita
 *
 *
 */
public class Contatto {

    //Attributi
    public String nome;
    public String cognome;
    public String numeroTelefono;
    public String email;

    public Contatto(String nome, String cognome, String numeroTelefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        if (email == "") {
            this.email = null;
        } else {
            this.email = email;
        }
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cognome);
        return hash;
    }

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

}
