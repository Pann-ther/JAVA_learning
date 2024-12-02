public class Main {
    public static void main(String[] args) {
        Produit nutella = new Produit("Nutella", "028849384", 3);
        Produit steak = new Produit("Steak Haché", "849384", 1);
        Produit beurre = new Produit("Beurre", "028849384", 4);
        Panier panier = new Panier();
        panier.ajouterProduit(nutella);
        panier.ajouterProduit(nutella);
        panier.ajouterProduit(beurre);
        panier.ajouterProduit(steak);
        System.out.println(panier.afficherPanier());
    }
}
