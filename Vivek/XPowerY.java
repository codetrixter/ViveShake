//Calculate x^y using recursion
public class XPowerY {
    public static void main(String args []) {
        System.out.println("2^3: "+calculate(2, 3));
        System.out.println("3^3: "+calculate(3, 3));
        System.out.println("2^5: "+calculate(2, 5));
    }

    public static int calculate(int x, int y) {
        return calculate(x, y, 1);
    }

    private static int calculate(int x, int y, int result) {
        if(y==0) return result;
        return calculate(x, y-1, x*result);
    }
}
// output:
// 2^3: 8
// 3^3: 27
// 2^5: 32
