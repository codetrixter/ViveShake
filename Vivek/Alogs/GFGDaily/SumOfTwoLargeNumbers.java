package Alogs.GFGDaily;

/* 

Given two strings denoting non-negative numbers X and Y. Calculate the sum of X and Y.


Example 1:

Input:
X = "25", Y = "23"
Output:
48
Explanation:
The sum of 25 and 23 is 48.
Example 2:

Input:
X = "2500", Y = "23"
Output:
2523
Explanation:
The sum of 2500 and 23 is 2523.

 */

public class SumOfTwoLargeNumbers {

    public static void main(String[] args) {
        System.out.println(new SumOfTwoLargeNumbers().findSum("25", "23"));
        System.out.println(new SumOfTwoLargeNumbers().findSum("2500", "23"));
        String X = "46456146471549843198645132144513216543216141321364132135464513163215361651465131161";
        String Y = "6546513215645613216132153165132315616532161616131614665131561566512131156165161651615161565156165161516165156156165165161616165";
        System.out.println(new SumOfTwoLargeNumbers().findSum(X, Y));
    }

    String findSum(String X, String Y) {
        // code here
        int n = X.length();
        int m = Y.length();

        StringBuilder sb = new StringBuilder();

        char x, y;
        int carry = 0;
        int digit = 0;
        int num = 0;

        for (int i = 0; i < Math.max(n, m); i++) {
            // reset
            x = 'a';
            y = 'b';
            digit = 0;
            num = 0;

            // get digit from behind
            if (n - 1 - i >= 0) {
                x = X.charAt(n - 1 - i);
            }
            if (m - 1 - i >= 0) {
                y = Y.charAt(m - 1 - i);
            }

            // perform addition
            if (x != 'a' && y != 'b') {
                num = Character.getNumericValue(x) + Character.getNumericValue(y) + carry;
            } else if (x != 'a') {
                num = Character.getNumericValue(x) + carry;
            } else {
                num = Character.getNumericValue(y) + carry;
            }
            if (num > 9) {
                carry = 1;
            } else {
                carry = 0;
            }

            digit = num % 10;

            sb.append(digit);
        }
        if (carry == 1) {
            sb.append(carry);
        }

        sb.reverse();

        // remove appended 0 in first
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }

        return sb.toString();
    }
}
