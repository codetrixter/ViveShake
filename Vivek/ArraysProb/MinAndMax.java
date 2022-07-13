package ArraysProb;

public class MinAndMax {
    
    public static void main(String[] args) {
        int a [] = {6, 12, 1, 9, 1000};
        int n = 5;
        pair p = getMinMax(a, n);
        System.out.println(p);
    }

    private static pair getMinMax(int a[], int n) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
            if(a[i] < min) {
                min = a[i];
            }
        }

        return new pair(min, max);
    }
}

class pair {
    int min, max;
    public pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public String toString() {
        return min +", "+ max;
    }
}