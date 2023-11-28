import java.io.Serializable;

public class Datum implements Serializable {
    private int den;
    private int mesic;
    private int rok;

    public Datum(int den, int mesic, int rok) {
        this.den = den;
        this.mesic = mesic;
        this.rok = rok;
    }

    public int getDen() {
        return den;
    }

    public int getMesic() {
        return mesic;
    }

    public int getRok() {
        return rok;
    }

    @Override
    public String toString() {
        return den + ". " + mesic + ". " + rok;
    }
}
