package alevel;

import java.util.Scanner;

public class TaskThree {

    public void start(Scanner in) {
        in = new Scanner(System.in);
        System.out.print("Select number of lessons (1-10): ");
        int numberOfLessons = in.nextInt();

        int exampleStart = 9 * 60;
        int exampleTime = 45;
        int shortBreak = 5;
        int longBreak = 15;

        int endOfLessons = exampleStart;

        int lesoonsTime = numberOfLessons * exampleTime;
        int shortPair = (numberOfLessons - 1) % 2;
        int breakPairs = ((numberOfLessons - 1) - shortPair);
        int breakTimePair = (breakPairs) / 2 * (shortBreak + longBreak);
        int shortPairTime = (shortPair) * shortBreak;

        endOfLessons += lesoonsTime + breakTimePair + shortPairTime;

        int min = endOfLessons % 60;
        int hours = (endOfLessons - min) / 60;

        System.out.println("Finish Lessons: " + hours + ":" + min);

    }
}
