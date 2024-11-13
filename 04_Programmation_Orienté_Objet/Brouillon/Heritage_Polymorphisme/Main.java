public class Main {
    public static void main(String[]args){

        // Creation et initialisation des objets de la classe voiture avec constructeurs
        Voiture clio = new Voiture("clio",110);
        Voiture audi = new Voiture("audi",190);
        Voiture porsche = new Voiture("porsche",230);

        // Creation et initialisation des objets de la classe moto avec constructeurs
        Moto mt07 = new Moto("mt07",130);
        Moto cb650r = new Moto("cb650r", 200);
        Moto panigale = new Moto("panigale",250);

        // Creation d'un tableau de type vehicule
        Vehicule[] parking = new Vehicule[6];

        // Initialisation du tableau avec les objets de types Vehicule
        parking[0]= clio;
        parking[1]= audi;
        parking[2]= porsche;
        parking[3]= mt07;
        parking[4]= cb650r;
        parking[5]= panigale;
        
        // Boucle for each pour afficher la vitesse de chaque vehicule du parking
        for(Vehicule vehicule : parking){
            vehicule.afficherVitesse();
        }

        

    }
}
