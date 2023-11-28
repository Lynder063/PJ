import java.util.ArrayList;

public class Ukol4 {
    public static void main(String[] args) {
        // Generická kolekce pro ukládání objektů
        ArrayList<Object> kolekce = new ArrayList<>();

        // Přidání objektů do kolekce
        kolekce.add(new Primka(1.5, 2.0));
        kolekce.add(new KvadratickaFunkce(1.0, -3.0, 2.0));

        // Vytisknutí všech objektů
        System.out.println("Všechny objekty:");
        for (Object obj : kolekce) {
            System.out.println(obj);
        }

        // Vytisknutí všech přímek
        System.out.println("\nVšechny přímky:");
        for (Object obj : kolekce) {
            if (obj instanceof Primka) {
                System.out.println(obj);
            }
        }

        // Vytisknutí všech kvadratických funkcí
        System.out.println("\nVšechny kvadratické funkce:");
        for (Object obj : kolekce) {
            if (obj instanceof KvadratickaFunkce) {
                System.out.println(obj);
            }
        }
    }
}
