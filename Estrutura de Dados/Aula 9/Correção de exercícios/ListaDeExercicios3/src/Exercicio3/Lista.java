package Exercicio3;

public class Lista {

	private int lista [];

	private int tamanho;

	public Lista(){
		lista = new int [10];
		tamanho = 0;
	}

	public boolean VerifVazia(){
		if (tamanho==0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean VerifCheia(){
		if (tamanho==lista.length){
			return true;
		}

		else{
			return false;
		}
	}

	public void Adicionar(int x){
		if(!VerifCheia()){
			lista[tamanho] = x;
			tamanho++;
		}
		else{
			System.out.println("A fila está cheia!");
		}
	}

		public String percorre(){                    
			String aux=" ";

			for (int i=0;i<tamanho;i++){
				aux=aux+"\n"+lista[i];
			}
			return aux;
		}
	

	public int retornar() {
		return lista[0];
	}

	public void Remover(){
		if(!VerifVazia()){
			System.out.println("Removendo o valor e adicionando ao topo da pilha= " + lista[0]);

			for(int i=0; i<=tamanho-2; i++){
				lista[i] = lista[i+1];
			}
			tamanho--;
		}

		else{
			System.out.println("Alista está vazia!");
		}
	}
}