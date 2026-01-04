package PasswordGeneration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordDictionary {
    private final List<String> words;
    private final Random random;

    public WordDictionary() {
        this.words = new ArrayList<>();
        this.random = new Random();
    }

    public void loadWords(String filePath) throws IOException {
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

    public String getRandomWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("No words loaded!");
        }
        return words.get(random.nextInt(words.size()));
    }

    public int getWordCount() {
        return words.size();
    }
}