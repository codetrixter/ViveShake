/* 
 * Given a rod of length N inches and an array of prices, price[] that contains
 * prices of all pieces of size smaller than N. Determine the maximum value 
 * obtainable by cutting up the rod and selling the pieces
 * 
 * 
Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.

 */

public class RodCutting {
    public static void main(String[] args) {
        int [] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(cutRod(price, n));
    }

    public static int cutRod(int price[], int n) {
        //code here
        int[] table = new int[n];
        for(int i = 0; i < n; i++) {
            table[i] = Integer.MIN_VALUE;
        }
        
        return cutRod(price, n, table);
    }
    
    private static int cutRod(int price[], int n, int[] table) {
        if(n == 0) return 0;
        if(table[n-1] != Integer.MIN_VALUE) return table[n-1];
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int temp = price[i] + cutRod(price, n - i - 1, table);
            if(temp > max)
               max = temp;
               
            table[n-1] = max;
        }
        
        return table[n-1];
    }
}
