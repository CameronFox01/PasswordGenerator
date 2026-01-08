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
        if(config.isCompletelyRandom()){
            // Generate completely random alphanumeric password
            password.append(generateCompletelyRandom(config.getMinLength(),
                    config.isIncludeSpecialChars()));
        } else {
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

            if (config.isIncludeCapitalLetter()) {
                password = makeLetterCapital(password.toString());
            }
        }
        return password.toString();
    }

    // Add this new method to your PasswordGenerator class:
    private String generateCompletelyRandom(int length, boolean includeSpecialChars) {
        StringBuilder result = new StringBuilder();

        // Define character sets
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%&*+-=?";

        // Combine all allowed characters
        String allChars = lowercase + uppercase + digits;
        if (includeSpecialChars) {
            allChars += specialChars;
        }
        // Ensure at least one of each type is included
        result.append(lowercase.charAt(random.nextInt(lowercase.length())));
        result.append(uppercase.charAt(random.nextInt(uppercase.length())));
        result.append(digits.charAt(random.nextInt(digits.length())));

        if (includeSpecialChars) {
            result.append(specialChars.charAt(random.nextInt(specialChars.length())));
        }

        // Fill the rest randomly
        while (result.length() < length) {
            result.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the string so guaranteed characters aren't always at the start
        return shuffleString(result.toString());
    }

    // Helper method to shuffle a string
    private String shuffleString(String input) {
        char[] characters = input.toCharArray();

        // Fisher-Yates shuffle
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }

        return new String(characters);
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
