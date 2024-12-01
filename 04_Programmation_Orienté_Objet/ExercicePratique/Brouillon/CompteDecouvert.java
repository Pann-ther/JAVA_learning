public class CompteDecouvert extends CompteBancaire {
    private double decouvertAutorise = -500;

    public CompteDecouvert(String titulaire) {
        super(titulaire);
    }

    public double getDecouvert() {
        return decouvertAutorise;
    }

    public void setDecouvert(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }

    public void retirer(int montant) {
        int input = 0;
        do {
            try {
                System.out.print("Entrez votre code secret: ");
                input = scanner.nextInt();
                if (input == codeSecret) {
                    if (montant <= 0) {
                        System.out.println("Erreur: le montant saisie est invalide, entrez un montant positif");
                    } else if (solde - montant > decouvertAutorise  ) {
                        solde -= montant;
                        System.out.println("Retrait effectué: votre nouveau solde est de: " + solde + "€");
                        break;
                    } else {
                        System.out.println("Vous avez atteint votre découvert autorisé");
                        System.out.println("Découvert autorisé: " + decouvertAutorise + "€");

                    }
                } else {
                    System.out.println("Erreur: le code saisie est invalide. Veuillez reesayer.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Erreur: entrée invalide. Veuillez entrer un code a 4 chiffres");
            }

        } while (input != codeSecret);
    }

}
