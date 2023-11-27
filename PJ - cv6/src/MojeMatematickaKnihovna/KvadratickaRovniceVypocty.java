package MojeMatematickaKnihovna;// KvadratickaRovniceVypocty.java
public class KvadratickaRovniceVypocty {
    public static double spocitejF(double a, double b, double c, double x) {
        return a * x * x + b * x + c;
    }

    public static int pocetKorenu(double a, double b, double c) {
        double diskriminant = b * b - 4 * a * c;
        if (diskriminant > 0) {
            return 2;
        } else if (diskriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void hodnotyKorenu(double a, double b, double c) {
        double diskriminant = b * b - 4 * a * c;

        if (diskriminant > 0) {
            double x1 = (-b + Math.sqrt(diskriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(diskriminant)) / (2 * a);
            System.out.println("Dva reálné kořeny: " + x1 + " a " + x2);
        } else if (diskriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Jeden reálný kořen: " + x);
        } else {
            System.out.println("Žádné reálné kořeny.");
        }
    }
}
