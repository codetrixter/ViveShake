/* 
 * 
Geek has a string Sof size Nconsisting of characters from '0'to '9'. He wants to minimise the length of the string. In each minimising operation, geek can remove any two consecutive characters if they are of the form {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"}.
Find the minimum possible length of the string after applying minimising operations. 
 

Example 1:

Input: 
N = 5 
S = "12213"
Output: 1
Explanation: Geek can get the string of 
length 1 in two minimising operation,
In 1st operation Geek will remove "12" 
from "12213" then Geek left with "213"
In 2nd operation Geek will remove "21" 
from "213" then Geek left with "3"
 

Example 2:

Input: 
N = 4
S = "1350"
Output: 4
Explanation: Can't remove any character.
 

Your Task:  
You don't need to read input or print anything. Complete the functionminLength() which takes N and S as input parameters and returns the the minimum possible length of the string.


Expected Time Complexity: O(N)
Expected Auxiliary Space:O(N)
 

Constraints:
1 ≤ N ≤ 105
 * 
 */


public class GeekAndNumberString {
    Set<String> set;

    Solution(){
        set=new HashSet<>();
        set.add("12");
        set.add("21");
        set.add("34");
        set.add("43");
        set.add("56");
        set.add("65");
        set.add("78");
        set.add("87");
        set.add("90");
        set.add("09");
    }

    public int minLength(String s, int n) {
        // code here
        int count = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (st.size() == 0) {
                st.push(c);
                continue;
            } else if (set.contains("" + st.peek() + "" + c)) {
                st.pop();
                count++;
                continue;
            }
            st.push(c);
        }
        return n - count * 2;
    }
}
