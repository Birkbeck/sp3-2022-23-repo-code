/*
 * This program demonstrates how to lock an object using synchronization
 */
package threads_02_04;

/**
 *
 * @author MFisher
 */
public class CountdownMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Countdown CD = new Countdown();
        Runnable r = () -> {
      //  synchronized(CD) {
         CD.printCount();
      //  }
    };
        Thread one = new Thread(r,"one");
        Thread two = new Thread(r,"two");
        one.start();
        two.start();
    }
}   

