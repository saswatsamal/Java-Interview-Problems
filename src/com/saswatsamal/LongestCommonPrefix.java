package com.saswatsamal;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strings){
        /**
         * This function computes the longest common prefix.
         * This take a string array as input.
         * We are using a variable "prefixLen" to keep track of prefix we computed
         */
        if(0== strings.length){
            return "";
        }
        //traversing the array of strings col by col
        for (int prefixLen=0; prefixLen < strings[0].length(); prefixLen++){
            char toMatch = strings[0].charAt(prefixLen);
            for(int i = 1; i <strings.length; i++){
                if(prefixLen>= strings[i].length() || strings[i].charAt(prefixLen) != toMatch)
                {
                    return strings[0].substring(0,prefixLen);
                }
            }
        }
        return strings[0];
    }
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] testCase1 = {"flower","flow","flowInsight"};
        System.out.println("Common Prefix of testCase1: "+longestCommonPrefix.longestCommonPrefix(testCase1));
        String[] testCase2 = {"dog","cat","bird"};
        System.out.println("Common Prefix of testCase2: "+longestCommonPrefix.longestCommonPrefix(testCase2));
        String[] testCase3 = {"class","classes",""};
        System.out.println("Common Prefix of testCase3: "+longestCommonPrefix.longestCommonPrefix(testCase3));
    }
}
