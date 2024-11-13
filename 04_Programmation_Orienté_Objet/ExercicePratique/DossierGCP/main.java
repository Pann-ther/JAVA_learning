public class main {
    public static void main(String[] args) {
        DossierCandidatureGCP candidat1 = new DossierCandidatureGCP("Chebbah", "123 456 789");
        candidat1.enregistrementEmargementEpreuveEcrite();
        candidat1.enregistrerNoteEpreuveEcrite(11);
        candidat1.publierResultatFinal();
        System.out.println(candidat1.toString());
    }
}
