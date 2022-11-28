package concurrency;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        // Creating child tasks
        var childTask1 = new ChildTask();
        var childTask2 = new ChildTask();

        // Start Child Threads
        new Thread(childTask1).start();
        new Thread(childTask2).start();

        System.out.println(Thread.currentThread().getName() + " executed by main thread");
    }
}

class ChildTask implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executed by child thread");
    }
}
