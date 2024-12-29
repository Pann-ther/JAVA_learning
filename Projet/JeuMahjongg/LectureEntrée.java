import java.util.Scanner;
public class LectureEntrée {
    static Scanner scan = new Scanner(System.in);

    public static int lireInt(String msg){
        int input = -1;
        boolean correct = false;
        do{
            try {
                System.out.print(msg);
                input = scan.nextInt();
                scan.nextLine();
                correct = true;
            } catch (Exception e) {
                System.out.println("Entrez un entier valide");
                scan.next();
                correct = false;
            }
        } while (!correct);

        return input;
    }

    public static String lireString(String msg){
        String input = "";
        boolean correct = false;
        do{
            try {
                System.out.print(msg);
                input = scan.nextLine();
                correct = true;
            } catch (Exception e) {
                System.out.println("Entrez un entier valide");
                correct = false;
            }
        } while (!correct);
        return input;
    }

    // Demande à l'utilisateur de rentrer les coordonnées de la tuile qu'il à choisi
    public static int[] coordTuile(String msg) {
        int[] coord = new int[2];
        coord[0] = lireInt("Entrez la ligne où se situe la " + msg + " tuile selectionné: ");
        coord[1] = lireInt("Entrez la colonne où se situe la " + msg + " tuile selectionné: ");
        return coord;
    }
}
