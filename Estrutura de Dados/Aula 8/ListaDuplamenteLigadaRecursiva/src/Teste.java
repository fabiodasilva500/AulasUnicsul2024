
import javax.swing.JOptionPane;
public class Teste {
	public static void main(String[]args){
		ListaDuplamenteEncadeadaRecursiva l=new ListaDuplamenteEncadeadaRecursiva();
		int op=0,dado;

		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("1-Adiciona Início\n2-Adiciona Final\n3-Remove Início\n4-Remove Final\n5-Exibir\n99-Sair"));

			switch(op){
			case 1:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				l.AdicionaInicio(dado);
				break;
			case 2:
				dado=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
				l.AdicionaFinal(dado);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+l.RemoveInicio());
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+l.RemoveFinal());
				break;
			case 5:
				l.percorre();
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Obrigado Caro Usuário, o programa será finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Valor inválido, digite outro");
			}
		}
	}
}
