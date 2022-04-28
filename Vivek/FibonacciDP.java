public class FibonacciDP {
    //Abdul Bari concept link: 
    //https://www.youtube.com/watch?v=5dRGRueKU3M&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=46
    private static int normalCallsCount;
    private static int dpCallsCount;
    //change this no. of which you want to calculate fibonacci, here I am checking for 10
    private static int N = 10;
    private static int[] dpValue = new int[N+1];
    public static void main(String args []) {
        //fib(0)=0,fib(1)=1,fib(2)=1,fib(3)=2,
        //fib(4)=3,fib(5)=5,fib(6)=8,fib(7)=13,fib(8)=21

        //initialize with -1, will update this in dp memoization
        for(int i = 0; i <= N; i++) {
            dpValue[i] = -1;
        }

        normalfib(N);
        System.out.println("Normal calls: "+normalCallsCount);

        dpMemoizationFib(N);
        System.out.println("DP calls: "+dpCallsCount);
    }

    //normal fibonacci method
    private static int normalfib(int n) {
        normalCallsCount++;
        if(n <= 1) return n;
        return normalfib(n-2) + normalfib(n-1);
    }

    //DP method : memoization (Top to bottom approach because we starting with 5 and going to 0)
    private static int dpMemoizationFib(int n) {
        dpCallsCount++;
        if(dpValue[n] != -1) return dpValue[n];

        if(n <= 1) {
            return dpValue[n] = n;
        }
        return dpValue[n] = dpMemoizationFib(n-2) + dpMemoizationFib(n-1);
    }
}

//output: N = 5
// Normal calls: 15
// DP calls: 9

//output: N = 10
// Normal calls: 177
// DP calls: 19

//output: N = 15
// Normal calls: 1973
// DP calls: 29