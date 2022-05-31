/**
* Java 1. Homework 4
*
* @author Ruslan Zhamabayev
* @version 26/01/22
*/

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    final char CHAR_O = 'o';
    final char CHAR_X = 'x';
    final char CHAR_DOT = '.';
    Random random;
    Scanner scanner;
    char[][] table;
    
    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        table = new char[3][3];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (checkWin(CHAR_X)) {
                System.out.println("YOU WON");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry,draw");
                break;
            }
            turnAI();
            printTable();
                if (checkWin(CHAR_O)) {
                System.out.println ("AI WON");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry,draw");
                break;
            }
        }
        System.out.println("Game over");
        printTable();
    }

    void initTable() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                table[x][y] = CHAR_DOT;
            }
        }
    }

    void printTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print("Enter x, y [1...3]: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = CHAR_X;
    }

    void  turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[x][y] = CHAR_O;
    }

    boolean checkWin(char ch) {
        for (int i = 0; i < 3; i++) {
            if ((table [i][0] == ch && table[i][1] == ch && table[i][2] == ch) ||
            (table [0][i] == ch && table[1][i] == ch && table[2][i] == ch)) {
            return true;
            }
        }
        if (table [0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
        if (table [2][0] == ch && table[1][1] == ch && table[0][2] == ch) return true;
        return false;
    }

    boolean isTableFull() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (table[x][y] == CHAR_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 3 || y > 3) {
            return false;
        }
        return table[y][x] == CHAR_DOT;
    }
}