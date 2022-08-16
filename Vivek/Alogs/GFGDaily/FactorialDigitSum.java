package Alogs.GFGDaily;

import java.util.ArrayList;

public class FactorialDigitSum {

    public static void main(String[] args) {
        factDigit(40321).forEach(i -> System.out.print(i));
        System.out.println();
        factDigit(5040).forEach(i -> System.out.print(i));
    }

    static ArrayList<Integer> factDigit(int N) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i = 1; i < 10; i++) {
            fact[i] = fact[i-1]*i;
        }
        
        for(int i = 9; i >= 1; i--) {
            while(fact[i]<=N) {
                N-= fact[i];
                result.add(0, i);
            }
        }
        return result;
    }
}
