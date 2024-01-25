/*
 * This program explains the syntax of using lambda expressions in Java
 */
package lambdas_01_02;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author MFisher
 */
public class Lambdas_01_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Anonymous Inner Class: Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1");
            }
        };

        // Lambda version of Runnable (no arguments)
        Runnable r2 = () -> System.out.println("run 2");

        // Start both threads
        r1.run();
        r2.run();

        //using an existing functional interface BiFunction         
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        String sentence = concat.apply("Today is ", "a great day");
        System.out.println(sentence);

        //example of the Consumer functional interface
        Consumer<String> hello = name -> System.out.println("Hello, " + name);
        for (String name : Arrays.asList("Duke", "Mickey", "Minnie")) {
            hello.accept(name);
        }

        //example of passing one value 
        GreetingFunction greeting = message ->
                System.out.println("Java Programming " + message);
        greeting.sayMessage("Rocks with lambda expressions");
    }

    //custom functional interface
    @FunctionalInterface
    interface GreetingFunction {
        void sayMessage(String message);
    }
}

