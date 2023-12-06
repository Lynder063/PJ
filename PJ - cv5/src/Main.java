import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vyberte operaci:");
        System.out.println("1. Mocniny čísla");
        System.out.println("2. Goniometrické funkce");
        System.out.println("3. Trojúhelník pravoúhlý");
        System.out.println("4. Trojúhelník obecný");
        System.out.println("5. Platnost datumu");
        System.out.println("6. Aktuální datum a čas");
        System.out.println("7. Obsah složky");
        System.out.println("8. Zkopírovat/Odstranit/Přejmenovat soubor/adresář");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                mocnina_cisla();
                break;
            case 2:
                goniometricke_funkce();
                break;
            case 3:
                trojuhelnik_pravouhly();
                break;
            case 4:
                trojuhelnik_obecny();
                break;
            case 5:
                platnost_datumu();
                break;
            case 6:
                aktualni_datum();
                break;
            case 7:
                obsah_slozky();
                break;
            case 8:
                kopirovani_odstraneni_prejmenovani();
                break;
            default:
                System.out.println("Neplatná volba.");
        }
    }

    // Metoda pro výpočet mocnin a odmocnin čísla
    public static void mocnina_cisla() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte číslo:");
        double cislo = scanner.nextDouble();

        double druha_mocnina = Math.pow(cislo, 2);
        double treti_mocnina = Math.pow(cislo, 3);
        double druha_odmocnina = Math.sqrt(cislo);
        double treti_odmocnina = Math.cbrt(cislo);

        System.out.println("Druhá mocnina: " + druha_mocnina);
        System.out.println("Třetí mocnina: " + treti_mocnina);
        System.out.println("Druhá odmocnina: " + druha_odmocnina);
        System.out.println("Třetí odmocnina: " + treti_odmocnina);
    }

    // Metoda pro výpočet goniometrických funkcí
    public static void goniometricke_funkce() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte úhel ve stupních:");
        double uhel = Math.toRadians(scanner.nextDouble());

        double sin = Math.sin(uhel);
        double cos = Math.cos(uhel);
        double tg = Math.tan(uhel);
        double cotg = 1 / Math.tan(uhel);

        System.out.println("sin: " + sin);
        System.out.println("cos: " + cos);
        System.out.println("tg: " + tg);
        System.out.println("cotg: " + cotg);
    }


    // Metoda pro zobrazení obsahu složky na disku
    public static void obsah_slozky() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte cestu k složce:");
        String cesta = scanner.nextLine();

        File slozka = new File(cesta);
        String[] soubory = slozka.list();

        System.out.println("Obsah složky:");
        assert soubory != null;
        for (String soubor : soubory) {
            System.out.println(soubor);
        }
    }

    // Metoda pro výběr operace se souborem/adresářem
    public static void kopirovani_odstraneni_prejmenovani() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte cestu k souboru/adresáři:");
        String cesta = scanner.nextLine();

        File zdroj = new File(cesta);

        if (!zdroj.exists()) {
            System.out.println("Zadaný soubor/adresář neexistuje.");
            return;
        }

        System.out.println("Vyberte operaci:");
        System.out.println("1. Kopírovat");
        System.out.println("2. Odstranit");
        System.out.println("3. Přejmenovat");

        int operace = scanner.nextInt();

        switch (operace) {
            case 1:
                System.out.println("Zadejte cestu cílového umístění:");
                scanner.nextLine(); // Pro konzumaci přebytečného znaku nového řádku
                String cilovaCestaKopie = scanner.nextLine();
                kopirovatSouborAdresar(zdroj, new File(cilovaCestaKopie));
                break;
            case 2:
                odstranitSouborAdresar(zdroj);
                break;
            case 3:
                System.out.println("Zadejte nový název souboru/adresáře:");
                scanner.nextLine(); // Pro konzumaci přebytečného znaku nového řádku
                String novyNazev = scanner.nextLine();
                prejmenovatSouborAdresar(zdroj, new File(zdroj.getParentFile(), novyNazev));
                break;
            default:
                System.out.println("Neplatná volba.");
        }
    }

    // Metoda pro zjištění jestli zdroj je soubor nebo adresář
    private static void kopirovatSouborAdresar(File zdroj, File cil) {
        if (zdroj.isDirectory()) {
            kopirovatAdresar(zdroj, cil);
        } else {
            kopirovatSoubor(zdroj, cil);
        }
    }

    // Metoda pro kopírování adresáře
    private static void kopirovatAdresar(File zdroj, File cil) {
        try {
            Path zdrojovaCesta = zdroj.toPath();
            Path cilovaCesta = cil.toPath();

            Files.walk(zdrojovaCesta)
                    .forEach(soubor -> {
                        try {
                            Path cilovySoubor = cilovaCesta.resolve(zdrojovaCesta.relativize(soubor));
                            Files.copy(soubor, cilovySoubor, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            System.out.println("Chyba při kopírování souboru/adresáře: " + e.getMessage());
                        }
                    });

            System.out.println("Obsah adresáře byl úspěšně zkopírován.");
        } catch (IOException e) {
            System.out.println("Chyba při kopírování adresáře: " + e.getMessage());
        }
    }

    // Metoda pro kopírování souboru
    private static void kopirovatSoubor(File zdroj, File cil) {
        try {
            Path cilPath;

            if (cil.isDirectory()) {
                cilPath = Paths.get(cil.getAbsolutePath(), zdroj.getName());
            } else {
                cilPath = cil.toPath();
            }

            Files.copy(zdroj.toPath(), cilPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Soubor/adresář byl úspěšně zkopírován.");
        } catch (IOException e) {
            System.out.println("Chyba při kopírování souboru/adresáře: " + e.getMessage());
        }
    }

    // Metoda pro odstranění souboru/adresáře
    private static void odstranitSouborAdresar(File souborAdresar) {
        if (souborAdresar.isDirectory()) {
            File[] obsah = souborAdresar.listFiles();
            if (obsah != null) {
                for (File f : obsah) {
                    odstranitSouborAdresar(f);
                }
            }
        }
        if (souborAdresar.delete()) {
            System.out.println("Soubor/adresář byl úspěšně odstraněn.");
        } else {
            System.out.println("Nepodařilo se odstranit soubor/adresář.");
        }
    }

    // Metoda pro přejmenování souboru/adresáře
    private static void prejmenovatSouborAdresar(File stary, File novy) {
        if (stary.renameTo(novy)) {
            System.out.println("Soubor/adresář byl úspěšně přejmenován.");
        } else {
            System.out.println("Nepodařilo se přejmenovat soubor/adresář.");
        }
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("dd.MM.yyyy");


    // Metoda pro pravoúhlý trojúhelník
    public static void trojuhelnik_pravouhly() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte délku odvěsny a:");
        double a = scanner.nextDouble();

        System.out.println("Zadejte délku odvěsny b:");
        double b = scanner.nextDouble();

        double prepona = Math.sqrt(a * a + b * b);
        double uhelAlfa = Math.toDegrees(Math.atan(b / a));
        double uhelBeta = Math.toDegrees(Math.atan(a / b));

        System.out.println("Přepona: " + prepona);
        System.out.println("Úhel alfa: " + uhelAlfa);
        System.out.println("Úhel beta: " + uhelBeta);
    }

    // Metoda pro obecný trojúhelník
    public static void trojuhelnik_obecny() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte délku strany a:");
        double a = scanner.nextDouble();

        System.out.println("Zadejte délku strany b:");
        double b = scanner.nextDouble();

        System.out.println("Zadejte délku strany c:");
        double c = scanner.nextDouble();

        double obvod = a + b + c;
        double s = obvod / 2;
        double obsah = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double uhelAlfa = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        double uhelBeta = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double uhelGama = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));

        System.out.println("Obvod: " + obvod);
        System.out.println("Obsah: " + obsah);
        System.out.println("Úhel alfa: " + uhelAlfa);
        System.out.println("Úhel beta: " + uhelBeta);
        System.out.println("Úhel gama: " + uhelGama);
    }

    // Metoda pro platnost datumu
    public static void platnost_datumu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte první datum ve formátu dd.MM.yyyy:");
        String datum1Str = scanner.nextLine();

        System.out.println("Zadejte druhé datum ve formátu dd.MM.yyyy:");
        String datum2Str = scanner.nextLine();

        try {
            Date datum1 = DATE_FORMAT2.parse(datum1Str);
            Date datum2 = DATE_FORMAT2.parse(datum2Str);

            if (datum1.before(datum2)) {
                System.out.println("Druhé datum je později než první.");
            } else if (datum1.equals(datum2)) {
                System.out.println("Datumy jsou stejné.");
            } else {
                System.out.println("První datum je později než druhé.");
            }
        } catch (ParseException e) {
            System.out.println("Chyba při zpracování datumu: " + e.getMessage());
        }
    }

    // Metoda pro aktuální datum a čas
    public static void aktualni_datum() {
        Date aktualniDatumCas = new Date();
        System.out.println("Aktuální datum a čas: " + DATE_FORMAT.format(aktualniDatumCas));
    }

}
