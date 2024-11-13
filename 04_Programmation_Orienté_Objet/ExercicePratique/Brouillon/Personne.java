public class Personne {

    private String nom;
    private int age;

    public Personne(String nom, int age){
        this.nom = nom;
        this.age = age;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nouveauNom){
        nom = nouveauNom;
    }

    public int getAge(){
        return age;
    }

}
