import java.util.LinkedList;
public class Grafo {
	static final int INFINITO = Integer.MAX_VALUE/4;
	static int numNos;
	static boolean[][] adjacencias;
	static int[][] matrizDistancia;
	static boolean[] visitados;
	static boolean[] cores;
	static No nos[];
	static int numCores = 5;
	static No[] solucao;
	static int[] tempSolucao;
	static int[] melhorSolucao;
	static int valorMelhorSolucao;
	static int valorSolucaoAtual;
	public Grafo(int n, int m){
		numNos = n;
		adjacencias = new boolean[n][n];
		visitados = new boolean[n];
		nos = new No[n];
		matrizDistancia = new int[n][n];
	}


	private static int buscaEmLargura(No inicio, No fim){
		if (inicio == fim) return 0;
		LinkedList<No> ll = new LinkedList<No>();
		inicio.distancia = 0;
		inicio.visitado = true;
		ll.add(inicio);
		No atual;
		while (!ll.isEmpty()){
			atual = ll.remove();
			for (No temp: atual.vizinhos){
				if (!temp.visitado){
					if (temp == fim) return atual.distancia + 1;
					temp.visitado = true;
					temp.distancia = atual.distancia + 1;
					ll.add(temp);
				}
			}
		}
		return -1;
	}

}