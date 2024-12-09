public class Exe {
    public static void methodeLanceuse(int x){
        System.out.println("Debut methode lanceuse");
        if (x == 3) {
            throw new Exception("Erreur detecté");
        }
        System.out.println("Fin methode lanceuse");

    }

    public static void methodeAttrapeuse(int x) {
        System.out.println("Debut methode attrapeuse");
        try {
            methodeLanceuse(3);
        } catch (Exception e) {
            System.out.println(e.getMessage()+" geré par la methode attrapeuse");
        }
        System.out.println("Fin de la methode attrapeuse");
    }

    public static void main(String[] args) {
        methodeAttrapeuse(2);
    }
}
