import java.util.ArrayList;

public class EspaceDeJeu {
    // Attribut de l'espace de jeu
    private int lignes;
    private int colonnes;
    private int hauteur;
    private ArrayList<Tuile>[][] espaceDeJeu; // Tableau en 2 dimensions contenant des listes (piles) de tuiles

    // Constructeur
    @SuppressWarnings("unchecked")
    public EspaceDeJeu(int lignes, int colonnes, int hauteur) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.hauteur = hauteur;

        // Création d'un tableau de listes pour représenter les piles dans l'espace de jeu
        espaceDeJeu = (ArrayList<Tuile>[][]) new ArrayList[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                espaceDeJeu[i][j] = new ArrayList<>();// creation des piles
            }
        }

        // initialise les cases de l'espace de jeu
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                for (int k = 0; k < hauteur; k++) {
                    espaceDeJeu[i][j].add(null); // permet de laisser "des cases vides pleines"et de les representer graphiquement
                }
            }
        }
    }

    // Place les tuiles dans l'espace de jeu selon les coordonnées données
    public void placementTuiles(int[][] dispositions, ArrayList<Tuile> tuiles) throws Exception {
        if (tuiles.size() != dispositions.length) {
            throw new Exception("Le nombre de tuiles n'est pas egale au nombre de coordonées des tuiles");
        }

        for (int i = 0; i < dispositions.length; i++) {
            Tuile tuileSelectionnee = JeuMahjongg.tirerTuile(); // Sélection d'une tuile aléatoire
            int[] coordonnees = dispositions[i];
            tuileSelectionnee.setCoordonnees(coordonnees); // Attribut à la tuile ses coordonnées
            int ligne = dispositions[i][0];
            int colonne = dispositions[i][1];
            int pile = dispositions[i][2];

            if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
                espaceDeJeu[ligne][colonne].set(pile, tuileSelectionnee);
                tuiles.remove(tuileSelectionnee); // retire la tuile
            } else {
                throw new Exception("Les coordonnées de la tuile sont en dehors des limites de l'espace de jeu");
            }
        }
    }

    // Supprime deux tuiles identiques du plateau si elles sont sélectionnables et différentes instances
    public boolean tirerTuiles(Tuile t1, Tuile t2) {
        if (t1.estEgale(t2)) {
            ArrayList<Tuile> tuile = trouveTuile(t1, t2);
            t1 = tuile.get(0);
            t2 = tuile.get(1);

            if (estSelectionnable(t1) && estSelectionnable(t2)) {
                int[] coord1 = t1.getCoordonnees();
                int[] coord2 = t2.getCoordonnees();
                espaceDeJeu[coord1[0]][coord1[1]].set(coord1[2], null);
                espaceDeJeu[coord2[0]][coord2[1]].set(coord2[2], null);
                return true;
            }
        }
        return false; 
    }
    
    // Permet de rechercher les coordonnées des tuiles et de les affecter à celles crées dans la methode main pour imiter la selection de l'utilisateur sur le plateau de jeu
    public ArrayList<Tuile> trouveTuile(Tuile t1, Tuile t2){
        boolean t1trouve = false;
        boolean t2trouve = false;

        for (int i = 0; i < espaceDeJeu.length; i++) {
            for (int j = 0; j < espaceDeJeu[i].length; j++) {
                for (int k = espaceDeJeu[i][j].size() - 1; k >= 0; k--) {
                    Tuile tuileActuelle = espaceDeJeu[i][j].get(k);
                    if (tuileActuelle != null) {
                        if (t1.getCategorie() == tuileActuelle.getCategorie() && !t1trouve) {
                            if (t1.getNumero() == tuileActuelle.getNumero()) {
                                t1 = tuileActuelle;
                                t1trouve = true;
                                break;
                            }
                        } else if (t2.getCategorie() == tuileActuelle.getCategorie() && !t2trouve) {
                            if (t2.getNumero() == tuileActuelle.getNumero()) {
                                System.out.println();
                                t2 = tuileActuelle;
                                t2trouve = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        // Retourne les tuiles entrées en parametres trouvés dans le plateau de jeu
        ArrayList<Tuile> tab = new ArrayList<>();
        tab.add(t1);
        tab.add(t2);
        return tab;
    }

    // Vérifie si une tuile est sélectionnable : aucune tuile au-dessus ou sur les côtés à la même hauteur
    public boolean estSelectionnable(Tuile tuile) {
        int[] coordonnees = tuile.getCoordonnees();
        int ligne = coordonnees[0];
        int colonne = coordonnees[1];
        int hauteur = coordonnees[2];

        // Verfie si une tuile est au-dessus
        if (hauteur < espaceDeJeu[ligne][colonne].size() - 1) {
            if (espaceDeJeu[ligne][colonne].get(hauteur + 1) != null) {
                return false;
            }
        }

        // Verifie si il y a des tuiles sur les cotés à la même hauteur
        if ((colonne > 0 && espaceDeJeu[ligne][colonne - 1].size() >= hauteur
            && espaceDeJeu[ligne][colonne - 1].get(hauteur) != null)
            && (colonne > colonne - 1 && espaceDeJeu[ligne][colonne + 1].size() >= hauteur
            && espaceDeJeu[ligne][colonne + 1].get(hauteur) != null)) {
            return false;
        }
        return true;
    }

    // Affiche le plateau de jeu avec la profondeur et les coordonnées
    public String debugger() {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < espaceDeJeu.length; i++) {
            ret.append("Ligne ").append(i).append("\n");
            for (int j = 0; j < espaceDeJeu[i].length; j++) {
                ret.append("  ").append("Colonne ").append(j).append("\n");
                for (int k = 0; k < espaceDeJeu[i][j].size(); k++) {
                    if (k == 0) {
                        ret.append("    ").append("p").append(k).append(" ").append(espaceDeJeu[i][j].get(k))
                                .append(" | ");
                    } else {
                        ret.append("p").append(k).append(" ").append(espaceDeJeu[i][j].get(k)).append(" | ");
                    }
                }
                ret.append("\n");
            }
        }
        return ret.toString();
    }

    // Affiche l'espace de jeu vu par le joueur en affichant la premiere tuile
    // presente dans la pile
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("   "); // alignement
        // Numéros des colonnes
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < espaceDeJeu[i].length; j++) {
                if (j >= 10) {
                    ret.append(j).append(" ");
                } else if ((j > 3 && j < 5) || (j == 7)){
                    ret.append(j).append("   ");
                } else {
                    ret.append(j).append("  ");
                }
            }
            ret.append("\n");
        }

        for (int i = 0; i < espaceDeJeu.length; i++) {
            ret.append(i).append(" "); // Numéros de lignes
            for (int j = 0; j < espaceDeJeu[i].length; j++) {
                for (int k = espaceDeJeu[i][j].size() - 1; k >= 0; k--) {
                    Tuile tuileActuelle = espaceDeJeu[i][j].get(k);
                    if (tuileActuelle == null) {
                        if (espaceDeJeu[i][j].get(0) == null) { // adapte la taille des cases vides sur l'espace de jeu
                            if ((j == 0) || (j == 6)||(j == 12)){
                                ret.append("    ");
                                break;
                            } else if ((j == 5)||(j > 0 && j <= 5) || (j >= 7 && j < 12)) {
                                ret.append("   ");
                                break;
                            }
                        }
                    } else { // adapte les <> en fonction de la position de la tuile sur l'espace de jeu
                        if ((j == 0) || (j == 6) || (j == 12)) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k)).append(">");
                            break;
                        } else if ((j > 0 && j < 5) || (j == 7)) {
                            ret.append(espaceDeJeu[i][j].get(k)).append(">");
                            break;
                        } else if ((j == 5) || (j > 7 && j < 12)) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k));
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
