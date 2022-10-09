/* 
Given a String S and an integer K. Find the count of all substrings of length K which have exactly 
K-1 distinct characters.

 

Example 1:

Input:
S = "abcc"
K = 2
Output:
1
Explanation:
Possible substrings of length K = 2 are
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct character
Only one valid substring exists {"cc"}. 
Example 2:
Input:
S = "aabab"
K = 3
Output :
3
Explanation:
Possible substrings of length K = 3 are
aab : 2 distinct characters
aba : 2 distinct characters
bab : 2 distinct characters.
All of these Substrings are a possible answer,
so the count is 3.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function 
countOfSubstrings() which takes a String S and an integer K as input and returns the 
count of substrings of length K having K-1 distinct characters.


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(constant)
 */

public class SubStringOfLenKWithKMinus1DistElements {
    static int countOfSubstrings(String S, int K) {
        // code here
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            } else {
                map.put(S.charAt(i), 1);
            }
        }
        // System.out.println(count+" "+map);
        if (map.size() == K - 1)
            count++;

        for (int i = 1; i <= S.length() - K; i++) {
            int cnt = map.get(S.charAt(i - 1));
            if (cnt > 1) {
                map.put(S.charAt(i - 1), map.get(S.charAt(i - 1)) - 1);
            } else {
                map.remove(S.charAt(i - 1));
            }
            if (map.containsKey(S.charAt(i + K - 1))) {
                map.put(S.charAt(i + K - 1), map.get(S.charAt(i + K - 1)) + 1);
            } else {
                map.put(S.charAt(i + K - 1), 1);
            }
            if (map.size() == K - 1)
                count++;
            // System.out.println(count+" "+map);
        }

        return count;
    }
}
