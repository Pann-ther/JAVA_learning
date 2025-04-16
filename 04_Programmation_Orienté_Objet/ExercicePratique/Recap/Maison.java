import java.util.ArrayList;

public class Maison{
    private ArrayList<Piece> maison;

    public Maison(){
        maison = new ArrayList<>();
    }

    public void ajouterMaison(Piece p){
        maison.add(p);
    }

    public double calculerSurfaceTotal(){
        double st = 0;
        for(Piece p : maison){
            st += p.getSurface();
        }
        return st;
    }

    public void afficherPieces(){
        System.out.println("Les pieces de la maison");
        for(Piece p: maison){
            System.out.println(p.getNom());
        }
    }
}











