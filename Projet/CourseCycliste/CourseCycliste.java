import java.util.Scanner;

public class CourseCycliste {

    public static void main(String[] args) {
        String[][] listeCoureurs = new String[50][3];
        String[][] listeArrivees = new String[50][2];
        String[][] listeAbandons = new String[50][2];
        String[][] listeDisqualification = new String[50][2];
        enregistrerCoureurs(listeCoureurs);
        gestionCourse(listeCoureurs, listeArrivees, listeAbandons, listeDisqualification);
    }

    // Enregistre le numero de brassard et les noms des coureurs dans la liste
    private static void enregistrerCoureurs(String[][] listeCoureurs) {
        System.out.println("---------------Enregistrement des coureurs---------------");
        String plusDeCoureurs = "";
        String nomCoureur = "";
        int numeroCoureur = 1;
        do {
            nomCoureur = lectureString("Entrez le nom du coureur: ", "Erreur: entrez une chaine de caractere");
            listeCoureurs[numeroCoureur - 1][0] = String.valueOf(numeroCoureur);
            listeCoureurs[numeroCoureur - 1][1] = nomCoureur;
            numeroCoureur++;
            plusDeCoureurs = lectureString("Souhaitez-vous entrer d'autres coureurs (O/N) ?: ",
                    "Erreur: entrez une chaine de caractere");
        } while (!plusDeCoureurs.equalsIgnoreCase("n"));
        afficherListeCoureurs(listeCoureurs);
    }

    private static void gestionCourse(String[][] listeCoureurs, String[][] listeArrivee, String[][] listeAbandons, String[][] listeDisqualification) {
        int choixMenu = -1;
        boolean finProgramme = false;
        while (!finProgramme) {
            System.out.println("---------------Menu gestion de la course---------------");
            afficherMenu();
            choixMenu = lectureChoix(1, 4);
            switch (choixMenu) {
                case 1 -> gestionEvenement(listeCoureurs, listeArrivee, listeAbandons, listeDisqualification);
                case 2 -> afficherResultatCourse(listeArrivee, listeAbandons, listeDisqualification);
                case 3 -> afficherListeCoureurs(listeCoureurs);
                case 4 -> finProgramme = true;
            }
        }
    }

    private static void gestionEvenement(String[][] listeCoureurs, String[][] listeArrivee, String[][] listeAbandons, String[][] listeDisqualification) {
        int numeroDossard = -1;
        boolean plusDeCoureurs = false;
        System.out.println("---------------Gestion des Evenements---------------");
        afficherListeCoureurs(listeCoureurs);
        while (!plusDeCoureurs){
            
            System.out.println("Entrez le numero de dossard du coureur concerné");
            numeroDossard = lectureChoix(1, calculerNbCoureurs(listeCoureurs));
            int choixEnregistrement = -1;
            afficherEvenements();
            choixEnregistrement = lectureChoix(1,3);
            enregistrerEvenement(choixEnregistrement, numeroDossard, listeCoureurs, listeArrivee, listeAbandons, listeDisqualification);
            String reponse = lectureString("Avez-vous d'autres coureurs à enregistrer (O/N)?: " , "Erreur: entrez une chaine de caractere");
            afficherResultatCourse(listeArrivee, listeAbandons, listeDisqualification);
            if (reponse.equalsIgnoreCase("N")) {
                plusDeCoureurs = true;
            }
        }
    }

    private static void enregistrerEvenement(int choixEnregistrement,int numeroDossard, String[][] listeCoureurs, String[][] listeArrivee, String[][] listeAbandons, String[][] listeDisqualification) {
        switch (choixEnregistrement) {
            case 1 -> enregistrerArrivee(numeroDossard, listeCoureurs, listeArrivee);
            case 2 -> enregistrerAbandon(numeroDossard, listeCoureurs, listeAbandons);
            case 3 -> enregistrerDisqualification(numeroDossard, listeCoureurs, listeDisqualification, listeArrivee);
        }
    }

