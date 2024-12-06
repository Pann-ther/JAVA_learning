public class Main {

    // Test si lors d'un tirage de deux tuiles si elles sont identiques sans etre de me instance pour valider le tirage et les retirer du jeu
    public static void tirageTuiles() {
        int index1 = JeuMahjongg.random.nextInt(JeuMahjongg.tuiles.size());
        Tuile tuile1 = JeuMahjongg.tuiles.get(index1);
        System.out.println("Tuile tiré: " + JeuMahjongg.tuiles.get(index1).toString());
        int index2;
        do {
            index2 = JeuMahjongg.random.nextInt(JeuMahjongg.tuiles.size());
        } while (index1 == index2);
        Tuile tuile2 = JeuMahjongg.tuiles.get(index2);
        System.out.println("Tuile tiré: " + JeuMahjongg.tuiles.get(index2).toString());

        if (tuile1.estEgale(tuile2)) {
            System.out.println("Les deux tuiles "+ tuile1+" et "+tuile2+ " sont identiques sans etre de meme instance, les deux tuiles ont été retiré");
            System.out.println("Tuiles restantes: " + JeuMahjongg.tuiles.size());
            JeuMahjongg.tuiles.remove(index1);
            JeuMahjongg.tuiles.remove(index2);
        } else {
            System.out.println("Les deux tuiles "+tuile1+" et "+tuile2+" ne sont pas identique sans etre de meme instance, elles ne peuvent pas etre retirées");
        }

        if (JeuMahjongg.tuiles.isEmpty()) {
            System.out.println("Toutes les paires ont été retirées. Bravo, vous avez gagné !");
        }
    }

    public static void appariementTuile(Tuile t1, Tuile t2){
        if (t1.estEgale(t2)) {
            System.out.println("On peut apparier "+t1+" et "+t2+" car elles sont identiques et de 2 instances differentes");
        } else{
            System.out.println("On ne peut pas apparier "+t1+" et "+t2+" car elles ne sont pas identiques et/ou de meme instance");

        }
    }
   

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
            Tuile tuileInvalideCategorie = new Tuile("Z", 3);
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

        // Test appariement 
        Tuile tuile1 = new Tuile("B", 7);
        Tuile tuile2 = new Tuile("C", 1);
        Tuile tuile3 = new Tuile("C", 1);
        appariementTuile(tuile1, tuile1); // Tuiles identiques de meme instance
        appariementTuile(tuile2, tuile3); // Tuiles identiques de 2 instances differentes
        appariementTuile(tuile1, tuile2); // Tuiles differentes de 2 instances differentes
        System.out.println();

        JeuMahjongg plateau = new JeuMahjongg(); // Initialise le plateau de jeu avec les 144 tuiles
        // Tirage
        System.out.println(plateau.tirerTuile());
        System.out.println(plateau.tirerTuile());
        System.out.println(plateau.tirerTuile());
        System.out.println(plateau.tuilesRestantes()); // Retourne le nombre de tuiles restantes
        System.out.println("Plateau vide: "+plateau.estVide()); // Retourne si le plateau est vide
        tirageTuiles(); // Utilise la methode de test
    }
}
