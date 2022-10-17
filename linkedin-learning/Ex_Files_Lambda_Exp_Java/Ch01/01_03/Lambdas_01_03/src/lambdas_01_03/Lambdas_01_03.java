/*
 * Sample program for movie 01_03
 */
package lambdas_01_03;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * @author MFisher
 */
public class Lambdas_01_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("expected value 3, actual value: " +
            intToString.apply(123).length());

        //static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("expected value 4, actual value:  " +
            intToString2.apply(4567).length());

        //lambdas made using a constructor
        Function<String, BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value: 123456789, actual value: " +
            newBigInt.apply("123456789"));

        //example of a lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");

        //these two are the same using the static method concat
        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println(greeting.apply("World"));

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Peggy"));


    }

}
