import java.util.Scanner;

public class DossierCandidatureGCP {
	private String nom;
	private String numero;
	private boolean emargement;
	private double note;
	private String status;

	static Scanner scanner = new Scanner(System.in);

	public DossierCandidatureGCP(String nom, String numero) {
		this.nom = nom;
		this.numero = numero;
		this.status = "ENREGISTRE";
		this.note = -1;
	}

	public void enregistrerEmargementEpreuveEcrite() throws Exception{
		if ("ADMIS".equals(status)) {
			throw new Exception();
		}
		this.emargement = true;
		status = "EMARGE";
	}

	public void enregistrerNoteEpreuveEcrite(int note) throws Exception {
		if ("ADMIS".equals(status)) {
			throw new Exception();
		}
		if (!emargement) {
			throw new Exception();
		}
		this.note = note;
		status = "NOTE_TRANSMISE";
	}

	public void publierResultatFinal() throws Exception{
		if ("ENREGISTRE".equals(status)) {
			throw new Exception();
		}
		if ("ADMIS".equals(status)) {
			throw new Exception();
		}
		if (note >= 10) {
			status = "ADMIS";
		} else {
			status = "NON_ADMIS";
		}
	}

	public String toString() {
		return "nom: " + nom + " numero: " + numero + " status: " + status + " note: " + note;
	}

	public static void main(String[] args) {
		try {
			DossierCandidatureGCP candidat1 = new DossierCandidatureGCP("Kylian", "1230303");
			candidat1.enregistrerEmargementEpreuveEcrite();
			candidat1.enregistrerNoteEpreuveEcrite(0);
			candidat1.publierResultatFinal();
			System.out.println(candidat1.toString());
		} catch (Exception e) {
			System.out.println("Candidat absent");
		}
		
	}
}
