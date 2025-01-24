import javax.swing.ImageIcon;

public class TuileHonneur extends Tuile{
    private static final String[] categoriesValides = { "VENT", "DRAGON"};
    private static final String[] dessinsValides = { "SUD", "NORD", "OUEST", "EST", "VERT", "ROUGE", "BLANC"};
    private String dessin;


    public TuileHonneur(String categorie, String dessin) {
        if (!estDansListe(categorie, categoriesValides)) {
            throw new IllegalArgumentException("La catégorie n'est pas valide");
        }

        if (!estDansListe(dessin, dessinsValides)) {
            throw new IllegalArgumentException("Le dessin n'est pas valide");
        }
        this.categorie = categorie;
        this.dessin = dessin;
        this.image = new ImageIcon("images/"+ categorie + "_" + dessin + ".png");
    }

    // Getters
    public String getDessin() {
        return dessin;
    }

    public static String[] getCategoriesValides() {
        return categoriesValides;
    }

    public static String[] getDessinsValides() {
        return dessinsValides;
    }

    @Override
public boolean retirerAvec(Tuile tuile) {
    if (tuile instanceof TuileHonneur) {
        TuileHonneur t = (TuileHonneur) tuile;
        // Vérifie que ce ne sont pas la même instance
        if (this != t 
                && this.getCategorie().equalsIgnoreCase(t.getCategorie())
                && this.getDessin().equalsIgnoreCase(t.getDessin())) {
            return true;
        }
    }
    return false;
}


    @Override
    public String toString() {
        return String.valueOf(categorie.charAt(0)) + String.valueOf(dessin.charAt(0)); 
    }
}
