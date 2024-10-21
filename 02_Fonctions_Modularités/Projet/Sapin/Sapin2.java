public class Sapin2{

	public static void main(String[]args){

		int nbTriangle;
		

		System.out.print("entrez le nombre de triangle que vous souhaitez pour votre sapin: ");
		nbTriangle = Terminal1.lireInt();

		int hauteurTronc = 3;
		int largeurTronc = 3;
		int ligne = 3;
		for(int i = 0; i < nbTriangle; i++){

			
			int etoile = 1;
			int espace = nbTriangle + 1;

			for(int l = 0; l < ligne; l++){

				for(int s = 0; s < espace; s++){
					System.out.print(" ");
				}

				for(int e = 0; e < etoile; e++){
					System.out.print("*");
				}
		
				etoile= etoile +2;
				espace = espace-1;
				System.out.println();
			}
			ligne = ligne +1;
		}
		for(int h = 0; h< hauteurTronc; h++){

			int espace = nbTriangle;
            		for(int s = 0; s < espace; s++){
               	 		System.out.print(" ");
            		}
			for(int l =0; l < largeurTronc; l++){
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
