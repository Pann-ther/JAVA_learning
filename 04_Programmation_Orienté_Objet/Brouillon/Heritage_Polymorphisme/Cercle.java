public class Cercle implements AvecSurface {
    protected Point centre;
    protected double rayon;
    
    public Cercle(Point centre, double rayon){
        this.centre = centre;
        this.rayon = rayon;
    }

    public double surface(){
        return Math.PI * rayon * rayon;
    }
    
}
