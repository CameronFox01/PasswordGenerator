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

        String password = WordDictionary.getRandomWord();

        password = checkRules(password);

        System.out.println("Password: " + password);
    }

    private static String checkRules(String password){
        if(Rules.getNumberNeeded()){
            password = password + Rules.randomNumber();
        }

        if(Rules.isSpecialCharacterNeeded()){
            password = password + Rules.randomSpecialCharacter();
        }

        if(!Rules.checkLength(password)){
            checkLength(password);
        }
        return password;
    }

    private static String checkLength(String password){
        password = password + WordDictionary.getRandomWord();

        if(!Rules.checkLength(password)){
            checkLength(password);
        }
        return password;
    }
}