    private static void enregistrerArrivee(int numeroDossard, String[][] listeCoureurs, String[][] listeArrivee) {
        int indexCoureur = numeroDossard -1;
        if (listeCoureurs[indexCoureur][2]  == null) {
            for(int i =0; i< listeCoureurs.length ; i++){
                if(listeArrivee[i][0]  == null && listeArrivee[i][1] == null){
                    listeArrivee[i][0] = listeCoureurs[indexCoureur][0];
                    listeArrivee[i][1] = listeCoureurs[indexCoureur][1];
                    listeCoureurs[indexCoureur][2] = "Arrivée";
                    return;
                }
            }
        } else {
            System.out.println("Ce coureur a déja été enregistré: "+listeCoureurs[indexCoureur][2]);
        }
    }

    private static void enregistrerAbandon(int numeroDossard, String[][] listeCoureurs, String[][] listeAbandon) {
        int indexCoureur = numeroDossard -1;
        if (listeCoureurs[indexCoureur][2] == null) {
            for(int i =0; i< listeCoureurs.length ; i++) {
                if(listeAbandon[i][0] == null && listeAbandon[i][1] == null){
                    listeAbandon[i][0] = listeCoureurs[indexCoureur][0];
                    listeAbandon[i][1] = listeCoureurs[indexCoureur][1];
                    listeCoureurs[indexCoureur][2] = "Abandon";
                    return; 
                }
            }
        } else {
            System.out.println("Ce coureur a déja été enregistré: "+listeCoureurs[indexCoureur][2]);
        }
    }

    private static void enregistrerDisqualification(int numeroDossard, String[][] listeCoureurs, String[][] listeDisqualification, String[][] listeArrivee) {
        int indexCoureur = numeroDossard -1;
        if (listeCoureurs[indexCoureur][2] == null ) {
            enregistrerDansDisqualification(listeCoureurs, listeDisqualification, indexCoureur);
            return;  
        } else if (listeCoureurs[indexCoureur][2].equals("Arrivée")) {
            enregistrerDansDisqualification(listeCoureurs, listeDisqualification, indexCoureur);
            retirerDeClassement(listeCoureurs,listeArrivee, indexCoureur);
        } else {
            System.out.println("Ce coureur a déja été enregistré: "+listeCoureurs[indexCoureur][2]);
        }
    }

    // Enregistre un coureur dans la liste des disqualifiés
    private static void enregistrerDansDisqualification(String[][] listeCoureurs, String[][] listeDisqualification, int indexCoureur) {
        for (int i = 0; i < listeCoureurs.length; i++) {
            if (listeDisqualification[i][0] == null && listeDisqualification[i][1] == null) {
                listeDisqualification[i][0] = listeCoureurs[indexCoureur][0];
                listeDisqualification[i][1] = listeCoureurs[indexCoureur][1];
                listeCoureurs[indexCoureur][2] = "Disqualifié";
                return;
            }
        }
    }

    private static void reorganisationClassement(String[][] listeArrivee, int indiceCoureurSupprime){
        for(int i=indiceCoureurSupprime; i<listeArrivee.length; i++){
            if(listeArrivee[i+1][0] != null){
                listeArrivee[i][0] = listeArrivee[i+1][0];
                listeArrivee[i][1] = listeArrivee[i+1][1];
            } else {
                listeArrivee[i][0] = null;
                listeArrivee[i][1]= null;
                return;
            }
        }
    }

