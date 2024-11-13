public class Voiture {

    // Attribut de la class Voiture
    private String marque;
    private String modele;
    private int annee;
    private int puissance;

    // Constructeur
    public Voiture (String marque, String modele, int annee, int puissance){
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.puissance = puissance;
    }

    public String getMarque(){
        return marque;
    }

    public void afficherCaracteristique(){
        System.out.println("Marque: "+ marque + ", Modele: "+ modele + ", Annee: "+ annee + ", puissance: "+ puissance +"ch");
    }
}




