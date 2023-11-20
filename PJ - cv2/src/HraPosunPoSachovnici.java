import java.util.ArrayList;

public class HraPosunPoSachovnici {

    public enum pohybEn{
        NAHORU,
        DOLU,
        DOLEVA,
        DOPRAVA
    }

    public ArrayList<String> histrorieAL = new ArrayList<>();

    public int historyInt = 1;

    public int radek;
    public int sloupec;

    public int poziceX = 0;
    public int poziceY = 0;

    public String[][] pole;


    public HraPosunPoSachovnici(int radek, int sloupec){
        this.radek = radek;
        this.sloupec = sloupec;
        pole = new String[radek][sloupec];
    }

    public void pohybChar(pohybEn move) {
        switch (move) {
            case NAHORU:
                if (poziceY > 0)
                    poziceY--;
                addHistroy("Nahoru");
                break;
            case DOLU:
                if (poziceY < radek - 1)
                    poziceY++;
                addHistroy("DolÅ¯");
                break;
            case DOLEVA:
                if (poziceX > 0)
                    poziceX--;
                addHistroy("Doleva");
                break;
            case DOPRAVA:
                if (poziceX < sloupec - 1)
                    poziceX++;
                addHistroy("Doprava");
                break;
        }
    }

    public int getPoziceX() {
        return poziceX;
    }


    public int getPoziceY() {
        return poziceY;
    }

    public void addHistroy(String message){

        histrorieAL.add("" + historyInt + " - " + message + " -> ["+getPoziceX()+";"+getPoziceY()+"]");
        historyInt ++;
    }

    public void moveHistory(){

        for (String i : histrorieAL){
            System.out.println(i);
        }
    }
}
