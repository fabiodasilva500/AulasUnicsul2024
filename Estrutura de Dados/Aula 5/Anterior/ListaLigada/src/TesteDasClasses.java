/**
 *
 * @author Fabio
 */
import javax.swing.JOptionPane;
public class TesteDasClasses {
	public static void main(String[]args){
		ListaLigada l=new ListaLigada();
		int op=0,pos=0, dado;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("1-Adiciona Final\n2-Adiciona In�cio\n3-Adiciona Posi��o\n4-Remove Final\n5-Remove In�cio\n6-Remove Posi��o\n7-Exibir\n99-Sair"));
			switch(op){
			case 1:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				l.AdicionaFinal(dado);
				break;
			case 2:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				l.AdicionaInicio(dado);
				break;
			case 3:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o"));
				l.escolhePosicao(dado, pos);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+l.RemoveFinal());
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+l.RemoveInicio());
				break;
			case 6:
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o"));
				JOptionPane.showMessageDialog(null, "O elemento removido foi:"+l.escolheRemove(pos));
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Lista:"+l.percorre());
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Valor inv�lido");
			}
		}

	}
}
