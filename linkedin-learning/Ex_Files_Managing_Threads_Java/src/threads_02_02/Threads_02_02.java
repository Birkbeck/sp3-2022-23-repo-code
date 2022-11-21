/*
 * This program is used to demonstrate using synchronization with threads
 */
package threads_02_02;
   
/**
 *
 * @author MFisher
 */
public class Threads_02_02 {
    //define a class variable called counter
     static int counter = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //use lambda notation for the runnable method 
        Runnable r = () -> {
            System.out.println("ID value: "+getID());
        };
        Thread one = new Thread(r,"one");
        one.start();
        Thread two = new Thread(r,"two");
        two.start(); 
    }
    public static int getID()
    {
        return counter++;
    }  
}
