/**
 *
 *
 * Slimani ouail jh791263
 */

import java.sql.Date;

public class Interventions {

    Object code_client;
    Object distance_deplacement;
    Object overtime;
    Object nombre_heures;
    Object date_intervention;

    public Interventions(Object code_client, Object distance_deplacement, Object overtime, Object nombre_heures, Object date_intervention) {
        this.code_client = code_client;
        this.distance_deplacement = distance_deplacement;
        this.overtime = overtime;
        this.nombre_heures = nombre_heures;
        this.date_intervention = date_intervention;
    }

    public Object getCode_client() {
        return code_client;
    }

    public void setCode_client(String code_client) {
        this.code_client = code_client;
    }

    public Object getDistance_deplacement() {
        return distance_deplacement;
    }

    public void setDistance_deplacement(int distance_deplacement) {
        this.distance_deplacement = distance_deplacement;
    }

    public Object getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public Object getNombre_heures() {
        return nombre_heures;
    }

    public void setNombre_heures(int nombre_heures) {
        this.nombre_heures = nombre_heures;
    }

    public Object getDate_intervention() {
        return date_intervention;
    }

    public void setDate_intervention(String date_intervention) {
        this.date_intervention = date_intervention;
    }

    @Override
    public String toString() {
        return "Interventions [code_client=" + code_client + ", distance_deplacement=" + distance_deplacement
                + ", overtime=" + overtime + ", nombre_heures=" + nombre_heures + ", date_intervention="
                + date_intervention + "]";
    }






}

