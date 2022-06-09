import java.util.TreeSet;

public class UglyNo3TreeSet {
    public static void main(String[] args) {
        int n = 150;
        System.out.println(getNthUglyNum(n));
    }

    private static long getNthUglyNum(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1l);

        int i = 1;
        while(i < n) {
            long temp = set.pollFirst();

            set.add(temp*2);
            set.add(temp*3);
            set.add(temp*5);
            i++;
        }

        return set.pollFirst();
    }
}
