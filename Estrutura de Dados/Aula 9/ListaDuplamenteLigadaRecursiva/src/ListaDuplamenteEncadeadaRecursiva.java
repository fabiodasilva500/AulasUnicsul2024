
import javax.swing.JOptionPane;
public class ListaDuplamenteEncadeadaRecursiva {

	private NO inicio;

	public ListaDuplamenteEncadeadaRecursiva(){
		inicio=null;
	}

	public boolean Vazia(){
		return inicio==null;
	}

	public void AdicionaInicio(int e){
		NO n=new NO(e);

		if(Vazia()==false){
			n.prox=inicio;
			inicio.anterior=n;
		}
		inicio=n;
	}

	public void AdicionaFinal(int e){
		NO n=new NO(e);

		if(Vazia()==true){
			inicio=n;
			n.prox=null;
			n.anterior=null;
		}
		else{
			NO aux=BuscaUltimo(inicio);
			aux.prox=n;
			n.anterior=aux;
			n.prox=null;
		}
	}

	public NO BuscaUltimo(NO aux){
		if(aux.prox!=null){
			return BuscaUltimo(aux.prox);
		}
		return aux;
	}

	public int RemoveInicio(){
		int r=-1;

		if(Vazia()==true){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}
		else{
			r=inicio.dado;
			inicio=inicio.prox;

			if(inicio!=null){
				inicio.anterior=null;
			}
		}
		return r;
	}

	public int RemoveFinal(){
		int r=-1;

		if(Vazia()==true){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}

		else{
			if(inicio.prox==null){
				r=inicio.dado;
				inicio=null;
			}
			else{
				NO aux2=LocalizaDadoParaRemocao(inicio,inicio);
				r=aux2.prox.dado;
				aux2.prox=null;
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


	public void percorre(){
		NO aux=inicio;
		String r=" ";
		JOptionPane.showMessageDialog(null,"Lista:"+ConcatenaValores(aux,r));
	}

	public String ConcatenaValores(NO aux, String r){
		if(aux!=null){
			r=r+"\n"+aux.dado;
			return ConcatenaValores(aux.prox,r);
		}
		return r;
	}
}
