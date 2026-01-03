package PasswordGeneration;

public class Rules {
    private static int length = 8;
    private static boolean specialCharacterNeeded = true;
    private static boolean pinPassword = false;

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
        if(length.length() == Rules.length){
            result = true;
        }
        return result;
    }
}
