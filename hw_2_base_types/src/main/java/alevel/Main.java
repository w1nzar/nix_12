package alevel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Select task number from 1 to 3. \n" +
                "Select 0 to exit.");

        Scanner in = new Scanner(System.in);
        System.out.print("Select your task: ");
        int taskNum = in.nextInt();

        if (taskNum == 1) {
            TaskOne taskOne = new TaskOne();
            taskOne.start(in);
            main(new String[]{""});
        } else if (taskNum == 2) {
            TaskTwo taskTwo = new TaskTwo();
            taskTwo.start(in);
            main(new String[]{""});
        } else if (taskNum == 3) {
            TaskThree taskThree = new TaskThree();
            taskThree.start(in);
            main(new String[]{""});
        } else if (taskNum == 0) {
            in.close();
            System.exit(0);
        } else {
            System.out.println("Incorrect input!");
            System.out.println("Try again");
            main(new String[]{""});
        }
    }
}
