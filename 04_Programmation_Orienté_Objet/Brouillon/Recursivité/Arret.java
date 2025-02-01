public class Arret {
    private String arret;
    private Heure heure;
    private Arret prochaineArret;

    public Arret(String arret, Heure heure, Arret prochaineArret){
        this.arret = arret;
        this.heure = heure;
        this.prochaineArret = prochaineArret;
    }

    public String getArret() {
        return arret;
    }

    public Heure getHeure() {
        return heure;
    }

    public Arret getProchaineArret() {
        return prochaineArret;
    }

    public void setProchaineArret(Arret as){
        prochaineArret = as;
    }

    public String toString() {
        if (getProchaineArret() == null) {
            return "Arret: "+ arret+", heure d'arrivée: "+heure+", Terminus";
        }
        return "Arret: "+ arret+", heure d'arrivée: "+heure+", prochaine arret: "+prochaineArret;
    }

    public void afficher(){
        System.out.println(this.toString());
        if (prochaineArret != null) {
            prochaineArret.afficher();
        }
    }

    public int nbGares(){
        if (prochaineArret == null) {
            return 1;
        }
        return 1 + prochaineArret.nbGares();
    }
}
