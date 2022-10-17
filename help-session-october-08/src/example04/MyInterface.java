package example04;

import java.util.function.Predicate;

@FunctionalInterface
interface MyInterface {
    // could use a lambda here by assigning to a static field or something similar
    Predicate<String> predStr = (x) -> true;

    // void myOtherMethod(); can't add this if we want to retain the
    // "FunctionalInterface"
    static void myStaticMethod() {
    }

    void myMethod(); // SAM - Single Abstract Method

    default void myDefaultMethod() {
        helper();
    }

    private void helper() {
    }
}