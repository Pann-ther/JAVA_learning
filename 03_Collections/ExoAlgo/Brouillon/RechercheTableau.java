import java.util.Scanner;

public class RechercheTableau {
    static Scanner scanner = new Scanner(System.in);

	public static char capturerInputChar(String message){
        char input;
		System.out.print("Entrez "+message+" : ");
		input = scanner.nextLine().charAt(0);
        input = Character.toLowerCase(input);
		return input;
	}

    public static void tableauMinuscule(char[] tab){
        for(int i=0; i<tab.length; i++){
            tab[i] = Character.toLowerCase(tab[i]);
        }
    }
	
	public static boolean rechercherCaractere(char[] tab, char caractereRecherché){
		boolean appartientTableau = false;
		for(int i=0; i<tab.length; i++){
			if(caractereRecherché == tab[i]){
				appartientTableau = true;
                break;
			}
		}
		return appartientTableau;
	}

    public static int calculerOccurence(char[] tab, char caractereRecherché){
        int nbOccurence = 0;
        for(int i=0; i<tab.length; i++){
            if (tab[i] == caractereRecherché){
                nbOccurence += 1;
            }
        }
        return nbOccurence;
    }

    public static boolean comparerTableau(char[] tab1, char[] tab2){
		boolean tableauIdentique = false;
		int comparaisonChar = 0;
		for(int i=0; i<tab1.length; i++){
			for(int j=0; j<tab2.length; j++){
				if(tab1[i] == tab2[j]){
					comparaisonChar +=1;
					break;
				}
            }
		}
		if(comparaisonChar == tab1.length){
			tableauIdentique = true;
		}
		return tableauIdentique;
	}

	public static void main(String[]args){
		char caractereRecherché = capturerInputChar("le caractere recherché");
		char[] tab1 = {'a', 'b', 'c','c'};
        char[] tab2 = {'a','c','d', 'k','c'};
        tableauMinuscule(tab1);
		System.out.println("Le nombre d'occurence du caractere de "+caractereRecherché+" : "+calculerOccurence(tab1, caractereRecherché));
        System.out.println("Le tableau 2 contient tout les caracteres du tableau 1 au moins une fois: "+comparerTableau(tab1, tab2));
		scanner.close();
	}
}
