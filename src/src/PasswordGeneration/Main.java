package PasswordGeneration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/resources/words_alpha.txt";
        // Initialize dictionary
        WordDictionary dictionary = CreateDictionary.createWordDictionary(filePath);

        // Configure password rules
        PasswordConfig config = new PasswordConfig();
        config.setMinLength(8);
        config.setIncludeNumbers(true);
        config.setIncludeSpecialChars(true);
        config.setLettersToNumbers(false);
        config.setMakePinPassword(false);
        config.setIncludeCapitalLetter(true);

        // Generate password
        if(!config.isMakePinPassword()) {

            PasswordGenerator generator = new PasswordGenerator(dictionary);
            String password = generator.generate(config);

            System.out.println("Password: " + password);
            System.out.println("Length: " + password.length());

            // Easy to generate multiple passwords with different configs!
            System.out.println("\nAlternative (no special chars):");
            config.setIncludeSpecialChars(false);
            config.setMinLength(16);
            System.out.println("Password: " + generator.generate(config));
        } else {
            PasswordGenerator generator = new PasswordGenerator(dictionary);
            String password = generator.pinGenerate(config);
            System.out.println("Pin: " + password);
            System.out.println("Length: " + password.length());
        }
    }
}