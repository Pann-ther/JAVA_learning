import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
class FactorielNonDefinie extends RuntimeException {
    public FactorielNonDefinie(){
        super("La factoriel n'est pas definie pour les entiers negatifs");
    }
}
public class Fact {
    static Scanner scanner = new Scanner(System.in);

    // Recupere l'entier saisie par l'utilisateur avec une gestion des exceptions
    public static int lireEntier(String msg){
        int entier = 0;
        boolean correct;

        do{
            try {
                System.out.print(msg);
                entier = scanner.nextInt();
                scanner.nextLine();
                if(entier<0){
                    throw new FactorielNonDefinie();
                }
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous n'avez pas entrez un entier");
                correct = false;
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Vous n'avez rien entrez");
                scanner.nextLine();
                correct = false;
            }
        } while (!correct);
        return entier;
    }

    // calcule la factoriel de l'entier saisie par l'utilisateur
    public static void calculerFactoriel(){
        boolean correct;
        do{
            try {
                int nombre = lireEntier("Entrez un entier positif: ");
                int resultatFactoriel;
                resultatFactoriel = nombre;
                for(int i = nombre-1; i>0; i--){
                    resultatFactoriel = resultatFactoriel * i;
                }
                System.out.println("Le factoriel de "+nombre+" est "+resultatFactoriel);
                correct = true;
            } catch (FactorielNonDefinie e) {
                    System.out.println(e.getMessage());
                    correct = false;
            }
        } while (!correct);
    }

    public static void main(String[]args){
        calculerFactoriel();
        scanner.close();
    }
}
