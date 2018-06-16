package com.company;

import java.lang.reflect.Array;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here


        /** Question 1 */

        System.out.println( sortByStrings1("weather", "therapyyw"));


        /** Question 2 */
        System.out.println(decodeString("2[b3[a]]"));

        /** Question 3 */

        int[] myArray = new int[]{1, 2, 3};
        int length = myArray.length;
        System.out.println(changePossibilities(new int[]{1, 2, 3}, length, 4));




    }


    /**
     * Question 1 -- sortByStrings(s,t): Sort the letters in the string s by the order
     * they occur in the string t. You can assume t will not have repetitive characters.
     * For s = "weather" and t = "therapyw", the output should be sortByString(s, t) = "theeraw".
     * For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".
     */


    public static String sortByStrings1(String s, String t) {

        StringBuilder myStringBuilder = new StringBuilder();

        int[] charArray = new int[26];

        for (char c : t.toCharArray()) {
            charArray[c - 'a']++;

        }

        for (char c : s.toCharArray()) {
            if (charArray[c - 'a'] > 0) {
                charArray[c - 'a']++;

            } else {
                myStringBuilder.append(c);

            }

        }

        for (char c : t.toCharArray()) {
            while (--charArray[c - 'a'] > 0) {
                myStringBuilder.append(c);

            }

        }

        return myStringBuilder.toString();
    }


    /**
     * Given an encoded string, return its corresponding decoded string.
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated
     * exactly k times. Note: k is guaranteed to be a positive integer.
     * <p>
     * For s = "4[ab]", the output should be decodeString(s) = "abababab"
     * For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
     */


    public static String decodeString(String s) {
        if (s == null) {
            return null;
        }

        Stack<StringBuilder> stackSb = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int repeat = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stackSb.push(stringBuilder);
                stackInt.push(repeat);
                stringBuilder = new StringBuilder();
                repeat = 0;
            } else if (c == ']') {
                StringBuilder temp = stringBuilder;
                stringBuilder = stackSb.pop();
                repeat = stackInt.pop();
                while (repeat > 0) {
                    stringBuilder.append(temp);
                    repeat -= 1;
                }
            } else if (c >= '0' && c <= '9') {
                repeat *= 10;
                repeat += c - '0';
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }


    /**
     * Question 3 -- changePossibilities(amount,amount): Your quirky boss collects rare, old coins.
     * They found out you're a programmer and asked you to solve something they've been wondering for a long time.
     * Write a function that, given an amount of money and an array of coin denominations, computes the number of ways
     * to make the amount of money with coins of the available denominations.
     * <p>
     * Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢),
     * your program would output 4—the number of ways to make 4¢ with those denominations:
     */


    static int changePossibilities(int a[], int b, int c) {
        if (c == 0) return 1;

        if (c < 0) return 0;

        if (b <= 0 && c >= 1) return 0;

        return changePossibilities(a, b - 1, c) + changePossibilities(a, b, c - a[b - 1]);
    }


}















