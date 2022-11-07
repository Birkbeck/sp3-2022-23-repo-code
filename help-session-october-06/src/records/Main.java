package records;

public class Main {
    public static void main(String... args) {
        var r = new Rectangle(10, 20);
        var s = new Rectangle(10, 20);
        System.out.println(r.getLength());
        System.out.println(s.getWidth());
        System.out.println(r);
        System.out.println(s.equals(r));

        var r1 = new Rect(10, 20);
        var r2 = new Rect(10, 20);
        System.out.println(r1.length());
        System.out.println(r2.width());
        System.out.println(r1);
        System.out.println(r1.equals(r2));
    }
}

class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // toString, equals, hashCode, ...
}

/**
 * @param length the length of the rectangle
 * @param width  the width of the rectangle
 */
record Rect(double length, double width) {
    @Override
    public String toString() {
        return "Nothing";
    }
}