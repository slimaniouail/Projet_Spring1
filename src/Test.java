/**
 *
 *
 * Slimani ouail jh791263
 */

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
public class Test {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\jh791263\\IdeaProjects\\Projet_Spring1\\src\\employe.json"));

            JSONObject jsonObject = (JSONObject)obj;

            String matricule_employe = (String) jsonObject.get("matricule_employe");
            String type_employe = (String) jsonObject.get("type_employe");
            String taux_horaire_min = (String) jsonObject.get("taux_horaire_min");
            String taux_horaire_max = (String) jsonObject.get("taux_horaire_max");


            JSONArray subjects = (JSONArray)jsonObject.get("interventions");

            Interventions jsonObjectInter;

            ArrayList<Interventions> L = new ArrayList();


            for(int i = 0; i < subjects.size(); i++) {

                Interventions Int = new Interventions(((HashMap) subjects.get(i)).get("code_client"), ((HashMap) subjects.get(i)).get("distance_deplacement"),
                        ((HashMap) subjects.get(i)).get("overtime"), ((HashMap) subjects.get(i)).get("nombre_heures"),
                        ((HashMap) subjects.get(i)).get("date_intervention"));

                L.add(Int);
            }

            Employe emp = new Employe(matricule_employe, type_employe , taux_horaire_min, taux_horaire_max, L);

            System.out.println(Employe.CalculEtatCompte(emp));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
