import java.util.Scanner;

public class DossierCandidatureGCP{
	private String nom;
	private String numero;
	private boolean emargement;
	private double note;
	private String status;

	static Scanner scanner = new Scanner(System.in);

	public DossierCandidatureGCP(String nom, String numero){
		this.nom = nom;
		this.numero = numero;
	}

	public void enregistrementEmargementEpreuveEcrite(){
		String input;
		System.out.print("Veuillez signer la fiche d'emargement avec votre nom: ");
		if(scanner.hasNextLine()){
            input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                emargement = true;
            } else {
			    System.out.println("Le candidat n'a pas émargé, le candidat ne peut plus etre admis");
		    }
        }
		
	}

	public void enregistrerNoteEpreuveEcrite(int note){
		if (emargement){
			this.note = note;
		} else {
			note = 0;
		}
	}

	public void publierResultatFinal(){
		if(note >= 10){
			status = "ADMIS";
			System.out.println("Note: "+note+"  Statut: "+status);
		} else {
			status = "NON_ADMIS";
			System.out.println("Note: "+note+"  Statut: "+status);
		}
	}
	
	public String toString(){
		return "nom: "+nom+" numero: "+numero+" status: "+status+" note: "+note;
	}
}
