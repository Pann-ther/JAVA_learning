public class Age {


    
    static String nom; // Declaration de la variable nom
    static final int AGE_MINIMUM = 18; // Declaration et initialisation de la constante age minimum

    // Methode d'affichage des informations
    public static void afficherInfos() {
        System.out.println("votre nom est : " + nom);
        System.out.println("l'age minimum est de : " + AGE_MINIMUM);
    }

    public static void main(String[] args) {

        // Recuperation du nom de l'utilisateur et initialisation de la variable 
        Terminal1.ecrireStringln("Veuillez entrer votre nom : ");
        nom = Terminal1.lireString();

        // appel de la méthode
        afficherInfos();
    }
}
