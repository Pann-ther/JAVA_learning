public class ResultatTirageTuiles {

    // Messages predefinis en fonction du resultat du tirage
    private String valide = "La paire de tuiles est valide: elle a été retirée du plateau";
    private String pasJouable = "La paire de tuiles n'est pas jouable, elle est bloquée par les tuiles adjacentes \nElle n'a pas été retirée du plateau";
    private String pasRetirable = "La paire de tuiles n'est pas valide, les tuiles ne sont pas de même symbole ou ont été sélectionné en double \nElle n'a pas été retirée du plateau";
    private String caseVide = "La case selectionnée est vide";
    private Resultat resultat;

    public ResultatTirageTuiles(){
    }

    // Valeurs acceptés pour le resultat
    public enum Resultat{
        VALIDE, PAS_JOUABLE, PAS_RETIRABLE, VIDE
    }

    // Donne le resultat du tirage
    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public String getMessage(){
        return switch (resultat) {
            case VALIDE -> valide;
            case PAS_JOUABLE -> pasJouable;
            case PAS_RETIRABLE -> pasRetirable;
            case VIDE -> caseVide;
        };
    }
}