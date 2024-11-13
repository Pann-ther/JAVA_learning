public class Rectangle {
    
    // Attribut class Rectangle
    private double largeur;
    private double hauteur;

    

    // Constructeur
    public Rectangle(double largeur, double hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
    }



    // Methode pour le calcul de la surface
    public double calculerSurface(){
        return largeur*hauteur;
    }

    // Methode pour afficher les attributs de la classe
    public void afficherDetails(){
        System.out.println("Largeur: "+ largeur + " cm");
        System.out.println("Hauteur: "+ hauteur + " cm");
        System.out.println("Surface: "+ calculerSurface() + " cm2");
    }

}
