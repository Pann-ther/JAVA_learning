import java.util.ArrayList;
import java.util.Scanner;
public class Ex {

    public static void ajouterNote(ArrayList<Double> t, ArrayList<Double> coeff){
        Scanner scan = new Scanner(System.in);
        double note;
        double co = -1;
        System.out.println("Note éleve");
        note = scan.nextDouble();
        scan.nextLine();
        System.out.println("Coefficient de la note");
        co = scan.nextDouble();
        scan.nextLine();
        t.add(note);
        coeff.add(co);
    }

    public static void changerNote(ArrayList<Double> t, ArrayList<Double> coeff){
        Scanner scan = new Scanner(System.in);
        int index= -1;
        double note = -1;
        double co = -1;
        afficherNotes(t,coeff);
        System.out.println("Quelle note voulez vous modifier?");
        index = scan.nextInt()-1;
        scan.nextLine();
        System.out.println("Nouvelle note");
        note = scan.nextDouble();
        scan.nextLine();
        System.out.println("Nouveau coefficient");
        co = scan.nextDouble();
        scan.nextLine();
        t.set(index, note);
        coeff.set(index, co);

    }
    public static void afficherNotes(ArrayList<Double> t, ArrayList<Double> coeff){
        for(int i=0; i<t.size(); i++){
            System.out.println("Notes "+(i+1)+": "+t.get(i)+", coefficient: "+coeff.get(i));
        }
    }

    public static double calculerMoyenne(ArrayList<Double> t, ArrayList<Double> coeff){
        double somme = 0;
        for(int i =0; i<t.size(); i++){
            somme += (t.get(i)*coeff.get(i));
        }
        double moyenne = somme / t.size();
        return moyenne;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean fini = false;
        ArrayList<Double> notes = new ArrayList<Double>();
        ArrayList<Double> coeff = new ArrayList<Double>();
        while (!fini) {
            int choix;
            System.out.println("Votre choix");
            System.out.println("1: Ajouter une note");
            System.out.println("2: afficher les notes");
            System.out.println("3: Calculer la moyenne");
            System.out.println("4: Modifier une note");
            System.out.println("5: finir le programme");
            choix = scan.nextInt();
            scan.nextLine();
            switch(choix){
                case 1:
                    ajouterNote(notes, coeff);
                    break;
                case 2:
                    afficherNotes(notes, coeff);
                    break;
                case 3:
                    System.out.println("Moyenne de l'eleve: "+calculerMoyenne(notes,coeff));
                    break;
                case 4:
                    changerNote(notes,coeff);
                    break;
                case 5:
                    fini = true;
                    break;
            }
        }
    }
}