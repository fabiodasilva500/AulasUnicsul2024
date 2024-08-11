
public class TabelaDeEspalhamento {
	private int estoque[];

	public TabelaDeEspalhamento(){
		estoque=new int[100];
	}

	public int FuncaoDeEspalhamento(int chave){
		return chave-1;
	}

	public void adiciona(int chave,int q){
		int indice=FuncaoDeEspalhamento(chave);
		if ((indice>=0)&&(indice<estoque.length)){
			estoque[indice]=q;
		}
		else{
			System.out.println("Código inválido. Não foi possível incluir");
		}
	}

	public void remove(int chave){
		int indice=FuncaoDeEspalhamento(chave);
		if ((indice>=0)&&(indice<estoque.length)){
			estoque[indice]=0;
		}
		else{
			System.out.println("Código inválido");
		}
	}

	public String percorre(){
		String aux="Código\tEstoque\n";
		for (int i=0;i<estoque.length;i++){
			aux+=(i+1)+"\t"+estoque[i]+"\n";
		}
		return aux;
	}


	public static void main(String[]args){
		TabelaDeEspalhamento tab=new TabelaDeEspalhamento();
		tab.adiciona(1, 230);
		tab.adiciona(44, 1000);
		tab.adiciona(100, 23);
		tab.adiciona(30, 300);
		tab.adiciona(33, 230);
		tab.remove(33);
		System.out.println(tab.percorre());
	}



}
