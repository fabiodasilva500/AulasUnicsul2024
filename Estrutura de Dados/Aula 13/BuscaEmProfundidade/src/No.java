public class No{
	int id;
	int numVizinhos;
	No[] vizinhos;
	boolean visitado;
	int cor;
	int distancia;
	No(){}
	
	No(int pid){
		id = pid;
	}
}
