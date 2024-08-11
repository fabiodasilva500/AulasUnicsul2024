import java.util.*;
public class MergeSort{
	/**
	M�todo de ordena��o por MergeSort
	@param origem array a ordenar
	 */
	public static void mergeSort(int origem[]){
		int n=origem.length;
		//array tempor�rio
		int lista1[]=new int[n];//subdivis�o do origem
		int lista2[]=new int[n];//subdivis�o do origem
		int temp[];//usado para trocas
		int i,j;

		//copia a entrada
		System.arraycopy(origem,0,lista1,0,lista1.length);

		//ordena executando tamanho-2*i vezes
		for (i=1;i<n;i*=2){
			//juntar 2 pares de tamanho i
			for (j=0;j<n;j+=2*i){
				merge(lista1,lista2,j,i);
			}
			temp = lista1; lista1 = lista2; lista2 = temp;
		}		

		//copiar arranjo ordenado para origem	
		System.arraycopy(lista1, 0, origem, 0, lista1.length);
	}

	/**
	Junta dois arrays para o merge sem recurs�o
	@param lista1 primeira divis�o
	@param lista2 segunda divis�o
	@param inicial lista final
	 */
	protected static void merge(int lista1[], int lista2[], int inicio, int inc){
		int x=inicio;
		int fim1=Math.min(inicio+inc, lista1.length);
		int fim2=Math.min(inicio+2*inc, lista1.length);
		int y=inicio+inc;
		int z=inicio;
		while((x<fim1)&&(y<fim2)){
			if(lista1[x]<lista1[y]){
				lista2[z++]=lista1[x++];
			} else {
				lista2[z++]=lista1[y++];
			}
		}

		if (x<fim1){
			System.arraycopy(lista1, x, lista2, z, fim1-x);
		}else {
			System.arraycopy(lista1, y, lista2, z, fim2-y);
		}

	}	

	/**Merge Sort Recursivo
@param origem array a ordenar
	 */
	public static void mergeSortRecursivo(int lista[], int inicio,
			int fim){

		if (inicio < fim){
			int meio = (inicio + fim) / 2;
			mergeSortRecursivo(lista,inicio, meio);
			mergeSortRecursivo(lista,meio + 1, fim);
			mesclar(lista,inicio, meio, meio+1,fim); 
		}
	}	

	/**
	Junta dois arrays
	@param lista1 lista
	@param inicioA In�cio da 1a. subdivis�o
	@param fimA Final da 1a. subdivis�o
	@param inicioB In�cio da 2a. subdivis�o
	@param fimB Final da 2a. subdivis�o
	 */ 
	public static void mesclar(int lista[], int inicioA, int fimA,
			int inicioB, int fimB){
		int i1 = inicioA; 
		int i2 = inicioB;
		int iaux = inicioA;
		int aux[] = new int[lista.length];
		while (i1 <= fimA && i2 <= fimB){
			if(lista[i1] <= lista[i2])
				aux[iaux++]=lista[i1++];
			else
				aux[iaux++]=lista[i2++];
		}	
		while (i1 <=fimA)
			aux[iaux++]=lista[i1++];
		while (i2 <=fimB)
			aux[iaux++]=lista[i2++];
		for (int i=inicioA;i<=fimB;i++)
			lista[i] = aux[i];
	}


	public static void main(String args[]){
		Random r = new Random();
		int lista[]=new int[4];
		int lista2[]=new int[4];
		int lista3[]=new int[4];

		int i;

		//MergeSort
		System.out.println("Teste Merge\nLista Inicial");
		for(i=0;i<lista.length;i++){
			lista[i]=r.nextInt(101);
			lista2[i]=lista[i];
			lista3[i]=lista[i];
			System.out.print(lista[i]+"  ");
		}
		mergeSort(lista);


		System.out.println("\nAlgoritmo N�o Recursivo\nLista Ordenada");
		for(i=0;i<lista.length;i++){
			System.out.print(lista[i]+"  ");
		}

		//MergeSort Recursivo
		System.out.println("\nAlgoritmo MergeSort Recursivo\nLista Ordenada");
		//mergeSortRecursivo(lista2,0,(lista2.length)-1);
		mergeSortRecursivo(lista2,0,(lista2.length)-1);
		for(i=0;i<lista2.length;i++){
			System.out.print(lista2[i]+"  ");
		}


	}


}