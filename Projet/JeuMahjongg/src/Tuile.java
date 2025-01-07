import javax.swing.ImageIcon;

public abstract class Tuile {
    protected String categorie;
    protected ImageIcon image;
    private int[] coordonnees;

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

    public ImageIcon getImage() {
        return image;
    }

    // Setter
    public void setCoordonnees(int[] coordonnees) {
        this.coordonnees = coordonnees;
    }

    public abstract boolean retirerAvec(Tuile tuile);
    public abstract String toString();
}