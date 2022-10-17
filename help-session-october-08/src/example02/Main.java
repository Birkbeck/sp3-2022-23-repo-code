package example02;

import java.util.Arrays;
import java.util.List;

import java.util.function.Predicate;

public class Main {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(sum(numbers, n -> n % 2 == 0));
        System.out.println(sum(numbers, n -> true));
    }

    public static int sum(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int n : numbers) {
            if (p.test(n)) {
                total += n;
            }
        }
        return total;
    }
}