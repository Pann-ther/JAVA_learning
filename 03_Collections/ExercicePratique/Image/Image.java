import java.util.Scanner;
public class Image{
	static Scanner scan = new Scanner(System.in);

    // Permet a l'utilisateur de saisir son image
    public static int[] saisirImage (){
        int taille = lireEntier("Entrez le taille de votre image: ");
        int[] image = new int[taille];
        for(int i=0; i<image.length; i++){
            System.out.println("Point "+(i+1)+" sur "+taille);
            image[i] = niveauGris();
        }
        return image;
    }

    // Permet a l'utilisateur de specifié le niveau de gris de chaque point
	public static int niveauGris(){
		int niveau = 0;
		do{
			niveau = lireEntier("Entrez le niveau de gris du point: ");
		} while (niveau < 0 || niveau > 255);
		return niveau;
	}
	
    // Calcul le % de point blanc dans l'image
	public static double pourcentagePointBlanc (int[] image){
		double nbPoint = 0;
		double nbPointBlanc = 0;
		for(int i=0; i<image.length; i++){
			nbPoint ++;
			if(image[i] == 255){
				nbPointBlanc ++;
			}
		}
		return (nbPointBlanc/nbPoint)*100;
	}

    // Gere l'eclaircissement de l'image
	public static void eclaircissement(int[] image){
		for(int i=0; i<image.length; i++){
			if(image[i]<= 225){
				image[i] += 30;
			} else {
				image[i] = 255;
			}
		} 
        System.out.println("Voila l'image après eclaircissement");
		for(int i=0; i<image.length; i++){
            System.out.print(image[i]+" ");
        }
	}

    // Gere les entrées utilisateur de type int
	public static int lireEntier(String msg){
		int input = 0;
		boolean correct = false;
		do{
			try{
				System.out.print(msg);
				input = scan.nextInt();
				correct = true;		
			} catch (Exception e){
				System.out.println("Erreur: vous n'avez pas entré d'entier");
				scan.next();
				correct = false;
			}
		} while (!correct);
		return input;
	}

    public static void main(String[] args) {
        int[] image = saisirImage();
        System.out.println("Pourcentage de points blanc: "+pourcentagePointBlanc(image)+"%");
        eclaircissement(image);
        scan.close();
    }
}
