import java.util.Scanner;
public class SaisieTableau{
	static Scanner scanner = new Scanner(System.in);

    // Demande et renvoie la type de tableau voulu par l'utilisateur
	public static String choisirType(){
		String input = "";

		do{
			System.out.print("Entrez le type du tableau (I/B): ");
			if(scanner.hasNext()){
				input = scanner.nextLine();
			} 
		} while (!input.equalsIgnoreCase("I") && !input.equalsIgnoreCase("B"));
		return input;
	}

    // Demande et renvoie la taille du tableau voulu par l'utilisateur
	public static int choisirTailleTableau(){
		int input = 0;

		do{
			System.out.print("Entrez la taille du tableau: ");
			if(scanner.hasNextInt()){
				input = scanner.nextInt();
			} else{
				scanner.next();
			}
		} while (input <= 0);
        scanner.nextLine();
		return input;
	}

    // Demande a l'utilisateur si il veut afficher les valeurs du tableau
	public static boolean afficherTableau(){
		String input = "";
		boolean afficher = false;

		do{
			System.out.print("Voulez vous afficher le tableau? (o/n): ");
			if(scanner.hasNext()){
			    input = scanner.nextLine();
				if(input.equalsIgnoreCase("o")){
					afficher = true;
				}
			} 
		} while (!input.equalsIgnoreCase("o") && !input.equalsIgnoreCase("n"));
		return afficher;
	}

    // Renvoit la chaine de caracteres complete du type du tableau
    public static String convertirType(String type){
        String convertion;
        if(type.equalsIgnoreCase("I")){
            convertion = "entiers";
        } else {
            convertion = "booleens";
        }
        return convertion;
    }

    // Recupere les valeurs saisis par l'utilisateur
    public static String[] saisirDonnées(String type, int nombre){
        String[] tab;
        do{
            System.out.println("Entrez "+nombre+" "+type+" et séparez les avec une virgule: ");
            String input = scanner.nextLine();
            tab = input.split(",");

            if(tab.length != nombre){
                System.out.println("Erreur: vous devez entrer "+nombre+" de valeurs");
            }
        } while (tab.length != nombre);
        
        return tab;
    } 

    // Affiche les valeurs du tableau
    public static <T> void affichageTableau(T[] tab, boolean reponseAfficherTableau){
        if(reponseAfficherTableau){
            for(int i=0; i<tab.length; i++){
                System.out.println(tab[i]);
            }
        }
    }

    // Cree le tableau conformément au reponse de l'utilisateur et stock les valeurs qu'il rentre au clavier
	public static void valeur(){
		String type = convertirType(choisirType());
		int nombre = choisirTailleTableau();
        String[] valeurs = saisirDonnées(type, nombre);
		if(type.equalsIgnoreCase("B")){
			type = "booléens";
			
			Boolean[] booleanTab = new Boolean[nombre];

			for(int i=0; i<valeurs.length; i++){
				booleanTab[i] = Boolean.parseBoolean(valeurs[i]);
			}

			boolean afficher = afficherTableau();

			affichageTableau(booleanTab, afficher);
		} else {
			type = "entiers";
			Integer[] intTab = new Integer[nombre];

			for(int i=0; i<valeurs.length; i++){
				intTab[i] = Integer.parseInt(valeurs[i]);
			}

			boolean afficher = afficherTableau();

			affichageTableau(intTab, afficher);
		}
	}

	public static void main(String[]args){
		valeur();
		scanner.close();
	}
}
