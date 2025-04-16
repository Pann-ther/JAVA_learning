public class Adresse{
    private int numero;
    private String nomVoie;
    private int codePostal;
    private String ville;

    public Adresse(int numero, String nomVoie, int codePostal, String ville){
        this.numero = numero;
        this.nomVoie = nomVoie;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getNumero(){
        return numero;
    }

    public String getNomVoie(){
        return nomVoie;
    }

    public int getCodePostal(){
        return codePostal;
    }

    public String getVille(){
        return ville;
    }

    public String toString(){
        return numero+" "+nomVoie+" "+codePostal+" "+ville;
    }
}