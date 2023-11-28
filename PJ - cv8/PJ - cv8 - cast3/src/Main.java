public class Main {
    public static void main(String[] args) {
        HraSachovniceManual hraManual = new HraSachovniceManual();
        hra(hraManual);

        HraSachovniceRandom hraRandom = new HraSachovniceRandom();
        hra(hraRandom);
    }

    public static void hra(HraSachovnice hra) {
        hra.execute();
    }
}