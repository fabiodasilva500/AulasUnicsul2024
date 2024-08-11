package Exercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class ListaLigada {
	private NO inicio;
	private int tamanho;
	private Livro[] dadosLivro;
	private String resultadoPesquisa;

	public ListaLigada(){
		inicio=null;
	}

	public void AdicionaFinal(Livro livro){
		NO n=new NO(livro);

		if(inicio == null){
			inicio=n;
			n.prox=null;
		}
		else{
			NO aux=BuscaUltimo(inicio);
			aux.prox=n;
		}
	}

	public NO BuscaUltimo(NO aux){
		if(aux.prox!=null){
			return BuscaUltimo(aux.prox);
		}
		return aux;
	}

	public void AdicionaInicio(Livro livro){
		NO n=new NO(livro);
		n.prox=inicio;
		inicio=n;
	}

	public NO AdicionarPosicao(Livro livro, int pos, NO lista, int count) {
		NO novo = new NO(livro);

		if(lista==null){
			lista = inicio;
			count = 1;
		}

		if (pos == 1) {
			AdicionaInicio(livro);
		} else {

			NO aux = lista;

			if (count == pos - 1) {
				novo.prox = aux.prox;
				aux.prox = novo;
				return lista;
			} else if (aux.prox != null && count < pos - 1) {
				aux = aux.prox;
				count++;
				AdicionarPosicao(livro, pos, aux, count);
			}else {
				JOptionPane.showMessageDialog(null, "Posição Inválida!");
			}
		}		
		return lista;
	}



	public Livro RemoveFinal(){
		Livro livro = null;

		if(inicio ==null){
			livro = new Livro();
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}

		else{
			if(inicio.prox==null){
				livro=inicio.livro;
				inicio=null;
			}
			else{
				NO aux=LocalizaDadoParaRemocao(inicio,inicio);
				livro=aux.prox.livro;
				aux.prox=null;
			}
		}
		return livro;
	}

	public NO LocalizaDadoParaRemocao(NO aux1, NO aux2){
		if(aux1.prox!=null){
			return LocalizaDadoParaRemocao(aux1.prox,aux1);
		}
		return aux2;
	}


	public Livro RemoveInicio(){
		Livro livro=null;
		if (inicio==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
			livro = new Livro();
		}
		else{
			livro=inicio.livro;
			inicio=inicio.prox;
		}
		return livro;
	}


	public Livro escolheRemove(int pos){
		Livro e = null;

		if(inicio==null){
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
			e = new Livro();
			return e;
		}    
		if(pos==1){// NOVA CONDIÇÃO. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SERÁ O PRIMEIRO
			e=RemoveInicio();
			return e;
		}else{           
			tamanho = obterTamanho();
			if(pos>tamanho || pos<=0){
				JOptionPane.showMessageDialog(null,"Posição Invalida!");
				e=new Livro();
				return e;
			}else if(pos==tamanho){
				e=RemoveFinal();
				return e;
			}else{				
				NO aux =RemovePosicao(pos, inicio, inicio);
				e=aux.prox.livro;
				aux.prox = aux.prox.prox;

				return e;
			}
		}		
	}


	private NO RemovePosicao(int posInfo, NO aux, NO aux2) {		
		if(posInfo>1){
			return RemovePosicao(posInfo-1, aux.prox,aux);
		}		
		return aux2;
	}


	public int obterTamanho(){
		NO aux=inicio;
		int contador=0;
		while(aux!=null){
			contador = contador+1;
			aux = aux.prox;
		}
		return contador;
	}

	public String percorre(NO aux, String livro, boolean primeiraExecucao){
		if(primeiraExecucao){
			aux = inicio;
			primeiraExecucao=false;
		}

		if(aux!=null){
			livro=livro+"\nTítulo:"+aux.livro.getTitulo()+" Quantidade de exemplares:"+aux.livro.getExemplares();
			return percorre(aux.prox, livro, primeiraExecucao);
		}
		return livro;
	}



	public void bubbleSortIterativo() {
		tamanho = obterTamanho();
		dadosLivro=converteNoVetor();
		for (int i = 0; i < tamanho; i++) {
			for (int j = i + 1; j < tamanho; j++) {
				if (dadosLivro[i].compareTo(dadosLivro[j]) > 0) {
					Livro aux = dadosLivro[i];
					dadosLivro[i] = dadosLivro[j];
					dadosLivro[j] = aux;
				}
			}
		}
	}


	public Livro[] bubbleSortRecursivo(int n, boolean primeiraExecucao) {
		if(primeiraExecucao){
			n = obterTamanho();
			primeiraExecucao = false;
			dadosLivro = converteNoVetor();
		}
		for (int i=0; i<n-1; i++) 
			if (dadosLivro[i].compareTo(dadosLivro[i+1]) > 0) 
			{ 
				// swap arr[i], arr[i+1] 
				Livro temp = dadosLivro[i]; 
				dadosLivro[i] = dadosLivro[i+1]; 
				dadosLivro[i+1] = temp; 
			} 

		if(n>=0){
			return bubbleSortRecursivo(n-1, primeiraExecucao);         	
		}

		return dadosLivro;
	}

	public String exibirListaOrdenada (int contador, String resultado,
			boolean primeiraExecucao){
		if(primeiraExecucao){
			contador=0;
			primeiraExecucao = false;
			tamanho = obterTamanho();
		}
		if(contador<tamanho){	
			resultado = resultado +"\nTítulo:"+dadosLivro[contador].getTitulo()+" Quantidade de exemplares:"+dadosLivro[contador].getExemplares();
			contador=contador+1;
			return exibirListaOrdenada(contador, resultado, primeiraExecucao);
		}
		return resultado;
	}


	public Livro[] converteNoVetor() {
		NO auxl = inicio;
		int cont = 0;
		int tamanho = obterTamanho();
		Livro[] dados=new Livro[tamanho];
		while (auxl != null) {
			dados[cont] = auxl.livro;
			auxl = auxl.prox;
			cont++;
		}

		return dados;
	}


	public String pesquisaSequencial(boolean primeiraExecucao, String titulo, int contador, int n,
			boolean encontrado){

		if(primeiraExecucao){
			contador=0;
			n=obterTamanho();
			primeiraExecucao=false;
			encontrado= false;
			resultadoPesquisa="Livro não encontrado";
		}

		if(dadosLivro!=null){
			if(!titulo.equalsIgnoreCase(dadosLivro[contador].getTitulo())
					&& contador<n-1){
				contador=contador+1;
				pesquisaSequencial(primeiraExecucao, titulo, contador, n, false);
			}
			else
				if(titulo.equalsIgnoreCase(dadosLivro[contador].getTitulo())){
					encontrado=true;
					int posicaoEncontrada=contador+1;
					resultadoPesquisa = "O livro foi encontrado na posição:"+posicaoEncontrada+"\n"
							+ "Segue abaixo os dados localizados:\nTítulo:"+dadosLivro[contador].getTitulo()+""
							+ "\nQuantidade de exemplares:"+dadosLivro[contador].getExemplares();
				}
		}

		return resultadoPesquisa;
	}
}
