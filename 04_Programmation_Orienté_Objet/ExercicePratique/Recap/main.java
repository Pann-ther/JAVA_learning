import java.util.ArrayList;

public class Main{
    public static void main(String[]args){
        /* 
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
        CompteBancaire compte2 = new CompteBancaire("Marcel Page");
        CompteBancaire compte3 = new CompteBancaire("Hame Sacko");
        System.out.println(compte1.toString());
        System.out.println(compte3.toString());
        compte1.deposer(1000);
        compte1.retirer(1500);
        System.out.println(compte1.afficherSolde());
        
    
        Maison maison = new Maison();
        Piece chambre1 = new Piece("Chambre 1",12);
        Piece chambre2 = new Piece("Chambre 2",17);
        Piece cuisine = new Piece("Cuisine",25);
        Piece salon = new Piece("Salon", 30);
        Piece douche = new Piece("Douche", 10);
        Piece toilette = new Piece("Toilette", 4);

        maison.ajouterMaison(chambre1);
        maison.ajouterMaison(chambre2);
        maison.ajouterMaison(cuisine);
        maison.ajouterMaison(salon);
        maison.ajouterMaison(douche);
        maison.ajouterMaison(toilette);
        System.out.println("Surface total: "+maison.calculerSurfaceTotal());
        */

        Developpeur dev1 = new Developpeur("Kylian Chebbah", 30000, "Python" , 10000);
        System.out.println(dev1.toString());
        
    }
}