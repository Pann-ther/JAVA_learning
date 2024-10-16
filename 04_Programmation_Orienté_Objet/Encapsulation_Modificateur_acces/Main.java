public class Main {
    public static void main(String[] args) {
        // Creation du compte bancaire et initialisation des attributs
        CompteBancaire client1 = new CompteBancaire("101214","John Doe",1000);
        // Affichage des informations du compte
        client1.releveCompte();

        // Tentative de modification du solde avec une valeur negative
        client1.setSolde(-200);

        // Changement de titulaire et mise a jour du solde
        client1.setTitulaire("Alice Dubois");
        client1.setSolde(3000);
        client1.releveCompte();

    }
}
