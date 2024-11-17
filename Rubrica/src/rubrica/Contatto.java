package rubrica;

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
        s += "[Nome: " + nome;
        s += " Cognome: " + cognome;
        s += " Num. di Telefono: " + numeroTelefono;
        if (email == null) {
            s += " E-Mail: N/D]";
        } else {
            s += " E-Mail: " + email + "]";
        }
        return s;
    }

}
