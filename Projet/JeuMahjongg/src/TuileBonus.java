import javax.swing.ImageIcon;

public class TuileBonus extends Tuile {
    private String dessin;

    public TuileBonus(String cat, String des) {
        String catUC = cat.toUpperCase();
        String desUC = des.toUpperCase();
        if (!estDansCategorie(catUC, categoriesValides)) {
            throw new IllegalArgumentException("La catégorie n'est pas valide");
        }

        if (!estDansDessin(desUC, dessinsValides)) {
            throw new IllegalArgumentException("Le dessin n'est pas valide");
        }
        this.categorie = catUC;
        this.dessin = desUC;
        this.image = new ImageIcon("images/" + categorie + "_" + dessin + ".png");
    }

    // Getter
    public String getDessin() {
        return dessin;
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
        return categorie + "_" + dessin;
    }
}
