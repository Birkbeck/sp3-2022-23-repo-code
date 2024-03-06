import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        Future<?> future = executorService.submit(() -> {
            System.out.println("Running thread " + Thread.currentThread().getName());
        });
        future.get();
        System.out.println("thread " + Thread.currentThread().getName() + " is done");
        executorService.shutdown();
    }
}
