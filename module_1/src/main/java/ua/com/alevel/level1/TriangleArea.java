package ua.com.alevel.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleArea {
    private double firstX;
    private double firstY;
    private double secondX;
    private double secondY;
    private double thirdX;
    private double thirdY;

    public double getArea() {
        return Math.abs((firstX - thirdX) * (secondY - thirdY) - (secondX - thirdX) * (firstY - thirdY)) * 0.5;
    }

    public boolean entering() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите координаты первой точки: ");
            System.out.print("x = ");
            firstX = in.nextDouble();
            System.out.print("y = ");
            in = new Scanner(System.in);
            firstY = in.nextDouble();

            System.out.print("Введите координаты второй точки: ");
            System.out.print("x = ");
            in = new Scanner(System.in);
            secondX = in.nextDouble();
            System.out.print("y = ");
            in = new Scanner(System.in);
            secondY = in.nextDouble();

            System.out.print("Введите координаты третей точки: ");
            System.out.print("x = ");
            in = new Scanner(System.in);
            thirdX = in.nextDouble();
            System.out.print("y = ");
            in = new Scanner(System.in);
            thirdY = in.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.print("Вводите только цифры! ");
            System.out.println("");
            return false;
        }
        return true;
    }
}
