
package threads_03_02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author MFisher
 */
public class Threads_03_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating a pool of 5 threads  
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {  
            Runnable worker = new WorkerThread("I'm thread " + i);  
            //calling execute method of ExecutorService
            executor.execute(worker);  
          }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
  
        System.out.println("Finished all threads");  
    }
    
}
