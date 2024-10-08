public class boucles {

    // Methode pour savoir si le nombre donné par l'utilisateur est pair ou impair
    public static void pairImpair() {
        Terminal1.ecrireString("Veuillez entrer un nombre : ");
        int nombre = Terminal1.lireInt();

        if (nombre % 2 == 0) {
            System.out.println(nombre + " est un nombre pair");
        } else {
            System.out.println(nombre + " est un nombre impair");
        }
    }

    // Methode pour afficher les nombres allant de 1 à 10 avec un boucle for
    public static void for10() {
        for (int i = 1; i < 11; i++) {
            System.out.print(i + " ");
        }
    }

    // Methode pour afficher les nombres allant de 1 à 10 avec un boucle while
    public static void while10() {
        int i = 0;
        while (i != 10) {
            i++;
            System.out.print(i + " ");
        }
    }

    // Methode pour afficher le mois correspondant au nombre donné par l'utilisateur
    public static void mois(){
        Terminal1.ecrireString("Veuillez entrer un nombre entre 1 et 12 : ");
        int mois = Terminal1.lireInt();

        switch (mois) {
            case 1:
                System.out.print("Janvier");
                break;
            
            case 2:
                System.out.print("Fevrier");
                break;
            case 3:
                System.out.print("Mars");
                break;
            case 4:
                System.out.print("Avril");
                break;  
            case 5:
                System.out.print("Mai");
                break;
            case 6:
                System.out.print("Juin");
                break;
            case 7:
                System.out.print("Juillet");
                break;
            case 8:
                System.out.print("Aout");
                break;
            case 9:
                System.out.print("Septembre");
                break;
            case 10:
                System.out.print("Octobre");
                break;
            case 11:
                System.out.print("Novembre");
                break;
            case 12:
                System.out.print("Decembre");
                break;
            default:
                System.out.print("Vous n'avez pas entrer un nombre entre 1 et 12");
                break;
        }
    }

    // Appel des methodes
    public static void main(String[] args) {

        String continuer;
        do{
            pairImpair();
            for10();
            System.out.println();
            while10();
            System.out.println();
            mois();
            System.out.println();

            Terminal1.ecrireString("Voulez vous entrer d'autres nombres? (oui/non) : ");
            continuer = Terminal1.lireString();
        } while (!continuer.equals("non"));

        System.out.println("Fin du programme");
        
    }
}
