public class Example02 {
    public static void main(String[] args) throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("Example02");
        Runnable runnable = () -> {
            System.out.println("Running thread " + Thread.currentThread().getName());
        };
        Thread t = builder.start(runnable);
        t.join();
        System.out.println("t thread " + t.getName() + " is done");

        Thread t2 = builder.start(runnable);
        t2.join();
        System.out.println("t2 thread " + t2.getName() + " is done");
    }
}
