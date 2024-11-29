import java.util.Scanner;
public class VentesConcessionnaire{
	static Scanner scan = new Scanner(System.in);

	// Controle les entrés au clavier de l'utilisateur
	public static int lireEntier(String msg){
		int input = 0;
		boolean correct = false;
		do{
			try {
				System.out.print(msg);
				input = scan.nextInt();
				correct = true;
			} catch (Exception e) {
				System.out.println("Erreur: vous n'avez pas saisie un entier");
				scan.next();
				correct = false;
			}
		} while (!correct || input <=0);
		return input;
	}

	// Stocke dans le tableau pour chaque vendeur le nombre de voiture vendues en fonction du modele 
	public static void entrerVente(int[][] t, String[] nom, String[] modele){
		for(int i=0; i<t.length; i++){
			for(int j=0; j<t[i].length; j++){
				t[i][j]= lireEntier("Entrez le nombre de "+modele[j]+" vendu par "+nom[i]+": ");
			}
			if (i<t.length-1) {
				System.out.println("Passons au vendeur "+nom[i+1]);
			}
			System.out.println();
		}
	}


	public static void venteModele(int[][] t, String[] nom){
		for(int modeles = 0; modeles<t[0].length; modeles++){
			int totalVentes=0;
			for(int vendeur=0; vendeur<t.length; vendeur++){
				totalVentes += t[vendeur][modeles];
			}
			System.out.println("Dans la concession, la "+nom[modeles]+" s'est vendu a "+totalVentes+" exemplaires");
		}
	}

	// Calcul le chiffre d'affaire par vendeur en fonction du nombre et du prix des voitures vendues
	public static void chiffreAffaire(int[][] t, String[] nom, int[] prix){
		for(int i=0; i<t.length; i++){
			int ca = 0;
			for(int j=0; j<t[i].length; j++){
				ca += prix[j]*t[i][j]; // recupere le prix du modele avec l'index de la colonne du tableau t pour le multiplier avec le nombre de voitures
			}
			System.out.println("Le chiffre d'affaire de "+nom[i]+" est de "+ca+" euros");
		}
	}
	public static void main(String[]args){
		String[] modelesVoitures ={"Twingo","Clio","Megane","Velsatis"};
		String[] vendeurs ={"André","Ingemar","Jean","Cindy","Joey"};
		int[] prixModele = {15000,18000,28000,35000};
		//int[][] ventesTab = new int[5][4];
		int[][] ventesTab = {{0,3,2,0},{2,3,0,1},{1,1,1,1},{5,1,0,0},{1,1,2,0}};
		//entrerVente(ventesTab, vendeurs, modelesVoitures);
		//venteModele(ventesTab, modelesVoitures);
		chiffreAffaire(ventesTab, vendeurs, prixModele);
		scan.close();
	}
}
