public class Main {
    public static void main(String[] args) {
        try {
            Employés employé1 = new Employés("John Doe", "12345", 2);
            Employés employé2 = new Employés("Janne Su", "234", 2);
            Commercial commercial1 = new Commercial("Barry Stone", "200", 2, 40000);
            Commercial commercial2 = new Commercial("Pitt Altor", "400", 2, 25000);
            Personnel liste = new Personnel();
            liste.ajouterEmploye(employé1);
            liste.ajouterEmploye(employé2);
            liste.ajouterEmploye(commercial1);
            liste.ajouterEmploye(commercial2);
            System.out.println(liste.salairePersonnel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
