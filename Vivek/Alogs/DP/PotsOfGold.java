package Alogs.DP;

import java.util.*;

public class PotsOfGold {
<<<<<<< HEAD

    public static void main(String[] args) {
        int[] coins = { 8, 15, 3, 7 };
=======
    
    public static void main(String[] args) {
        int [] coins = {8, 15, 3, 7};
>>>>>>> 5cdbe2fede4d8d4213fc4f96180b73d52e10d443
        int n = 4;
        System.out.println(maxCoins(coins, n));
    }

    public static int maxCoins(int coins[], int n) {

<<<<<<< HEAD
        int l = 0, r = n - 1;
=======
        int l = 0, r = n-1;
>>>>>>> 5cdbe2fede4d8d4213fc4f96180b73d52e10d443
        Map<String, Integer> map = new HashMap<>();

        return maxProfit(coins, l, r, map);
    }

<<<<<<< HEAD
    private static int maxProfit(int[] coins, int l, int r, Map<String, Integer> map) {

        if (l > r)
            return 0;

        String key = l + "|" + r;
        Integer sol = map.get(key);

        if (sol != null)
            return sol;

        int a = coins[l] + Math.min(maxProfit(coins, l + 2, r, map), maxProfit(coins, l + 1, r - 1, map));
        int b = coins[r] + Math.min(maxProfit(coins, l + 1, r - 1, map), maxProfit(coins, l, r - 1, map));
=======
    private static int maxProfit(int [] coins, int l, int r, Map<String, Integer> map) {

        if(l > r) return 0;

        String key = l+"|"+r;
        Integer sol = map.get(key);

        if(sol != null) return sol;

        int a = coins[l] + Math.min(maxProfit(coins, l+2, r, map), maxProfit(coins, l+1, r-1, map));
        int b = coins[r] + Math.min(maxProfit(coins, l+1, r-1, map), maxProfit(coins, l, r-1, map));
>>>>>>> 5cdbe2fede4d8d4213fc4f96180b73d52e10d443

        int profit = Math.max(a, b);
        map.put(key, profit);

        return profit;
<<<<<<< HEAD
    }
=======
>>>>>>> 5cdbe2fede4d8d4213fc4f96180b73d52e10d443
}
