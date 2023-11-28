import java.io.Serializable;

public class Osoba implements Serializable {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private Datum datumNarozeni;

    public Osoba(String jmeno, String prijmeni, int vek, Datum datumNarozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.datumNarozeni = datumNarozeni;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", věk: " + vek + ", narozen: " + datumNarozeni.toString();
    }
}
