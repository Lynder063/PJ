// MojeMath.java
public class MojeMath {
    public static double prumer(double[] pole) {
        double suma = 0;
        for (double cislo : pole) {
            suma += cislo;
        }
        return suma / pole.length;
    }

    public static double rozptyl(double[] pole) {
        double prumer = prumer(pole);
        double sumaKvadratuOdecekPrumer = 0;

        for (double cislo : pole) {
            sumaKvadratuOdecekPrumer += Math.pow(cislo - prumer, 2);
        }

        return sumaKvadratuOdecekPrumer / pole.length;
    }

    public static void prumer_a_rozptyl(double[] pole, double[] vystup) {
        vystup[0] = prumer(pole);
        vystup[1] = rozptyl(pole);
    }
}
