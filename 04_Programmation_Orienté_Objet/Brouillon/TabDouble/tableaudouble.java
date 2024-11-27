public class tableaudouble {
    public static void main(String[] args) {
        // Tableau qui comportent les tonnes de bateau coulés et les tonnes de bateaux construits de 1939 à 1945
        int[][] tonnage = { { 810, 332 }, { 4407, 1219 }, { 4398, 1964 }, { 8245, 7182 }, { 3611, 14585 },
                { 1422, 13349 }, { 451, 3834 } };

        // Calcul du tonnage total coulés
        int total = 0;
        for (int j = 0; j < tonnage.length; j++) {
            total += tonnage[j][0];
        }

        // Calcul de l'ecart entre la production et la destruction de bateau sur les 7 années de la guerre
        int[] delTab = new int[7];
        for (int i = 0; i < tonnage.length; i++) {
            int deltaTonnageAnnuel = tonnage[i][1] - tonnage[i][0];
            delTab[i] = deltaTonnageAnnuel;
        }
        for(int i =0; i<delTab.length; i++){
            System.out.println("Variation du tonnage en " + (1939 + i) + ": " +delTab[i]);
        }
    }
}
