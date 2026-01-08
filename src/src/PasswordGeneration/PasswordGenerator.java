package PasswordGeneration;

// PasswordGenerator.java - Main generator logic
import java.util.ArrayList;
import java.util.List;
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
            password = applyLeetSpeak(password.toString());
        }

        if (config.isIncludeCapitalLetter()){
            password = makeLetterCapital(password.toString());
        }

        return password.toString();
    }

    public String pinGenerate(PasswordConfig config) {
        StringBuilder pin = new StringBuilder();
        int i = config.getMinLength();
        while (pin.length() < i) {
            pin.append(generateRandomNumber());
        }
        if(pin.length() > i){
            pin.setLength(i);
        }
        return pin.toString();
    }

    private StringBuilder makeLetterCapital(String password) {
        // Find all letter positions first
        List<Integer> letterPositions = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                letterPositions.add(i);
            }
        }

        // If no lowercase letters, return as-is
        if (letterPositions.isEmpty()) {
            return new StringBuilder(password);
        }

        // Pick a random letter position
        int pos = letterPositions.get(random.nextInt(letterPositions.size()));
        char capitalChar = Character.toUpperCase(password.charAt(pos));

        return new StringBuilder(password.substring(0, pos) + capitalChar + password.substring(pos + 1));
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

    private StringBuilder applyLeetSpeak(String text) {
        // Future implementation: a->4, e->3, i->1, o->0, s->5, t->7
        return new StringBuilder(text.replace('a', '4')
                .replace('e', '3')
                .replace('i', '1')
                .replace('o', '0')
                .replace('s', '5')
                .replace('t', '7'));
    }
}
