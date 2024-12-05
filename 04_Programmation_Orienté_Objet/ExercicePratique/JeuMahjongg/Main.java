public class Main {
    public static void main(String[] args) {
        // Test : Création valide
        try {
            Tuile tuile1 = new Tuile("B", 5);
            System.out.println("Test réussi : Tuile valide créée - " + tuile1);
        } catch (IllegalArgumentException e) {
            System.out.println("Test échoué : " + e.getMessage());
        }

        // Test : Catégorie invalide
        try {
            Tuile tuileInvalideCategorie = new Tuile("X", 5);
            System.out.println("Test échoué : Catégorie invalide n'a pas levé d'exception.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test réussi : Exception levée pour catégorie invalide - "+e.getMessage());
        }

        // Test : Numéro invalide
        try {
            Tuile tuileInvalideNumero = new Tuile("C", 10);
            System.out.println("Test échoué : Numéro invalide n'a pas levé d'exception.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test réussi : Exception levée pour numéro invalide - "+e.getMessage());
        }

        // Test : Appariement de deux tuiles identiques
        Tuile tuile2 = new Tuile("C", 1);
        Tuile tuile3 = new Tuile("C", 1);
        if (tuile2.estEgale(tuile3)) {
            System.out.println("Test réussi : Les tuiles sont identiques.");
        } else {
            System.out.println("Test échoué : Les tuiles identiques ne sont pas reconnues.");
        }

        // Test : Appariement de deux tuiles différentes
        Tuile tuile4 = new Tuile("K", 4);
        if (!tuile2.estEgale(tuile4)) {
            System.out.println("Test réussi : Les tuiles différentes ne sont pas reconnues comme identiques.");
        } else {
            System.out.println("Test échoué : Les tuiles différentes sont reconnues comme identiques.");
        }
        System.out.println();

        JeuMahjongg plateau = new JeuMahjongg(); // Initialise le plateau de jeu avec les 144 tuiles
        // Tirage
        System.out.println(plateau.tirerTuile());
        System.out.println(plateau.tirerTuile());
        System.out.println(plateau.tirerTuile());
        System.out.println(plateau.tuilesRestantes()); // Retourne le nombre de tuiles restantes
        System.out.println("Plateau vide: "+plateau.estVide()); // Retourne si le plateau est vide
    }
}
