/*
 * ID Class contains the synchronized keyword to prevent
 * multiple threads from accessing the getID() method at the same time
 */
package threads_02_03;

/**
 *
 * @author MFisher
 */
public class ID {
   private static int counter; // initialized to 0 by default

   public static synchronized int getID()
   {
      return counter++;
   }

    
}
