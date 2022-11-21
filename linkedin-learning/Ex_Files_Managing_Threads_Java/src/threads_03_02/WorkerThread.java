
package threads_03_02;

/**
 *
 * @author MFisher
 */
public class WorkerThread implements Runnable{
    private final String message;  
    //Constructor to assign a message when creating a new thread
    public WorkerThread(String message){  
        this.message=message;  
    }  
    @Override
    /**
     *
     */
   public void run() {  
        System.out.println(Thread.currentThread().getName()+
                " (Start) message = " + message);  
        //call workToBeDone method to simulate a delay
        workToBeDone();
        System.out.println(Thread.currentThread().getName()+
                " (End)");//prints thread name  
    }  
    private void workToBeDone() {  
        try {  Thread.sleep(2000);  } 
        catch (InterruptedException e) 
        { e.printStackTrace(); }  
    }  
}
