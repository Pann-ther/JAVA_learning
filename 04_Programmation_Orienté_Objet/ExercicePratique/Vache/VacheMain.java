public class VacheMain {
    public static void main(String[] args) {
        Vache.setPrixKilo();
        Vache vache1 = new Vache(670);
        System.out.println(vache1.toString());
        vache1.nouvellePesée(700);
        System.out.println(vache1.toString());

    }
}
