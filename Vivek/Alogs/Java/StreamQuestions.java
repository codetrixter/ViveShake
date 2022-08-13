import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamQuestions {
    public static void main(String[] args) {
    
        List<Integer> myLsit = Arrays.asList(10, 11, 12, 12, 14, 14, 15, 16, 17, 18, 20, 21, 23);

        System.out.println("Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?");
        List<Integer> result = myLsit.stream()
        .filter(i -> i%2==0)
        .collect(Collectors.toList());
        for(int e : result){
            System.out.print(e + ", ");
        }
        System.out.println();

        System.out.println("Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
        List<Integer> startingWith1 = myLsit.stream()
        .filter(i -> String.valueOf(i).charAt(0) == '1')
        .collect(Collectors.toList());
        for(int e : startingWith1) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("Q3 How to find duplicate elements in a given integers list in java using Stream functions?");
        HashSet<Integer> set = new HashSet<>();
        List<Integer> duplicates = myLsit.stream()
        .filter(i -> !set.add(i)).collect(Collectors.toList());

        for(int e : duplicates) {
            System.out.print(e+" ");
        }
        System.out.println();

        System.out.println("Q4 Given the list of integers, find the first element of the list using Stream functions?");
        int num = myLsit.stream().findFirst().get();
        System.out.println(num);

        System.out.println("Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?");
        long count = myLsit.stream().count();
        System.out.println(count);

        System.out.println("Q6 Given a list of integers, find the maximum value element present in it using Stream functions?");
        int max = myLsit.stream().max(Integer::compare).get();
        System.out.println(max);

        System.out.println("Q7 Given a String, find the first non-repeated character in it using Stream functions?");
        String input = "Java Hungry Blog Alive is Awesome";
        Character res = input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object
                                                                                   // and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))// Store
                                                                                                               // the
                                                                                                               // chars
                                                                                                               // in map
                                                                                                               // with
                                                                                                               // count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(res);
    }
}
