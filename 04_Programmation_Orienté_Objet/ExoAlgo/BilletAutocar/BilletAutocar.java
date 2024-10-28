public class BilletAutocar{


    static public String [] tabVille = {"Vierzon", "Salbris", "Nouans", "Lamotte-Bevron", "La ferté Saint-Aubin","Orléans"};
    static public double [] tabPrix = {3.20, 1.80, 2.30, 4.20, 5.00};

    
    static public void afficherIndiceVille(String ville){
        boolean villeTrouvé = false;
        for(int i =0; i< tabVille.length; i++){
            if(ville.equalsIgnoreCase(tabVille[i])){
                villeTrouvé = true;
                System.out.println("La ville "+ville+" se trouve a l'indice "+i);
                break;
            }
        }

        if(villeTrouvé == false){
            System.out.println("La ville "+ville+" ne fait pas partie du tableau");
        }
    }

    // Methode qui calcul le prix du trajet en fonction de la ville de depart et d'arrivé
    static public void calculerPrixTrajet(String villeDepart, String villeArrivé){

        // Stock l'indice des troncons pour le prix
        int indiceVilleDepart = 0;
        int indiceVilleArrive = 0;
        // Stock le resultat de la recherche des 2 villes dans le tableau
        boolean villeDepartTrouvé = false;
        boolean villeArrivéTrouvé = false;
        // 
        double prixTrajet = 0;

        // Boucle for pour rechercher les villes dans le tableau
        for(int i = 0; i<tabVille.length; i++){
            if(villeDepart.equalsIgnoreCase(tabVille[i])){
                villeDepartTrouvé = true;
                indiceVilleDepart =  i;
            }
            if(villeArrivé.equalsIgnoreCase(tabVille[i])){
                villeArrivéTrouvé = true;
                indiceVilleArrive =  i;
            }
        }

        // Arret du programme si la ville de depart et d'arrivé ne sont pas trouvé
        if(villeDepartTrouvé == false || villeArrivéTrouvé == false){
            System.out.println("Le trajet est invalide");
            return;
        }
        
        // Calcul du prix du trajet
        if (indiceVilleDepart < indiceVilleArrive) {
            for(int i = indiceVilleDepart ; i < indiceVilleArrive; i++){ // sens allé
                prixTrajet += tabPrix[i];
            }
        }else {
            for(int i = indiceVilleArrive   ; i < indiceVilleDepart; i++){ // sens retour
                prixTrajet += tabPrix[i];
            }
        }
        

        System.out.println("Prix du trajet: "+prixTrajet);
    }

    

    public static void main(String[]args){
       calculerPrixTrajet("orléans", "nouans");
    }

}