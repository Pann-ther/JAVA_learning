public class Main {
    public static void main(String[] args) {
        Personne personne1 = new Personne("Kylian",22);
        System.out.println(personne1.getNom()+" "+personne1.getAge()+" ans");
        personne1.setNom("Charles");
        System.out.println(personne1.getNom()+" "+personne1.getAge()+" ans");

    }
}
