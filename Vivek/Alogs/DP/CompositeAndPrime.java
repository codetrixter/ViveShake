/* 
Given two integers L and R find the difference of number of composites and primes between the range L and R (both inclusive).

Example 1:

Input: L = 4, R = 6
Output: 1
Explanation: Composite no. are 4 and 6.
And prime is 5.

Example 2:

Input: L = 4, R = 4
Output: 1
Explanation: There is no prime no. in [L,R]
 

Your Task:
You don't need to read or print anything. Your task is to complete the function Count() which takes L and R as input parameter and returns difference between no. of composites and primes between [L,R].
 

Expected Time Complexity: O(nlog(n)) where n = R - L + 1
Expected Space Complexity: O(n)
 

Constraints:
1 <= L <= R <= 105 
 */

public class CompositeAndPrime {

    public static void main(String[] args) {
        CompositeAndPrime cp = new CompositeAndPrime();
        System.out.println(cp.Count(4, 6));
        System.out.println(cp.Count(4, 4));
    }

    public int Count(int L, int R) {
        // code here
        boolean[] prime = new boolean[R + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        int primes = 0, comps = 0;

        for (int i = 2; i <= R; i++) {
            if (prime[i]) {
                for (int j = 2 * i; j <= R; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = L; i <= R; i++) {
            if (prime[i])
                primes++;
            else
                comps++;
        }

        if (L == 1)
            comps--;

        return comps - primes;
    }
}
