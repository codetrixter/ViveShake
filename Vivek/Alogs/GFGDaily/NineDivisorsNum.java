import java.util.*;
/* 
Find the count of numbers less than equal to N having exactly 9 divisors.
Example 1:

Input:
N = 100
Output:
2
Explanation:
The two numbers which have 
exactly 9 divisors are 36 and 100.
Example 2:

Input:
N = 1000
Output:
8 
Explanation:
The numbers are:
36 100 196 225 256 441 484 676

Your Task:  
You don't need to read input or print anything. Your task is to complete the function nineDivisors() which takes an integer N as an input parameter and returns the total number of elements from 1 to N inclusive, that have exactly 9 divisors.

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space:  O(sqrt(N))
 

Constraints:
1<=N<=1010
 */
public class NineDivisorsNum {

    public static void main(String[] args) {
        System.out.println(nineDivisors(100));//ans : 2
    }

    static boolean isprime(long N) {
        if (N < 2)
            return false;

        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    static long nineDivisors(long N) {
        if (N < 36)
            return 0;

        ArrayList<Long> prime = new ArrayList<>();

        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (isprime(i))
                prime.add(i);
        }

        int n = prime.size(), count = 0;

        for (int i = 0; i < n; i++) {
            long x = prime.get(i);
            if ((Math.pow(x, 8) <= N))
                count++;
            else
                break;
        }

        for (int i = 0; i < n; i++) {
            long x = prime.get(i);
            boolean flag = true;
            for (int j = i + 1; j < n; j++) {
                long y = prime.get(j);
                if ((x * x * y * y) <= N) {
                    flag = false;
                    count++;
                } else {
                    break;
                }
            }
            if (flag == true)
                break;
        }
        return count;
    }
}
