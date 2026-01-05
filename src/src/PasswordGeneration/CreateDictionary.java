package PasswordGeneration;

import java.io.IOException;

/**
 * File to create the word dictionary.
 */
public class CreateDictionary {
    public static WordDictionary createWordDictionary(String filePath) {
        WordDictionary dictionary = new WordDictionary();
        try {
            dictionary.loadWords(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dictionary;
    }
}
