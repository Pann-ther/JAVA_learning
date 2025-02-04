public class Longeres {
    private String piece;
    private int ordre;
    private Longeres pieceSuivante;

    public Longeres(String piece, int ordre, Longeres pieceSuivante){
        this.piece = piece;
        this.ordre = ordre;
        this.pieceSuivante = pieceSuivante;
    }

    public int getOrdre() {
        return ordre;
    }

    public String getPiece() {
        return piece;
    }

    public Longeres getPieceSuivante() {
        return pieceSuivante;
    }

    public void afficher() {
        Longeres piece = this;
        while (piece != null) {
            System.out.print(piece.getPiece()+" ");
            if (piece.getOrdre()>0) {
                System.out.print(piece.getOrdre());
            }
            if (piece.getPieceSuivante() != null) {
                System.out.print(", ");
            }
            piece = piece.getPieceSuivante();
        }
    }

}




