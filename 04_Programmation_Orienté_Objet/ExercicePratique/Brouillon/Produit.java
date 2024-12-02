public class Produit {
    private String nom;
    private String ref;
    private int quantité;

    public Produit(String nom, String ref, int quantité) {
        this.nom = nom;
        this.ref = ref;
        this.quantité = quantité;
    }

    public String getNom() {
        return nom;
    }

    public String getRef() {
        return ref;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public String toString() {
        return "Nom: " + nom + ", reference: " + ref + ", quantité: " + quantité;
    };

}
