/*
 * This is a sample main program to show how to use the 
 * synchronized keyword to prevent multiple threads from 
 * corrupting our data
 */
package threads_02_03;

/**
 *
 * @author MFisher
 */
public class Threads_02_03 {

  //define a class variable called counter
     static int counter = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
/* Example of locking using a synchronized method */
    
        //use lambda notation for the runnable method 
//        Runnable r = () -> {
//            System.out.println("ID value: "+getID());
//        };
//        Thread one = new Thread(r,"one");
//        one.start();
//        
//        Thread two = new Thread(r,"two");
//        two.start(); 
//    }

/*  Example of locking using an object */
    //use lambda notation for the runnable method 

        Runnable r2 = () -> {
            ID id = new ID();
            System.out.println("ID value: "+id.getID());
        };
        Thread one = new Thread(r2,"one");   
        one.start();
        Thread two = new Thread(r2,"two");
        two.start();     
    }

    public static synchronized int getID()
    {
        return counter++;
    }
    
}

