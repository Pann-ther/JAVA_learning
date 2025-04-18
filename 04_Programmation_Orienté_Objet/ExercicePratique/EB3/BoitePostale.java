import java.util.ArrayList;
public class BoitePostale{
	private ArrayList<Courrier> bp;
	
	public BoitePostale(){
		bp = new ArrayList<>();
	}

	public void enregistrer(Courrier c){
		c.affranchir();
		bp.add(c);
	}

	public void afficherListeCourriers(){
		for(Courrier c : bp){
			System.out.println(c.toString());
		}
	}
}
