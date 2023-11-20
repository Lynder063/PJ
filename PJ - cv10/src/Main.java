import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int coordinationX;
        int coordinationY;

        Scanner scanner = new Scanner(System.in);

        int velikost;

        do {
            try {
                System.out.print("Zadejte velikost hracího pole (>0): ");
                velikost = scanner.nextInt();

                if (velikost <= 0){
                    System.out.println("\nZadejte číslo větší než 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("\nNeplatný vstup! Zadejte celé číslo.");
                scanner.nextLine();
            }
        } while (true);

        MinovePole mp = new MinovePole(velikost,velikost);

        do {
            do {
                try {
                    System.out.print("Zadejete pozici x: ");
                    coordinationX = scanner.nextInt();

                    System.out.print("Zadejete pozici y: ");
                    coordinationY = scanner.nextInt();

                    if (!kontrolaHodnot(coordinationX, coordinationY, mp.getRozmerX(), mp.getRozmerY())) {
                        System.out.println("\nZadejte hodnotu ve správném rozsahu! <0-"+mp.getRozmerX()+" ; 0-"+mp.getRozmerY()+">");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("\nNeplatný vstup! Zadejte celé číslo.");
                    scanner.nextLine();
                }
            } while (true);

            System.out.println();
            mp.checkValue(coordinationX, coordinationY);
        } while (mp.getStateHry());

    }

    public static boolean kontrolaHodnot(int cX, int cY, int oX, int oY){
        return (cX >= 0 && cX <= oX) && (cY >= 0 && cY <= oY);
    }
}
