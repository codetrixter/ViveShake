import java.util.Arrays;
import java.util.List;

public class StreamProblems {
    public static void main(String[] args) {
        /*
         * Q9 Given a list of integers, sort all the values present in it using Stream
         * functions?
         */

        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        list.stream()
                .sorted()
                .forEach(System.out::println);

        /*
         * Q10 Given a list of integers, sort all the values present in it in descending
         * order using Stream functions?
         */

        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        myList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
