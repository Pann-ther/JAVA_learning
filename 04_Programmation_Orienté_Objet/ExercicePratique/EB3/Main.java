public class Main {
    public static void main(String[]args){
        Colis colis1 = new Colis(2500, 40, "10 rue de la galmy, 77600 Bussy", true);
        Lettres lettre1 = new Lettres(20,"5 rue pavee, 77600 Bussy", true);
        Lettres lettre2 = new Lettres(10,"10 rue pavee, 77600 Bussy", false);

        BoitePostale bp1 = new BoitePostale();
        bp1.enregistrer(colis1);
        bp1.enregistrer(lettre1);
        bp1.enregistrer(lettre2);
        bp1.afficherListeCourriers();
    }
}
