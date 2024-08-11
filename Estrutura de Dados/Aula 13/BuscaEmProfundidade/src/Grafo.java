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

	private static int buscaEmProfundidade(No atual, No fim, int visitados){
		atual.visitado = true;
		if (atual == fim) return visitados;
		for (No temp: atual.vizinhos){
			if (!temp.visitado){
				int res = buscaEmProfundidade(temp, fim, visitados+1);
				if (res > 0) return res;
			}
		}
		return -1;
	}
}