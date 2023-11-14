public class Main {
    public static void main(String[] args) {
        // Příklady použití
        KomplexniCislo cislo1 = new KomplexniCislo(3, 2);
        KomplexniCislo cislo2 = new KomplexniCislo(1, 4);

        KomplexniCislo vysledekSoucet = cislo1.plus(cislo2);
        KomplexniCislo vysledekRozdil = cislo1.minus(cislo2);
        KomplexniCislo vysledekNasobeni = cislo1.krat(cislo2);
        KomplexniCislo vysledekSoucetSCislem = cislo1.plus(5);

        System.out.println("Sčítání: " + vysledekSoucet);
        System.out.println("Odčítání: " + vysledekRozdil);
        System.out.println("Násobení: " + vysledekNasobeni);
        System.out.println("Sčítání s číslem: " + vysledekSoucetSCislem);
    }
}
