public class Main {
    public static void main(String[] args) {
        // Test implementation operations
        try {
            Tuile t1 = new TuileNumerique("Cercle", 1);
            Tuile t2 = new TuileNumerique("Cercle", 1);
            Tuile t3 = t1;
            Tuile t4 = new TuileHonneur("Vent","Est");
            Tuile t5 = new TuileHonneur("Vent","ESt");
            Tuile t6 = new TuileBonus("Fleur","Bambou");
            Tuile t7 = new TuileBonus("Fleur","Orchidee");
            System.out.println("Afficher les informations de la tuile: "+t6.toString());
            System.out.println("D'instances differentes");
            System.out.println(t1.toString()+" peut etre retiré avec "+t2.toString()+" : "+t1.retirerAvec(t2));
            System.out.println("D'une meme instance");
            System.out.println(t1.toString()+" peut etre retiré avec "+t3.toString()+" : "+t1.retirerAvec(t3));
            System.out.println(t4.toString()+" peut etre retiré avec "+t7.toString()+" : "+t4.retirerAvec(t7));
            System.out.println(t6.toString()+" peut etre retiré avec "+t7.toString()+" : "+t6.retirerAvec(t7));
            System.out.println("Acces au images des tuiles");
            System.out.println(t6.getImage());
            System.out.println(t1.getImage());
            System.out.println(t4.getImage());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println();

        // Test du jeu: simulation d'une partie qui se termine quand le tableau de jeu est vide
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
            System.out.println("Le but du jeu est de selectonner par paire les tuiles identiques afin de les retirer du plateau");
            System.out.println("La partie sera terminer lorsque le plateau sera vide");
            System.out.println();
            do{
                System.out.print("Tuiles restantes: "+plateau.tuilesRestantes()+"   Tour de jeu: "+ nbTour+ "\n"); // Compteur tuiles restantes et tour de jeu
                System.out.println(); 
                System.out.println(plateau.toString());
                int[] coordT1 = LectureEntrée.coordTuile("première");
                int[] coordT2 = LectureEntrée.coordTuile("deuxième");
                System.out.println(plateau.tirerTuiles(coordT1,coordT2));
                System.out.println();
                nbTour ++;
            } while (!plateau.estVide());
            System.out.println("Vous avez gagné la partie");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
