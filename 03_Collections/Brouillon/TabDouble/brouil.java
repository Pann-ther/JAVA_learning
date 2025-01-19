import java.util.Scanner;
public class brouil {
    static Scanner scan = new Scanner(System.in); // Creation du scanner

    // Gere l'ajout d'un entier dans le tableau a partir d'une entrée utilisateur, et renvoi le nouveau tableau avec le nombre ajouté
    public static int[] ajouter(int[] t,String msg){
        System.out.println("Tableau");
        afficher(t);
        int ajout = lireEntier(msg);
        int[] array = new int[t.length+1];
        for(int i = 0; i<t.length; i++){
            array[i]= t[i];
        }
        array[array.length-1] = ajout;
        System.out.println("Tableau apres ajout");
        afficher(array);
        return array;
    }

    // Gere la suppresion d'un entier dans le tableau a partir d'une entrée utilisateur, et renvoi le nouveau tableau sans le nombre supprimé
    public static int[] supprimer(int[] t,String msg){
        System.out.println("Tableau");
        afficher(t);
        int suppression = lireEntier(msg);
        int index = rechercher(t, suppression);
        int[] array = new int[t.length-1];
        if (index == -1) {
            System.out.println("Le nombre n'existe pas dans le tableau");
            return t;
        } else {
            for(int i=0 ; i<index; i++){
                array[i] = t[i];
            }
            for(int i=index+1; i<t.length; i++){
                array[i-1] = t[i];
            }
        }
        System.out.println("Tableau apres suppression");
        afficher(array);
        return array;
    }

    // Affiche le contenu d'un tableau
    public static void afficher(int[] t){
        for(int i=0; i<t.length; i++){
            System.out.print(t[i]+ " ");
        }
        System.out.println();
    }

    // Recherche un nombre dans un tableau et renvoie l'index du nombre trouvé
    public static int rechercher(int[] t, int recherche){
        for(int i=0; i<t.length; i++){
            if (recherche == t[i]) {
                return i;
            }
        }
        return -1;
    }

    // Gere l'entrée utilisateur
    public static int lireEntier(String msg){
        int input = 0;
        boolean correct = false;
        do{
            try {
                System.out.print(msg);
                input = scan.nextInt();
                correct = true;
            } catch (Exception e) {
                System.out.println("Erreur: vous n'avez pas entré un entier valide");
                scan.next();
                correct = false;
            }
        } while (!correct || input < 0);
        return input;
    }


    public static void main(String[] args) {
        int[] tab = { 32, 45, 4000, 200, 20 };
        int[] tab2 = ajouter(tab, "Quel nombre voulez vous ajouter dans le tableau? : ");
        int[] tab3 = supprimer(tab2, "Quel nombre voulez vous supprimer? : ");
    }

}
