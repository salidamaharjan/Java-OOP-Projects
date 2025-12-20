package com.mycompany.app;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class App {

    public static Map<String, Integer> wordCount() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        wordCountMap = readFile("/Users/salida/code/JavaOOP-Project/w3p2/src/main/java/com/mycompany/app/App.java");
        return wordCountMap;
    }

    public static Map<String, Integer> readFile(String fileName) {
        File file = new File(fileName);
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (Scanner fileReader = new Scanner(file)) {
            System.out.println("\n--- Reading from file---");
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String[] words = data.split(" ");

                for (String word : words) {
                    Integer count = wordCountMap.get(word);
                    if (count == null) {
                        wordCountMap.put(word, 1);
                    } else {
                        wordCountMap.put(word, count + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read task file.");
        }
        return wordCountMap;
    }

    public static void main(String[] args) {
        System.out.println(wordCount());
    }
}
