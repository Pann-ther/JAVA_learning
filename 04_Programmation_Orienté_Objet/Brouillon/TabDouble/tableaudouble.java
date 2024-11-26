public class tableaudouble {
    public static void main(String[] args) {
        String[][] tab;
        tab = new String[2][];
        tab[0] = new String[4];
        tab[1] = new String[4];
        tab[0][0] = "--Pina Colada--";
        tab[0][1] = "Jus d'ananas";
        tab[0][2] = "Lait coco";
        tab[0][3] = "Sucre";
        tab[1][0] = "--Pina Pola--";
        tab[1][1] = "Jus d'ananas";
        tab[1][2] = "Lait coco";
        tab[1][3] = "Sucre";
        for (int j = 0; j < tab.length; j++) {
            for (int i = 0; i < tab[j].length; i++) {
                System.out.println(tab[j][i]);
            }
        }
    }
}
