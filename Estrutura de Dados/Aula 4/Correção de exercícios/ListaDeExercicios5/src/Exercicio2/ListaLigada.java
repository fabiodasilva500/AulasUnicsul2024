package Exercicio2;


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

	public void AdicionaFinal(double e){
		NO n=new NO(e);

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

	public void AdicionaInicio(double e){
		NO n=new NO(e);
		n.prox=inicio;
		inicio=n;
	}

	public double RemoveFinal(){
		double r=-1;

		if(inicio ==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}

		else{
			if(inicio.prox==null){
				r=inicio.temperatura;
				inicio=null;
			}
			else{
				NO aux=LocalizaDadoParaRemocao(inicio,inicio);
				r=aux.prox.temperatura;
				aux.prox=null;
			}
		}
		return r;
	}

	public NO LocalizaDadoParaRemocao(NO aux1, NO aux2){
		if(aux1.prox!=null){
			return LocalizaDadoParaRemocao(aux1.prox,aux1);
		}
		return aux2;
	}



	public double RemoveInicio(){
		double r=-1;
		if (inicio==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}
		else{
			r=inicio.temperatura;
			inicio=inicio.prox;
		}
		return r;
	}


	public NO AdicionarPosicao(double e, int pos, NO lista, int count) {
		NO novo = new NO(e);

		if(lista==null){
			lista = inicio;
			count = 1;
		}

		if (pos == 1) {
			AdicionaInicio(e);
		} else {

			NO aux = lista;

			if (count == pos - 1) {
				novo.prox = aux.prox;
				aux.prox = novo;
				return lista;
			} else if (aux.prox != null && count < pos - 1) {
				aux = aux.prox;
				count++;
				AdicionarPosicao(e, pos, aux, count);
			}else {
				JOptionPane.showMessageDialog(null, "Posição Inválida!");
			}
		}		
		return lista;
	}


	public double escolheRemove(int pos){
		double e = -1;

		if(inicio==null){
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
			return e;
		}    
		if(pos==1){// NOVA CONDIÇÃO. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SERÁ O PRIMEIRO
			e=RemoveInicio();
			return e;
		}else{           
			tamanho = obterTamanho(inicio, 0);
			if(pos>tamanho || pos<=0){
				JOptionPane.showMessageDialog(null, "Posição Invalida!");
				return e;
			}else if(pos==tamanho){
				e=RemoveFinal();
				return e;
			}else{				
				NO aux =RemovePosicao(pos, inicio, inicio);
				e=aux.prox.temperatura;
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


	public int obterTamanho(NO aux, int contador){
		if(aux!=null){
			contador = contador+1;
			return obterTamanho(aux.prox, contador);
		}
		return contador;
	}

	public String percorre(NO aux, String r, boolean primeiraExecucao){
		if(primeiraExecucao){
			aux = inicio;
			primeiraExecucao=false;
		}

		if(aux!=null){
			r=r+"\n"+aux.temperatura;
			return	percorre(aux.prox, r, primeiraExecucao);
		}
		return r;
	}
}
