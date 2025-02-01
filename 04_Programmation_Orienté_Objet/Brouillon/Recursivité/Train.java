public class Train {
    private int numero;
    private Arret premierArret;

    public Train(int numero, Arret premierArret){
        this.numero = numero;
        this.premierArret = premierArret;
    }

    public void ajouterArretDebut(String nouvelleGare, Heure heure){
        Arret nouveau = new Arret(nouvelleGare,heure, premierArret);
        premierArret = nouveau;
    }

    public void ajouterArretFin(String nouvelleGare, Heure heure){
        Arret nouveau = new Arret(nouvelleGare,heure, null);
        if (premierArret == null) {
            premierArret = nouveau;
        } else {
            Arret arr = premierArret;
            while (arr.getProchaineArret() != null) {
                arr = arr.getProchaineArret();
            }
            arr.setProchaineArret(nouveau);
        }
    }

    public void supprimerArret(String arretSupprime){
        Arret arr = premierArret; 
        Arret aPrecedent = null; // Stock l'arret qui precede celui a supprimé
        while (arr != null) {
            if (arr.getArret().equalsIgnoreCase(arretSupprime)) {
                if (aPrecedent == null) {
                    premierArret = arr.getProchaineArret();
                    break;
                } else {
                    aPrecedent.setProchaineArret(arr.getProchaineArret());
                    break;
                }
            }
            aPrecedent = arr;
            arr = arr.getProchaineArret();
        }
    }

    public void afficher(){
        Arret arret = premierArret;
        System.out.println("Train "+numero);
        while(arret != null){
            System.out.println(arret.getArret()+" "+arret.getHeure());
            arret = arret.getProchaineArret();
        }
    }

    public int nbArret(){
        Arret arret = premierArret;
        int total =0;
        total = arret.nbGares();
        return total;
    }

    public String heurePassage(String gare){
        Arret arret = premierArret;
        while (arret != null) {
            if (gare.equals(arret.getArret())) {
                return "Le train passera à "+arret.getHeure()+" en gare de "+arret.getArret();
            }
            arret = arret.getProchaineArret();
        }return "Le train ne passe pas en gare de "+ gare;
    }

    public void enregistrerRetard(int retard){
        Arret arret = premierArret;
        while (arret != null) {
            Heure heure = arret.getHeure();
            heure.ajouterRetard(retard);
            arret = arret.getProchaineArret();
        }
    }
}
