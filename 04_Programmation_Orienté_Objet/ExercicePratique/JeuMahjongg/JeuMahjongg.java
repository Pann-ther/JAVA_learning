import java.util.ArrayList;
import java.util.Random;

public class JeuMahjongg {
    // Attribut du jeu du Mahjong
    protected static Random random = new Random(); // Pour le tirage aléatoire des tuiles
    protected static ArrayList<Tuile> tuiles; // Pour stocker les 144 tuiles apres l'initialisation de JeuMahjongg

    // Constructeur
    public JeuMahjongg() {
        tuiles = new ArrayList<Tuile>();
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

    public static ArrayList<Tuile> getTuiles() {
        return tuiles;
    }

    // Permet de tirer une tuile aleatoirement et de la retirer de l'ensemble
    public Tuile tirerTuile() {
        int index = random.nextInt(tuiles.size());
        Tuile tuile = tuiles.get(index);
        tuiles.remove(tuile);
        return tuile;
    }

    // Verifie combien y'a t'ils de tuiles restantes en jeu
    public int tuilesRestantes(){
        return tuiles.size();
    }

    // Verifie si le plateau de tuiles est vide
    public boolean estVide(){
        if(tuiles.isEmpty()){
            return true;
        }
        return false;
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
