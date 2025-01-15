import javax.swing.ImageIcon;

import mahjong.gui.IGMahjong;
public class TestFenetre {
    public static void main(String[] args) {
        IGMahjong fenetre = new IGMahjong(true);
        fenetre.setMessage("Bonjour");
        fenetre.ajouterTuile(new ImageIcon("../images/BAMBOU_4.png"), 0,0,0);
        fenetre.ajouterTuile(new ImageIcon("../images/BAMBOU_4.png"), 0,1,0);
        fenetre.retirerPaire(0, 0, 0, 0, 1, 0);
    }
}
