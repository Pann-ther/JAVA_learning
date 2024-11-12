public class Main {
    public static void main(String[] args) {
       //CompteBancaire client1 = new CompteBancaire("Kylian Chebbah");
       //System.out.println(client1.toString());

       CompteBancaire client2 = new CompteBancaire("Ursula Chebbah");
       client2.deposer(1000);
       client2.retirer(500);
       System.out.println(client2.toString());

    }
}
