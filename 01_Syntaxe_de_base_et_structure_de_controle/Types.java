public class Types {
    

    // Declaration et attribution des variables
    static byte b = 8;
    static long l = 100000;
    static short s = 310;
    static int i = 10;
    static double d = 10.5;
    static char lettre = 'K';
    static boolean estVrai = true;

    // Methode pour afficher la valeur des variables
    public static void afficherTypes (){
        System.out.println("Valeur de byte : " + b);
        System.out.println("Valeur de long : " + l);
        System.out.println("Valeur de short : " + s);
        System.out.println("Valeur de int : " + i);
        System.out.println("Valeur de double : " + d);
        System.out.println("Valeur de char : " + lettre);
        System.out.println("Valeur de boolean : " + estVrai);

    }

    public static void main(String[] args){

        // Appel de la methodes pour afficher les valeurs
        afficherTypes();

    }
}
