public class UglyNum1 {
    public static void main(String[] args) {
        // first 15 ugly no.s
        for (int i = 1; i <= 15; i++)
            System.out.print(getNthUglyNum(i) + " ");

        System.out.println(getNthUglyNum(150));
    }

    private static int getNthUglyNum(int n) {
        int i = 1;
        int count = 1;

        while (n > count) {
            i++;
            if (isUglyNum(i)) {
                count++;
            }
        }
        return i;
    }

    private static boolean isUglyNum(int num) {
        num = maxDivide(num, 2);
        num = maxDivide(num, 3);
        num = maxDivide(num, 5);
        return num == 1;
    }

    private static int maxDivide(int num, int digit) {
        while (num % digit == 0)
            num = num / digit;
        return num;
    }
}
