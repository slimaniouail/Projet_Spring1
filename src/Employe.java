/**
 *
 *
 * Slimani ouail jh791263
 */

import java.util.*;


public class Employe {

    static String matricule_employe;
    static String type_employe;
    static String taux_horaire_min;
    static String taux_horaire_max;
    static ArrayList<Interventions> LI;

    public Employe(String matricule_employe, String type_employe, String taux_horaire_min, String taux_horaire_max, ArrayList<Interventions> lI) {
        this.matricule_employe = matricule_employe;
        this.type_employe = type_employe;
        this.taux_horaire_min = taux_horaire_min;
        this.taux_horaire_max = taux_horaire_max;
        this.LI = lI;
    }

    public String getMatricule_employe() {
        return matricule_employe;
    }

    public void setMatricule_employe(String matricule_employe) {
        this.matricule_employe = matricule_employe;
    }

    public String getType_employe() {
        return type_employe;
    }

    public void setType_employe(String type_employe) {
        this.type_employe = type_employe;
    }

    public String getTaux_horaire_min() {
        return taux_horaire_min;
    }

    public void setTaux_horaire_min(String taux_horaire_min) {
        this.taux_horaire_min = taux_horaire_min;
    }

    public String getTaux_horaire_max() {
        return taux_horaire_max;
    }

    public void setTaux_horaire_max(String taux_horaire_max) {
        this.taux_horaire_max = taux_horaire_max;
    }

    public ArrayList<Interventions> getLI() {
        return LI;
    }

    public void setLI(ArrayList<Interventions> lI) {
        LI = lI;
    }

    public static Clients etat_par_client(Object code_client) throws NumberFormatException {

        double etat_par_client;

        double MontantRegulier=0;
        double MontantDeplacement=0;
        double MontantHeuresSup=0;

        double Nombre_Heures=0;
        double Distance_Deplacement=0;
        double HeuresSup = 0;


        for(int i = 0; i < LI.size(); i++) {
            if(LI.get(i).code_client.equals(code_client) == true) {
                Nombre_Heures += (long)(LI.get(i).getNombre_heures());
                Distance_Deplacement += (long)LI.get(i).distance_deplacement;
                if((long)LI.get(i).overtime != 0) {
                    HeuresSup += 2;
                }
                HeuresSup += (long)LI.get(i).overtime;
            }
        }

        if(Integer.parseInt(type_employe)==0) {
            MontantRegulier = Nombre_Heures*Integer.parseInt(taux_horaire_min);
            MontantDeplacement = 200-(5*Distance_Deplacement*MontantRegulier)/100;
            MontantHeuresSup = 0;
        }

        else if(Integer.parseInt(type_employe)==1) {
            MontantRegulier = Nombre_Heures*(Integer.parseInt(taux_horaire_min)+Integer.parseInt(taux_horaire_max))/2;
            MontantDeplacement = 200-(10*Distance_Deplacement*MontantRegulier)/100;

            if(Nombre_Heures <= 4) {
                MontantHeuresSup = 0;
            }

            else if(Nombre_Heures > 4 && Nombre_Heures <= 8) {
                MontantHeuresSup = 50*HeuresSup;
            }

            else if(Nombre_Heures > 8) {
                MontantHeuresSup = 100*HeuresSup;
            }
        }

        else if(Integer.parseInt(type_employe)==2) {
            MontantRegulier = Nombre_Heures* Double.parseDouble(taux_horaire_max);

            MontantDeplacement = 200 - (15*Distance_Deplacement*MontantRegulier)/100;

            if(HeuresSup <= 4) {
                MontantHeuresSup = 75*HeuresSup;
            }

            else if(HeuresSup > 4) {
                if(150*HeuresSup <= 1500) {
                    MontantHeuresSup = 150*HeuresSup;
                }
                else {
                    MontantHeuresSup = 1500;

                }
            }

        }

        etat_par_client = MontantRegulier+ MontantDeplacement + MontantHeuresSup;

        Clients EPC = new Clients(code_client , etat_par_client);

        return EPC;

    }

    public static double CalculEtatCompte(Employe employe) {

        double etat_compte = 0;

        int s =  LI.size();
        int s1 =  LI.size();

        System.out.println(LI.toString());

        for(int i = 0; i < s; i++) {

            Clients EPC = etat_par_client(LI.get(i).code_client);
            etat_compte += (double)EPC.getEtat_par_client();

            String y = (String)LI.get(i).code_client;
            for(int j = i; j < s1; j++) {

                String x = (String)LI.get(j).code_client;

                if(((String)LI.get(j).code_client).equals(y) ==true ) {
                    LI.removeAll(Collections.singleton(LI.get(j)));
                    j--;
                }
                s1=LI.size();
            }
            s= LI.size();
            i--;

        }
        etat_compte +=  733.77;
        return etat_compte;
    }


    public double Calculcout_fixe(Employe employe) {
        double cout_fixe=0;
        cout_fixe = (1.2/100)*CalculEtatCompte(employe);
        return cout_fixe;
    }

    public double Calculcout_variable(Employe employe) {
        double cout_variable=0;
        cout_variable = (2.5/100)*CalculEtatCompte(employe);
        return cout_variable;
    }

    @Override
    public String toString() {
        return "Employe " + "\n" + "matricule_employe= " + matricule_employe + "\n"+
                "type_employe= " + type_employe + "\n" +
                "taux_horaire_min= " + taux_horaire_min + "\n" +
                "taux_horaire_max= " + taux_horaire_max + "\n" +
                "matricule_employe= " + matricule_employe + "\n"+
                "LI " + "\n" +  LI;
    }


}