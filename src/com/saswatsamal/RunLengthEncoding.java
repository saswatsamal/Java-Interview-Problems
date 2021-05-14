package com.saswatsamal;

public class RunLengthEncoding {
    public String encoding(String toEncode)
    {
        int consecutiveCharCount = 1;
        StringBuilder encodedString = new StringBuilder();
        //travsersing the entire string
        for(int currentChar = 1; currentChar <= toEncode.length(); ++currentChar){
            if(currentChar == toEncode.length() || toEncode.charAt(currentChar) != toEncode.charAt(currentChar-1))
            {
                encodedString.append(consecutiveCharCount); //it will count the number of chars repeated
                encodedString.append(toEncode.charAt(currentChar-1)); //it will store that char
                consecutiveCharCount = 1; //resetting it to one
            }
            else
            {
                ++consecutiveCharCount;
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        String testCase1 = "AAAABBBBCDDDD";
        System.out.println("The RLE of "+testCase1+" : "+runLengthEncoding.encoding(testCase1));
        String testCase2 = "WWBBLLLOOPPQQ";
        System.out.println("The RLE of "+testCase2+" : "+runLengthEncoding.encoding(testCase2));
    }
}
