public class Damier {

    public static int auSortOnze() {
        return (int) (Math.random() * 11); // Retourne un nombre aléatoire entre 0 et 10
    }

    public static int auSortQuatre() {
        return (int) (Math.random() * 4);
    }

    public static void afficherDamier(char[][] tab) {
        for (int i = 0; i < 13; i++) {
            System.out.print("# ");
        }
        System.out.println();
        for (int i = 0; i < tab.length; i++) {
            System.out.print("# ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.print("#");
            System.out.println();
        }
        for (int i = 0; i < 13; i++) {
            System.out.print("# ");
        }
    }

    public static char[][] initDamier(int lignes, int colonnes) {
        char[][] tab = new char[lignes][colonnes]; // Initialisation correcte du tableau

        // Remplissage du damier avec des espaces et une case spécifique
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (j == 5 && i == 5) {
                    tab[5][5] = '2'; // Case centrale initialisée avec '2'
                } else {
                    tab[i][j] = ' '; // Les autres cases sont initialisées avec un espace
                }
            }
        }

        int nbNoisettes = 0;
        // Placement des "ô" sur le damier
        while (nbNoisettes < 25) {
            int coordX = auSortOnze();
            int coordY = auSortOnze();
            if (tab[coordX][coordY] != 'ô' && tab[coordX][coordY] != '2') {
                tab[coordX][coordY] = 'ô'; // Placer un "ô" dans une case vide
                nbNoisettes++;
            }
        }

        return tab; // Retourner le damier
    }

    public static void deplacerEcureuil(char[][] tab) {
        int deplacement = auSortQuatre();

        int x = -1;
        int y = -1;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == '2') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        switch (deplacement) {
            case 0:
                if (x > 0) {
                    tab[x][y] = ' ';
                    tab[x - 1][y] = '2';
                }
                break;
            case 1:
                if (y < tab[x].length - 1) {
                    tab[x][y] = ' ';
                    tab[x][y + 1] = '2';
                }
                break;
            case 2:
                if (x < tab.length - 1) {
                    tab[x][y] = ' ';
                    tab[x + 1][y] = '2';
                }
                break;
            case 3:
                if (y > 0) {
                    tab[x][y] = ' ';
                    tab[x][y - 1] = '2';
                }
                break;
        }
    }

    public static boolean resteNoisettes(char[][] tab){
        for(int i=0; i<tab.length; i++){
            for(int j=0; j<tab[i].length; j++){
                if (tab[i][j] == 'ô') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        char[][] damier = initDamier(11, 11); // Initialisation d'un damier de 11x11
        boolean resteDesNoisettes = true;
        // Affichage du damier 
        afficherDamier(damier);
        while (resteDesNoisettes) {
            Thread.sleep(10);
            deplacerEcureuil(damier);
            System.out.println();
            afficherDamier(damier);
            resteDesNoisettes = resteNoisettes(damier);
            Thread.sleep(10);
        }
    }
}
