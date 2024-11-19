public class PersonneMain {

    public static void main(String[] args) {
        Personne personne1 = new Personne("John", "Doe", "1801213012345 67", "06 12 34 56 78");
        Personne personne2 = new Personne("Lea", "Morel", "2920938435678 23", "07 89 45 23 67");
        Personne personne3 = new Personne("Thomas", "Durant", "2030547098765 91", "06 98 76 54 32");
        System.out.println(personne1.toString());
        System.out.println(personne2.toString());
        System.out.println(personne3.toString());
        personne1.setNumeroTel("07 40 30 10 20");
        personne2.setNumeroTel("06 50 60 70 80");
        personne3.setNumeroTel("07 10 55 34 23");
        System.out.println("-----Changement numero de telephone-----");
        System.out.println(personne1.toString());
        System.out.println(personne2.toString());
        System.out.println(personne3.toString());
        System.out.println(personne1.aMemeNomQue(personne2));
    }

}
