public class JeuCartesMain {
    public static void main(String[] args) {
        JeuCartes carte1 = new JeuCartes("Coeur",13);
        JeuCartes carte2 = new JeuCartes("Pique",14);
        System.out.println(carte1.getCouleur());
        System.out.println(carte2.getValeur());
        System.out.println(carte2.plusForte(carte1).toString());
        System.out.println(carte1.toString());
        System.out.println(carte2.toString());
    }
}
