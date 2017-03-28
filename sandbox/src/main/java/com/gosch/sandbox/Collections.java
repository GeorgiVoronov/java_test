package com.gosch.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        /*
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP";
        */
        // One line initialization
        String[] langs = {"Java", "C#", "Python", "PHP"};

        /*
        for (int i = 0; i < langs.length; i++) {
            System.out.println("Я хочу выучить " + langs[i]);
        }
        */
        for (String s : langs) {
            System.out.println("Я хочу выучить " + s);
        }
        System.out.println();

        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP");

        for (String s : languages) {
            System.out.println("Я хочу выучить " + s);
        }
        System.out.println();

        // One line initialization
        List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");
        for (String s : languages2) {
            System.out.println("Я хочу выучить " + s);
        }
        System.out.println();

        for (int i = 0; i < languages2.size(); i++) {
            System.out.println("Я хочу выучить " + languages2.get(i));
        }
    }

}
