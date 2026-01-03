package PasswordGeneration;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/resources/words_alpha.txt";
        try {
            WordDictionary.loadWords(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(WordDictionary.getRandomWord());
        }
    }
}
