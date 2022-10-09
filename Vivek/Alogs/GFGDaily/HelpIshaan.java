/* 
 * 
Ishaan has been given a task by his teacher. He needs to find the Nth term of a series. His teacher gives him some examples to help him out (Refer examples below). He is a bit weak in pattern searching so to help him his teacher told him that the Nth term is related to prime numbers. The Nth term is the difference of N and the closest prime number to N. Help him find the Nth term for a given N.
 

Example 1:

Input: N = 10
Output: 1
Explanation: Closest prime to 10 is 11.
Example 2:

Input: N = 7
Output: 0
Explanation: Closest prime to 7 is 7.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function NthTerm() which takes N as input paramater and returns Nth term.
 

Expected Time Complexity: O(N* √ N)
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 100000
 * 
 */

public class HelpIshaan {

    public static void main(String[] args) {
        HelpIshaan obj = new HelpIshaan();
        System.out.println(obj.NthTerm(10));
        System.out.println(obj.NthTerm(7));
    }

    public int NthTerm(int N) {
        // code here
        if (isPrime(N)) {
            // System.out.println(isPrime(N));
            return 0;
        }
        return NthTerm_temp(N - 1, N + 1, N);
    }

    private int NthTerm_temp(int a, int b, int N) {
        // System.out.println(a + " : "+b + ", "+N);
        if (a > 1 && isPrime(a)) {
            return N - a;
        } else if (isPrime(b)) {
            return b - N;
        }
        return NthTerm_temp(a - 1, b + 1, N);
    }

    private boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
