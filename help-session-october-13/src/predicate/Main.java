package predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.Predicate;

public class Main {
    public static void main(String... args) {
        Predicate<Integer> pred = i -> i % 2 != 0;
        List<Integer> li = Arrays.asList(1, 10, 25, 37, 40);
        List<Integer> filteredList = filterList(li, pred);
        filteredList.forEach(i -> System.out.println(i));
    }

    static List<Integer> filterList(List<Integer> list,
                                    Predicate<Integer> pred) {
        List<Integer> filteredList = new ArrayList<>();
        for (var integer : list) {
            if (pred.test(integer)) {
                filteredList.add(integer);
            }
        }
        return filteredList;
    }
}