/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_03_03;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author MFihser
 */
public class Threads_03_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(4);
        // create and start threads
        for (int i = 0; i < 5; ++i) 
            new Thread(new Worker(start,end)).start();

        try{
         System.out.println("main thread doing something");
         Thread.sleep(1000); // sleep for 1 second
         start.countDown(); // let all threads proceed
         System.out.println("main thread doing something else");
         end.await(); // wait for all threads to finish
         
      }
      catch (InterruptedException ie)
      {
         System.err.println(ie);
      }
    }
    
}
