package net.stredniskola.ondrejkohout.it;

import java.util.Scanner;

public class RealizaceHryKonzola {

    public static Scanner scanner;

    public static void main(String[] args) {

        int radek;
        int sloupec;
        scanner = new Scanner(System.in);

        radek = validationOfInput("Zadejte počet řádků: ");
        sloupec = validationOfInput("Zadejte počet sloupců: ");

        HraPosunPoSachovnici hppsInstance = new HraPosunPoSachovnici(radek, sloupec);

        callPrintBoard(hppsInstance);

        startGame(hppsInstance);
    }

    static void startGame(HraPosunPoSachovnici hs){

        char inputChar;

        do {

            System.out.print("Zadejte příkaz: ");

            inputChar = scanner.next().charAt(0);
            scanner.nextLine();

            switch (Character.toUpperCase(inputChar)){
                case 'L': hs.pohybChar(HraPosunPoSachovnici.pohybEn.DOLEVA); callPrintBoard(hs); break;
                case 'R': hs.pohybChar(HraPosunPoSachovnici.pohybEn.DOPRAVA); callPrintBoard(hs); break;
                case 'U': hs.pohybChar(HraPosunPoSachovnici.pohybEn.NAHORU); callPrintBoard(hs); break;
                case 'D': hs.pohybChar(HraPosunPoSachovnici.pohybEn.DOLU); callPrintBoard(hs); break;
                case 'H': hs.moveHistory(); break;
                case 'K': System.out.print(""); break;

                default: System.out.println("Špatný input"); break;
            }

        } while (Character.toUpperCase(inputChar) != 'K');
    }

     static void printBoard(int radek, int sloupec, String[][] pole, int poziceX, int poziceY) {

        for (int i = 0; i < radek; i++) {
            for (int j = 0; j < sloupec; j++) {
                pole[i][j] = ".";
            }
        }

        pole[poziceY][poziceX] = "O";

        System.out.println("------------------------------------");

        for (int i = 0; i < radek; i++) {
            for (int j = 0; j < sloupec; j++) {
                System.out.print(pole[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("------------------------------------");
    }

    static void callPrintBoard(HraPosunPoSachovnici hppsInstance){

        printBoard(hppsInstance.radek, hppsInstance.sloupec, hppsInstance.pole, hppsInstance.getPoziceX(), hppsInstance.getPoziceY());
    }

    static int validationOfInput(String zprava){

        int value;

        while (true) {
            System.out.print(zprava);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();

                if (value <= 0){
                    System.out.println("Nesprávný vstup. Zadejte platné číslo.");
                    System.out.println("------------------------------------");
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    break;
                }
            } else {
                System.out.println("Nesprávný vstup. Zadejte celé číslo.");
                System.out.println("------------------------------------");
                scanner.nextLine();
            }
        }

        return value;
    }
}
