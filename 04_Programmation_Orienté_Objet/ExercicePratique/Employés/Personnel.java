import java.util.ArrayList;

public class Personnel {
    private ArrayList<Employés> liste;

    public Personnel() {
        liste = new ArrayList<Employés>();
    }

    public void ajouterEmploye(Employés employe) {
        if (!liste.contains(employe)) {
            liste.add(employe);
        }

    }

    public void supprimerEmploye(Employés employe) throws Exception {
        if (liste.contains(employe)) {
            liste.remove(employe);
        } else {
            throw new Exception("Erreur: cette personne ne fait pas parti du personnel");
        }
    }

    public String salairePersonnel() {
        double salaireTotal = 0;
        for (Employés employe : liste) {
            salaireTotal += employe.getSalaire();
        }
        return "Le salaire de l'ensemble du personel s'eleve à " + salaireTotal + "€";
    }

    public String toString() {
        String ret = "";
        for (Employés employe : liste) {
            ret += employe.toString() + "\n";
        }
        return ret;
    }
}