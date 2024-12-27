import java.util.ArrayList;

public class Plateau {
    private int lignes;
    private int colonnes;
    private ArrayList<Tuile>[][] plateau;
    private JeuMahjongg ensembleTuiles;

    @SuppressWarnings("unchecked")
    public Plateau(int lignes, int colonnes, int[][] disposition, JeuMahjongg ensembleTuiles) throws Exception {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.ensembleTuiles = ensembleTuiles;

        plateau = new ArrayList[lignes][colonnes]; // initialisation du tableau

        // Initialise chaque cases avec un ArrayList pour representer les piles de tuiles
        for (int l = 0; l < plateau.length; l++) {
            for (int c = 0; c < plateau[l].length; c++) {
                plateau[l][c] = new ArrayList<>();
            }
        }
        ensembleTuiles.melangerTuiles(); // Melange les tuiles de l'ensemble avant des les placer dans le plateau
        initialiserPlateau(disposition, ensembleTuiles); // Initialise le tableau en placant les tuiles aleatoirement choisis au coordonnées indiqués
    }

    public void initialiserPlateau(int[][] disposition, JeuMahjongg ensembleTuiles) throws Exception {
        if (ensembleTuiles.size() != disposition.length) {
            throw new Exception("Le nombre de coordonées ne corresponds pas au nombre de tuiles");
        }

        for (int i = 0; i < ensembleTuiles.size(); i++) {
            Tuile tuiletiree = ensembleTuiles.get(i);
            tuiletiree.setCoordonnees(disposition[i]);
            int ligne = disposition[i][0];
            int colonne = disposition[i][1];
            if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
                plateau[ligne][colonne].add(tuiletiree);
            } else {
                throw new Exception("Les coordonées de la tuile sont hors de l'espace de jeu");
            }
        }
    }

    // Retire les tuiles de l'ensemble et du plateau de jeu uniquement si 2 tuiles ont le meme dessin et sont d'instances différentes
    public boolean tirerTuiles() {
        // Entrées de l'utilisateur
        
        Tuile tuile1Str ;
        int[] coordTuile1Str;
        Tuile tuile2Str;
        int[] coordTuile2Str ;
        do{
             tuile1Str = choixTuile("première");
             coordTuile1Str = coordTuile("première");
             tuile2Str = choixTuile("deuxième");
             coordTuile2Str = coordTuile("deuxième");
        } while (tuile1Str == null && tuile2Str == null);
        
        // Récupération des tuiles sélectionnées à partir du plateau de jeu
        Tuile t1 = tuilePlateau(coordTuile1Str, tuile1Str);
        Tuile t2 = tuilePlateau(coordTuile2Str, tuile2Str);

        if (t1.estEgale(t2)) {
            if (estSelectionnable(t1) && estSelectionnable(t2)) {

                // Retirer les tuiles du plateau
                plateau[coordTuile1Str[0]][coordTuile1Str[1]].remove(t1);
                plateau[coordTuile2Str[0]][coordTuile2Str[1]].remove(t2);

                // Retirer les tuiles de l'ensemble
                ensembleTuiles.supprimer(t1);
                ensembleTuiles.supprimer(t2);
                return true;
            }
        }
        return false;
    }

    // Recupere la tuile choisi par l'utilisateur dans le plateau
    public Tuile tuilePlateau(int[] coordTuile, Tuile tuile) {
        Tuile tuileSelectionnee = null;
        for (int i = plateau[coordTuile[0]][coordTuile[1]].size() - 1; i >= 0; i--) {
            Tuile tuileActuelle = plateau[coordTuile[0]][coordTuile[1]].get(i);
            if (tuileActuelle.toString().equals(tuile.toString())) {
                tuileSelectionnee = tuileActuelle;
            }
        }
        return tuileSelectionnee;
    }

    // Demande à l'utilisateur de choisir une tuile
    public Tuile choixTuile(String msg) {
        String tuileStr = LectureEntrée.lireString("Entrez la " + msg + " tuile selectionné: ");
        String categorie = tuileStr.substring(0, 1);
        int numero = Integer.parseInt(tuileStr.substring(1));
        Tuile tuile = new Tuile(categorie, numero);
        return tuile;
    }

    // Demande à l'utilisateur de rentrer les coordonnées de la tuile qu'il à choisi
    public int[] coordTuile(String msg) {
        int[] coord = new int[2];
        coord[0] = LectureEntrée.lireInt("Entrez la ligne où se situe la " + msg + " tuile selectionné: ");
        coord[1] = LectureEntrée.lireInt("Entrez la colonne où se situe la " + msg + " tuile selectionné: ");
        return coord;
    }

    // Verifie si les tuiles choisi peuvent etre joué et retirer du plateau
    public boolean estSelectionnable(Tuile t) {
        if (t == null) {
            return false;
        }
        int[] coord = t.getCoordonnees();
        int ligne = coord[0];
        int colonne = coord[1];
        int hauteur = coord[2];
        
        // Vérifie si la pile est vide ou si la tuile n'est pas au sommet de la pile
        if (plateau[ligne][colonne].isEmpty() || plateau[ligne][colonne].size() - 1 != hauteur) {
            return false;
        }
        
        // Vérifie la tuile est bloqué par d'autres tuiles à droite et à gauche sur la même hauteur
        if ((colonne > 0 && !plateau[ligne][colonne -1].isEmpty() && plateau[ligne][colonne - 1].size()-1 >= hauteur) &&
            (colonne < colonnes - 1 && !plateau[ligne][colonne + 1].isEmpty() && plateau[ligne][colonne + 1].size()-1 >= hauteur)) {
            return false; 
        }
        return true; // La tuile est sélectionnable
    }

    // Affiche les tuiles avec leur emplacement sur le plateau pour debugger
    public String debug() {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < plateau.length; i++) {
            ret.append("Ligne ").append(i).append("\n");
            for (int j = 0; j < plateau[i].length; j++) {
                ret.append("  ").append("Colonne ").append(j).append("\n");
                for (int k = 0; k < plateau[i][j].size(); k++) {
                    if (k == 0) {
                        ret.append("    ").append("p").append(k).append(" ").append(plateau[i][j].get(k)).append(" | ");
                    } else {
                        ret.append("p").append(k).append(" ").append(plateau[i][j].get(k)).append(" | ");
                    }
                }
                ret.append("\n");
            }
        }
        return ret.toString();
    }

    // Affiche le plateau de jeu (du point de vue utilisateur) avec uniqument les tuiles au sommet de chaque pile
    public String toString() {
        StringBuilder ret = new StringBuilder();

        // Numéro de colonne
        ret.append("   ");
        for (int i = 0; i < colonnes; i++) {
            if (i >= 10) {
                ret.append(i).append(" ");
            } else if ((i > 3 && i < 5) || (i == 7)) {
                ret.append(i).append("   ");
            } else {
                ret.append(i).append("  ");
            }
        }
        ret.append("\n");

        for (int i = 0; i < lignes; i++) {
            ret.append(i).append(" "); // Numéro de ligne
            for (int j = 0; j < colonnes; j++) {
                // Affichage des cases vides
                if (plateau[i][j].isEmpty()) {
                    if ((j == 0) || (j == 6) || (j == 12)) {
                        ret.append("    ");
                    } else if ((j == 5) || (j > 0 && j <= 5) || (j >= 7 && j < 12)) {
                        ret.append("   ");
                    }
                } else {
                    // Affichage des tuiles au sommet des piles
                    for (int k = plateau[i][j].size() - 1; k >= 0; k--) {
                        Tuile tuileActuelle = plateau[i][j].get(k);
                        if ((j == 0) || (j == 6) || (j == 12)) {
                            ret.append("<").append(tuileActuelle).append(">");
                            break;
                        } else if ((j > 0 && j < 5) || (j == 7)) {
                            ret.append(tuileActuelle).append(">");
                            break;
                        } else if ((j == 5) || (j > 7 && j < 12)) {
                            ret.append("<").append(tuileActuelle);
                            break;
                        }
                    }
                }
            }
            ret.append("\n");
        }
        return ret.toString();
    }
}