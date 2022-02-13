package ua.com.alevel;

import org.apache.commons.lang3.*;
import org.apache.commons.io.*;

public class Pehota {
    public static void main(String[] args) {
        Natalia natalia = new Natalia();
        Morskaya morskaya = new Morskaya();
        String str1 = natalia.greeting();
        String str2 = morskaya.greeting();
        String str1Upper = StringUtils.upperCase(str1);
        System.out.println("Privet ya: " + str1 + "\n" + str2);
        System.out.println("Tranform to upper case:" + str1Upper);
        System.out.println("Natalia Morskaya Pehota!!! ") + (IOCase.SENSITIVE.checkEquals(str1, str1Upper));

    }
}