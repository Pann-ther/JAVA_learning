import java.util.Scanner;
public class BilletAutocar{

    static Scanner scanner = new Scanner(System.in);
    static public String [] ligne1Ville = {"Vierzon", "Salbris", "Nouans", "Lamotte-Bevron", "La ferté Saint-Aubin","Orleans"};
    static public double [] tab1Prix = {3.20, 1.80, 2.30, 4.20, 5.00};
    static public String [] ligne2Ville = {"Bussy", "Torcy", "Lognes", "Bondy", "Chelles","Nation"};
    static public double [] tab2Prix = {2.50, 1.80, 2.30, 9.00, 5.00};


    static public String villeDepart;
    static public String villeArrivé;
    static public String [] ligneBus;
    static public double [] tarif;

    // Methode pour recuperer la ligne utilisé pour le trajet
    static public void recupereLigne(){
        int reponse;
        // Boucle pour verifier que la saisie est conforme a ce qui est attendu
        do{
            System.out.print("Quelle ligne sera emprunter? (1/2) : ");
            reponse = scanner.nextInt();
            scanner.nextLine();

        } while (reponse != 1 && reponse != 2);
        // Assignation des villes desservies par le bus et les tarifs
        if (reponse == 1) {
            ligneBus = ligne1Ville;
            tarif = tab1Prix;
        } else{
            ligneBus = ligne2Ville;
            tarif = tab2Prix;
        }

    }

    // Methode pour recuperer les informations du trajet
    static public void recupererItineraire(){
        System.out.print("Entrez la ville de depart: ");
        villeDepart = scanner.nextLine();
        System.out.print("Entrez la ville d'arrivé: ");
        villeArrivé = scanner.nextLine();

    }    

    // Methode qui calcul le prix du trajet en fonction de la ville de depart et d'arrivé
    static public void calculerPrixTrajet(){

        // Stock l'indice des troncons pour le prix
        int indiceVilleDepart = 0;
        int indiceVilleArrive = 0;
        // Stock le resultat de la recherche des 2 villes dans le tableau
        boolean villeDepartTrouvé = false;
        boolean villeArrivéTrouvé = false;
        // 
        double prixTrajet = 0;

        // Boucle for pour rechercher les villes dans le tableau
        for(int i = 0; i<ligneBus.length; i++){
            if(villeDepart.equalsIgnoreCase(ligneBus[i])){
                villeDepartTrouvé = true;
                indiceVilleDepart =  i;
            }
            if(villeArrivé.equalsIgnoreCase(ligneBus[i])){
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
            for(int i = indiceVilleDepart ; i < indiceVilleArrive; i++){ // sens aller
                prixTrajet += tarif[i];
            }
        }else {
            for(int i = indiceVilleArrive   ; i < indiceVilleDepart; i++){ // sens retour
                prixTrajet += tarif[i];
            }
        }
        
        // Affichage du prix
        System.out.println("Prix du trajet: "+prixTrajet);
    }

    // Methode qui applique une promotion de 10% a chaque troncon ajouter au trajet
    static public void calculerReductionTrajet(){

        // Stock l'indice des troncons pour le prix
        int indiceVilleDepart = 0;
        int indiceVilleArrive = 0;
        // Stock le resultat de la recherche des 2 villes dans le tableau
        boolean villeDepartTrouvé = false;
        boolean villeArrivéTrouvé = false;
        // 
        double prixTrajet = 0;

        // Boucle for pour rechercher les villes dans le tableau
        for(int i = 0; i<ligneBus.length; i++){
            if(villeDepart.equalsIgnoreCase(ligneBus[i])){
                villeDepartTrouvé = true;
                indiceVilleDepart =  i;
            }
            if(villeArrivé.equalsIgnoreCase(ligneBus[i])){
                villeArrivéTrouvé = true;
                indiceVilleArrive =  i;
            }
        }

        // Arret du programme si la ville de depart et d'arrivé ne sont pas trouvé
        if(villeDepartTrouvé == false || villeArrivéTrouvé == false){
            System.out.println("Le trajet est invalide");
            return;
        }
        
        // Stock le % de reduction et augmente la taille de la reduction a chaque troncon
        double reduction=1; 
        // Calcul du prix du trajet
        if (indiceVilleDepart < indiceVilleArrive) {
            for(int i = indiceVilleDepart ; i < indiceVilleArrive; i++){ // sens aller
                prixTrajet += tarif[i]*reduction;
                reduction = Math.max(0, reduction-0.1);
            }
        }else {
            for(int i = indiceVilleArrive   ; i < indiceVilleDepart; i++){ // sens retour
                prixTrajet += tarif[i]*reduction;
                reduction = Math.max(0, reduction-0.1) ;

            }
        }
        
        // Affichage du prix
        System.out.println("Prix du trajet: "+prixTrajet);
    }

    

    public static void main(String[]args){
        recupereLigne();
        recupererItineraire();
        calculerPrixTrajet();
    }

}