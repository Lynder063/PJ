import java.util.Random;

public class HraSachovniceRandom extends HraSachovnice {
    @Override
    public void execute() {
        System.out.println("Automatizovaný náhodný pohyb na šachovnici");
        // Zde doplňte implementaci automatizovaného pohybu
        // Můžete například generovat náhodné tahy
        Random random = new Random();
        int x1 = random.nextInt(8) + 1;
        int y1 = random.nextInt(8) + 1;
        int x2 = random.nextInt(8) + 1;
        int y2 = random.nextInt(8) + 1;
        System.out.println("Náhodný tah: " + (char)('a' + x1 - 1) + y1 + (char)('a' + x2 - 1) + y2);
    }
}