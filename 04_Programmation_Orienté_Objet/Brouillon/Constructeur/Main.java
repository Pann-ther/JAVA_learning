public class Main {

    public static void main(String[] args) {
        Livre roman = new Livre("Jamais Plus","Coleen Hoover",6.80);
        Livre manga = new Livre("My Hero Academia","Hohei Horikoshi");
        roman.afficherDetails();
        manga.afficherDetails();
    }
    
}
