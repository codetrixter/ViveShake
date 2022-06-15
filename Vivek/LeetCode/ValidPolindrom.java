package LeetCode;

import java.util.*;

/* 
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric 
characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise. 
*/

public class ValidPolindrom {

    public static void main(String[] args) {
        String s1 = "0A man, a plan, a canal: Panama0";
        String s2 =  "race a car";
        String s3 = " ";
        System.out.println(isPolindrome(s1));
        System.out.println(isPolindrome(s2));
        System.out.println(isPolindrome(s3));
    }


    public static boolean isPolindrome(String s) {
        ArrayList<Character> c = new ArrayList<>();
        int len = s.length();
        
        for(int i = 0; i < len; i++) {
            char chr = s.charAt(i);
            boolean isChar = Character.isLetter(chr);
            if(isChar || Character.isDigit(chr)) {
                if(isChar)
                    c.add(Character.toLowerCase(chr));
                else
                    c.add(chr);
            }
        }
        
        int start = 0;
        int end = c.size() -1;
        while(start < end) {
            if(c.get(start) != c.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    
}
