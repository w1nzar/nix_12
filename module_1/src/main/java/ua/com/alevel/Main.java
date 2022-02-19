package ua.com.alevel;

import ua.com.alevel.level1.Horse;
import ua.com.alevel.level1.Numbers;
import ua.com.alevel.level1.TriangleArea;
import ua.com.alevel.level2.Bracket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать!");
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите уровень 1-2: ");
        int level = in.nextInt();

        switch (level) {
            case 1: {
                firstLevelCall();
            }
            case 2: {
                secondLevelCall();
            }

        }
    }

    private static void firstLevelCall() {
        System.out.println("Вы на 1 уровне!");
        System.out.println("Вам доступны следующие задачи: \n" +
                "1 - Поиск уникальных чисел\n" +
                "2 - Площадь треугольника\n" +
                "3 - Ход коня\n" +
                "0 - Выйти\n" +
                "Выберите нужныую задачу: ");
        Scanner in = new Scanner(System.in);
        int task = in.nextInt();

        switch (task) {
            case 1: {
                Numbers numbers = new Numbers();
                numbers.enteringInfo();
                System.out.println("Количество уникальных чисел: " + numbers.findAmountOfUniqueNum());
                System.out.println("");
                firstLevelCall();
            }
            case 2: {
                TriangleArea triangleArea = new TriangleArea();
                if (!triangleArea.entering()) {
                    System.out.println("");
                    firstLevelCall();
                }
                System.out.println("Площадь: " + triangleArea.getArea());
                System.out.println("");
                firstLevelCall();
            }
            case 3: {
                Horse horse = new Horse();
                if (horse.entering()) {
                    horse.move();
                }
                System.out.println("");
                firstLevelCall();
            }
            case 0: {
                main(new String[]{""});
            }
        }

    }

    private static void secondLevelCall() {
        System.out.println("Вы на 2 уровне!");
        System.out.println("Вам доступны следующие задачи: \n" +
                "1 - Проверка на вальдность скобок\n" +
                "0 - Выйти\n" +
                "Выберите нужныую задаччу: ");
        Scanner in = new Scanner(System.in);
        int task = in.nextInt();

        switch (task) {
            case 1: {
                Bracket bracket = new Bracket();
                bracket.entering();
                System.out.println("Валидность вашей строки: " + bracket.check());
            }

            case 0: {
                main(new String[]{""});
            }
        }

    }


}
