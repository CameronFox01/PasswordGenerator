package PasswordGeneration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/resources/words_alpha.txt";

        try {
            // Initialize dictionary
            WordDictionary dictionary = new WordDictionary();
            dictionary.loadWords(filePath);

            // Configure password rules
            PasswordConfig config = new PasswordConfig();
            config.setMinLength(12);
            config.setIncludeNumbers(true);
            config.setIncludeSpecialChars(true);

            // Generate password
            PasswordGenerator generator = new PasswordGenerator(dictionary);
            String password = generator.generate(config);

            System.out.println("Password: " + password);
            System.out.println("Length: " + password.length());

            // Easy to generate multiple passwords with different configs!
            System.out.println("\nAlternative (no special chars):");
            config.setIncludeSpecialChars(false);
            config.setMinLength(16);
            System.out.println("Password: " + generator.generate(config));

        } catch (IOException e) {
            System.err.println("Error loading words: " + e.getMessage());
        }
    }
}