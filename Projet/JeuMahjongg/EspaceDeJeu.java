import java.util.ArrayList;

public class EspaceDeJeu {
    // Attribut de l'espace de jeu
    private int lignes;
    private int colonnes;
    private int hauteur;
    private ArrayList<ArrayList<ArrayList<Tuile>>> espaceDeJeu; // Tableau en 3 dimensions avec une imbrication des ArrayList

    // Constructeur
    public EspaceDeJeu(int lignes, int colonnes, int hauteur) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.hauteur = hauteur;
        espaceDeJeu = new ArrayList<>();

        for (int i = 0; i < lignes; i++) {
            ArrayList<ArrayList<Tuile>> ligne = new ArrayList<>();
            for (int j = 0; j < colonnes; j++) {
                ArrayList<Tuile> colonne = new ArrayList<>();
                for (int k = 0; k < hauteur; k++) {
                    colonne.add(null); // initialise toutes les cases avec null
                }
                ligne.add(colonne);
            }
            espaceDeJeu.add(ligne);
        }
    }

    // Place les tuiles aleatoirement dans l'espace de jeu
    public void placementTuiles(int[][] dispositions, ArrayList<Tuile> tuiles) throws Exception {
        if (tuiles.size() != dispositions.length) {
            throw new Exception("Le nombre de tuiles n'est pas egale au nombre de coordonées des tuiles");
        }

        for (int i = 0; i < dispositions.length; i++) {
            int index = 0;

            index = JeuMahjongg.random.nextInt(tuiles.size());

            Tuile tuileSelectionnee = JeuMahjongg.tuiles.get(index);
            int ligne = dispositions[i][0];
            int colonne = dispositions[i][1];
            int pile = dispositions[i][2];
            if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes && pile >= 0 && pile < hauteur) {
                espaceDeJeu.get(ligne).get(colonne).set(pile, tuileSelectionnee);
                tuiles.remove(tuileSelectionnee);
            } else {
                throw new Exception("Les coordonnées de la tuile sont en dehors des limites de l'espace de jeu");
            }
        }
    }

    // Retire les tuiles du plateau si elles sont identiques en etant d'instances differentes
    public void tirerTuiles(Tuile t1, Tuile t2) {
        boolean occurence1 = false;
        int ligne1 = 0;
        int colonne1 = 0;
        int pile1 = 0;
        boolean occurence2 = false;
        int ligne2 = 0;
        int colonne2 = 0;
        int pile2 = 0;

        // Verifie si t1 et t2 sont differents objets et ont les mêmes attributs
        if (t1 != t2) {
            if (t1.getCategorie() == t2.getCategorie() && t1.getNumero() == t2.getNumero()) {
                for (int i = 0; i < espaceDeJeu.size(); i++) {
                    for (int j = 0; j < espaceDeJeu.get(i).size(); j++) {
                        for (int k = espaceDeJeu.get(i).get(j).size() - 1; k >= 0; k--) {
                            Tuile tuileActuelle = espaceDeJeu.get(i).get(j).get(k);

                            if (tuileActuelle != null) {
                                if (tuileActuelle.estEgale(t1)) {
                                    if (tuileActuelle.estEgale(t1) && !occurence1) {
                                        occurence1 = true;
                                        ligne1 = i;
                                        colonne1 = j;
                                        pile1 = k;
                                        break;
                                    }

                                    if (tuileActuelle.estEgale(t2) && !occurence2) {
                                        occurence2 = true;
                                        ligne2 = i;
                                        colonne2 = j;
                                        pile2 = k;
                                        break;
                                    }
                                } else {
                                    break;
                                }

                            }
                        }
                    }
                }

                // Verifie si la paire de tuile est presente en sommet de pile
                if (occurence1 && occurence2) {
                    System.out.println("Les deux tuiles ont été trouvées dans l'espace de jeu.");
                    espaceDeJeu.get(ligne1).get(colonne1).set(pile1, null);
                    espaceDeJeu.get(ligne2).get(colonne2).set(pile2, null);

                } else {
                    System.out.println("Les tuiles n'ont pas été trouvées ou sont en paire.");
                }
            } else {
                System.out.println("Les tuiles n'ont pas le même dessin.");
            }
        } else {
            System.out.println(t1 + " et " + t2 + " sont de la même instance.");
        }
    }

    // Affiche le positionnement de toutes les tuiles dans l'espace de jeu
    public String debugger() {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < espaceDeJeu.size(); i++) {
            ret.append("Ligne ").append(i).append("\n");
            for (int j = 0; j < espaceDeJeu.get(i).size(); j++) {
                ret.append("  ").append("Colonne ").append(j).append("\n");
                for (int k = 0; k < espaceDeJeu.get(i).get(j).size(); k++) {
                    if (k == 0) {
                        ret.append("    ").append("p").append(k).append(" ").append(espaceDeJeu.get(i).get(j).get(k))
                                .append(" | ");
                    } else {
                        ret.append("p").append(k).append(" ").append(espaceDeJeu.get(i).get(j).get(k)).append(" | ");
                    }
                }
                ret.append("\n");
            }
        }
        return ret.toString();
    }

    // Affiche l'espace de jeu vu par le joueur en affichant la premiere tuile presente dans la pile
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("   "); // alignement
        // Numéros des colonnes
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < espaceDeJeu.get(i).size(); j++) {
                if (j >= 10) {
                    ret.append(j).append(" ");
                } else if (j > 3 && j<5 ) {
                    ret.append(j).append("   ");
                }else if (j == 7) {
                    ret.append(j).append("   ");
                    
                }else {
                    ret.append(j).append("  ");
                }
            }
            ret.append("\n");
        }

        for (int i = 0; i < espaceDeJeu.size(); i++) {
            ret.append(i).append(" "); // Numéros de lignes
            for (int j = 0; j < espaceDeJeu.get(i).size(); j++) {
                for (int k = espaceDeJeu.get(i).get(j).size() - 1; k >= 0; k--) {
                    if (espaceDeJeu.get(i).get(j).get(k) == null) {
                        if (espaceDeJeu.get(i).get(j).get(0) == null) {
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
                    } else {
                        if (j == 0) {
                            ret.append("<").append(espaceDeJeu.get(i).get(j).get(k)).append(">");
                            break;
                        } else if (j > 0 && j < 5) {
                            ret.append(espaceDeJeu.get(i).get(j).get(k)).append(">");
                            break;
                        } else if (j == 5) {
                            ret.append("<").append(espaceDeJeu.get(i).get(j).get(k));
                            break;
                        } else if (j == 6) {
                            ret.append("<").append(espaceDeJeu.get(i).get(j).get(k)).append(">");
                            break;
                        } else if (j == 7) {
                            ret.append(espaceDeJeu.get(i).get(j).get(k)).append(">");
                            break;
                        } else if (j > 7 && j < 12) {
                            ret.append("<").append(espaceDeJeu.get(i).get(j).get(k));
                            break;
                        } else if (j == 12) {
                            ret.append("<").append(espaceDeJeu.get(i).get(j).get(k)).append(">");
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
