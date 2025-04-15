public class Personne {

    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }

    // Getters
    public String getNom(){
        return nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public int getAge(){
        return age;
    }

    // Setters
    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String afficherInfos(){
        return "Nom: "+nom+", Prenom: "+prenom+", Age: "+age;
    }
    
}