package Exercicio3;


import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class ListaLigada {
	private NO inicio;
	private int tamanho;

	public ListaLigada(){
		inicio=null;
	}

	public void AdicionaFinal(Aluno aluno){
		NO n=new NO(aluno);

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

	public void AdicionaInicio(Aluno aluno){
		NO n=new NO(aluno);
		n.prox=inicio;
		inicio=n;
	}

	public Aluno RemoveFinal(){
		Aluno aluno = null;

		if(inicio ==null){
			aluno = new Aluno();
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}

		else{
			if(inicio.prox==null){
				aluno=inicio.aluno;
				inicio=null;
			}
			else{
				NO aux=LocalizaDadoParaRemocao(inicio,inicio);
				aluno=aux.prox.aluno;
				aux.prox=null;
			}
		}
		return aluno;
	}

	public NO LocalizaDadoParaRemocao(NO aux1, NO aux2){
		if(aux1.prox!=null){
			return LocalizaDadoParaRemocao(aux1.prox,aux1);
		}
		return aux2;
	}



	public Aluno RemoveInicio(){
		Aluno aluno=null;
		if (inicio==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
			aluno = new Aluno();
		}
		else{
			aluno=inicio.aluno;
			inicio=inicio.prox;
		}
		return aluno;
	}


	public NO AdicionarPosicao(Aluno aluno, int pos, NO lista, int count) {
		NO novo = new NO(aluno);

		if(lista==null){
			lista = inicio;
			count = 1;
		}

		if (pos == 1) {
			AdicionaInicio(aluno);
		} else {

			NO aux = lista;

			if (count == pos - 1) {
				novo.prox = aux.prox;
				aux.prox = novo;
				return lista;
			} else if (aux.prox != null && count < pos - 1) {
				aux = aux.prox;
				count++;
				AdicionarPosicao(aluno, pos, aux, count);
			}else {
				JOptionPane.showMessageDialog(null, "Posição Inválida!");
			}
		}		
		return lista;
	}


	public Aluno escolheRemove(int pos){
		int count = 1;
		Aluno e = null;

		if(inicio==null){
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
			e = new Aluno();
			return e;
		}    
		if(pos==1){// NOVA CONDIÇÃO. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SERÁ O PRIMEIRO
			e=RemoveInicio();
			return e;
		}else{           
			tamanho = obterTamanho();
			if(pos>tamanho || pos<=0){
				JOptionPane.showMessageDialog(null,"Posição Invalida!");
				e=new Aluno();
				return e;
			}else if(pos==tamanho){
				e=RemoveFinal();
				return e;
			}else{				
				NO aux =RemovePosicao(pos, inicio, inicio);
				e=aux.prox.aluno;
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

	public String percorre(NO aux, String aluno, boolean primeiraExecucao){
		if(primeiraExecucao){
			aux = inicio;
			primeiraExecucao=false;
		}


		if(aux!=null){
			aluno=aluno+"\nRA:"+aux.aluno.getRA()+" Nome:"+aux.aluno.getNome()+
					" Semestre:"+aux.aluno.getSemestre()+" Turma:"+aux.aluno.getTurma();
			return percorre(aux.prox, aluno, primeiraExecucao);
		}
		return aluno;
	}
}
