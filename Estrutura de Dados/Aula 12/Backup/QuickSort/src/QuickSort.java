import java.util.*;
public class QuickSort{


	/**
	Método Quicksort Recursivo
	 */
	public static void quickSort (int vet[], int ini, int fim)
	{
		int divisao; 
		if (ini < fim) { 
			divisao = particao(vet, ini, fim); 
			quickSort (vet, ini, divisao-1); 
			quickSort (vet, divisao+1, fim); 
		}
	}

	public static int particao (int vet[], int ini, int fim)
	{
		int pivo = vet[ini],i = ini+1, f = fim, aux; 
		while (i<=f) { 
			while (i <= fim && vet[i] <= pivo) 
				++i; 
			while (pivo < vet[f]) 
				--f; 
			if (i < f){ 
				aux = vet[i];
				vet[i] = vet[f];
				vet[f] = aux; 
				++i; 
				--f;
			}	 
		} 
		if (ini != f){
			vet[ini] = vet[f];
			vet[f] = pivo;
		} 
		return f; 
	}


	/**
		Principal
	 */

	public static void main(String args[]){
		Random r = new Random();
		int lista[]=new int[4];
		int lista2[]=new int[4];
		int lista3[]=new int[4];

		int i;

		System.out.println("Teste Quick\nLista Inicial");
		for(i=0;i<lista.length;i++){
			lista[i]=r.nextInt(101);
			lista2[i]=lista[i];
			lista3[i]=lista[i];
			System.out.print(lista[i]+"  ");
		}

		//QuickSort Recursivo
		System.out.println("\nQuickSort\nAlgoritmo Recursivo\nLista Ordenada");
		quickSort(lista3,0,(lista2.length)-1);
		for(i=0;i<lista3.length;i++){
			System.out.print(lista3[i]+"  ");
		}
	}
}