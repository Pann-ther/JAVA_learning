import javax.swing.ImageIcon;

import mahjong.gui.IGMTuile;

public abstract class Tuile implements IGMTuile{
    protected String categorie;
    protected ImageIcon image;
    private int[] coordonnees;
    private boolean highlighted;

    public Tuile() {
        coordonnees = new int[3];
    }

    // Verifie si l'entrée fait partie des tableaux d'entrées valides
    public boolean estDansListe(String entree, String[] tab) {
        for (String t : tab) {
            if (t.equalsIgnoreCase(entree)) {
                return true;
            }
        }
        return false;
    }

    // Getters

    public int[] getCoordonnees() {
        return coordonnees;
    }

    public String getCategorie() {
        return categorie;
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public int getX() {
        return coordonnees[0];
    }

    @Override
    public int getY() {
        return coordonnees[1];
    }
    @Override
    public int getZ() {
        return coordonnees[2];
    }
    @Override
    public boolean isHighlighted() {
        if (highlighted) {
            return true;
        }
        return false;
    }

    @Override
    public void setHighlighted(boolean b) {
        this.highlighted = b;
    }

    // Setter
    public void setCoordonnees(int[] coordonnees) {
        this.coordonnees = coordonnees;
    }

    public abstract boolean retirerAvec(Tuile tuile);
    public abstract String toString();
}