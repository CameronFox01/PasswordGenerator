package PasswordGeneration;

// PasswordConfig.java - Configuration object (no static state!)
public class PasswordConfig {
    private int minLength;
    private boolean includeNumbers;
    private boolean includeSpecialChars;
    private boolean lettersToNumbers; // future: l33t speak
    private boolean makePinPassword;
    private boolean includeCapitalLetter;
    private boolean completelyRandom;

    public PasswordConfig() {
        // Defaults
        this.minLength = 8;
        this.includeNumbers = true;
        this.includeSpecialChars = true;
        this.lettersToNumbers = false;
        this.makePinPassword = false;
        this.includeCapitalLetter = true;
        this.completelyRandom = false;
    }

    // Getters and setters
    public int getMinLength() { return minLength; }
    public void setMinLength(int minLength) { this.minLength = minLength; }

    public boolean isIncludeNumbers() { return includeNumbers; }
    public void setIncludeNumbers(boolean includeNumbers) { this.includeNumbers = includeNumbers; }

    public boolean isIncludeSpecialChars() { return includeSpecialChars; }
    public void setIncludeSpecialChars(boolean includeSpecialChars) { this.includeSpecialChars = includeSpecialChars; }

    public boolean isLettersToNumbers() { return lettersToNumbers; }
    public void setLettersToNumbers(boolean lettersToNumbers) { this.lettersToNumbers = lettersToNumbers; }

    public boolean isMakePinPassword() { return makePinPassword; }
    public void setMakePinPassword(boolean makePinPassword) { this.makePinPassword = makePinPassword; }

    public boolean isIncludeCapitalLetter() { return includeCapitalLetter; }
    public void setIncludeCapitalLetter(boolean includeCapitalLetter) {this.includeCapitalLetter = includeCapitalLetter;}

    public boolean isCompletelyRandom() { return completelyRandom; }
    public void setCompletelyRandom(boolean completelyRandom) { this.completelyRandom = completelyRandom; }
}