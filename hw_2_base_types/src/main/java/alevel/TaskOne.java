package alevel;

import java.util.Scanner;

public class TaskOne {

    public void start(Scanner in) {
        in = new Scanner(System.in);
        System.out.print("Pleas, put your string: ");
        String userStr = in.nextLine();

        String parseUserString[] = userStr.split("");
        int resultCount = 0;

        for (int i = 0; i < parseUserString.length; i++) {
            if (digitFinder(parseUserString[i])) {
                resultCount += Integer.parseInt(parseUserString[i]);
            }
        }

        System.out.println("Sum is: " + resultCount);
    }

    private boolean digitFinder(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
