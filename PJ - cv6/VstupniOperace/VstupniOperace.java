// VstupniOperace.java
package VstupniOperace;

import java.util.Scanner;

public class NacteniHodnot {
    private static final Scanner scanner = new Scanner(System.in);

    public static int nactiInt() {
        System.out.print("Zadejte celé číslo: ");
        return scanner.nextInt();
    }

    public static double nactiDouble() {
        System.out.print("Zadejte desetinné číslo: ");
        return scanner.nextDouble();
    }
}
