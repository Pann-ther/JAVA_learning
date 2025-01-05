import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JeuMahjongg {
    // Attribut du jeu du Mahjong
    private Random random = new Random(); // Pour le tirage aléatoire des tuiles
    private ArrayList<Tuile> tuiles; // Pour stocker les 144 tuiles apres l'initialisation de JeuMahjongg

    // Constructeur
    public JeuMahjongg() {
        tuiles = new ArrayList<>();
        // boucle pour initialiser automatiquement les 144 tuiles
        for (int i = 0; i < Tuile.getCategoriesValides().length; i++) {
            if (i < 3) { // Categorie CERCLE, BAMBOU, CARACTERE
                for (int j = 1; j <= 9; j++) {
                    for (int k = 0; k < 4; k++) {
                        tuiles.add(new TuileNumerique(Tuile.getCategoriesValides()[i], j));
                    }
                }
            } else if (i < 4) { // Categorie VENT
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        tuiles.add(new TuileHonneur(Tuile.getCategoriesValides()[i], Tuile.getDessinsValides()[j]));
                    }
                }
            } else if (i < 5) { // Categorie DRAGON
                for (int j = 4; j < 7; j++) {
                    for (int k = 0; k < 4; k++) {
                        tuiles.add(new TuileHonneur(Tuile.getCategoriesValides()[i], Tuile.getDessinsValides()[j]));
                    }
                } 
            } else if (i< 6) { // Categorie FLEUR
                for (int j = 7; j < 11; j++) {
                    tuiles.add(new TuileBonus(Tuile.getCategoriesValides()[i], Tuile.getDessinsValides()[j]));
                }
            } else { // Categorie SAISON
                for (int j = 11; j < Tuile.getDessinsValides().length; j++) {
                    tuiles.add(new TuileBonus(Tuile.getCategoriesValides()[i], Tuile.getDessinsValides()[j]));
                }
            }
        }
    }

    // Permet de tirer une tuile aleatoirement et de la retirer de l'ensemble
    public Tuile tirerTuile() {
        int index = random.nextInt(tuiles.size());
        Tuile tuile = tuiles.get(index);
        tuiles.remove(tuile);
        return tuile;
    }

    // Renvoie la taille de l'ensemble
    public int size() {
        return tuiles.size();
    }

    // Verifie combien y'a t'ils de tuiles restantes en dans l'ensemble
    public int tuilesRestantes() {
        return tuiles.size();
    }

    // Verifie si l'ensemble de tuiles est vide
    public boolean estVide() {
        if (tuiles.isEmpty()) {
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
