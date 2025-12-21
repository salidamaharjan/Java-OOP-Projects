package com.mycompany.app;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class App {

    public static Map<String, Integer> wordCount() {
        Map<String, Integer> wordCountMap;
        wordCountMap = readFile("/Users/salida/code/JavaOOP-Project/w3p2/src/main/java/com/mycompany/app/App.java");
        return wordCountMap;
    }

    public static Map<String, Integer> readFile(String fileName) {
        File file = new File(fileName);
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (Scanner fileReader = new Scanner(file)) {
            System.out.println("\n--- Reading from file---");
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine().trim().strip().toLowerCase();
                String[] words = data.split(" ");
                for (String word : words) {
                    System.out.println("in for: " + word);
                    String strippedWord = stringTrim(word);
                    System.out.println("in for: stripped word " + strippedWord);

                    Integer count = wordCountMap.get(strippedWord);
                    if (count == null) {
                        wordCountMap.put(strippedWord, 1);
                    } else {
                        wordCountMap.put(strippedWord, count + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read task file.");
        }
        return wordCountMap;
    }

    public static String stringTrim(String word) {
        String[] wordSplit = word.split("");
        StringBuilder stripTrimWord = new StringBuilder();
        for (String s : wordSplit) {
            if (!s.matches(".*[^A-Za-z0-9 ].*") && !s.matches(".*\\p{Punct}.*")) {
                stripTrimWord.append(s);
            }
        }
        System.out.println(stripTrimWord);
        return stripTrimWord.toString();
    }

    public static void main(String[] args) {
        System.out.println(wordCount());
    }
}
