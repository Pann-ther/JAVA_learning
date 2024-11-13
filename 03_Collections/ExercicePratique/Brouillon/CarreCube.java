import java.util.Scanner;

public class CarreCube {
    public static double carre(double x){
		double carre;
		carre = x*x;
		return carre;
	}

	public static double cube(double x){
		double cube;
		cube = x*x*x;
		return cube;
	}
	

	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);
		int nbTest;
		System.out.print("Combien de carré et de cube souhaitez vous calculez: ");
		nbTest = scanner.nextInt();
		for(int i = 1; i<= nbTest; i++){
			double input;
			System.out.print("Entrez le nombre x: ");
			input = scanner.nextInt();
			System.out.println("Le carré de "+input+": "+carre(input));
			System.out.println("Le cube de "+input+": "+cube(input));
            System.out.println();
		}
		scanner.close();
	}	

}
