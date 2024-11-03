import java.util.Scanner;
import java.util.Date;

public class FormatCSV{

	static Scanner scanner = new Scanner(System.in); // Creation du scanner pour les entrées au clavier
	static String ligneCSV; // Stock l'entrée utilisateur
	static String [] tab; // Stock les données de la ligne CSV
	static String [] decompositionDate = new String[3]; // Stock les données qui vont composer l'objet Date
	static int jour, mois, année; // decompose la date 
	static String nom, prenom, date;// Stock chaque donnée de la ligne CSV
    // Verifie si les données sont valides
	static boolean prenomValide = false; 
	static boolean nomValide = false;
	static boolean dateValide = false;


	// Stock la ligne CSV entrée par l'utilisateur
		public static void saisieUtilisateur(){
			System.out.print("Entrez la ligne CSV: ");
            if(scanner.hasNextLine())
			ligneCSV = scanner.nextLine();
		}

	// Decoupe la chaine de caractères pour en extraire les donnees
		public static void extraireDonnées(){
			tab  = ligneCSV.split(";");
            if(tab.length < 3){
                System.out.println("Erreur de format");
            }
            for(int i = 0; i<tab.length; i++){
                tab[i]= tab[i].replace('"',' ').trim();
            }
			prenom = tab[0];
			nom = tab[1];
			date = tab[2];
		}

	// Verification des entrées qui contiennent des lettres
		public static boolean verifierDonnéeLettre(String donnée){
			char d = donnée.charAt(0);
			if(!Character.isLetter(d)){
				return false;
                
			}
            return true;
		}

	
	// Verification des entrées qui contiennent des chiffres
		public static boolean verifierDonnéeChiffre(String donnée){
			char d = donnée.charAt(0);
			if(!Character.isDigit(d)){
				return false;
                
			}
            return true;
		}

    // Decompose la date pour pouvoir crée un objet Date 
        public static void date(){
            decompositionDate = tab[2].split("/");
            if (decompositionDate.length < 3) {
                System.out.println("erreur de format");
            }
            jour = Integer.parseInt(decompositionDate[0]);
            mois = Integer.parseInt(decompositionDate[1])-1;
            année = Integer.parseInt(decompositionDate[2])-1900;

        }

	// Verifie si la ligne CSV est valide
		public static void verifierLigneCSV(Date date){
			if(prenomValide && nomValide && dateValide){
				System.out.println(prenom);
				System.out.println(nom);
				System.out.println(date);
			}else{
				System.out.println("Erreur de format");
			}
		}

	public static void main(String[]args){
		saisieUtilisateur(); 
		extraireDonnées();
		prenomValide = verifierDonnéeLettre(prenom); // Permet de stocker le retour de la methode 
		nomValide = verifierDonnéeLettre(nom); // Permet de stocker le retour de la methode 
		dateValide =  verifierDonnéeChiffre(date); // Permet de stocker le retour de la methode 
        Date naissance = new Date(année, mois, jour); // Crée l'objet naissance
		verifierLigneCSV(naissance); // le parametre naissance permet d'afficher la date apres que l'objet soit crée
		scanner.close(); // ferme le scanner
	}
}
