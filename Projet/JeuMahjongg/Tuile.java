import java.util.ArrayList;

public class Tuile {
    // Attributs d'une tuile
    // Attributs en final car ce sont des caracteristiques sont immuables
    private static final String[] categoriesValides = { "C", "B", "K", "S", "N", "O", "E", "V", "R", "W", "F", "P" };
    private static final String[] categoriesSpeciales = {"S", "N", "O", "E", "V", "R", "W", "F", "P" };
    private String categorie;
    private int numero;
    
    // Constructeur
    public Tuile(String categorie, int numero){
        if(!estDansCategorie(categorie, categoriesValides)){
            throw new IllegalArgumentException("La catégorie "+categorie+" n'existe pas");
        }else if (numero < 1 || numero > 9) {
            throw new IllegalArgumentException("Le numéro "+ numero + " n'existe pas");
        } else if(numero > 1 && estDansCategorie(categorie, categoriesSpeciales)) {
            throw new IllegalArgumentException("La tuile "+ categorie+numero+" n'existe pas");
        }
        
        this.categorie = categorie;
        this.numero = numero;
    }

    // Verifie si categorie fait partie du tableau categoriesValides
    public boolean estDansCategorie(String categorie, String[] tab){
        for(String c : tab){
            if(c.equalsIgnoreCase(categorie)){
                return true;
            }
        }
        return false;
    }

    
    //Getters
    public static String[] getCategoriesValides() {
        return categoriesValides;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getNumero() {
        return numero;
    }

    // Verifie si deux tuiles sont identiques (categorie et numero) en ayant des instances differentes
    public boolean estEgale(Tuile objet){
        if (this != objet && this.getCategorie().equals(objet.getCategorie()) && this.getNumero() == objet.getNumero()) {
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
