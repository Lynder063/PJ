import java.util.Scanner;

public class HraSachovniceManual extends HraSachovnice {
    @Override
    public void execute() {
        System.out.println("Ruční ovládání šachovnice");
        // Zde doplňte implementaci ručního ovládání
        // Můžete použít třeba Scanner pro načítání vstupu od hráče
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadej tah (např. e2e4): ");
        String tah = scanner.nextLine();
        System.out.println("Hráč zadal tah: " + tah);
    }
}