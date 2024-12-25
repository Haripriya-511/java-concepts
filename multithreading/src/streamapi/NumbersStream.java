package streamapi;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumbersStream {
    public static void main(String[] args) {
        int[] nums={1,5,3,-2,9,12};
        //Using streams
        Arrays.stream(nums).forEach(System.out::println);
        //Int Streams
        IntStream.range(1, 5).forEach(System.out::println);    // 1, 2, 3, 4
        IntStream.rangeClosed(1, 5).forEach(System.out::println); // 1, 2, 3, 4, 5
        IntStream randomInts = new Random().ints(5, 1, 100); // 5 random numbers between 1 and 100
        int sum1 = IntStream.rangeClosed(1, 10).sum();       // Sum: 55
        OptionalDouble average = IntStream.rangeClosed(1, 10).average(); // Average: 5.5

        int[] numbers = {3, 6, 8, 10, 45};
        int maxEvenNumber = Arrays.stream(numbers)  // Stream of integers
                .filter(num -> num % 2 == 0)            // Filter even numbers: 6, 8, 10
                .max()                                  // Get the maximum: 10
                .orElseThrow(() -> new RuntimeException("No value found"));

        System.out.println(maxEvenNumber); // Output: 10

        long count = Stream.of(1, 2, 3, 4, 5).count(); // Output: 5

        OptionalInt min = IntStream.of(5, 10, 15).min(); // Output: OptionalInt[5]
        OptionalInt max = IntStream.of(5, 10, 15).max(); // Output: OptionalInt[15]


        IntSummaryStatistics stats = IntStream.of(1, 2, 3, 4, 5).summaryStatistics();
        System.out.println(stats.getSum()); // Output: 15
        System.out.println(stats.getAverage()); // Output: 3.0

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        int sum= numbers1.stream().reduce(0,(a,b)->(a+b));
        System.out.println(sum);
        int sum2=numbers1.stream().reduce(0,Integer::sum);
        System.out.println(sum2);

        int maxi=numbers1.stream().reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println(maxi);









    }
}
