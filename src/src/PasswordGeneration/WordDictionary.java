package PasswordGeneration;

import java.io.*;
import java.util.*;

public class WordDictionary {

    private static final List<String> words = new ArrayList<>();

    public static void loadWords(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    words.add(line);
                }
            }
        }
    }

    public static String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}

