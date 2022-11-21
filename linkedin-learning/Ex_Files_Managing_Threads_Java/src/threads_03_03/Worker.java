
package threads_03_03;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author MFisher
 */
public class Worker extends Thread {
   private final CountDownLatch start;
   private final CountDownLatch end;
   Worker(CountDownLatch start, CountDownLatch end) {
     this.start = start;
     this.end = end;
   }
   public void run() {
          try
            {
              printInfo("thread entered run()");
              start.await();  // wait before proceeding
              printInfo("doing work"); 
              Thread.sleep(3000);
              end.countDown(); // reduce count 
            }
              catch (InterruptedException ie)
              {
                  System.err.println(ie);
              }
           }

        void printInfo(String s)
         {
         System.out.println(System.currentTimeMillis() +
               ": " + Thread.currentThread() +
                     ": " + s);
           }
   }


