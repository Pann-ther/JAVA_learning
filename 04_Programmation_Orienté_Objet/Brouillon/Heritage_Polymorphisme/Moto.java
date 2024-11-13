public class Moto extends Vehicule{

    // Heritage du constructeur de la classe vehicule
    public Moto (String modele, double vitesse){
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
        if(vitesse >=0){
            super.setVitesse(vitesse);
        } else {
            System.out.println("La vitesse de la moto ne peut etre negative");
        }

    }
    
}
