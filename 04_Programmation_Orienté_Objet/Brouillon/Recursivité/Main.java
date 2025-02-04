public class Main {
    public static void main(String[] args) {
        Militaire ofge = new Militaire("Officier Géneral", "Dupont", null);
        Militaire of = new Militaire("Officier ", "Maitre", ofge);
        Militaire sousof = new Militaire("Sous Officier", "Sako", of);
        Militaire rang = new Militaire("Militaire de rang", "Roy", sousof);

        System.out.println(rang.toString());
        System.out.println(of.toString());
        System.out.println(rang.nbSuperieur(rang.getSuperieur()));

        ////

        Train t1 = new Train(4567, null);
        // Ajout des gares desservies par le train
        t1.ajouterArretFin("Torcy", new Heure(14, 40));
        t1.ajouterArretFin("Bussy", new Heure(14, 50));
        t1.ajouterArretFin("Val", new Heure(14, 55));
        t1.ajouterArretFin("Disney", new Heure(14, 59));
        // Modification de la desserte et retard
        System.out.println("Plan de route initial");
        t1.afficher();
        t1.supprimerArret("torcy");
        t1.enregistrerRetard(10);
        System.out.println("Plan de route final");
        t1.afficher();
        System.out.println("Le terminus est dans " + t1.nbArret() + " arrets ");
        System.out.println(t1.heurePassage("Torcy"));
        t1.enregistrerRetard(10);

        Longeres piece = new Longeres("Salle de bain", 0, null);
        piece = new Longeres("Chambre ", 2, piece);
        piece = new Longeres("Chambre ", 1, piece);
        piece = new Longeres("Chambre ", 0, piece);
        piece = new Longeres("Cuisine ", 0, piece);
        piece = new Longeres("Séjour ", 0, piece);
        piece.afficher();
    }
}
