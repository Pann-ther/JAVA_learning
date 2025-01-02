public class Rectangle implements AvecSurface {
    protected Point hautDroit;
    protected double longueur, largeur;

    public Rectangle(Point hautDroit, double longueur, double largeur){
        this.hautDroit = hautDroit;
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double surface(){
        return longueur * largeur;
    }
}
