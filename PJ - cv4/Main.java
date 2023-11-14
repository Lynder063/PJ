class Barva {
    protected int r;
    protected int g;
    protected int b;
    protected double intenzita;

    public Barva(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        vypoctiIntenzitu();
    }

    public void setSlozky(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        vypoctiIntenzitu();
    }

    public void vypoctiIntenzitu() {
        intenzita = (r + g + b) / 3.0;
    }

    public String formatujBarvu() {
        return String.format("r:%02X;g:%02X;b:%02X", r, g, b);
    }
}

class BarvaRGB1 extends Barva {
    public BarvaRGB1(int r, int g, int b) {
        super(r, g, b);
    }

    public void setSlozky(int r, int g, int b) {
        super.setSlozky(r, g, b);
    }
}

class BarvaRGB2 extends Barva {
    public BarvaRGB2(int r, int g, int b) {
        super(r, g, b);
    }

    public void setSlozky(int r, int g, int b) {
        super.setSlozky(r, g, b);
    }
}

class BarvaCMYK extends Barva {
    private int c;
    private int m;
    private int y;
    private int k;

    public BarvaCMYK(int c, int m, int y, int k) {
        super(0, 0, 0); // inicializace bílé barvy
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
        vypoctiRGB();
    }

    public void setCmyk(int c, int m, int y, int k) {
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
        vypoctiRGB();
    }

    private void vypoctiRGB() {
        r = (int) (255 * (1 - c / 100.0) * (1 - k / 100.0));
        g = (int) (255 * (1 - m / 100.0) * (1 - k / 100.0));
        b = (int) (255 * (1 - y / 100.0) * (1 - k / 100.0));
        vypoctiIntenzitu();
    }
}

public class Main {
    public static void main(String[] args) {
        BarvaRGB1 barvaRGB1 = new BarvaRGB1(255, 0, 0);
        BarvaRGB2 barvaRGB2 = new BarvaRGB2(0, 255, 0);
        BarvaCMYK barvaCMYK = new BarvaCMYK(0, 50, 100, 0);

        System.out.println("Barva RGB1: " + barvaRGB1.formatujBarvu());
        System.out.println("Barva RGB2: " + barvaRGB2.formatujBarvu());
        System.out.println("Barva CMYK: " + barvaCMYK.formatujBarvu());
    }
}
