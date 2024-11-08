import java.util.Scanner;

public class Rectangle{
    static Scanner scanner = new Scanner(System.in);

	public static void dessinerRectangle(int hauteur, int largeur, char caractère){
		for(int h=0 ; h<hauteur; h++){
			System.out.println();
			for(int l=0; l<largeur; l++){
				System.out.print(caractère);
			}
		}
    }

	public static int capturerInputInt(String message){
        int input;
		System.out.print("Entrez "+message+" : ");
		input = scanner.nextInt();
        scanner.nextLine();
		return input;
	}

    public static char capturerInputChar(String message){
        char input;
		System.out.print("Entrez "+message+" : ");
		input = scanner.nextLine().charAt(0);
		return input;
	}
	public static void main(String[]args){
		int hauteur = capturerInputInt("la hauteur");
		int largeur = capturerInputInt("la largeur");
        char caractères = capturerInputChar("le caractère pour dessiner le rectangle");
        if (hauteur == largeur) {
            System.out.println("Ceci est un carré");
        }else{
            dessinerRectangle(hauteur, largeur, caractères);
        }
		
		scanner.close();
	}
}