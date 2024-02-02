package Fri0202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Examples {
    // Producer extends
    // if you need a list to produce T values (you want to read Ts from the list),
    // you need to declare it with ? extends T, e.g., List<? extends Integer> and this is immutable.
    //
    // Consumer super
    // if you need a list to consume T values (you want to write Ts into the list),
    // you need to declare it with ? super T, e.g., List<? super Integer> and this is mutable.
    //
    // The PECS mnemonic stands for Producer-extends, Consumer-super.
    // BUT there is no guarantee what type of object you may read from this list.
    // The only guarantee is that you may add an object of type T to this list.

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T t : src) {
            System.out.println(t);
            dest.add(t);
        }
        System.out.println(dest);
        System.out.println(src);
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Number> result = new ArrayList<>();
        copy(intList, result);
    }
}
