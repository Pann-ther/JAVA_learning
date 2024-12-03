import java.util.ArrayList;
public class Elevage {
    private ArrayList<Volaille> elevage;
    private ArrayList<Poulet> abattoirPoulet;
    private ArrayList<Canard> abattoirCanard;

    public Elevage() {
        elevage = new ArrayList<Volaille>();
        abattoirPoulet = new ArrayList<Poulet>();
        abattoirCanard = new ArrayList<Canard>();
    }


    public ArrayList<Volaille> getElevage() {
        return elevage;
    }

    public ArrayList<Poulet> getAbattoirPoulet() {
        return abattoirPoulet;
    }

    public ArrayList<Canard> getAbattoirCanard() {
        return abattoirCanard;
    }
    

    public void ajouterVolaille(Volaille volaille)throws EntreeInvalide{
		if(!elevage.contains(volaille)){
			elevage.add(volaille);
		} else {
			throw new EntreeInvalide("Erreur: "+volaille.getType()+" avec l'id "+volaille.getId()+" est déjà present dans l'élevage");
		}
	}

    public void supprimerVolaille(Volaille volaille)throws EntreeInvalide{
		if(elevage.contains(volaille)){
			elevage.remove(volaille);
		} else {
			throw new EntreeInvalide("Erreur: cette volaille n'est pas present dans l'elevage");
		}
	}

    public void verifierPoids() {
        for (Volaille v : elevage) {
            if (v.getType().equalsIgnoreCase("Canard")) {
                if (v.getPoids() >= Canard.poidsAbattage) {
                    elevage.remove(v);
                    abattoirCanard.add((Canard)v);
                }
            }
            if (v.getType().equalsIgnoreCase("Poulet")) {
                if (v.getPoids() >= Poulet.poidsAbattage) {
                    elevage.remove(v);
                    abattoirPoulet.add((Poulet)v);
                }
            }
        }

        System.out.println("Après la mise a jour des poids voici la liste des volailles parti à l'abattoir");
        System.out.println("Abattoir des poulets");
        afficherAbattoir(abattoirPoulet);
        System.out.println("Abattoir des canards");
        afficherAbattoir(abattoirCanard);
    }

    public void afficherAbattoir(ArrayList<? extends Volaille> abattoir) {
        for (Volaille element : abattoir) {
            System.out.println(element.toString());
        }
    }

    public double calculerValeurAbattoir() {
        double CA = 0;
        for (Poulet p : abattoirPoulet) {
            CA += (p.getPoids() * Poulet.prixKilo);
        }
        for (Canard c : abattoirCanard) {
            CA += (c.getPoids() * Canard.prixKilo);
        }
        return CA;
    }

    public String toString(){
        String liste = "";
        for(Volaille v : elevage){
            liste += v.toString()+"\n";
        }
        return liste;
    }

}