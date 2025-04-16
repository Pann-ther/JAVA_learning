import java.util.ArrayList;

public class SacLettres {
    ArrayList<Lettre> sacLettres;

    public SacLettres() {
        sacLettres = new ArrayList<>();
    }

    public void ajouterLettre(Lettre l) {
        sacLettres.add(l);
    }

    public boolean memeCP() {
        int cp = sacLettres.get(0).getAdresse().getCodePostal();
        System.out.println(cp);

        for (Lettre l : sacLettres) {
            if (l.getAdresse().getCodePostal() != cp) {
                return false;
            }
        }
        return true;
    }
}



