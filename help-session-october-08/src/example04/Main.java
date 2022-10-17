package example04;

public class Main {
    public static void main(String... args) {
        MyInterface my = new MyClass();
        my.myMethod();

        my = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("In " + this.getClass().getName());
            }
        };

        my.myMethod();

        my = () -> {
            System.out.println("In lambda expression");
        };

        my.myMethod();

        my = System.out::println;
        my.myMethod();
        // print a blank line
    }
}
