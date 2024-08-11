package Diversos;

/**
 *
 * @author Rodrigo Pereira
 */
public class QuickSort {




    public static void main(String[] args) {


         int vetor[] = new int[10];
         vetor[0] = 5;
         vetor[1] = 4;
         vetor[2] = 3;
         vetor[3] = 2;
         vetor[4] = 1;
         vetor[5] = 6;
         vetor[6] = 7;
         vetor[7] = 8;
         vetor[8] = 9;
         vetor[9] = 0;
     quick_sort(vetor, 0, vetor.length-1);

    }






    public static void quick_sort(int []v,int ini, int fim){
                int meio;

                if(ini<fim){
                        meio = partition(v,ini,fim);
                        quick_sort(v,ini,meio);
                        quick_sort(v,meio+1,fim);
                }

                for (int i = 0; i < 10; i++) {
                     System.out.println(v[i]);
        }
        }

        public static int partition(int []v, int ini, int fim){
                int pivo, topo,i;
                pivo = v[ini];
                topo = ini;

                for(i=ini+1;i<fim;i++){
                        if(v[i]<pivo){
                                v[topo]=v[i];
                                v[i]=v[topo+1];
                                topo++;
                        }
                }
                v[topo]=pivo;
                return topo;
        }








}
