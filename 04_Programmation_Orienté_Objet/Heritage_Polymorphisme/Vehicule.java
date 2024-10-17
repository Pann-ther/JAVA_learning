public class Vehicule {

    // Declaration des attribus de la classe vehicule
    private double vitesse;
    private String modele;

    // Constructeur
    public Vehicule(String modele, double vitesse) {
        this.modele = modele;
        setVitesse(vitesse);
    }


    // Methode pour afficher la vitesse du vehicule
    public void afficherVitesse() {
        System.out.println("La vitesse de la "+getModele()+" est de " + getVitesse() + "km/h");
    }


    // Getter pour la vitesse
    public double getVitesse(){
        return vitesse;
    }

    // Getter pour le modele
    public String getModele(){
        return modele;
    }

    // Setter pour la vitesse avec une condition a l'initialisation
    public void setVitesse (double vitesse){
        if(vitesse >= 0){
            this.vitesse = vitesse;
        }else{
            System.out.println("La vitesse du vehicule ne peut etre negative");
        }
    }

    // Setter pour le modele
    public void setModele(String modele){
        this.modele = modele;
    }

}
