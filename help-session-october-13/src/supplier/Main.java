package supplier;

import java.util.function.Supplier;

public class Main {
    public static void main(String... args) {
        Supplier<String> strSupplier = () -> "Hello World!";
        var s = strSupplier.get();
        System.out.println(s);

        Supplier<String> emptySupplier = String::new; // new String()
        s = emptySupplier.get();
        System.out.println("[" + s + "]");
        System.out.println("[" + emptySupplier.get() + "]");
    }
}