import java.util.ArrayList;
import java.util.Random;

public class JeuMahjongg {
    // Attribut du jeu du Mahjong
    private Random random = new Random(); // Pour le tirage aléatoire des tuiles
    private ArrayList<Tuile> tuiles; // Pour stocker les 144 tuiles apres l'initialisation de JeuMahjongg

    // Constructeur
    public JeuMahjongg() {
        tuiles = new ArrayList<>();
        initialiserTuiles();
    }

    //initialise les 144 tuiles
    public void initialiserTuiles(){
        // Tuiles numériques
        for(String numerique : TuileNumerique.getCategoriesValides()){
            for(int i=1; i<=9; i++){
                for(int j=0; j<4; j++){
                    tuiles.add(new TuileNumerique(numerique, i));
                }
            }
        }

        // Tuiles Honneurs
        for(String dessin : TuileHonneur.getDessinsValides()){
            if (dessin.equals("EST") || dessin.equals("OUEST") || dessin.equals("NORD") || dessin.equals("SUD")) {
               for(int i=0; i<4; i++){
                    tuiles.add(new TuileHonneur("VENT", dessin));
                } 
            } else {
                for(int i=0; i<4; i++){
                    tuiles.add(new TuileHonneur("DRAGON", dessin));
                }
            }
        }

        // Tuiles Bonus
        for(String dessin:TuileBonus.getDessinsValides()){
            if(dessin.equals("PRUNIER") || dessin.equals("ORCHIDEE") || dessin.equals("CHRYSANTHEME") || dessin.equals("BAMBOU")){
                tuiles.add(new TuileBonus("FLEUR", dessin));
            } else {
                tuiles.add(new TuileBonus("SAISON", dessin));
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
