public class Operateurs {

    // Déclaration et initialisation des variables
    static int a = 20;
    static int b = 15;

    // Methode pour afficher les resultats des opérations
    public static void resultat (int a, int b){
        System.out.println("La somme de "+ a + " + " + b + " est égale à : " + (a+b)); 
        System.out.println("La difference de "+ a + " - " + b + " est égale à : " + (a-b)); 
        System.out.println("Le produits de "+ a + " * " + b + " est égale à : " + (a*b)); 
        System.out.println("Le reste de "+ a + " % " + b + " est égale à : " + (a%b)); 
    }

    // Methode pour vérifier si a est supérieur à b
    public static void superieur (int a, int b){
       if (a>b){
        System.out.println(a + " est superieur à " + b);
       }
    }

    // Methode qui verifie si a est positif et b est négatif
    public static void verifierValeur (int a,int b){
        if (a>0 && b<0){
            System.out.println(a + " est positif et " + b + " est négatif.");
        } else {
            System.out.println("Les conditions ne sont pas remplies.");
        }
    }

    //Appel des methodes
    public static void main(String[] args) {
        resultat(a, b);
        superieur(a, b);
        verifierValeur(a, b);
    }
}
