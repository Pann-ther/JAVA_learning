public class Personne {
	private String prenom,nom,numeroINSEE,numeroTel;

	public Personne(String prenom,String nom, String numeroINSEE, String numeroTel){
		this.prenom = prenom;
		this.nom = nom;
		this.numeroINSEE = numeroINSEE;
		this.numeroTel = numeroTel;
	}

	public String getPrenom(){
		return prenom;
	}

	public String getNom(){
		return nom;
	}

	public String getNumeroINSEE(){
		return numeroINSEE;
	}

	public String NumeroTel(){
		return numeroTel;
	}

	public void setPrenom(String prenom){
		this.prenom = prenom;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public void setNumeroINSEE(String numeroINSEE){
		this.numeroINSEE = numeroINSEE;
	}

	public void setNumeroTel(String numeroTel){
		this.numeroTel = numeroTel;
	}
    
    public boolean aMemeNomQue(Personne personne){
        return this.nom.equalsIgnoreCase(personne.nom);
    }

    public String toString(){
        return "prenom: "+ prenom + ", nom: "+ nom +", numero INSEE: " + numeroINSEE + ", numero de telephone: "+ numeroTel;
    }
}