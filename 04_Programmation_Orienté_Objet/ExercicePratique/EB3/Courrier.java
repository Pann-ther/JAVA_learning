public abstract class Courrier {
	protected double poids;
	protected String adresse;
	protected boolean envoiExpress = false;
	protected double cout = 0;

	public Courrier(double poids, String adresse, boolean envoiExpress){
			this.poids = poids;
			this.adresse = adresse;
			this.envoiExpress = envoiExpress;
	}
	
	public double getPoids(){
		return poids;
	}

	public String getAdresse(){
		return adresse;
	}

	public boolean getEnvoiExpress(){
		return envoiExpress;
	}
	
	public double getCout(){
		return cout;
	}

	public abstract double affranchir();

	public abstract String toString();


}