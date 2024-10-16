public class Livre {

    private String titre;
    private String auteur;
    private double prix;

    public Livre(String titre, String auteur, double prix){
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
    }
    
    public Livre(String titre, String auteur){
        this.titre = titre;
        this.auteur = auteur;
        this.prix = 0;
    }

    public void afficherDetails(){
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("Prix: " + prix + " €");
        System.out.println();
    }
}
