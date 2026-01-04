package PasswordGeneration;

// PasswordConfig.java - Configuration object (no static state!)
public class PasswordConfig {
    private int minLength;
    private boolean includeNumbers;
    private boolean includeSpecialChars;
    private boolean lettersToNumbers; // future: l33t speak

    public PasswordConfig() {
        // Defaults
        this.minLength = 8;
        this.includeNumbers = true;
        this.includeSpecialChars = true;
        this.lettersToNumbers = false;
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
}