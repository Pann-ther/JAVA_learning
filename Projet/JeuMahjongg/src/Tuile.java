import javax.swing.ImageIcon;

public abstract class Tuile {
    protected static final String[] categoriesValides = { "CERCLE", "BAMBOU", "CARACTERE", "VENT", "DRAGON", "FLEUR",
            "SAISON" };
    protected static final String[] dessinsValides = { "SUD", "NORD", "OUEST", "EST", "VERT", "ROUGE", "BLANC",
            "PRUNIER", "ORCHIDEE", "CHRYSANTHEME", "BAMBOU", "PRINTEMPS", "ETE",
            "AUTOMNE", "HIVER" };
    protected String categorie;
    protected ImageIcon image;
    private int[] coordonnees;

    public Tuile() {
        coordonnees = new int[3];
    }

    // Verifie si categorie fait partie du tableau categoriesValides
    public boolean estDansCategorie(String categorie, String[] tab) {
        for (String c : tab) {
            if (c.equalsIgnoreCase(categorie)) {
                return true;
            }
        }
        return false;
    }

    // Verifie si dessin fait partie du tableau dessinsValides
    public boolean estDansDessin(String dessin, String[] tab) {
        for (String d : tab) {
            if (d.equalsIgnoreCase(dessin)) {
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

    public static String[] getCategoriesValides() {
        return categoriesValides;
    }

    public static String[] getDessinsValides() {
        return dessinsValides;
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