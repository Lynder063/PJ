// Main.java
import MojeMatematickaKnihovna.KvadratickaRovniceVypocty;import VstupniOperace.NacteniHodnot;

public class Main {
    public static void main(String[] args) {
        // Testování VstupniOperace
        int intValue = NacteniHodnot.nactiInt();
        System.out.println("Zadáno celé číslo: " + intValue);

        double doubleValue = NacteniHodnot.nactiDouble();
        System.out.println("Zadáno desetinné číslo: " + doubleValue);

        // Testování KvadratickaRovniceVypocty
        double a = 1, b = -3, c = 2;
        KvadratickaRovniceVypocty.hodnotyKorenu(a, b, c);

        // Testování MojeMath
        double[] cisla = {1, 2, 3, 4, 5};
        double prumer = MojeMath.prumer(cisla);
        double rozptyl = MojeMath.rozptyl(cisla);

        System.out.println("Průměr: " + prumer);
        System.out.println("Rozptyl: " + rozptyl);

        double[] vystup = new double[2];
        MojeMath.prumer_a_rozptyl(cisla, vystup);

        System.out.println("Průměr (výstup): " + vystup[0]);
        System.out.println("Rozptyl (výstup): " + vystup[1]);
    }
}
