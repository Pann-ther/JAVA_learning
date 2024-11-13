import java.util.Scanner;

public class CourseEscargots {

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);

        // Recuperation du nb d'escargots
        int nbEscargots;
        do{
            System.out.print("Entrez le nombre d'escargots participant a la course: ");
            nbEscargots = scanner.nextInt();
        } while(nbEscargots <= 0);

        //Creation du tableau qui va stocker la position de chaque escargots sur le plateau de jeu et initialisation des positions a 0
        int [] tabJeu = new int[nbEscargots];
        for(int i= 0; i<tabJeu.length ; i++){
            tabJeu[i]=0;
        }

        // Creation de la boucle infini qui s'arretera quand un escargot sera a la position 50 ou l'aura depassé
        boolean ligneArrive = false;
        int nbTour = 0;
        while (ligneArrive == false){
            nbTour ++;
            System.out.println("Tour "+ nbTour);
            System.out.println();

            // Creation d'une boucle de jeu pour chaque tour, lancé de des et deplacement de la position pour chaque escargot
            for(int i = 0; i<tabJeu.length ; i++){
                // Creation du lancé de des qui renverra un nb entre 1 à 6
                int lancerDes = MOOC.auSort(1,6);
                tabJeu[i] += lancerDes;
                System.out.println("L'escargot "+(i+1)+" est a la case "+ tabJeu[i]);
            }

            // Structure conditionnel qui verifie si l'escargot a franchis la ligne d'arrivée
            for(int i = 0; i<tabJeu.length ; i++){
                if(tabJeu[i]>= 50){
                    ligneArrive = true;
                    System.out.println();
                    System.out.println("L'escargot "+(i+1)+" a remporté la course");
                    break;
                }
            }
           
        }
    }
}
