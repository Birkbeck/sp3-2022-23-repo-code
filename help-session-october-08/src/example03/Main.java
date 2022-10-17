package example03;

import java.util.*; // do not do this - be specific

public class Main {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(
            numbers.stream()
                .filter(Main::isEven)
                .map(Main::doubleIt)
                .filter(Main::isGT5)
                .findFirst().get());
    }

    public static boolean isEven(int n) {
        System.out.println("isEven: " + n);
        return n % 2 == 0;
    }

    public static int doubleIt(int n) {
        System.out.println("doubleIt: " + n);
        return n * 2;
    }

    public static boolean isGT5(int n) {
        System.out.println("isGT5: " + n);
        return n > 5;
    }
}