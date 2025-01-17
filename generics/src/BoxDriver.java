public class BoxDriver {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(42);
        int x = intBox.getData();

        Box<String> strBox = new Box<>("Hello");
        String s = strBox.getData();

//        int y = (Integer) strBox.getData();
//        intBox = strBox;
    }
}
