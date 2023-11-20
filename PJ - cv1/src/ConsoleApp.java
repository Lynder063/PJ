import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        u_i();
        u_ii();
        System.out.println(u_iii());
        u_iv_datovetypy();
        u_v();
    }

    public static void u_i() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Zadej celé číslo (byte, int, long): ");
            byte byteValue = scanner.nextByte();
            int intValue = scanner.nextInt();
            long longValue = scanner.nextLong();

            System.out.print("Zadej číslo s desetinnou částí (float, double): ");
            float floatValue = scanner.nextFloat();
            double doubleValue = scanner.nextDouble();

            scanner.nextLine(); // Consume the newline character

            System.out.print("Zadej znak: ");
            char charValue = scanner.next().charAt(0);

            System.out.print("Zadej text: ");
            String stringValue = scanner.next();

            System.out.println("Vstupní hodnoty:");
            System.out.println("Byte: " + byteValue);
            System.out.println("Int: " + intValue);
            System.out.println("Long: " + longValue);
            System.out.println("Float: " + floatValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Char: " + charValue);
            System.out.println("String: " + stringValue);
            System.out.println("------------------------------------------------");
        } catch (InputMismatchException e) {
            System.out.println("Chyba: Neplatná hodnota.");
        }
    }


    public static void u_ii() {
        byte byteValue = 10;
        int intValue = 100;
        long longValue = 1000L;
        float floatValue = (float) 3.14;
        double doubleValue = 2.71828;
        char charValue = 'A';
        String stringValue = "Hello, World!";

        System.out.println("Deklarace a inicializace proměnných:");
        System.out.println("Byte: " + byteValue);
        System.out.println("Int: " + intValue);
        System.out.println("Long: " + longValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Char: " + charValue);
        System.out.println("String: " + stringValue);
        System.out.println("------------------------------------------------");
    }

    public static String u_iii() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Zadej jméno: ");
        String firstName = scanner1.nextLine();
        System.out.print("Zadej příjmení: ");
        String lastName = scanner1.nextLine();

        return firstName + " " + lastName;
    }

    public static void u_iv_datovetypy() {
        System.out.println("Datové typy v jazyce Java:");
        System.out.println("---------------------------------------------------------------------------------------------");
        //https://programming.guide/java/primitive-ranges.html
        System.out.println("| Název       | Obalovací třída | Velikost (bajty) | Velikost (bity)  | Rozsah              |");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("| byte        | Byte            | 1                | 8                | -128 až 127         |");
        System.out.println("| int         | Integer         | 4                | 32               | -2^31 až 2^31-1     |");
        System.out.println("| long        | Long            | 8                | 64               | -2^63 až 2^63-1     |");
        System.out.println("| float       | Float           | 4                | 32               | -3.4e38 až 3.4e38   |");
        System.out.println("| double      | Double          | 8                | 64               | -1.7e308 až 1.7e308 |");
        System.out.println("| char        | Character       | 2                | 16               | 'u0000' až 'uffff'  |");
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public static void u_v() {
        int result1 = 6 + 4;
        String result2 = "" + 6 + 4;

        System.out.println("Výsledek výrazu 6 + 4: " + result1);  // Výsledek je 10
        System.out.println("Výsledek výrazu \"\" + 6 + 4: " + result2);  // Výsledek je "64" (jelikož text + text)
    }
}