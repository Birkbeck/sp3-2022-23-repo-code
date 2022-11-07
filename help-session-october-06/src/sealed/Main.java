package sealed;

public class Main {
    public static void main(String... args) {
        // Rectangle r = new Rectangle();
        var s = new Square();
        var c = new Circle();
    }
}

/**
 *
 */
sealed class Shape permits Circle, Square {
}

// class Rectangle extends Shape {
//
// }

final class Circle extends Shape {

}

non-sealed class Square extends Shape {

}