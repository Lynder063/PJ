package net.stredniskola.ondrejkohout.it;

public class ZnakText {

    public static void main(String[] args) {
        char znak = 'A';
        TiskInfoZnak(znak);
        tiskASCII();
        System.out.println(DejASCII());
    }

    public static void TiskInfoZnak(char z) {

        System.out.println(DejInfoZnak(z));
    }

    public static String DejInfoZnak(char z) {
        int ascii = z;
        return "Znak: " + z + "\nASCII kód (dekadicky): " + ascii + "\nASCII kód (hexadecimálně): " + Integer.toHexString(ascii);
    }


    public static void tiskASCII() {
        System.out.println("ASCII tabulka:");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("| Znak | ASCII (dekadicky)  | ASCII (hexadecimálně)  | Znak | ASCII (dekadicky)  | ASCII (hexadecimálně)  |");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        for (char pismeno = 'A'; pismeno <= 'Z'; pismeno++) {
            int ascii = pismeno;
            System.out.printf("|   %c  |         %d         |           %s           |", pismeno, ascii, Integer.toHexString(ascii));
            int asciiLower = Character.toLowerCase(pismeno);
            System.out.printf("   %c  |         %d         |           %s           |\n", Character.toLowerCase(pismeno), asciiLower, Integer.toHexString(asciiLower));
        }

        System.out.println("------------------------------------------------------------------------------------------------------------");

        for (char cislo = '0'; cislo <= '9'; cislo++) {
            int ascii = cislo;
            System.out.printf("|   %c  |         %d         |           %s           |\n", cislo, ascii, Integer.toHexString(ascii));
        }

        System.out.println("------------------------------------------------------");
    }

    //Nechápu zadání "Upravte předcházející metodu tak, aby využila této metody"
    public static String DejASCII() {
        StringBuilder sb = new StringBuilder();
        sb.append("ASCII tabulka:\n");
        sb.append("-----------------------------------------------------------------------------------------------------------\n");
        sb.append("| Znak | ASCII (dekadicky)  | ASCII (hexadecimálně)  | Znak | ASCII (dekadicky)  | ASCII (hexadecimálně)  |\n");
        sb.append("-----------------------------------------------------------------------------------------------------------\n");

        for (char pismeno = 'A'; pismeno <= 'Z'; pismeno++) {
            int ascii = pismeno;
            sb.append(String.format("|   %c  |         %d         |           %s           |", pismeno, ascii, Integer.toHexString(ascii)));
            int asciiLower = Character.toLowerCase(pismeno);
            sb.append(String.format("   %c  |         %d         |           %s           |\n", Character.toLowerCase(pismeno), asciiLower, Integer.toHexString(asciiLower)));
        }

        sb.append("------------------------------------------------------------------------------------------------------------\n");

        for (char cislo = '0'; cislo <= '9'; cislo++) {
            int ascii = cislo;
            sb.append(String.format("|   %c  |         %d         |           %s           |\n", cislo, ascii, Integer.toHexString(ascii)));
        }

        sb.append("------------------------------------------------------\n");
        return sb.toString();
    }
}

