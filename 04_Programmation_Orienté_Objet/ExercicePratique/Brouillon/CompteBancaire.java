import java.util.Scanner;

public class CompteBancaire {
    protected static Scanner scanner = new Scanner(System.in);
    // Attribut de l'objet
    private int numeroCompte;
    private String titulaire;
    protected double solde;
    protected int codeSecret; // Sert à s'authentifier avant d'effectuer des operataions sur le compte

    // Compteur static pour attribuer un numéro de compte en fonction des comptes deja crées
    private static int compteurNumeroCompte = 1;


    // Constructeur
    public CompteBancaire(String titulaire){
        int input = 0;
        this.titulaire = titulaire;
        solde = 0.0;
        numeroCompte = compteurNumeroCompte;
        compteurNumeroCompte ++;
        // Initialise le code secret saisie par l'utilsateur
        do{
            System.out.print("Entrez votre code secret a 4 chiffres: ");
            if(scanner.hasNextInt()){
                input = scanner.nextInt();
                if (input >= 1000 && input <= 9999) {
                    codeSecret = input;
                    break;
                } else {
                    System.out.println("Erreur: entrez un code secret a 4 chiffres");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Erreur: entrez un entier a 4 chiffres");
                scanner.nextLine();
            }
        } while (true);
    }

    // Getters
    public int getNumeroCompte(){
        return numeroCompte;
    }

    public String getTitulaire(){
        return titulaire;
    }

    public double getSolde(){
        return solde;
    }

    // Permet de deposer de l'argent sur le compte avec un controle des sommes deposables
    public void deposer(double montant){
        int input;
        do{
            System.out.print("Entrez votre code secret: ");
            input = scanner.nextInt();

            if (input == codeSecret) {
                if(montant <= 0){
                    System.out.println("Un montant nul ou négatif ne peut etre deposé sur le compte");
                } else {
                    solde += montant;
                    System.out.println("Vous avez deposez "+montant+" €");
                }
                break;
            } else {
                System.out.println("Erreur: le code secret est incorrect veuillez reesayez");
                scanner.nextLine();
            }
        } while(true);
    }

    // Permet de retirer de l'argent sur le compte avec un controle des sommes retirables
    public void retirer(double montant){
        int input;

        do{
            System.out.print("Entrez votre code secret: ");
            input = scanner.nextInt();

            if (input == codeSecret) {
                if(montant<=0){
                    System.out.println("Un montant nul ou positif ne peut etre retiré du compte");
                } else if((solde-montant)<0) {
                    System.out.println("Le montant du solde est insuffisant pour effectuer ce retrait");
                } else {
                    solde= solde-montant;
                    System.out.println("Vous avez retirez "+montant+" €");
                }
                break;
            } else {
                System.out.println("Erreur: le code secret est incorrect veuillez reesayez");
                scanner.nextLine();
            }
        } while (true);
    }

    public String toString(){
        return "Titulaire: "+titulaire+"  Numéro de compte: "+numeroCompte+"  Solde: "+solde;
    }
}
