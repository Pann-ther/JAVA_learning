import javax.swing.ImageIcon;

public class TuileNumerique extends Tuile{
    private int numero;

    public TuileNumerique(String cat, int numero) {
        String catUC = cat.toUpperCase();
        if (!estDansCategorie(catUC, categoriesValides)) {
            throw new IllegalArgumentException("La catégorie n'est pas valide");
        }

        if (numero < 1 || numero > 9) {
            throw new IllegalArgumentException("Le numéro n'est pas valide");
        }
        this.categorie = catUC;
        this.numero = numero;
        this.image = new ImageIcon("images/" + categorie + "_" + numero + ".png");
    }

    // Getters
    public int getNumero() {
        return numero;
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
        return categorie + "_" + numero;
    }

}
