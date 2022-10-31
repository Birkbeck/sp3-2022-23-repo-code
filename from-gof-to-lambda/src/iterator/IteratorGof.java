package iterator;

import java.util.List;

import static java.util.Arrays.asList;

public final class IteratorGof {
    static final List<Integer> LIST = asList(1, 2, 3, 4, 5, 6);

    public static void main(final String[] args) {

        for (Integer integer : LIST) {
            System.out.println(integer);
        }

        for (Integer i : LIST) {
            System.out.println(i);
        }
    }

    private IteratorGof() {
    }
}
