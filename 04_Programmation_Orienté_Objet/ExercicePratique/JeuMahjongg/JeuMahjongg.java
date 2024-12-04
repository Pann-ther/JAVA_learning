import java.util.ArrayList;
import java.util.Random;

public class JeuMahjongg {
    // Attribut du jeu du Mahjong
    // Attributs en final car ce sont des caracteristiques sont immuables
    private final String[] categorie = { "C", "B", "K", "S", "N", "O", "E", "V", "R", "W", "F", "P" };
    private final int[] numero = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private Random random; // Pour le tirage aléatoire des tuiles
    private ArrayList<Tuile> tuiles; // Pour stocker les 144 tuiles apres l'initialisation de JeuMahjongg

    // Constructeur
    public JeuMahjongg() {
        tuiles = new ArrayList<Tuile>();
        random = new Random();

        // boucle pour initialiser automatiquement les 144 tuiles
        for (int i = 0; i < categorie.length; i++) {
            if (i < 3) {
                for (int j = 0; j < numero.length; j++) {
                    for (int k = 0; k < 4; k++) {
                        tuiles.add(new Tuile(categorie[i], j + 1));
                    }
                }
            } else {
                for (int k = 0; k < 4; k++) {
                    tuiles.add(new Tuile(categorie[i], 1));
                }
            }
        }
    }

    // Permet le tirage de deux tuiles et verifie si elles sont identiques pour valider le tirage et les retirer du jeu
    public void tirageTuiles() {
        int index1 = random.nextInt(tuiles.size());
        Tuile tuile1 = tuiles.get(index1);
        System.out.println("Tuile tiré: " + tuiles.get(index1).toString());
        int index2 = random.nextInt(tuiles.size());
        Tuile tuile2 = tuiles.get(index2);
        System.out.println("Tuile tiré: " + tuiles.get(index2).toString());
        
        if (tuile1.estEgale(tuile2)) {
            System.out.println("Les deux tuiles " + tuile1.toString() + " sont identiques, les deux tuiles ont été retiré");
            System.out.println("Tuiles restantes: " + tuiles.size());
            tuiles.remove(index1);
            tuiles.remove(index2);
        } else {
            System.out.println("Les deux tuiles ne sont pas identique, elles ne peuvent pas etre retirées");
        }
        if (tuiles.isEmpty()) {
            System.out.println("Toutes les paires ont été retirées. Bravo, vous avez gagné !");
        }
    }

    public String toString(){
        String liste ="";
        int compteur = 0;
        for(Tuile tuile : tuiles){
            liste += tuile.toString()+" ";
            compteur ++;
            if(compteur % 12 == 0){
                liste += "\n" ;
            }
        }
        return liste;
    }
}
