/*
 3)	A classe Livro possu� atributos que s�o criados na classe concreta e acessados
  	por meio dos m�todos p�blicos da classe (getters e setters). 
  	Dado o cen�rio implemente uma Pilha 
*/

package Exercicio3;

import javax.swing.JOptionPane;

public class TesteDasClasses {
	public static void main(String[]args){
		String titulo;
		int exemplares;
		Pilha dadosPilha = new Pilha(10);
	
		int op=0;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("1-Adicionar\n2-Remover\n3-Exibir\n99-Sair"));
			switch(op){
			case 1:
				titulo=JOptionPane.showInputDialog("Informe o t�tulo do livro");
				exemplares=Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de exemplares"));
				dadosPilha.push(new Livro(titulo, exemplares));
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:\n"+dadosPilha.pop());
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Fila:"+dadosPilha.percorre());
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Pilha:"+dadosPilha.percorre());
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Valor inv�lido, digite novamente");
			}
		}
	}
}





