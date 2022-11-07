package inherit;

sealed interface Academic {
}

non-sealed interface Professor extends Academic {
} // single inheritance

sealed interface Student {
}

non-sealed interface ResearchStudent extends Student {
}

non-sealed interface TeachingAssistant extends Academic, ResearchStudent {
} // multiple inheritance

public final class Main {
    public static void main(String... args) {
        TeachingAssistant t = new TAImpl();
        // if I want to use an alternative implementation then
        // I need to edit the source code!!!!
        t = new TAAltImpl();
        System.out.println(t);
    }
}

class TAImpl implements TeachingAssistant {

}

class TAAltImpl implements TeachingAssistant {

}