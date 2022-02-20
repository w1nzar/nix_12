package ua.com.alevel.level1;

import java.util.Locale;
import java.util.Scanner;

public class Horse {

    private final int chessBoardSize = 8;
    private String[][] chessBoard = new String[chessBoardSize][chessBoardSize];
    private String startPos;
    private String targetPos;

    public Horse() {
        char c = 'A';

        for (int i = 0; i < chessBoardSize; i++) {
            for (int j = 0; j < chessBoardSize; j++) {
                chessBoard[i][j] = c + String.valueOf(j);
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println("");
            c++;
        }
    }

    public boolean entering() {
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте стартовую точку: ");
        startPos = in.nextLine().toUpperCase(Locale.ROOT);
        System.out.print("Задайте конечную точку: ");
        in = new Scanner(System.in);
        targetPos = in.nextLine().toUpperCase(Locale.ROOT);
        boolean ifStart = false, isEnd = false;

        for (int i = 0; i < chessBoardSize; i++) {
            for (int j = 0; j < chessBoardSize; j++) {
                if (startPos.equals(chessBoard[i][j])) {
                    ifStart = true;
                }

                if (targetPos.equals(chessBoard[i][j])) {
                    isEnd = true;
                }
            }
        }

        if (!ifStart || !isEnd) {
            System.out.print("Стартовой или конечной точки не найдено!");
            return false;
        }
        return true;
    }

    public boolean move() {
        String[] moveChess = new String[8];

        for (int i = 0; i < chessBoardSize; i++) {
            for (int j = 0; j < chessBoardSize; j++) {
                if (startPos.equals(chessBoard[i][j])) {
                    moveChess = findPossibleMoves(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < moveChess.length; i++) {
            if (targetPos.equals(moveChess[i])) {
                System.out.print("Ход выполнен!");
                return true;
            }
        }

        System.out.print("Невозможно переместиться в заданную точку!\n Возможные точки перемещения: ");
        for (int i = 0; i < moveChess.length; i++) {
            System.out.print(moveChess[i] + " ");
        }
        return false;
    }

    private String[] findPossibleMoves(int i, int j) {
        int pos = 0;
        String[] possibleMoves = new String[8];
        putPossibleMoves(possibleMoves, pos, moveUp(i, j));
        pos += 2;
        putPossibleMoves(possibleMoves, pos, moveDown(i, j));
        pos += 2;
        putPossibleMoves(possibleMoves, pos, moveLeft(i, j));
        pos += 2;
        putPossibleMoves(possibleMoves, pos, moveRight(i, j));
        return possibleMoves;
    }

    private String[] putPossibleMoves(String[] possibleMoves, int pos, String positions) {
        String[] partTimeLookingPos = positions.split("/");
        possibleMoves[pos] = partTimeLookingPos[0];
        possibleMoves[pos + 1] = partTimeLookingPos[1];
        return possibleMoves;
    }

    private String moveUp(int i, int j) {
        String upLeft = "";
        String upRight = "";
        int maxVal = 7;
        int minVal = 0;
        int futureHor = i - 2;
        int futureWer = j - 1;

        if (futureHor < minVal) {
            futureHor = (maxVal + 1) - Math.abs(futureHor);
        }

        if (futureWer < minVal) {
            futureWer = (maxVal + 1) - Math.abs(futureWer);
        }

        upLeft = chessBoard[futureHor][futureWer];
        futureWer = j + 1;

        if (futureWer > maxVal) {
            futureWer = futureWer - (maxVal + 1);
        }

        upRight = chessBoard[futureHor][futureWer];
        return upLeft + "/" + upRight;
    }

    private String moveDown(int i, int j) {
        String upLeft = "";
        String upRight = "";
        int maxVal = 7;
        int minVal = 0;
        int futureHor = i + 2;
        int futureWer = j - 1;

        if (futureHor > maxVal) {
            futureHor = futureHor - (maxVal + 1);
        }

        if (futureWer < minVal) {
            futureWer = (maxVal + 1) - Math.abs(futureWer);
        }

        upLeft = chessBoard[futureHor][futureWer];
        futureWer = j + 1;

        if (futureWer > maxVal) {
            futureWer = futureWer - (maxVal + 1);
        }

        upRight = chessBoard[futureHor][futureWer];
        return upLeft + "/" + upRight;
    }

    private String moveLeft(int i, int j) {
        String leftUp = "";
        String leftDown = "";
        int maxVal = 7;
        int minVal = 0;
        int futureHor = i + 1;
        int futureWer = j - 2;

        if (futureHor > maxVal) {
            futureHor = futureHor - (maxVal + 1);
        }

        if (futureWer < minVal) {
            futureWer = (maxVal + 1) - Math.abs(futureWer);
        }

        leftDown = chessBoard[futureHor][futureWer];
        futureHor = i - 1;

        if (futureHor < minVal) {
            futureHor = (maxVal + 1) - Math.abs(futureHor);
        }

        leftUp = chessBoard[futureHor][futureWer];
        return leftUp + "/" + leftDown;
    }

    private String moveRight(int i, int j) {
        String leftUp = "";
        String leftDown = "";
        int maxVal = 7;
        int minVal = 0;
        int futureHor = i + 1;
        int futureWer = j + 2;

        if (futureHor > maxVal) {
            futureHor = futureHor - (maxVal + 1);
        }

        if (futureWer > maxVal) {
            futureWer = futureWer - (maxVal + 1);
        }

        leftDown = chessBoard[futureHor][futureWer];
        futureHor = i - 1;

        if (futureHor < minVal) {
            futureHor = (maxVal + 1) - Math.abs(futureHor);
        }

        leftUp = chessBoard[futureHor][futureWer];
        return leftUp + "/" + leftDown;
    }
}
