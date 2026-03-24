package com.gla.objectandclasses.Level2;

class PalindromeChecker {

    String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String rev = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }

        return text.equalsIgnoreCase(rev);
    }

    public void displayResult() {
        if (isPalindrome())
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    public static void main(String[] args) {
        PalindromeChecker p1 =
                new PalindromeChecker("Madam");

        p1.displayResult();
    }
}

