import java.util.ArrayList;

public class Panier {
    ArrayList<Produit> panier;

    public Panier() {
        panier = new ArrayList<Produit>();
    }

    public Panier(Produit[] produits){
        panier = new ArrayList<Produit>();
        for(int i=0; i<produits.length; i++){
            panier.add(produits[i]);
        }
    }

    public void ajouterProduit(Produit produit) {
        for (Produit p : panier) {
            if (panier.contains(produit)) {
                p.setQuantité(p.getQuantité() + produit.getQuantité());
                System.out.println(produit.getNom() + " est deja dans la liste, la quantité a été mise a jour: "
                        + produit.getQuantité());
                return;
            }
        }
        panier.add(produit);
        System.out.println(produit.getNom() + " a bien été ajouté a votre panier");
    }

    public void supprimerProduit(Produit produit) {
        if (panier.contains(produit)) {
            panier.remove(produit);
            System.out.println(produit.getNom() + " a bien été supprimé du panier");
        } else {
            System.out.println("Erreur: ce produit ne fait pas partie du panier");
        }
    }

    public void supprimerProduit(Produit produit, int quantité) {
        for (Produit p : panier) {
            if (panier.contains(produit)) {
                int pQuantité = p.getQuantité();
                if (pQuantité > quantité) {
                    p.setQuantité(pQuantité-quantité);
                    System.out.println("Vous avez surprimé "+ p.getQuantité()+" "+produit.getNom());
                } else {
                    panier.remove(produit);
                    System.out.println(produit.getNom() + " a bien été supprimé du panier");
                }
                return;
            }
        }
        System.out.println("Erreur: ce produit ne fait pas partie du panier");
    }

    public String afficherPanier() {
        String aff = "";
        for (Produit produit : panier) {
            aff += "produit: " + produit.getNom() + ", quantité: " + produit.getQuantité() + "\n";
        }
        return aff;
    }
}
