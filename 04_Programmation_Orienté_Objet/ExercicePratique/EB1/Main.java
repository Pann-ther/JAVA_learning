public class Main{
    public static void main(String[]args){
        /* 
        Adresse ad1 = new Adresse(8,"rue de la galmy",77700,"Chessy");
        Adresse ad2 = new Adresse(6,"rue de la galmy",20000,"Chessy");
        Adresse ad3 = new Adresse(8,"rue de la galmy",77400,"Chessy");
        Lettre lettre1 = new Lettre(ad1, 3.60, 2.20);
        Lettre lettre2 = new Lettre(ad2, 3.60, 2.20);
        Lettre lettre3 = new Lettre(ad3, 3.60, 2.20);
        
        SacLettres sac1 = new SacLettres();
        sac1.ajouterLettre(lettre1);
        sac1.ajouterLettre(lettre2);
        sac1.ajouterLettre(lettre3);
        System.out.println(sac1.memeCP());
        */
        Curiosite c1 = new Curiosite("Pompe a essence", 114, null);
        Curiosite c2 = new Curiosite("Belvedere de la sievre", 57, c1);
        Curiosite c3 = new Curiosite("Eglise saint-Martin", 12, c2);

        c3.afficherCuriosite();
        Recurse cl1 = new Recurse();
        System.out.println(cl1.somme(5));
        System.out.println(cl1.facto(5));
        
    }
}
