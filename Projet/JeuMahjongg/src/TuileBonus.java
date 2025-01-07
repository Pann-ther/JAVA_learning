import javax.swing.ImageIcon;

public class TuileBonus extends Tuile {
    private static final String[] categoriesValides = { "FLEUR","SAISON" };
    private static final String[] dessinsValides = { "PRUNIER", "ORCHIDEE", "CHRYSANTHEME", "BAMBOU", "PRINTEMPS", "ETE",
            "AUTOMNE", "HIVER" };
    private String dessin;

    public TuileBonus(String categorie, String dessin) {
        if (!estDansListe(categorie, categoriesValides)) {
            throw new IllegalArgumentException("La catégorie n'est pas valide");
        }

        if (!estDansListe(dessin, dessinsValides)) {
            throw new IllegalArgumentException("Le dessin n'est pas valide");
        }
        this.categorie = categorie;
        this.dessin = dessin;
        this.image = new ImageIcon("../images/" + categorie + "_" + dessin + ".png");
    }

    // Getter
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
        if (tuile instanceof TuileBonus) {
            TuileBonus t = (TuileBonus) tuile;
            if (this != t && this.getCategorie().equalsIgnoreCase(t.getCategorie())) {
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
