public class Main {
    public static void main(String[] args) {
        // Testování úkolu 2 - Vytvoření instance třídy Datum
        Datum datum1 = new Datum(1, 12, 2022);
        System.out.println("Vytvořené datum: " + datum1);

        // Testování úkolu 3 - Vytvoření instance třídy Osoba
        Osoba osoba1 = new Osoba("Jan", "Novák", 25, datum1);
        System.out.println("Vytvořená osoba: " + osoba1);

        // Testování úkolu 4 - Souborové operace
        IOFileTool.write_datum_filebin(datum1, "datum.bin");
        Datum precteneDatum = IOFileTool.read_datum_filebin("datum.bin");
        System.out.println("Načtené datum z binárního souboru: " + precteneDatum);

        IOFileTool.osoba_serializace(osoba1, "osoba.ser");
        Osoba nactenaOsoba = IOFileTool.osoba_deserializace("osoba.ser");
        System.out.println("Načtená osoba ze serializovaného souboru: " + nactenaOsoba);

        // Další souborové operace můžete testovat zde...
    }
}
