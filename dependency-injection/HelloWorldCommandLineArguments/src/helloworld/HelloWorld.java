package helloworld;

public class HelloWorld {

    public static void main(String... args) {
        if (args.length > 0) {
            System.out.println(String.join(" ", args));
        } else {
            System.out.println("Hello World!");
        }
    }
}