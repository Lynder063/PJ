import java.util.ArrayList;

public class ToolHistoriePohybu {

    public static double spoctiVzdalenost(ArrayList<Souradnice> historie) {
        if (historie.size() < 2) {
            return 0.0;
        }

        Souradnice prvni = historie.get(0);
        Souradnice posledni = historie.get(historie.size() - 1);

        return Math.sqrt(Math.pow(posledni.x - prvni.x, 2) + Math.pow(posledni.y - prvni.y, 2));
    }

    public static String sestavVyslednouCestu(ArrayList<Souradnice> historie) {
        StringBuilder cesta = new StringBuilder();

        for (int i = 0; i < historie.size(); i++) {
            Souradnice souradnice = historie.get(i);
            cesta.append("[").append(souradnice.x).append(";").append(souradnice.y).append("]");

            if (i < historie.size() - 1) {
                cesta.append(" -> ");
            }
        }

        return cesta.toString();
    }
}
