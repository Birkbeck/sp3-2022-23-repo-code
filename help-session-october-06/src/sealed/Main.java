public class Main {
    public static void main(String... args) {
        // Rectangle r = new Rectangle();
        Square s = new Square();
        Circle c = new Circle();
    }
}

sealed class Shape permits Circle, Square {
}

// class Rectangle extends Shape {

// }

final class Circle extends Shape {

}

non-sealed class Square extends Shape {

}