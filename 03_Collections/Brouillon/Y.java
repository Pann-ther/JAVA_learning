import java.util.ArrayList;
import java.util.Scanner;
public class Y {
    public static void main(String[] args) {
        ArrayList<String> articles = new ArrayList<String>();
        ArrayList<Integer> prixArticles = new ArrayList<Integer>();
        int choix = -1;
        String article = " ";
        int prix = -1;
        int index= -1;
        Scanner scan = new Scanner(System.in);
        boolean fini = false;
        while (!fini) {
            System.out.println("Votre choix");
            System.out.println("1: Ajouter un artcle");
            System.out.println("2: Supprimer un article");
            System.out.println("3: Finir le programme et afficher le ticker de caisse");
            choix = scan.nextInt();
            scan.nextLine();
            if (choix == 1) {
                System.out.println("Nom de l'article");
                article = scan.nextLine();
                articles.add(article);
                System.out.println("Prix de l'article");
                prix = scan.nextInt();
                scan.nextLine();
                prixArticles.add(prix);
            } else if (choix == 2) {
                System.out.println("Nom de l'article a supprimer");
                article = scan.nextLine();
                index = articles.indexOf(article);
                articles.remove(index);
                prixArticles.remove(index);
            } else if(choix == 3){
                System.out.println("Ticket de caisse");
                for(int i=0; i<articles.size(); i++){
                    System.out.println(articles.get(i)+" - "+prixArticles.get(i)+"€");
                }
                fini = true;
            }

        }
    }

}
