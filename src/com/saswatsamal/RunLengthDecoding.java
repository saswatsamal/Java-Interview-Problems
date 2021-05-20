package com.saswatsamal;

public class RunLengthDecoding {
    public static String decoding (String text) {
        int consecutiveCharCount = 0;
        StringBuilder result = new StringBuilder () ;

        for (int currentChar = 0; currentChar < text.length(); currentChar++) {
            char character = text.charAt(currentChar);
            if (Character.isDigit(character)) {
                consecutiveCharCount = consecutiveCharCount * 10 + character - '0';
            }
            else {
                while (consecutiveCharCount >0){
                    result.append(character);
                    consecutiveCharCount--;
                }
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        RunLengthDecoding runLengthDecoding = new RunLengthDecoding();
        String testCase1 = "4A4B1C4D";
        System.out.println("The RLDof "+testCase1+" : "+runLengthDecoding.decoding(testCase1));
        String testCase2 = "2WW2BB3LLL2OO2PP2QQ";
        System.out.println("The RLD of "+testCase2+" : "+runLengthDecoding.decoding(testCase2));
    }
}
