package example01;

import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;

@FunctionalInterface
interface MyInterface {
    public String myMethod();
    // public String myMethod2(); // not allowed
}

public class Main {
    public static void main(String[] args) {
        List<Integer> intSeq = Arrays.asList(1, 2, 3, 4);
        // intSeq.forEach(System.out::println);
        // intSeq.forEach(x -> {
        // var y = x + 2;
        // System.out.println(y);
        // });
        Consumer<Integer> cnsmr = x -> System.out.println(x);
        intSeq.forEach(cnsmr);
    }
}