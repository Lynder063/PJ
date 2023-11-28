// Funkce_Kvadraticka.java
public class Funkce_Kvadraticka extends Funkce {
    private double a;
    private double b;
    private double c;

    public Funkce_Kvadraticka(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calc_y(double x) {
        return a * x * x + b * x + c;
    }

    public int pocet_korenu() {
        double discriminant = diskriminant();
        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public double diskriminant() {
        return b * b - 4 * a * c;
    }

    @Override
    public String toString() {
        return "Funkce_Kvadraticka: y = " + a + "x^2 + " + b + "x + " + c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Funkce_Kvadraticka that = (Funkce_Kvadraticka) obj;

        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0 && Double.compare(that.c, c) == 0;
    }
}
