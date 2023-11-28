// Funkce_Primka.java
public class Funkce_Primka extends Funkce {
    private double k;
    private double q;

    public Funkce_Primka(double k, double q) {
        this.k = k;
        this.q = q;
    }

    @Override
    public double calc_y(double x) {
        return k * x + q;
    }

    @Override
    public String toString() {
        return "Funkce_Primka: y = " + k + "x + " + q;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Funkce_Primka that = (Funkce_Primka) obj;

        return Double.compare(that.k, k) == 0 && Double.compare(that.q, q) == 0;
    }
}
