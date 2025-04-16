public class Piece{
    private String nom;
    private double surface;

    public Piece(String nom, double surface){
        this.nom = nom;
        this.surface = surface;
    }

    public String getNom(){
        return nom;
    }

    public double getSurface(){
        return surface;
    }

    public String toString(){
        return "Piece: "+nom+", Surface: "+surface+" m2";
    }
}