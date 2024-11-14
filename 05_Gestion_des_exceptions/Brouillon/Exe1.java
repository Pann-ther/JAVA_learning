import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Exe1 {
    static Scanner scanner = new Scanner(System.in);

    public static int lireEntier(String msg){
        int entier = 0;
        boolean correct; 
        do{
            try {
                System.out.print(msg);
                entier = scanner.nextInt();
                correct = true; 
            } catch (InputMismatchException  e) {
                System.out.println("Vous n'avez pas saisis un entier");
                System.out.print("Veuillez recommencer");
                scanner.nextLine();
                correct = false;
            }
        } while (!correct);
        return entier;
    }

    public static void main(String[]args){
        int[] tab;
        int taille;
        taille = lireEntier("Entrez un entier pour la taille du tableau: ");
        tab = new int[taille];
        for(int i = 0; i<tab.length; i++){
            tab[i]= lireEntier("Entrez la valeur "+(i+1)+" : ");
        }
        for(int i=0; i<tab.length; i++){
            System.out.println(tab[i]);
        }
    }
}
