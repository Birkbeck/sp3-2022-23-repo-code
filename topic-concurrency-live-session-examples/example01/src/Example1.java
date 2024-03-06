public class Example1 {
    public static void main(String[] args) {
        Thread t = Thread.ofVirtual().start(() -> {
            System.out.println("Hello, World!");
        });
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
