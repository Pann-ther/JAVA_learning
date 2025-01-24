import java.util.ArrayList;
import javax.swing.ImageIcon;
import mahjong.gui.IGMahjong;

public class Plateau {
    private int lignes;
    private int colonnes;
    private ArrayList<Tuile>[][] plateau;
    private int nbTuilesRestantes;
    private IGMahjong plateauGraphique;
    private boolean partieEstPerdu = false;

    @SuppressWarnings("unchecked")
    public Plateau(int lignes, int colonnes, int[][] disposition, JeuMahjongg ensembleTuiles) throws Exception {
        this.lignes = lignes;
        this.colonnes = colonnes;

        plateau = new ArrayList[lignes][colonnes]; // initialisation du tableau
        plateauGraphique = new IGMahjong(true);

        // Initialise chaque cases avec un ArrayList pour representer les piles de
        // tuiles
        for (int l = 0; l < plateau.length; l++) {
            for (int c = 0; c < plateau[l].length; c++) {
                plateau[l][c] = new ArrayList<>();
            }
        }
        initialiserPlateau(disposition, ensembleTuiles, plateauGraphique); // Initialise le tableau en placant les tuiles aleatoirement
                                                         // choisis au coordonnées indiqués
    }

    public void initialiserPlateau(int[][] disposition, JeuMahjongg ensembleTuiles, IGMahjong plateauGraphique) throws Exception {
        if (ensembleTuiles.size() != disposition.length) {
            throw new Exception(
                    "Le nombre de coordonées ne corresponds pas au nombre de tuiles: " + ensembleTuiles.size());
        }

        nbTuilesRestantes = ensembleTuiles.size();
        int tailleEnsemble = ensembleTuiles.size(); // Taille initiale de l'ensemble
        for (int i = 0; i < tailleEnsemble; i++) {
            Tuile tuiletiree = ensembleTuiles.tirerTuile();
            int ligne = disposition[i][0];
            int colonne = disposition[i][1];
            if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
                plateau[ligne][colonne].add(tuiletiree);
                tuiletiree.setCoordonnees(disposition[i]);
                plateauGraphique.ajouterTuile(tuiletiree.getImage(), tuiletiree.getX(),tuiletiree.getY(),tuiletiree.getZ());
            } else {
                throw new Exception("Les coordonées de la tuile sont hors de l'espace de jeu");
            }
        }
    }

    // Retire les tuiles du plateau de jeu uniquement si 2 tuiles ont le meme dessin
    // et sont d'instances différentes
    
    public ResultatTirageTuiles tirerTuiles(int[] coordT1, int[] coordT2) {
        ResultatTirageTuiles resultatTirage = new ResultatTirageTuiles(); // Cette objet va permettre de donner le resultat du tirage de tuiles
        // Verifie si les cases sont vides et permets au joueur de continuer à jouer
        if (plateau[coordT1[0]][coordT1[1]].isEmpty() || plateau[coordT2[0]][coordT2[1]].isEmpty()) {
            resultatTirage.setResultat(ResultatTirageTuiles.Resultat.VIDE);
            return resultatTirage;
        }
        // Récupération des tuiles sélectionnées à partir du plateau de jeu
        Tuile t1 = plateau[coordT1[0]][coordT1[1]].get(plateau[coordT1[0]][coordT1[1]].size() - 1);
        Tuile t2 = plateau[coordT2[0]][coordT2[1]].get(plateau[coordT2[0]][coordT2[1]].size() - 1);

        if (t1.retirerAvec(t2)) {
            if (estSelectionnable(t1) && estSelectionnable(t2)) {
                
                // Retirer les tuiles du plateau
                plateau[t1.getX()][t1.getY()].remove(t1);
                plateauGraphique.retirerPaire(t1.getX(),t1.getY(),t1.getZ(),t2.getX(),t2.getY(),t2.getZ());
                plateau[t2.getX()][t2.getY()].remove(t2);
                nbTuilesRestantes -= 2;
                resultatTirage.setResultat(ResultatTirageTuiles.Resultat.VALIDE);
                return resultatTirage;
            }
            resultatTirage.setResultat(ResultatTirageTuiles.Resultat.PAS_JOUABLE);
            return resultatTirage;
        }
        resultatTirage.setResultat(ResultatTirageTuiles.Resultat.PAS_RETIRABLE);
        return resultatTirage;
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

        // Vérifie la tuile est bloqué par d'autres tuiles à droite et à gauche sur la
        // même hauteur
        if ((colonne > 0 && !plateau[ligne][colonne - 1].isEmpty() && plateau[ligne][colonne - 1].size() - 1 >= hauteur)
                &&
                (colonne < colonnes - 1 && !plateau[ligne][colonne + 1].isEmpty()
                        && plateau[ligne][colonne + 1].size() - 1 >= hauteur)) {
            return false;
        }
        return true; // La tuile est sélectionnable
    }

    public boolean resteCombinaisonsPossibles(){
        for(int i = 0; i<lignes; i++){
            for(int j =0; j<colonnes; j++){
                if(!plateau[i][j].isEmpty()){
                    Tuile t1 = plateau[i][j].get(plateau[i][j].size()-1); // Recupere la tuile au sommet de la pile
                    if (estSelectionnable(t1)) {
                        for(int k=0; k<lignes; k++){
                            for(int l=0; l<colonnes; l++){
                                if(!plateau[k][l].isEmpty()){
                                    Tuile t2 = plateau[k][l].get(plateau[k][l].size()-1);
                                    if (estSelectionnable(t2) && t1.retirerAvec(t2)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        partieEstPerdu = true;
        return false;
    }

    // Verifie combien y'a t'ils de tuiles restantes en dans le plateau
    public int tuilesRestantes() {
        return nbTuilesRestantes;
    }

    // Verifie si le plateau est vide
    public boolean estVide() {
        if (nbTuilesRestantes == 0) {
            return true;
        }
        return false;
    }

    public boolean getPartieEstPerdu(){
        return partieEstPerdu;
    }

    // Renvoi la tuile selectionné 
    public Tuile getTuile(int[] coord){
        if (plateau[coord[0]][coord[1]].isEmpty()) {
            return null;
        }
        return plateau[coord[0]][coord[1]].get(plateau[coord[0]][coord[1]].size() -1);
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

    // Affiche le plateau de jeu (du point de vue utilisateur) avec uniqument les
    // tuiles au sommet de chaque pile
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
                            if (estSelectionnable(tuileActuelle)) {
                            ret.append("<").append(tuileActuelle).append(">");
                            break;
                            }
                            ret.append(" ").append(tuileActuelle).append(" ");
                            break;
                        } else if ((j > 0 && j < 5) || (j == 7)) {
                            if (estSelectionnable(tuileActuelle)) {
                                ret.append(tuileActuelle).append(">");
                                break;
                            }
                            ret.append(tuileActuelle).append(" ");
                            break;
                        } else if ((j == 5) || (j > 7 && j < 12)) {
                            if (estSelectionnable(tuileActuelle)) {
                                ret.append("<").append(tuileActuelle);
                                break;
                            }
                            ret.append(" ").append(tuileActuelle);
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