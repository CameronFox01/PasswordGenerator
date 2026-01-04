package PasswordGeneration;

// PasswordGenerator.java - Main generator logic
import java.util.Random;

public class PasswordGenerator {
    private final WordDictionary dictionary;
    private final Random random;

    public PasswordGenerator(WordDictionary dictionary) {
        this.dictionary = dictionary;
        this.random = new Random();
    }

    public String generate(PasswordConfig config) {
        StringBuilder password = new StringBuilder();

        // Start with a random word
        password.append(dictionary.getRandomWord());

        // Add numbers if needed
        if (config.isIncludeNumbers()) {
            password.append(generateRandomNumber());
        }

        // Add special character if needed
        if (config.isIncludeSpecialChars()) {
            password.append(generateRandomSpecialChar());
        }

        // Ensure minimum length by adding more words
        while (password.length() < config.getMinLength()) {
            password.append(dictionary.getRandomWord());
        }

        // Future: Apply l33t speak transformation
        if (config.isLettersToNumbers()) {
            return applyLeetSpeak(password.toString());
        }

        return password.toString();
    }

    public String pinGenerate(PasswordConfig config) {
        StringBuilder pin = new StringBuilder();
        int i = config.getMinLength();
        while (pin.length() < i) {
            pin.append(generateRandomNumber());
        }
        return pin.toString();
    }

    private String generateRandomNumber() {
        // Generate 1-4 digit number
        return String.valueOf(random.nextInt(10000));
    }

    private String generateRandomSpecialChar() {
        // ASCII 33-47: ! " # $ % & ' ( ) * + , - . /
        int code = 33 + random.nextInt(15);
        return String.valueOf((char) code);
    }

    private String applyLeetSpeak(String text) {
        // Future implementation: a->4, e->3, i->1, o->0, s->5, t->7
        return text.replace('a', '4')
                .replace('e', '3')
                .replace('i', '1')
                .replace('o', '0')
                .replace('s', '5')
                .replace('t', '7');
    }
}
