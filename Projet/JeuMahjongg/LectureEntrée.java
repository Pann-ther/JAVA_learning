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

   
}
