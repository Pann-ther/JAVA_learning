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
    public Tuile tirerTuile() {
        int index = random.nextInt(tuiles.size());
        Tuile tuile = tuiles.get(index);
        tuiles.remove(tuile);
        return tuile;
    }

    // Tire aleatoire une tuile de l'ensemble
    public Tuile tirageAleatoire() {
        int index = random.nextInt(tuiles.size());
        return tuiles.get(index);
    }

    // Supprime une tuile
    public void supprimer(Tuile t){
        tuiles.remove(t);
    }

    // Renvoie la taille de l'ensemble
    public int size(){
        return tuiles.size();
    } 

    // Renvoie la tuile à l'index donné
    public Tuile get(int index){
        return tuiles.get(index);
    }
    // Melange les tuiles
    public void melangerTuiles() {
        Collections.shuffle(tuiles); // Mélange les tuiles de manière aléatoire
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
