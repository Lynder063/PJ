import java.util.InputMismatchException;
import java.util.Scanner;

public class NacteniHodnot {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Short shortValue = nacti_short();
        Integer intValue = nacti_int();
        Float floatValue = nacti_float();
        Double doubleValue = nacti_double();
        String stringValue = nacti_string();
        Character charValue = nacti_char();

        System.out.println("Načtené hodnoty:");
        System.out.println("Short: " + shortValue);
        System.out.println("Integer: " + intValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("String: " + stringValue);
        System.out.println("Char: " + charValue);
    }

    public static void handleInputError(String dataType) {
        System.err.println("Chyba: Špatný formát údaje (" + dataType + ").");
        scanner.nextLine();
    }
    public static void handleFormatError(String dataType) {
        System.err.println("Chyba: Překročen rozsah údaje (" + dataType + ").");
        scanner.nextLine();
    }

    public static Short nacti_short() {
        try {
            System.out.print("\nZadej číslo (Short): ");
            return scanner.nextShort();
        } catch (InputMismatchException e) {
            handleInputError("Short");
        } catch (NumberFormatException e) {
            handleFormatError("Short");
        }
        return null;
    }

    public static Integer nacti_int() {
        try {
            System.out.print("\nZadej celé číslo (Integer): ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            handleInputError("Integer");
        } catch (NumberFormatException e) {
            handleFormatError("Integer");
        }
        return null;
    }

    public static Float nacti_float() {
        try {
            System.out.print("\nZadej desetinné číslo (Float): ");
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            handleInputError("Float");
        } catch (NumberFormatException e) {
            handleFormatError("Float");
        }
        return null;
    }

    public static Double nacti_double() {
        try {
            System.out.print("\nZadej desetinné číslo (Double): ");
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            handleInputError("Double");
        } catch (NumberFormatException e) {
            handleFormatError("Double");
        }
        return null;
    }

    public static String nacti_string() {
        try {
            System.out.print("\nZadej text (String): ");
            return scanner.next();
        } catch (StringIndexOutOfBoundsException e){
            handleInputError("String");
        }
        return null;
    }

    public static Character nacti_char() {
        try {
            System.out.print("\nZadej znak (Character): ");
            return scanner.next().charAt(0);
        } catch (InputMismatchException e) {
            handleInputError("Character");
        }
        return null;
    }
}