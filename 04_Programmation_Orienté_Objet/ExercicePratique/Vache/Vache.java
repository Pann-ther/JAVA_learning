import java.util.Scanner;

public class Vache {
    private int immatriculation;
    private double poids;
    private double prix;
    private static int compteurImmatriculation = 1; // Donne un numero d'immatriculation unique en se basant sur le nombre de vache possédé
    private static double prixKilo; // Stock le prix au kilo de toute les vaches
    private static Scanner scan;// Declaration du scanner

    static {
        scan = new Scanner(System.in);// Initialisation du scanner
    }

    // Constructeur
    public Vache(double poids) {
        while (poids <= 0) {
            System.out.println("Erreur: Le poids doit etre positif");
            poids = lireDouble("Entrez un poids valide: ");
        }
        this.poids = poids;
        immatriculation = compteurImmatriculation;
        compteurImmatriculation++;
        this.prix = prixVache(); // Calcule automatiquement le prix

    }

    // Getters
    public int getImmatriculation() {
        return immatriculation;
    }

    public double getPoids() {
        return poids;
    }

    public double getPrix() {
        return prix;
    }

    public static double getPrixKilo() {
        return prixKilo;
    }

    // Setters
    public void setPoids(double poids) {
        if (poids > 0) {
            this.poids = poids;
            prix = prixVache();

        } else {
            System.out.println("Erreur: le poids doit etre positif");
        }

    }

    public static void setPrixKilo(double nouveauPrix) {
        if(nouveauPrix > 0){
            prixKilo = nouveauPrix ;
        } else {
            System.out.println("Erreur: le prix doit etre positif");
        }
    }

    // reinitialise le poids avec celui de la nouvelle pesée et recalcul le prix de la vache
    public void nouvellePesée(double poids) {
        if (poids > 0) {
            this.poids = poids;
            prix = prixVache();

        } else {
            System.out.println("Erreur: le poids doit etre positif");
        }
    }

    // Calcul du prix de la vache
    public double prixVache() {
        return prixKilo * poids;
    }

    // Methode pour lire un double avec gestion des exceptions
    public static double lireDouble(String msg) {
        boolean correct;
        double input = 0;
        do {
            try {
                System.out.print(msg);
                input = scan.nextDouble();
                correct = true;
            } catch (Exception e) {
                System.out.println("Erreur: veuillez entrez un nombre");
                scan.next();
                correct = false;
            }
        } while (!correct);
        return input;
    }

    // Methode pour lire un int avec gestion des exceptions
    public static int lireInt(String msg) {
        boolean correct;
        int input = 0;
        do {
            try {
                System.out.print(msg);
                input = scan.nextInt();
                correct = true;
            } catch (Exception e) {
                System.out.println("Erreur: veuillez entrez un nombre");
                scan.next();
                correct = false;
            }
        } while (!correct);
        return input;
    }

    // Affiche toutes les informations de la vache
    public String toString() {
        return "Numéro d'immatriculation: " + immatriculation + ", poids: " + poids + " KG, prix : "+ String.format("%.2f", prix) + "€";
    }

}
