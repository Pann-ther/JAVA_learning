public class Main {
    public static void main(String[] args) {
        Militaire ofge = new Militaire("Officier Géneral","Dupont",null);
        Militaire of = new Militaire("Officier ","Maitre",ofge);
        Militaire sousof = new Militaire("Sous Officier","Sako",of);
        Militaire rang = new Militaire("Militaire de rang","Roy",sousof);

        System.out.println(rang.toString());
        System.out.println(of.toString());
        System.out.println(rang.nbSuperieur(rang.getSuperieur()));

        ////
        Arret a1 = new Arret("Marne la vallée",new Heure(14,56),null);
        Arret a2 = new Arret("Val d'europe",new Heure(14,53),a1);
        Arret a3 = new Arret("Bussy-Saint-Georges",new Heure(14,49),a2);
        Arret a4 = new Arret("Torcy",new Heure(14,45),a3);
        System.out.println(a1.toString());
    }
}
