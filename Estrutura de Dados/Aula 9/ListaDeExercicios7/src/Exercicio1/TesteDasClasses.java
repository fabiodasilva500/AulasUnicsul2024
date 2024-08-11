package Exercicio1;
/**
 *
 * @author Fabio
 */
import javax.swing.JOptionPane;
public class TesteDasClasses {
	public static void main(String[]args){
		ListaLigada l=new ListaLigada();
		int op=0,pos=0; 
		double dado = 0;
		Livro livro;

		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Lista de Livros\n1-Adiciona Final\n2-Adiciona Início\n3-Adiciona "
					+ "\n4-Remove Final\n5-Remove Início\n6-Remove Posição\n7-Exibir\n8-Ordenar\n9-Exibir Lista Ordenada\n10-Pesquisar na Lista Ordenada\n99-Sair"));
			switch(op){
			case 1:
				livro = new Livro();
				livro.setTitulo(JOptionPane.showInputDialog("Informe o título do livro"));
				livro.setExemplares(Integer.parseInt(JOptionPane.showInputDialog("Informe o número de exemplares")));				
				l.AdicionaFinal(livro);
				break;
			case 2:
				livro = new Livro();
				livro.setTitulo(JOptionPane.showInputDialog("Informe o título do livro"));
				livro.setExemplares(Integer.parseInt(JOptionPane.showInputDialog("Informe o número de exemplares")));
				l.AdicionaInicio(livro);
				break;
			case 3:
				livro = new Livro();
				livro.setTitulo(JOptionPane.showInputDialog("Informe o título do livro"));
				livro.setExemplares(Integer.parseInt(JOptionPane.showInputDialog("Informe o número de exemplares")));
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição"));
				l.AdicionarPosicao(livro, pos, null, 0);
				break;
			case 4:
				livro = new Livro();
				livro = l.RemoveFinal();
				JOptionPane.showMessageDialog(null,"O livro removido foi:\nTítulo:"+livro.getTitulo()+
						"\nQuantidade de exemplares:"+livro.getExemplares()); 
				break;
			case 5:
				livro= new Livro();
				livro = l.RemoveInicio();
				JOptionPane.showMessageDialog(null,"O livro removido foi:\nTítulo:"+livro.getTitulo()+
						"\nQuantidade de exemplares:"+livro.getExemplares()); 
				break;
			case 6:
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição"));
				livro = new Livro();
				livro = l.escolheRemove(pos);
				JOptionPane.showMessageDialog(null,"O livro removido foi:\nTítulo:"+livro.getTitulo()+
						"\nQuantidade de exemplares:"+livro.getExemplares()); 
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Lista:"+l.percorre(null, "", true));
				break;
			case 8:
				l.bubbleSortRecursivo(0, true);
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Lista ordenada:"+l.exibirListaOrdenada(0, "", true));
				break;
			case 10:
				String titulo = JOptionPane.showInputDialog("Informe o título do livro que deseja pesquisar");
				JOptionPane.showMessageDialog(null, l.pesquisaSequencial(true, titulo, 0, 0, false));
				break; 
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Valor inválido");
			}
		}
	}
}
