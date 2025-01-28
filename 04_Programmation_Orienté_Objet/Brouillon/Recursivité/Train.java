public class Train {
    private int numero;
    private Arret premierArret;

    public Train(int numero, Arret premierArret){
        this.numero = numero;
        this.premierArret = premierArret;
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
        while (arret != null) {
            total++;
            arret = arret.getProchaineArret();
        }
        return total;
    }

    public String heurePassage(String gare){
        Arret arret = premierArret;
        while (arret != null) {
            if (gare.equals(arret.getArret())) {
                return "Le train passera à "+arret.getHeure()+" en gare de "+arret.getArret();
            }
            arret = arret.getProchaineArret();
        }return "Le train ne passe pas a cette gare";
    }

    public void enregistrerRetard(int retard){
        Arret arret = premierArret;
        while (arret != null) {
            System.out.println(arret.getHeure());
            Heure heure = arret.getHeure();
            heure.ajouterRetard(retard);
            System.out.println(arret.getHeure());
            arret = arret.getProchaineArret();
        }
    }
}
