package Sort;

/**
 *
 * @author Rodrigo Pereira
 */

import java.util.Random;



public class Randon {

    public static void main(String[] args) {
        Random nunbers = new Random();
        int v[] = new int[10];
        for (int i = 0; i < 10; i++) {
            v[i] = nunbers.nextInt(10);
            System.out.println(v[i]);
        }        

    }




}
