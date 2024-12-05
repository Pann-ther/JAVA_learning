import java.util.ArrayList;
import java.util.Random;

public class JeuMahjongg {
    // Attribut du jeu du Mahjong
    private Random random; // Pour le tirage aléatoire des tuiles
    private ArrayList<Tuile> tuiles; // Pour stocker les 144 tuiles apres l'initialisation de JeuMahjongg

    // Constructeur
    public JeuMahjongg() {
        tuiles = new ArrayList<Tuile>();
        random = new Random();

        // boucle pour initialiser automatiquement les 144 tuiles
        for (int i = 0; i < Tuile.getCategoriesValides().length; i++) {
            if (i < 3) {
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < 4; k++) {
                        tuiles.add(new Tuile(Tuile.getCategoriesValides()[i], j + 1));
                    }
                }
            } else {
                for (int k = 0; k < 4; k++) {
                    tuiles.add(new Tuile(Tuile.getCategoriesValides()[i], 1));
                }
            }
        }
    }

    // Permet de tirer une tuile aleatoirement et de la retirer de l'ensemble
    public String tirerTuile() {
        int index = random.nextInt(tuiles.size());
        Tuile tuile = tuiles.get(index);
        tuiles.remove(tuile);
        return "Tuile tirée: " + tuile.toString();
    }

    // Verifie combien y'a t'ils de tuiles restantes en jeu
    public String tuilesRestantes(){
        int nbTuiles = tuiles.size();
        return "Tuiles restantes: "+nbTuiles;
    }

    // Verifie si le plateau de tuiles est vide
    public boolean estVide(){
        if(tuiles.isEmpty()){
            return true;
        }
        return false;
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
            System.out.println(
                    "Les deux tuiles " + tuile1.toString() + " sont identiques, les deux tuiles ont été retiré");
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

    // Affiche les pieces disponibles a la pioche
    public String toString() {
        String liste = "";
        int compteur = 0;
        for (Tuile tuile : tuiles) {
            liste += tuile.toString() + " ";
            compteur++;
            if (compteur % 12 == 0) {
                liste += "\n";
            }
        }
        return liste;
    }
}
