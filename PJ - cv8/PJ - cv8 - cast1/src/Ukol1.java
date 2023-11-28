public class Ukol1 {

    public static void main(String[] args) {
        // Volání funkcí
        parseJmenoPrijmeni1("John Doe");
        String parsedName = parseJmenoPrijmeni2("   Alice    Wonderland   ");
        System.out.println("Jméno a příjmení: " + parsedName);

        // Další volání funkcí...
    }

    // Metoda pro úkol 1a
    public static void parseJmenoPrijmeni1(String input) {
        String[] parts = input.split(" ");
        String jmeno = parts[0];
        String prijmeni = parts[1];
        System.out.println("Jméno: '" + jmeno + "', Příjmení: '" + prijmeni + "'");
    }

    // Metoda pro úkol 1b a 1c
    public static String parseJmenoPrijmeni2(String input) {
        String trimmedInput = input.trim();
        String[] parts = trimmedInput.split("\\s+");
        String jmeno = parts[0];
        String prijmeni = parts[1];
        return "Jméno: '" + jmeno + "', Příjmení: '" + prijmeni + "'";
    }

    // Další metody pro úkol 1d, 1e1, 1e2...

    // Metoda pro úkol 1d
    public static String[] parseLogin(String input) {
        return input.split(";");
    }

    // Metoda pro úkol 1e1
    public static int[] parseCislaInt(String input) {
        String[] cislaStr = input.split(";");
        int[] cislaInt = new int[cislaStr.length];
        for (int i = 0; i < cislaStr.length; i++) {
            cislaInt[i] = Integer.parseInt(cislaStr[i]);
        }
        return cislaInt;
    }

    // Metoda pro úkol 1e2
    public static double[] parseCislaDouble(String input) {
        String[] cislaStr = input.split(";");
        double[] cislaDouble = new double[cislaStr.length];
        for (int i = 0; i < cislaStr.length; i++) {
            cislaDouble[i] = Double.parseDouble(cislaStr[i]);
        }
        return cislaDouble;
    }
}
