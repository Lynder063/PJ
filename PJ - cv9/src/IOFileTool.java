import java.io.*;

public class IOFileTool {
    public static int pocetznaku_file(String filename) {
        try (FileReader fr = new FileReader(filename)) {
            int count = 0;
            int c;
            while ((c = fr.read()) != -1) {
                count++;
            }
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // nebo vhodný návratový kód, který indikuje chybu
        }
    }

    public static void copy_file(String filename1, String filename2) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(filename2))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // odstraní bílé znaky na začátku a konci řádku
                if (!line.isEmpty()) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // zde můžete přidat vhodnou obsluhu chyby
        }
    }

    public static void osoba_serializace(Osoba osoba, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(osoba);
        } catch (IOException e) {
            e.printStackTrace();
            // zde můžete přidat vhodnou obsluhu chyby
        }
    }

    public static Osoba osoba_deserializace(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Osoba) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null; // nebo vhodný návratový kód, který indikuje chybu
        }
    }

    public static void write_datum_filebin(Datum datum, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(datum.getDen());
            dos.writeInt(datum.getMesic());
            dos.writeInt(datum.getRok());
        } catch (IOException e) {
            e.printStackTrace();
            // zde můžete přidat vhodnou obsluhu chyby
        }
    }

    public static Datum read_datum_filebin(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int den = dis.readInt();
            int mesic = dis.readInt();
            int rok = dis.readInt();
            return new Datum(den, mesic, rok);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // nebo vhodný návratový kód, který indikuje chybu
        }
    }
}
