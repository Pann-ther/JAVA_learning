import java.util.Scanner;

public class Entreprise {
	static Scanner scan = new Scanner(System.in);

	// Affiche l'organisatio de l'entreprise en affichant l'employé et le service
	// auquel il appartient
	public static void afficherOrganisationEntreprise(String[] employés, String[] services, int[] indexService) {
		for (int i = 0; i < employés.length; i++) {
			int index = indexService[i];
			System.out.print(employés[i] + " travaille au service " + services[index]);
			System.out.println();
		}
		System.out.println();
	}

	// Affiche les employés d'un service choisit par l'utilisateur
	public static void afficherServiceEmployés(String[] employés, String[] services, int[] indexService) {
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

	// Affiche tout les services de l'entreprise
	public static void afficherServices(String[] services) {
		System.out.println("Services de l'entreprise");
		for (int i = 0; i < services.length; i++) {
			System.out.println((i + 1) + " " + services[i]);
		}
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

	public static void main(String[] args) {
		String[] employés = { "Jean", "Charles", "Jeanne", "Julie", "Juan", "Chris" };
		String[] services = { "bureau d'etude", "ressources humaines", "service commercial", "gestion financiere" };
		int[] indexService = { 0, 1, 0, 2, 1, 3 };
		afficherOrganisationEntreprise(employés, services, indexService);
		afficherServiceEmployés(employés, services, indexService);
		afficherEmployésParService(employés, services, indexService);
		scan.close();
	}
}