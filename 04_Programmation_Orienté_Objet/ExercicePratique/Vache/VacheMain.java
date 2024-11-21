public class VacheMain {
    public static void main(String[] args) {
        Vache.setPrixKilo(3);
        Vache [] troupeau = new Vache[3];
        troupeau[0] = new Vache(670);
        troupeau[1] = new Vache(890);
        troupeau[2] = new Vache(1100);
        double prixTroupeau = 0;
        for(int i = 0; i<troupeau.length; i++){
            prixTroupeau += troupeau[i].getPrix();
        }
        System.out.println("Le prix du troupeau est de "+String.format("%.2f",(prixTroupeau))+"€");
    }
}
