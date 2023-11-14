public class KomplexniCislo {
    private double real;
    private double imag;

    public KomplexniCislo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public KomplexniCislo plus(KomplexniCislo other) {
        return new KomplexniCislo(this.real + other.real, this.imag + other.imag);
    }

    public KomplexniCislo plus(double scalar) {
        return new KomplexniCislo(this.real + scalar, this.imag);
    }

    public KomplexniCislo minus(KomplexniCislo other) {
        return new KomplexniCislo(this.real - other.real, this.imag - other.imag);
    }

    public KomplexniCislo minus(double scalar) {
        return new KomplexniCislo(this.real - scalar, this.imag);
    }

    public KomplexniCislo krat(KomplexniCislo other) {
        double realPart = this.real * other.real - this.imag * other.imag;
        double imagPart = this.real * other.imag + this.imag * other.real;
        return new KomplexniCislo(realPart, imagPart);
    }

    public KomplexniCislo krat(double scalar) {
        return new KomplexniCislo(this.real * scalar, this.imag * scalar);
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }
}
