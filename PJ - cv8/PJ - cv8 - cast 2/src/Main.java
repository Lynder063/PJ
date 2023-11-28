// Main.java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Vytvoření instancí tříd Funkce_Primka a Funkce_Kvadraticka
        Funkce_Primka primka = new Funkce_Primka(2, 3);
        Funkce_Kvadraticka kvadraticka = new Funkce_Kvadraticka(1, -2, -3);

        // Vytvoření kolekce pro uchování instancí tříd Funkce_Primka a Funkce_Kvadraticka
        ArrayList<Funkce> funkceKolekce = new ArrayList<>();
        funkceKolekce.add(primka);
        funkceKolekce.add(kvadraticka);

        // Vytisknutí všech funkcí
        System.out.println("Všechny funkce:");
        for (Funkce funkce : funkceKolekce) {
            System.out.println(funkce);
        }

        // Vytisknutí pouze přímkových funkcí
        System.out.println("\nPřímkové funkce:");
        for (Funkce funkce : funkceKolekce) {
            if (funkce instanceof Funkce_Primka) {
                System.out.println(funkce);
            }
        }

        // Vytisknutí pouze kvadratických funkcí
        System.out.println("\nKvadratické funkce:");
        for (Funkce funkce : funkceKolekce) {
            if (funkce instanceof Funkce_Kvadraticka) {
                System.out.println(funkce);
            }
        }
    }
}
