import javax.swing.ImageIcon;

public class TuileNumerique extends Tuile {
    private int numero;
    private static final String[] categoriesValides = { "CERCLE", "BAMBOU", "CARACTERE" };

    public TuileNumerique(String categorie, int numero) {
        if (!estDansListe(categorie, categoriesValides)) {
            throw new IllegalArgumentException("La catégorie n'est pas valide");
        }

        if (numero < 1 || numero > 9) {
            throw new IllegalArgumentException("Le numéro n'est pas valide");
        }
        this.categorie = categorie;
        this.numero = numero;
        this.image = new ImageIcon("images/"+ categorie + "_" + numero + ".png");
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public static String[] getCategoriesValides() {
        return categoriesValides;
    }

    @Override
    public boolean retirerAvec(Tuile tuile) {
        if (tuile instanceof TuileNumerique) {
            TuileNumerique t = (TuileNumerique) tuile;
            if (this != t && this.getCategorie().equalsIgnoreCase(t.getCategorie())
                    && this.getNumero() == t.getNumero()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.categorie.equals("CARACTERE")) {
            return "K" + numero;
        }
        return String.valueOf(categorie.charAt(0)) + numero;
    }

}
