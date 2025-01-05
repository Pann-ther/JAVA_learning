import javax.swing.ImageIcon;

public class TuileHonneur extends Tuile{
    private String dessin;

    public TuileHonneur(String cat, String des) {
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

    // Getters
    public String getDessin() {
        return dessin;
    }

    @Override
    public boolean retirerAvec(Tuile tuile) {
        if (tuile instanceof TuileHonneur) {
            TuileHonneur t = (TuileHonneur) tuile;
            if (this != t && this.getCategorie().equalsIgnoreCase(t.getCategorie())
                    && this.getDessin().equalsIgnoreCase(t.getDessin())) {
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
