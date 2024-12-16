import java.util.ArrayList;

public class EspaceDeJeu {
    // Attribut de l'espace de jeu
    private int lignes;
    private int colonnes;
    private int hauteur;
    ArrayList<Tuile>[][] espaceDeJeu; // Tableau en 3 dimensions avec une imbrication des ArrayList

    // Constructeur
    @SuppressWarnings("unchecked")
    public EspaceDeJeu(int lignes, int colonnes, int hauteur) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.hauteur = hauteur;

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
                    espaceDeJeu[i][j].add(null);
                }
            }
        }
    }

    // Place les tuiles aleatoirement dans l'espace de jeu
    public void placementTuiles(int[][] dispositions, ArrayList<Tuile> tuiles) throws Exception {
        if (tuiles.size() != dispositions.length) {
            throw new Exception("Le nombre de tuiles n'est pas egale au nombre de coordonées des tuiles");
        }

        for (int i = 0; i < dispositions.length; i++) {
            Tuile tuileSelectionnee = JeuMahjongg.tirerTuile();
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

    // Retire les tuiles du plateau si elles sont identiques en etant d'instances
    // differentes
    public void tirerTuiles(Tuile t1, Tuile t2) {
        if (t1 != t2 && t1.estEgale(t2)) {
            int[] coord = trouverCoordonnees(t1, t2);

            if (coord != null && coord != null) {
                espaceDeJeu[coord[0]][coord[1]].set(coord[2], null);
                espaceDeJeu[coord[3]][coord[4]].set(coord[5], null);
            }
        }
    }

    // Cherche les tuiles dans l'espace de jeu et, si elles sont trouvées, renvoie
    // leurs coordonnées dans un tableau
    public int[] trouverCoordonnees(Tuile t1, Tuile t2) {
        int[] coord = new int[6];
        for (int i = 0; i < coord.length; i++) {
            coord[i] = -1;
        }

        for (int i = 0; i < espaceDeJeu.length; i++) {
            for (int j = 0; j < espaceDeJeu[i].length; j++) {
                for (int k = espaceDeJeu[i][j].size() - 1; k >= 0; k--) {
                    Tuile tuileActuelle = espaceDeJeu[i][j].get(k);
                    if (tuileActuelle != null) {
                        if (tuileActuelle.estEgale(t1) && coord[0] == -1) {
                            coord[0] = i;
                            coord[1] = j;
                            coord[2] = k;
                            break;
                        } else if (tuileActuelle.estEgale(t2) && coord[0] != -1) {
                            coord[3] = i;
                            coord[4] = j;
                            coord[5] = k;
                            return coord;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return null;
    }

    // Affiche le positionnement de toutes les tuiles dans l'espace de jeu
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
                } else if (j > 3 && j < 5) {
                    ret.append(j).append("   ");
                } else if (j == 7) {
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
                            if (j == 0) {
                                ret.append("    ");
                                break;
                            } else if (j > 0 && j < 5) {
                                ret.append("   ");
                                break;
                            } else if (j == 5) {
                                ret.append("   ");
                                break;
                            } else if (j == 6) {
                                ret.append("    ");
                                break;
                            } else if (j == 7) {
                                ret.append("   ");
                                break;
                            } else if (j > 7 && j < 12) {
                                ret.append("   ");
                                break;
                            } else if (j == 12) {
                                ret.append("    ");
                                break;
                            }
                        }
                    } else { // adapte les <> en fonction de la position de la tuile sur l'espace de jeu
                        if (j == 0) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k)).append(">");
                            break;
                        } else if (j > 0 && j < 5) {
                            ret.append(espaceDeJeu[i][j].get(k)).append(">");
                            break;
                        } else if (j == 5) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k));
                            break;
                        } else if (j == 6) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k)).append(">");
                            break;
                        } else if (j == 7) {
                            ret.append(espaceDeJeu[i][j].get(k)).append(">");
                            break;
                        } else if (j > 7 && j < 12) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k));
                            break;
                        } else if (j == 12) {
                            ret.append("<").append(espaceDeJeu[i][j].get(k)).append(">");
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
