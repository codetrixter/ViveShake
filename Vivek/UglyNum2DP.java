public class UglyNum2DP {
    public static void main(String[] args) {
        int n = 150;
        System.out.println(n+"th ugly no: "+getNthUglyNum(n));
    }

    private static int getNthUglyNum(int n) {
        int [] ugly = new int[n];
        ugly[0] = 1;
        int i2, i3, i5;
        i2 = i3 = i5 = 0;

        int nextMulNumOf2 = ugly[i2]*2;
        int nextUMulNumOf3 = ugly[i3]*3;
        int nextMulNumOf5 = ugly[i5]*5;

        for(int i = 1; i < n; i++) {
            int nextUglyNum = Math.min(Math.min(nextMulNumOf2, nextUMulNumOf3) , nextMulNumOf5);
            ugly[i] = nextUglyNum;

            if(nextUglyNum == nextMulNumOf2) {
                i2++;
                nextMulNumOf2 = ugly[i2]*2;
            }

            if(nextUglyNum == nextUMulNumOf3) {
                i3++;
                nextUMulNumOf3 = ugly[i3]*3;
            }

            if(nextUglyNum == nextMulNumOf5) {
                i5++;
                nextMulNumOf5 = ugly[i5]*5;
            }
        }

        return ugly[n-1];
    }
}
