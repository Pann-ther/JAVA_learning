import java.util.Scanner;

public class CourseCycliste {

    public static void main(String[] args) {
        String[] nomsCoureurs = new String[50];
        String[] numerosDossard = new String[50];
        String[] resultatsCourses = new String[50];
        scan.close()
    }

    private static void enregistrerCoureurs(){
        System.out.println("---------------Enregistrement des coureurs---------------");
        boolean plusDeCoureurs = false;
        String nomCoureur = "";
        int numeroCoureur = 1;
        do {
            nomCoureur = lectureString("Entrez le nom du coureur: ") 
        } while (!plusDeCoureurs);
    }

    private static String lectureString(String message){
        String entree = "";
        boolean estCorrect = false;
        Scanner lecture = new Scanner(System.in);
        do {
            System.out.print(message);
            entree = lecture.nextLine();
            if (!entree.trim().isEmpty() || !entree.matches("\\d+")) {
                estCorrect = true;
            } else{
                System.out.println("Erreur: Entrez une chaine de caractere");
                lecture.nextLine();
            }
        } while (!estCorrect);
    }
    
}