/* 
 Given a string consisting of lowercase english alphabets. Find the repeated character present first in the string.

Example 1:

Input:
S = "geeksforgeeks"
Output: g
Explanation: g, e, k and s are the repeating
characters. Out of these, g occurs first. 
Example 2:

Input: 
S = "abcde"
Output: -1
Explanation: No repeating character present.
 */

public class FindFirstDuplicate {
    
    public static void main(String[] args) {
        System.out.println(firstRep("geeksforgeeks"));
    }

    static char firstRep(String S)
    {
        // your code here
        int indexForRepeatingChar = Integer.MAX_VALUE;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < S.length(); i++) {
            if(map.containsKey(S.charAt(i))) {
                int savedPreviousIndex = map.get(S.charAt(i));
                if(indexForRepeatingChar > savedPreviousIndex) {
                    indexForRepeatingChar = savedPreviousIndex;
                }
            } else {
                map.put(S.charAt(i), i);
            }
        }
        
        return indexForRepeatingChar != Integer.MAX_VALUE ? S.charAt(indexForRepeatingChar) : '#';
    }
}
