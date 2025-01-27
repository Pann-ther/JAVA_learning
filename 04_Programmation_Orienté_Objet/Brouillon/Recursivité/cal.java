public class ErreurParametre extends Exception {
    public ErreurParametre(String message) {
        super(message);
    }
}

public class cal {
    public static int x(int n){
        if (n == 0) {
            return 1;
        }
        return 2*y(n-1)-x(n-1);
    }
    public static int y(int n){
        if (n == 0) {
            return 1;
        }
        return 2*x(n-1)-y(n-1);
    }
    public static boolean testPair(int n){
        if (n == 0) {
            return true;
        } else if (n == 1){
            return false;
        }
        return testImpair(n-1);
    }

    public static boolean testImpair(int n){
        if (n == 0) {
            return false;
        } else if (n == 1){
            return true;
        }
        return testPair(n-1);
    }
    public static void valeurNegative(String message, double n) throws ErreurParametre {
        if (n < 0) {
            throw new ErreurParametre(message);
        }
    }

    public static int factorielle(int n) throws ErreurParametre{
        valeurNegative("La valeur ne peut pas etre negative", n);
        if (n == 0) {
            return 1;
        }

        return factorielle(n - 1) * n;
    }

    public static double augmentation(double salaire, double taux, int annee) throws ErreurParametre {
        valeurNegative("Le nb d'année ne peut pas etre negatif", annee);
        if (annee == 0) {
            return salaire;
        }
        return augmentation(salaire * (1 + taux), taux, annee - 1);
    }

    public static double seche(double poids, double deficit, int semaines) throws ErreurParametre{
        valeurNegative("le nombre de semaine ne peut pas etre negatif", semaines);
        if (semaines == 0) {
            return poids;
        }
        return seche(poids - ((deficit * 7) / 7700), deficit, semaines - 1);
    }

    public static void main(String[] args) {
        try {
            System.out.println(factorielle(5));
            System.out.println(augmentation(30000, 0.036, 5));
            System.out.println(seche(109.3, 1000, 10));
            System.out.println(testImpair(12));
            System.out.println(x(10));
        } catch (ErreurParametre e) {
            System.out.println(e.getMessage());
        }

    }
}
