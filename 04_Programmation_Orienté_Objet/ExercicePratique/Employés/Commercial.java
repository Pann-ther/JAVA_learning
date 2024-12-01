public class Commercial extends Employés {
    private static double interessement = 0.05;
    private double ventesMensuel;

    public Commercial(String nom, String matricule, double indiceSalarial, double ventesMensuel) {
        super(nom, matricule, indiceSalarial);
        this.ventesMensuel = ventesMensuel;
        calculerSalaire();
    }

    public double getInteressement() {
        return interessement;
    }

    public double getVentesMensuel() {
        return ventesMensuel;
    }

    public void setInteressement(double interessement) {
        this.interessement = interessement;
        calculerSalaire();
    }

    public void setVentesMensuel(double ventesMensuel) {
        this.ventesMensuel = ventesMensuel;
        calculerSalaire();
    }

    public void calculerSalaire() {
        salaire = (indiceSalarial * salaireBase) + (interessement * ventesMensuel);
    }

    public String toString() {
        return "Nom: " + nom + ", matricule: " + matricule + ", interessement: " + (interessement * 100) + "%, ventes mensuel: " + ventesMensuel + "€, salaire: "
                + salaire + "€";
    }
}
