public class Calculette {

    // Methode d'addition de 2 entiers
    public static int additionner(int a, int b) {
        return a + b;
    }

    // Methode d'affichage du resultat de l'addition
    public static void afficherResultat(int resultat) {
        System.out.println("Le resultat est : " + resultat);
    }

    public static void main(String[] args) {

        // Appel de la methode additionner
        Terminal1.ecrireStringln("Entrer le premier nombre : ");
        int a = Terminal1.lireInt();

        int somme = additionner(10, 5);

        // Appel de la methode afficherResultat
        afficherResultat(somme);
    }
}
