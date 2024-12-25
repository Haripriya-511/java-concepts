package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StingStreams {
    public static void main(String[] args) {
        String[] names={"Ad","Dni","Martha","Kevin","Ben","Joe","Brad","Susan"};
        Stream.of(names).sorted().forEach(System.out::println);
        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        Stream.of(names).filter(x->x.startsWith("B")).forEach(System.out::println);

        String input = "hello";

// Using chars() to process as IntStream
        input.chars()
                .mapToObj(c -> (char) c) // Convert int to char
                .forEach(System.out::println); // Output: h, e, l, l, o
        String sentence = "Java streams are powerful!";
       Arrays.stream(sentence.split(" "))
               .map(String::toUpperCase)
               .collect(Collectors.toList())
        .forEach(System.out::println);

        List<String> words = Arrays.asList("Java", "streams", "are", "powerful");
        String joined = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined); // Output: Java, streams, are, powerful

        //finding unique characters
        String input1 = "Java streams are powerful";
        List<Character> list=input1.chars()
                .mapToObj(c->(char)c)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

        List<String> words1 = Arrays.asList("Java", "streams", "are", "powerful");
        words1.parallelStream()
                .forEach(word -> System.out.println(Thread.currentThread().getName() + ": " + word));





    }
}
