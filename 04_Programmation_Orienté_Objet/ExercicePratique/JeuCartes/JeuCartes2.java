class CouleurInvalide extends RuntimeException{
	public CouleurInvalide(){
		super("La couleur saisi est invalide. Les seuls valides sont:  Coeur, Carreau, Trèfle, Pique");
	}
}

class ValeurInvalide extends RuntimeException{
	public ValeurInvalide(){
		super("La valeur saisi est invalide. La valeur doit etre comprises entre 2 et 10 pour les cartes numériques et entre 11 et 14 pour les cartes honorables");
	}
}

public class JeuCartes2{
	private final String couleur;
	private final int valeur;
	// Valeur des cartes honorées: Valet = 11, Dame = 12, Roi = 13, As = 14
	// Tableau qui contient le nom des cartes
	private static final String[] nomsCartes = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
	// Tableau qui contient la couleur des cartes
	private static final String[] couleursCartes = {"coeur", "carreau", "trèfle", "pique"};

	// Constructeur
	public JeuCartes2(String couleur, int valeur){
			if(!couleurValide(couleur)){
				throw new CouleurInvalide(); // Lance l'exception si la couleur saisie est invalide
			}
	
			if(valeur < 2 || valeur > 14){
				throw new ValeurInvalide(); // Lance l'exception si la valeur saisie est invalide
			}
			this.couleur = couleur;
			this.valeur = valeur;
		
	}
	
	// Getters
	public String getCouleur(){
		return couleur;
	}

    public int getValeur(){
		return valeur;
        	
    }

    // Getter qui convertis les valeurs des cartes en textes
	public String getNomCarte(){
		return nomsCartes[valeur - 2];
	}

	// Vérifie que la couleur est correct
	public static boolean couleurValide(String couleur){
		for(int i=0; i<couleursCartes.length; i++){
			if (couleursCartes[i].equalsIgnoreCase(couleur)) {
				return true;
			}
		}
		return false;
	}

	// Renvoie la carte qui a la valeur la plus forte
	public JeuCartes2 plusForte(JeuCartes2 carte){
		if(this.valeur > carte.getValeur()){
			return this;
		} else {
			return carte;
		}
	}
		
	// Affiche les informations de la carte
	public String toString(){
		return "valeur = "+getNomCarte()+ ", couleur = "+couleur ;
	}

	public static void main(String[] args) {
		try{
			JeuCartes2 carte1 = new JeuCartes2("Coeur",14);
			JeuCartes2 carte2 = new JeuCartes2("Pique",4);
			System.out.println(carte1.getCouleur());
			System.out.println(carte2.getNomCarte());
			System.out.println(carte1.plusForte(carte2));
			System.out.println(carte1.toString());
			System.out.println(carte2.toString());
		} catch (CouleurInvalide e){
			System.out.println(e.getMessage());
		} catch (ValeurInvalide e){
			System.out.println(e.getMessage());
			System.out.println("Rappel: Valet = 11, Dame = 12, Roi = 13, As = 14");
		}
        
    }
}