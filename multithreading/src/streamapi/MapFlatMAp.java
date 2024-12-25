package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFlatMAp {
    public static void main(String[] args) {
        List<String> words= Arrays.asList("Adam","Ana","Daniel");

        List<Integer> lengths=words.stream().map(String::length)
                .collect(Collectors.toList());
        lengths.forEach(System.out::println);

        List<Integer> nums=Arrays.asList(1,2,3,4);
        nums.stream().map(x->x*x)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //flatMAp()
        // hello - get all unique characters
        String[] array={"hello","shell"};
       List<String> unique= Arrays.stream(array)
                .map(w->w.split(""))
               .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
       unique.stream().forEach(System.out::println);
       //Your task is that given two lists of numbers ([1, 2, 3], [4, 5]). Generate all pairs of possible numbers!
        //
        //So the result in the case should be: (1,4), (1,5), (2,4),(2,5),(3,4),(3,5)
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);
       List<List<Integer>> pairs=nums1.stream()
                .flatMap(i->nums2.stream().map(j->Arrays.asList(i,j)))
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(pairs.toArray()));




    }
}
