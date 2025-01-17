import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Test : Création valide
        try {
            Tuile t1 = new TuileNumerique("BAMBOU", 5);
            System.out.println("Test réussi : Tuile valide créée - " + t1);
        } catch (Exception e) {
            System.out.println("Test échoué : " + e.getMessage());
        }

        // Test : Catégorie invalide
        try {
            Tuile t2 = new TuileNumerique("FLEUR", 3);
            System.out.println("Test échoué : Catégorie invalide n'a pas levé d'exception");
        } catch (Exception e) {
            System.out.println("Test réussi : Exception levée pour catégorie invalide - " + e.getMessage());
        }

        // Test : Numéro invalide
        try {
            Tuile t3 = new TuileNumerique("CARACTERE", 10);
            System.out.println("Test échoué : Numéro invalide n'a pas levé d'exception");
        } catch (Exception e) {
            System.out.println("Test réussi : Exception levée pour numéro invalide - " + e.getMessage());
        }

        // Test implementation operations

        // Tentative de retrait de 2 tuiles identiques de même instance
        Tuile t1 = new TuileHonneur("DRAGON", "VERT");
        Tuile t2 = t1;
        if (t1.retirerAvec(t2)) {
            System.out.println("Test échoué : La methode permet d'enlever 2 tuiles identiques d'une même instance");
        } else {
            System.out.println(
                    "Test réussi : La methode ne permet pas d'enlever 2 tuiles identiques d'une même instance");
        }
        // Tentative de retrait de 2 tuiles identiques d'instances differentes
        Tuile t3 = new TuileHonneur("DRAGON", "VERT");
        if (t1.retirerAvec(t3)) {
            System.out.println("Test réussi : La methode permet d'enlever 2 tuiles identiques d'instances differentes");
        } else {
            System.out.println(
                    "Test échoué : La methode ne permet pas d'enlever 2 tuiles identiques d'instances differentes");
        }
        // Tentative de retrait de 2 tuiles differentes
        Tuile t4 = new TuileBonus("FLEUR", "BAMBOU");
        if (t1.retirerAvec(t4)) {
            System.out.println("Test échoué : La methode permet d'enlever 2 tuiles differentes ");
        } else {
            System.out.println("Test réussi : La methode ne permet pas d'enlever 2 tuiles differentes");
        }

        // Afficher l'image d'une tuile
        System.out.println("Affichage chemin de l'image: " + t1.getImage());
        System.out.println();
        System.out.println();

        // Test du jeu: simulation d'une partie qui se termine quand le tableau de jeu
        // est vide
        try {
            JeuMahjongg ensembleTuiles = new JeuMahjongg(); // Initialise l'ensemble de tuiles avec les 144 tuiles
            int[][] disp = { // disposition des tuiles dans le plateau de jeu
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

            Plateau plateau = new Plateau(7, 13, disp, ensembleTuiles); // initialisation du plateau de jeu

            int nbTour = 0;
            System.out.println(
                    "Le but du jeu est de selectonner par paire les tuiles identiques afin de les retirer du plateau");
            System.out.println("La partie sera terminer lorsque le plateau sera vide ou que plus aucunes combinaisons ne soit possible");
            System.out.println();
            do {
                System.out.print("Tuiles restantes: " + plateau.tuilesRestantes() + " Tour de jeu: " + nbTour + "\n"); // Compteur tuiles restantes et tour de jeu                                                                                                 
                System.out.println();
                System.out.println(plateau.toString());
                int[] coordT1 = LectureEntrée.coordTuile("première");
                int[] coordT2 = LectureEntrée.coordTuile("deuxième");
                if (plateau.tirerTuiles(coordT1, coordT2)) {
                    System.out.println("La paire de tuiles est valide: elle a été retirée du plateau");
                } else {
                    System.out.println("La paire de tuiles n'est pas valide: elle n'a pas été retirée du plateau");
                }
                if (!plateau.resteCombinaisonsPossibles()) {
                    System.out.println("Vous avez perdu la partie: il ne reste plus de coup à jouer");
                    System.out.println(plateau.toString());
                } else if (plateau.estVide()) {
                    System.out.println("Vous avez gagné la partie: il n'y a plus de tuiles sur le plateau");
                }
                System.out.println();
                nbTour++;
            } while (!plateau.estVide() && !plateau.getPartieEstPerdu());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
