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
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("--------------- Contatto ---------------\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Cognome: ").append(cognome).append("\n");
        sb.append("Numero di Telefono: ").append(numeroTelefono).append("\n");
        sb.append("E-Mail: ").append(email != null ? email : "N/D").append("\n");
        sb.append("--------------- Aggiunto ---------------");
        return sb.toString();
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
