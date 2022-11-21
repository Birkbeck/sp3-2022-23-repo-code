/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads_02_04;

/**
 *
 * @author Producer
 */
public class Countdown {
    public void printCount() {
      try {
         for(int i = 10; i > 0; i--) {
            System.out.println("  ---   "  + i );
         }
         System.out.println("BlastOff!");
      }catch (Exception e) {
         System.out.println("Thread  interrupted.");
      }
   }
}
