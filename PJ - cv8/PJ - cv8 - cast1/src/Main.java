public class Main {
    public static void main(String[] args) {
        // Volání funkcí z Ukol1
        Ukol1.parseJmenoPrijmeni1("John Doe");
        Ukol1.parseJmenoPrijmeni2("   Alice    Wonderland   ");

        // Další volání funkcí...

        String loginInput = "user1;user2;user3";
        String[] logins = Ukol1.parseLogin(loginInput);
        System.out.println("Loginy: " + java.util.Arrays.toString(logins));

        String cislaIntInput = "1;2;3;4;5";
        int[] cislaInt = Ukol1.parseCislaInt(cislaIntInput);
        System.out.println("Celá čísla: " + java.util.Arrays.toString(cislaInt));

        String cislaDoubleInput = "1.1;2.2;3.3;4.4;5.5";
        double[] cislaDouble = Ukol1.parseCislaDouble(cislaDoubleInput);
        System.out.println("Desetinná čísla: " + java.util.Arrays.toString(cislaDouble));

    }
}
