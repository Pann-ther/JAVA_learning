import java.util.Scanner;

public class CribleErathostène{

    //
	static Scanner scanner = new Scanner(System.in); // Creation du scanner
	static int dernierEntier; // Declaration de la variable qui determinera la taille du tableau
	static boolean [] tab; // Declaration du tableau

    // Methode capture l'entrer utilisateur et la stocker
	public static void entrerUtilisateur(){
        int input;
        do{
            System.out.print("Entrer un entier: "); 
		    dernierEntier = scanner.nextInt();
        }while (dernierEntier < 2);
		
	}

    // Methode qui initialise le tableau
	public static void initialiserTab(){
		tab = new boolean[dernierEntier +1];
        for(int i=0; i<dernierEntier; i++){
            tab[i]=false;
        }

	}

    // Methode qui utilise une Boucle for pour verifier si les nombres du tableau sont des multiples
	public static void crible(){
		
        for(int i = 2; i <=Math.sqrt(dernierEntier); i++){
            if (!tab[i]) { // Si le nombre n'est pas marqué
                for(int j = i*i; j <= dernierEntier; j+= i){
                tab[j]=true;
            }
            }
            
        }
	}

    // Methode qui affiche si le nombre est premier ou pas
    public static void afficherNombresPremiers(){
        for(int i=2; i<tab.length; i++){
            if (tab[i] == true) { // Si le nombre est marqué
                System.out.println(i+"  n'est pas un nombre premier");
            }else{
                System.out.println(i+" est un nombre premier");
            }
        }
    }

	public static void main(String[]args){
        entrerUtilisateur();
        initialiserTab();
        crible();
        afficherNombresPremiers();
	}
}
