import java.util.Scanner;

class InferieurEgal extends RuntimeException{
	public InferieurEgal(){
		super("n ne peut pas etre inferieur ou egal a 1");
	}
}

class SaisieIncorrect extends RuntimeException{
	public SaisieIncorrect(){
		super("l'entier saisie n'est pas compris entre 1 et n");
	}
}

class SaisieVide extends RuntimeException{
	public SaisieVide(){
		super("Vous n'avez pas entré d'entier");
	}
}

class LongeurTab extends RuntimeException{
	public LongeurTab(){
		super("Le tableau ne peut pas etre inferieur a 2 cases");
	}
}

public class Menu{
	static Scanner scanner = new Scanner(System.in);

    // Methode pour traiter le choix fait par l'utilisateur
	public static int saisirChoix(int n){
		if(n <=1){
			throw new InferieurEgal();
		}
		
		int saisieUtilisateur =0;
		boolean saisieCorrect = false;

		do{
			try{
				System.out.print("Veuillez entrez un entier entre 1 et "+n+": ");
				saisieUtilisateur = scanner.nextInt();
				if(saisieUtilisateur <1 || saisieUtilisateur > n){
					throw new SaisieIncorrect();
				}
				saisieCorrect = true;
			} catch (InferieurEgal e){ // Gestion des tableaux qui ont une taille inferieur a celle requis
				System.out.println(e.getMessage());
				scanner.nextLine();
				saisieCorrect = false;
			} catch (SaisieIncorrect e){ // Gestion des saisies hors plages d'entiers defini
				System.out.println(e.getMessage());
				scanner.nextLine();
				saisieCorrect = false;
			} catch (SaisieVide e){ // Gestion des entrées vides
				System.out.println(e.getMessage());
				scanner.nextLine();
				saisieCorrect = false;
			}
		} while (!saisieCorrect);
		return saisieUtilisateur;
	}

    // Methode qui affiche le contenu des tableaux
	public static void afficherMenu(String[] tab, String nomMenu){
		try{
			if(tab.length <2){
				throw new LongeurTab();
			}
            System.out.println("-----"+nomMenu+"-----");
			for(int i=0; i<tab.length; i++){
				System.out.println("Plat "+(i+1)+": "+tab[i]);
			}
		} catch (LongeurTab e){
			System.out.println(e.getMessage());
		}
	} 

    // Methode après l'appel de l'affichage permet a l'utilisateur d'entrer un entier
	public static int choisirMenu(String[] tab, String nomMenu){
		afficherMenu(tab, nomMenu);
		return saisirChoix(tab.length);
	}

	public static void main(String[]args){
		String[] tab1 = {"Basse cote","Poulet braissé", "Chesseburger","Boeuf Bourguignon"};
		String[] tab2 = {"Mafé","Thieb","Foutou","Couscous","Yassa"};
		int choix1 = choisirMenu(tab1, "Menu 1"); 
        int choix2 = choisirMenu(tab2, "Menu 2"); 
        System.out.println("-----Votre Commande-----");
		System.out.println("Vous avez choisi dans le Menu 1: "+ tab1[choix1 -1]); 
        System.out.println("Vous avez choisi dans le Menu 2: "+ tab2[choix2 -1]); 
	}
}