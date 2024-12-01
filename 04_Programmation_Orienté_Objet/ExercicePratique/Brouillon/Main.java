public class Main {
    public static void main(String[] args) {
        CompteDecouvert compte1 = new CompteDecouvert("Kylian");
        System.out.println(compte1.toString());
        compte1.deposer(1500);
        compte1.retirer(2001);
    }
}
