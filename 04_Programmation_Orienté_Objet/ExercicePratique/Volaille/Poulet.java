public class Poulet extends Volaille{
	protected static double prixKilo = 0.90;
	protected static double poidsAbattage = 3;
	private final String type = "Poulet";

	public Poulet (double poids, int id) throws EntreeInvalide{
		super(poids,id);
	}

	public double getPrixKilo(){
		return prixKilo;
	}

	public double getPoidsAbattage(){
		return poidsAbattage;
	}

    @Override
	public String getType(){
		return type;
	}

	public void setPrixKilo(double prixKilo){
		this.prixKilo = prixKilo;
	}

	public void setPoidsAbattage(double poidsAbattage)throws EntreeInvalide{
		if(poidsAbattage <= 0){
			throw new EntreeInvalide("Le poids doit etre positif");
		}
		this.poidsAbattage = poidsAbattage;
	}

	public String toString(){
		return "Type de volaille: "+ type+", poids: "+poids+", id: "+id+ ", prix au kilo: "+prixKilo+", poids d'abattage"+poidsAbattage;
	}
}
