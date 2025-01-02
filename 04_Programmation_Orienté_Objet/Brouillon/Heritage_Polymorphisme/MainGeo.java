public class MainGeo {
    public static void main(String[] args) {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(7, 1);
        Rectangle r1 = new Rectangle(p1, 5, 10);
        Triangle t1 = new Triangle(p1, p2, p3);
        Cercle c1 = new Cercle(p1, 3);
        AvecSurface forme = new Cercle(p2, 10);
        Cercle c2 = (Cercle) forme;
        AvecSurface[] tab = new AvecSurface[4];
        tab[0] = t1;
        tab[1] = r1;
        tab[2] = c1;
        tab[3] = c2;
        int indGrand = 0;
        System.out.println("Surface tab " + indGrand + ": " + tab[indGrand].surface());
        for (int i = 1; i < tab.length; i++) {
            System.out.println("Surface tab " + i + ": " + tab[i].surface());
            if (tab[i].surface() > tab[indGrand].surface()) {
                indGrand = i;
            }
        }
        System.out.println("Tab " + indGrand + " à la surface la plus grande");

    }
}
