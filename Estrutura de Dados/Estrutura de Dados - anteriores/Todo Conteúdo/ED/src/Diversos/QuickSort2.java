package Diversos;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Pereira
 */
public class QuickSort2 {


    public static void main(String[] args) {
       int v[] = new int[5];
       int i;
        for (i = 0; i < v.length; i++) {
            v[i]= Integer.parseInt(JOptionPane.showInputDialog("Digite o " + String.valueOf(i+1)));
        }
       partation(v, 0, v.length-1);
    }

    public static void partation(int v[], int inicio, int fim){

        int pivo = v.length / 2;
        int aux = 0;
        while(inicio<fim){
            if(v[inicio]>pivo)
            {
                aux = v[fim];
                v[fim]= v[inicio];
                v[inicio] = aux;
                inicio++;
                fim--;
            }
        }
     
   for(int i=0;i<v.length; i++){
            System.out.println(v[i]);
            
        }


    }
 

}
