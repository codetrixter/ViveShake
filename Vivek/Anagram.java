import java.util.*;

public class Anagram {
    public static void main(String args []) {

        //test case 1
        String str1 = "ACDB";
        String str2 = "DCBA";
        System.out.println("Is anagram: "+isAnagram(str1, str2));

        //test case 2
        str1 = "ACD";
        str2 = "DCBA";
        System.out.println("Is anagram: "+isAnagram(str1, str2));

        //test case 3
        str1 = "ACDe";
        str2 = "DCBA";
        System.out.println("Is anagram: "+isAnagram(str1, str2));

        //output:
        //Is anagram: true
        //Is anagram: false
        //Is anagram: false
    }

    //Method to test if two strings are anagram
    private static boolean isAnagram(String str1, String str2) {

        if(str1.length() == str2.length()) {

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            //convert the string to character array
            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();
            //sort the arrays 
            Arrays.sort(char1);
            Arrays.sort(char2);
            
            return Arrays.equals(char1, char2);
        }
        return false;
    }
}