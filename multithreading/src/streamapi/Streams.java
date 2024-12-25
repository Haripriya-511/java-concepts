package streamapi;
import java.util.*;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        // From a Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> streamFromList = list.stream();
        // From an Array
        String[] array = {"A", "B", "C"};
        Stream<String> streamFromArray = Arrays.stream(array);
        // From Static Methods
        Stream<String> streamOf = Stream.of("A", "B", "C");
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2); // Infinite Stream


    }
}
