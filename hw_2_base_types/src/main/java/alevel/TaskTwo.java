package alevel;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskTwo {

    public void start(Scanner in) {
        in = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String userStr = in.nextLine();


        String parseUserString[] = userStr.split("");
        Map<String, Integer> letters = new TreeMap<String, Integer>();

        for (int i = 0; i < parseUserString.length; i++) {
            if (stringFinder(parseUserString[i])) {
                if (letters.containsKey(parseUserString[i])) {
                    int value = letters.get(parseUserString[i]);
                    letters.put(parseUserString[i], value + 1);
                } else {
                    letters.put(parseUserString[i], 1);
                }
            }
        }

        System.out.println("Number of letters: ");
        for (Map.Entry<String, Integer> item : letters.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }

    private boolean stringFinder(String str) {
        if (str.matches("[a-zA-z]{1}")) {
            return true;
        }
        return false;
    }
}
