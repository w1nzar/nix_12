package ua.com.alevel.level2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bracket {
    private String inputStr;

    public void entering() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите вашу строку: ");
        inputStr = in.nextLine();
    }

    public boolean check() {
        String[] inputArr = inputStr.split("");
        ArrayList<String> brackets = new ArrayList<>();
        int openCountRound = 0, openCountSquare = 0, openCountFigured = 0;
        int closeCountRound = 0, closeCountSquare = 0, closeCountFigured = 0;

        for (int i = 0; i < inputArr.length; i++) {
            switch (inputArr[i]){
                case "(":
                    brackets.add(inputArr[i]);
                    openCountRound += 1;
                    break;
                case ")":
                    brackets.add(inputArr[i]);
                    closeCountRound += 1;
                    break;
                case "{":
                    brackets.add(inputArr[i]);
                    openCountSquare += 1;
                    break;
                case "}":
                    brackets.add(inputArr[i]);
                    closeCountSquare += 1;
                    break;
                case "[":
                    brackets.add(inputArr[i]);
                    openCountFigured += 1;
                    break;
                case "]":
                    brackets.add(inputArr[i]);
                    closeCountFigured += 1;
                    break;
            }
        }

        if((openCountRound != closeCountRound) || (openCountSquare != closeCountSquare) || (openCountFigured != closeCountFigured)) {
            return false;
        }

        if (brackets.size() == 0) {
            return true;
        }

        if (brackets.size() % 2 != 0) {
            return false;
        }

        if (brackets.get(0).equals("}") || brackets.get(0).equals("]") || brackets.get(0).equals(")")) {
            return false;
        }

        boolean ifOk = true;

        for (int i = 0; i < brackets.size(); i++) {
            if (brackets.get(i).equals(")") || brackets.get(i).equals("}") || brackets.get(i).equals("]")) {
                continue;
            }

            String investigatedItem = brackets.get(i);
            String oppositeItem = findOpposite(investigatedItem);
            int roundBrackets = 0, squareBrackets = 0, curlyBrackets = 0;
            int investigatedBracket = 0, oppositeBracket = 0;

            for (int j = i; j < brackets.size(); j++) {
                if (brackets.get(j).equals(investigatedItem)) {
                    investigatedBracket += 1;
                } else if (brackets.get(j).equals(oppositeItem)) {
                    investigatedBracket -= 1;
                }

                if (brackets.get(j).equals("(")) {
                    roundBrackets += 1;
                } else if (brackets.get(j).equals(")")) {
                    roundBrackets -= 1;
                }

                if (brackets.get(j).equals("[")) {
                    squareBrackets += 1;
                } else if (brackets.get(j).equals("]")) {
                    squareBrackets -= 1;
                }

                if (brackets.get(j).equals("{")) {
                    curlyBrackets += 1;
                } else if (brackets.get(j).equals("}")) {
                    curlyBrackets -= 1;
                }

                if (investigatedBracket == 0) {
                    if (roundBrackets == 0 && squareBrackets == 0 && curlyBrackets == 0) {
                        ifOk = true;
                        break;
                    } else {
                        ifOk = false;
                        break;
                    }
                }
            }
            System.out.println("");

            if (!ifOk) {
                return false;
            }
        }
        return true;
    }

    private String findOpposite(String bracket) {
        String oppositeBracket = "";
        switch (bracket) {
            case "(":
                oppositeBracket = ")";
                break;
            case "{":
                oppositeBracket = "}";
                break;
            case "[":
                oppositeBracket = "]";
                break;
        }

        return oppositeBracket;
    }
}
