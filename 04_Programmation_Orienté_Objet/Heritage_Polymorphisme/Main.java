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

        // Creation d'un tableau de type voiture
        Voiture[] parkingVoiture = new Voiture[3];

        // Initialisation du tableau avec les objets de la classe voiture
        parkingVoiture[0] = clio;
        parkingVoiture[1] = audi;
        parkingVoiture[2] = porsche;

        // Creation d'un tableau de type moto
        Moto[] parkingMoto = new Moto[3];

        // Initialisation du tableau avec les objets de la classe moto 
        parkingMoto[0] = mt07;
        parkingMoto[1]= cb650r;
        parkingMoto[2] = panigale;


        // boucle for-each pour afficher la vitesse de chaque vehicule dans les tableaux
        for(Moto moto : parkingMoto){
            moto.afficherVitesse();
        }

        for(Voiture voiture : parkingVoiture){
            voiture.afficherVitesse();
        }

    }
}
