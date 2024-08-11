package Exercicio3;

import javax.swing.JOptionPane;

public class Pilha {
	private Livro dados[];
	private int topo;


	public Pilha(int n){
		dados=new Livro[n];
		topo=0;
	}

	public void push(Livro l){
		if (topo<dados.length){
			dados[topo]=l;
			topo++;
		}
		else{
			JOptionPane.showMessageDialog(null, "Pilha Cheia");
		}
	}

	public Livro pop(){
		Livro l=null;
		if (topo>0){
			l=dados[topo-1];
			topo--;
		}
		else{
			JOptionPane.showMessageDialog(null, "Pilha V�zia");
		}
		return (l);
	}


	public String percorre(){
		String aux=" ";
		for (int i=0;i<topo;i++){
			aux=aux+"\n"+dados[i].toString();
		}
		return aux;
	}

}