import java.util.Scanner;

public class EntrepriseModif {
	static Scanner scan = new Scanner(System.in);

	// Affiche l'organisatio de l'entreprise en affichant l'employé et le service
	// auquel il appartient
	public static void afficherOrganisationEntreprise(String[] employés, String[] services, int[] indexService) {
        int plagePleine = premierIndexVide(employés);
        if (plagePleine == -1) {
            System.out.println("Le tableau est plein");
        }
		for (int i = 0; i < plagePleine; i++) {
			int index = indexService[i];
			System.out.print(employés[i] + " travaille au service " + services[index]);
			System.out.println();
		}
		System.out.println();
	}

	// Affiche les employés d'un service choisit par l'utilisateur
	public static void afficherServiceEmployés(String[] employés, String[] services, int[] indexService) {
        int plagePleine = premierIndexVide(employés);
        if (plagePleine == -1) {
            System.out.println("Le tableau est plein");
        }
		afficherServices(services);
		int index = lireEntier("Entrez le numéro du service que vous souhaitez consulter: ", services.length) - 1;
		String service = services[index];
		System.out.println("Employés du service " + service);
		for (int i = 0; i < employés.length; i++) {
			if (index == indexService[i]) {
				System.out.println(employés[i]);
			}
		}
		System.out.println();
	}

	// Affiche les employés d'un service choisit par l'utilisateur
	public static void afficherEmployésParService(String[] employés, String[] services, int[] indexService) {
        int plagePleine = premierIndexVide(employés);
        if (plagePleine == -1) {
            System.out.println("Le tableau est plein");
        }
		System.out.println("Voici la liste des employés par services");
		for (int i = 0; i < services.length; i++) {
			System.out.println(services[i]);
			for (int j = 0; j < employés.length; j++){
				if (i == indexService[j]) {
					System.out.print(employés[j]+" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

    // Ajoute un employé et son service d'après les entrées utilisateurs
    public static void ajouterEmployé(String[] employés ,String[] services, int[] indexService){
        int index = premierIndexVide(employés);
        if (index == -1) {
            System.out.println("Le tableau est plein");
        }

        String nom = lireString("Entrez le nom du nouvelle employé: ");
        System.out.println();
        afficherServices(services);
        int service = lireEntier("Entrez le service de l'employé: ", 4);
        employés[index] = nom;
        indexService[index] = service;
        System.out.println(employés[index]+ " du service "+ services[service]+" a bien été ajouté");
	}

    // Supprime un employé et son service d'après les entrées utilisateurs
    public static void supprimerEmployé(String[] employés ,String[] services, int[] indexService){
        int indexTab = premierIndexVide(employés);
        String nom = lireString("Entrez le nom de l'employé qui part a la retraite: ");
        int indexNom = rechercheNom(employés, nom);
        if (indexNom == -1) {
            System.out.println("Cette personne n'existe pas parmi les employés");
        }
        String[] temporaireEmployés = employés;
        int[] temporaireIndex = indexService;
        for(int i=indexNom; i<indexTab-1; i++){
            employés[i]= temporaireEmployés[i+1];
        }
        for(int i=indexNom; i<indexTab-1; i++){
            indexService[i]= temporaireIndex[i+1];
        }
        employés[indexTab-1]="0";
        indexService[indexTab-1]=-1;

        System.out.println("Après supression");
        afficherEmployés(employés);
    }

    // Remplit les tableau vide avec des caractere predefini 
    public static void remplirString(String[] tab){
        for(int i=0; i<tab.length; i++){
            tab[i]="0";
        }
    }

    public static void remplirEntier(int[] tab){
        for(int i=0; i<tab.length; i++){
            tab[i]=-1;
        }
    }

	// Affiche tout les services de l'entreprise
	public static void afficherServices(String[] services) {
		System.out.println("Services de l'entreprise");
		for (int i = 0; i < services.length; i++) {
			System.out.println((i + 1) + " " + services[i]);
		}
	}

    public static void afficherEmployés(String[] employés) {
        int index = premierIndexVide(employés);
		System.out.println("Liste employés");
		for (int i = 0; i < index; i++) {
			System.out.print(employés[i]+" ");
		}
	}
    // Recherche un nom dans un tableau
    public static int rechercheNom(String[] tab, String nom){
        for(int i= 0; i<tab.length; i++){
            if (tab[i].equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return -1;
    }

    // Permet d'avoir l'index d'ou commence la plage vide du tableau
    public static int premierIndexVide(String[] tab){
        for(int i=0; i<tab.length; i++){
            if (tab[i].equals("0")) {
                return i;
            }
        }
        return -1;
    }

	// Gere les entrées de type int par l'utilisateur
	public static int lireEntier(String msg, int nbService) {
		int input = 0;
		boolean correct;
		do {
			try {
				System.out.print(msg);
				input = scan.nextInt();
				correct = true;
			} catch (Exception e) {
				System.out.println("Erreur: vous n'avez pas entré un entier valide");
				scan.next();
				correct = false;
			}
		} while (!correct || input <= 0 || input > nbService);
		return input;
	}

	// Gere les entrées de type string par l'utilisateur
    public static String lireString(String msg) {
		String input = "";
		boolean correct;
		do {
			try {
				System.out.print(msg);
				input = scan.nextLine();
				correct = true;
			} catch (Exception e) {
				System.out.println("Erreur: vous n'avez pas entré une chaine de caractere");
				correct = false;
			}
		} while (!correct );
		return input;
	}

	public static void main(String[] args) {
		String[] employés = new String[50];
        remplirString(employés);
        employés[0] = "Jean";
        employés[1] = "John";
        employés[2] = "Jeannot";
        employés[3] = "Jeanne";
        employés[4] = "Juan";
        employés[5] = "Chris";
		String[] services = { "bureau d'etude", "ressources humaines", "service commercial", "gestion financiere" };
		int[] indexService = new int[50];
        remplirEntier(indexService);
        indexService[0] = 0;
        indexService[1] = 1;
        indexService[2] = 0;
        indexService[3] = 2;
        indexService[4] = 1;
        indexService[5] = 3;
		//afficherOrganisationEntreprise(employés, services, indexService);
		//afficherServiceEmployés(employés, services, indexService);
		//(employés, services, indexService);
        ajouterEmployé(employés, services, indexService);
        supprimerEmployé(employés, services, indexService);
		scan.close();
	}
}