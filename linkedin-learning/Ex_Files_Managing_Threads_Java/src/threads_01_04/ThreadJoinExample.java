/* This program demonstrates the use of some advanced thread
 * methods, specifically sleep and join.  This is the main
 * method which creates three threads. Then it tries to join
 * thread2 causing the system to wait until it is done, then
 * thread3 can start.
 */
package threads_01_04;

/**
 * @author MFisher
 */
public class ThreadJoinExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestJoinClass t1 = new TestJoinClass("t1");
        TestJoinClass t2 = new TestJoinClass("t2");
        TestJoinClass t3 = new TestJoinClass("t3");
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        t2.start();
        t3.start();
        System.out.println("Main thread is done!");
    }

}
