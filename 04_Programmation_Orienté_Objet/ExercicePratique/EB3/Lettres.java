public class Lettres extends Courrier{
	public Lettres(double poids, String adresse, boolean envoiExpress){
		super(poids,adresse,envoiExpress);
		if(poids > 30){
			throw new IllegalArgumentException();
		}
	}

	public double affranchir(){
		if(envoiExpress == true){
			return cout =(2.50 + (0.01 * poids))*2;
		} else {
			return cout = 2.50 + (0.01 * poids);
		}
	}
	
	public String toString(){
		return "Poids: "+poids+"; Adresse: "+adresse+"; Envoi express: "+envoiExpress;
	}
}