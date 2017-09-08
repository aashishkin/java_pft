package ru.stqa.pft.sandbox;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args){

        List<String> languages = new ArrayList<>();
        List<String> languages2 = Arrays.asList("Java", "C#", "Python", "PHP");

        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("PHP");

        String[] langs = {"Java", "C#", "Python", "PHP"};


        for(String l : languages2) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
