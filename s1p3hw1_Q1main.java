package com.stage1.part3.hw1;

public class Q1main {

    public static void main(String[] args) {
        String str = "ABCD123!@#$%ab";

        StringBuilder capitalLetter = new StringBuilder();;
        StringBuilder lowerCaseLetter = new StringBuilder();;
        StringBuilder integerNumber = new StringBuilder();;
        StringBuilder otherCharacter = new StringBuilder();;

        String regCapLet = "[A-Z]";
        String regLowLet = "[a-z]";
        String regIntNum = "\\d{1}";

        String[] strArr = str.split("");

        for(String it:strArr){
            if(it.matches(regCapLet))       capitalLetter.append(it);
            else if(it.matches(regLowLet))  lowerCaseLetter.append(it);
            else if(it.matches(regIntNum))  integerNumber.append(it);
            else                            otherCharacter.append(it);
        }

        System.out.println("Capital letters: " + capitalLetter);
        System.out.println("Lower case letters: " + lowerCaseLetter);
        System.out.println("Integer numbers: " + integerNumber);
        System.out.println("Other characters: " + otherCharacter);

    }

}
