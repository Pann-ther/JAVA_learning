public class Tableau {

    // Déclaration et initialisation tableau unidimensionnel
    static double[] notesTableau = { 10.5, 23.5, 3.9, 4.3, 13.5 };
    static double sommeTableau;

    // Déclaration et initialisation d'une matrice
    static int[][] matrices = { { 1, 2, 3, 123 }, { 4, 5, 6, 456 }, { 7, 8, 9, 789 } };
    static double sommeMatrice;

    // Méthode pour calculer la somme des valeurs du tableau
    public static void calculSomme() {
        sommeTableau = 0;
        for (double note : notesTableau) {
            System.out.print(note + " ");
            sommeTableau += note;
        }
        System.out.println();
        System.out.println("La somme de ce tableau est de : " + sommeTableau);
    }

    // Méthode pour calculer la sommes des valeurs de la matrice
    public static void calculMatrice() {
        sommeMatrice = 0;
        for (int[] ligne : matrices) {
            for (int valeur : ligne) {
                System.out.print(valeur + " ");
                sommeMatrice += valeur;
            }
        }
        System.out.println();
        System.out.println("La somme de cette matrice : " + sommeMatrice);
    }

    // appel des methodes
    public static void main(String[] args) {
        calculSomme();
        calculMatrice();
    }
}
