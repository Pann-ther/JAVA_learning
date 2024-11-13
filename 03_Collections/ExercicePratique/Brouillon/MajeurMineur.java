import java.util.Scanner;
import java.time.LocalDateTime;

public class MajeurMineur{
	static Scanner scanner = new Scanner(System.in);

	public static String recupererDate(){
		String date;
		System.out.print("Entrez votre date de naissance jj/mm/aaaa: ");
		date = scanner.nextLine();
		return date;
	}

	public static void majeur(String date){
		String[] tabString = date.split("/");
		int[] tabInt = new int[tabString.length];
		for(int i=0; i<tabString.length; i++){
			tabInt[i]=Integer.parseInt(tabString[i]);
		}
		int jour = tabInt[0];
		int mois = tabInt[1];
		int année = tabInt[2];
		LocalDateTime dateNaissance = LocalDateTime.of(année, mois, jour,0,0);
		LocalDateTime dateActuelle = LocalDateTime.now();
		LocalDateTime majorité = dateActuelle.minusYears(18);
		if(dateNaissance.isBefore(majorité)){
			System.out.println("Vous etes majeur");
        }else{
			System.out.println("Vous etes mineur");
        }
	}
	
	public static void main(String[]args){
		String date = recupererDate();
		majeur(date);
		scanner.close();
	}
}

