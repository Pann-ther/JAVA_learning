import java.util.Scanner;

public class Calculatrice {
    // Creation du scanner
    static Scanner scanner = new Scanner(System.in);

    // Declaration des variables
    static double nb1;
    static double nb2;
    static double resultat;

    // Methode pour gerer les entrées autres qu'un double puis initialisation des
    // variables avec les valeurs valides
    static public double nombreValide() {
        while (true) {
            System.out.println("Veuillez saisir un nombre");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Entrer un nombre valide");
                scanner.next();
            }
        }
    }

    // Methode pour s'assurer que l'utilisateur entre un des 4 operateurs
    // proposés
    static public String operateurValide() {
        String reponse;
        do {
            System.out.println("Quelle operation souhaitez vous realiser ? + - / * ");
            reponse = scanner.next();
        } while (!reponse.equalsIgnoreCase("+") && !reponse.equalsIgnoreCase("-") && !reponse.equalsIgnoreCase("/")&& !reponse.equalsIgnoreCase("*"));

        return reponse;
    }

    // Methode pour recuperer les nombres saisis par l'utilisateur et initialiser
    // les variables
    static public void demanderNombre() {

        nb1 = nombreValide();
        nb2 = nombreValide();

    }

    // Methode pour gerer l'erreur de la division par 0
    static public double division(double nb1, double nb2) {
        if (nb2 == 0) {
            return 0;
        } else {
            return nb1 / nb2;
        }
    }

    // Methode pour effectuer le calcul des nombres choissis en fonction du type
    // d'operation selectionner par l'utilisateur
    static public void calcul() {
        // Declaration variable
        String reponse = operateurValide();

        // Utilisation d'un switch pour effectuer le calcul qui correspond à l'operateur
        // selectioné
        switch (reponse) {
            case "+":
                resultat = nb1 + nb2;
                break;
            case "-":
                resultat = nb1 - nb2;
                break;
            case "/":
                resultat = division(nb1, nb2);
                break;
            case "*":
                resultat = nb1 * nb2;
                break;
            default:
                break;
        }

        // affichage du resultat
        System.out.println(resultat);

    }

    // demarrage du programme et appel des fonctions
    public static void main(String[] args) {
        demanderNombre();
        calcul();
        scanner.close();
    }

}