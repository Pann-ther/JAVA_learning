public class Colis extends Courrier{
	private double volume;

	public Colis(double poids, double volume,String adresse, boolean envoiExpress){
		super(poids,adresse,envoiExpress);
		if(volume > 50){
			throw new IllegalArgumentException();
		}
		this.volume = volume;
	}
	
	public double affranchir(){
		if(envoiExpress == true){
			return cout =((0.25*volume)+(0.01*poids))*2;
		} else {
			return cout =(0.25*volume)+(0.01*poids);
		}
	}

	public String toString(){
		return "Poids: "+poids+"; Volume: "+volume+"; Adresse: "+adresse+"; Envoi express: "+envoiExpress;
	}

}
