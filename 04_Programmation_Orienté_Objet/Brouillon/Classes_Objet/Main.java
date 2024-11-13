public class Main{
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture("Toyota", "Yaris GR", 2023, 261);
        maVoiture.afficherCaracteristique();
        System.out.println(maVoiture.getMarque());
    }
}