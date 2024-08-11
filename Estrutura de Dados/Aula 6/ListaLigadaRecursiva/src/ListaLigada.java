import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class ListaLigada {
	private NO inicio;

	public ListaLigada(){
		inicio=null;
	}

	public void AdicionaFinal(int e){
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

	public void AdicionaInicio(int e){
		NO n=new NO(e);
		n.prox=inicio;
		inicio=n;
	}
	
	public int RemoveFinal(){
		int r=-1;

		if(inicio ==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}

		else{
			if(inicio.prox==null){
				r=inicio.dado;
				inicio=null;
			}
			else{
				NO aux=LocalizaDadoParaRemocao(inicio,inicio);
				r=aux.prox.dado;
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
	
	
	
	
	public int RemoveInicio(){
		int r=-1;
		if (inicio==null){
			JOptionPane.showMessageDialog(null,"Lista Vázia");
		}
		else{
			r=inicio.dado;
			inicio=inicio.prox;
		}
		return r;
	}

	public String percorre(){
		NO aux=inicio;
		String r=" ";
		while(aux!=null){
			r=r+"\n"+aux.dado;
			aux=aux.prox;
		}
		return r;
	}
}
