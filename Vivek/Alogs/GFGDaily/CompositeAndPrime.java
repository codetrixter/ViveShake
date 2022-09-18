/* 
Given two integers L and R find the difference of number of composites and primes between the
range L and R (both inclusive).

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
 */

public class CompositeAndPrime {

    public static void main(String[] args) {
        CompositeAndPrime cp = new CompositeAndPrime();
        System.out.println(cp.Count(4, 6));
        System.out.println(cp.Count(4, 4));
    }

    public int Count(int L, int R)
    {
        // code here
        int com = 0, prime = 0;
        for(int i = L; i <= R; i++) {
            if(i == 1) continue;
            if(isPrime(i)) {
                prime++;
            } else {
                com++;
            }
        }
        
        return com - prime;
    }
    
    private boolean isPrime(int i) {
        if(i <= 1) return true;
        
        int sqrtI = (int)Math.sqrt(i);
        for(int j = 2; j <= sqrtI; j++) {
            if(i % j == 0) return false;
        }
        return true;
    } 
}
