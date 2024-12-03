import java.util.ArrayList;

public class Tuile {
    // Attributs d'une tuile
    private String categorie;
    private int numero;
    
    // Constructeur
    public Tuile(String categorie, int numero){
        this.categorie = categorie;
        this.numero = numero;
    }

    //Getters
    public String getCategorie() {
        return categorie;
    }

    public int getNumero() {
        return numero;
    }

    // Verifie si deux tuiles sont identiques (categorie et numero) en ayant des instances differentes
    public boolean estEgale(Tuile objet){
        if (this == objet) {
            return false;
        } else if (this != objet && this.getCategorie().equals(objet.getCategorie()) && this.getNumero() == objet.getNumero()) {
            return true;
        } else{
            return false;
        }
    }

    // Affiche les informations de la tuile
    public String toString(){
        return categorie+numero;
    }
}
