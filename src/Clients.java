/**
 *
 *
 * Slimani ouail jh791263
 */

public class Clients {

    Object code_client;
    Object etat_par_client;

    public Clients(Object code_client, Object etat_par_client) {
        super();
        this.code_client = code_client;
        this.etat_par_client = etat_par_client;
    }

    public Object getCode_client() {
        return code_client;
    }

    public void setCode_client(Object code_client) {
        this.code_client = code_client;
    }

    public Object getEtat_par_client() {
        return etat_par_client;
    }

    public void setEtat_par_client(Object etat_par_client) {
        this.etat_par_client = etat_par_client;
    }

    @Override
    public String toString() {
        return "Clients [code_client=" + code_client + ", etat_par_client=" + etat_par_client + "]";
    }




}
