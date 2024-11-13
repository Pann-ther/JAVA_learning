public class JeuCartes{
	private String couleur;
	private int valeur;

	// Constructeur
	public JeuCartes(String couleur, int valeur){
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
	public String getNomValeur(){
		switch(valeur){
			case 11: return "Valet";
			case 12: return "Dame";
			case 13: return "Roi";
			case 14: return "As";
			default: return Integer.toString(valeur);
		}
	}

    //Setters (ajouté malgré que l'enoncé disent que les valeurs et couleur ne change jamais après initialisation)
    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    public void setValeur(int valeur){
        this.valeur = valeur;
    }

	// Renvoi la carte qui a la valeur la plus forte
	public JeuCartes plusForte(JeuCartes carte){
		if(this.valeur > carte.getValeur()){
			return this;
		} else {
			return carte;
		}
	}
		
	// Affiche les informations de la carte
	public String toString(){
		return "La carte est un "+getNomValeur()+" de "+couleur;
	}

    // Methode main
    public static void main(String[] args) {
        JeuCartes carte1 = new JeuCartes("Coeur",13);
        JeuCartes carte2 = new JeuCartes("Pique",4);
        System.out.println(carte1.getCouleur());
        System.out.println(carte2.getValeur());
        System.out.println(carte2.plusForte(carte1).toString());
        System.out.println(carte1.toString());
        System.out.println(carte2.toString());
    }
}