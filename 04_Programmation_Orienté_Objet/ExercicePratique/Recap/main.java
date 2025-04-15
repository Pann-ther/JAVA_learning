import java.util.ArrayList;

public class Main{
    public static void main(String[]args){
        ArrayList<Personne> personnes = new ArrayList<>();
        Personne personne1 = new Personne("Phillipe","Tio",45);
        Personne personne2 = new Personne("Geraldine","Perrez",29);
        Personne personne3 = new Personne("Batiste","Blanc",20);
        Personne personne4 = new Personne("Janelle","Castle",18);
        Personne personne5 = new Personne("Mathis","Chaumont",16);
        personnes.add(personne1);
        personnes.add(personne2);
        personnes.add(personne3);
        personnes.add(personne4);
        personnes.add(personne5);

        System.out.println("Liste des personnes");
        for(int i=0;i<personnes.size();i++){
            System.out.println(personnes.get(i).afficherInfos());
        }
        System.out.println();


        System.out.println("Liste des personnes de plus de 25 ans");
        for(int i=0; i<personnes.size();i++){
            if (personnes.get(i).getAge() > 25) {
                System.out.println(personnes.get(i).afficherInfos());
            }
        }
        System.out.println();

        for(Personne p : personnes){
            String personneRecherche = "Batiste";
            if (p.getNom().equalsIgnoreCase(personneRecherche)) {
                System.out.println(personneRecherche+ " à été trouvé dans la liste");
            }
        }
        System.out.println();



        CompteBancaire compte1 = new CompteBancaire("Kylian Chebbah");
        System.out.println("Numero de compte: "+compte1.getNumeroCompte());
        compte1.deposer(1000);
        compte1.retirer(1500);
        System.out.println(compte1.afficherSolde());


    }
}