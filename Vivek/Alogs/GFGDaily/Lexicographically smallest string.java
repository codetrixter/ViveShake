/* 
Given a string S consisting of only lowercase characters. Find the lexicographically smallest string after removing exactly k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k character.
NOTE: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.

Example 1:

Input: S = "fooland", k = 2
Output: "and" 
Explanation: As the size of the string = 7
which is not a power of 2, hence k = 4.
After removing 4 characters from the given 
string, the lexicographically smallest
string is "and".
Example 2:

Input: S = "code", k = 4
Output: "cd"
Explanation: As the length of the string = 4, 
which is 2 to the power 2, hence k = 2.
Hence, lexicographically smallest string after 
removal of 2 characters is "cd".

Your Task:  
You dont need to read input or print anything. Complete the function lexicographicallySmallest() which takes S and k as input parameters and returns the lexicographically smallest string after removing k characters.

Expected Time Complexity: O(n+k), n is size of the string
Expected Auxiliary Space: O(n)

Constraints:
1<= |S| <=105
1<= k <= 105
 */
public class LexicographicallySmallestString {
    static String lexicographicallySmallest(String s, int k) {
        // code here
       int n = s.length();
       if(n != 0 && (n & (n - 1)) > 0) {
           k *= 2;
       }else {
           k /= 2;
       }
       if(k >= n) {
           return "-1";
       }
       int left = n - k;
       ArrayDeque<Character> ad = new ArrayDeque<>();
       for(int i=0;i<n;i++) {
           if(ad.isEmpty()) {
               ad.push(s.charAt(i));
           }else {
               while(!ad.isEmpty() && s.charAt(i) < ad.peek() && (ad.size() - 1 + n - i) >= left) {
                   ad.pop();
               }
               if(ad.size() < left) {
                   ad.push(s.charAt(i));
               }
           }
       }
       char[] ans = new char[left];
       int i = left - 1;
       while(!ad.isEmpty()) {
           ans[i--] = ad.pop();
       }
       return String.valueOf(ans);
   }
}
