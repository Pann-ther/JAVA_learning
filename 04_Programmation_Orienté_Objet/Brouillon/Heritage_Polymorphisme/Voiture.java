public class Voiture extends Vehicule {
    
    // Heritage du constructeur de la classe vehicule
    public Voiture(String modele, double vitesse){
        super(modele, vitesse);
    }

    // Override de la methode 
    @Override
    public void afficherVitesse(){
        System.out.println("La vitesse de la "+getModele()+" est de "+ getVitesse()+"km/h");
    }

    // Override de la methode 
    @Override
    public void setVitesse(double vitesse){
        if(vitesse >= 0){
            super.setVitesse(vitesse);
        } else {
            System.out.println("La vitesse de la voiture ne peut etre negative");
        }
    }
}
