public class MinovePole {

    public int[][] poleHry;
    public char[][] poleGrafiky;

    public int rozmerX;
    public int rozmerY;

    public boolean stateHry = true;

    private int unikatniCounter;


    public MinovePole(int x, int y) {

        rozmerX = x;
        rozmerY = y;

        poleHry = new int[x][y];
        poleGrafiky = new char[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                poleHry[i][j] = 0;
                poleGrafiky[i][j] = '.';
            }
        }

        pridejMiny(x + 1, x ,y);
        createVisual(x, y);
    }

    public void createVisual(int x, int y){

        int visualX = x+2;
        int visualY = y+2;

        char[][] poleVisual = new char[visualX][visualX];

        for (int i = 0; i < visualX; i++) {
            for (int j = 0; j < visualY; j++) {
                if (i == 0 || i == visualX-1){
                    poleVisual[i][j] = '_';
                } else if (j == 0 || j == visualY-1){
                    poleVisual[i][j] = '|';
                } else poleVisual[i][j] = (poleGrafiky[i-1][j-1]);
            }
        }

        for (int i = 0; i < visualX; i++) {
            for (int j = 0; j < visualY; j++) {
                System.out.print(poleVisual[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkValue(int x, int y){

        if (poleGrafiky[x][y] == '.') unikatniCounter++;

        if (poleHry[x][y] == 0){
            poleGrafiky[x][y] = '0';
            createVisual(rozmerX, rozmerY);

        } else {
            poleGrafiky[x][y] = '1';

            createVisual(rozmerX, rozmerY);

            System.out.println("Dokončil jste hru s odkrytím "+(unikatniCounter-1)+" neminových polí.");

            setStateHry(false);
        }
    }

    public void pridejMiny(int pocetMin, int x, int y){

        int random_X;
        int random_Y;

        for (int i = 0; i < pocetMin; i++){
            random_X = (int)Math.floor(Math.random() * (x));
            random_Y = (int)Math.floor(Math.random() * (y));

            poleHry[random_X][random_Y] = 1;
        }
    }

    public int getRozmerX() {
        return rozmerX-1;
    }

    public int getRozmerY() {
        return rozmerY-1;
    }

    public boolean getStateHry() {
        return stateHry;
    }

    public void setStateHry(boolean stateHry) {
        this.stateHry = stateHry;
    }
}
