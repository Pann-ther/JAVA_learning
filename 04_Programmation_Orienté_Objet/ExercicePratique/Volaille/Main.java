public class Main {

    public static void main(String[] args) {
        try {
            Elevage ferme = new Elevage();

            for (int i = 0; i < 15; i++) {
                ferme.ajouterVolaille(new Poulet(0.250, i));
            }
            System.out.println(ferme.getElevage());
        } catch (EntreeInvalide e) {
            System.out.println(e.getMessage());
        }

    }

}
