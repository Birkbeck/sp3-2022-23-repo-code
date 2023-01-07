import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Point> data = new HashMap<>();
        data.put("a", new Point(1, 3));
        data.put("apple", new Point(7, 7));
        data.put("be", new Point(4, 7));
        data.put("bear", new Point(7, 4));
        data.put("carpet", new Point(2, 19));
        data.put("cat", new Point(1, 3));
        data.put("dog", new Point(2, 18));
        data.put("specialty", new Point(7, 4));
        data.put("student", new Point(1, 3));
        data.put("umbrella", new Point(42, 8));
        //System.out.println(data);
        System.out.println(sumStrings(data));
    }

    public static Map<Point, Integer> sumStrings(Map<String, Point> data) {
        data.forEach((k,v) -> System.out.printf("%s = %s\n", k, v));
        return null;
    }
}

record Point(int x, int y) {
    @Override
    public String toString(){
        return "[x=" + x +",y=" + y + "]";
    }
}