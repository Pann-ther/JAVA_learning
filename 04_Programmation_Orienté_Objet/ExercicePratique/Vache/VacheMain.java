public class VacheMain {
    public static void main(String[] args) {
        Vache.setPrixKilo(3);
        Vache vache1 = new Vache(670);
        Vache vache2 = new Vache(890);
        Vache vache3 = new Vache(1100);
        double prixTroupeau = vache1.getPrix()+vache2.getPrix()+vache3.getPrix();
        System.out.println("Le prix du troupeau est de "+String.format("%.2f",(prixTroupeau))+"€");
    }
}
