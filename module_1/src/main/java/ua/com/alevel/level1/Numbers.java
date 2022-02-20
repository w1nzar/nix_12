package ua.com.alevel.level1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Numbers {

    private String userStr;

    public void enteringInfo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите вашу строку: ");
        in = new Scanner(System.in);
        userStr = in.nextLine();
    }

    public int findAmountOfUniqueNum() {
        String[] inputArr = userStr.split("");
        Set<Integer> uniqueSet = new TreeSet<Integer>();

        for (int i = 0; i < inputArr.length; i++) {
            try {
                uniqueSet.add(Integer.parseInt(inputArr[i]));
            } catch (Exception ex) {
                continue;
            }
        }

        return uniqueSet.size();
    }
}
