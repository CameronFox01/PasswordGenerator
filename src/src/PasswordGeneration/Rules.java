package PasswordGeneration;

import java.util.Random;

public class Rules {
    private static int length = 8;
    private static boolean specialCharacterNeeded = true;
    private static boolean pinPassword = false;
    private static boolean numberNeeded = true;

    public static void setNumberNeeded(boolean numberNeeded) {
        Rules.numberNeeded = numberNeeded;
    }

    public static boolean getNumberNeeded() {
        return numberNeeded;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Rules.length = length;
    }

    public static boolean isSpecialCharacterNeeded() {
        return specialCharacterNeeded;
    }

    public static void setSpecialCharacterNeeded(boolean specialCharacterNeeded) {
        Rules.specialCharacterNeeded = specialCharacterNeeded;
    }

    public static boolean isPinPassword() {
        return pinPassword;
    }

    public static void setPinPassword(boolean pinPassword) {
        Rules.pinPassword = pinPassword;
    }

    public static boolean checkLength(String length){
        boolean result = false;
        if(length.length() >= Rules.length){
            result = true;
        }
        return result;
    }

    public static String randomSpecialCharacter(){
        String result = "";
        int min = 33;
        int max = 47;

        Random rand = new Random();

        int randNum = rand.nextInt(max - min + 1) + min;
        char character = (char) randNum;
        result = String.valueOf(character);
        return result;
    }

    public static String randomNumber(){
        String result = "";

        Random rand = new Random();
        int randNum = rand.nextInt(10000);
        String character = "" + randNum;
        result = (character);

        return result;
    }
}
