import java.util.ArrayList;

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
            System.out.println("Les deux tuiles " + tuile1 + " et " + tuile2
                    + " sont identiques sans etre de meme instance, les deux tuiles ont été retiré");
            System.out.println("Tuiles restantes: " + JeuMahjongg.tuiles.size());
            JeuMahjongg.tuiles.remove(index1);
            JeuMahjongg.tuiles.remove(index2);
        } else {
            System.out.println("Les deux tuiles " + tuile1 + " et " + tuile2
                    + " ne sont pas identique sans etre de meme instance, elles ne peuvent pas etre retirées");
        }

        if (JeuMahjongg.tuiles.isEmpty()) {
            System.out.println("Toutes les paires ont été retirées. Bravo, vous avez gagné !");
        }
    }

    public static void appariementTuile(Tuile t1, Tuile t2) {
        if (t1.estEgale(t2)) {
            System.out.println("On peut apparier " + t1 + " et " + t2
                    + " car elles sont identiques et de 2 instances differentes");
        } else {
            System.out.println("On ne peut pas apparier " + t1 + " et " + t2
                    + " car elles ne sont pas identiques et/ou de meme instance");

        }
    }

    public static void main(String[] args) {

        // Test initialisation de l'espace de jeu et utilisation de la methode pour enlever du plateau 2 tuiles si se sont une paire d'instances differentes
        try {
            JeuMahjongg plateau = new JeuMahjongg(); // Initialise le plateau de jeu avec les 144 tuiles
            int[][] disp = { // coordonnées du positionnement des tuiles dans l'espace de jeu 
                    { 0, 0, 0 }, { 0, 1, 0 }, { 0, 2, 0 }, { 0, 3, 0 }, { 0, 4, 0 }, { 0, 8, 0 },
                    { 0, 9, 0 }, { 0, 10, 0 }, { 0, 11, 0 }, { 0, 12, 0 }, { 1, 0, 0 }, { 1, 1, 0 }, { 1, 2, 0 },
                    { 1, 3, 0 }, { 1, 5, 0 }, { 1, 6, 0 }, { 1, 7, 0 }, { 1, 9, 0 }, { 1, 10, 0 }, { 1, 11, 0 },
                    { 1, 12, 0 }, { 2, 0, 0 }, { 2, 1, 0 }, { 2, 2, 0 }, { 2, 6, 0 }, { 2, 10, 0 }, { 2, 11, 0 },
                    { 2, 12, 0 }, { 3, 0, 0 }, { 3, 1, 0 }, { 3, 5, 0 }, { 3, 6, 0 }, { 3, 7, 0 }, { 3, 11, 0 },
                    { 3, 12, 0 }, { 4, 0, 0 }, { 4, 1, 0 }, { 4, 2, 0 }, { 4, 6, 0 }, { 4, 10, 0 }, { 4, 11, 0 },
                    { 4, 12, 0 }, { 5, 0, 0 }, { 5, 1, 0 }, { 5, 2, 0 }, { 5, 3, 0 }, { 5, 5, 0 }, { 5, 6, 0 },
                    { 5, 7, 0 }, { 5, 9, 0 }, { 5, 10, 0 }, { 5, 11, 0 }, { 5, 12, 0 }, { 6, 0, 0 }, { 6, 1, 0 },
                    { 6, 2, 0 }, { 6, 3, 0 }, { 6, 4, 0 }, { 6, 8, 0 }, { 6, 9, 0 }, { 6, 10, 0 }, { 6, 11, 0 },
                    { 6, 12, 0 }, { 0, 0, 1 }, { 0, 1, 1 }, { 0, 2, 1 }, { 0, 3, 1 }, { 0, 9, 1 }, { 0, 10, 1 },
                    { 0, 11, 1 }, { 0, 12, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 2, 1 }, { 1, 6, 1 }, { 1, 10, 1 },
                    { 1, 11, 1 }, { 1, 12, 1 }, { 2, 0, 1 }, { 2, 1, 1 }, { 2, 11, 1 }, { 2, 12, 1 }, { 3, 0, 1 },
                    { 3, 6, 1 }, { 3, 12, 1 }, { 4, 0, 1 }, { 4, 1, 1 }, { 4, 11, 1 }, { 4, 12, 1 }, { 5, 0, 1 },
                    { 5, 1, 1 }, { 5, 2, 1 }, { 5, 6, 1 }, { 5, 10, 1 }, { 5, 11, 1 }, { 5, 12, 1 }, { 6, 0, 1 },
                    { 6, 1, 1 }, { 6, 2, 1 }, { 6, 3, 1 }, { 6, 9, 1 }, { 6, 10, 1 }, { 6, 11, 1 }, { 6, 12, 1 },
                    { 0, 0, 2 }, { 0, 1, 2 }, { 0, 2, 2 }, { 0, 10, 2 }, { 0, 11, 2 }, { 0, 12, 2 }, { 1, 0, 2 },
                    { 1, 1, 2 }, { 1, 11, 2 }, { 1, 12, 2 }, { 2, 0, 2 }, { 2, 12, 2 }, { 4, 0, 2 }, { 4, 12, 2 },
                    { 5, 0, 2 }, { 5, 1, 2 }, { 5, 11, 2 }, { 5, 12, 2 }, { 6, 0, 2 }, { 6, 1, 2 }, { 6, 2, 2 },
                    { 6, 10, 2 }, { 6, 11, 2 }, { 6, 12, 2 }, { 0, 0, 3 }, { 0, 1, 3 }, { 0, 11, 3 }, { 0, 12, 3 },
                    { 1, 0, 3 }, { 1, 12, 3 }, { 5, 0, 3 }, { 5, 12, 3 }, { 6, 0, 3 }, { 6, 1, 3 }, { 6, 11, 3 },
                    { 6, 12, 3 }, { 0, 0, 4 }, { 0, 12, 4 }, { 6, 0, 4 }, { 6, 12, 4 }
            };
            EspaceDeJeu plateauJeu = new EspaceDeJeu(7, 13, 5);
            ArrayList<Tuile> tuiles = JeuMahjongg.getTuiles();
            plateauJeu.placementTuiles(disp, tuiles); // repartition aléatoire des tuiles dans l'espace de jeu
            Tuile tuile1 = new Tuile("K", 9);
            Tuile tuile2 = new Tuile("K", 9);
            //System.out.println(plateauJeu.debugger());
            System.out.println(plateauJeu.toString());
            plateauJeu.tirerTuiles(tuile1, tuile2);
            System.out.println(plateauJeu.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