    // Retire un coureur de la liste d'arrivée et réorganise le classement
    private static void retirerDeClassement(String[][] listeCoureurs, String[][] listeArrivee, int indexCoureur) {
        for (int j = 0; j < listeArrivee.length; j++) {
            if (listeArrivee[j][0].equals(listeCoureurs[indexCoureur][0])) {
                listeArrivee[j][0] = null;
                listeArrivee[j][1] = null;
                reorganisationClassement(listeArrivee, j);
                return;
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("1: Enregistrer un évenement");
        System.out.println("2: Consulter les resultats de la course");
        System.out.println("3: Consulter la liste des coureurs");
        System.out.println("4: Terminer le programme");
        System.out.print("Votre choix: ");
    }

    private static void afficherEvenements() {
        System.out.println("1: Enregistrer une arrivée");
        System.out.println("2: Enregistrer un abandon");
        System.out.println("3: Enregistrer une disqualification");
        System.out.println("4: Retourner au menu");
        System.out.print("Votre choix: ");
    }

    private static void afficherListeCoureurs(String[][] listeCoureurs) {
        System.out.println("-----Liste des coureurs-----");
        for (int i = 0; i < listeCoureurs.length; i++) {
            if (listeCoureurs[i][0] != null && listeCoureurs[i][1] != null) {
                System.out.println("Dossard " + listeCoureurs[i][0] + ": " + listeCoureurs[i][1]);
            }else{
                return;
            }
        }
    }

    private static void afficherResultatCourse(String[][] listeArrivee, String[][] listeAbandons, String[][] listeDisqualification){
        afficherClassement(listeArrivee);
        afficherAbandons(listeAbandons);
        afficherDisqualification(listeDisqualification);
    }

    private static void afficherClassement(String[][] listeArrivee){
        System.out.println("-----Classement de la course-----");
        for (int i = 0; i < listeArrivee.length; i++) {
            if (listeArrivee[i][0] != null && listeArrivee[i][1] != null) {
                System.out.println("Position "+(i+1)+" Dossard " + listeArrivee[i][0] + ": " + listeArrivee[i][1]);
            }else{
                return;
            }
        }
    }

    private static void afficherAbandons(String[][] listeAbandons){
        System.out.println("-----Abandons-----");
        for (int i = 0; i < listeAbandons.length; i++) {
            if (listeAbandons[i][0] != null && listeAbandons[i][1] != null) {
                System.out.println("Dossard " + listeAbandons[i][0] + ": " + listeAbandons[i][1]);
            }else{
                return;
            }
        }
    }

    private static void afficherDisqualification(String[][] listeDisqualification){
        System.out.println("-----Disqualification-----");
        for (int i = 0; i < listeDisqualification.length; i++) {
            if (listeDisqualification[i][0] != null && listeDisqualification[i][1] != null) {
                System.out.println("Dossard " + listeDisqualification[i][0] + ": " + listeDisqualification[i][1]);
            }else{
                return;
            }
        }
    }

    

    private static int calculerNbCoureurs(String[][] listeCoureurs){
        int nbCoureurs = 0;
        for (int i = 0; i < listeCoureurs.length; i++) {
            if (listeCoureurs[i][0] != null && listeCoureurs[i][1] != null) {
                nbCoureurs++;
            } else {
                break ;
            }
        }
        return nbCoureurs;
    }

    private static String lectureString(String messageUtilisateur, String messageErreur) {
        String entree = "";
        boolean estCorrect = false;
        Scanner lecture = new Scanner(System.in);
        do {
            System.out.print(messageUtilisateur);
            entree = lecture.nextLine();
            if (!entree.trim().isEmpty() || !entree.matches("\\d+")) {
                estCorrect = true;
            } else {
                System.out.println(messageErreur);
                lecture.nextLine();
            }
        } while (!estCorrect);
        return entree;
    }

    private static int lectureChoix(int minimum, int maximum) {
        int entree = -1;
        boolean estCorrect = false;
        Scanner lecture = new Scanner(System.in);
        do {
            try {
                entree = lecture.nextInt();
                if (entree >= minimum && entree <= maximum) {
                    estCorrect = true;
                } else {
                    System.out.println("Erreur: faites un choix valide en saissisant un des nombres proposé");
                lecture.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Erreur: faites un choix valide en saissisant un des nombres proposé");
                lecture.nextLine();
            }
        } while (!estCorrect);
        return entree;
    }
}