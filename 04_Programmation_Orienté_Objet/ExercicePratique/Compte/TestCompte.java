public class TestCompte {
    public static void main (String[]args){
		Compte[] comptes = new Compte[10];
		for(int i = 0; i<comptes.length; i++){
			comptes[i] = new Compte("Charles Doe");
			comptes[i].deposer(200);
			int depotIndice = i * 100;
			comptes[i].deposer(depotIndice);
			System.out.println("Compte "+(i+1)+" "+comptes[i].toString());
        }

        Compte compte11 = new Compte("John Doe");
        System.out.println("Compte 11 "+compte11.toString());
	}
}